package com.x.ic.msg.service.atom.impl;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import com.x.hbase.base.IHbaseClientFactory;
import com.x.hbase.base.model.FamilyVO;
import com.x.hbase.base.model.PutVO;
import com.x.hbase.base.model.QualifierVO;
import com.x.ic.msg.constants.SmcConstants;
import com.x.ic.msg.dao.mapper.bo.StlPolicyTaskCycle;
import com.x.ic.msg.dao.mapper.bo.StlPolicyTaskCycleExample;
import com.x.ic.msg.dao.mapper.interfaces.StlPolicyTaskCycleMapper;
import com.x.ic.msg.exception.NodeTransferException;
import com.x.ic.msg.exception.NodeValidateException;
import com.x.ic.msg.service.atom.interfaces.INodeTransferSV;
import com.x.ic.msg.vo.MessageData;
import com.x.ic.smc.sdk.cache.util.SmcCacheUtil;
import com.x.ic.smc.sdk.cache.vo.Element;
import com.x.ic.smc.sdk.cache.vo.Node;
import com.x.ic.smc.sdk.cache.vo.NodeElementMapping;
import com.x.ic.smc.sdk.cache.vo.Policy;
import com.x.ic.smc.sdk.cache.vo.PolicyInstn;
import com.x.ic.smc.sdk.cache.vo.PolicyItemPlanInstn;
import com.x.ic.smc.sdk.mds.vo.Header;
import com.x.ic.smc.sdk.mds.vo.SmcBusinessMessage;
import com.x.sdk.mds.vo.BusinessMessage;
import com.x.sdk.util.StringUtil;

import net.minidev.json.JSONArray;

@Service
public class NodeTransferSVImpl implements INodeTransferSV {
	
	private static final Logger log = LogManager.getLogger(MessageCondSVImpl.class);

	@Autowired
	private StlPolicyTaskCycleMapper cycleMapper;
	
	@Override
	public void trans(MessageData messageData) {
		
		String tenantId = messageData.getTenantId();
		
		List<Node> nodes = SmcCacheUtil.getNodeByContractId(tenantId, messageData.getTopicName());
		
		List<Policy> policys = messageData.getPolicys();
		if(policys==null || policys.size() == 0){
			return;
		}
		DocumentContext context =  JsonPath.parse(messageData.getDataStr());
		
		Map<Long,String> nNode = new HashMap<>();
		List<Map<Long,String>> arrChildList = new ArrayList<>();
		for(Node node:nodes){
			if(node.getNodeType().equals(SmcConstants.StlNode.NodeType.JAONARRAY)){
				JSONArray arr = context.read(node.getNodePath());
				for(int i=0;i<arr.size();i++){
					Map<Long, String> tmpPath = new HashMap<>();
					for(Node n : nodes){
						if(node.getNodeId() .equals(n.getParentNodeId()) ){
							tmpPath.put(n.getNodeId(), node.getNodePath()+"["+i+"]"+n.getNodeCode());
						}
					}
					arrChildList.add(i,tmpPath);
				}
			}else if(node.getNodeType().equals(SmcConstants.StlNode.NodeType.JSON)){
				
			}else{
				boolean parentIsArrayFlag = false;
				for(Node n : nodes){
					if(node.getParentNodeId().equals(n.getNodeId()) && n.getNodeType().equals(SmcConstants.StlNode.NodeType.JAONARRAY)){
						parentIsArrayFlag = true;
					}
				}
				if(!parentIsArrayFlag){
					nNode.put(node.getNodeId(), node.getNodePath());
				}
			}
		}
		if(arrChildList.size()>0){
			for(int i=0;i<arrChildList.size();i++){
				arrChildList.get(i).putAll(nNode);
			}
		}else{
			Map<Long, String> mapAll = new HashMap<>();
			mapAll.putAll(nNode);
			arrChildList.add(mapAll);
		}
		
		
		for(Policy policy : policys){
			List<NodeElementMapping> mapping = SmcCacheUtil.getNodeElementMappingByPolicyId(tenantId, policy.getPolicyId());
			for(Map<Long,String> item : arrChildList){
				BusinessMessage businessMessage = new BusinessMessage();
				businessMessage.setBusiType("SMC_DATAFLOW");
				businessMessage.setCreateTime(Timestamp.valueOf(LocalDateTime.now()));
				String msgId = UUID.randomUUID().toString().replace("-", "");
				businessMessage.setMsgID(msgId);
				businessMessage.setMsgVersion("1.0");
				SmcBusinessMessage message = new SmcBusinessMessage();
				Header header = new Header();
				header.setPolicyId(policy.getPolicyId());
				header.setTenantId(tenantId);
				header.setObjectType(policy.getStlObjectId());
				header.setSerialId(msgId);
				Map<String, String> messageBody = new HashMap<>();
				boolean needSettle = true;
				for(NodeElementMapping m : mapping){
					
					Element element = SmcCacheUtil.getElementByElementId(tenantId, m.getTarNodeDescId());
					messageBody.put(element.getElementCode(), JsonPath.read(messageData.getDataStr(), item.get(m.getSrcNodeDescId())).toString());
				
					if(element.getIsPrimaryKey().equals(SmcConstants.StlElement.IsPrimaryKey.YES)){
						header.setPrimaryKey(element.getElementCode());
					}
					
					if(element.getIsSettlement().equals(SmcConstants.StlElement.IsSettlement.YES)){
						String objectCode = JsonPath.read(messageData.getDataStr(), item.get(m.getSrcNodeDescId()));
						PolicyInstn instn = SmcCacheUtil.getPolicyInstnByObjectCode(tenantId, policy.getPolicyId(),objectCode);
						if(instn!=null){
							header.setObjectType(instn.getInstnType());
							header.setObjectCode(objectCode);
						}else{
							needSettle = false;
						}
						
					}
//					if(element.getElementType().equals(SmcConstants.StlElement.ElementType.TIMESTAMP)){
//						StlPolicyTaskCycle cycle = getCycle(tenantId, policy.getPolicyId(), JsonPath.read(messageData.getDataStr(), item.get(m.getSrcNodeDescId())));
//						header.setCycleValue(cycle.getCycleValue());
						header.setCycleType(policy.getExecCycle());
//						header.setPolicyCycleId(cycle.getPolicyCycleId());
//					}
					
				}
				message.setBody(JSONObject.parseObject(JSON.toJSONString(messageBody)));
				message.setHeader(header);
				//message.getHeader().setBsn("BSN_"+header.getTenantId() + "_" + header.getPolicyId() + "_" + header.getCycleValue());
				businessMessage.setData(JSON.toJSONString(message));
				
				if(needSettle){
					messageData.getMessages().add(businessMessage);
				}
					
			}
		}
	}
	
	
	private StlPolicyTaskCycle getCycle(String tenantId,Long policyId,Long timestamp){
		StlPolicyTaskCycleExample example = new StlPolicyTaskCycleExample();
		StlPolicyTaskCycleExample.Criteria criteria = example.createCriteria();
		criteria.andTenantIdEqualTo(tenantId);
		criteria.andPolicyIdEqualTo(policyId);
		Date date = new Date(Long.valueOf(timestamp));
		criteria.andStartTimeLessThan(date);
		criteria.andEndTimeGreaterThanOrEqualTo(date);
		List<StlPolicyTaskCycle> list = cycleMapper.selectByExample(example);
		if(list.size()>0){
			return list.get(0);
		}
		return null;
	}
	
	@Override
	public void vilidateNode(MessageData messageData) {

		String topicName = messageData.getTopicName();
		
		List<Node> nodes = SmcCacheUtil.getNodeByContractId(messageData.getTenantId(), topicName);
		
		messageData.setNodes(nodes);
		
		for (Node node : nodes) {
			boolean flag = true;
			if(node.getIsNeedCheck().equals(SmcConstants.StlNode.Check.YES)||node.getNodeType().equals(SmcConstants.StlNode.NodeType.JAONARRAY)){
				
				if(node.getNodeType().equals(SmcConstants.StlNode.NodeType.STRING)){
					Object o = JsonPath.read(messageData.getDataStr(), node.getNodePath());
					if(o instanceof List){
						List list = (List)o;
						if(list==null||list.size()==0){
							flag = false;
						}
					}else{
						if(StringUtil.isBlank(String.valueOf(o))){
							flag = false;
						}
					}
					
				}else{
					Object object = JsonPath.read(messageData.getDataStr(), node.getNodePath());
					if(object == null){
						flag = false;
					}
				}
			}
			if(!flag){
				String errMessage = "节点验证失败:PATH" + node.getNodePath();
				if(!IHbaseClientFactory.getDefaultHbaseClient().tableExists(SmcConstants.Hbase.MESSAGE_INPUT_SRC_FAILURE)){
					IHbaseClientFactory.getDefaultHbaseClient().creatTable(SmcConstants.Hbase.MESSAGE_INPUT_SRC_FAILURE, new String[]{"data"});
				}
				StringBuffer rowKey = new StringBuffer();
				//错单表rowKey = tanentId+topicName+msgId
				rowKey.append(messageData.getTenantId()).append(messageData.getTopicName()).append(messageData.getMsgID());
				List<PutVO> puts = new ArrayList<>();
				PutVO putVO = new PutVO();
				putVO.setRowkey(rowKey.toString());
				List<FamilyVO> families = new ArrayList<>();
				FamilyVO familyVO = new FamilyVO();
				familyVO.setFamily("data");
				List<QualifierVO> qualifiers = new ArrayList<>();
				
				QualifierVO msg = new QualifierVO();
				msg.setQualifier("msg");
				msg.setValue(messageData.getDataStr());
				QualifierVO reason = new QualifierVO();
				reason.setQualifier("reason");
				reason.setValue(errMessage);
				qualifiers.add(msg);
				qualifiers.add(reason);
				familyVO.setQualifiers(qualifiers);
				families.add(familyVO);
				putVO.setFamilies(families);
				puts.add(putVO);
				
				try {
					IHbaseClientFactory.getDefaultHbaseClient().addRecords(SmcConstants.Hbase.MESSAGE_INPUT_SRC_FAILURE, puts);
				} catch (IOException e) {
					log.error("存入错单表失败messageId:{0}：{1}",messageData.getMsgID(),e.getMessage());
					
				}
				
				throw new NodeValidateException(errMessage);
			}
		}

	}	
	
}

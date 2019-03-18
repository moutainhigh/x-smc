package com.x.ic.msg.service.busi.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.x.ic.msg.constants.SmcConstants;
import com.x.ic.msg.exception.NoSuitableException;
import com.x.ic.msg.exception.NodeValidateException;
import com.x.ic.msg.service.atom.interfaces.IMessageCondSV;
import com.x.ic.msg.service.atom.interfaces.INodeTransferSV;
import com.x.ic.msg.service.busi.interfaces.ITopicSupportSV;
import com.x.ic.msg.vo.MessageData;
import com.x.ic.smc.sdk.cache.vo.Policy;
import com.x.sdk.component.mds.MDSClientFactory;
import com.x.sdk.mds.vo.BusinessMessage;

@Service
public class TopicSupportSVImpl implements ITopicSupportSV {

	
	private static final Logger log = LogManager.getLogger(TopicSupportSVImpl.class);
	
	@Autowired
	private IMessageCondSV messageCondSV;
	
	@Autowired
	private INodeTransferSV nodeTransferSV;
	
	@Override
	public void messageDispense(MessageData messageData) {
		
		log.debug("开始进行政策适配！");
		try {
			List<Policy> policyList = messageCondSV.suitPolicy(messageData);
			messageData.setPolicys(policyList);
			log.debug("开始进行节点验证！");
			nodeTransferSV.vilidateNode(messageData);
			log.debug("开始进行节点转换！");
			nodeTransferSV.trans(messageData);
			List<BusinessMessage> mgs = messageData.getMessages();
			if(mgs.size()!=0){
				for(BusinessMessage mg : mgs){
					log.debug("消息发送：{}" ,JSON.toJSONString(mg) );
					MDSClientFactory.getSenderClient(SmcConstants.MDS_NS_SMC_DETAILED_TOPIC).send(JSON.toJSONString(mg), System.currentTimeMillis()%2);
				}
			}else{
				log.debug("没有适配到合适的政策：{}" , messageData.getDataStr());
			}
		} catch (NoSuitableException e) {
			log.error(e.getMessage());
		} catch (NodeValidateException e){
			log.error(e.getMessage());
		}catch(Exception e){
			log.error(e.getMessage());
		}	
	}

}

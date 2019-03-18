package com.x.ic.msg.cache;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.x.ic.msg.constants.SmcCacheConstant;
import com.x.ic.msg.constants.SmcConstants;
import com.x.ic.msg.dao.mapper.bo.StlNode;
import com.x.ic.msg.dao.mapper.bo.StlNodeExample;
import com.x.ic.msg.dao.mapper.bo.StlNodeExample.Criteria;
import com.x.ic.msg.dao.mapper.interfaces.StlNodeMapper;
import com.x.ic.msg.test.NodeTree;
import com.x.sdk.cache.base.AbstractCache;
import com.x.sdk.mcs.MCSClientFactory;


@Component("test")
public class NodeTreeCache extends AbstractCache {

	private static final Logger log = LogManager.getLogger(NodeTreeCache.class);
	
	@Autowired
	private StlNodeMapper stlNodeMapper;
	
	@Override
	public void write() throws Exception {
		
		StlNodeExample stlNodeExample = new StlNodeExample();
		Criteria criteria = stlNodeExample.createCriteria();
		criteria.andStateEqualTo(SmcConstants.StlNode.State.NORMAL);
		criteria.andParentNodeIdIsNull();
		StlNode rootNode = stlNodeMapper.selectByExample(stlNodeExample).get(0);
		NodeTree root = JSONObject.parseObject(JSON.toJSONString(rootNode), NodeTree.class);
		childNodes(root);
		MCSClientFactory.getCacheClient(SmcCacheConstant.MSDNS).hset(SmcCacheConstant.NameSpace.NODE_CACHE, "nodeTree", JSON.toJSONString(root));
		
	}
	public void childNodes(NodeTree node){
		StlNodeExample stlNodeExample = new StlNodeExample();
		Criteria criteria = stlNodeExample.createCriteria();
		criteria.andStateEqualTo(SmcConstants.StlNode.State.NORMAL);
		criteria.andParentNodeIdEqualTo(node.getNodeId());
		if(node.getNodeType().equals(SmcConstants.StlNode.NodeType.JAONARRAY) || node.getNodeType().equals(SmcConstants.StlNode.NodeType.JSON)){
			List<StlNode> childs = stlNodeMapper.selectByExample(stlNodeExample);
			if(childs!=null){
				List<NodeTree> childNodes = new ArrayList<>();
				for(StlNode child : childs){
					NodeTree n = new NodeTree();
					n.setContractId(child.getContractId());
					n.setCreateTime(child.getCreateTime());
					n.setDescription(child.getDescription());
					n.setIsNeedCheck(child.getIsNeedCheck());
					n.setLastestTime(child.getLastestTime());
					n.setNodeCode(child.getNodeCode());
					n.setNodeId(child.getNodeId());
					n.setNodeName(child.getNodeName());
					n.setNodePath(child.getNodePath());
					n.setNodeType(child.getNodeType());
					n.setState(child.getState());
					n.setTenantId(child.getTenantId());
					StlNode no = stlNodeMapper.selectByPrimaryKey(child.getParentNodeId());
					n.setParentNode(JSONObject.parseObject(JSON.toJSONString(no),NodeTree.class));
					childNodes.add(n);
				}
				for (int i = 0 ; i< childNodes.size();i++) {
					childNodes(childNodes.get(i));
				}
				node.setChildNodes(childNodes);
			}
		}
		
		
		
		
		
		
		
		
	}

}

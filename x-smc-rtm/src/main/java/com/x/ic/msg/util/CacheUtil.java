package com.x.ic.msg.util;

import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.x.ic.msg.constants.SmcCacheConstant;
import com.x.ic.msg.dao.mapper.bo.StlNode;
import com.x.sdk.mcs.MCSClientFactory;

public class CacheUtil {

	public static void main(String[] args) {
		StlNode node = CacheUtil.getNode("pubgo", 10001l);
		System.out.println(JSON.toJSONString(node));
	}
	public static List<StlNode> getNodeListByContractId(String tenantId , String contractId){
		String key = new StringBuffer(tenantId).append(contractId).toString();
		String nodeStr = MCSClientFactory.getCacheClient(SmcCacheConstant.MSDNS).hget(SmcCacheConstant.NameSpace.NODE_CACHE, key);
		return JSONObject.parseArray(nodeStr, StlNode.class);
	}
	public static StlNode getNode(String tenantId , Long nodeId){
		String key = new StringBuffer(tenantId).append(nodeId).toString();
		String nodeStr = MCSClientFactory.getCacheClient(SmcCacheConstant.MSDNS).hget(SmcCacheConstant.NameSpace.NODE_CACHE, key);
		return JSONObject.parseObject(nodeStr, StlNode.class);
	}
	
	
	
	
	
	
}

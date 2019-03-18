package com.x.ic.msg.test;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;


public class Transfer2 {

	public static void main(String[] args) throws IOException {
//		List<Node> nodes = SmcCacheUtil.getNodeByContractId("pubgo", "mayt3-test-topic");
//		List<NodeElementMapping> mapping = SmcCacheUtil.getNodeElementMappingByPolicyId("pubgo", 100001l);

		DocumentContext context =  JsonPath.parse(new File("F:/jsonData/data.json"));
//		String nodeTreeStr = MCSClientFactory.getCacheClient(SmcCacheConstant.MSDNS).hget(SmcCacheConstant.NameSpace.NODE_CACHE, "nodeTree");
		
		JSONObject json = JSONObject.parseObject(context.jsonString());
		Map map = new HashMap<>();
		StringBuffer path = new StringBuffer("$");
		ts(json,path);

	}
	public static void ts(Object arg,StringBuffer path){
		StringBuffer tmp = new StringBuffer(path);
		if(arg instanceof Map){
			Map map = (Map)(arg);
			for(Object key : map.keySet()){
				tmp.append(".").append(key);
				if(map.get(key) instanceof Map || map.get(key) instanceof List){
					ts(map.get(key),tmp);
				}else{
					System.out.println(tmp.toString());
				}
			}
		}else{
			JSONArray arr = (JSONArray)arg;
			for(int i = 0; i< arr.size();i++){
				StringBuffer tmp2 = new StringBuffer(tmp);
				tmp2.append("[").append(i).append("]");
				ts(arr.get(i),tmp2);
			}
		}
		
	}
	
	
	

}

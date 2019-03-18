package com.x.dshm.client.impl;
//package com.ai.runner.center.dshm.client.impl;
//
//import java.util.Map;
//import java.util.TreeMap;
//import java.util.Map.Entry;
//
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//import org.springframework.stereotype.Repository;
//
//import com.ai.runner.center.dshm.client.interfaces.IDshmClient;
//
//public class test {
//	//private IDshmClient client;
//	public static void main(String[] args){
//		IDshmClient client = (IDshmClient)new ClassPathXmlApplicationContext(new String[]{
//			"classpath:context/dshm-context.xml"
//	}).getBean("dshmClient");
//		Map<String,String> params = new TreeMap<String,String>();
//		params.put("acct_id", "259");	
//		params.put("tenant_id", "VIV-BYD");	
//		Map<String, String> results=client.list("bl_userinfo")
//				.where(params)
//				.executeQuery();
//		for(Entry<String, String> result:results.entrySet()){
//			System.out.println("the key is "+result.getKey()+"="+result.getValue());
//		}
//	}
//}

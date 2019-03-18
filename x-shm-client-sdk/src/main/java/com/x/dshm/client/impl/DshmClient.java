package com.x.dshm.client.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.TreeMap;

//import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.x.sdk.mcs.interfaces.ICacheClient;
import com.alibaba.fastjson.JSONObject;
import com.x.dshm.client.CacheFactoryUtil;
import com.x.dshm.client.interfaces.IDshmClient;
public class DshmClient implements IDshmClient{
	private static final Logger log = LoggerFactory.getLogger(DshmClient.class);
	private class operInfo{
		String tableName;
		Map<String, String> params;
	}
	private ICacheClient cacheClient;
//	private ICacheClient cacheClient=CacheFactoryUtil
//            .getCacheClient(CacheBLMapper.CACHE_BL_CAL_PARAM);
	private operInfo operInfo=null;
	public DshmClient(){
		cacheClient =  CacheFactoryUtil
                .getCacheClient(CacheBLMapper.CACHE_BL_CAL_PARAM);
	}
	@Override
	public DshmClient list(String tableName) {
		if(tableName==null||"".equals(tableName.trim())){
			throw new IllegalArgumentException("表名不能为空！");
		}
		this.operInfo=new operInfo();
		this.operInfo.tableName=tableName;
		return this;
	}
	@Override
	public DshmClient where(Map<String, String> params) {
		if(this.operInfo == null){
			throw new IllegalArgumentException("为初始化表对象！请先调用list！");
		}
		if(params!=null && params.size()!=0){
			this.operInfo.params = params;
		}
		return this;
	}

	@Override
	public List<Map<String, String>>executeQuery(ICacheClient cacheClient) {
		//需要根据Map获取tableId
		StringBuilder indexKey= new StringBuilder();
		indexKey.append(this.operInfo.tableName.toLowerCase()).append(":");
		String tenant_id="ALL";
		StringBuilder hindexKey= new StringBuilder();
		StringBuilder hindexValue= new StringBuilder();
		List<Map<String,String>> list = new ArrayList<Map<String,String>>();
		System.out.println("the size of the list is "+list.size());
		Map<String, String> searchValue= new HashMap<String, String>();
		if(this.operInfo.params!=null&&this.operInfo.params.size()!=0){
			for(Entry<String, String> paramsentry:this.operInfo.params.entrySet()){
				indexKey.append(paramsentry.getKey().toLowerCase()).append(":");
				hindexKey.append(paramsentry.getKey().toLowerCase()).append(":");
				hindexValue.append(paramsentry.getValue()).append(":");
				if(("tenant_id").equals(paramsentry.getKey().toLowerCase())){
					 tenant_id=paramsentry.getValue();
				}
			}
			//indexKey.append(tenant_id);
			System.out.println("the indexKey is "+indexKey.toString());
			String tableId=cacheClient.get((indexKey.toString()).substring(0, indexKey.toString().length()-1));
			System.out.println("the table_id is "+tableId);
			StringBuilder hFirstKey=new StringBuilder();
			hFirstKey.append(this.operInfo.tableName).append(":").append(tableId);
			System.out.println("the first key is "+hFirstKey.toString());
			hindexKey.append((hindexValue.toString()).substring(0, hindexValue.toString().length()-1));
			System.out.println("the second key is "+hindexKey.toString());
			String hValue=cacheClient.hget(hFirstKey.toString(),hindexKey.toString());
			System.out.println("the length of the hValue is "+hValue);
			if(hValue==null||"".equals(hValue.trim())){
				// list.add(searchValue);
				 return list;
			}
			else{
				String[] singleValue=StringUtils.splitPreserveAllTokens(hValue, "$");
				for(int i=0;i<singleValue.length;i++){
//					if(searchValue.size()==0){
//						searchValue=json2Map(singleValue[i]);
//					}else{
//						Map<String, String> value=json2Map(singleValue[i]);
//						value2Map(value,searchValue);
//					}
					Map<String, String> searchMulValue= new HashMap<String, String>();
					searchMulValue=json2Map(singleValue[i]);
					list.add(searchMulValue);
				}
				
				return list;
			}
		}else{
				StringBuilder firstBuilder=new StringBuilder();
				firstBuilder.append(this.operInfo.tableName.toLowerCase());
				Map<String, String> tableIds=cacheClient.hgetAll(firstBuilder.toString());
				System.out.println("the get id map the key is "+firstBuilder.toString());
				for(Entry<String, String>tableid:tableIds.entrySet()){
					StringBuilder hfirst=new StringBuilder();
					hfirst.append(this.operInfo.tableName.toLowerCase()).append(":").append(tableid.getKey());
					Map<String, String> noParamValue=cacheClient.hgetAll(hfirst.toString());
					for(Entry<String, String> allValue:noParamValue.entrySet()){
						Map<String, String> searchValue2=new HashMap<String,String>();
						String allhValue=allValue.getValue();
						String[] singleValue=StringUtils.splitPreserveAllTokens(allhValue, "$");
						for(int i=0;i<singleValue.length;i++){
//							if(searchValue.size()==0){
//								searchValue=json2Map(singleValue[i]);
//							}else{
//								Map<String, String> value=json2Map(singleValue[i]);
//								value2Map(value,searchValue);
//							}
							Map<String, String> searchMulValue= new HashMap<String, String>();
							searchMulValue=json2Map(singleValue[i]);
							list.add(searchMulValue);
						}
					}
				}
				return list;
		}
	}
	Map<String, String> json2Map(String obj){
		Map<String, String> jsonMap= new HashMap<String,String>();
		JSONObject jsonobject=JSONObject.parseObject(obj);
		for(Object k:jsonobject.keySet()){
			jsonMap.put(k.toString(), jsonobject.get(k).toString());
		}
		return jsonMap;
	}
	
	void value2Map(Map<String, String>value,Map<String,String>searchValue){
		for(Entry<String, String> valueentry:value.entrySet()){
			String valueKey=valueentry.getKey();
			StringBuilder searchvalue= new StringBuilder();
			String tempvalue=searchValue.get(valueKey);
			if(tempvalue==null||"".equals(tempvalue)||tempvalue.length()==0){
				searchValue.put(valueKey, valueentry.getValue());
			}else{
				searchvalue.append(tempvalue).append("#").append(valueentry.getValue());
			}
		}
	}
	public static void main(String[] args){
//		IDshmClient client = (IDshmClient)new ClassPathXmlApplicationContext(new String[]{
//				"classpath:context/dshm-context.xml"
//		}).getBean("dshmClient");
		IDshmClient client=new DshmClient();
		Properties p=new Properties();
		p.setProperty("paas.sdk.mode", "1");
		p.setProperty("ccs.appname", "aiopt-baas-dshm");
		p.setProperty("ccs.zk_address", "10.1.130.84:39181");
//		p.setProperty("paas.auth.url", "http://10.1.245.4:19811/service-portal-uac-web/service/auth");
//		p.setProperty("paas.auth.pid", "87EA5A771D9647F1B5EBB600812E3067");
//		p.setProperty("paas.ccs.serviceid", "CCS008");
//		p.setProperty("paas.ccs.servicepassword", "123456");
//		p.setProperty("paas.auth.url", "http://10.1.245.4:19811/service-portal-uac-web/service/auth");
//		p.setProperty("paas.auth.pid", "DD9AA862535641EEA67A25F719E37CBD");
//		p.setProperty("paas.ccs.serviceid", "CCS006");
//		p.setProperty("paas.ccs.servicepassword", "123456");

		
		ICacheClient cacheClient =  CacheFactoryUtil
              .getCacheClient(p,CacheBLMapper.CACHE_BL_CAL_PARAM);

		Map<String,String> params = new TreeMap<String,String>();
		//params.put("acct_id1", "48");	
		//params.put("cust_id", "221");
		//charge_type:price_code:dr:0000001051
		//params.put("detail_code", "0000001031");
		params.put("subs_id", "262");
		params.put("tenant_id", "ECITIC");
		List<Map<String, String>> results=client.list("bl_subs_comm")
				.where(params)
				.executeQuery(cacheClient);
		for (Map<String, String> map : results){
			for(Entry<String, String> result:map.entrySet()){
				System.out.println("the key is "+result.getKey()+"="+result.getValue());
			}
//			String objectId = map.get("object_id");
//			System.out.println("the key is "+objectId);
//            String billTimeSn = map.get("BILL_TIME_SN");
//            System.out.println("the key is "+billTimeSn);
		}
	}
	@Override
	public List<Map<String, String>> executeQuery() {
		// TODO Auto-generated method stub
		//需要根据Map获取tableId
		StringBuilder indexKey= new StringBuilder();
		indexKey.append(this.operInfo.tableName.toLowerCase()).append(":");
		String tenant_id="ALL";
		StringBuilder hindexKey= new StringBuilder();
		StringBuilder hindexValue= new StringBuilder();
		List<Map<String,String>> list = new ArrayList<Map<String,String>>();
		System.out.println("the size of the list is "+list.size());
		Map<String, String> searchValue= new HashMap<String, String>();
		if(this.operInfo.params!=null&&this.operInfo.params.size()!=0){
			for(Entry<String, String> paramsentry:this.operInfo.params.entrySet()){
				indexKey.append(paramsentry.getKey().toLowerCase()).append(":");
				hindexKey.append(paramsentry.getKey().toLowerCase()).append(":");
				hindexValue.append(paramsentry.getValue()).append(":");
				if(("tenant_id").equals(paramsentry.getKey().toLowerCase())){
					 tenant_id=paramsentry.getValue();
				}
			}
			//indexKey.append(tenant_id);
			System.out.println("the indexKey is "+indexKey.toString());
			String tableId=this.cacheClient.get((indexKey.toString()).substring(0, indexKey.toString().length()-1));
			System.out.println("the table_id is "+tableId);
			StringBuilder hFirstKey=new StringBuilder();
			hFirstKey.append(this.operInfo.tableName).append(":").append(tableId);
			System.out.println("the first key is "+hFirstKey.toString());
			hindexKey.append((hindexValue.toString()).substring(0, hindexValue.toString().length()-1));
			System.out.println("the second key is "+hindexKey.toString());
			String hValue=this.cacheClient.hget(hFirstKey.toString(),hindexKey.toString());
			System.out.println("the length of the hValue is "+hValue);
			if(hValue==null||"".equals(hValue.trim())){
				// list.add(searchValue);
				 return list;
			}
			else{
				String[] singleValue=StringUtils.splitPreserveAllTokens(hValue, "$");
				for(int i=0;i<singleValue.length;i++){
//							if(searchValue.size()==0){
//								searchValue=json2Map(singleValue[i]);
//							}else{
//								Map<String, String> value=json2Map(singleValue[i]);
//								value2Map(value,searchValue);
//							}
					Map<String, String> searchMulValue= new HashMap<String, String>();
					searchMulValue=json2Map(singleValue[i]);
					list.add(searchMulValue);
				}
				
				return list;
			}
		}else{
				StringBuilder firstBuilder=new StringBuilder();
				firstBuilder.append(this.operInfo.tableName.toLowerCase());
				Map<String, String> tableIds=this.cacheClient.hgetAll(firstBuilder.toString());
				System.out.println("the get id map the key is "+firstBuilder.toString());
				for(Entry<String, String>tableid:tableIds.entrySet()){
					StringBuilder hfirst=new StringBuilder();
					hfirst.append(this.operInfo.tableName.toLowerCase()).append(":").append(tableid.getKey());
					Map<String, String> noParamValue=this.cacheClient.hgetAll(hfirst.toString());
					for(Entry<String, String> allValue:noParamValue.entrySet()){
						Map<String, String> searchValue2=new HashMap<String,String>();
						String allhValue=allValue.getValue();
						String[] singleValue=StringUtils.splitPreserveAllTokens(allhValue, "$");
						for(int i=0;i<singleValue.length;i++){
//									if(searchValue.size()==0){
//										searchValue=json2Map(singleValue[i]);
//									}else{
//										Map<String, String> value=json2Map(singleValue[i]);
//										value2Map(value,searchValue);
//									}
							Map<String, String> searchMulValue= new HashMap<String, String>();
							searchMulValue=json2Map(singleValue[i]);
							list.add(searchMulValue);
						}
					}
				}
				return list;
		}
	}

	
}

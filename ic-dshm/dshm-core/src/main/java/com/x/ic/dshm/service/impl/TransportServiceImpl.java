package com.x.ic.dshm.service.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.x.ic.dshm.constants.BillingConstants;
import com.x.ic.dshm.dao.interfaces.IDao;
import com.x.ic.dshm.dso.interfaces.IDso;
import com.x.ic.dshm.dto.EbillingShmTableDb;
import com.x.ic.dshm.dto.ShmTableLoad;
import com.x.ic.dshm.service.interfaces.ITransportService;

import net.sf.json.JSONObject;

@Service("transportService")
public class TransportServiceImpl implements ITransportService{
	private static final Logger log = LoggerFactory.getLogger(TransportServiceImpl.class);
	private IDao dao;
	private IDso dso;
	public void setDao(IDao dao) {
		this.dao = dao;
	}
	public void setDso(IDso dso) {
		this.dso = dso;
	}
	@Override
	public Boolean EbillingTable2Dso() {
		Map<String, ShmTableLoad> tableLoads=dao.LoadShmTableInfo();
		Map<String, EbillingShmTableDb> tableDbMaps=dao.LoadShmTableDb();
		StringBuilder loadContext =new StringBuilder();
		Gson gson = new Gson();	
		for(Entry<String, ShmTableLoad> entry : tableLoads.entrySet()){
			String tableNameId=entry.getKey();//bl_userinfo:12
			ShmTableLoad shmTableLoad=entry.getValue();
			StringBuilder redisKey= new StringBuilder();
			StringBuilder indexId= new StringBuilder();//用于刷新和释放内存空间时，用来查找table_id
			String [] tableid=StringUtils.splitPreserveAllTokens(tableNameId, BillingConstants.KEY_JOINER);// table_name:table_id
			redisKey.append(tableid[0]);
			log.debug(".......... the redisKey is "+redisKey.toString());
			indexId.append(tableid[0]).append(BillingConstants.KEY_JOINER).append(shmTableLoad.getIndexKey());			
			//indexId 中的tenantId 如果该表中没有租户id 而向info和record表沉淀的时候将租户沉淀为ALL   bl_userinfo:subs_id:tenant_id:VIV-BYD
			String field=tableid[1];  //table_id
			String params = gson.toJson(shmTableLoad);
			//将java bean对象转换成json形式
			if(!(StringUtils.contains(loadContext.toString(), redisKey.toString()))){
				//表示是第一次开始加载该表，需要将之前的删除
				dso.del(redisKey.toString());
				loadContext.append(redisKey.toString()).append(BillingConstants.VALUE_JOINER);
			}
			log.debug("//////////////////the field is "+field);
			dso.hset(redisKey.toString(), field, params);  //bl_userinfo  12  value
			dso.set(indexId.toString(), field);//这个主要是为了全表查询的时候使用    bl_userinfo:subs_id:tenant_id:VIV-BYD    12
		}
		//开始进行db表的加载
		for(Entry<String, EbillingShmTableDb> entrydb : tableDbMaps.entrySet()){
			StringBuilder dbKey= new StringBuilder();
			dbKey.append(entrydb.getKey());
			String dbParams=gson.toJson(entrydb.getValue());
			if(!(StringUtils.contains(loadContext.toString(), dbKey.toString()))){
				//表示是第一次开始加载该表，需要将之前的删除
				dso.del(dbKey.toString());
				loadContext.append(dbKey.toString()).append(BillingConstants.VALUE_JOINER);
			}
			dso.set(dbKey.toString(), dbParams);   //ebilling    value
		}
		
		return true;
	}
	@Override
	public void LoadData2Dso(String table_name, String infoValue,String tableId) {
		// 首先需要获取需要加载的表的结构
//		for(Entry<String,String> infoentry:tableInfos.entrySet() ){
			//转换成java bean 对象
			JSONObject jsonObject= JSONObject.fromObject((Object)infoValue);
			ShmTableLoad tableinfo=(ShmTableLoad) jsonObject.toBean(jsonObject, ShmTableLoad.class);
			StringBuilder firstKey=new StringBuilder();
			firstKey.append(table_name).append(BillingConstants.KEY_JOINER).append(tableId);
			//Map<String,String> fieldValues=dao.LoadTableData(table_name,tableinfo);//此处设计不合理此处的map太大了会jvm会爆掉的
			dao.LoadTableData(table_name,tableinfo,firstKey.toString());//此处设计不合理此处的map太大了会jvm会爆掉的
			
			//开始向内存中插入
//			for(Entry<String,String> fieldvalue:fieldValues.entrySet()){
//				dso.hset(firstKey.toString(), fieldvalue.getKey(), fieldvalue.getValue());
//				//最终的存储形式：subs_user:13  subs_id:active_time:12:20151221000000  "subs_id":"12","active_time":"20151221000000","province_code":"11"
//			}
		//}	
	}
	@Override
	public void Data2Dso(String firstKey, String fieldKey, String value) {
		dso.hset(firstKey, fieldKey, value);	
	}

	@Override
	//public String getDbInfo(String dbName, String tenant_id) {
//		StringBuilder dbKey=new StringBuilder();
//		dbKey.append(dbName).append(BillingConstants.KEY_JOINER).append(tenant_id);
//		return dso.get(dbKey.toString());
//	}
	public String getDbInfo(String dbName) {
	StringBuilder dbKey=new StringBuilder();
	dbKey.append(dbName);
	return dso.get(dbKey.toString());
}
	@Override
	public Boolean initCtp2Dso(String infoValue, String tableId,Map<String, String>initMap,String tableName,int type) {
			//转换成java bean 对象
			JSONObject jsonObject= JSONObject.fromObject((Object)infoValue);
			ShmTableLoad tableinfo=(ShmTableLoad) jsonObject.toBean(jsonObject, ShmTableLoad.class);
			StringBuilder index= new StringBuilder();
			StringBuilder record= new StringBuilder();
			index.append(tableinfo.getIndexKey());
			Map<String, String> records= new HashMap<String,String>();
			String[] indexKeys=StringUtils.splitPreserveAllTokens(index.toString(), BillingConstants.KEY_JOINER);
			String[] recordKeys=StringUtils.splitPreserveAllTokens(tableinfo.getRecord(), BillingConstants.KEY_JOINER);
			for(String indexKey:indexKeys)
				index.append(BillingConstants.KEY_JOINER).append(initMap.get(indexKey));
			for(String recordKey:recordKeys)
				records.put(recordKey, initMap.get(recordKey));
			//将Map转换成json的形式
			JSONObject recordvalue = JSONObject.fromObject(records);
			record.append(recordvalue.toString());
			StringBuilder nameId= new StringBuilder();
			nameId.append(tableName).append(BillingConstants.KEY_JOINER).append(tableId);
//			String[] redisData= new String[3];
//			redisData[0]=nameId.toString();
//			redisData[1]=index.toString();
//			redisData[2]=recordvalue.toString();
			log.debug("the nameId is: "+nameId);
			log.debug("the index is: "+index.toString());
			if(type==1){//表示是需要进行insert操作的
				log.debug("执行缓存insert操作。。。。。");
				String value="";
				value=dso.hget(nameId.toString(), index.toString());
				log.debug("the value is: "+value);
				log.debug("the recordvalue is:"+recordvalue.toString());
				if(value==null){
					log.debug("the value is null,and the recordvalue is:"+ recordvalue.toString());
					dso.hset(nameId.toString(), index.toString(), recordvalue.toString());
					return true;
				}
				else{
					StringBuilder mulRecords= new StringBuilder();
					mulRecords.append(value).append("$").append(recordvalue.toString());
					log.debug("the mulRecord is:"+mulRecords.toString());
					dso.hset(nameId.toString(), index.toString(), mulRecords.toString());
					return true;
				}
			}else if(type==0){//表示需要先删除在insert操作或者是update操作
				log.debug("执行缓存update操作。。。。。");
				String value="";
				
				log.debug("the tableinfo primary is "+tableinfo.getPrimaryKey());
				String[] primaryKeys=StringUtils.splitPreserveAllTokens(tableinfo.getPrimaryKey(), BillingConstants.KEY_JOINER);
				value=dso.hget(nameId.toString(), index.toString());
				log.debug("the value is:"+value);
				if(value!=null&&value.contains("$")){
					String[] valueString=StringUtils.splitPreserveAllTokens(value, "$");
					StringBuilder initPrimary = new StringBuilder();
					for(int j=0;j<primaryKeys.length;j++){
						initPrimary.append(primaryKeys[j]).append(BillingConstants.KEY_JOINER).append(initMap.get(primaryKeys[j]));
					}
					int i=0;
					for( i=0;i<valueString.length;i++){
						Map<String, String> valueMap= new HashMap<String,String>();
						valueMap=json2Map(valueString[i]);
						StringBuilder valuePrimary= new StringBuilder();
						for(int j=0;j<primaryKeys.length;j++){
							valuePrimary.append(primaryKeys[j]).append(BillingConstants.KEY_JOINER).append(valueMap.get(primaryKeys[j]));
						}
						if((initPrimary.toString()).equals(valuePrimary.toString())){
							valueString[i]=recordvalue.toString();
							break;
						}
					}
					if(i==valueString.length){
						log.error("primary key is not in redis ......");
						return false;
					}else{
						StringBuilder updateValue= new StringBuilder();
						for(int j=0;j<valueString.length;j++){
							if(j==0)
								updateValue.append(valueString[j]);
							else {
								updateValue.append("$").append(valueString[j]);
							}
						}
						log.debug("updateValue is :"+updateValue.toString());
						dso.hset(nameId.toString(), index.toString(), updateValue.toString());
						return true;
					}	
				}else{
					log.debug("value not contains $ and the recordvlue is: "+recordvalue.toString());
					dso.hset(nameId.toString(), index.toString(), recordvalue.toString());
					return true;
				}
			}else{//表示此时是要进行删除操作
				log.info("执行删除操作。。。。");
				String[] indexStrings=StringUtils.splitPreserveAllTokens(index.toString(), "$");
				dso.hdel(nameId.toString(), indexStrings);
				return true;
			}
				
	}
	
	public  Map<String, String> json2Map(String json) {
		Map<String, String> jsonMap= new HashMap<String,String>();
		JSONObject jsonobject=JSONObject.fromObject(json);
		for(Object k:jsonobject.keySet()){
			jsonMap.put(k.toString().toLowerCase(), jsonobject.get(k).toString());
		}
		return jsonMap;
	}
	@Override
	public Map<String, String> LoadTableInfo(String tableName) {
		StringBuilder tableKey=new StringBuilder();
		tableKey.append(tableName.toLowerCase());
		Map<String, String> tableInfos= new HashMap<String, String>();
		tableInfos=dso.getMap(tableKey.toString());
		return tableInfos;
	}
	@Override
	public Long DeleteTableMem(String tableName,String tableId) {
		StringBuilder firstKey=new StringBuilder();
		firstKey.append(tableName).append(BillingConstants.KEY_JOINER).append(tableId);
		 return dso.del(firstKey.toString());
	}


}

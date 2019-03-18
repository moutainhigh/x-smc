package com.x.dshm.client.interfaces;

import java.util.List;
import java.util.Map;

import com.x.sdk.mcs.interfaces.ICacheClient;



public interface IDshmClient {
	/**
	 * 用于需要查询的表名
	 * @param tableName
	 * @return
	 */
	IDshmClient list(String tableName);
	/**
	 * 填写where条件的值
	 * @param params
	 * @return
	 */
	IDshmClient where(Map<String, String> params);
	/**
	 * 执行查询操作
	 * @return
	 */
	List<Map<String,String>> executeQuery(ICacheClient cacheClient);
	
	List<Map<String,String>> executeQuery();
	
}

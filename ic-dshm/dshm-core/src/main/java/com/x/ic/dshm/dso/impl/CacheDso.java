package com.x.ic.dshm.dso.impl;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.x.sdk.mcs.interfaces.ICacheClient;
import com.x.ic.dshm.constants.CacheBLMapper;
import com.x.ic.dshm.dso.interfaces.IDso;
import com.x.ic.dshm.util.CacheFactoryUtil;


@Repository("cacheDso")
public class CacheDso implements IDso{
	private ICacheClient  cacheClient=null;
//	private ICacheClient  cacheClient =  MCSClientFactory
//            .getCacheClient(CacheBLMapper.CACHE_BL_CAL_PARAM);
	public CacheDso() throws Exception{
		cacheClient = CacheFactoryUtil
				.getCacheClient(CacheBLMapper.CACHE_BL_CAL_PARAM);
	}
	@Override
	public void hset(String key, String field, String value) {
		cacheClient.hset(key, field, value);
	}
	@Override
	public String hget(String key, String field) {
		return cacheClient.hget(key, field);
	}
	@Override
	public Boolean hexists(String key, String field) {
		return cacheClient.hexists(key, field);
	}
	@Override
	public Long hdel(String key, String[] field) {
		return cacheClient.hdel(key, field);
	}
	@Override
	public Map<String, String> getMap(String key) {
		return cacheClient.hgetAll(key);
	}
	@Override
	public boolean isExist(String key) {
		return cacheClient.exists(key);
	}
	@Override
	public void addItem2ListTail(String key, String item) {
		
	}

	@Override
	public void addItem2ListHead(String key, String item) {
		
	}
	@Override
	public Long del(String key) {
		return cacheClient.del(key);
		
	}
	@Override
	public void set(String key, String value) {
		cacheClient.set(key, value);
	}
	@Override
	public String get(String key) {
		return cacheClient.get(key);
	}
}

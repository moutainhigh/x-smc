package com.x.smc.calculate.topology.core.util;

import java.util.Map;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

import com.x.sdk.mcs.impl.CacheClient;
import com.x.sdk.mcs.impl.CacheClusterClient;
import com.x.sdk.mcs.interfaces.ICacheClient;

public class RedisUtil {
	private RedisUtil() {
	}

	private static ICacheClient cacheClient;

	public static ICacheClient getCacheClient() {
		if (cacheClient == null) {
			return null;
		}
		return cacheClient;
	}

	public static ICacheClient init(Map<String, Object> configMap) {
		GenericObjectPoolConfig genericObjectPoolConfig = new GenericObjectPoolConfig();
		genericObjectPoolConfig.setMaxTotal(Integer.parseInt(
				configMap.get("redis.maxTotal") == null ? "500" : String.valueOf(configMap.get("redis.maxTotal"))));
		genericObjectPoolConfig.setMaxIdle(Integer.parseInt(
				configMap.get("redis.maxIdle") == null ? "100" : String.valueOf(configMap.get("redis.maxIdle"))));
		genericObjectPoolConfig.setMinIdle(Integer.parseInt(
				configMap.get("redis.minIdle") == null ? "5" : String.valueOf(configMap.get("redis.minIdle"))));
		genericObjectPoolConfig
				.setTestOnBorrow(Boolean.parseBoolean(configMap.get("redis.testOnBorrow") == null ? "true"
						: String.valueOf(configMap.get("redis.testOnBorrow"))));
		String host = configMap.get("redis.sentinel.sentinels") == null ? "127.0.0.1:6379"
				: String.valueOf(configMap.get("redis.sentinel.sentinels"));
		String[] hostArray = host.split(";");

		if (hostArray.length > 1) {
			cacheClient = new CacheClusterClient(genericObjectPoolConfig, hostArray);
		} else {
			cacheClient = new CacheClient(genericObjectPoolConfig, host);
		}
		return (ICacheClient) cacheClient;
	}
}
package com.x.ic.smc.util;

import com.x.ic.smc.constants.SmcCacheConstant;
import com.x.sdk.mcs.MCSClientFactory;
import com.x.sdk.mcs.interfaces.ICacheClient;

public class RedisUtil {
	private RedisUtil() {
	}

	private static ICacheClient cacheClient;
	
	public static ICacheClient getCacheClient() {
		if(cacheClient == null) {
			synchronized(RedisUtil.class) {
				cacheClient = MCSClientFactory.getCacheClient(SmcCacheConstant.NameSpace.SMC_CACHE_CLIENT);
			}
		}
		return cacheClient;
	}
}

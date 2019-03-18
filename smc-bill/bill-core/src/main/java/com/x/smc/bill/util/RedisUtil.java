package com.x.smc.bill.util;

import com.x.sdk.mcs.MCSClientFactory;
import com.x.sdk.mcs.interfaces.ICacheClient;
import com.x.smc.bill.constants.BillConstants;

public class RedisUtil {
	private RedisUtil() {
	}

	private static ICacheClient cacheClient;
	
	public static ICacheClient getCacheClient() {
		if(cacheClient == null) {
			synchronized(RedisUtil.class) {
				cacheClient = MCSClientFactory.getCacheClient(BillConstants.NameSpace.BILL_CACHE_CLIENT);
			}
		}
		return cacheClient;
	}
}

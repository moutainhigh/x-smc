package com.x.ic.msg.test;

import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.x.ic.smc.sdk.cache.util.SmcCacheUtil;

public class CacheTest {
	
	@Test
	public void cacheTest1(){
//		MCSClientFactory.getCacheClient("com.x.smc.msg.order").set("aaaaa", "vvvvvvvvvvvv");
//		String str = MCSClientFactory.getCacheClient("com.x.smc.msg.order").get("aaaaa");
		System.out.println(JSON.toJSONString(SmcCacheUtil.getElementByPolicyId("pubgo", 100001l)));
	}
	
}

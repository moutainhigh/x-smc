package com.x.dshm.client;

import java.util.Properties;

import com.x.sdk.component.base.ComponentConfigLoader;
import com.x.sdk.mcs.MCSClientFactory;
import com.x.sdk.mcs.interfaces.ICacheClient;

public final class CacheFactoryUtil {

    private CacheFactoryUtil() {
    }

    public static ICacheClient getCacheClient(Properties p,String namespace) {
    	
		ComponentConfigLoader.loadPaaSConf(p);
        return MCSClientFactory.getCacheClient(namespace);
    }
    public static ICacheClient getCacheClient(String namespace){
    	return MCSClientFactory.getCacheClient(namespace);
    }

}


package com.x.ic.dshm.util;

import com.x.sdk.mcs.MCSClientFactory;
import com.x.sdk.mcs.interfaces.ICacheClient;

public final class CacheFactoryUtil {

    private CacheFactoryUtil() {
    }

    public static ICacheClient getCacheClient(String namespace) {
        return MCSClientFactory.getCacheClient(namespace);
    }

}

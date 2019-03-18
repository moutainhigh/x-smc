package com.x.smc.check.topology.test;

import com.x.sdk.mcs.MCSClientFactory;
import com.x.sdk.mcs.interfaces.ICacheClient;
import com.x.smc.preprocess.topology.core.constant.SmcConstants.NameSpace;

public class TestClient {
    private static ICacheClient countCacheClient;

    public static void main(String[] args) {

        countCacheClient = MCSClientFactory.getCacheClient(NameSpace.CHECK_COUNT_CACHE);
    }

}

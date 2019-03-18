package com.x.ic.smc.cache.init;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import com.x.ic.smc.util.SmcCacheUtil;

public class SmcCacheInit implements InitializingBean {
    private static final Logger LOGGER = LogManager.getLogger(SmcCacheInit.class);
    @Autowired
    private transient ApplicationContext context;
    @Override
    public void afterPropertiesSet() throws Exception {
        LOGGER.info("开始mcs缓存数据初始化...");
        SmcCacheUtil.refreshMcs(context);
        LOGGER.info("mcs缓存数据初始化完成");
    }

}

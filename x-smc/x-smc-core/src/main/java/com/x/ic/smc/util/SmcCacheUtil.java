package com.x.ic.smc.util;

import java.util.Map;

import org.springframework.context.ApplicationContext;

import com.x.base.exception.SystemException;
import com.x.sdk.cache.base.AbstractCache;


public final class SmcCacheUtil {
    private SmcCacheUtil(){}
    
    public static void refreshMcs(ApplicationContext context) {
        Map<String, AbstractCache> caches = context.getBeansOfType(AbstractCache.class);
        for (AbstractCache cache : caches.values()) {
            try {
                cache.write();
            } catch (Exception e) {
                // LOGGER.error("写入mcs缓存失败", e);
                throw new SystemException(e);
            }

        }
    }
}

package com.x.ic.smc.cache;

import java.util.List;

import org.springframework.stereotype.Component;

import com.x.sdk.cache.base.AbstractCache;
import com.x.sdk.util.CollectionUtil;
import com.x.ic.smc.constants.SmcCacheConstant;
import com.x.ic.smc.constants.SmcConstants;
import com.x.ic.smc.dao.mapper.bo.StlElement;
import com.x.ic.smc.dao.mapper.bo.StlElementCriteria;
import com.x.ic.smc.dao.mapper.factory.MapperFactory;
import com.x.ic.smc.util.RedisUtil;
import com.alibaba.fastjson.JSON;

@Component
public class ElementCache extends AbstractCache {

    @Override
    public void write() throws Exception {
        StlElementCriteria stlElementCriteria = new StlElementCriteria();
        stlElementCriteria.createCriteria().andStateEqualTo(SmcConstants.StlElement.State.NORMAL);
        List<StlElement> stlElements = MapperFactory.getElementMapper().selectByExample(
                stlElementCriteria);
        if (CollectionUtil.isEmpty(stlElements)) {
            return;
        }
        for (StlElement stlElement : stlElements) {
            // key:tenantId.elementId,value:StlElement
            StringBuilder key = new StringBuilder();
            key.append(stlElement.getTenantId()).append(".").append(stlElement.getElementId());
            RedisUtil.getCacheClient().hset(SmcCacheConstant.NameSpace.ELEMENT_CACHE, key.toString(),
                    JSON.toJSONString(stlElement));
        }
    }

}

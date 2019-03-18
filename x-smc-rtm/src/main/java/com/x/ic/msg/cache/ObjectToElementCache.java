package com.x.ic.msg.cache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.x.ic.msg.constants.SmcCacheConstant;
import com.x.ic.msg.constants.SmcConstants;
import com.x.ic.msg.dao.mapper.bo.StlElement;
import com.x.ic.msg.dao.mapper.bo.StlElementExample;
import com.x.ic.msg.dao.mapper.interfaces.StlElementMapper;
import com.x.sdk.cache.base.AbstractCache;
import com.x.sdk.mcs.MCSClientFactory;
import com.x.sdk.util.CollectionUtil;

//@Component
public class ObjectToElementCache extends AbstractCache {

	private static final Logger log = LogManager.getLogger(ObjectToElementCache.class);
	
	@Autowired
	private StlElementMapper stlElementMapper;
	
    @Override
    public void write() throws Exception {

        StlElementExample stlElementCriteria = new StlElementExample();
        StlElementExample.Criteria criteria = stlElementCriteria.createCriteria();
        criteria.andStateEqualTo(SmcConstants.StlElement.State.NORMAL);
        List<StlElement> stlElements = stlElementMapper.selectByExample(stlElementCriteria);
        if (CollectionUtil.isEmpty(stlElements)) {
            return;
        }
        List<StlElement> UniqueStlElements = UniqueData(stlElements);

        for (StlElement stlElement : UniqueStlElements) {

            StlElementExample stlElementCriteriaNew = new StlElementExample();
            StlElementExample.Criteria criteriaNew = stlElementCriteriaNew.createCriteria();

            criteriaNew.andTenantIdEqualTo(stlElement.getTenantId());
            criteriaNew.andObjectIdEqualTo(stlElement.getObjectId());
            List<StlElement> stlElementResults = stlElementMapper.selectByExample(
                    stlElementCriteriaNew);
            // key:tenantId.elementId,value:StlElement
            StringBuilder key = new StringBuilder();
            key.append("TenantId:").append(stlElement.getTenantId());
            key.append(".");
            key.append("ObjectId:").append(stlElement.getObjectId());
            String val = JSON.toJSONString(stlElementResults);
            MCSClientFactory.getCacheClient(SmcCacheConstant.MSDNS).hset(SmcCacheConstant.NameSpace.OBJECT_ELEMENT_CACHE, key.toString(),val);
            log.debug("NameSpace:{}",SmcCacheConstant.NameSpace.OBJECT_ELEMENT_CACHE);
			log.debug("key:{}",key.toString());
			log.debug("value:{}",val);
        }
    }

    private List<StlElement> UniqueData(List<StlElement> stlElements) {
        List<StlElement> results = new ArrayList<StlElement>();
        Map<String, Integer> unique = new HashMap<String, Integer>();
        for (StlElement stlElement : stlElements) {
            if (unique.containsKey(stlElement.getObjectId() + stlElement.getTenantId())) {
                continue;
            } else {
                unique.put(stlElement.getObjectId() + stlElement.getTenantId(), 1);
                results.add(stlElement);
            }
        }
        return results;
    }

}

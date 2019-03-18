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
import com.x.ic.msg.dao.mapper.bo.StlPolicyItem;
import com.x.ic.msg.dao.mapper.bo.StlPolicyItemExample;
import com.x.ic.msg.dao.mapper.interfaces.StlPolicyItemMapper;
import com.x.ic.msg.util.CacheKeyUtil;
import com.x.sdk.cache.base.AbstractCache;
import com.x.sdk.mcs.MCSClientFactory;
import com.x.sdk.util.CollectionUtil;

@Component
public class PolicyItemCache extends AbstractCache {

	private static final Logger log = LogManager.getLogger(PolicyItemCache.class);
	
	@Autowired
	private StlPolicyItemMapper stlPolicyItemMapper;
	
    @Override
    public void write() throws Exception {

        StlPolicyItemExample stlPolicyItemCriteria = new StlPolicyItemExample();
        List<StlPolicyItem> list = stlPolicyItemMapper.selectByExample(stlPolicyItemCriteria);
        if(CollectionUtil.isEmpty(list)){
			return;
		}
        Map<String, List<StlPolicyItem>> itemMap = new HashMap<>();
        for (StlPolicyItem item : list) {
        	String key = CacheKeyUtil.getPolicyItemByPolicyId(item.getTenantId(), item.getPolicyId());
			if(itemMap.containsKey(key)){
				itemMap.get(key).add(item);
			}else{
				List<StlPolicyItem> items = new ArrayList<>();
				items.add(item);
				itemMap.put(key, items);
			}
		}
        for (String key : itemMap.keySet()) {
        	String value = JSON.toJSONString(itemMap.get(key));
        	MCSClientFactory.getCacheClient(SmcCacheConstant.MSDNS).hset(SmcCacheConstant.NameSpace.POLICY_ITEM_CACHE, key, value);
        	log.debug("NameSpace:{}",SmcCacheConstant.NameSpace.POLICY_ITEM_CACHE);
			log.debug("key:{}",key);
			log.debug("value:{}",value);		
		}
    }
}

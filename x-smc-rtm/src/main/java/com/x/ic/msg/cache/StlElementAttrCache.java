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
import com.x.ic.msg.dao.mapper.bo.StlElementAttr;
import com.x.ic.msg.dao.mapper.bo.StlElementAttrExample;
import com.x.ic.msg.dao.mapper.interfaces.StlElementAttrMapper;
import com.x.ic.msg.util.CacheKeyUtil;
import com.x.sdk.cache.base.AbstractCache;
import com.x.sdk.mcs.MCSClientFactory;
import com.x.sdk.util.CollectionUtil;

@Component
public class StlElementAttrCache extends AbstractCache {
	
private static final Logger LOGGER = LogManager.getLogger(StlElementAttrCache.class);

private static final Logger log = LogManager.getLogger(StlElementAttrCache.class);

	@Autowired
	private StlElementAttrMapper stlElementAttrMapper;

    @Override
    public void write() throws Exception {
        StlElementAttrExample stlElementAttrCriteria = new StlElementAttrExample();
        List<StlElementAttr> stlElementAttrs = stlElementAttrMapper.selectByExample(stlElementAttrCriteria);
        if (CollectionUtil.isEmpty(stlElementAttrs)) {
            return;
        }
        
        Map<String, List<StlElementAttr>> policyMap = new HashMap<>();
        Map<String, List<StlElementAttr>> elementMap = new HashMap<>();
        for (StlElementAttr attr : stlElementAttrs) {
			
        	String elementKey = CacheKeyUtil.getElementAttrByElementId(attr.getTenantId(), attr.getElementId());
        	if(elementMap.containsKey(elementKey)){
        		elementMap.get(elementKey).add(attr);
        	}else{
        		List<StlElementAttr> attrList = new ArrayList<>();
        		attrList.add(attr);
        		elementMap.put(elementKey, attrList);
        	}
        	
        	String policyKey = CacheKeyUtil.getElementAttrByPolicyId(attr.getTenantId(), attr.getPolicyId());
        	if(policyMap.containsKey(policyKey)){
        		policyMap.get(policyKey).add(attr);
        	}else{
        		List<StlElementAttr> attrList = new ArrayList<>();
        		attrList.add(attr);
        		policyMap.put(policyKey, attrList);
        	}
        	
		}
        
        for(String key : elementMap.keySet()){
        	String value = JSON.toJSONString(elementMap.get(key));
        	MCSClientFactory.getCacheClient(SmcCacheConstant.MSDNS).hset(SmcCacheConstant.NameSpace.STL_ELEMENT_ATTR_CACHE, key, value);
        	log.debug("NameSpace:{}",SmcCacheConstant.NameSpace.ELEMENT_CACHE);
            log.debug("key:{}",key);
            log.debug("value:{}",value);
        }
        for(String key : policyMap.keySet()){
        	String value = JSON.toJSONString(policyMap.get(key));
        	MCSClientFactory.getCacheClient(SmcCacheConstant.MSDNS).hset(SmcCacheConstant.NameSpace.STL_ELEMENT_ATTR_CACHE, key, value);
        	log.debug("NameSpace:{}",SmcCacheConstant.NameSpace.ELEMENT_CACHE);
            log.debug("key:{}",key);
            log.debug("value:{}",value);
        }
        
    }

}

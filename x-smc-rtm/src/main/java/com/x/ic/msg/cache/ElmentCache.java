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
import com.alibaba.fastjson.JSONArray;
import com.x.ic.msg.constants.SmcCacheConstant;
import com.x.ic.msg.constants.SmcConstants;
import com.x.ic.msg.dao.mapper.bo.StlElement;
import com.x.ic.msg.dao.mapper.bo.StlElementExample;
import com.x.ic.msg.dao.mapper.bo.StlElementExample.Criteria;
import com.x.ic.msg.dao.mapper.interfaces.StlElementMapper;
import com.x.ic.msg.util.CacheKeyUtil;
import com.x.sdk.cache.base.AbstractCache;
import com.x.sdk.mcs.MCSClientFactory;
import com.x.sdk.util.CollectionUtil;

@Component
public class ElmentCache extends AbstractCache {

	private static final Logger log = LogManager.getLogger(ElmentCache.class);
	
	@Autowired
	private StlElementMapper stlElmentMapper;
	
	@Override
	public void write() throws Exception {
		
		StlElementExample example = new StlElementExample();
		Criteria criteria = example.createCriteria();
		criteria.andStateEqualTo(SmcConstants.StlElement.State.NORMAL);
		List<StlElement> stlElements = stlElmentMapper.selectByExample(example);
		if(CollectionUtil.isEmpty(stlElements)){
			return ;
		}
		Map<String, List<StlElement>> map = new HashMap<>();
		for (StlElement stlElement : stlElements) {
            String key = CacheKeyUtil.getElementByElementId(stlElement.getTenantId(), stlElement.getElementId());
            String value = JSON.toJSONString(stlElement);
            MCSClientFactory.getCacheClient(SmcCacheConstant.MSDNS).hset(SmcCacheConstant.NameSpace.ELEMENT_CACHE, key,value);
            log.debug("NameSpace:{}",SmcCacheConstant.NameSpace.ELEMENT_CACHE);
            log.debug("key:{}",key);
            log.debug("value:{}",value);
            
            String key2 = CacheKeyUtil.getElementByPolicyId(stlElement.getTenantId(), stlElement.getPolicyId());
            if(map.containsKey(key2)){
            	map.get(key2).add(stlElement);
            }else{
            	List<StlElement> list = new ArrayList<>();
            	list.add(stlElement);
            	map.put(key2, list);
            }
            
        }
		for(String mapKey : map.keySet()){
			String value = JSONArray.toJSONString(map.get(mapKey));
			MCSClientFactory.getCacheClient(SmcCacheConstant.MSDNS).hset(SmcCacheConstant.NameSpace.ELEMENT_CACHE, mapKey , value);

            log.debug("NameSpace:{}",SmcCacheConstant.NameSpace.ELEMENT_CACHE);
            log.debug("key:{}",mapKey);
            log.debug("value:{}",value);
		}
	}



}

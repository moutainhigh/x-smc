package com.x.ic.msg.cache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.x.ic.msg.constants.SmcCacheConstant;
import com.x.ic.msg.constants.SmcConstants;
import com.x.ic.msg.dao.mapper.bo.StlNodeElementMapping;
import com.x.ic.msg.dao.mapper.bo.StlNodeElementMappingExample;
import com.x.ic.msg.dao.mapper.interfaces.StlNodeElementMappingMapper;
import com.x.ic.msg.util.CacheKeyUtil;
import com.x.sdk.cache.base.AbstractCache;
import com.x.sdk.mcs.MCSClientFactory;
import com.x.sdk.util.CollectionUtil;

@Component
public class NodeElementMappingCache extends AbstractCache {

	private static final Logger log = LogManager.getLogger(NodeElementMappingCache.class);
	
	@Autowired
	private StlNodeElementMappingMapper stlNodeElementMappingMapper;
	
	@Override
	public void write() throws Exception {
		
		StlNodeElementMappingExample stlNodeElementMappingExample = new StlNodeElementMappingExample();
		StlNodeElementMappingExample.Criteria criteria = stlNodeElementMappingExample.createCriteria();
		criteria.andStateEqualTo(SmcConstants.StlNodeElementMapping.State.NORMAL);
		List<StlNodeElementMapping> stlNodeElementMappings = stlNodeElementMappingMapper.selectByExample(stlNodeElementMappingExample);
		if(CollectionUtil.isEmpty(stlNodeElementMappings)){
			return;
		}
		Map<String, List<StlNodeElementMapping>> stlNodeElementMappingCache = new HashMap<>();
		for (StlNodeElementMapping stlNodeElementMapping : stlNodeElementMappings) {
			String key = CacheKeyUtil.getNodeElementMappingByPolicyId(stlNodeElementMapping.getTenantId(), stlNodeElementMapping.getPolicyId());
			if(stlNodeElementMappingCache.containsKey(key)){
				stlNodeElementMappingCache.get(key).add(stlNodeElementMapping);
			}else{
				List<StlNodeElementMapping> stlNodeElementMappingList = new ArrayList<>();
				stlNodeElementMappingList.add(stlNodeElementMapping);
				stlNodeElementMappingCache.put(key, stlNodeElementMappingList);
			}
			
		}
		for(String key : stlNodeElementMappingCache.keySet()){
			String val = JSON.toJSONString(stlNodeElementMappingCache.get(key));
			MCSClientFactory.getCacheClient(SmcCacheConstant.MSDNS).hset(SmcCacheConstant.NameSpace.NODE_ELEMENT_MAPPING_CACHE, key, val);
			log.debug("NameSpace:{}",SmcCacheConstant.NameSpace.NODE_ELEMENT_MAPPING_CACHE);
			log.debug("key:{}",key);
			log.debug("value:{}",val);
		}
		
	}

}

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
import com.x.ic.msg.dao.mapper.bo.StlNode;
import com.x.ic.msg.dao.mapper.bo.StlNodeExample;
import com.x.ic.msg.dao.mapper.bo.StlNodeExample.Criteria;
import com.x.ic.msg.dao.mapper.interfaces.StlNodeMapper;
import com.x.ic.msg.util.CacheKeyUtil;
import com.x.sdk.cache.base.AbstractCache;
import com.x.sdk.mcs.MCSClientFactory;
import com.x.sdk.util.CollectionUtil;

@Component
public class NodeCache extends AbstractCache {
	
	private static final Logger log = LogManager.getLogger(NodeCache.class);
	
	@Autowired
	private StlNodeMapper stlNodeMapper;
	
	@Override
	public void write() throws Exception {
		
		StlNodeExample stlNodeExample = new StlNodeExample();
		Criteria criteria = stlNodeExample.createCriteria();
		criteria.andStateEqualTo(SmcConstants.StlNode.State.NORMAL);
		List<StlNode> stlNodes = stlNodeMapper.selectByExample(stlNodeExample);
		if(CollectionUtil.isEmpty(stlNodes)){
			return;
		}
		Map<String, List<StlNode>> mapCache = new HashMap<>();
		
		for (StlNode stlNode : stlNodes) {
			String key = CacheKeyUtil.getNodeByContractId(stlNode.getTenantId(), stlNode.getContractId());
			
			if(mapCache.containsKey(key)){
				mapCache.get(key).add(stlNode);
			}else{
				List<StlNode> stlNodeList = new ArrayList<>();
				stlNodeList.add(stlNode);
				mapCache.put(key, stlNodeList);
			}
			String key2 = CacheKeyUtil.getNodeByNodeId(stlNode.getTenantId(), stlNode.getNodeId());
			String value = JSON.toJSONString(stlNode);
			MCSClientFactory.getCacheClient(SmcCacheConstant.MSDNS).hset(SmcCacheConstant.NameSpace.NODE_CACHE, key2, value);
			
			log.debug("NameSpace:{}",SmcCacheConstant.NameSpace.NODE_CACHE);
            log.debug("key:{}",key2);
            log.debug("value:{}",value);
		}
		for(String key : mapCache.keySet()){
			String val = JSON.toJSONString(mapCache.get(key));
			MCSClientFactory.getCacheClient(SmcCacheConstant.MSDNS).hset(SmcCacheConstant.NameSpace.NODE_CACHE, key, val);
			log.debug("NameSpace:{}",SmcCacheConstant.NameSpace.NODE_CACHE);
            log.debug("key:{}",key);
            log.debug("value:{}",val);
		}
		

	}

}

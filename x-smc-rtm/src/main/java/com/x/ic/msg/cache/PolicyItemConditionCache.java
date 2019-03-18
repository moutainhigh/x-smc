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
import com.x.ic.msg.dao.mapper.bo.StlNode;
import com.x.ic.msg.dao.mapper.bo.StlPolicyItemCondition;
import com.x.ic.msg.dao.mapper.bo.StlPolicyItemConditionExample;
import com.x.ic.msg.dao.mapper.interfaces.StlNodeMapper;
import com.x.ic.msg.dao.mapper.interfaces.StlPolicyItemConditionMapper;
import com.x.ic.msg.util.CacheKeyUtil;
import com.x.sdk.cache.base.AbstractCache;
import com.x.sdk.mcs.MCSClientFactory;
import com.x.sdk.util.CollectionUtil;

@Component
public class PolicyItemConditionCache extends AbstractCache {

	private static final Logger log = LogManager.getLogger(PolicyItemConditionCache.class);
	
	@Autowired
	private StlPolicyItemConditionMapper stlPolicyItemConditionMapper;
	@Autowired
	private StlNodeMapper stlNodeMapper;
    @Override
    public void write() throws Exception {

    	StlPolicyItemConditionExample stlPolicyItemConditionCriteria = new StlPolicyItemConditionExample();
        List<StlPolicyItemCondition> list = stlPolicyItemConditionMapper.selectByExample(stlPolicyItemConditionCriteria);
        if(CollectionUtil.isEmpty(list)){
        	return ;
        }
        
        Map<String, List<StlPolicyItemCondition>> tenantMap = new HashMap<>();
        Map<String, List<StlPolicyItemCondition>> formatMap = new HashMap<>();
        Map<String, List<StlPolicyItemCondition>> contractMap = new HashMap<>();
        for (StlPolicyItemCondition condition : list) {
			String tenantKey = CacheKeyUtil.getPolicyItemConditionByTenantId(condition.getTenantId());
			String formatKey = CacheKeyUtil.getPolicyItemConditionByDataFormat(condition.getTenantId(), condition.getDataFormat());
			if(tenantMap.containsKey(tenantKey)){
				tenantMap.get(tenantKey).add(condition);
			}else{
				List<StlPolicyItemCondition> conditions = new ArrayList<>();
				conditions.add(condition);
				tenantMap.put(tenantKey, conditions);
			}
			if(formatMap.containsKey(formatKey)){
				formatMap.get(formatKey).add(condition);
			}else{
				List<StlPolicyItemCondition> conditions = new ArrayList<>();
				conditions.add(condition);
				formatMap.put(formatKey, conditions);
			}
			StlNode node = stlNodeMapper.selectByPrimaryKey(condition.getElementId());
			if(node!=null){
				String contractKey = CacheKeyUtil.getPolicyItemConditionByContractId(condition.getTenantId(),condition.getDataFormat(), node.getContractId());
            	if(contractMap.containsKey(contractKey)){
            		contractMap.get(contractKey).add(condition);
            	}else{
            		List<StlPolicyItemCondition> conditionList = new ArrayList<>();
            		conditionList.add(condition);
            		contractMap.put(contractKey, conditionList);
            	}
        	}
		}
        for (String key : tenantMap.keySet()) {
			String value = JSON.toJSONString(tenantMap.get(key));
			MCSClientFactory.getCacheClient(SmcCacheConstant.MSDNS).hset(SmcCacheConstant.NameSpace.POLICY_ITEM_CONDITION_CACHE, key, value);
			log.debug("NameSpace:{}" , SmcCacheConstant.NameSpace.POLICY_ITEM_CONDITION_CACHE);
            log.debug("key:{}" , key);
            log.debug("value:{}" , value);
			
		}
        
        for (String key : formatMap.keySet()) {
			String value = JSON.toJSONString(formatMap.get(key));
			
			MCSClientFactory.getCacheClient(SmcCacheConstant.MSDNS).hset(SmcCacheConstant.NameSpace.POLICY_ITEM_CONDITION_CACHE, key, value);
			log.debug("NameSpace:{}" , SmcCacheConstant.NameSpace.POLICY_ITEM_CONDITION_CACHE);
            log.debug("key:{}" , key);
            log.debug("value:{}" , value);
			
		}
        for (String key : contractMap.keySet()) {
			String value = JSON.toJSONString(contractMap.get(key));
			
			MCSClientFactory.getCacheClient(SmcCacheConstant.MSDNS).hset(SmcCacheConstant.NameSpace.POLICY_ITEM_CONDITION_CACHE, key, value);
			log.debug("NameSpace:{}" , SmcCacheConstant.NameSpace.POLICY_ITEM_CONDITION_CACHE);
            log.debug("key:{}" , key);
            log.debug("value:{}" , value);
			
		}
        
    }

}

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
import com.x.ic.msg.dao.mapper.bo.StlPolicyItemPlan;
import com.x.ic.msg.dao.mapper.bo.StlPolicyItemPlanExample;
import com.x.ic.msg.dao.mapper.interfaces.StlPolicyItemPlanMapper;
import com.x.ic.msg.util.CacheKeyUtil;
import com.x.sdk.cache.base.AbstractCache;
import com.x.sdk.mcs.MCSClientFactory;
import com.x.sdk.util.CollectionUtil;

@Component
public class PolicyItemPlanCache extends AbstractCache {

	private static final Logger log = LogManager.getLogger(PolicyItemPlanCache.class);
	
	@Autowired
	private StlPolicyItemPlanMapper stlPolicyItemPlanMapper;
	
    @Override
    public void write() throws Exception {
        StlPolicyItemPlanExample stlPolicyItemPlanCriteria = new StlPolicyItemPlanExample();
        List<StlPolicyItemPlan> list = stlPolicyItemPlanMapper.selectByExample(
                stlPolicyItemPlanCriteria);
        
        if(CollectionUtil.isEmpty(list)){
			return;
		}
        
        Map<String, List<StlPolicyItemPlan>> planMap = new HashMap<>();
        
        for (StlPolicyItemPlan plan : list) {
			String key = CacheKeyUtil.getPolicyItemPlanByPolicyId(plan.getTenantId(), plan.getPolicyId());
			if(planMap.containsKey(key)){
				planMap.get(key).add(plan);
			}else{
				List<StlPolicyItemPlan> plans = new ArrayList<>();
				plans.add(plan);
				planMap.put(key, plans);
			}
		}
        
        for(String key : planMap.keySet()){
        	String value = JSON.toJSONString(planMap.get(key));
        	MCSClientFactory.getCacheClient(SmcCacheConstant.MSDNS).hset(SmcCacheConstant.NameSpace.POLICY_ITEM_PLAN_CACHE, key, value);
        	log.debug("NameSpace:{}",SmcCacheConstant.NameSpace.POLICY_ITEM_PLAN_CACHE);
			log.debug("key:{}",key);
			log.debug("value:{}",value);	
        }
    }

}

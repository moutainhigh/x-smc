package com.x.ic.msg.cache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONArray;
import com.x.ic.msg.constants.SmcCacheConstant;
import com.x.ic.msg.dao.mapper.bo.StlPolicyBillPlan;
import com.x.ic.msg.dao.mapper.bo.StlPolicyBillPlanCriteria;
import com.x.ic.msg.dao.mapper.interfaces.StlPolicyBillPlanMapper;
import com.x.ic.smc.sdk.cache.constants.CacheConstant;
import com.x.ic.smc.sdk.cache.util.CacheKeyUtil;
import com.x.sdk.cache.base.AbstractCache;
import com.x.sdk.mcs.MCSClientFactory;
import com.x.sdk.util.CollectionUtil;

@Component
public class PolicyBillPlanCache extends AbstractCache{

	private static final Logger log = LogManager.getLogger(PolicyBillPlanCache.class);
	
	@Autowired
	private StlPolicyBillPlanMapper stlPolicyBillPlanMapper;
	
	@Override
	public void write() throws Exception {
		// TODO Auto-generated method stub
		StlPolicyBillPlanCriteria example = new StlPolicyBillPlanCriteria();
		List<StlPolicyBillPlan> list = stlPolicyBillPlanMapper.selectByExample(example);
		if(CollectionUtil.isEmpty(list)) {
			return;
		}
		Map<String, List<StlPolicyBillPlan>> map = new HashMap<String, List<StlPolicyBillPlan>>();
		for(StlPolicyBillPlan billPlan:list) {
			String key = CacheKeyUtil.getPolicyBillPlanByPolicyId(billPlan.getTenantId(), String.valueOf(billPlan.getPolicyId()));
			List<StlPolicyBillPlan> billPlanList = map.get(key); 
			if(CollectionUtil.isEmpty(billPlanList)) {
				billPlanList = new ArrayList<>();
			}
			billPlanList.add(billPlan);
			map.put(key, billPlanList);
		}
		for(Map.Entry<String, List<StlPolicyBillPlan>> entry:map.entrySet()) {
			MCSClientFactory.getCacheClient(SmcCacheConstant.MSDNS).hset(CacheConstant.NameSpace.POLICY_BILL_PLAN_CACHE, 
					entry.getKey(), JSONArray.toJSONString(entry.getValue()));
			log.debug("NameSpace:{}",SmcCacheConstant.NameSpace.POLICY_CACHE);
	        log.debug("key:{}",entry.getKey());
	        log.debug("value:{}",JSONArray.toJSONString(entry.getValue()));
		}
		
	}

}

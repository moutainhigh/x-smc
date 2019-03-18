package com.x.ic.msg.cache;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.x.ic.msg.constants.SmcCacheConstant;
import com.x.ic.msg.dao.mapper.bo.StlPolicyTaskCycle;
import com.x.ic.msg.dao.mapper.bo.StlPolicyTaskCycleExample;
import com.x.ic.msg.dao.mapper.interfaces.StlPolicyTaskCycleMapper;
import com.x.ic.msg.util.CacheKeyUtil;
import com.x.sdk.cache.base.AbstractCache;
import com.x.sdk.mcs.MCSClientFactory;

@Component
public class PolicyTaskCycle extends AbstractCache {
	private static final Logger log = LogManager.getLogger(PolicyTaskCycle.class);

	@Autowired
	private StlPolicyTaskCycleMapper policyTaskCycleMapper;
	
	@Override
	public void write() throws Exception {
		StlPolicyTaskCycleExample example = new StlPolicyTaskCycleExample();
		List<StlPolicyTaskCycle> list = policyTaskCycleMapper.selectByExample(example);
		
		for(StlPolicyTaskCycle cycle : list){
			String key = CacheKeyUtil.getPolicyTaskCycleByPolicyId(cycle.getTenantId(), cycle.getPolicyId());
			String value = JSON.toJSONString(cycle);
			MCSClientFactory.getCacheClient(SmcCacheConstant.MSDNS).hset(SmcCacheConstant.NameSpace.POLICY_TASK_CYCLE, key, value);
			log.debug("NameSpace:{}",SmcCacheConstant.NameSpace.NODE_ELEMENT_MAPPING_CACHE);
			log.debug("key:{}",key);
			log.debug("value:{}",value);
		}
		
		
		
		
	}
	
	
}

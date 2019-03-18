package com.x.ic.msg.cache;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.x.ic.msg.constants.SmcCacheConstant;
import com.x.ic.msg.dao.mapper.bo.StlPolicyItemPlanInstn;
import com.x.ic.msg.dao.mapper.bo.StlPolicyItemPlanInstnExample;
import com.x.ic.msg.dao.mapper.interfaces.StlPolicyItemPlanInstnMapper;
import com.x.ic.msg.util.CacheKeyUtil;
import com.x.sdk.cache.base.AbstractCache;
import com.x.sdk.mcs.MCSClientFactory;

@Component
public class PolicyItemPlanInstnCache extends AbstractCache  {
	private static final Logger log = LogManager.getLogger(PolicyItemPlanInstnCache.class);

	@Autowired
	private StlPolicyItemPlanInstnMapper planInstnMapper;
	
	@Override
	public void write() throws Exception {
		
		StlPolicyItemPlanInstnExample example = new StlPolicyItemPlanInstnExample();
		
		List<StlPolicyItemPlanInstn> ins = planInstnMapper.selectByExample(example);
		
		for(StlPolicyItemPlanInstn in : ins){
			String key = CacheKeyUtil.getPolicyItemPlanInstnByPolicyId(in.getTenantId(), in.getPolicyId(), in.getObjectCode());
			String value = JSON.toJSONString(in);
			MCSClientFactory.getCacheClient(SmcCacheConstant.MSDNS).hset(SmcCacheConstant.NameSpace.POLICY_ITEM_PLAN_CACHE_INSTN, key, value);
			log.debug("NameSpace:{}",SmcCacheConstant.NameSpace.NODE_CACHE);
            log.debug("key:{}",key);
            log.debug("value:{}",value);
		}
		
		
	}




}

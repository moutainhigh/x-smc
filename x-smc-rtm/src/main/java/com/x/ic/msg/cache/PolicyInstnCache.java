package com.x.ic.msg.cache;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.x.ic.msg.constants.SmcCacheConstant;
import com.x.ic.msg.dao.mapper.bo.StlPolicyInstn;
import com.x.ic.msg.dao.mapper.bo.StlPolicyInstnExample;
import com.x.ic.msg.dao.mapper.interfaces.StlPolicyInstnMapper;
import com.x.ic.msg.util.CacheKeyUtil;
import com.x.sdk.cache.base.AbstractCache;
import com.x.sdk.mcs.MCSClientFactory;

@Component
public class PolicyInstnCache extends AbstractCache {

	private static final Logger log = LogManager.getLogger(PolicyInstnCache.class);
	
	@Autowired
	private StlPolicyInstnMapper instnMapper;
	
	@Override
	public void write() throws Exception {
		StlPolicyInstnExample example = new StlPolicyInstnExample();
		List<StlPolicyInstn> list = instnMapper.selectByExample(example);
		for(StlPolicyInstn in : list){
			String key = CacheKeyUtil.getPolicyInstnByObjectCode(in.getTenantId(), in.getPolicyId(), in.getObjectCode());
			String value = JSON.toJSONString(in);
			MCSClientFactory.getCacheClient(SmcCacheConstant.MSDNS).hset(SmcCacheConstant.NameSpace.POLICY_INSTN_CACHE, key, value);
        	log.debug("NameSpace:{}",SmcCacheConstant.NameSpace.POLICY_INSTN_CACHE);
			log.debug("key:{}",key);
			log.debug("value:{}",value);
		}
		
	}

}

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
import com.x.ic.msg.dao.mapper.bo.StlPolicy;
import com.x.ic.msg.dao.mapper.bo.StlPolicyExample;
import com.x.ic.msg.dao.mapper.interfaces.StlPolicyMapper;
import com.x.ic.msg.util.CacheKeyUtil;
import com.x.sdk.cache.base.AbstractCache;
import com.x.sdk.mcs.MCSClientFactory;
import com.x.sdk.util.CollectionUtil;

@Component
public class PolicyCache extends AbstractCache {

	private static final Logger log = LogManager.getLogger(PolicyCache.class);
	
	@Autowired
	private StlPolicyMapper stlPolicyMapper;
	
    @Override
    public void write() throws Exception {
        StlPolicyExample criteria = new StlPolicyExample();
        criteria.createCriteria().andStateEqualTo(SmcConstants.StlPolicy.State.NORMAL);
        List<StlPolicy> stlPolicies = stlPolicyMapper.selectByExample(criteria);
        if (CollectionUtil.isEmpty(stlPolicies)) {
            return;
        }
        
        Map<String, List<StlPolicy>> tenantMap = new HashMap<>();
        for (StlPolicy stlPolicy : stlPolicies) {
            String keyOne = CacheKeyUtil.getPolicyKeyByPolicyId(stlPolicy.getTenantId(), stlPolicy.getPolicyId());
            String valOne = JSON.toJSONString(stlPolicy);
            MCSClientFactory.getCacheClient(SmcCacheConstant.MSDNS).hset(SmcCacheConstant.NameSpace.POLICY_CACHE, keyOne.toString(),
                    valOne);
            
            log.debug("NameSpace:{}",SmcCacheConstant.NameSpace.POLICY_CACHE);
            log.debug("key:{}",keyOne.toString());
            log.debug("value:{}",valOne);
            
            String key2 = CacheKeyUtil.getPolicyKeyByTenantId(stlPolicy.getTenantId());
            
            if(tenantMap.containsKey(key2)){
            	tenantMap.get(key2).add(stlPolicy);
            }else{
            	List<StlPolicy> policys = new ArrayList<>();
            	policys.add(stlPolicy);
            	tenantMap.put(key2, policys);
            }
           
        }
        
        for(String key : tenantMap.keySet()){
        	String value = JSON.toJSONString(tenantMap.get(key));
        	MCSClientFactory.getCacheClient(SmcCacheConstant.MSDNS).hset(SmcCacheConstant.NameSpace.POLICY_CACHE , key , value);
        	log.debug("NameSpace:{}" , SmcCacheConstant.NameSpace.POLICY_CACHE);
            log.debug("key:{}" , key);
            log.debug("value:{}" , value);
        }
        
       
    }

}

package com.x.ic.smc.cache;

import java.util.List;

import org.springframework.stereotype.Component;

import com.x.sdk.cache.base.AbstractCache;
import com.x.sdk.util.CollectionUtil;
import com.x.ic.smc.constants.SmcCacheConstant;
import com.x.ic.smc.constants.SmcConstants;
import com.x.ic.smc.dao.mapper.bo.StlPolicy;
import com.x.ic.smc.dao.mapper.bo.StlPolicyCriteria;
import com.x.ic.smc.dao.mapper.factory.MapperFactory;
import com.x.ic.smc.util.RedisUtil;
import com.alibaba.fastjson.JSON;

@Component
public class PolicyCache extends AbstractCache {

    @Override
    public void write() throws Exception {
        StlPolicyCriteria criteria = new StlPolicyCriteria();
        criteria.createCriteria().andStateEqualTo(SmcConstants.StlPolicy.State.NORMAL);
        List<StlPolicy> stlPolicies = MapperFactory.getStlPolicyMapper().selectByExample(criteria);
        if (CollectionUtil.isEmpty(stlPolicies)) {
            return;
        }
        for (StlPolicy stlPolicy : stlPolicies) {
            // key:tenantId.policyCode,value:stlPolicy
            StringBuilder keyOne = new StringBuilder();
            keyOne.append(stlPolicy.getTenantId());
            keyOne.append(".");
            keyOne.append(stlPolicy.getPolicyCode());
            RedisUtil.getCacheClient().hset(SmcCacheConstant.NameSpace.POLICY_CACHE, keyOne.toString(),
                    JSON.toJSONString(stlPolicy));
        }
        RedisUtil.getCacheClient().hset(SmcCacheConstant.NameSpace.POLICY_CACHE, SmcCacheConstant.POLICY_ALL,
                JSON.toJSONString(stlPolicies));
    }

}

package com.x.ic.smc.cache;

import java.util.List;

import org.springframework.stereotype.Component;

import com.x.sdk.cache.base.AbstractCache;
import com.x.ic.smc.constants.SmcCacheConstant;
import com.x.ic.smc.dao.mapper.bo.StlPolicyItemCondition;
import com.x.ic.smc.dao.mapper.bo.StlPolicyItemConditionCriteria;
import com.x.ic.smc.dao.mapper.factory.MapperFactory;
import com.x.ic.smc.util.RedisUtil;
import com.alibaba.fastjson.JSON;

@Component
public class PolicyItemConditionCache extends AbstractCache {

    @Override
    public void write() throws Exception {
        // TODO Auto-generated method stub
        StlPolicyItemConditionCriteria stlPolicyItemConditionCriteria = new StlPolicyItemConditionCriteria();
        List<StlPolicyItemCondition> list = MapperFactory.getStlPolicyItemConditionMapper()
                .selectByExample(stlPolicyItemConditionCriteria);
        RedisUtil.getCacheClient().hset(SmcCacheConstant.NameSpace.POLICY_CACHE,
                SmcCacheConstant.POLICY_ITEM_CONDITION, JSON.toJSONString(list));

    }

}

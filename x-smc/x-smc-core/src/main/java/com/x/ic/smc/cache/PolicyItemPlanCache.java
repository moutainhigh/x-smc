package com.x.ic.smc.cache;

import java.util.List;

import org.springframework.stereotype.Component;

import com.x.sdk.cache.base.AbstractCache;
import com.x.ic.smc.constants.SmcCacheConstant;
import com.x.ic.smc.dao.mapper.bo.StlPolicyItemPlan;
import com.x.ic.smc.dao.mapper.bo.StlPolicyItemPlanCriteria;
import com.x.ic.smc.dao.mapper.factory.MapperFactory;
import com.x.ic.smc.util.RedisUtil;
import com.alibaba.fastjson.JSON;

@Component
public class PolicyItemPlanCache extends AbstractCache {

    @Override
    public void write() throws Exception {
        // TODO Auto-generated method stub
        StlPolicyItemPlanCriteria stlPolicyItemPlanCriteria = new StlPolicyItemPlanCriteria();
        List<StlPolicyItemPlan> list = MapperFactory.getStlPolicyItemPlanMapper().selectByExample(
                stlPolicyItemPlanCriteria);
        RedisUtil.getCacheClient().hset(SmcCacheConstant.NameSpace.POLICY_CACHE,
                SmcCacheConstant.POLICY_ITEM_PLAN, JSON.toJSONString(list));

    }

}

package com.x.ic.smc.cache;

import java.util.List;

import org.springframework.stereotype.Component;

import com.x.sdk.cache.base.AbstractCache;
import com.x.ic.smc.constants.SmcCacheConstant;
import com.x.ic.smc.dao.mapper.bo.StlPolicyItem;
import com.x.ic.smc.dao.mapper.bo.StlPolicyItemCriteria;
import com.x.ic.smc.dao.mapper.factory.MapperFactory;
import com.x.ic.smc.util.RedisUtil;
import com.alibaba.fastjson.JSON;

@Component
public class PolicyItemCache extends AbstractCache {

    @Override
    public void write() throws Exception {
        // TODO Auto-generated method stub
        StlPolicyItemCriteria stlPolicyItemCriteria = new StlPolicyItemCriteria();
        List<StlPolicyItem> list = MapperFactory.getStlPolicyItemMapper().selectByExample(
                stlPolicyItemCriteria);
        RedisUtil.getCacheClient().hset(SmcCacheConstant.NameSpace.POLICY_CACHE, SmcCacheConstant.POLICY_ITEM,
                JSON.toJSONString(list));

    }

}

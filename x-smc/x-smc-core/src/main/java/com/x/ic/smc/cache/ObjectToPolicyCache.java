package com.x.ic.smc.cache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import com.x.sdk.cache.base.AbstractCache;
import com.x.ic.smc.constants.SmcCacheConstant;
import com.x.ic.smc.dao.mapper.bo.StlPolicyItemCondition;
import com.x.ic.smc.dao.mapper.bo.StlPolicyItemConditionCriteria;
import com.x.ic.smc.dao.mapper.bo.StlPolicyItemPlan;
import com.x.ic.smc.dao.mapper.bo.StlPolicyItemPlanCriteria;
import com.x.ic.smc.dao.mapper.factory.MapperFactory;
import com.x.ic.smc.util.RedisUtil;
import com.alibaba.fastjson.JSON;

@Component
public class ObjectToPolicyCache extends AbstractCache {
private static final Logger LOGGER = LogManager.getLogger(ObjectToPolicyCache.class);
    @Override
    public void write() throws Exception {

        StlPolicyItemConditionCriteria stlPolicyItemConditionCriteria = new StlPolicyItemConditionCriteria();
        List<StlPolicyItemCondition> stlPolicyItemConditions = MapperFactory
                .getStlPolicyItemConditionMapper().selectByExample(stlPolicyItemConditionCriteria);

        StlPolicyItemPlanCriteria stlPolicyItemPlanCriteria = new StlPolicyItemPlanCriteria();
        List<StlPolicyItemPlan> stlPolicyItemPlans = MapperFactory.getStlPolicyItemPlanMapper()
                .selectByExample(stlPolicyItemPlanCriteria);
        if ((stlPolicyItemConditions.size()) == 0 && (stlPolicyItemPlans.size() == 0)) {
            return;
        }
        List<String> UniqueTenantIdAndObjectIds = UniqueData(stlPolicyItemConditions,
                stlPolicyItemPlans);
        if (UniqueTenantIdAndObjectIds.size() != 0) {

            for (String tenantIdAndObjectId : UniqueTenantIdAndObjectIds) {

                String tenantId = tenantIdAndObjectId.split("_")[0];
                String objectId = tenantIdAndObjectId.split("_")[1];
                List<String> uniqueTenantIdAndPolicyIds = UniquePolicyIdData(objectId, tenantId);
                StringBuilder sBuilder = new StringBuilder();
                sBuilder.append(tenantId).append("_").append(objectId);
                LOGGER.info(sBuilder.toString());
                LOGGER.info(JSON.toJSONString(uniqueTenantIdAndPolicyIds));

                RedisUtil.getCacheClient().hset(SmcCacheConstant.NameSpace.OBJECT_POLICY_CACHE,
                        sBuilder.toString(), JSON.toJSONString(uniqueTenantIdAndPolicyIds));
            }
        }
    }

    private List<String> UniquePolicyIdData(String objectId, String tenantId) {
        // 查询stl_policy_item_plan和stl_policy_item_condition去重政策ID
        List<String> result = null;
        Map<String, Integer> unique = new HashMap<String, Integer>();
        StlPolicyItemConditionCriteria stlPolicyItemConditionCriteria = new StlPolicyItemConditionCriteria();
        StlPolicyItemConditionCriteria.Criteria criteria = stlPolicyItemConditionCriteria
                .createCriteria();
        criteria.andTenantIdEqualTo(tenantId);
        criteria.andObjectIdEqualTo(objectId);
        List<StlPolicyItemCondition> stlPolicyItemConditions = MapperFactory
                .getStlPolicyItemConditionMapper().selectByExample(stlPolicyItemConditionCriteria);

        StlPolicyItemPlanCriteria stlPolicyItemPlanCriteria = new StlPolicyItemPlanCriteria();
        StlPolicyItemPlanCriteria.Criteria criteria2 = stlPolicyItemPlanCriteria.createCriteria();
        criteria2.andTenantIdEqualTo(tenantId);
        criteria2.andObjectIdEqualTo(objectId);
        List<StlPolicyItemPlan> stlPolicyItemPlans = MapperFactory.getStlPolicyItemPlanMapper()
                .selectByExample(stlPolicyItemPlanCriteria);
        if ((stlPolicyItemConditions.size() == 0) && (stlPolicyItemPlans.size() == 0)) {
            return result;
        } else {
            result = new ArrayList<String>();
            if (stlPolicyItemConditions.size() != 0) {
                for (StlPolicyItemCondition stlPolicyItemCondition : stlPolicyItemConditions) {
                    if (unique.containsKey(stlPolicyItemCondition.getTenantId()
                            + stlPolicyItemCondition.getPolicyId().toString())) {
                        continue;
                    } else {
                        unique.put(stlPolicyItemCondition.getTenantId()
                                + stlPolicyItemCondition.getPolicyId().toString(), 1);
                        result.add(stlPolicyItemCondition.getTenantId() + "_"
                                + Long.toString(stlPolicyItemCondition.getPolicyId()));
                    }
                }
            }

            if (stlPolicyItemPlans.size() != 0) {
                for (StlPolicyItemPlan stlPolicyItemPlan : stlPolicyItemPlans) {
                    if (unique.containsKey(stlPolicyItemPlan.getTenantId()
                            + stlPolicyItemPlan.getPolicyId().toString())) {
                        continue;
                    } else {
                        unique.put(stlPolicyItemPlan.getTenantId()
                                + stlPolicyItemPlan.getPolicyId().toString(), 1);
                        result.add(stlPolicyItemPlan.getTenantId() + "_"
                                + Long.toString(stlPolicyItemPlan.getPolicyId()));
                    }
                }
            }
        }
        return result;
    }

    private List<String> UniqueData(List<StlPolicyItemCondition> stlPolicyItemConditions,
            List<StlPolicyItemPlan> stlPolicyItemPlans) {
        List<String> results = new ArrayList<String>();
        Map<String, Integer> unique = new HashMap<String, Integer>();
        if (stlPolicyItemConditions.size() != 0) {
            for (StlPolicyItemCondition stlPolicyItemCondition : stlPolicyItemConditions) {
                if (unique.containsKey(stlPolicyItemCondition.getTenantId()
                        + stlPolicyItemCondition.getObjectId())) {
                    continue;
                } else {
                    unique.put(
                            stlPolicyItemCondition.getTenantId()
                                    + stlPolicyItemCondition.getObjectId(), 1);
                    results.add(stlPolicyItemCondition.getTenantId() + "_"
                            + stlPolicyItemCondition.getObjectId());
                }
            }
        }
        if (stlPolicyItemPlans.size() != 0) {
            for (StlPolicyItemPlan stlPolicyItemPlan : stlPolicyItemPlans) {
                if (unique.containsKey(stlPolicyItemPlan.getTenantId()
                        + stlPolicyItemPlan.getObjectId())) {
                    continue;
                } else {
                    unique.put(stlPolicyItemPlan.getTenantId() + stlPolicyItemPlan.getObjectId(), 1);
                    results.add(stlPolicyItemPlan.getTenantId() + "_"
                            + stlPolicyItemPlan.getObjectId());
                }
            }
        }
        return results;
    }
}

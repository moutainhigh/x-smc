package com.x.ic.msg.cache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.x.ic.msg.constants.SmcCacheConstant;
import com.x.ic.msg.dao.mapper.bo.StlElement;
import com.x.ic.msg.dao.mapper.bo.StlElementExample;
import com.x.ic.msg.dao.mapper.bo.StlPolicyItemCondition;
import com.x.ic.msg.dao.mapper.bo.StlPolicyItemConditionExample;
import com.x.ic.msg.dao.mapper.bo.StlPolicyItemPlan;
import com.x.ic.msg.dao.mapper.bo.StlPolicyItemPlanExample;
import com.x.ic.msg.dao.mapper.interfaces.StlElementMapper;
import com.x.ic.msg.dao.mapper.interfaces.StlPolicyItemConditionMapper;
import com.x.ic.msg.dao.mapper.interfaces.StlPolicyItemPlanMapper;
import com.x.sdk.cache.base.AbstractCache;
import com.x.sdk.mcs.MCSClientFactory;
import com.alibaba.fastjson.JSON;

//@Component
public class PolicyToElementCache extends AbstractCache {

	@Autowired
	private StlPolicyItemConditionMapper stlPolicyItemConditionMapper;
	@Autowired
	private StlPolicyItemPlanMapper stlPolicyItemPlanMapper;
	@Autowired
	private StlElementMapper stlElementMapper;
	
	
    @Override
    public void write() throws Exception {

        StlPolicyItemConditionExample stlPolicyItemConditionCriteria = new StlPolicyItemConditionExample();
        List<StlPolicyItemCondition> stlPolicyItemConditions = stlPolicyItemConditionMapper.selectByExample(stlPolicyItemConditionCriteria);

        StlPolicyItemPlanExample stlPolicyItemPlanCriteria = new StlPolicyItemPlanExample();
        List<StlPolicyItemPlan> stlPolicyItemPlans =stlPolicyItemPlanMapper.selectByExample(stlPolicyItemPlanCriteria);
        if ((stlPolicyItemConditions.size()) == 0 && (stlPolicyItemPlans.size() == 0)) {
            return;
        }
        List<String> uniqueTenantIdAndPolicyIdAndObjectIds = UniqueData(stlPolicyItemConditions,
                stlPolicyItemPlans);
        if (uniqueTenantIdAndPolicyIdAndObjectIds.size() != 0) {

            for (String uniqueTenantIdAndPolicyIdAndObjectId : uniqueTenantIdAndPolicyIdAndObjectIds) {

                String tenantId = uniqueTenantIdAndPolicyIdAndObjectId.split("_")[0];
                String policyId = uniqueTenantIdAndPolicyIdAndObjectId.split("_")[1];
                String objectId = uniqueTenantIdAndPolicyIdAndObjectId.split("_")[2];
                String uniqueElements = getElements(uniqueTenantIdAndPolicyIdAndObjectId);
                StringBuilder sBuilder = new StringBuilder();
                sBuilder.append(tenantId).append("_").append(policyId).append("_").append(objectId);
                MCSClientFactory.getCacheClient(SmcCacheConstant.MSDNS).hset(SmcCacheConstant.NameSpace.POLICY_ELEMENT_CACHE,
                        sBuilder.toString(), uniqueElements);
            }
        }
    }

    private String getElements(String tenantIdAndPolicyId) {

        String tenantId = tenantIdAndPolicyId.split("_")[0];
        Long policyId = Long.parseLong(tenantIdAndPolicyId.split("_")[1]);
        String objectId = tenantIdAndPolicyId.split("_")[2];
        Map<String, Integer> unique = new HashMap<String, Integer>();
        List<StlElement> stlElements = null;

        //StlElementMapper mapper = MapperFactory.getElementMapper();

        StlPolicyItemConditionExample stlPolicyItemConditionCriteria = new StlPolicyItemConditionExample();
        StlPolicyItemConditionExample.Criteria criteria = stlPolicyItemConditionCriteria
                .createCriteria();
        criteria.andTenantIdEqualTo(tenantId);
        criteria.andPolicyIdEqualTo(policyId);
        criteria.andObjectIdEqualTo(objectId);
        List<StlPolicyItemCondition> stlPolicyItemConditions = stlPolicyItemConditionMapper.selectByExample(stlPolicyItemConditionCriteria);

        StlPolicyItemPlanExample stlPolicyItemPlanCriteria = new StlPolicyItemPlanExample();
        StlPolicyItemPlanExample.Criteria criteria2 = stlPolicyItemPlanCriteria.createCriteria();
        criteria2.andTenantIdEqualTo(tenantId);
        criteria2.andPolicyIdEqualTo(policyId);
        criteria2.andObjectIdEqualTo(objectId);
        List<StlPolicyItemPlan> stlPolicyItemPlans = stlPolicyItemPlanMapper.selectByExample(stlPolicyItemPlanCriteria);
        if ((stlPolicyItemConditions.size() == 0) && (stlPolicyItemPlans.size() == 0)) {
            return null;
        } else {
            stlElements = new ArrayList<StlElement>();
            if (stlPolicyItemConditions.size() != 0) {
                for (StlPolicyItemCondition stlPolicyItemCondition : stlPolicyItemConditions) {
                    if (unique.containsKey(stlPolicyItemCondition.getTenantId()
                            + stlPolicyItemCondition.getElementId().toString())) {
                        continue;
                    } else {
                        unique.put(stlPolicyItemCondition.getTenantId()
                                + stlPolicyItemCondition.getElementId().toString(), 1);
                        StlElementExample stlElementCriteria = new StlElementExample();
                        StlElementExample.Criteria elementCriteria = stlElementCriteria
                                .createCriteria();
                        elementCriteria.andTenantIdEqualTo(stlPolicyItemCondition.getTenantId());
                        elementCriteria.andElementIdEqualTo(stlPolicyItemCondition.getElementId());
                        elementCriteria.andAttrTypeEqualTo("statistics");
                        elementCriteria.andStatisticsTypeNotEqualTo("content_count");
                        List<StlElement> elements = stlElementMapper.selectByExample(stlElementCriteria);
                        if (elements.size() != 0) {
                            stlElements.add(elements.get(0));
                        }
                    }
                }
            }
            if (stlPolicyItemPlans.size() != 0) {
                for (StlPolicyItemPlan stlPolicyItemPlan : stlPolicyItemPlans) {
                    if (unique.containsKey(stlPolicyItemPlan.getTenantId()
                            + stlPolicyItemPlan.getElementId().toString())) {
                        continue;
                    } else {
                        unique.put(stlPolicyItemPlan.getTenantId()
                                + stlPolicyItemPlan.getElementId().toString(), 1);
                        StlElementExample stlElementCriteria1 = new StlElementExample();
                        StlElementExample.Criteria elementCriteria1 = stlElementCriteria1
                                .createCriteria();
                        elementCriteria1.andTenantIdEqualTo(stlPolicyItemPlan.getTenantId());
                        elementCriteria1.andElementIdEqualTo(stlPolicyItemPlan.getElementId());
                        elementCriteria1.andAttrTypeEqualTo("statistics");
                        elementCriteria1.andStatisticsTypeNotEqualTo("content_count");
                        List<StlElement> elements = stlElementMapper.selectByExample(stlElementCriteria1);
                        if (elements.size() != 0) {
                            stlElements.add(elements.get(0));
                        }
                    }
                }
            }
        }
        return JSON.toJSONString(stlElements);
    }

    private List<String> UniqueData(List<StlPolicyItemCondition> stlPolicyItemConditions,
            List<StlPolicyItemPlan> stlPolicyItemPlans) {
        List<String> results = new ArrayList<String>();
        Map<String, Integer> unique = new HashMap<String, Integer>();
        if (stlPolicyItemConditions.size() != 0) {
            for (StlPolicyItemCondition stlPolicyItemCondition : stlPolicyItemConditions) {
                if (unique.containsKey(stlPolicyItemCondition.getTenantId()
                        + stlPolicyItemCondition.getPolicyId()
                        + stlPolicyItemCondition.getObjectId())) {
                    continue;
                } else {
                    unique.put(
                            stlPolicyItemCondition.getTenantId()
                                    + stlPolicyItemCondition.getPolicyId()
                                    + stlPolicyItemCondition.getObjectId(), 1);
                    results.add(stlPolicyItemCondition.getTenantId() + "_"
                            + stlPolicyItemCondition.getPolicyId() + "_"
                            + stlPolicyItemCondition.getObjectId());
                }
            }
        }
        if (stlPolicyItemPlans.size() != 0) {
            for (StlPolicyItemPlan stlPolicyItemPlan : stlPolicyItemPlans) {
                if (unique.containsKey(stlPolicyItemPlan.getTenantId()
                        + stlPolicyItemPlan.getPolicyId() + stlPolicyItemPlan.getObjectId())) {
                    continue;
                } else {
                    unique.put(stlPolicyItemPlan.getTenantId() + stlPolicyItemPlan.getPolicyId()
                            + stlPolicyItemPlan.getObjectId(), 1);
                    results.add(stlPolicyItemPlan.getTenantId() + "_"
                            + stlPolicyItemPlan.getPolicyId() + "_"
                            + stlPolicyItemPlan.getObjectId());
                }
            }
        }
        return results;
    }
}

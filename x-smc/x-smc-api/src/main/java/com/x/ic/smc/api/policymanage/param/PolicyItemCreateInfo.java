package com.x.ic.smc.api.policymanage.param;

import java.io.Serializable;
import java.util.List;

public class PolicyItemCreateInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 政策适配记录
     */
    private List<PolicyItemConditionCreateInfo> policyItemConditionCreateInfos;

    /**
     * 政策策略记录
     */
    private List<PolicyItemPlanCreateInfo> policyItemPlanCreateInfos;

    public List<PolicyItemConditionCreateInfo> getPolicyItemConditionCreateInfos() {
        return policyItemConditionCreateInfos;
    }

    public void setPolicyItemConditionCreateInfos(
            List<PolicyItemConditionCreateInfo> policyItemConditionCreateInfos) {
        this.policyItemConditionCreateInfos = policyItemConditionCreateInfos;
    }

    public List<PolicyItemPlanCreateInfo> getPolicyItemPlanCreateInfos() {
        return policyItemPlanCreateInfos;
    }

    public void setPolicyItemPlanCreateInfos(
            List<PolicyItemPlanCreateInfo> policyItemPlanCreateInfos) {
        this.policyItemPlanCreateInfos = policyItemPlanCreateInfos;
    }
}

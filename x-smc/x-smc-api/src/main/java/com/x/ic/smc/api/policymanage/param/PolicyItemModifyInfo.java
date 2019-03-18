package com.x.ic.smc.api.policymanage.param;

import java.io.Serializable;
import java.util.List;

public class PolicyItemModifyInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 政策适配记录
     */
    private List<PolicyItemConditionModifyInfo> policyItemConditionModifyInfos;

    /**
     * 政策策略记录
     */
    private List<PolicyItemPlanModifyInfo> policyItemPlanModifyInfos;

    public List<PolicyItemConditionModifyInfo> getPolicyItemConditionModifyInfos() {
        return policyItemConditionModifyInfos;
    }

    public void setPolicyItemConditionModifyInfos(
            List<PolicyItemConditionModifyInfo> policyItemConditionModifyInfos) {
        this.policyItemConditionModifyInfos = policyItemConditionModifyInfos;
    }

    public List<PolicyItemPlanModifyInfo> getPolicyItemPlanModifyInfos() {
        return policyItemPlanModifyInfos;
    }

    public void setPolicyItemPlanModifyInfos(
            List<PolicyItemPlanModifyInfo> policyItemPlanModifyInfos) {
        this.policyItemPlanModifyInfos = policyItemPlanModifyInfos;
    }

}

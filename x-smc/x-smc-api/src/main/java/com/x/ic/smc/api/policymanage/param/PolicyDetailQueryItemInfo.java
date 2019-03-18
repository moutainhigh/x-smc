package com.x.ic.smc.api.policymanage.param;

import java.io.Serializable;
import java.util.List;

public class PolicyDetailQueryItemInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 政策项ID
     */
    private Long itemId;

    /**
     * 政策适配记录
     */
    List<PolicyDetailQueryConditionInfo> policyDetailQueryConditionInfos;

    /**
     * 政策策略记录
     */
    List<PolicyDetailQueryPlanInfo> policyDetailQueryPlanInfos;

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public List<PolicyDetailQueryConditionInfo> getPolicyDetailQueryConditionInfos() {
        return policyDetailQueryConditionInfos;
    }

    public void setPolicyDetailQueryConditionInfos(
            List<PolicyDetailQueryConditionInfo> policyDetailQueryConditionInfos) {
        this.policyDetailQueryConditionInfos = policyDetailQueryConditionInfos;
    }

    public List<PolicyDetailQueryPlanInfo> getPolicyDetailQueryPlanInfos() {
        return policyDetailQueryPlanInfos;
    }

    public void setPolicyDetailQueryPlanInfos(
            List<PolicyDetailQueryPlanInfo> policyDetailQueryPlanInfos) {
        this.policyDetailQueryPlanInfos = policyDetailQueryPlanInfos;
    }
}

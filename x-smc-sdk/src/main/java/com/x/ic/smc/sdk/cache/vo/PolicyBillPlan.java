package com.x.ic.smc.sdk.cache.vo;

import java.sql.Timestamp;

public class PolicyBillPlan {
    private Long billPlanId;

    private String tenantId;

    private Long policyId;

    private String calElementType;

    private String calPhase;

    private String ruleValue;

    private Long sortIndex;

    private Timestamp updateTime;

    public Long getBillPlanId() {
        return billPlanId;
    }

    public void setBillPlanId(Long billPlanId) {
        this.billPlanId = billPlanId;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId == null ? null : tenantId.trim();
    }

    public Long getPolicyId() {
        return policyId;
    }

    public void setPolicyId(Long policyId) {
        this.policyId = policyId;
    }

    public String getCalElementType() {
        return calElementType;
    }

    public void setCalElementType(String calElementType) {
        this.calElementType = calElementType == null ? null : calElementType.trim();
    }

    public String getCalPhase() {
        return calPhase;
    }

    public void setCalPhase(String calPhase) {
        this.calPhase = calPhase == null ? null : calPhase.trim();
    }

    public String getRuleValue() {
        return ruleValue;
    }

    public void setRuleValue(String ruleValue) {
        this.ruleValue = ruleValue == null ? null : ruleValue.trim();
    }

    public Long getSortIndex() {
        return sortIndex;
    }

    public void setSortIndex(Long sortIndex) {
        this.sortIndex = sortIndex;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }
}
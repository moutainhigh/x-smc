package com.x.ic.msg.dao.mapper.bo;

import java.sql.Timestamp;

public class StlPolicyBillPlan {
    private Long billPlanId;

    private String tenantId;

    private String planName;

    private String planDescribe;

    private Long policyId;

    private String calElementType;

    private String calPhase;

    private String ruleValue;

    private Long sortIndex;

    private String remark;

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

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName == null ? null : planName.trim();
    }

    public String getPlanDescribe() {
        return planDescribe;
    }

    public void setPlanDescribe(String planDescribe) {
        this.planDescribe = planDescribe == null ? null : planDescribe.trim();
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }
}
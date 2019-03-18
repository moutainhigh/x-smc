package com.x.ic.smc.api.policymanage.param;

import java.io.Serializable;
import java.util.List;

public class PolicyDetailQueryPlanInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 策略ID
     */
    private Long planId;

    /**
     * 租户ID
     */
    private String tenantId;

    /**
     * 政策项ID
     */
    private Long itemId;

    /**
     * 政策ID
     */
    private Long policyId;

    /**
     * 算费对象,cust 客户 subs 订购 order 使用流水
     */
    private String objectId;

    /**
     * 算费属性
     */
    private Long elementId;

    /**
     * 费用科目
     */
    private String feeItem;

    /**
     * 策略类型,normal 标准： 统一的策略 step 阶梯：分阶梯计费， switch 分档：满足某档后，所有数据所此当费率计算
     */
    private String planType;

    /**
     * 算费方式,ratio：按比例 fixed：按固定金额 price：单价
     */
    private String calType;

    /**
     * 标准策略取值,策略类型选normal 标准时必填
     */
    private String normalCalValue;

    /**
     * 阶梯或分档策略取值,策略类型选step阶梯或switch分档时必填
     */
    private List<StepCalValue> stepCalValues;

    /**
     * 更新部门
     */
    private String updateDeptId;

    /**
     * 更新工号
     */
    private String updateOperId;

    /**
     * 更新时间
     */
    private String updateTimeStr;

    public Long getPlanId() {
        return planId;
    }

    public void setPlanId(Long planId) {
        this.planId = planId;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public Long getPolicyId() {
        return policyId;
    }

    public void setPolicyId(Long policyId) {
        this.policyId = policyId;
    }

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public Long getElementId() {
        return elementId;
    }

    public void setElementId(Long elementId) {
        this.elementId = elementId;
    }

    public String getFeeItem() {
        return feeItem;
    }

    public void setFeeItem(String feeItem) {
        this.feeItem = feeItem;
    }

    public String getPlanType() {
        return planType;
    }

    public void setPlanType(String planType) {
        this.planType = planType;
    }

    public String getCalType() {
        return calType;
    }

    public void setCalType(String calType) {
        this.calType = calType;
    }

    public String getNormalCalValue() {
        return normalCalValue;
    }

    public void setNormalCalValue(String normalCalValue) {
        this.normalCalValue = normalCalValue;
    }

    public List<StepCalValue> getStepCalValues() {
        return stepCalValues;
    }

    public void setStepCalValues(List<StepCalValue> stepCalValues) {
        this.stepCalValues = stepCalValues;
    }

    public String getUpdateDeptId() {
        return updateDeptId;
    }

    public void setUpdateDeptId(String updateDeptId) {
        this.updateDeptId = updateDeptId;
    }

    public String getUpdateOperId() {
        return updateOperId;
    }

    public void setUpdateOperId(String updateOperId) {
        this.updateOperId = updateOperId;
    }

    public String getUpdateTimeStr() {
        return updateTimeStr;
    }

    public void setUpdateTimeStr(String updateTimeStr) {
        this.updateTimeStr = updateTimeStr;
    }
}

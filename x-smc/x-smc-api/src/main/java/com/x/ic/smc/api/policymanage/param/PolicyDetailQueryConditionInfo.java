package com.x.ic.smc.api.policymanage.param;

import java.io.Serializable;

public class PolicyDetailQueryConditionInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 政策适配记录ID
     */
    private Long conditionId;

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
     * 归属对象,cust 客户 subs 订购 order 使用流水
     */
    private String objectId;

    /**
     * 元素ID
     */
    private Long elementId;

    /**
     * 匹配方式,>：大于 >=：大于等于 <：小于 <=：小于等于 in ：包含 nin：不包含 =：等于 !=：不等于
     */
    private String matchType;

    /**
     * 匹配值
     */
    private String matchValue;

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

    public Long getConditionId() {
        return conditionId;
    }

    public void setConditionId(Long conditionId) {
        this.conditionId = conditionId;
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

    public String getMatchType() {
        return matchType;
    }

    public void setMatchType(String matchType) {
        this.matchType = matchType;
    }

    public String getMatchValue() {
        return matchValue;
    }

    public void setMatchValue(String matchValue) {
        this.matchValue = matchValue;
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

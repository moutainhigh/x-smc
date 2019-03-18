package com.x.smc.bill.dao.mapper.bo;

import java.sql.Timestamp;

public class PolicyTaskCycle {
    private String policyCycleId;

    private String policyCycleCode;

    private Long policyId;

    private String objectType;

    private String objectCode;

    private Timestamp startTime;

    private Timestamp endTime;

    private String status;

    private String tenantId;

    private Timestamp createDate;

    private Timestamp updateTime;

    private String createStaffId;

    private String cycleValue;

    public String getPolicyCycleId() {
        return policyCycleId;
    }

    public void setPolicyCycleId(String policyCycleId) {
        this.policyCycleId = policyCycleId == null ? null : policyCycleId.trim();
    }

    public String getPolicyCycleCode() {
        return policyCycleCode;
    }

    public void setPolicyCycleCode(String policyCycleCode) {
        this.policyCycleCode = policyCycleCode == null ? null : policyCycleCode.trim();
    }

    public Long getPolicyId() {
        return policyId;
    }

    public void setPolicyId(Long policyId) {
        this.policyId = policyId;
    }

    public String getObjectType() {
        return objectType;
    }

    public void setObjectType(String objectType) {
        this.objectType = objectType == null ? null : objectType.trim();
    }

    public String getObjectCode() {
        return objectCode;
    }

    public void setObjectCode(String objectCode) {
        this.objectCode = objectCode == null ? null : objectCode.trim();
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId == null ? null : tenantId.trim();
    }

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    public String getCreateStaffId() {
        return createStaffId;
    }

    public void setCreateStaffId(String createStaffId) {
        this.createStaffId = createStaffId == null ? null : createStaffId.trim();
    }

    public String getCycleValue() {
        return cycleValue;
    }

    public void setCycleValue(String cycleValue) {
        this.cycleValue = cycleValue == null ? null : cycleValue.trim();
    }
}
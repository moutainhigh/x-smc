package com.x.smc.bill.dao.mapper.bo;

import java.sql.Timestamp;

public class StlBillData {
    private Long billId;

    private String billFrom;

    private String tenantId;

    private String policyId;

    private String objectType;

    private String objectCode;

    private Long stlElementId;

    private String stlElementSn;

    private String billTimeSn;

    private Timestamp billStartTime;

    private Timestamp billEndTime;

    private String cycleType;

    private String cycleValue;

    private String origFee;

    private String checkState;

    private String diffFee;

    private String checkStateDesc;

    private Timestamp checkTime;

    private String adjustFee;

    private String finalFee;

    private Long totalCount;

    private Timestamp adjustTime;

    private String adjustOperId;

    private String adjustDesc;

    private String extendStr;

    private String createDeptId;

    private String createOperId;

    private Timestamp createTime;

    public Long getBillId() {
        return billId;
    }

    public void setBillId(Long billId) {
        this.billId = billId;
    }

    public String getBillFrom() {
        return billFrom;
    }

    public void setBillFrom(String billFrom) {
        this.billFrom = billFrom == null ? null : billFrom.trim();
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId == null ? null : tenantId.trim();
    }

    public String getPolicyId() {
        return policyId;
    }

    public void setPolicyId(String policyId) {
        this.policyId = policyId == null ? null : policyId.trim();
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

    public Long getStlElementId() {
        return stlElementId;
    }

    public void setStlElementId(Long stlElementId) {
        this.stlElementId = stlElementId;
    }

    public String getStlElementSn() {
        return stlElementSn;
    }

    public void setStlElementSn(String stlElementSn) {
        this.stlElementSn = stlElementSn == null ? null : stlElementSn.trim();
    }

    public String getBillTimeSn() {
        return billTimeSn;
    }

    public void setBillTimeSn(String billTimeSn) {
        this.billTimeSn = billTimeSn == null ? null : billTimeSn.trim();
    }

    public Timestamp getBillStartTime() {
        return billStartTime;
    }

    public void setBillStartTime(Timestamp billStartTime) {
        this.billStartTime = billStartTime;
    }

    public Timestamp getBillEndTime() {
        return billEndTime;
    }

    public void setBillEndTime(Timestamp billEndTime) {
        this.billEndTime = billEndTime;
    }

    public String getCycleType() {
        return cycleType;
    }

    public void setCycleType(String cycleType) {
        this.cycleType = cycleType == null ? null : cycleType.trim();
    }

    public String getCycleValue() {
        return cycleValue;
    }

    public void setCycleValue(String cycleValue) {
        this.cycleValue = cycleValue == null ? null : cycleValue.trim();
    }

    public String getOrigFee() {
        return origFee;
    }

    public void setOrigFee(String origFee) {
        this.origFee = origFee == null ? null : origFee.trim();
    }

    public String getCheckState() {
        return checkState;
    }

    public void setCheckState(String checkState) {
        this.checkState = checkState == null ? null : checkState.trim();
    }

    public String getDiffFee() {
        return diffFee;
    }

    public void setDiffFee(String diffFee) {
        this.diffFee = diffFee == null ? null : diffFee.trim();
    }

    public String getCheckStateDesc() {
        return checkStateDesc;
    }

    public void setCheckStateDesc(String checkStateDesc) {
        this.checkStateDesc = checkStateDesc == null ? null : checkStateDesc.trim();
    }

    public Timestamp getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(Timestamp checkTime) {
        this.checkTime = checkTime;
    }

    public String getAdjustFee() {
        return adjustFee;
    }

    public void setAdjustFee(String adjustFee) {
        this.adjustFee = adjustFee == null ? null : adjustFee.trim();
    }

    public String getFinalFee() {
        return finalFee;
    }

    public void setFinalFee(String finalFee) {
        this.finalFee = finalFee == null ? null : finalFee.trim();
    }

    public Long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Long totalCount) {
        this.totalCount = totalCount;
    }

    public Timestamp getAdjustTime() {
        return adjustTime;
    }

    public void setAdjustTime(Timestamp adjustTime) {
        this.adjustTime = adjustTime;
    }

    public String getAdjustOperId() {
        return adjustOperId;
    }

    public void setAdjustOperId(String adjustOperId) {
        this.adjustOperId = adjustOperId == null ? null : adjustOperId.trim();
    }

    public String getAdjustDesc() {
        return adjustDesc;
    }

    public void setAdjustDesc(String adjustDesc) {
        this.adjustDesc = adjustDesc == null ? null : adjustDesc.trim();
    }

    public String getExtendStr() {
        return extendStr;
    }

    public void setExtendStr(String extendStr) {
        this.extendStr = extendStr == null ? null : extendStr.trim();
    }

    public String getCreateDeptId() {
        return createDeptId;
    }

    public void setCreateDeptId(String createDeptId) {
        this.createDeptId = createDeptId == null ? null : createDeptId.trim();
    }

    public String getCreateOperId() {
        return createOperId;
    }

    public void setCreateOperId(String createOperId) {
        this.createOperId = createOperId == null ? null : createOperId.trim();
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }
}
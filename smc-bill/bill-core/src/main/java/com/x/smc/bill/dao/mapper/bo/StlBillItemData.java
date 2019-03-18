package com.x.smc.bill.dao.mapper.bo;

import java.sql.Timestamp;

public class StlBillItemData {
    private Long billItemId;

    private Long billId;

    private String tenantId;

    private String itemType;

    private String feeItemId;

    private Float totalFee;

    private String checkState;

    private Float diffFee;

    private String checkStateDesc;

    private Timestamp checkTime;

    private Timestamp adjustTime;

    private String adjustOperId;

    private String adjustDesc;

    private String createDeptId;

    private String createOperId;

    private Timestamp createTime;

    public Long getBillItemId() {
        return billItemId;
    }

    public void setBillItemId(Long billItemId) {
        this.billItemId = billItemId;
    }

    public Long getBillId() {
        return billId;
    }

    public void setBillId(Long billId) {
        this.billId = billId;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId == null ? null : tenantId.trim();
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType == null ? null : itemType.trim();
    }

    public String getFeeItemId() {
        return feeItemId;
    }

    public void setFeeItemId(String feeItemId) {
        this.feeItemId = feeItemId == null ? null : feeItemId.trim();
    }

    public Float getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(Float totalFee) {
        this.totalFee = totalFee;
    }

    public String getCheckState() {
        return checkState;
    }

    public void setCheckState(String checkState) {
        this.checkState = checkState == null ? null : checkState.trim();
    }

    public Float getDiffFee() {
        return diffFee;
    }

    public void setDiffFee(Float diffFee) {
        this.diffFee = diffFee;
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
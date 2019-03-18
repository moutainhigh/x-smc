package com.x.ic.smc.dao.mapper.bo;

import java.sql.Timestamp;

public class StlBillStyle {
    private Long billStyleId;

    private String tenantId;

    private String billStyleSn;

    private String billTitle;

    private String state;

    private String createDeptId;

    private String createOperId;

    private Timestamp createTime;

    private String updateDeptId;

    private String updateOperId;

    private Timestamp updateTime;

    public Long getBillStyleId() {
        return billStyleId;
    }

    public void setBillStyleId(Long billStyleId) {
        this.billStyleId = billStyleId;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId == null ? null : tenantId.trim();
    }

    public String getBillStyleSn() {
        return billStyleSn;
    }

    public void setBillStyleSn(String billStyleSn) {
        this.billStyleSn = billStyleSn == null ? null : billStyleSn.trim();
    }

    public String getBillTitle() {
        return billTitle;
    }

    public void setBillTitle(String billTitle) {
        this.billTitle = billTitle == null ? null : billTitle.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
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

    public String getUpdateDeptId() {
        return updateDeptId;
    }

    public void setUpdateDeptId(String updateDeptId) {
        this.updateDeptId = updateDeptId == null ? null : updateDeptId.trim();
    }

    public String getUpdateOperId() {
        return updateOperId;
    }

    public void setUpdateOperId(String updateOperId) {
        this.updateOperId = updateOperId == null ? null : updateOperId.trim();
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }
}
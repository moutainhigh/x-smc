package com.x.ic.smc.dao.mapper.bo;

import java.sql.Timestamp;

public class StlImportLog {
    private Long logId;

    private String tenantId;

    private String impFileName;

    private String impFileUrl;

    private String dataType;

    private String objectId;

    private String billTimeSn;

    private Timestamp importTime;

    private Long importRecords;

    private String batchNo;

    private String rstFileName;

    private String rstFileUrl;

    private String state;

    private String stateDesc;

    private String optDeptId;

    private String optOperId;

    private Timestamp stateChgTime;

    public Long getLogId() {
        return logId;
    }

    public void setLogId(Long logId) {
        this.logId = logId;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId == null ? null : tenantId.trim();
    }

    public String getImpFileName() {
        return impFileName;
    }

    public void setImpFileName(String impFileName) {
        this.impFileName = impFileName == null ? null : impFileName.trim();
    }

    public String getImpFileUrl() {
        return impFileUrl;
    }

    public void setImpFileUrl(String impFileUrl) {
        this.impFileUrl = impFileUrl == null ? null : impFileUrl.trim();
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType == null ? null : dataType.trim();
    }

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId == null ? null : objectId.trim();
    }

    public String getBillTimeSn() {
        return billTimeSn;
    }

    public void setBillTimeSn(String billTimeSn) {
        this.billTimeSn = billTimeSn == null ? null : billTimeSn.trim();
    }

    public Timestamp getImportTime() {
        return importTime;
    }

    public void setImportTime(Timestamp importTime) {
        this.importTime = importTime;
    }

    public Long getImportRecords() {
        return importRecords;
    }

    public void setImportRecords(Long importRecords) {
        this.importRecords = importRecords;
    }

    public String getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo == null ? null : batchNo.trim();
    }

    public String getRstFileName() {
        return rstFileName;
    }

    public void setRstFileName(String rstFileName) {
        this.rstFileName = rstFileName == null ? null : rstFileName.trim();
    }

    public String getRstFileUrl() {
        return rstFileUrl;
    }

    public void setRstFileUrl(String rstFileUrl) {
        this.rstFileUrl = rstFileUrl == null ? null : rstFileUrl.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public String getStateDesc() {
        return stateDesc;
    }

    public void setStateDesc(String stateDesc) {
        this.stateDesc = stateDesc == null ? null : stateDesc.trim();
    }

    public String getOptDeptId() {
        return optDeptId;
    }

    public void setOptDeptId(String optDeptId) {
        this.optDeptId = optDeptId == null ? null : optDeptId.trim();
    }

    public String getOptOperId() {
        return optOperId;
    }

    public void setOptOperId(String optOperId) {
        this.optOperId = optOperId == null ? null : optOperId.trim();
    }

    public Timestamp getStateChgTime() {
        return stateChgTime;
    }

    public void setStateChgTime(Timestamp stateChgTime) {
        this.stateChgTime = stateChgTime;
    }
}
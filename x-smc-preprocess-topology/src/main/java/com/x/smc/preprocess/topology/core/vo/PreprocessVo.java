package com.x.smc.preprocess.topology.core.vo;

import java.sql.Timestamp;

/**
 * 
 * @author wangluyang
 *
 */
public class PreprocessVo {

	private Long preprocessId;

    private String tenantId;

    private String dataType;

    private String objectId;

    private String billTimeSn;

    private String batchNo;

    private String cycleType;

    private String cycleValue;

    private String hbaseTableName;

    private String currentCount;

    private Timestamp updateTime;

    public Long getPreprocessId() {
        return preprocessId;
    }

    public void setPreprocessId(Long preprocessId) {
        this.preprocessId = preprocessId;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId == null ? null : tenantId.trim();
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

    public String getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo == null ? null : batchNo.trim();
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

    public String getHbaseTableName() {
        return hbaseTableName;
    }

    public void setHbaseTableName(String hbaseTableName) {
        this.hbaseTableName = hbaseTableName == null ? null : hbaseTableName.trim();
    }

    public String getCurrentCount() {
        return currentCount;
    }

    public void setCurrentCount(String currentCount) {
        this.currentCount = currentCount == null ? null : currentCount.trim();
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }
 
}

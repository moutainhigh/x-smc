package com.x.smc.preprocess.topology.core.vo;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 算费数据处理记录vo
 * @author wangluyang
 *
 */
public class CalDataRecordVo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long recordId;

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

    private Timestamp calDate;

    private Timestamp nextCalDate;

    public Long getRecordId() {
        return recordId;
    }

    public void setRecordId(Long recordId) {
        this.recordId = recordId;
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

    public Timestamp getCalDate() {
        return calDate;
    }

    public void setCalDate(Timestamp calDate) {
        this.calDate = calDate;
    }

    public Timestamp getNextCalDate() {
        return nextCalDate;
    }

    public void setNextCalDate(Timestamp nextCalDate) {
        this.nextCalDate = nextCalDate;
    }
}

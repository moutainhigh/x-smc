package com.x.smc.preprocess.topology.core.bo;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 详单
 * @author wangluyang
 *
 */
public class BillDetailVo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long billId;

    private String billFrom;

    private String tenantId;

    private String policyId;

    private String objectType;
    
    private String objectCode;
    
    private String billTimeSn;

    private Timestamp billStartTime;

    private Timestamp billEndTime;

    private String origFee;

    private String checkState;

    private String diffFee;

    private String checkStateDesc;

    private Timestamp checkTime;

    private String adjustFee;

    private String finalFee;

    private Timestamp adjustTime;

    private String adjustOperId;

    private String adjustDesc;

    private String extendStr;

    private String createDeptId;

    private String createOperId;

    private Timestamp createTime;

    private String yyyyMm;
    
    private String feeItemId;
    
    private String itemType;
    
	private String totalFee;
    
    private String msgHeader;
    
    private String msgBody;

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
		this.billFrom = billFrom;
	}

	public String getTenantId() {
		return tenantId;
	}

	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}

	public String getPolicyId() {
		return policyId;
	}

	public void setPolicyId(String policyId) {
		this.policyId = policyId;
	}

	public String getObjectType() {
		return objectType;
	}

	public void setObjectType(String objectType) {
		this.objectType = objectType;
	}

	public String getObjectCode() {
		return objectCode;
	}

	public void setObjectCode(String objectCode) {
		this.objectCode = objectCode;
	}

	public String getBillTimeSn() {
		return billTimeSn;
	}

	public void setBillTimeSn(String billTimeSn) {
		this.billTimeSn = billTimeSn;
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

	public String getOrigFee() {
		return origFee;
	}

	public void setOrigFee(String origFee) {
		this.origFee = origFee;
	}

	public String getCheckState() {
		return checkState;
	}

	public void setCheckState(String checkState) {
		this.checkState = checkState;
	}

	public String getDiffFee() {
		return diffFee;
	}

	public void setDiffFee(String diffFee) {
		this.diffFee = diffFee;
	}

	public String getCheckStateDesc() {
		return checkStateDesc;
	}

	public void setCheckStateDesc(String checkStateDesc) {
		this.checkStateDesc = checkStateDesc;
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
		this.adjustFee = adjustFee;
	}

	public String getFinalFee() {
		return finalFee;
	}

	public void setFinalFee(String finalFee) {
		this.finalFee = finalFee;
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
		this.adjustOperId = adjustOperId;
	}

	public String getAdjustDesc() {
		return adjustDesc;
	}

	public void setAdjustDesc(String adjustDesc) {
		this.adjustDesc = adjustDesc;
	}

	public String getExtendStr() {
		return extendStr;
	}

	public void setExtendStr(String extendStr) {
		this.extendStr = extendStr;
	}

	public String getCreateDeptId() {
		return createDeptId;
	}

	public void setCreateDeptId(String createDeptId) {
		this.createDeptId = createDeptId;
	}

	public String getCreateOperId() {
		return createOperId;
	}

	public void setCreateOperId(String createOperId) {
		this.createOperId = createOperId;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public String getYyyyMm() {
		return yyyyMm;
	}

	public void setYyyyMm(String yyyyMm) {
		this.yyyyMm = yyyyMm;
	}

	public String getFeeItemId() {
		return feeItemId;
	}

	public void setFeeItemId(String feeItemId) {
		this.feeItemId = feeItemId;
	}

	public String getItemType() {
		return itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

	public String getTotalFee() {
		return totalFee;
	}

	public void setTotalFee(String totalFee) {
		this.totalFee = totalFee;
	}

	public String getMsgHeader() {
		return msgHeader;
	}

	public void setMsgHeader(String msgHeader) {
		this.msgHeader = msgHeader;
	}

	public String getMsgBody() {
		return msgBody;
	}

	public void setMsgBody(String msgBody) {
		this.msgBody = msgBody;
	}
}

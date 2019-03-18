package com.x.ic.smc.sdk.mds.vo;

import java.io.Serializable;

public class Header  implements Serializable {

	private static final long serialVersionUID = 1L;

	
	private String tenantId;
	private Long policyId;
	private String objectType;
	private String objectCode;
	private String bsn;
	private String cycleType;
	private String cycleValue;
	private String primaryKey;
	private String serialId;
	private String policyCycleId;
	
	public String getPolicyCycleId() {
		return policyCycleId;
	}
	public void setPolicyCycleId(String policyCycleId) {
		this.policyCycleId = policyCycleId;
	}
	public String getSerialId() {
		return serialId;
	}
	public void setSerialId(String serialId) {
		this.serialId = serialId;
	}
	public String getPrimaryKey() {
		return primaryKey;
	}
	public void setPrimaryKey(String primaryKey) {
		this.primaryKey = primaryKey;
	}
	public String getTenantId() {
		return tenantId;
	}
	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
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
		this.objectType = objectType;
	}
	public String getObjectCode() {
		return objectCode;
	}
	public void setObjectCode(String objectCode) {
		this.objectCode = objectCode;
	}
	public String getBsn() {
		return bsn;
	}
	public void setBsn(String bsn) {
		this.bsn = bsn;
	}
	public String getCycleType() {
		return cycleType;
	}
	public void setCycleType(String cycleType) {
		this.cycleType = cycleType;
	}
	public String getCycleValue() {
		return cycleValue;
	}
	public void setCycleValue(String cycleValue) {
		this.cycleValue = cycleValue;
	}

	
	
	
	
	
}

package com.x.smc.bill.api.demo.param;

import java.io.Serializable;
import java.sql.Timestamp;

public class DstDiscountInfoVO implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -5118793497584647838L;

	/**
     * 权益id
     */
    private String discountId;

    /**
     * 租户id
     */
    private String tenantId;

    /**
     * 权益名称
     */
    private String discountName;

    /**
     * 权益编码
     */
    private String discountCode;

    /**
     * 分类编码
     */
    private String classCode;

    /**
     * 权益说明
     */
    private String discountInstructions;

    /**
     * 权益类型
     */
    private String discountType;

    /**
     * 权益有效时长
     */
    private String effectiveTime;

    /**
     * 权益有效期单位
     */
    private String effectiveUnit;

    /**
     * 状态
     */
    private String status;

    /**
     * 0未认证1已认证
     */
    private String verifyState;

    /**
     * 创建人
     */
    private String createUserId;

    /**
     * 创建日期
     */
    private Timestamp createDate;

    /**
     * 备注
     */
    private String remark;

    public String getDiscountId() {
        return discountId;
    }

    public void setDiscountId(String discountId) {
        this.discountId = discountId == null ? null : discountId.trim();
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId == null ? null : tenantId.trim();
    }

    public String getDiscountName() {
        return discountName;
    }

    public void setDiscountName(String discountName) {
        this.discountName = discountName == null ? null : discountName.trim();
    }

    public String getDiscountCode() {
        return discountCode;
    }

    public void setDiscountCode(String discountCode) {
        this.discountCode = discountCode == null ? null : discountCode.trim();
    }

    public String getClassCode() {
        return classCode;
    }

    public void setClassCode(String classCode) {
        this.classCode = classCode == null ? null : classCode.trim();
    }

    public String getDiscountInstructions() {
        return discountInstructions;
    }

    public void setDiscountInstructions(String discountInstructions) {
        this.discountInstructions = discountInstructions == null ? null : discountInstructions.trim();
    }

    public String getDiscountType() {
        return discountType;
    }

    public void setDiscountType(String discountType) {
        this.discountType = discountType == null ? null : discountType.trim();
    }

    public String getEffectiveTime() {
        return effectiveTime;
    }

    public void setEffectiveTime(String effectiveTime) {
        this.effectiveTime = effectiveTime == null ? null : effectiveTime.trim();
    }

    public String getEffectiveUnit() {
        return effectiveUnit;
    }

    public void setEffectiveUnit(String effectiveUnit) {
        this.effectiveUnit = effectiveUnit == null ? null : effectiveUnit.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getVerifyState() {
        return verifyState;
    }

    public void setVerifyState(String verifyState) {
        this.verifyState = verifyState == null ? null : verifyState.trim();
    }

    public String getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId == null ? null : createUserId.trim();
    }

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}
package com.x.smc.bill.vo;

import java.io.Serializable;

/**
 * 权益激活消费方vo
 * @author wangluyang
 *
 */
public class DstActiveProcessorVo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 租户id
	 */
	private String tenantId;

	/**
	 * 权益编码
	 */
    private String discountCode;

    /**
     * 客户id
     */
    private String custId;
    
    /**
     * 客户id
     */
    private String custName;

    /**
     * 主体编码
     */
    private String ownerCode;

    /**
     * 主体实例编码
     */
    private String ownerInstanceCode;
    

    /**
     * 权益购买日期
     */
    private Long discountPayDate;

    /**
     * 权益购买价格
     */
    private String discountPayFee;

    /**
     * 0：未激活
	 * 1：生效
	 * 2：过期，失效
     * 权益激活状态
     */
    private String activeStatus = "1";

    /**
     * 激活日期
     */
    private Long activeDate;
    
    /**
     * 创建用户id
     */
    private String createUserId;

    /**
     * 备注
     */
    private String remark;

	public String getTenantId() {
		return tenantId;
	}

	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}

	public String getDiscountCode() {
		return discountCode;
	}

	public void setDiscountCode(String discountCode) {
		this.discountCode = discountCode;
	}

	public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}
	
	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getOwnerCode() {
		return ownerCode;
	}

	public void setOwnerCode(String ownerCode) {
		this.ownerCode = ownerCode;
	}

	public String getOwnerInstanceCode() {
		return ownerInstanceCode;
	}

	public void setOwnerInstanceCode(String ownerInstanceCode) {
		this.ownerInstanceCode = ownerInstanceCode;
	}

	public Long getDiscountPayDate() {
		return discountPayDate;
	}

	public void setDiscountPayDate(Long discountPayDate) {
		this.discountPayDate = discountPayDate;
	}
	
	public String getDiscountPayFee() {
		return discountPayFee;
	}

	public void setDiscountPayFee(String discountPayFee) {
		this.discountPayFee = discountPayFee;
	}

	public String getActiveStatus() {
		return activeStatus;
	}

	public void setActiveStatus(String activeStatus) {
		this.activeStatus = activeStatus;
	}

	public Long getActiveDate() {
		return activeDate;
	}

	public void setActiveDate(Long activeDate) {
		this.activeDate = activeDate;
	}

	public String getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}

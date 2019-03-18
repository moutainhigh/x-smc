package com.x.smc.bill.vo;

import java.io.Serializable;

/**
 * 消息提醒vo
 * @author wangluyang
 *
 */
public class DstRemindSendVo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String remindInfo;
	
	/**
     * 客户id
     */
    private String custId;
    
    /**
     * 客户权益实例id
     */
    private String instanceId;

    /**
     * 主体编码
     */
    private String ownerCode;

    /**
     * 主体实例编码
     */
    private String ownerInstanceCode;
    
    /**
     * 权益编码
     */
    private String discountCode;
    
    /**
     * 消息类型
     */
    private String msgType = "text";
    
    /**
     * 创建日期
     */
    private Long createTime;
    
    

	public String getRemindInfo() {
		return remindInfo;
	}

	public void setRemindInfo(String remindInfo) {
		this.remindInfo = remindInfo;
	}

	public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}

	public String getInstanceId() {
		return instanceId;
	}

	public void setInstanceId(String instanceId) {
		this.instanceId = instanceId;
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

	public String getDiscountCode() {
		return discountCode;
	}

	public void setDiscountCode(String discountCode) {
		this.discountCode = discountCode;
	}
	
	public String getMsgType() {
		return msgType;
	}

	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}

	public Long getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Long createTime) {
		this.createTime = createTime;
	}
	
}

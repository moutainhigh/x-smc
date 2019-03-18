package com.x.ic.smc.api.elementmanage.param;
import java.io.Serializable;

/**
 * 
 * @author zhangbc
 *
 */
public class AttributeRecord implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Long getSubElementId() {
		return subElementId;
	}

	public void setSubElementId(Long subElementId) {
		this.subElementId = subElementId;
	}

	public Long getSubObjectId() {
		return subObjectId;
	}

	public void setSubObjectId(Long subObjectId) {
		this.subObjectId = subObjectId;
	}

	public String getRelType() {
		return relType;
	}

	public void setRelType(String relType) {
		this.relType = relType;
	}

	public String getRelValue() {
		return relValue;
	}

	public void setRelValue(String relValue) {
		this.relValue = relValue;
	}

	/**
	 * 限定元素ID
	 */
	private Long subElementId;
	
	/**
	 * 元素对象ID
	 */
	private Long subObjectId;
	
	/**
	 * 限定方式
	 */
	private String relType;
	
	/**
	 * 限定值
	 */
	private String relValue;
	
	

}

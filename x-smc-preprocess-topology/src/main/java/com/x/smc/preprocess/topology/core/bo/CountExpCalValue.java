package com.x.smc.preprocess.topology.core.bo;

import java.io.Serializable;

public class CountExpCalValue  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 区域类型
	 */
	private String sectionType;
	
	/**
	 * 区域表达式
	 */
	private String sectionValue;
	
	/**
	 * 价格类型
	 */
	private String calType;
	
	/**
	 * 价格表达式
	 */
	private String calValue;

	public String getSectionType() {
		return sectionType;
	}

	public void setSectionType(String sectionType) {
		this.sectionType = sectionType;
	}

	public String getSectionValue() {
		return sectionValue;
	}

	public void setSectionValue(String sectionValue) {
		this.sectionValue = sectionValue;
	}

	public String getCalType() {
		return calType;
	}

	public void setCalType(String calType) {
		this.calType = calType;
	}

	public String getCalValue() {
		return calValue;
	}

	public void setCalValue(String calValue) {
		this.calValue = calValue;
	}
}

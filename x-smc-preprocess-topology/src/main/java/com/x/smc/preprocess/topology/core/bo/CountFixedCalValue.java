package com.x.smc.preprocess.topology.core.bo;

import java.io.Serializable;

/**
 * 
 * @author wangluyang
 *
 */
public class CountFixedCalValue implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String startNum;
	
	private String endNum;
	
	private String sortIndex;
	
	private String calValue;

	public String getStartNum() {
		return startNum;
	}

	public void setStartNum(String startNum) {
		this.startNum = startNum;
	}

	public String getEndNum() {
		return endNum;
	}

	public void setEndNum(String endNum) {
		this.endNum = endNum;
	}

	public String getSortIndex() {
		return sortIndex;
	}

	public void setSortIndex(String sortIndex) {
		this.sortIndex = sortIndex;
	}

	public String getCalValue() {
		return calValue;
	}

	public void setCalValue(String calValue) {
		this.calValue = calValue;
	}
}

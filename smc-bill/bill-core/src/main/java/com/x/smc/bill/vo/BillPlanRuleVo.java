package com.x.smc.bill.vo;

import java.io.Serializable;

public class BillPlanRuleVo  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 规则，格式，表达式
	 * n/50==0?p+4:p
	 */
	private String expression;
	
	private String sortIndex;

	public String getExpression() {
		return expression;
	}

	public void setExpression(String expression) {
		this.expression = expression;
	}

	public String getSortIndex() {
		return sortIndex;
	}

	public void setSortIndex(String sortIndex) {
		this.sortIndex = sortIndex;
	}
}

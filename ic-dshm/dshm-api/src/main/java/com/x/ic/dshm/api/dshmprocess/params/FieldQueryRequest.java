package com.x.ic.dshm.api.dshmprocess.params;

import com.x.base.vo.BaseInfo;

public class FieldQueryRequest extends BaseInfo {

	private static final long serialVersionUID = 1L;

	/**
	 * 表Id
	 */
	private Integer tableId;
	/**
	 * 表名称
	 */
	private String tableName;

	

	public Integer getTableId() {
		return tableId;
	}

	public void setTableId(Integer tableId) {
		this.tableId = tableId;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	
	
}

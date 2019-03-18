package com.x.ic.dshm.api.dshmprocess.params;

import java.io.Serializable;


/**
 * 请求参数
 * @author biancx
 *
 */
public class ReqParam implements Serializable{


	private static final long serialVersionUID = -5452699762452333281L;
	private String[] tableNames;
	private String[] tableId;
	
	public String[] getTableNames() {
		return tableNames;
	}
	public void setTableNames(String[] tableNames) {
		this.tableNames = tableNames;
	}
	public String[] getTableId() {
		return tableId;
	}
	public void setTableId(String[] tableId) {
		this.tableId = tableId;
	}
	

}

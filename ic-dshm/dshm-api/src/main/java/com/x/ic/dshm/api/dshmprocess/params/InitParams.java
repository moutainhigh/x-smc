package com.x.ic.dshm.api.dshmprocess.params;

import java.io.Serializable;

public class InitParams implements Serializable{

	private static final long serialVersionUID = -5452699762452333324L;
	
	private String tableName;
	private Object obj;
	private int type;
	
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public Object getObj() {
		return obj;
	}
	public void setObj(Object obj) {
		this.obj = obj;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	
	
}

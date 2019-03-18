package com.x.ic.dshm.api.dshmprocess.params;

import java.io.Serializable;
import java.util.List;

public class AddEbillingShmTableRecord implements Serializable{
     private String dbConnect;
     private String tableName;
     private List<String> isIndexKey;
     public List<String> getIsIndexKey() {
		return isIndexKey;
	}
	public void setIsIndexKey(List<String> isIndexKey) {
		this.isIndexKey = isIndexKey;
	}
	private List<ShmTableRecordVo> shmTableRecordVoList;
	public String getDbConnect() {
		return dbConnect;
	}
	public void setDbConnect(String dbConnect) {
		this.dbConnect = dbConnect;
	}
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public List<ShmTableRecordVo> getShmTableRecordVoList() {
		return shmTableRecordVoList;
	}
	public void setShmTableRecordVoList(List<ShmTableRecordVo> shmTableRecordVoList) {
		this.shmTableRecordVoList = shmTableRecordVoList;
	}
}
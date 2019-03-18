package com.x.ic.dshm.api.dshmprocess.params;


import java.io.Serializable;

public class ShmTableRecordVo implements Serializable{
	public static final String SHM_ID = "id";
	public static final String SHM_TABLEID = "tableId";
	public static final String SHM_TABLENAME = "tableName";
	public static final String SHM_FIELDSEQ = "fieldSeq";
	public static final String SHM_FIELDNAME = "fieldName";
	public static final String SHM_FIELDTYPE = "fieldType";
	public static final String SHM_FIELDFORMAT = "fieldFormat";
	public static final String SHM_FIELDSIZE = "fieldSize";
	public static final String SHM_ISHASHKEY = "isHashkey";
	public static final String SHM_ISPARIMARY = "isPrimary";
	public static final String SHM_SEARCHTYPE = "searchType";
	//2015-12-02 tenantid=BYD
	public static final String SHM_TENANTID = "tenantId";
	
	private Integer id;
	private Integer tableId;
	private String tableName; 
	private Integer fieldSeq;
	private String fieldName;
	private Integer fieldType;
	private String fieldFormat;
	private Integer fieldSize;
	private Integer isHashkey;
	private Integer isPrimary;
	private String searchType;
	private String tenantId;
	public ShmTableRecordVo() {
	}
	public ShmTableRecordVo(Integer id, Integer tableId, String tableName, Integer fieldSeq, String fieldName, Integer fieldType, String fieldFormat, Integer fieldSize,Integer isPrimary, Integer isHashkey, String searchType, String tenantId) {
		this.id = id;
		this.tableId = tableId;
		this.tableName = tableName;
		this.fieldSeq = fieldSeq;
		this.fieldName = fieldName;
		this.fieldType = fieldType;
		this.fieldFormat = fieldFormat;
		this.fieldSize = fieldSize;
		this.isHashkey = isHashkey;
		this.isPrimary = isPrimary;
		this.searchType = searchType;
		this.tenantId = tenantId;
	}
	
	//getter and setter
	public Integer getIsHashkey() {
		return isHashkey;
	}
	public void setIsHashkey(Integer isHashkey) {
		this.isHashkey = isHashkey;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
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
	public Integer getFieldSeq() {
		return fieldSeq;
	}
	public void setFieldSeq(Integer fieldSeq) {
		this.fieldSeq = fieldSeq;
	}
	public String getFieldName() {
		return fieldName;
	}
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	public Integer getFieldType() {
		return fieldType;
	}
	public void setFieldType(Integer fieldType) {
		this.fieldType = fieldType;
	}
	public String getFieldFormat() {
		return fieldFormat;
	}
	public void setFieldFormat(String fieldFormat) {
		this.fieldFormat = fieldFormat;
	}
	public Integer getFieldSize() {
		return fieldSize;
	}
	public void setFieldSize(Integer fieldSize) {
		this.fieldSize = fieldSize;
	}
	public Integer getIsPrimary() {
		return isPrimary;
	}
	public void setIsPrimary(Integer isPrimary) {
		this.isPrimary = isPrimary;
	}
	public String getSearchType() {
		return searchType;
	}
	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}
    public String getTenantId() {
		return tenantId;
	}
	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}	
}

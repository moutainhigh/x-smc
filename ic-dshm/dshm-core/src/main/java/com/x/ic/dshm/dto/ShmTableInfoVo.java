package com.x.ic.dshm.dto;



public class ShmTableInfoVo {
	public static final String SHM_ID = "id";
	public static final String SHM_TABLEID = "tableId";
	public static final String SHM_INDEXKEY = "indexKey";
	public static final String SHM_ISENABLE = "isEnable";
	public static final String SHM_TABLENAME = "tableName";
	public static final String SHM_STORAGETYPE = "storageType";
	public static final String SHM_INDEXCOUNT = "indexCount";
	public static final String SHM_DATACOUNT = "dataCount";
	public static final String SHM_ISPARA = "isPara";
	public static final String SHM_INDEXID = "indexId";
	public static final String SHM_HASHTYPE = "hashType";
	public static final String SHM_LESSEENAME = "lesseeName";
	public static final String DB_CONNECT = "dbConnect";
	public static final String SHM_TENANTID = "tenantId";
	/**
	 * 主键id
	 */
	private Integer id;
	/**
	 * 实体表序号
	 */
	private Integer tableId;
	/**
	 * 是否启用加载功能
	 */
	private Integer isEnable;
	/**
	 * 实体表名
	 */
	private String tableName;
	/**
	 * 存储类型，0为string，1为hash
	 */
	private Integer storageType;
	/**
	 * 该表的主键
	 */
	private String indexKey;
	/**
	 * 索引最大值，一般可取Data_count的130%
	 */
	private Integer indexCount;
	/**
	 * 数据最大值，最大可容纳数据量
	 */
	private Long dataCount;
	/**
	 * 是否为全量加载的参数表，0不是，1是
	 */
	private Integer isPara;
	/**
	 * 索引id
	 */
	private Integer indexId;
	/**
	 * hash类型，string或者int
	 */
	private Integer hashType;
	/**
	 * 租户名称
	 */
	private String lesseeName;
	/**
	 * 数据库连接信息
	 */
	private String dbConnect;
	
	//2015-12-02 tenantid=BYD
	private String tenantId;
	public ShmTableInfoVo() {
	}
	public ShmTableInfoVo(Integer id, Integer tableId, Integer isEnable, String tableName, Integer storageType, String indexKey, Integer indexCount, Long dataCount, Integer isPara, Integer indexId, Integer hashType, String lesseeName,String dbConnect, String tenantId) {
		this.id = id;
		this.tableId = tableId;
		this.isEnable = isEnable;
		this.tableName = tableName;
		this.storageType = storageType;
		this.indexKey = indexKey;
		this.indexCount = indexCount;
		this.dataCount = dataCount;
		this.isPara = isPara;
		this.indexId = indexId;
		this.hashType = hashType;
		this.lesseeName = lesseeName;
		this.dbConnect=dbConnect;
		this.tenantId=tenantId;
	}
	//getter and setter
	public String getDbConnect() {
		return dbConnect;
	}
	public void setDbConnect(String dbConnect) {
		this.dbConnect = dbConnect;
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
	public Integer getIsEnable() {
		return isEnable;
	}
	public void setIsEnable(Integer isEnable) {
		this.isEnable = isEnable;
	}
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public String getIndexKey() {
		return indexKey;
	}
	public void setIndexKey(String indexKey) {
		this.indexKey = indexKey;
	}
	public Integer getStorageType() {
		return storageType;
	}
	public void setStorageType(Integer storageType) {
		this.storageType = storageType;
	}
	public Integer getIndexCount() {
		return indexCount;
	}
	public void setIndexCount(Integer indexCount) {
		this.indexCount = indexCount;
	}
	public Long getDataCount() {
		return dataCount;
	}
	public void setDataCount(Long dataCount) {
		this.dataCount = dataCount;
	}
	public Integer getIsPara() {
		return isPara;
	}
	public void setIsPara(Integer isPara) {
		this.isPara = isPara;
	}
	public Integer getIndexId() {
		return indexId;
	}
	public void setIndexId(Integer indexId) {
		this.indexId = indexId;
	}
	public Integer getHashType() {
		return hashType;
	}
	public void setHashType(Integer hashType) {
		this.hashType = hashType;
	}
	public String getLesseeName() {
		return lesseeName;
	}
	public void setLesseeName(String lesseeName) {
		this.lesseeName = lesseeName;
	}
    public String getTenantId() {
		return tenantId;
	}
	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}	
}

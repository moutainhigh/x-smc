package com.x.ic.smc.api.elementmanage.param;

import com.x.base.vo.BaseResponse;

public class ElementSearchResponseVO extends BaseResponse{

	public Long getElementId() {
		return elementId;
	}

	public void setElementId(Long elementId) {
		this.elementId = elementId;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 元素ID
	 */
	private Long elementId;
	
	
	/**
	 * 元素编码
	 */
	private String elementCode;
	
	/**
	 * 元素名称
	 */
	private String elementName;
	
	/**
	 * 归属对象
	 */
	private String objectId;
	
	/**
	 * 属性分类
	 */
	private String attrType;
	
	/**
	 * 是否结算对象
	 */
	private String isSettlement;
	
	/**
	 * 属性值类型
	 */
	private String valueType;
	
	/**
	 * 是否必填
	 */
	private String isNecessary;
	
	
	/**
	 * 元素类型
	 */
	private String elementType;
	
	/**
	 * 数据生成方式
	 */
	private String dataCreateType;
	
	/**
	 * 是否主键
	 */
	private String isPrimaryKey;
	
	/**
	 * 单位
	 */
	private String unit;
	
	/**
	 * 业务数据序号
	 */
	private Long sortId;
	
	/**
	 * 元素描述
	 */
	private String elementDesc;
	
	/**
	 * 汇总方式
	 */
	private String statisticsType;
	
	/**
	 * 汇总周期
	 */
	private String statisticsCyc;
	
	/**
	 * 统计对象ID
	 */
	private String statisticsObjectId;
	
	/**
	 * 统计元素id
	 */
	private Long statisticsElementId;
	
	/**
	 * 状态
	 */
	private String state;
	
	/**
	 * 创建部门
	 */
	private String createDeptId;
	
	/**
	 * 创建工号
	 */
	private String createOperId;
	
	/**
	 * 属性记录
	 */
	private AttributeRecord attributeRecord;
	
	
	private String tenantId;

	

	public String getTenantId() {
		return tenantId;
	}

	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}

	public String getElementCode() {
		return elementCode;
	}

	public void setElementCode(String elementCode) {
		this.elementCode = elementCode;
	}

	public String getElementName() {
		return elementName;
	}

	public void setElementName(String elementName) {
		this.elementName = elementName;
	}

	public String getObjectId() {
		return objectId;
	}

	public void setObjectId(String objectId) {
		this.objectId = objectId;
	}

	public String getAttrType() {
		return attrType;
	}

	public void setAttrType(String attrType) {
		this.attrType = attrType;
	}

	public String getIsSettlement() {
		return isSettlement;
	}

	public void setIsSettlement(String isSettlement) {
		this.isSettlement = isSettlement;
	}

	public String getValueType() {
		return valueType;
	}

	public void setValueType(String valueType) {
		this.valueType = valueType;
	}

	public String getIsNecessary() {
		return isNecessary;
	}

	public void setIsNecessary(String isNecessary) {
		this.isNecessary = isNecessary;
	}

	public String getElementType() {
		return elementType;
	}

	public void setElementType(String elementType) {
		this.elementType = elementType;
	}

	public String getDataCreateType() {
		return dataCreateType;
	}

	public void setDataCreateType(String dataCreateType) {
		this.dataCreateType = dataCreateType;
	}

	public String getIsPrimaryKey() {
		return isPrimaryKey;
	}

	public void setIsPrimaryKey(String isPrimaryKey) {
		this.isPrimaryKey = isPrimaryKey;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public Long getSortId() {
		return sortId;
	}

	public void setSortId(Long sortId) {
		this.sortId = sortId;
	}

	public String getElementDesc() {
		return elementDesc;
	}

	public void setElementDesc(String elementDesc) {
		this.elementDesc = elementDesc;
	}

	public String getStatisticsType() {
		return statisticsType;
	}

	public void setStatisticsType(String statisticsType) {
		this.statisticsType = statisticsType;
	}

	public String getStatisticsCyc() {
		return statisticsCyc;
	}

	public void setStatisticsCyc(String statisticsCyc) {
		this.statisticsCyc = statisticsCyc;
	}

	public String getStatisticsObjectId() {
		return statisticsObjectId;
	}

	public void setStatisticsObjectId(String statisticsObjectId) {
		this.statisticsObjectId = statisticsObjectId;
	}


	public Long getStatisticsElementId() {
		return statisticsElementId;
	}

	public void setStatisticsElementId(Long statisticsElementId) {
		this.statisticsElementId = statisticsElementId;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCreateDeptId() {
		return createDeptId;
	}

	public void setCreateDeptId(String createDeptId) {
		this.createDeptId = createDeptId;
	}

	public String getCreateOperId() {
		return createOperId;
	}

	public void setCreateOperId(String createOperId) {
		this.createOperId = createOperId;
	}

	public AttributeRecord getAttributeRecord() {
		return attributeRecord;
	}

	public void setAttributeRecord(AttributeRecord attributeRecord) {
		this.attributeRecord = attributeRecord;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	

}

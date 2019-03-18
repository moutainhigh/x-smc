package com.x.ic.smc.api.elementmanage.param;

import com.x.base.vo.BaseInfo;

/**
 * 
 * @author zhangbc
 *
 */
public class ElementUpdateRequest extends BaseInfo{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 元素ID
	 */
	private Long elementId;
	
	/**
	 * 元素名称
	 */
	private String elementName;
	
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
	 * 更新部门
	 */
	private String updateDeptId;
	
	/**
	 * 更新工号
	 */
	private String updateOperId;
	
	/**
	 * 属性记录
	 */
	private AttributeRecord attributeRecord;



	public Long getElementId() {
		return elementId;
	}

	public void setElementId(Long elementId) {
		this.elementId = elementId;
	}

	public String getElementName() {
		return elementName;
	}

	public void setElementName(String elementName) {
		this.elementName = elementName;
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

	public String getUpdateDeptId() {
		return updateDeptId;
	}

	public void setUpdateDeptId(String updateDeptId) {
		this.updateDeptId = updateDeptId;
	}

	public String getUpdateOperId() {
		return updateOperId;
	}

	public void setUpdateOperId(String updateOperId) {
		this.updateOperId = updateOperId;
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

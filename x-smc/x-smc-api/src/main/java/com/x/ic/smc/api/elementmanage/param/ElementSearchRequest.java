package com.x.ic.smc.api.elementmanage.param;

import com.x.base.vo.BaseInfo;
import com.x.base.vo.PageInfo;

/**
 * 
 * @author zhangbc
 *
 */
public class ElementSearchRequest extends BaseInfo {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 元素Id
	 */
	private String elementCode;
	
	/**
	 * 属性分类
	 */
    private String attrType;
    
    /**
     * 是否结算对象
     */
    private String isSettlement;
    
    /**
     * 元素类型
     */
    private String elementType;
    
    /**
     * 汇总周期
     */
    private String statisticsCyc;
    
    /**
     * 状态
     */
    private String state;
    
    /**
     * 归属对象
     */
    private String objectId;
    
    
    public String getObjectId() {
		return objectId;
	}


	public void setObjectId(String objectId) {
		this.objectId = objectId;
	}


	/**
     * 分页信息
     */
    private PageInfo<ElementSearchResponseVO>  pageInfo;


	public String getElementCode() {
		return elementCode;
	}


	public void setElementCode(String elementCode) {
		this.elementCode = elementCode;
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


	public String getElementType() {
		return elementType;
	}


	public void setElementType(String elementType) {
		this.elementType = elementType;
	}


	public String getStatisticsCyc() {
		return statisticsCyc;
	}


	public void setStatisticsCyc(String statisticsCyc) {
		this.statisticsCyc = statisticsCyc;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public PageInfo<ElementSearchResponseVO> getPageInfo() {
		return pageInfo;
	}


	public void setPageInfo(PageInfo<ElementSearchResponseVO> pageInfo) {
		this.pageInfo = pageInfo;
	}
    
}

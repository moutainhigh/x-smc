package com.x.ic.dshm.api.dshmprocess.params;

import com.x.base.vo.BaseInfo;
import com.x.base.vo.PageInfo;

public class PagingTableInfoRequest extends BaseInfo {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 表名
	 */
	private String tableName ;
	
	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	/**
	 * 分页信息
	 */
	private PageInfo<ShmTableInfoVo> pageInfo;

	public PageInfo<ShmTableInfoVo> getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(PageInfo<ShmTableInfoVo> pageInfo) {
		this.pageInfo = pageInfo;
	}
	
	

}

package com.x.ic.smc.api.billstyle.param;

import java.util.List;

import com.x.base.vo.BaseInfo;


public class AddBillStyleInfo extends BaseInfo{

	private static final long serialVersionUID = 1L;
	
	/**
	 * 账单样式编码 必填
	 */
	private String billStyleSn;

    /**
     * 账单标题 必填
     */
    private String billTitle;

    /**
     * 创建部门
     */
    private String createDeptId;

    /**
     * 创建工号
     */
    private String createOperId;
    
//    /**
//     * 账单项 必填
//     */
//    private List<BillStyleVo> billStyleVos;
    
    /**
     * 详单项 必填
     */
    private List<BillStyleDetailVo> billStyleDetailVos;
    
	public String getBillStyleSn() {
		return billStyleSn;
	}

	public void setBillStyleSn(String billStyleSn) {
		this.billStyleSn = billStyleSn;
	}

	public String getBillTitle() {
		return billTitle;
	}

	public void setBillTitle(String billTitle) {
		this.billTitle = billTitle;
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

    // public List<BillStyleVo> getBillStyleVos() {
    // return billStyleVos;
    // }
    //
    // public void setBillStyleVos(List<BillStyleVo> billStyleVos) {
    // this.billStyleVos = billStyleVos;
    // }

	public List<BillStyleDetailVo> getBillStyleDetailVos() {
		return billStyleDetailVos;
	}

	public void setBillStyleDetailVos(List<BillStyleDetailVo> billStyleDetailVos) {
		this.billStyleDetailVos = billStyleDetailVos;
	}



}

package com.x.ic.smc.api.billstyle.param;

import java.io.Serializable;
import java.util.List;

import com.x.base.vo.BaseInfo;


public class UpdateBillStyleInfo extends BaseInfo implements Serializable{

	private static final long serialVersionUID = 1L;
	
	/**
	 * 账单样式ID 必填
	 */
	private Long billStyleId;

    /**
     * 账单标题 
     */
    private String billTitle;

    /**
     * 更新部门
     */
    private String updateDeptId;

    /**
     * 更新工号
     */
    private String updateOperId;
    
//    /**
//     * 账单项 必填
//     */
//    private List<BillStyleVo> billStyleVos;
    
    /**
     * 详单项 必填
     */
    private List<BillStyleDetailVo> billStyleDetailVos;

	public Long getBillStyleId() {
		return billStyleId;
	}

	public void setBillStyleId(Long billStyleId) {
		this.billStyleId = billStyleId;
	}

	public String getBillTitle() {
		return billTitle;
	}

	public void setBillTitle(String billTitle) {
		this.billTitle = billTitle;
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

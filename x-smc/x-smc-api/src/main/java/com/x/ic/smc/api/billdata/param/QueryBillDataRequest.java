package com.x.ic.smc.api.billdata.param;

import com.x.base.vo.BaseInfo;

public class QueryBillDataRequest extends BaseInfo {

    private static final long serialVersionUID = 1L;

    /**
     * 政策编码
     */
    private String policyCode;

    /**
     * 结算对象
     */
    private String stlObjectId;

    /**
     * 结算账期 必填
     */
    private String billTimeSn;

    public String getPolicyCode() {
        return policyCode;
    }

    public void setPolicyCode(String policyCode) {
        this.policyCode = policyCode == null ? null : policyCode.trim();
    }

    public String getStlObjectId() {
        return stlObjectId;
    }

    public void setStlObjectId(String stlObjectId) {
        this.stlObjectId = stlObjectId == null ? null : stlObjectId.trim();
    }

    public String getBillTimeSn() {
        return billTimeSn;
    }

    public void setBillTimeSn(String billTimeSn) {
        this.billTimeSn = billTimeSn == null ? null : billTimeSn.trim();
    }
}

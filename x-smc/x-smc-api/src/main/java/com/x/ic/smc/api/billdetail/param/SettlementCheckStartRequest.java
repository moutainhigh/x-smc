package com.x.ic.smc.api.billdetail.param;

import com.x.base.vo.BaseInfo;

public class SettlementCheckStartRequest extends BaseInfo {
    private static final long serialVersionUID = 1L;

    /**
     * 批次号
     */
    private String batchNo;

    /**
     * 账期月份,yyyymm
     */
    private String billMonth;

    public String getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo;
    }

    public String getBillMonth() {
        return billMonth;
    }

    public void setBillMonth(String billMonth) {
        this.billMonth = billMonth;
    }
}

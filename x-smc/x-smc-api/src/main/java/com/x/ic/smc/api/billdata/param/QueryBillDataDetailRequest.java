package com.x.ic.smc.api.billdata.param;

import com.x.base.vo.BaseInfo;
import com.x.base.vo.HBasePager;

public class QueryBillDataDetailRequest extends BaseInfo {

    private static final long serialVersionUID = 1L;

    /**
     * 账单id 必填
     */
    private Long billId;

    /**
     * 结算账期 必填
     */
    private String billTimeSn;

    /**
     * 分页信息必填
     */
    private HBasePager<QueryBillDetail> hBasePager;

    public String getBillTimeSn() {
        return billTimeSn;
    }

    public void setBillTimeSn(String billTimeSn) {
        this.billTimeSn = billTimeSn;
    }

    public Long getBillId() {
        return billId;
    }

    public void setBillId(Long billId) {
        this.billId = billId;
    }

    public HBasePager<QueryBillDetail> gethBasePager() {
        return hBasePager;
    }

    public void sethBasePager(HBasePager<QueryBillDetail> hBasePager) {
        this.hBasePager = hBasePager;
    }

}

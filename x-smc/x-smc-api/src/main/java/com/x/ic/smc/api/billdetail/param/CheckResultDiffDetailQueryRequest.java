package com.x.ic.smc.api.billdetail.param;

import com.x.base.vo.BaseInfo;
import com.x.base.vo.HBasePager;

public class CheckResultDiffDetailQueryRequest extends BaseInfo {
    private static final long serialVersionUID = 1L;

    /**
     * 账期月份
     */
    private String billMonth;

    /**
     * 账单ID
     */
    private Long billId;

    /**
     * 分页信息，分页时必填
     */
    private HBasePager<DiffDetailDataInfo> pager;

    public String getBillMonth() {
        return billMonth;
    }

    public void setBillMonth(String billMonth) {
        this.billMonth = billMonth;
    }

    public Long getBillId() {
        return billId;
    }

    public void setBillId(Long billId) {
        this.billId = billId;
    }

    public HBasePager<DiffDetailDataInfo> getPager() {
        return pager;
    }

    public void setPager(HBasePager<DiffDetailDataInfo> pager) {
        this.pager = pager;
    }

}

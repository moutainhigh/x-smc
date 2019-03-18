package com.x.ic.smc.api.billdata.param;

import java.util.List;

import com.x.base.vo.BaseResponse;


public class QueryBillDataResponse extends BaseResponse {

    private static final long serialVersionUID = 1L;

    /**
     * 账单信息查询服务返回list
     */
    private List<BillDataVo> billDataVos;

    public List<BillDataVo> getBillDataVos() {
        return billDataVos;
    }

    public void setBillDataVos(List<BillDataVo> billDataVos) {
        this.billDataVos = billDataVos;
    }

}

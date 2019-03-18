package com.x.ic.smc.service.busi.interfaces;

import com.x.base.exception.BusinessException;
import com.x.ic.smc.api.billdata.param.QueryBillDataDetailRequest;
import com.x.ic.smc.api.billdata.param.QueryBillDataRequest;
import com.x.ic.smc.api.billdata.param.QueryBillDataResponse;
import com.x.ic.smc.api.billdata.param.QueryBillDetailResponse;

public interface IBillDataBusiSV {
    /**
     * 账单信息查询<br>
     * 
     * @param queryBillDataRequest
     * @return
     * @author wangjl9
     * @ApiDocMethod
     */
    QueryBillDataResponse queryBillData(QueryBillDataRequest queryBillDataRequest)
            throws BusinessException;

    /**
     * 账单信息查询<br>
     * 
     * @param queryBillDataDetailRequest
     * @return
     * @author wangjl9
     * @ApiDocMethod
     */
    QueryBillDetailResponse queryBillDataDetail(
            QueryBillDataDetailRequest queryBillDataDetailRequest) throws BusinessException;
}

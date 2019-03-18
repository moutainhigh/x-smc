package com.x.ic.smc.api.billdata.impl;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.x.base.exception.BusinessException;
import com.x.ic.smc.api.billdata.interfaces.IBillDataSV;
import com.x.ic.smc.api.billdata.param.QueryBillDataDetailRequest;
import com.x.ic.smc.api.billdata.param.QueryBillDataRequest;
import com.x.ic.smc.api.billdata.param.QueryBillDataResponse;
import com.x.ic.smc.api.billdata.param.QueryBillDetailResponse;
import com.x.ic.smc.constants.SmcExceptCodeConstant;
import com.x.ic.smc.service.busi.interfaces.IBillDataBusiSV;
import com.x.ic.smc.util.BusinessUtil;
import com.alibaba.dubbo.config.annotation.Service;

@Service
public class BillDataSVImpl implements IBillDataSV {

    @Autowired
    private IBillDataBusiSV iBillDataBusiSV;

    @Override
    public QueryBillDataResponse queryBillData(QueryBillDataRequest queryBillDataRequest)
            throws BusinessException {
        BusinessUtil.checkBaseInfo(queryBillDataRequest);
        if (StringUtils.isBlank(queryBillDataRequest.getBillTimeSn())) {
            throw new BusinessException(SmcExceptCodeConstant.PARAM_IS_NULL, "结算账期不可为空");
        }
        return iBillDataBusiSV.queryBillData(queryBillDataRequest);
    }

    @Override
    public QueryBillDetailResponse queryBillDataDetail(
            QueryBillDataDetailRequest queryBillDataDetailRequest) throws BusinessException {
        BusinessUtil.checkBaseInfo(queryBillDataDetailRequest);
        if ((queryBillDataDetailRequest.getBillId() == null)
                || (queryBillDataDetailRequest.getBillId() == 0)) {
            throw new BusinessException(SmcExceptCodeConstant.PARAM_IS_NULL, "账单ID不可为空");
        }
        if (StringUtils.isBlank(queryBillDataDetailRequest.getBillTimeSn())) {
            throw new BusinessException(SmcExceptCodeConstant.PARAM_IS_NULL, "结算账期不可为空");
        }
        return iBillDataBusiSV.queryBillDataDetail(queryBillDataDetailRequest);
    }
}

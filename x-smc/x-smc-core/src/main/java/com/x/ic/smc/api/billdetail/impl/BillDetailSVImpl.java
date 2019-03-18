package com.x.ic.smc.api.billdetail.impl;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.x.base.exception.BusinessException;
import com.x.base.exception.SystemException;
import com.x.base.vo.BaseResponse;
import com.x.base.vo.HBasePager;
import com.x.base.vo.ResponseHeader;
import com.x.sdk.util.DateUtil;
import com.x.sdk.util.StringUtil;
import com.x.ic.smc.api.billdetail.interfaces.IBillDetailSV;
import com.x.ic.smc.api.billdetail.param.BillDetailDataImportRequest;
import com.x.ic.smc.api.billdetail.param.CheckResultDiffDetailQueryRequest;
import com.x.ic.smc.api.billdetail.param.CheckResultDiffDetailQueryResponse;
import com.x.ic.smc.api.billdetail.param.CheckResultQueryRequest;
import com.x.ic.smc.api.billdetail.param.CheckResultQueryResponse;
import com.x.ic.smc.api.billdetail.param.DiffDetailDataInfo;
import com.x.ic.smc.api.billdetail.param.SettlementCheckStartRequest;
import com.x.ic.smc.constants.SmcExceptCodeConstant;
import com.x.ic.smc.service.busi.interfaces.IBillDetailBusiSV;
import com.x.ic.smc.util.BusinessUtil;
import com.alibaba.dubbo.config.annotation.Service;

@Service
public class BillDetailSVImpl implements IBillDetailSV {
    private static final Logger LOG = LogManager.getLogger(BillDetailSVImpl.class);

    @Autowired
    private transient IBillDetailBusiSV billDetailBusiSV;

    @Override
    public BaseResponse importBillDetailData(BillDetailDataImportRequest request) {
        BusinessUtil.checkBaseInfo(request);
        if (StringUtil.isBlank(request.getBillTimeSn())) {
            throw new BusinessException(SmcExceptCodeConstant.PARAM_IS_NULL, "[账期]不能为空");
        }
        if (request.getBillTimeSn().length() != 6) {
            throw new BusinessException(SmcExceptCodeConstant.PARAM_TYPE_NOT_RIGHT, "[账期]长度应为6位");
        }
        if (!DateUtil.isValidDate(request.getBillTimeSn(), DateUtil.YYYYMM)) {
            throw new BusinessException(SmcExceptCodeConstant.PARAM_TYPE_NOT_RIGHT,
                    "[账期]格式应为[YYYYMM]");
        }
        if (StringUtil.isBlank(request.getObjectId())) {
            throw new BusinessException(SmcExceptCodeConstant.PARAM_IS_NULL, "[数据对象]不能为空");
        }
        // List<String> objectIdValues = getFieldValues(BillDetailDataImportRequest.ObjectId.class);
        // if (!objectIdValues.contains(request.getObjectId())) {
        // throw new BusinessException(SmcExceptCodeConstant.PARAM_TYPE_NOT_RIGHT, "[数据对象]不合法");
        // }
        if (StringUtil.isBlank(request.getImpFileName())) {
            throw new BusinessException(SmcExceptCodeConstant.PARAM_IS_NULL, "[文件名]不能为空");
        }
        if (StringUtil.isBlank(request.getImpFileUrl())) {
            throw new BusinessException(SmcExceptCodeConstant.PARAM_IS_NULL, "[文件位置]不能为空");
        }
        if (StringUtil.isBlank(request.getOptDeptId())) {
            throw new BusinessException(SmcExceptCodeConstant.PARAM_IS_NULL, "[操作部门]不能为空");
        }
        if (StringUtil.isBlank(request.getOptOperId())) {
            throw new BusinessException(SmcExceptCodeConstant.PARAM_IS_NULL, "[操作工号]不能为空");
        }

        String batchNo = billDetailBusiSV.importBillDetailData(request);
        // 调用对账总控程序，成功或失败都不需要关心
        try {
            SettlementCheckStartRequest checkStartRequest = new SettlementCheckStartRequest();
            checkStartRequest.setTenantId(request.getTenantId());
            checkStartRequest.setTenantPwd(request.getTenantPwd());
            checkStartRequest.setBatchNo(batchNo);
            checkStartRequest.setBillMonth(StringUtil.restrictLength(request.getBillTimeSn(), 6));
            BaseResponse response = billDetailBusiSV.startSettlementCheck(checkStartRequest);
            LOG.error("自动调用对账总控程序，返回结果:[" + response.getResponseHeader().getResultCode() + ":"
                    + response.getResponseHeader().getResultMessage() + "]");
        } catch (Exception e) {
            LOG.error("自动调用对账总控程序发现异常", e);
        }

        ResponseHeader responseHeader = new ResponseHeader(true, SmcExceptCodeConstant.SUCCESS,
                "成功");
        BaseResponse response = new BaseResponse();
        response.setResponseHeader(responseHeader);
        return response;
    }

    @Override
    public BaseResponse startSettlementCheck(SettlementCheckStartRequest request) {
        BusinessUtil.checkBaseInfo(request);
        return billDetailBusiSV.startSettlementCheck(request);
    }

    @Override
    public CheckResultQueryResponse queryCheckResult(CheckResultQueryRequest request) {
        BusinessUtil.checkBaseInfo(request);

        return billDetailBusiSV.queryCheckResult(request);
    }

    @Override
    public CheckResultDiffDetailQueryResponse queryCheckResultDiffDetail(
            CheckResultDiffDetailQueryRequest request) {
        BusinessUtil.checkBaseInfo(request);

        HBasePager<DiffDetailDataInfo> pageInfo = billDetailBusiSV
                .queryCheckResultDiffDetail(request);

        ResponseHeader responseHeader = new ResponseHeader(true, SmcExceptCodeConstant.SUCCESS,
                "成功");
        CheckResultDiffDetailQueryResponse response = new CheckResultDiffDetailQueryResponse();
        response.setResponseHeader(responseHeader);
        response.setPager(pageInfo);
        return response;
    }

    List<String> getFieldValues(Class<?> t) throws SystemException {
        List<String> list = new ArrayList<String>();
        Field[] fields = t.getFields();
        for (Field field : fields) {
            try {
                list.add(field.get(t).toString());
            } catch (IllegalArgumentException | IllegalAccessException e) {
                throw new SystemException(e);
            }
        }
        return list;
    }
}

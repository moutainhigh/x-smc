package com.x.ic.smc.service.busi.interfaces;

import com.x.base.vo.BaseResponse;
import com.x.base.vo.HBasePager;
import com.x.ic.smc.api.billdetail.param.BillDetailDataImportRequest;
import com.x.ic.smc.api.billdetail.param.CheckResultDiffDetailQueryRequest;
import com.x.ic.smc.api.billdetail.param.CheckResultQueryRequest;
import com.x.ic.smc.api.billdetail.param.CheckResultQueryResponse;
import com.x.ic.smc.api.billdetail.param.DiffDetailDataInfo;
import com.x.ic.smc.api.billdetail.param.SettlementCheckStartRequest;

public interface IBillDetailBusiSV {

    String importBillDetailData(BillDetailDataImportRequest request);

    BaseResponse startSettlementCheck(SettlementCheckStartRequest request);

    CheckResultQueryResponse queryCheckResult(CheckResultQueryRequest request);

    HBasePager<DiffDetailDataInfo> queryCheckResultDiffDetail(
            CheckResultDiffDetailQueryRequest request);

}

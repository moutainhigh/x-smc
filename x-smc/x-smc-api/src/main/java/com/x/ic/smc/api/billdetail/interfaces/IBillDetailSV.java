package com.x.ic.smc.api.billdetail.interfaces;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.x.base.vo.BaseResponse;
import com.x.ic.smc.api.billdetail.param.BillDetailDataImportRequest;
import com.x.ic.smc.api.billdetail.param.CheckResultDiffDetailQueryRequest;
import com.x.ic.smc.api.billdetail.param.CheckResultDiffDetailQueryResponse;
import com.x.ic.smc.api.billdetail.param.CheckResultQueryRequest;
import com.x.ic.smc.api.billdetail.param.CheckResultQueryResponse;
import com.x.ic.smc.api.billdetail.param.SettlementCheckStartRequest;

@Path("/billdetail")
@Consumes({ MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_XML })
public interface IBillDetailSV {
    /**
     * 账详单文件导入服务
     * 
     * @param request
     * @return
     * @author mayt
     * @ApiDocMethod
     * @RestRelativeURL billdetail/importBillDetailData
     */
    @POST
    @Path("/importBillDetailData")
    BaseResponse importBillDetailData(BillDetailDataImportRequest request);

    /**
     * 结算对账总控服务
     * 
     * @param request
     * @return
     * @author mayt
     * @ApiDocMethod
     * @RestRelativeURL billdetail/startSettlementCheck
     */
    @POST
    @Path("/startSettlementCheck")
    BaseResponse startSettlementCheck(SettlementCheckStartRequest request);

    /**
     * 对账结果查询
     * 
     * @param request
     * @return
     * @author mayt
     * @ApiDocMethod
     * @RestRelativeURL billdetail/queryCheckResult
     */
    @POST
    @Path("/queryCheckResult")
    CheckResultQueryResponse queryCheckResult(CheckResultQueryRequest request);

    /**
     * 对账结果差异详单查询
     * 
     * @param request
     * @return
     * @author mayt
     * @ApiDocMethod
     * @RestRelativeURL billdetail/queryCheckResultDiffDetail
     */
    @POST
    @Path("/queryCheckResultDiffDetail")
    CheckResultDiffDetailQueryResponse queryCheckResultDiffDetail(
            CheckResultDiffDetailQueryRequest request);
}

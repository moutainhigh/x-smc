package com.x.ic.smc.api.billdata.interfaces;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.x.base.exception.BusinessException;
import com.x.ic.smc.api.billdata.param.QueryBillDataDetailRequest;
import com.x.ic.smc.api.billdata.param.QueryBillDataRequest;
import com.x.ic.smc.api.billdata.param.QueryBillDataResponse;
import com.x.ic.smc.api.billdata.param.QueryBillDetailResponse;

/**
 * Date: 2016年3月16日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 * 
 * @author wangjl9
 */
@Path("/billdata")
@Consumes({ MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_XML })
public interface IBillDataSV {

    /**
     * 账单信息查询<br>
     * 
     * @param queryBillDataRequest
     * @return
     * @author wangjl9
     * @ApiDocMethod
     * @RestRelativeURL billdata/queryBillData
     */
    @POST
    @Path("/queryBillData")
    QueryBillDataResponse queryBillData(QueryBillDataRequest queryBillDataRequest)
            throws BusinessException;

    /**
     * 账详单信息查询<br>
     * 
     * @param queryBillDataDetailRequest
     * @return
     * @author wangjl9
     * @ApiDocMethod
     * @RestRelativeURL billdata/queryBillDataDetail
     */
    @POST
    @Path("/queryBillDataDetail")
    QueryBillDetailResponse queryBillDataDetail(
            QueryBillDataDetailRequest queryBillDataDetailRequest) throws BusinessException;

}

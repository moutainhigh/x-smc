package com.x.ic.smc.api.querybillstyle.interfaces;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.x.base.exception.BusinessException;
import com.x.ic.smc.api.querybillstyle.param.QueryBillStyle;
import com.x.ic.smc.api.querybillstyle.param.QueryBillStyleInfo;
import com.x.ic.smc.api.querybillstyle.param.QueryBillStyleListInfo;
import com.x.ic.smc.api.querybillstyle.param.QueryBillStyleListVoResponse;

/**
 * Date: 2016年3月17日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 * 
 * @author wangjl9
 */
@Path("/querybillstyle")
@Consumes({ MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_XML })
public interface IQueryBillStyleSV {

    /**
     * 查询账单样式<br>
     * 
     * @param queryBillStyle
     * @return
     * @author wangjl9
     * @ApiDocMethod
     * @RestRelativeURL querybillstyle/queryBillStyle
     */
    @POST
    @Path("/queryBillStyle")
    QueryBillStyleInfo queryBillStyle(QueryBillStyle queryBillStyle) throws BusinessException;

    /**
     * 查询账单样式列表<br>
     * 
     * @param queryBillStyleListInfo
     * @return
     * @author wangjl9
     * @ApiDocMethod
     * @RestRelativeURL querybillstyle/queryBillStyleList
     */
    @POST
    @Path("/queryBillStyleList")
    QueryBillStyleListVoResponse queryBillStyleList(QueryBillStyleListInfo queryBillStyleListInfo)
            throws BusinessException;

}

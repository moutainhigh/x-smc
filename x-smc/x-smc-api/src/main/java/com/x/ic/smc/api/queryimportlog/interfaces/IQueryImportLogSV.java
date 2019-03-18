package com.x.ic.smc.api.queryimportlog.interfaces;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.x.base.exception.BusinessException;
import com.x.ic.smc.api.queryimportlog.param.QueryImportLogRequest;
import com.x.ic.smc.api.queryimportlog.param.QueryImportLogResponse;

/**
 * Date: 2016年4月1日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 * 
 * @author wangjl9
 */
@Path("/queryimportlog")
@Consumes({ MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_XML })
public interface IQueryImportLogSV {

    /**
     * 数据日志表查询<br>
     * 
     * @param queryImportLogRequest
     * @return
     * @throws BusinessException
     * @author wangjl9
     * @ApiDocMethod
     * @RestRelativeURL queryimportlog/queryImportLog
     */
    @POST
    @Path("/queryImportLog")
    QueryImportLogResponse queryImportLog(QueryImportLogRequest queryImportLogRequest)
            throws BusinessException;

}

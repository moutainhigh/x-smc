package com.x.ic.smc.api.sysparammanage.interfaces;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.x.base.exception.BusinessException;
import com.x.ic.smc.api.sysparammanage.param.AddSysParamInfo;
import com.x.ic.smc.api.sysparammanage.param.AddSysParamResponse;
import com.x.ic.smc.api.sysparammanage.param.DeleteSysParam;
import com.x.ic.smc.api.sysparammanage.param.DeleteSysParamResponse;
import com.x.ic.smc.api.sysparammanage.param.QuerySysParamInfo;
import com.x.ic.smc.api.sysparammanage.param.QuerySysParamResponse;
import com.x.ic.smc.api.sysparammanage.param.SysParamInfo;
import com.x.ic.smc.api.sysparammanage.param.UpdateSysParamResponse;

/**
 * Date: 2016年3月16日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 * 
 * @author wangjl9
 */
@Path("/sysparammanage")
@Consumes({ MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_XML })
public interface ISysParamManageSV {

    /**
     * 增加业务参数配置表<br>
     * 
     * @param addBillStyleInfo
     * @author wangjl9
     * @ApiDocMethod
     * @RestRelativeURL sysparammanage/addSysParam
     */
    @POST
    @Path("/addSysParam")
    AddSysParamResponse addSysParam(AddSysParamInfo addSysParamInfo) throws BusinessException;

    /**
     * 修改业务参数配置表<br>
     * 
     * @param updateBillStyleInfo
     * @author wangjl9
     * @ApiDocMethod
     * @RestRelativeURL sysparammanage/updateSysParam
     */
    @POST
    @Path("/updateSysParam")
    UpdateSysParamResponse updateSysParam(SysParamInfo sysParamInfo) throws BusinessException;

    /**
     * 删除业务参数配置表<br>
     * 
     * @param deleteSysParam
     * @author wangjl9
     * @ApiDocMethod
     * @RestRelativeURL sysparammanage/deleteSysParam
     */
    @POST
    @Path("/deleteSysParam")
    DeleteSysParamResponse deleteSysParam(DeleteSysParam deleteSysParam) throws BusinessException;

    /**
     * 查询业务参数配置表<br>
     * 
     * @param querySysParamInfo
     * @return
     * @author wangjl9
     * @ApiDocMethod
     * @RestRelativeURL sysparammanage/querySysParam
     */
    @POST
    @Path("/querySysParam")
    QuerySysParamResponse querySysParam(QuerySysParamInfo querySysParamInfo)
            throws BusinessException;
}

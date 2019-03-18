package com.x.ic.smc.api.sysparamcache.interfaces;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.x.ic.smc.api.sysparamcache.param.GetSysParamDescRequest;
import com.x.ic.smc.api.sysparamcache.param.GetSysParamListRequest;
import com.x.ic.smc.api.sysparamcache.param.GetSysParamRequest;
import com.x.ic.smc.api.sysparamcache.param.SmcSysParam;

/**
 * 从cache中获取系统参数
 * 
 * Date: 2016年4月26日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 * 
 * @author gucl
 */
@Path("/sysparamcache")
@Consumes({ MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_XML })
public interface ISmcSysParamCache {
    /**
     * 获取系统参数列表
     * 
     * @param tenantId
     * @param typeCode
     * @param paramCode
     * @return
     * @author gucl
     * @ApiDocMethod
     * @ApiCode
     * @RestRelativeURL sysparamcache/getSysParams
     */
    @POST
    @Path("/getSysParams")
    List<SmcSysParam> getSysParams(GetSysParamListRequest request);

    /**
     * 获取单个系统参数
     * 
     * @param tenantId
     * @param typeCode
     * @param paramCode
     * @param columnValue
     * @return
     * @author gucl
     * @ApiDocMethod
     * @ApiCode
     * @RestRelativeURL sysparamcache/getSysParam
     */
    @POST
    @Path("/getSysParam")
    SmcSysParam getSysParam(GetSysParamRequest request);

    /**
     * 获取系统参数对应的描述信息
     * 
     * @param tenantId
     * @param typeCode
     * @param paramCode
     * @param columnValue
     * @return
     * @author gucl
     * @ApiDocMethod
     * @ApiCode
     * @RestRelativeURL sysparamcache/getSysParamDesc
     */
    @POST
    @Path("/getSysParamDesc")
    String getSysParamDesc(GetSysParamDescRequest request);
}

package com.x.ic.smc.api.elementmanage.interfaces;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.x.base.exception.BusinessException;
import com.x.base.vo.BaseResponse;
import com.x.base.vo.PageInfo;
import com.x.ic.smc.api.elementmanage.param.ElementCreateRequest;
import com.x.ic.smc.api.elementmanage.param.ElementSearchRequest;
import com.x.ic.smc.api.elementmanage.param.ElementSearchResponseVO;
import com.x.ic.smc.api.elementmanage.param.ElementUpdateRequest;

/**
 * 
 * @author zhangbc
 * 
 */
@Path("/elementmanage")
@Consumes({ MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_XML })
public interface IElementManageSV {

    /**
     * 基础元素新增
     * 
     * @param request
     * @return
     * @throws BusinessException
     * @RestRelativeURL elementmanage/createElement
     */
    @POST
    @Path("/createElement")
    BaseResponse createElement(ElementCreateRequest request) throws BusinessException;

    /**
     * 元素注销
     * 
     * @return
     * @throws BusinessException
     * @RestRelativeURL elementmanage/deleteElement
     */
    @POST
    @Path("/deleteElement")
    BaseResponse deleteElement(Long elementId, String tenantId) throws BusinessException;

    /**
     * 元素修改
     * 
     * @return
     * @throws BusinessException
     * @RestRelativeURL elementmanage/updateElement
     */
    @POST
    @Path("/updateElement")
    BaseResponse updateElement(ElementUpdateRequest request) throws BusinessException;

    /**
     * 通过元素ID获取元素
     * 
     * @param elementId
     * @return
     * @throws BusinessException
     * @RestRelativeURL elementmanage/searchElementById
     */
    @POST
    @Path("/searchElementById")
    ElementSearchResponseVO searchElementById(long elementId) throws BusinessException;

    /**
     * 分页获取元素信息
     * 
     * @return
     * @throws BusinessException
     * @RestRelativeURL elementmanage/searchElement
     */
    @POST
    @Path("/searchElement")
    PageInfo<ElementSearchResponseVO> searchElement(ElementSearchRequest elementSearchRequest)
            throws BusinessException;

}

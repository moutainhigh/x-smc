package com.x.ic.smc.api.billstyle.interfaces;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.x.base.vo.BaseResponse;
import com.x.ic.smc.api.billstyle.param.AddBillStyleInfo;
import com.x.ic.smc.api.billstyle.param.CancelBillStyleInfo;
import com.x.ic.smc.api.billstyle.param.UpdateBillStyleInfo;

/**
 * Date: 2016年3月16日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 * 
 * @author wangjl9
 */
@Path("/billstyle")
@Consumes({ MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_XML })
public interface IBillStyleSV {

    /**
     * 增加账单样式<br>
     * 
     * @param addBillStyleInfo
     * @return
     * @author wangjl9
     * @ApiDocMethod
     * @RestRelativeURL billstyle/addBillStyle
     */
    @POST
    @Path("/addBillStyle")
    BaseResponse addBillStyle(AddBillStyleInfo addBillStyleInfo);

    /**
     * 修改账单样式<br>
     * 
     * @param updateBillStyleInfo
     * @return
     * @author wangjl9
     * @ApiDocMethod
     * @RestRelativeURL billstyle/updateBillStyle
     */
    @POST
    @Path("/updateBillStyle")
    BaseResponse updateBillStyle(UpdateBillStyleInfo updateBillStyleInfo);

    /**
     * 账单样式注销<br>
     * 
     * @param cancelBillStyleInfo
     * @return
     * @author wangjl9
     * @ApiDocMethod
     * @RestRelativeURL billstyle/cancleBillStyle
     */
    @POST
    @Path("/cancleBillStyle")
    BaseResponse cancleBillStyle(CancelBillStyleInfo cancelBillStyleInfo);
}

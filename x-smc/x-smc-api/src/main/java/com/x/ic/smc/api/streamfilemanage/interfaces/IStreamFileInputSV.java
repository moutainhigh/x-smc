package com.x.ic.smc.api.streamfilemanage.interfaces;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.x.base.vo.BaseResponse;
import com.x.ic.smc.api.streamfilemanage.param.StreamFileParam;

@Path("/streamfilemanage")
@Consumes({ MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_XML })
public interface IStreamFileInputSV {

    /**
     * 流水文件导入
     * 
     * @ApiDocMethod
     * @RestRelativeURL streamfilemanage/fileInport
     */
    @POST
    @Path("/fileInport")
    BaseResponse fileInport(StreamFileParam streamFileParam);

}

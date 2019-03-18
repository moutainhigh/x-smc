package com.x.ic.smc.service.busi.interfaces;

import com.x.base.exception.BusinessException;
import com.x.ic.smc.api.sysparammanage.param.AddSysParamInfo;
import com.x.ic.smc.api.sysparammanage.param.AddSysParamResponse;
import com.x.ic.smc.api.sysparammanage.param.DeleteSysParam;
import com.x.ic.smc.api.sysparammanage.param.DeleteSysParamResponse;
import com.x.ic.smc.api.sysparammanage.param.QuerySysParamInfo;
import com.x.ic.smc.api.sysparammanage.param.QuerySysParamResponse;
import com.x.ic.smc.api.sysparammanage.param.SysParamInfo;
import com.x.ic.smc.api.sysparammanage.param.UpdateSysParamResponse;

public interface ISysParamManageBusiSV {

    /**
     * 增加业务参数配置表<br>
     * 
     * @param addBillStyleInfo
     * @author wangjl9
     * @ApiDocMethod
     */
    AddSysParamResponse addSysParam(AddSysParamInfo addSysParamInfo) throws BusinessException;

    /**
     * 修改业务参数配置表<br>
     * 
     * @param updateBillStyleInfo
     * @author wangjl9
     * @ApiDocMethod
     */
    UpdateSysParamResponse updateSysParam(SysParamInfo sysParamInfo) throws BusinessException;

    /**
     * 删除业务参数配置表<br>
     * 
     * @param deleteSysParam
     * @author wangjl9
     * @ApiDocMethod
     */
    DeleteSysParamResponse deleteSysParam(DeleteSysParam deleteSysParam) throws BusinessException;

    /**
     * 查询业务参数配置表<br>
     * 
     * @param querySysParamInfo
     * @return
     * @author wangjl9
     * @ApiDocMethod
     */
    QuerySysParamResponse querySysParam(QuerySysParamInfo querySysParamInfo)
            throws BusinessException;

}

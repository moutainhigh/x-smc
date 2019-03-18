package com.x.ic.smc.service.busi.interfaces;

import com.x.base.exception.BusinessException;
import com.x.ic.smc.api.queryimportlog.param.QueryImportLogRequest;
import com.x.ic.smc.api.queryimportlog.param.QueryImportLogResponse;

public interface IQueryImportLogBusiSV {

    /**
     * 数据日志表查询<br>
     * 
     * @param queryImportLogRequest
     * @return
     * @throws BusinessException
     * @author wangjl9
     * @ApiDocMethod
     */
    QueryImportLogResponse queryImportLog(QueryImportLogRequest queryImportLogRequest)
            throws BusinessException;

}

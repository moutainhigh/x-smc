package com.x.ic.smc.service.atom.interfaces;

import com.x.ic.smc.dao.mapper.bo.StlImportLog;

/**
 * 数据导入日志表 - 原子服务<br>
 * Date: 2016年4月18日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 * 
 * @author mayt
 */
public interface IImportLogAtomSV {
    /**
     * 校验批次号是否已经导入
     * 
     * @param tenantId
     * @param batchNo
     * @return
     * @author mayt
     * @ApiDocMethod
     */
    boolean isExistBatchNo(String tenantId, String batchNo);

    /**
     * 将导入日志新增到共享缓存
     * 
     * @param stlImportLog
     * @author mayt
     * @ApiDocMethod
     */
    void writeLogToCache(StlImportLog stlImportLog);
}

package com.x.ic.smc.service.atom.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import com.x.base.exception.BusinessException;
import com.x.base.exception.SystemException;
import com.x.sdk.dubbo.util.DubboConsumerFactory;
import com.x.ic.dshm.api.dshmprocess.interfaces.IdshmSV;
import com.x.ic.dshm.api.dshmprocess.params.InitParams;
import com.x.ic.smc.constants.SmcCacheConstant;
import com.x.ic.smc.dao.mapper.bo.StlImportLog;
import com.x.ic.smc.dao.mapper.bo.StlImportLogCriteria;
import com.x.ic.smc.dao.mapper.factory.MapperFactory;
import com.x.ic.smc.service.atom.interfaces.IImportLogAtomSV;
import com.x.ic.smc.vo.dshm.ImportLogDshmVO;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

@Component
public class ImportLogAtomSVImpl implements IImportLogAtomSV {
    private static final Logger LOG = LogManager.getLogger(ImportLogAtomSVImpl.class);

    @Override
    public boolean isExistBatchNo(String tenantId, String batchNo) {
        StlImportLogCriteria importLogCriteria = new StlImportLogCriteria();
        importLogCriteria.createCriteria().andTenantIdEqualTo(tenantId).andBatchNoEqualTo(batchNo);
        int count = MapperFactory.getStlImportLogMapper().countByExample(importLogCriteria);
        if (count > 0) {
            return true;
        }
        return false;
    }

    @Override
    public void writeLogToCache(StlImportLog stlImportLog) {
        LOG.info("将文件导入日志写入共享缓存...");
        ImportLogDshmVO dshmVO = new ImportLogDshmVO();
        dshmVO.setBatch_no(stlImportLog.getBatchNo());
        dshmVO.setBill_time_sn(stlImportLog.getBillTimeSn());
        dshmVO.setData_type(stlImportLog.getDataType());
        dshmVO.setImp_file_name(stlImportLog.getImpFileName());
        dshmVO.setImp_file_url(stlImportLog.getImpFileUrl());
        dshmVO.setImport_records(stlImportLog.getImportRecords());
        dshmVO.setImport_time(stlImportLog.getImportTime());
        dshmVO.setLog_id(stlImportLog.getLogId());
        dshmVO.setObject_id(stlImportLog.getObjectId());
        dshmVO.setTenant_id(stlImportLog.getTenantId());

        IdshmSV idshmSV = DubboConsumerFactory.getService(IdshmSV.class);
        int a;
        try {
        	InitParams param = new InitParams();
        	param.setTableName(SmcCacheConstant.Dshm.TableName.STL_IMPORT_LOG);
        	param.setObj(JSON.toJSONString(dshmVO));
        	param.setType(SmcCacheConstant.Dshm.OptType.INSERT);
        	JSONObject.toJSONString(param);
            a = idshmSV.initLoader(param);
        } catch (BusinessException e) {
            LOG.error("写入共享缓存失败", e);
            throw e;
        } catch (Exception e) {
            LOG.error("写入共享缓存失败", e);
            throw new SystemException(e);
        }
        LOG.info(a);
    }

}

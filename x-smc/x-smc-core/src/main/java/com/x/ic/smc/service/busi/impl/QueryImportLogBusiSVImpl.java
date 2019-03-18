package com.x.ic.smc.service.busi.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.x.base.exception.BusinessException;
import com.x.base.vo.PageInfo;
import com.x.base.vo.ResponseHeader;
import com.x.sdk.util.BeanUtils;
import com.x.ic.smc.api.queryimportlog.param.ImportLogVo;
import com.x.ic.smc.api.queryimportlog.param.QueryImportLogRequest;
import com.x.ic.smc.api.queryimportlog.param.QueryImportLogResponse;
import com.x.ic.smc.dao.mapper.bo.StlImportLog;
import com.x.ic.smc.dao.mapper.bo.StlImportLogCriteria;
import com.x.ic.smc.dao.mapper.factory.MapperFactory;
import com.x.ic.smc.dao.mapper.interfaces.StlImportLogMapper;
import com.x.ic.smc.service.busi.interfaces.IQueryImportLogBusiSV;

@Service
@Transactional
public class QueryImportLogBusiSVImpl implements IQueryImportLogBusiSV {

    @Override
    public QueryImportLogResponse queryImportLog(QueryImportLogRequest queryImportLogRequest)
            throws BusinessException {
        QueryImportLogResponse queryImportLogResponse = new QueryImportLogResponse();
        StlImportLogCriteria stlImportLogCriteria = new StlImportLogCriteria();
        StlImportLogCriteria.Criteria criteria = stlImportLogCriteria.createCriteria();
        String orderByClause = "IMPORT_TIME desc,STATE_CHG_TIME desc";
        stlImportLogCriteria.setOrderByClause(orderByClause);
        criteria.andTenantIdEqualTo(queryImportLogRequest.getTenantId());
        if (!StringUtils.isBlank(queryImportLogRequest.getBatchNo())) {
            criteria.andBatchNoEqualTo(queryImportLogRequest.getBatchNo());
        }
        if (!StringUtils.isBlank(queryImportLogRequest.getDataType())) {
            criteria.andDataTypeEqualTo(queryImportLogRequest.getDataType());
        }
        if (!StringUtils.isBlank(queryImportLogRequest.getImpFileName())) {
            criteria.andImpFileNameEqualTo(queryImportLogRequest.getImpFileName());
        }
        if (!StringUtils.isBlank(queryImportLogRequest.getObjectId())) {
            criteria.andObjectIdEqualTo(queryImportLogRequest.getObjectId());
        }
        if (!StringUtils.isBlank(queryImportLogRequest.getState())) {
            criteria.andStateEqualTo(queryImportLogRequest.getState());
        }
        if (!StringUtils.isBlank(queryImportLogRequest.getStartTime())) {
            criteria.andImportTimeGreaterThan(Timestamp.valueOf(queryImportLogRequest
                    .getStartTime()));
        }
        if (!StringUtils.isBlank(queryImportLogRequest.getEndTime())) {
            criteria.andImportTimeLessThan(Timestamp.valueOf(queryImportLogRequest.getEndTime()));
        }
        StlImportLogMapper mapper = MapperFactory.getStlImportLogMapper();

        PageInfo<ImportLogVo> pageInfo = new PageInfo<ImportLogVo>();
        pageInfo.setCount(mapper.countByExample(stlImportLogCriteria));

        if (queryImportLogRequest.getPageInfo() == null) {
            pageInfo.setPageNo(1);
            pageInfo.setPageSize(pageInfo.getCount() == 0 ? 10 : pageInfo.getCount());
        } else {
            pageInfo.setPageNo(queryImportLogRequest.getPageInfo().getPageNo());
            pageInfo.setPageSize(queryImportLogRequest.getPageInfo().getPageSize());
            stlImportLogCriteria.setLimitStart(pageInfo.getStartRowIndex());
            stlImportLogCriteria.setLimitEnd(pageInfo.getPageSize());
        }
        List<StlImportLog> stlImportLogs = mapper.selectByExample(stlImportLogCriteria);
        if (stlImportLogs.size() != 0) {
            List<ImportLogVo> result = new ArrayList<ImportLogVo>();
            for (StlImportLog stlImportLog : stlImportLogs) {
                ImportLogVo importLogVo = new ImportLogVo();
                BeanUtils.copyVO(importLogVo, stlImportLog);
                result.add(importLogVo);
            }
            pageInfo.setResult(result);
        }
        ResponseHeader responseHeader = new ResponseHeader(true, "000000", "成功");
        queryImportLogResponse.setResponseHeader(responseHeader);
        queryImportLogResponse.setPageInfo(pageInfo);
        return queryImportLogResponse;
    }

}

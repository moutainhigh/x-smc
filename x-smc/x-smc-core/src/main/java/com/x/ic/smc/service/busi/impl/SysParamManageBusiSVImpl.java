package com.x.ic.smc.service.busi.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.x.base.exception.BusinessException;
import com.x.base.vo.PageInfo;
import com.x.base.vo.ResponseHeader;
import com.x.sdk.util.BeanUtils;
import com.x.sdk.util.DateUtil;
import com.x.sdk.util.StringUtil;
import com.x.ic.smc.api.sysparammanage.param.AddSysParamInfo;
import com.x.ic.smc.api.sysparammanage.param.AddSysParamResponse;
import com.x.ic.smc.api.sysparammanage.param.DeleteSysParam;
import com.x.ic.smc.api.sysparammanage.param.DeleteSysParamResponse;
import com.x.ic.smc.api.sysparammanage.param.QuerySysParamInfo;
import com.x.ic.smc.api.sysparammanage.param.QuerySysParamResponse;
import com.x.ic.smc.api.sysparammanage.param.SysParamInfo;
import com.x.ic.smc.api.sysparammanage.param.UpdateSysParamResponse;
import com.x.ic.smc.constants.SmcExceptCodeConstant;
import com.x.ic.smc.dao.mapper.bo.StlSysParam;
import com.x.ic.smc.dao.mapper.bo.StlSysParamCriteria;
import com.x.ic.smc.dao.mapper.factory.MapperFactory;
import com.x.ic.smc.dao.mapper.interfaces.StlSysParamMapper;
import com.x.ic.smc.service.busi.interfaces.ISysParamManageBusiSV;
import com.x.ic.smc.util.SmcSeqUtil;

@Service
@Transactional
public class SysParamManageBusiSVImpl implements ISysParamManageBusiSV {

    @Override
    public AddSysParamResponse addSysParam(AddSysParamInfo addSysParamInfo)
            throws BusinessException {
        StlSysParam stlSysParam = new StlSysParam();
        BeanUtils.copyVO(stlSysParam, addSysParamInfo);
        stlSysParam.setTenantId(addSysParamInfo.getTenantId());
        stlSysParam.setGuidkey(SmcSeqUtil.createGuidkey());
        stlSysParam.setState("1");
        stlSysParam.setUpdateTime(DateUtil.getSysDate());
        MapperFactory.getStlSysParamMapper().insert(stlSysParam);
        // SysParamUtil.writeSysParam(stlSysParam);
        AddSysParamResponse addSysParamResponse = new AddSysParamResponse();
        ResponseHeader responseHeader = new ResponseHeader(true, "000000", "成功");
        addSysParamResponse.setResponseHeader(responseHeader);
        return addSysParamResponse;
    }

    @Override
    public UpdateSysParamResponse updateSysParam(SysParamInfo sysParamInfo)
            throws BusinessException {
        UpdateSysParamResponse updateSysParamResponse = new UpdateSysParamResponse();
        StlSysParamCriteria stlSysParamCriteria = new StlSysParamCriteria();

        StlSysParamCriteria.Criteria criteria = stlSysParamCriteria.createCriteria();
        criteria.andTenantIdEqualTo(sysParamInfo.getTenantId());
        criteria.andGuidkeyEqualTo(sysParamInfo.getGuidkey());
        StlSysParamMapper mapper = MapperFactory.getStlSysParamMapper();
        if (mapper.selectByExample(stlSysParamCriteria).size() == 0) {
            throw new BusinessException(SmcExceptCodeConstant.NO_DATA_OR_CACAE_ERROR,
                    sysParamInfo.getGuidkey() + "此guidId不存在，不可修改");
        }

        StlSysParam stlSysParam = new StlSysParam();
        BeanUtils.copyVO(stlSysParam, sysParamInfo);
        stlSysParam.setTenantId(sysParamInfo.getTenantId());
        stlSysParam.setUpdateTime(DateUtil.getSysDate());
        mapper.updateByExampleSelective(stlSysParam, stlSysParamCriteria);
        // SysParamUtil.writeSysParam(stlSysParam);
        ResponseHeader responseHeader = new ResponseHeader(true, "000000", "成功");
        updateSysParamResponse.setResponseHeader(responseHeader);
        return updateSysParamResponse;
    }

    @Override
    public DeleteSysParamResponse deleteSysParam(DeleteSysParam deleteSysParam)
            throws BusinessException {
        DeleteSysParamResponse deleteSysParamResponse = new DeleteSysParamResponse();

        StlSysParamCriteria stlSysParamCriteria = new StlSysParamCriteria();
        StlSysParamCriteria.Criteria criteria = stlSysParamCriteria.createCriteria();
        criteria.andTenantIdEqualTo(deleteSysParam.getTenantId());
        criteria.andGuidkeyEqualTo(deleteSysParam.getGuidkey());
        StlSysParamMapper mapper = MapperFactory.getStlSysParamMapper();
        if (mapper.selectByExample(stlSysParamCriteria).size() == 0) {
            throw new BusinessException(SmcExceptCodeConstant.NO_DATA_OR_CACAE_ERROR,
                    deleteSysParam.getGuidkey() + "此guidId不存在，不可删除");
        }
        StlSysParam stlSysParam = new StlSysParam();
        stlSysParam.setState("0");

        mapper.updateByExampleSelective(stlSysParam, stlSysParamCriteria);
        ResponseHeader responseHeader = new ResponseHeader(true, "000000", "成功");
        deleteSysParamResponse.setResponseHeader(responseHeader);
        return deleteSysParamResponse;
    }

    @Override
    public QuerySysParamResponse querySysParam(QuerySysParamInfo querySysParamInfo)
            throws BusinessException {
        QuerySysParamResponse querySysParamResponse = new QuerySysParamResponse();
        List<SysParamInfo> sysParamInfos = null;
        StlSysParamCriteria stlSysParamCriteria = new StlSysParamCriteria();
        StlSysParamCriteria.Criteria criteria = stlSysParamCriteria.createCriteria();
        criteria.andTenantIdEqualTo(querySysParamInfo.getTenantId());
        if (!StringUtil.isBlank(querySysParamInfo.getTypeCode())) {
            criteria.andTypeCodeEqualTo(querySysParamInfo.getTypeCode());
        }
        if (!StringUtil.isBlank(querySysParamInfo.getParamCode())) {
            criteria.andParamCodeEqualTo(querySysParamInfo.getParamCode());
        }
        if (!StringUtil.isBlank(querySysParamInfo.getColumnValue())) {
            criteria.andColumnValueEqualTo(querySysParamInfo.getColumnValue());
        }
        if (!StringUtil.isBlank(querySysParamInfo.getColumnDesc())) {
            criteria.andColumnDescEqualTo(querySysParamInfo.getColumnDesc());
        }
        if (!StringUtil.isBlank(querySysParamInfo.getSubParamCode())) {
            criteria.andSubParamCodeEqualTo(querySysParamInfo.getSubParamCode());
        }
        if (!StringUtil.isBlank(querySysParamInfo.getParentValue())) {
            criteria.andParentValueEqualTo(querySysParamInfo.getParentValue());
        }
        if (querySysParamInfo.getDispord() != null) {
            criteria.andDispordEqualTo(querySysParamInfo.getDispord());
        }
        if (!StringUtil.isBlank(querySysParamInfo.getDescb())) {
            criteria.andDescbLike("%" + querySysParamInfo.getDescb() + "%");
        }
        if (!StringUtil.isBlank(querySysParamInfo.getState())) {
            criteria.andStateEqualTo(querySysParamInfo.getState());
        }
        if (!StringUtil.isBlank(querySysParamInfo.getUpdateDeptId())) {
            criteria.andStateEqualTo(querySysParamInfo.getState());
        }
        if (!StringUtil.isBlank(querySysParamInfo.getUpdateOperId())) {
            criteria.andUpdateDeptIdEqualTo(querySysParamInfo.getUpdateOperId());
        }
        if (querySysParamInfo.getUpdateTime() != null) {
            criteria.andUpdateTimeEqualTo(querySysParamInfo.getUpdateTime());
        }

        StlSysParamMapper mapper = MapperFactory.getStlSysParamMapper();
        PageInfo<SysParamInfo> pageInfo = new PageInfo<SysParamInfo>();
        pageInfo.setCount(mapper.countByExample(stlSysParamCriteria));
        if (querySysParamInfo.getPageInfo() == null) {
            pageInfo.setPageNo(1);
            pageInfo.setPageSize(pageInfo.getCount() == 0 ? 10 : pageInfo.getCount());
        } else {
            stlSysParamCriteria.setLimitStart(querySysParamInfo.getPageInfo().getStartRowIndex());
            stlSysParamCriteria.setLimitEnd(querySysParamInfo.getPageInfo().getPageSize());
            pageInfo.setPageNo(querySysParamInfo.getPageInfo().getPageNo());
            pageInfo.setPageSize(querySysParamInfo.getPageInfo().getPageSize());
        }

        List<StlSysParam> stlSysParams = mapper.selectByExample(stlSysParamCriteria);
        if (stlSysParams != null) {
            sysParamInfos = new ArrayList<SysParamInfo>();
            for (StlSysParam stlSysParam : stlSysParams) {
                SysParamInfo sysParamInfo = new SysParamInfo();
                BeanUtils.copyVO(sysParamInfo, stlSysParam);
                sysParamInfo.setTenantId(stlSysParam.getTenantId());
                sysParamInfos.add(sysParamInfo);
            }
            pageInfo.setResult(sysParamInfos);
        }

        ResponseHeader responseHeader = new ResponseHeader(true, "000000", "成功");
        querySysParamResponse.setPageInfo(pageInfo);
        querySysParamResponse.setResponseHeader(responseHeader);
        return querySysParamResponse;
    }

}

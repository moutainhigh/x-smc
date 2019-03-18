package com.x.ic.smc.service.busi.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.x.base.exception.BusinessException;
import com.x.base.vo.PageInfo;
import com.x.base.vo.ResponseHeader;
import com.x.sdk.util.StringUtil;
import com.x.ic.smc.api.querybillstyle.param.QueryBillStyle;
import com.x.ic.smc.api.querybillstyle.param.QueryBillStyleDetailVo;
import com.x.ic.smc.api.querybillstyle.param.QueryBillStyleInfo;
import com.x.ic.smc.api.querybillstyle.param.QueryBillStyleListInfo;
import com.x.ic.smc.api.querybillstyle.param.QueryBillStyleListVo;
import com.x.ic.smc.api.querybillstyle.param.QueryBillStyleListVoResponse;
import com.x.ic.smc.dao.mapper.bo.StlBillDetailStyleItem;
import com.x.ic.smc.dao.mapper.bo.StlBillDetailStyleItemCriteria;
import com.x.ic.smc.dao.mapper.bo.StlBillStyle;
import com.x.ic.smc.dao.mapper.bo.StlBillStyleCriteria;
import com.x.ic.smc.dao.mapper.factory.MapperFactory;
import com.x.ic.smc.dao.mapper.interfaces.StlBillStyleMapper;
import com.x.ic.smc.service.busi.interfaces.IQueryBillStyleBusiSV;

@Service
@Transactional
public class QueryBillStyleBusiSVImpl implements IQueryBillStyleBusiSV {

    @Override
    public QueryBillStyleInfo queryBillStyle(QueryBillStyle queryBillStyle)
            throws BusinessException {
        // TODO Auto-generated method stub
        ResponseHeader responseHeader = new ResponseHeader();
        String tenantId = queryBillStyle.getTenantId();
        Long billStyleId = queryBillStyle.getBillStyleId();
        // List<QueryBillStyleVo> queryBillStyleVos = null;
        List<QueryBillStyleDetailVo> queryBillStyleDetailVos = null;
        QueryBillStyleInfo queryBillStyleInfo = new QueryBillStyleInfo();
        StlBillStyleCriteria stlBillStyleCriteria = new StlBillStyleCriteria();
        StlBillStyleCriteria.Criteria criteria = stlBillStyleCriteria.createCriteria();
        criteria.andTenantIdEqualTo(tenantId);
        criteria.andBillStyleIdEqualTo(billStyleId);
        criteria.andStateEqualTo("1");
        List<StlBillStyle> stlBillStyles = MapperFactory.getStlBillStyleMapper().selectByExample(
                stlBillStyleCriteria);
        if (stlBillStyles.size() == 0) {
            responseHeader.setSuccess(true);
            responseHeader.setResultCode("000000");
            responseHeader.setResultMessage("成功");
            queryBillStyleInfo.setResponseHeader(responseHeader);
            return queryBillStyleInfo;
        }
        BeanUtils.copyProperties(stlBillStyles.get(0), queryBillStyleInfo);

        // StlBillStyleItemCriteria stlBillStyleItemCriteria = new StlBillStyleItemCriteria();
        // StlBillStyleItemCriteria.Criteria criteria2 = stlBillStyleItemCriteria.createCriteria();
        // criteria2.andTenantIdEqualTo(tenantId);
        // criteria2.andBillStyleIdEqualTo(billStyleId);
        // List<StlBillStyleItem> stlBillStyleItems = MapperFactory.getStlBillStyleItemMapper()
        // .selectByExample(stlBillStyleItemCriteria);
        // if (stlBillStyleItems != null) {
        // queryBillStyleVos = new ArrayList<QueryBillStyleVo>();
        // for (StlBillStyleItem stlBillStyleItem : stlBillStyleItems) {
        // QueryBillStyleVo queryBillStyleVo = new QueryBillStyleVo();
        // BeanUtils.copyProperties(stlBillStyleItem, queryBillStyleVo);
        // queryBillStyleVos.add(queryBillStyleVo);
        // }
        // queryBillStyleInfo.setQueryBillStyleVos(queryBillStyleVos);
        // }

        StlBillDetailStyleItemCriteria stlBillDetailStyleItemCriteria = new StlBillDetailStyleItemCriteria();
        StlBillDetailStyleItemCriteria.Criteria criteria3 = stlBillDetailStyleItemCriteria
                .createCriteria();
        criteria3.andTenantIdEqualTo(tenantId);
        criteria3.andBillStyleIdEqualTo(billStyleId);
        List<StlBillDetailStyleItem> stlBillDetailStyleItems = MapperFactory
                .getStlBillDetailStyleItemMapper().selectByExample(stlBillDetailStyleItemCriteria);
        if (stlBillDetailStyleItems != null) {
            queryBillStyleDetailVos = new ArrayList<QueryBillStyleDetailVo>();
            for (StlBillDetailStyleItem stlBillDetailStyleItem : stlBillDetailStyleItems) {
                QueryBillStyleDetailVo queryBillStyleDetailVo = new QueryBillStyleDetailVo();
                BeanUtils.copyProperties(stlBillDetailStyleItem, queryBillStyleDetailVo);
                queryBillStyleDetailVos.add(queryBillStyleDetailVo);
            }
            queryBillStyleInfo.setQueryBillStyleDetailVos(queryBillStyleDetailVos);
        }
        responseHeader.setSuccess(true);
        responseHeader.setResultCode("000000");
        responseHeader.setResultMessage("成功");
        queryBillStyleInfo.setResponseHeader(responseHeader);
        return queryBillStyleInfo;
    }

    @Override
    public QueryBillStyleListVoResponse queryBillStyleList(
            QueryBillStyleListInfo queryBillStyleListInfo) throws BusinessException {
        // TODO Auto-generated method stub
        QueryBillStyleListVoResponse queryBillStyleListVoResponse = new QueryBillStyleListVoResponse();
        StlBillStyleCriteria stlBillStyleCriteria = new StlBillStyleCriteria();
        StlBillStyleCriteria.Criteria criteria = stlBillStyleCriteria.createCriteria();
        criteria.andTenantIdEqualTo(queryBillStyleListInfo.getTenantId());
        criteria.andStateEqualTo("1");
        if (!StringUtil.isBlank(queryBillStyleListInfo.getBillStyleSn())) {
            criteria.andBillStyleSnEqualTo(queryBillStyleListInfo.getBillStyleSn());
        }
        if (queryBillStyleListInfo.getBillStyleId() != null) {
            criteria.andBillStyleIdEqualTo(queryBillStyleListInfo.getBillStyleId());
        }
        if (!StringUtil.isBlank(queryBillStyleListInfo.getBillTitle())) {
            criteria.andBillTitleEqualTo(queryBillStyleListInfo.getBillTitle());
        }
        if (!StringUtil.isBlank(queryBillStyleListInfo.getState())) {
            criteria.andStateEqualTo(queryBillStyleListInfo.getState());
        }
        if (!StringUtil.isBlank(queryBillStyleListInfo.getCreateDeptId())) {
            criteria.andCreateDeptIdEqualTo(queryBillStyleListInfo.getCreateDeptId());
        }
        if (!StringUtil.isBlank(queryBillStyleListInfo.getCreateOperId())) {
            criteria.andCreateDeptIdEqualTo(queryBillStyleListInfo.getCreateOperId());
        }
        if (queryBillStyleListInfo.getCreateTime() != null) {
            criteria.andCreateTimeEqualTo(queryBillStyleListInfo.getCreateTime());
        }
        if (!StringUtil.isBlank(queryBillStyleListInfo.getUpdateDeptId())) {
            criteria.andUpdateDeptIdEqualTo(queryBillStyleListInfo.getUpdateDeptId());
        }
        if (!StringUtil.isBlank(queryBillStyleListInfo.getUpdateOperId())) {
            criteria.andUpdateDeptIdEqualTo(queryBillStyleListInfo.getUpdateOperId());
        }
        if (queryBillStyleListInfo.getUpdateTime() != null) {
            criteria.andUpdateTimeEqualTo(queryBillStyleListInfo.getUpdateTime());
        }
        StlBillStyleMapper mapper = MapperFactory.getStlBillStyleMapper();

        PageInfo<QueryBillStyleListVo> pageInfo = new PageInfo<QueryBillStyleListVo>();
        pageInfo.setCount(mapper.countByExample(stlBillStyleCriteria));

        if (queryBillStyleListInfo.getPageInfo() == null) {
            pageInfo.setPageNo(1);
            pageInfo.setPageSize(pageInfo.getCount() == 0 ? 10 : pageInfo.getCount());
        } else {
            stlBillStyleCriteria.setLimitStart(queryBillStyleListInfo.getPageInfo()
                    .getStartRowIndex());
            stlBillStyleCriteria.setLimitEnd(queryBillStyleListInfo.getPageInfo().getPageSize());
            pageInfo.setPageNo(queryBillStyleListInfo.getPageInfo().getPageNo());
            pageInfo.setPageSize(queryBillStyleListInfo.getPageInfo().getPageSize());
        }

        List<StlBillStyle> stlBillStyles = mapper.selectByExample(stlBillStyleCriteria);
        if (stlBillStyles != null) {
            List<QueryBillStyleListVo> queryBillStyleListVos = new ArrayList<QueryBillStyleListVo>();
            for (StlBillStyle stlBillStyle : stlBillStyles) {
                QueryBillStyleListVo queryBillStyleListVo = new QueryBillStyleListVo();
                BeanUtils.copyProperties(stlBillStyle, queryBillStyleListVo);
                queryBillStyleListVos.add(queryBillStyleListVo);
            }
            pageInfo.setResult(queryBillStyleListVos);
        }
        queryBillStyleListVoResponse.setPageInfo(pageInfo);
        ResponseHeader responseHeader = new ResponseHeader();
        responseHeader.setSuccess(true);
        responseHeader.setResultCode("000000");
        responseHeader.setResultMessage("成功");
        queryBillStyleListVoResponse.setResponseHeader(responseHeader);
        return queryBillStyleListVoResponse;
    }

}

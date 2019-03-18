package com.x.ic.smc.service.busi.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.x.base.exception.BusinessException;
import com.x.base.vo.PageInfo;
import com.x.sdk.util.StringUtil;
import com.x.ic.smc.api.elementmanage.param.ElementSearchRequest;
import com.x.ic.smc.api.elementmanage.param.ElementSearchResponseVO;
import com.x.ic.smc.constants.SmcExceptCodeConstant;
import com.x.ic.smc.constants.SmcConstants;
import com.x.ic.smc.dao.mapper.bo.StlElement;
import com.x.ic.smc.dao.mapper.bo.StlElementCriteria;
import com.x.ic.smc.dao.mapper.bo.StlElementCriteria.Criteria;
import com.x.ic.smc.dao.mapper.factory.MapperFactory;
import com.x.ic.smc.dao.mapper.interfaces.StlElementMapper;
import com.x.ic.smc.service.busi.interfaces.IElementManageBusiSV;

@Component
@Transactional
public class ElementManageBusiSVImpl implements IElementManageBusiSV {

    @Override
    public void createElement(StlElement stlElement) {
        // TODO Auto-generated method stub
        MapperFactory.getElementMapper().insert(stlElement);
    }

    @Override
    public void deleteElement(Long elementId, String tenantId) throws BusinessException {
        // TODO Auto-generated method stub
        StlElement stlElement = MapperFactory.getElementMapper().selectByPrimaryKey(elementId);
        if (null == stlElement) {
            throw new BusinessException(SmcExceptCodeConstant.PARAM_IS_NULL, "[元素]不存在");
        }
        if ("1".equals(stlElement.getState())) {

            if (!tenantId.equals(stlElement.getTenantId())) {
                throw new BusinessException(SmcExceptCodeConstant.PARAM_IS_NULL, "[元素]不存在");
            }
            stlElement.setState(SmcConstants.StlElement.State.CANCELLED);
            MapperFactory.getElementMapper().updateByPrimaryKey(stlElement);
        }
    }

    @Override
    public void updateElement(StlElement stlElement) {

        MapperFactory.getElementMapper().updateByPrimaryKey(stlElement);
    }

    @Override
    public StlElement searchElementById(Long elementId) {
        // TODO Auto-generated method stub
        return MapperFactory.getElementMapper().selectByPrimaryKey(elementId);
    }

    @Override
    public PageInfo<ElementSearchResponseVO> searchElementList(ElementSearchRequest request) {
        // TODO Auto-generated method stub
        StlElementCriteria stlElementCriteria = new StlElementCriteria();
        Criteria criteria = stlElementCriteria.createCriteria();

        if (!StringUtil.isBlank(request.getElementCode())) {
            criteria.andElementCodeEqualTo(request.getElementCode());
        }

        if (!StringUtil.isBlank(request.getAttrType())) {
            criteria.andAttrTypeEqualTo(request.getAttrType());
        }
        if (!StringUtil.isBlank(request.getElementType())) {
            criteria.andElementTypeEqualTo(request.getElementType());
        }
        if (!StringUtil.isBlank(request.getIsSettlement())) {
            criteria.andIsSettlementEqualTo(request.getIsSettlement());
        }
        if (!StringUtil.isBlank(request.getState())) {
            criteria.andStateEqualTo(request.getState());
        }
        if (!StringUtil.isBlank(request.getStatisticsCyc())) {
            criteria.andStatisticsCycEqualTo(request.getStatisticsCyc());
        }
        if (!StringUtil.isBlank(request.getObjectId())) {
            criteria.andObjectIdEqualTo(request.getObjectId());
        }
        criteria.andTenantIdEqualTo(request.getTenantId());
        criteria.andStateEqualTo(SmcConstants.StlElement.State.NORMAL);
        StlElementMapper mapper = MapperFactory.getElementMapper();

        PageInfo<ElementSearchResponseVO> pageInfo = new PageInfo<ElementSearchResponseVO>();
        pageInfo.setCount(mapper.countByExample(stlElementCriteria));

        if (request.getPageInfo() == null) {
            pageInfo = new PageInfo<ElementSearchResponseVO>();
            pageInfo.setPageNo(1);
            pageInfo.setPageSize(pageInfo.getCount() == 0 ? 10 : pageInfo.getCount());
        } else {
            stlElementCriteria.setLimitStart(request.getPageInfo().getStartRowIndex() - 1);
            stlElementCriteria.setLimitEnd(request.getPageInfo().getPageSize());
            pageInfo.setPageNo(request.getPageInfo().getPageNo());
            pageInfo.setPageSize(request.getPageInfo().getPageSize());
        }

        List<StlElement> list = mapper.selectByExample(stlElementCriteria);
        if (list != null) {
            List<ElementSearchResponseVO> elementList = new ArrayList<ElementSearchResponseVO>();
            for (StlElement stlElement : list) {
                ElementSearchResponseVO elmentSearchVo = new ElementSearchResponseVO();
                BeanUtils.copyProperties(stlElement, elmentSearchVo);
                elementList.add(elmentSearchVo);
            }
            pageInfo.setResult(elementList);
        }

        return pageInfo;
    }

    @Override
    public boolean checkElementCode(StlElement stlElement) {
        // TODO Auto-generated method stub
        StlElementCriteria stlElementCriteria = new StlElementCriteria();
        Criteria criteria = stlElementCriteria.createCriteria();
        criteria.andTenantIdEqualTo(stlElement.getTenantId());
        criteria.andObjectIdEqualTo(stlElement.getObjectId());
        criteria.andElementCodeEqualTo(stlElement.getElementCode());
        List<StlElement> list = MapperFactory.getElementMapper()
                .selectByExample(stlElementCriteria);
        return list.size() > 0;
    }

}

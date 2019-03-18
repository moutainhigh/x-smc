package com.x.ic.smc.api.elementmanage.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.x.base.exception.BusinessException;
import com.x.base.vo.BaseResponse;
import com.x.base.vo.PageInfo;
import com.x.base.vo.ResponseHeader;
import com.x.sdk.util.StringUtil;
import com.x.ic.smc.api.elementmanage.interfaces.IElementManageSV;
import com.x.ic.smc.api.elementmanage.param.AttributeRecord;
import com.x.ic.smc.api.elementmanage.param.ElementCreateRequest;
import com.x.ic.smc.api.elementmanage.param.ElementSearchRequest;
import com.x.ic.smc.api.elementmanage.param.ElementSearchResponseVO;
import com.x.ic.smc.api.elementmanage.param.ElementUpdateRequest;
import com.x.ic.smc.constants.SmcExceptCodeConstant;
import com.x.ic.smc.constants.SmcConstants;
import com.x.ic.smc.dao.mapper.bo.StlElement;
import com.x.ic.smc.dao.mapper.bo.StlElementAttr;
import com.x.ic.smc.service.busi.interfaces.IElementAttrManageBusiSV;
import com.x.ic.smc.service.busi.interfaces.IElementManageBusiSV;
import com.x.ic.smc.util.BusinessUtil;
import com.x.ic.smc.util.DateTimeUtil;
import com.x.ic.smc.util.SmcSeqUtil;
import com.alibaba.dubbo.config.annotation.Service;

@Service
public class ElementManageSVImpl implements IElementManageSV {

    @SuppressWarnings("unused")
    private static final Logger LOGGER = LogManager.getLogger();

    @Autowired
    private transient IElementManageBusiSV iElementManageBusiSV;

    @Autowired
    private transient IElementAttrManageBusiSV iElementAttrManageBusiSV;

    @Override
    public BaseResponse createElement(ElementCreateRequest request) throws BusinessException {
        BusinessUtil.checkBaseInfo(request);
        checkRequest(request);
        Long elementId = SmcSeqUtil.createElementId();
        StlElement stlElement = new StlElement();
        BeanUtils.copyProperties(request, stlElement);
        stlElement.setElementId(elementId);
        stlElement.setState(SmcConstants.StlElement.State.NORMAL);
        stlElement.setCreateTime(DateTimeUtil.getNowTimeStamp());
        checkElementCode(stlElement);
        iElementManageBusiSV.createElement(stlElement);

        if (null != request.getAttributeRecord()) {
            StlElementAttr strElementAttr = new StlElementAttr();
            Long attrId = SmcSeqUtil.createElementAttrId();
            strElementAttr.setElementId(elementId);
            strElementAttr.setAttrId(attrId);
            strElementAttr.setTenantId(request.getTenantId());
            strElementAttr.setUpdateTime(DateTimeUtil.getNowTimeStamp());
            BeanUtils.copyProperties(request.getAttributeRecord(), strElementAttr);
            iElementAttrManageBusiSV.createElementAttr(strElementAttr);
        }
        ResponseHeader responseHeader = new ResponseHeader(true, SmcExceptCodeConstant.SUCCESS,
                "成功");
        BaseResponse response = new BaseResponse();
        response.setResponseHeader(responseHeader);
        return response;
    }

    private void checkRequest(ElementCreateRequest request) throws BusinessException {

        if (StringUtil.isBlank(request.getElementCode())) {
            throw new BusinessException(SmcExceptCodeConstant.PARAM_IS_NULL, "[元素编码]不能为空");
        }
        if (StringUtil.isBlank(request.getTenantId())) {
            throw new BusinessException(SmcExceptCodeConstant.PARAM_IS_NULL, "[租户]不能为空");
        }
        if (StringUtil.isBlank(request.getElementName())) {
            throw new BusinessException(SmcExceptCodeConstant.PARAM_IS_NULL, "[元素名称]不能为空");
        }
        if (StringUtil.isBlank(request.getObjectId())) {
            throw new BusinessException(SmcExceptCodeConstant.PARAM_IS_NULL, "[归属对象]不能为空");
        }
        if (StringUtil.isBlank(request.getAttrType())) {
            throw new BusinessException(SmcExceptCodeConstant.PARAM_IS_NULL, "[属性分类]不能为空");
        }
        if (StringUtil.isBlank(request.getIsSettlement())) {
            throw new BusinessException(SmcExceptCodeConstant.PARAM_IS_NULL, "[是否结算对象]不能为空");
        }
        if (StringUtil.isBlank(request.getValueType())) {
            throw new BusinessException(SmcExceptCodeConstant.PARAM_IS_NULL, "[属性值类型]不能为空");
        }
        if (StringUtil.isBlank(request.getIsNecessary())) {
            throw new BusinessException(SmcExceptCodeConstant.PARAM_IS_NULL, "[是否必填]不能为空");
        }
        if (StringUtil.isBlank(request.getElementType())) {
            throw new BusinessException(SmcExceptCodeConstant.PARAM_IS_NULL, "[元素类型]不能为空");
        }
        if (StringUtil.isBlank(request.getDataCreateType())) {
            throw new BusinessException(SmcExceptCodeConstant.PARAM_IS_NULL, "[数据生成方式]不能为空");
        }
        if (StringUtil.isBlank(request.getDataCreateType())) {
            throw new BusinessException(SmcExceptCodeConstant.PARAM_IS_NULL, "[数据生成方式]不能为空");
        }

        if (SmcConstants.StlElement.Type.STATISTICS.equals(request.getAttrType())) {
            if (null == request.getAttributeRecord()) {
                throw new BusinessException(SmcExceptCodeConstant.PARAM_IS_NULL, "[统计元素属性]不能为空");
            }
            if (request.getStatisticsElementId() == 0) {
                throw new BusinessException(SmcExceptCodeConstant.PARAM_IS_NULL, "[统计元素ID]不能为空");
            }
        }
        if (SmcConstants.StlElement.Type.VALUE_SUM.equals(request.getStatisticsType())) {

            if (!SmcConstants.StlElement.Type.INT.equals(request.getValueType())
                    && !SmcConstants.StlElement.Type.FLOAT.equals(request.getValueType())) {
                throw new BusinessException(SmcExceptCodeConstant.PARAM_IS_NULL,
                        "[属性值]只能为FLOAT或者INT类型");
            }
        }
        if (SmcConstants.StlElement.IsSettlement.YES.equals(request.getIsSettlement())) {
            if (!SmcConstants.StlElement.Type.ENUM.equals(request.getValueType())
                    && !SmcConstants.StlElement.Type.STRING.equals(request.getValueType())) {
                throw new BusinessException(SmcExceptCodeConstant.PARAM_IS_NULL,
                        "[属性值]只能为ENUM或者STRING类型");
            }
        }

        if (!SmcConstants.StlElement.Type.STATISTICS.equals(request.getAttrType())) {
            if (null != request.getAttributeRecord()) {
                throw new BusinessException(SmcExceptCodeConstant.PARAM_IS_NULL, "[统计元素属性]必须为空");
            }
            if (request.getStatisticsElementId() != 0) {
                throw new BusinessException(SmcExceptCodeConstant.PARAM_IS_NULL, "[统计元素ID]必须为空");
            }

        }

    }

    public void checkElementCode(StlElement stlElement) {
        if (iElementManageBusiSV.checkElementCode(stlElement)) {
            throw new BusinessException(SmcExceptCodeConstant.NO_DATA_OR_CACAE_ERROR,
                    "[同一租户元素编码]必须唯一");
        }
    }

    @Override
    public BaseResponse deleteElement(Long elementId, String tenantId) throws BusinessException {
        // TODO Auto-generated method stub
        if (elementId == 0) {
            throw new BusinessException(SmcExceptCodeConstant.PARAM_IS_NULL, "[元素ID]不能为空");
        }
        if (StringUtil.isBlank(tenantId)) {
            throw new BusinessException(SmcExceptCodeConstant.PARAM_IS_NULL, "[租户]不能为空");
        }
        iElementManageBusiSV.deleteElement(elementId, tenantId);
        ResponseHeader responseHeader = new ResponseHeader(true, SmcExceptCodeConstant.SUCCESS,
                "成功");
        BaseResponse response = new BaseResponse();
        response.setResponseHeader(responseHeader);
        return response;
    }

    @Override
    public BaseResponse updateElement(ElementUpdateRequest request) throws BusinessException {

        checkUpdateRequest(request);
        Long elementId = request.getElementId();
        StlElement stlElement = iElementManageBusiSV.searchElementById(elementId);
        if (null != stlElement && stlElement.getTenantId().equals(request.getTenantId())) {
            BeanUtils.copyProperties(request, stlElement);
        } else {
            throw new BusinessException(SmcExceptCodeConstant.PARAM_IS_NULL, "[元素]不存在");
        }
        stlElement.setUpdateDeptId(request.getUpdateDeptId());
        stlElement.setUpdateTime(DateTimeUtil.getNowTimeStamp());
        iElementManageBusiSV.updateElement(stlElement);
        StlElementAttr stlElementAttr = iElementAttrManageBusiSV
                .searchElementAttrByElementId(elementId);
        if (null != request.getAttributeRecord()) {
            if (null == request.getAttributeRecord().getSubElementId()
                    || request.getAttributeRecord().getSubElementId() == 0) {
                throw new BusinessException(SmcExceptCodeConstant.PARAM_IS_NULL, "[元素ID]为空");
            }
            if (null == request.getAttributeRecord().getSubObjectId()
                    || request.getAttributeRecord().getSubObjectId() == 0) {
                throw new BusinessException(SmcExceptCodeConstant.PARAM_IS_NULL, "[对象ID]为空");
            }
            if (null == request.getAttributeRecord().getRelType()
                    || StringUtil.isBlank(request.getAttributeRecord().getRelType())) {
                throw new BusinessException(SmcExceptCodeConstant.PARAM_IS_NULL, "[限定方式]为空");
            }
            if (null == request.getAttributeRecord().getRelValue()
                    || StringUtil.isBlank(request.getAttributeRecord().getRelValue())) {
                throw new BusinessException(SmcExceptCodeConstant.PARAM_IS_NULL, "[限定值]为空");
            }

            BeanUtils.copyProperties(request.getAttributeRecord(), stlElementAttr);
            stlElementAttr.setUpdateDeptId(request.getUpdateDeptId());
            stlElementAttr.setUpdateTime(DateTimeUtil.getNowTimeStamp());
            stlElementAttr.setUpdateOperId(request.getUpdateOperId());
            iElementAttrManageBusiSV.updateElementAttr(stlElementAttr);
        }
        ResponseHeader responseHeader = new ResponseHeader(true, SmcExceptCodeConstant.SUCCESS,
                "成功");
        BaseResponse response = new BaseResponse();
        response.setResponseHeader(responseHeader);
        return response;
    }

    private void checkUpdateRequest(ElementUpdateRequest request) throws BusinessException {
        BusinessUtil.checkBaseInfo(request);
        if (null == request.getElementId() || request.getElementId() == 0) {
            throw new BusinessException(SmcExceptCodeConstant.PARAM_IS_NULL, "[元素ID]不能为空");
        }
        if (StringUtil.isBlank(request.getTenantId())) {
            throw new BusinessException(SmcExceptCodeConstant.PARAM_IS_NULL, "[租户]不能为空");
        }
        if (StringUtil.isBlank(request.getElementName())) {
            throw new BusinessException(SmcExceptCodeConstant.PARAM_IS_NULL, "[元素名称]不能为空");
        }

        if (StringUtil.isBlank(request.getIsSettlement())) {
            throw new BusinessException(SmcExceptCodeConstant.PARAM_IS_NULL, "[是否结算对象]不能为空");
        }
        if (StringUtil.isBlank(request.getValueType())) {
            throw new BusinessException(SmcExceptCodeConstant.PARAM_IS_NULL, "[属性值类型]不能为空");
        }
        if (StringUtil.isBlank(request.getIsNecessary())) {
            throw new BusinessException(SmcExceptCodeConstant.PARAM_IS_NULL, "[是否必填]不能为空");
        }
        if (StringUtil.isBlank(request.getElementType())) {
            throw new BusinessException(SmcExceptCodeConstant.PARAM_IS_NULL, "[元素类型]不能为空");
        }
        if (StringUtil.isBlank(request.getDataCreateType())) {
            throw new BusinessException(SmcExceptCodeConstant.PARAM_IS_NULL, "[数据生成方式]不能为空");
        }
        if (StringUtil.isBlank(request.getDataCreateType())) {
            throw new BusinessException(SmcExceptCodeConstant.PARAM_IS_NULL, "[数据生成方式]不能为空");
        }

        if (SmcConstants.StlElement.Type.VALUE_SUM.equals(request.getStatisticsType())) {

            if (!SmcConstants.StlElement.Type.INT.equals(request.getValueType())
                    && !SmcConstants.StlElement.Type.FLOAT.equals(request.getValueType())) {
                throw new BusinessException(SmcExceptCodeConstant.PARAM_IS_NULL,
                        "[属性值]只能为FLOAT或者INT类型");
            }
        }
        if (SmcConstants.StlElement.IsSettlement.YES.equals(request.getIsSettlement())) {
            if (!SmcConstants.StlElement.Type.ENUM.equals(request.getValueType())
                    && !SmcConstants.StlElement.Type.STRING.equals(request.getValueType())) {
                throw new BusinessException(SmcExceptCodeConstant.PARAM_IS_NULL,
                        "[属性值]只能为ENUM或者STRING类型");
            }
        }

    }

    @Override
    public ElementSearchResponseVO searchElementById(long elementId) throws BusinessException {
        // TODO Auto-generated method stub
        ElementSearchResponseVO elementSearchResponseVO = new ElementSearchResponseVO();
        if (elementId == 0) {
            throw new BusinessException(SmcExceptCodeConstant.PARAM_IS_NULL, "[元素ID]不能为空");
        }
        StlElement stlElement = iElementManageBusiSV.searchElementById(elementId);
        if (stlElement != null) {
            BeanUtils.copyProperties(stlElement, elementSearchResponseVO);
        } else {
            throw new BusinessException(SmcExceptCodeConstant.PARAM_IS_NULL, "[元素]不存在");
        }
        StlElementAttr stlElementAttr = iElementAttrManageBusiSV
                .searchElementAttrByElementId(elementId);
        if (null != stlElementAttr) {
            AttributeRecord attributeRecord = new AttributeRecord();
            BeanUtils.copyProperties(stlElementAttr, attributeRecord);
            elementSearchResponseVO.setAttributeRecord(attributeRecord);
        }
        ResponseHeader responseHeader = new ResponseHeader(true, SmcExceptCodeConstant.SUCCESS,
                "成功");
        elementSearchResponseVO.setResponseHeader(responseHeader);
        return elementSearchResponseVO;
    }

    @Override
    public PageInfo<ElementSearchResponseVO> searchElement(ElementSearchRequest elementSearchRequest)
            throws BusinessException {
        // TODO Auto-generated method stub
        checkSearch(elementSearchRequest);
        return iElementManageBusiSV.searchElementList(elementSearchRequest);
    }

    private void checkSearch(ElementSearchRequest elementSearchRequest) {
        BusinessUtil.checkBaseInfo(elementSearchRequest);
    }

}

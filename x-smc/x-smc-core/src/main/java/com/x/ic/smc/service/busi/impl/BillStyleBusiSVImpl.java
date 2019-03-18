package com.x.ic.smc.service.busi.impl;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.x.base.exception.BusinessException;
import com.x.base.vo.BaseResponse;
import com.x.base.vo.ResponseHeader;
import com.x.sdk.util.DateUtil;
import com.x.sdk.util.StringUtil;
import com.x.ic.smc.api.billstyle.param.AddBillStyleInfo;
import com.x.ic.smc.api.billstyle.param.BillStyleDetailVo;
import com.x.ic.smc.api.billstyle.param.CancelBillStyleInfo;
import com.x.ic.smc.api.billstyle.param.UpdateBillStyleInfo;
import com.x.ic.smc.constants.SmcExceptCodeConstant;
import com.x.ic.smc.dao.mapper.bo.StlBillDetailStyleItem;
import com.x.ic.smc.dao.mapper.bo.StlBillDetailStyleItemCriteria;
import com.x.ic.smc.dao.mapper.bo.StlBillStyle;
import com.x.ic.smc.dao.mapper.bo.StlBillStyleCriteria;
import com.x.ic.smc.dao.mapper.factory.MapperFactory;
import com.x.ic.smc.dao.mapper.interfaces.StlBillDetailStyleItemMapper;
import com.x.ic.smc.dao.mapper.interfaces.StlBillStyleMapper;
import com.x.ic.smc.service.busi.interfaces.IBillStyleBusiSV;
import com.x.ic.smc.util.SmcSeqUtil;

@Service
@Transactional
public class BillStyleBusiSVImpl implements IBillStyleBusiSV {

    @Override
    public BaseResponse addBillStyle(AddBillStyleInfo addBillStyleInfo) {
        // TODO Auto-generated method stub
        BaseResponse baseResponse = new BaseResponse();
        ResponseHeader responseHeader = new ResponseHeader();
        baseResponse.setResponseHeader(responseHeader);
        String tenantId = addBillStyleInfo.getTenantId();
        Long billStyleId = SmcSeqUtil.createBillStyleId();
        Timestamp now = DateUtil.getSysDate();
        String createDeptId = addBillStyleInfo.getCreateDeptId();
        String createOperId = addBillStyleInfo.getCreateOperId();

        StlBillStyleCriteria stlBillStyleCriteria = new StlBillStyleCriteria();
        StlBillStyleCriteria.Criteria criteria = stlBillStyleCriteria.createCriteria();
        criteria.andBillStyleSnEqualTo(addBillStyleInfo.getBillStyleSn());
        criteria.andTenantIdEqualTo(addBillStyleInfo.getTenantId());
        StlBillStyleMapper mapper = MapperFactory.getStlBillStyleMapper();
        List<StlBillStyle> stlBillStyles = mapper.selectByExample(stlBillStyleCriteria);
        if (stlBillStyles.size() != 0) {
            responseHeader.setSuccess(false);
            responseHeader.setResultCode("999999");
            responseHeader.setResultMessage(addBillStyleInfo.getBillStyleSn() + "此账单样式编码已经存在");
            baseResponse.setResponseHeader(responseHeader);
            return baseResponse;
        }

        // 账单格式定义表
        StlBillStyle stlBillStyle = new StlBillStyle();
        BeanUtils.copyProperties(addBillStyleInfo, stlBillStyle);
        stlBillStyle.setTenantId(tenantId);
        stlBillStyle.setBillStyleId(billStyleId);
        stlBillStyle.setCreateTime(now);
        stlBillStyle.setState("1");
        mapper.insert(stlBillStyle);
        // 账单项定义表
        // List<BillStyleVo> billStyleVos = addBillStyleInfo.getBillStyleVos();
        // if(billStyleVos==null){
        // throw new BusinessException(ExceptCodeConstant.PARAM_IS_NULL, "账单项定义表不可为空");
        // }
        // StlBillStyleItemMapper stlBillStyleItemMapper =
        // MapperFactory.getStlBillStyleItemMapper();
        // for (BillStyleVo billStyleVo : billStyleVos) {
        // StlBillStyleItem stlBillStyleItem = new StlBillStyleItem();
        // BeanUtils.copyProperties(billStyleVo, stlBillStyleItem);
        // stlBillStyleItem.setTenantId(tenantId);
        // stlBillStyleItem.setBillStyleId(billStyleId);
        // stlBillStyleItem.setItemId(SmcSeqUtil.createBillStyleItemId());
        // stlBillStyleItem.setCreateDeptId(createDeptId);
        // stlBillStyleItem.setCreateOperId(createOperId);
        // stlBillStyleItem.setCreateTime(now);
        // stlBillStyleItemMapper.insert(stlBillStyleItem);
        // }
        // 详单项定义表
        List<BillStyleDetailVo> billStyleDetailVos = addBillStyleInfo.getBillStyleDetailVos();
        if (billStyleDetailVos == null) {
            throw new BusinessException(SmcExceptCodeConstant.PARAM_IS_NULL, "详单项定义表不可为空");
        }
        StlBillDetailStyleItemMapper stlBillDetailStyleItemMapper = MapperFactory
                .getStlBillDetailStyleItemMapper();
        for (BillStyleDetailVo billStyleDetailVo : billStyleDetailVos) {
            StlBillDetailStyleItem stlBillDetailStyleItem = new StlBillDetailStyleItem();
            BeanUtils.copyProperties(billStyleDetailVo, stlBillDetailStyleItem);
            stlBillDetailStyleItem.setTenantId(tenantId);
            stlBillDetailStyleItem.setBillStyleId(billStyleId);
            stlBillDetailStyleItem.setItemId(SmcSeqUtil.createBillStyleItemId());
            stlBillDetailStyleItem.setCreateDeptId(createDeptId);
            stlBillDetailStyleItem.setCreateOperId(createOperId);
            stlBillDetailStyleItem.setCreateTime(now);
            stlBillDetailStyleItemMapper.insert(stlBillDetailStyleItem);
        }

        responseHeader.setSuccess(true);
        responseHeader.setResultCode("000000");
        responseHeader.setResultMessage("成功");
        baseResponse.setResponseHeader(responseHeader);
        return baseResponse;
    }

    @Override
    public BaseResponse updateBillStyle(UpdateBillStyleInfo updateBillStyleInfo) {
        // TODO Auto-generated method stub
        BaseResponse baseResponse = new BaseResponse();
        Timestamp now = DateUtil.getSysDate();
        String tenantId = updateBillStyleInfo.getTenantId();
        Long billStyleId = updateBillStyleInfo.getBillStyleId();
        // 判断是不是已经存在
        StlBillStyleCriteria stlBillStyleCriteria = new StlBillStyleCriteria();
        StlBillStyleCriteria.Criteria criteria = stlBillStyleCriteria.createCriteria();
        criteria.andTenantIdEqualTo(tenantId);
        criteria.andBillStyleIdEqualTo(updateBillStyleInfo.getBillStyleId());

        StlBillStyleMapper mapper = MapperFactory.getStlBillStyleMapper();
        if (mapper.selectByExample(stlBillStyleCriteria).size() == 0) {
            throw new BusinessException(SmcExceptCodeConstant.PARAM_IS_NULL,
                    updateBillStyleInfo.getBillStyleId() + "此账单样式ID不存在不可以进行修改操作");
        }
        // 更新了账单样式表
        StlBillStyle stlBillStyle = new StlBillStyle();
        BeanUtils.copyProperties(updateBillStyleInfo, stlBillStyle);
        stlBillStyle.setUpdateTime(now);
        StlBillStyleCriteria stlBillStyleCriteria1 = new StlBillStyleCriteria();
        StlBillStyleCriteria.Criteria criteria1 = stlBillStyleCriteria1.createCriteria();
        criteria1.andTenantIdEqualTo(tenantId);
        criteria1.andBillStyleIdEqualTo(billStyleId);
        MapperFactory.getStlBillStyleMapper().updateByExampleSelective(stlBillStyle,
                stlBillStyleCriteria1);
        // // 删除账单项表旧数据然后插入新数据
        // StlBillStyleItemMapper stlBillStyleItemMapper =
        // MapperFactory.getStlBillStyleItemMapper();
        // StlBillStyleItemCriteria stlBillStyleItemCriteria = new StlBillStyleItemCriteria();
        // StlBillStyleItemCriteria.Criteria criteria2 = stlBillStyleItemCriteria.createCriteria();
        // criteria2.andTenantIdEqualTo(tenantId);
        // criteria2.andBillStyleIdEqualTo(billStyleId);
        // stlBillStyleItemMapper.deleteByExample(stlBillStyleItemCriteria);

        // List<BillStyleVo> billStyleVos = updateBillStyleInfo.getBillStyleVos();
        // for (BillStyleVo billStyleVo : billStyleVos) {
        // StlBillStyleItem stlBillStyleItem = new StlBillStyleItem();
        // BeanUtils.copyProperties(billStyleVo, stlBillStyleItem);
        // stlBillStyleItem.setTenantId(tenantId);
        // stlBillStyleItem.setBillStyleId(billStyleId);
        // stlBillStyleItem.setItemId(SmcSeqUtil.createBillStyleItemId());
        // stlBillStyleItem.setUpdateTime(now);
        // if (!StringUtil.isBlank(updateBillStyleInfo.getUpdateDeptId())) {
        // stlBillStyleItem.setUpdateDeptId(updateBillStyleInfo.getUpdateDeptId());
        // }
        // if (!StringUtil.isBlank(updateBillStyleInfo.getUpdateOperId())) {
        // stlBillStyleItem.setUpdateDeptId(updateBillStyleInfo.getUpdateOperId());
        // }
        // stlBillStyleItemMapper.insert(stlBillStyleItem);
        //
        // }
        // 删除详单项表旧数据然后插入新数据
        StlBillDetailStyleItemMapper stlBillDetailStyleItemMapper = MapperFactory
                .getStlBillDetailStyleItemMapper();
        StlBillDetailStyleItemCriteria stlBillDetailStyleItemCriteria = new StlBillDetailStyleItemCriteria();
        StlBillDetailStyleItemCriteria.Criteria criteria3 = stlBillDetailStyleItemCriteria
                .createCriteria();
        criteria3.andTenantIdEqualTo(tenantId);
        criteria3.andBillStyleIdEqualTo(billStyleId);
        stlBillDetailStyleItemMapper.deleteByExample(stlBillDetailStyleItemCriteria);

        List<BillStyleDetailVo> billStyleDetailVos = updateBillStyleInfo.getBillStyleDetailVos();
        for (BillStyleDetailVo billStyleDetailVo : billStyleDetailVos) {
            StlBillDetailStyleItem stlBillDetailStyleItem = new StlBillDetailStyleItem();
            BeanUtils.copyProperties(billStyleDetailVo, stlBillDetailStyleItem);
            stlBillDetailStyleItem.setTenantId(tenantId);
            stlBillDetailStyleItem.setBillStyleId(billStyleId);
            stlBillDetailStyleItem.setItemId(SmcSeqUtil.createBillStyleItemId());
            stlBillDetailStyleItem.setUpdateTime(now);
            if (!StringUtil.isBlank(updateBillStyleInfo.getUpdateDeptId())) {
                stlBillDetailStyleItem.setUpdateDeptId(updateBillStyleInfo.getUpdateDeptId());
            }
            if (!StringUtil.isBlank(updateBillStyleInfo.getUpdateOperId())) {
                stlBillDetailStyleItem.setUpdateOperId(updateBillStyleInfo.getUpdateOperId());
            }
            stlBillDetailStyleItemMapper.insert(stlBillDetailStyleItem);
        }
        ResponseHeader responseHeader = new ResponseHeader();
        responseHeader.setSuccess(true);
        responseHeader.setResultCode("000000");
        responseHeader.setResultMessage("成功");
        baseResponse.setResponseHeader(responseHeader);
        return baseResponse;
    }

    @Override
    public BaseResponse cancleBillStyle(CancelBillStyleInfo cancelBillStyleInfo) {
        // TODO Auto-generated method stub
        BaseResponse baseResponse = new BaseResponse();

        StlBillStyleCriteria stlBillStyleCriteria = new StlBillStyleCriteria();
        StlBillStyleCriteria.Criteria criteria = stlBillStyleCriteria.createCriteria();
        criteria.andTenantIdEqualTo(cancelBillStyleInfo.getTenantId());
        criteria.andBillStyleIdEqualTo(cancelBillStyleInfo.getBillStyleId());
        StlBillStyleMapper mapper = MapperFactory.getStlBillStyleMapper();
        // 判断这个id是否存在
        List<StlBillStyle> stlBillStyles = mapper.selectByExample(stlBillStyleCriteria);
        if (stlBillStyles.size() == 0) {
            throw new BusinessException(SmcExceptCodeConstant.NO_DATA_OR_CACAE_ERROR,
                    cancelBillStyleInfo.getBillStyleId() + "此账单样式ID不存在，不可以注销");
        }
        StlBillStyle stlBillStyle = new StlBillStyle();
        stlBillStyle.setState("0");
        MapperFactory.getStlBillStyleMapper().updateByExampleSelective(stlBillStyle,
                stlBillStyleCriteria);
        ResponseHeader responseHeader = new ResponseHeader();
        responseHeader.setSuccess(true);
        responseHeader.setResultCode("000000");
        responseHeader.setResultMessage("成功");
        baseResponse.setResponseHeader(responseHeader);
        return baseResponse;
    }

}

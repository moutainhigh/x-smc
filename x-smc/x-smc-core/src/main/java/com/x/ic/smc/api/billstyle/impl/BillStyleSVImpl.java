package com.x.ic.smc.api.billstyle.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.x.base.exception.BusinessException;
import com.x.base.vo.BaseResponse;
import com.x.sdk.util.StringUtil;
import com.x.ic.smc.api.billstyle.interfaces.IBillStyleSV;
import com.x.ic.smc.api.billstyle.param.AddBillStyleInfo;
import com.x.ic.smc.api.billstyle.param.BillStyleDetailVo;
import com.x.ic.smc.api.billstyle.param.CancelBillStyleInfo;
import com.x.ic.smc.api.billstyle.param.UpdateBillStyleInfo;
import com.x.ic.smc.constants.SmcExceptCodeConstant;
import com.x.ic.smc.service.busi.interfaces.IBillStyleBusiSV;
import com.x.ic.smc.util.BusinessUtil;
import com.alibaba.dubbo.config.annotation.Service;

@Service
public class BillStyleSVImpl implements IBillStyleSV {

    @Autowired
    private IBillStyleBusiSV iBillStyleBusiSV;

    @Override
    public BaseResponse addBillStyle(AddBillStyleInfo addBillStyleInfo) throws BusinessException {
        // TODO Auto-generated method stub
        BusinessUtil.checkBaseInfo(addBillStyleInfo);
        if (StringUtil.isBlank(addBillStyleInfo.getBillStyleSn())) {
            throw new BusinessException(SmcExceptCodeConstant.PARAM_IS_NULL, "账单样式编码不可为空");
        }
        if (StringUtil.isBlank(addBillStyleInfo.getBillTitle())) {
            throw new BusinessException(SmcExceptCodeConstant.PARAM_IS_NULL, "账单标题不可为空");
        }
        // List<BillStyleVo> billStyleVos = addBillStyleInfo.getBillStyleVos();
        // if (billStyleVos == null) {
        // throw new BusinessException(ExceptCodeConstant.PARAM_IS_NULL, "账单项列表不可为空");
        // }
        // for (BillStyleVo billStyleVo : billStyleVos) {
        // if (StringUtil.isBlank(billStyleVo.getItemCode())) {
        // throw new BusinessException(ExceptCodeConstant.PARAM_IS_NULL, "元素编码不可为空");
        // }
        // if (StringUtil.isBlank(billStyleVo.getItemTitle())) {
        // throw new BusinessException(ExceptCodeConstant.PARAM_IS_NULL, "元素标题不可为空");
        // }
        //
        // if (StringUtil.isBlank(billStyleVo.getItemOwner())) {
        // throw new BusinessException(ExceptCodeConstant.PARAM_IS_NULL, "账单项归属不可为空");
        // }
        // if (StringUtil.isBlank(billStyleVo.getObjectId())) {
        // throw new BusinessException(ExceptCodeConstant.PARAM_IS_NULL, "取值对象ID不可为空");
        // }
        // if ((billStyleVo.getElementId() == null)) {
        // throw new BusinessException(ExceptCodeConstant.PARAM_IS_NULL, "取值元素ID不可为空");
        // }
        // if ((billStyleVo.getSortId() == null)) {
        // throw new BusinessException(ExceptCodeConstant.PARAM_IS_NULL, "序号不可为空");
        // }
        //
        // }

        List<BillStyleDetailVo> billStyleDetailVos = addBillStyleInfo.getBillStyleDetailVos();
        if (billStyleDetailVos == null) {
            throw new BusinessException(SmcExceptCodeConstant.PARAM_IS_NULL, "详单项列表不可为空");
        }
        List<String> isUnique = new ArrayList<String>();
        for (BillStyleDetailVo billStyleDetailVo : billStyleDetailVos) {

            if (StringUtil.isBlank(billStyleDetailVo.getItemCode())) {
                throw new BusinessException(SmcExceptCodeConstant.PARAM_IS_NULL, "元素编码不可为空");
            }
            if (isUnique.size() != 0) {
                if (isUnique.contains(billStyleDetailVo.getItemCode())) {
                    throw new BusinessException(SmcExceptCodeConstant.NO_DATA_OR_CACAE_ERROR,
                            "元素编码重复");
                } else {
                    isUnique.add(billStyleDetailVo.getItemCode());
                }
            } else {
                isUnique.add(billStyleDetailVo.getItemCode());
            }
            if (StringUtil.isBlank(billStyleDetailVo.getItemTitle())) {
                throw new BusinessException(SmcExceptCodeConstant.PARAM_IS_NULL, "元素标题不可为空");
            }
            if (StringUtil.isBlank(billStyleDetailVo.getCheckFlag())) {
                throw new BusinessException(SmcExceptCodeConstant.PARAM_IS_NULL, "核对标识不可为空");
            }
            if (StringUtil.isBlank(billStyleDetailVo.getItemOwner())) {
                throw new BusinessException(SmcExceptCodeConstant.PARAM_IS_NULL, "账单项归属不可为空");
            }
            if (StringUtil.isBlank(billStyleDetailVo.getObjectId())) {
                throw new BusinessException(SmcExceptCodeConstant.PARAM_IS_NULL, "取值对象ID不可为空");
            }
            if ((billStyleDetailVo.getElementId() == null)
                    || (billStyleDetailVo.getElementId() == 0)) {
                throw new BusinessException(SmcExceptCodeConstant.PARAM_IS_NULL, "取值元素ID不可为空");
            }
            if ((billStyleDetailVo.getSortId() == null) || billStyleDetailVo.getSortId() == 0) {
                throw new BusinessException(SmcExceptCodeConstant.PARAM_IS_NULL, "序号不可为空");
            }
        }
        return iBillStyleBusiSV.addBillStyle(addBillStyleInfo);
    }

    @Override
    public BaseResponse updateBillStyle(UpdateBillStyleInfo updateBillStyleInfo)
            throws BusinessException {
        // TODO Auto-generated method stub
        BusinessUtil.checkBaseInfo(updateBillStyleInfo);
        if ((updateBillStyleInfo.getBillStyleId() == null)
                || (updateBillStyleInfo.getBillStyleId() == 0)) {
            throw new BusinessException(SmcExceptCodeConstant.PARAM_IS_NULL, "账单样式ID不可为空");
        }

        // List<BillStyleVo> billStyleVos = updateBillStyleInfo.getBillStyleVos();
        // if (billStyleVos == null) {
        // throw new BusinessException(ExceptCodeConstant.PARAM_IS_NULL, "账单项列表不可为空");
        // }
        // for (BillStyleVo billStyleVo : billStyleVos) {
        // if (StringUtil.isBlank(billStyleVo.getItemCode())) {
        // throw new BusinessException(ExceptCodeConstant.PARAM_IS_NULL, "元素编码不可为空");
        // }
        // if (StringUtil.isBlank(billStyleVo.getItemTitle())) {
        // throw new BusinessException(ExceptCodeConstant.PARAM_IS_NULL, "元素标题不可为空");
        // }
        // if (StringUtil.isBlank(billStyleVo.getItemOwner())) {
        // throw new BusinessException(ExceptCodeConstant.PARAM_IS_NULL, "账单项归属不可为空");
        // }
        // if (StringUtil.isBlank(billStyleVo.getObjectId())) {
        // throw new BusinessException(ExceptCodeConstant.PARAM_IS_NULL, "取值对象ID不可为空");
        // }
        // if ((billStyleVo.getElementId() == null)) {
        // throw new BusinessException(ExceptCodeConstant.PARAM_IS_NULL, "取值元素ID不可为空");
        // }
        // if ((billStyleVo.getSortId() == null)) {
        // throw new BusinessException(ExceptCodeConstant.PARAM_IS_NULL, "序号不可为空");
        // }
        // }

        List<BillStyleDetailVo> billStyleDetailVos = updateBillStyleInfo.getBillStyleDetailVos();
        if (billStyleDetailVos == null) {
            throw new BusinessException(SmcExceptCodeConstant.PARAM_IS_NULL, "详单项列表不可为空");
        }
        List<String> isUnique = new ArrayList<String>();
        for (BillStyleDetailVo billStyleDetailVo : billStyleDetailVos) {

            if (StringUtil.isBlank(billStyleDetailVo.getItemCode())) {
                throw new BusinessException(SmcExceptCodeConstant.PARAM_IS_NULL, "元素编码不可为空");
            }
            if (isUnique.size() != 0) {
                if (isUnique.contains(billStyleDetailVo.getItemCode())) {
                    throw new BusinessException(SmcExceptCodeConstant.NO_DATA_OR_CACAE_ERROR,
                            "元素编码重复");
                } else {
                    isUnique.add(billStyleDetailVo.getItemCode());
                }
            } else {
                isUnique.add(billStyleDetailVo.getItemCode());
            }
            if (StringUtil.isBlank(billStyleDetailVo.getItemTitle())) {
                throw new BusinessException(SmcExceptCodeConstant.PARAM_IS_NULL, "元素标题不可为空");
            }
            if (StringUtil.isBlank(billStyleDetailVo.getCheckFlag())) {
                throw new BusinessException(SmcExceptCodeConstant.PARAM_IS_NULL, "核对标识不可为空");
            }
            if (StringUtil.isBlank(billStyleDetailVo.getItemOwner())) {
                throw new BusinessException(SmcExceptCodeConstant.PARAM_IS_NULL, "账单项归属不可为空");
            }
            if (StringUtil.isBlank(billStyleDetailVo.getObjectId())) {
                throw new BusinessException(SmcExceptCodeConstant.PARAM_IS_NULL, "取值对象ID不可为空");
            }
            if ((billStyleDetailVo.getElementId() == null)
                    || (billStyleDetailVo.getElementId() == 0)) {
                throw new BusinessException(SmcExceptCodeConstant.PARAM_IS_NULL, "取值元素ID不可为空");
            }
            if ((billStyleDetailVo.getSortId() == null) || billStyleDetailVo.getSortId() == 0) {
                throw new BusinessException(SmcExceptCodeConstant.PARAM_IS_NULL, "序号不可为空");
            }
        }
        return iBillStyleBusiSV.updateBillStyle(updateBillStyleInfo);
    }

    @Override
    public BaseResponse cancleBillStyle(CancelBillStyleInfo cancelBillStyleInfo)
            throws BusinessException {
        // TODO Auto-generated method stub
        BusinessUtil.checkBaseInfo(cancelBillStyleInfo);
        if ((cancelBillStyleInfo.getBillStyleId() == null)
                || (cancelBillStyleInfo.getBillStyleId() == 0)) {
            throw new BusinessException(SmcExceptCodeConstant.PARAM_IS_NULL, "账单样式ID不可为空");
        }
        return iBillStyleBusiSV.cancleBillStyle(cancelBillStyleInfo);
    }

}

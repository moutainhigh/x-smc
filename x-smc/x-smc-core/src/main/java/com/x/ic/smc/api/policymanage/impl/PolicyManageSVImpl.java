package com.x.ic.smc.api.policymanage.impl;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.x.base.exception.BusinessException;
import com.x.base.exception.SystemException;
import com.x.base.vo.BaseResponse;
import com.x.base.vo.PageInfo;
import com.x.base.vo.ResponseHeader;
import com.x.sdk.util.CollectionUtil;
import com.x.sdk.util.DateUtil;
import com.x.sdk.util.StringUtil;
import com.x.ic.smc.api.policymanage.interfaces.IPolicyManageSV;
import com.x.ic.smc.api.policymanage.param.PolicyCancelRequest;
import com.x.ic.smc.api.policymanage.param.PolicyCreateRequest;
import com.x.ic.smc.api.policymanage.param.PolicyDetailQueryRequest;
import com.x.ic.smc.api.policymanage.param.PolicyDetailQueryResponse;
import com.x.ic.smc.api.policymanage.param.PolicyItemConditionCreateInfo;
import com.x.ic.smc.api.policymanage.param.PolicyItemCreateInfo;
import com.x.ic.smc.api.policymanage.param.PolicyItemPlanCreateInfo;
import com.x.ic.smc.api.policymanage.param.PolicyListQueryInfo;
import com.x.ic.smc.api.policymanage.param.PolicyListQueryRequest;
import com.x.ic.smc.api.policymanage.param.PolicyListQueryResponse;
import com.x.ic.smc.api.policymanage.param.PolicyModifyRequest;
import com.x.ic.smc.api.policymanage.param.StepCalValue;
import com.x.ic.smc.constants.SmcConstants;
import com.x.ic.smc.constants.SmcExceptCodeConstant;
import com.x.ic.smc.service.atom.interfaces.IPolicyManageAtomSV;
import com.x.ic.smc.service.atom.interfaces.IStlBillStyleAtomSV;
import com.x.ic.smc.service.atom.interfaces.IStlElementAtomSV;
import com.x.ic.smc.service.busi.interfaces.IPolicyManageBusiSV;
import com.x.ic.smc.util.BusinessUtil;
import com.x.ic.smc.util.LongUtil;
import com.alibaba.dubbo.config.annotation.Service;

@Service
public class PolicyManageSVImpl implements IPolicyManageSV {
    @Autowired
    private transient IPolicyManageBusiSV iPolicyManageBusiSV;

    @Autowired
    private transient IPolicyManageAtomSV iPolicyManageAtomSV;

    @Autowired
    private transient IStlElementAtomSV iStlElementAtomSV;

    @Autowired
    private transient IStlBillStyleAtomSV iStlBillStyleAtomSV;

    @Override
    public BaseResponse createPolicy(PolicyCreateRequest request) throws BusinessException,
            SystemException {
        BusinessUtil.checkBaseInfo(request);
        checkRequest(request);

        iPolicyManageBusiSV.createPolicy(request);

        ResponseHeader responseHeader = new ResponseHeader(true, SmcExceptCodeConstant.SUCCESS,
                "成功");
        BaseResponse response = new BaseResponse();
        response.setResponseHeader(responseHeader);
        return response;
    }

    private void checkRequest(PolicyCreateRequest request) throws BusinessException,
            SystemException {
        if (StringUtil.isBlank(request.getPolicyCode())) {
            throw new BusinessException(SmcExceptCodeConstant.PARAM_IS_NULL, "[政策编码]不能为空");
        }
        if (iPolicyManageAtomSV.isExistPolicyCode(request.getTenantId(), request.getPolicyCode())) {
            throw new BusinessException("", "该[政策编码:" + request.getPolicyCode() + "]已存在");
        }
        if (StringUtil.isBlank(request.getPolicyName())) {
            throw new BusinessException(SmcExceptCodeConstant.PARAM_IS_NULL, "[政策名称]不能为空");
        }
        if (StringUtil.isBlank(request.getStartTimeStr())) {
            throw new BusinessException(SmcExceptCodeConstant.PARAM_IS_NULL, "[政策生效时间]不能为空");
        }
        if (!DateUtil.isValidDate(request.getStartTimeStr(), DateUtil.YYYYMMDD)) {
            throw new BusinessException(SmcExceptCodeConstant.PARAM_TYPE_NOT_RIGHT, "[政策生效时间]格式不正确");
        }
        if (StringUtil.isBlank(request.getEndTimeStr())) {
            throw new BusinessException(SmcExceptCodeConstant.PARAM_IS_NULL, "[政策失效时间]不能为空");
        }
        if (!DateUtil.isValidDate(request.getEndTimeStr(), DateUtil.YYYYMMDD)) {
            throw new BusinessException(SmcExceptCodeConstant.PARAM_TYPE_NOT_RIGHT, "[政策失效时间]格式不正确");
        }
        if (StringUtil.isBlank(request.getPolicyType())) {
            throw new BusinessException(SmcExceptCodeConstant.PARAM_IS_NULL, "[政策类型]不能为空");
        }
        if (StringUtil.isBlank(request.getExecCycle())) {
            throw new BusinessException(SmcExceptCodeConstant.PARAM_IS_NULL, "[执行周期]不能为空");
        }
        List<String> execCycleFieldValues = getFieldValues(PolicyCreateRequest.ExecCycle.class);
        if (!execCycleFieldValues.contains(request.getExecCycle())) {
            throw new BusinessException(SmcExceptCodeConstant.PARAM_TYPE_NOT_RIGHT, "[执行周期]不合法");
        }
        if (StringUtil.isBlank(request.getExecTimeStr())) {
            throw new BusinessException(SmcExceptCodeConstant.PARAM_IS_NULL, "[执行时间设定]不能为空");
        }
        if (StringUtil.isBlank(request.getDataObjectId())) {
            throw new BusinessException(SmcExceptCodeConstant.PARAM_IS_NULL, "[政策对应业务数据]不能为空");
        }
        List<String> dataObjectIdFieldValues = getFieldValues(PolicyCreateRequest.DataObjectId.class);
        if (!dataObjectIdFieldValues.contains(request.getDataObjectId())) {
            throw new BusinessException(SmcExceptCodeConstant.PARAM_TYPE_NOT_RIGHT, "[政策对应业务数据]不合法");
        }
        if (LongUtil.isEmpty(request.getDataElementId())) {
            throw new BusinessException(SmcExceptCodeConstant.PARAM_IS_NULL, "[执行周期对应时间元素ID]不能为空");
        }
        if (StringUtil.isBlank(request.getStlObjectId())) {
            throw new BusinessException(SmcExceptCodeConstant.PARAM_IS_NULL, "[结算对象]不能为空");
        }
        if (LongUtil.isEmpty(request.getStlElementId())) {
            throw new BusinessException(SmcExceptCodeConstant.PARAM_IS_NULL, "[结算属性]不能为空");
        }
        if (!iStlElementAtomSV.isValidSettlementElement(request.getTenantId(),
                request.getStlElementId())) {
            throw new BusinessException("", "[结算属性:" + request.getStlElementId() + "]无效");
        }
        if (StringUtil.isBlank(request.getStlElementSn())) {
            throw new BusinessException(SmcExceptCodeConstant.PARAM_IS_NULL, "[具体结算方（合同号）]不能为空");
        }
        if (StringUtil.isBlank(request.getBillStyleSn())) {
            throw new BusinessException(SmcExceptCodeConstant.PARAM_IS_NULL, "[账单样式编码]不能为空");
        }
        if (!iStlBillStyleAtomSV
                .isValidBillStyleSn(request.getTenantId(), request.getBillStyleSn())) {
            throw new BusinessException("", "[账单样式编码:" + request.getBillStyleSn() + "]无效");
        }
        checkPolicyItem(request.getPolicyItemCreateInfo(), request.getTenantId());
    }

    private void checkPolicyItem(List<PolicyItemCreateInfo> policyItemCreateInfos, String tenantId)
            throws BusinessException, SystemException {
        if (CollectionUtil.isEmpty(policyItemCreateInfos)) {
            throw new BusinessException(SmcExceptCodeConstant.PARAM_IS_NULL, "[政策项]不能为空");
        }
        for (PolicyItemCreateInfo policyItemCreateInfo : policyItemCreateInfos) {
            checkPolicyItemCondition(policyItemCreateInfo.getPolicyItemConditionCreateInfos(),
                    tenantId);
            checkPolicyItemPlan(policyItemCreateInfo.getPolicyItemPlanCreateInfos(), tenantId);
        }
    }

    private void checkPolicyItemPlan(List<PolicyItemPlanCreateInfo> policyItemPlanCreateInfos,
            String tenantId) throws BusinessException, SystemException {
        if (CollectionUtil.isEmpty(policyItemPlanCreateInfos)) {
            throw new BusinessException(SmcExceptCodeConstant.PARAM_IS_NULL, "[政策策略记录]不能为空");
        }
        for (PolicyItemPlanCreateInfo policyItemPlanCreateInfo : policyItemPlanCreateInfos) {
            if (StringUtil.isBlank(policyItemPlanCreateInfo.getObjectId())) {
                throw new BusinessException(SmcExceptCodeConstant.PARAM_IS_NULL, "[算费对象]不能为空");
            }
            if (LongUtil.isEmpty(policyItemPlanCreateInfo.getElementId())) {
                throw new BusinessException(SmcExceptCodeConstant.PARAM_IS_NULL, "[算费属性]不能为空");
            }
            if (!iStlElementAtomSV
                    .isvalidElement(tenantId, policyItemPlanCreateInfo.getElementId())) {
                throw new BusinessException(SmcExceptCodeConstant.BUSINESS_EXCEPTION, "算费属性["
                        + policyItemPlanCreateInfo.getElementId() + "]无效");
            }
            if (StringUtil.isBlank(policyItemPlanCreateInfo.getFeeItem())) {
                throw new BusinessException(SmcExceptCodeConstant.PARAM_IS_NULL, "[费用科目]不能为空");
            }
            if (StringUtil.isBlank(policyItemPlanCreateInfo.getPlanType())) {
                throw new BusinessException(SmcExceptCodeConstant.PARAM_IS_NULL, "[策略类型]不能为空");
            }
            List<String> planTypeFieldValues = getFieldValues(PolicyItemPlanCreateInfo.PlanType.class);
            if (!planTypeFieldValues.contains(policyItemPlanCreateInfo.getPlanType())) {
                throw new BusinessException(SmcExceptCodeConstant.PARAM_IS_NULL, "[策略类型]不合法");
            }
            if (StringUtil.isBlank(policyItemPlanCreateInfo.getCalType())) {
                throw new BusinessException(SmcExceptCodeConstant.PARAM_IS_NULL, "[算费方式]不能为空");
            }
            List<String> calTypeFieldValues = getFieldValues(PolicyItemPlanCreateInfo.CalType.class);
            if (!calTypeFieldValues.contains(policyItemPlanCreateInfo.getCalType())) {
                throw new BusinessException(SmcExceptCodeConstant.PARAM_IS_NULL, "[算费方式]不合法");
            }
            if (SmcConstants.StlPolicyItemPlan.PlanType.NORMAL.equals(policyItemPlanCreateInfo
                    .getPlanType())) {
                if (StringUtil.isBlank(policyItemPlanCreateInfo.getNormalCalValue())) {
                    throw new BusinessException(SmcExceptCodeConstant.PARAM_IS_NULL, "[标准策略取值]不能为空");
                }
            } else {
                if (CollectionUtil.isEmpty(policyItemPlanCreateInfo.getStepCalValues())) {
                    throw new BusinessException(SmcExceptCodeConstant.PARAM_IS_NULL,
                            "[阶梯或分档策略取值]不能为空");
                }
                for (StepCalValue stepCalValue : policyItemPlanCreateInfo.getStepCalValues()) {
                    if (StringUtil.isBlank(stepCalValue.getStartValue())) {
                        throw new BusinessException(SmcExceptCodeConstant.PARAM_IS_NULL,
                                "[起始值]不能为空");
                    }
                    if (StringUtil.isBlank(stepCalValue.getEndValue())) {
                        throw new BusinessException(SmcExceptCodeConstant.PARAM_IS_NULL,
                                "[结束值]不能为空");
                    }
                    if (StringUtil.isBlank(stepCalValue.getCalValue())) {
                        throw new BusinessException(SmcExceptCodeConstant.PARAM_IS_NULL,
                                "[费率取值]不能为空");
                    }
                }
            }
        }
    }

    private void checkPolicyItemCondition(
            List<PolicyItemConditionCreateInfo> policyItemConditionCreateInfos, String tenantId)
            throws BusinessException, SystemException {
        if (CollectionUtil.isEmpty(policyItemConditionCreateInfos)) {
            return;
        }
        for (PolicyItemConditionCreateInfo policyItemConditionCreateInfo : policyItemConditionCreateInfos) {
            if (StringUtil.isBlank(policyItemConditionCreateInfo.getObjectId())) {
                throw new BusinessException(SmcExceptCodeConstant.PARAM_IS_NULL, "[归属对象]不能为空");
            }
            List<String> objectIdFieldValues = getFieldValues(PolicyItemConditionCreateInfo.ObjectId.class);
            if (!objectIdFieldValues.contains(policyItemConditionCreateInfo.getObjectId())) {
                throw new BusinessException(SmcExceptCodeConstant.PARAM_TYPE_NOT_RIGHT, "[归属对象]不合法");
            }
            if (LongUtil.isEmpty(policyItemConditionCreateInfo.getElementId())) {
                throw new BusinessException(SmcExceptCodeConstant.PARAM_IS_NULL, "[元素ID]不能为空");
            }
            if (!iStlElementAtomSV.isvalidElement(tenantId,
                    policyItemConditionCreateInfo.getElementId())) {
                throw new BusinessException("", "[元素ID:"
                        + policyItemConditionCreateInfo.getElementId() + "]无效");
            }
            if (StringUtil.isBlank(policyItemConditionCreateInfo.getMatchType())) {
                throw new BusinessException(SmcExceptCodeConstant.PARAM_IS_NULL, "[匹配方式]不能为空");
            }
            List<String> matchTypeFieldValues = getFieldValues(PolicyItemConditionCreateInfo.MatchType.class);
            if (!matchTypeFieldValues.contains(policyItemConditionCreateInfo.getMatchType())) {
                throw new BusinessException(SmcExceptCodeConstant.PARAM_TYPE_NOT_RIGHT, "[匹配方式]不合法");
            }
            if (StringUtil.isBlank(policyItemConditionCreateInfo.getMatchValue())) {
                throw new BusinessException(SmcExceptCodeConstant.PARAM_IS_NULL, "[匹配值]不能为空");
            }
        }
    }

    public static List<String> getFieldValues(Class<?> t) throws SystemException {
        List<String> list = new ArrayList<String>();
        Field[] fields = t.getFields();
        for (Field field : fields) {
            try {
                list.add(field.get(t).toString());
            } catch (IllegalArgumentException | IllegalAccessException e) {
                throw new SystemException(e);
            }
        }
        return list;
    }

    @Override
    public BaseResponse modifyPolicy(PolicyModifyRequest request) throws BusinessException,
            SystemException {
        BusinessUtil.checkBaseInfo(request);
        checkRequest(request);

        iPolicyManageBusiSV.modifyPolicy(request);

        ResponseHeader responseHeader = new ResponseHeader(true, SmcExceptCodeConstant.SUCCESS,
                "成功");
        BaseResponse response = new BaseResponse();
        response.setResponseHeader(responseHeader);
        return response;
    }

    private void checkRequest(PolicyModifyRequest request) {
        if (LongUtil.isEmpty(request.getPolicyId())) {
            throw new BusinessException(SmcExceptCodeConstant.PARAM_IS_NULL, "[政策ID]不能为空");
        }
        if (StringUtil.isBlank(request.getPolicyName())) {
            throw new BusinessException(SmcExceptCodeConstant.PARAM_IS_NULL, "[政策名称]不能为空");
        }
        if (StringUtil.isBlank(request.getStartTimeStr())) {
            throw new BusinessException(SmcExceptCodeConstant.PARAM_IS_NULL, "[政策生效时间]不能为空");
        }
        if (!DateUtil.isValidDate(request.getStartTimeStr(), DateUtil.YYYYMMDD)) {
            throw new BusinessException(SmcExceptCodeConstant.PARAM_TYPE_NOT_RIGHT, "[政策生效时间]格式不正确");
        }
        if (StringUtil.isBlank(request.getEndTimeStr())) {
            throw new BusinessException(SmcExceptCodeConstant.PARAM_IS_NULL, "[政策失效时间]不能为空");
        }
        if (!DateUtil.isValidDate(request.getEndTimeStr(), DateUtil.YYYYMMDD)) {
            throw new BusinessException(SmcExceptCodeConstant.PARAM_TYPE_NOT_RIGHT, "[政策失效时间]格式不正确");
        }
        if (StringUtil.isBlank(request.getPolicyType())) {
            throw new BusinessException(SmcExceptCodeConstant.PARAM_IS_NULL, "[政策类型]不能为空");
        }
        if (StringUtil.isBlank(request.getExecCycle())) {
            throw new BusinessException(SmcExceptCodeConstant.PARAM_IS_NULL, "[执行周期]不能为空");
        }
        List<String> execCycleFieldValues = getFieldValues(PolicyCreateRequest.ExecCycle.class);
        if (!execCycleFieldValues.contains(request.getExecCycle())) {
            throw new BusinessException(SmcExceptCodeConstant.PARAM_TYPE_NOT_RIGHT, "[执行周期]不合法");
        }
        if (StringUtil.isBlank(request.getExecTimeStr())) {
            throw new BusinessException(SmcExceptCodeConstant.PARAM_IS_NULL, "[执行时间设定]不能为空");
        }
        if (LongUtil.isEmpty(request.getDataElementId())) {
            throw new BusinessException(SmcExceptCodeConstant.PARAM_IS_NULL, "[执行周期对应时间元素ID]不能为空");
        }
        if (StringUtil.isBlank(request.getStlObjectId())) {
            throw new BusinessException(SmcExceptCodeConstant.PARAM_IS_NULL, "[结算对象]不能为空");
        }
        if (LongUtil.isEmpty(request.getStlElementId())) {
            throw new BusinessException(SmcExceptCodeConstant.PARAM_IS_NULL, "[结算属性]不能为空");
        }
        if (!iStlElementAtomSV.isValidSettlementElement(request.getTenantId(),
                request.getStlElementId())) {
            throw new BusinessException("", "[结算属性:" + request.getStlElementId() + "]无效");
        }
        if (StringUtil.isBlank(request.getStlElementSn())) {
            throw new BusinessException(SmcExceptCodeConstant.PARAM_IS_NULL, "[具体结算方（合同号）]不能为空");
        }
        if (StringUtil.isBlank(request.getBillStyleSn())) {
            throw new BusinessException(SmcExceptCodeConstant.PARAM_IS_NULL, "[账单样式编码]不能为空");
        }
        if (!iStlBillStyleAtomSV
                .isValidBillStyleSn(request.getTenantId(), request.getBillStyleSn())) {
            throw new BusinessException("", "[账单样式编码:" + request.getBillStyleSn() + "]无效");
        }
        checkPolicyItem(request.getPolicyItemModifyInfos(), request.getTenantId());
    }

    @Override
    public BaseResponse cancelPolicy(PolicyCancelRequest request) throws BusinessException,
            SystemException {
        BusinessUtil.checkBaseInfo(request);
        if (CollectionUtil.isEmpty(request.getPolicyIds())) {
            throw new BusinessException(SmcExceptCodeConstant.PARAM_IS_NULL, "[政策ID]不能为空");
        }
        for (Long policyId : request.getPolicyIds()) {
            if (LongUtil.isEmpty(policyId)) {
                throw new BusinessException(SmcExceptCodeConstant.PARAM_IS_NULL, "[政策ID]不能为空");
            }
        }

        iPolicyManageBusiSV.cancelPolicy(request);

        ResponseHeader responseHeader = new ResponseHeader(true, SmcExceptCodeConstant.SUCCESS,
                "成功");
        BaseResponse response = new BaseResponse();
        response.setResponseHeader(responseHeader);
        return response;
    }

    @Override
    public PolicyListQueryResponse queryPolicyList(PolicyListQueryRequest request) {
        BusinessUtil.checkBaseInfo(request);

        PageInfo<PolicyListQueryInfo> pageInfo = iPolicyManageBusiSV.queryPolicyList(request);

        ResponseHeader responseHeader = new ResponseHeader(true, SmcExceptCodeConstant.SUCCESS,
                "成功");
        PolicyListQueryResponse response = new PolicyListQueryResponse();
        response.setPageInfo(pageInfo);
        response.setResponseHeader(responseHeader);
        return response;
    }

    @Override
    public PolicyDetailQueryResponse queryPolicyDetail(PolicyDetailQueryRequest request) {
        BusinessUtil.checkBaseInfo(request);
        if (LongUtil.isEmpty(request.getPolicyId())) {
            throw new BusinessException(SmcExceptCodeConstant.PARAM_IS_NULL, "[政策ID]不能为空");
        }
        ResponseHeader responseHeader = new ResponseHeader(true, SmcExceptCodeConstant.SUCCESS,
                "成功");
        PolicyDetailQueryResponse response = iPolicyManageBusiSV.queryPolicyDetail(request);
        if (response == null) {
            response = new PolicyDetailQueryResponse();
        }
        response.setResponseHeader(responseHeader);
        return response;
    }
}

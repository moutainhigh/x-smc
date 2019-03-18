package com.x.ic.smc.service.busi.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.x.base.exception.BusinessException;
import com.x.base.exception.SystemException;
import com.x.base.vo.PageInfo;
import com.x.sdk.util.BeanUtils;
import com.x.sdk.util.CollectionUtil;
import com.x.sdk.util.DateUtil;
import com.x.sdk.util.StringUtil;
import com.x.ic.smc.api.policymanage.param.PolicyCancelRequest;
import com.x.ic.smc.api.policymanage.param.PolicyCreateRequest;
import com.x.ic.smc.api.policymanage.param.PolicyDetailQueryConditionInfo;
import com.x.ic.smc.api.policymanage.param.PolicyDetailQueryItemInfo;
import com.x.ic.smc.api.policymanage.param.PolicyDetailQueryPlanInfo;
import com.x.ic.smc.api.policymanage.param.PolicyDetailQueryRequest;
import com.x.ic.smc.api.policymanage.param.PolicyDetailQueryResponse;
import com.x.ic.smc.api.policymanage.param.PolicyItemConditionCreateInfo;
import com.x.ic.smc.api.policymanage.param.PolicyItemCreateInfo;
import com.x.ic.smc.api.policymanage.param.PolicyItemPlanCreateInfo;
import com.x.ic.smc.api.policymanage.param.PolicyListQueryInfo;
import com.x.ic.smc.api.policymanage.param.PolicyListQueryRequest;
import com.x.ic.smc.api.policymanage.param.PolicyModifyRequest;
import com.x.ic.smc.api.policymanage.param.StepCalValue;
import com.x.ic.smc.constants.SmcExceptCodeConstant;
import com.x.ic.smc.constants.SmcConstants;
import com.x.ic.smc.dao.mapper.bo.StlPolicy;
import com.x.ic.smc.dao.mapper.bo.StlPolicyCriteria;
import com.x.ic.smc.dao.mapper.bo.StlPolicyItem;
import com.x.ic.smc.dao.mapper.bo.StlPolicyItemCondition;
import com.x.ic.smc.dao.mapper.bo.StlPolicyItemConditionCriteria;
import com.x.ic.smc.dao.mapper.bo.StlPolicyItemCriteria;
import com.x.ic.smc.dao.mapper.bo.StlPolicyItemPlan;
import com.x.ic.smc.dao.mapper.bo.StlPolicyItemPlanCriteria;
import com.x.ic.smc.dao.mapper.factory.MapperFactory;
import com.x.ic.smc.service.busi.interfaces.IPolicyManageBusiSV;
import com.x.ic.smc.util.LongUtil;
import com.x.ic.smc.util.SmcSeqUtil;
import com.x.ic.smc.vo.SetpCalValueVO;
import com.alibaba.fastjson.JSON;

@Component
@Transactional
public class PolicyManageBusiSVImpl implements IPolicyManageBusiSV {

    @Override
    public void createPolicy(PolicyCreateRequest request) throws SystemException {
        Timestamp sysdate = DateUtil.getSysDate();
        Long policyId = SmcSeqUtil.createPolicyId();
        // 保存政策表
        StlPolicy stlPolicy = new StlPolicy();
        BeanUtils.copyVO(stlPolicy, request);
        stlPolicy.setPolicyId(policyId);
        stlPolicy.setTenantId(request.getTenantId());
        stlPolicy.setStartTime(DateUtil.getTimestamp(request.getStartTimeStr(), DateUtil.YYYYMMDD));
        stlPolicy.setEndTime(DateUtil.getTheDayLastSecond(DateUtil.getTimestamp(
                request.getEndTimeStr(), DateUtil.YYYYMMDD)));
        stlPolicy.setCreateDeptId(request.getOptDeptId());
        stlPolicy.setCreateOperId(request.getOptOperId());
        stlPolicy.setCreateTime(sysdate);
        stlPolicy.setState(SmcConstants.StlPolicy.State.NORMAL);
        MapperFactory.getStlPolicyMapper().insert(stlPolicy);
        // 保存政策项
        for (PolicyItemCreateInfo policyItemCreateInfo : request.getPolicyItemCreateInfo()) {
            Long itemId = SmcSeqUtil.createItemId();
            StlPolicyItem stlPolicyItem = new StlPolicyItem();
            stlPolicyItem.setItemId(itemId);
            stlPolicyItem.setTenantId(request.getTenantId());
            stlPolicyItem.setPolicyId(policyId);
            MapperFactory.getStlPolicyItemMapper().insert(stlPolicyItem);
            if (!CollectionUtil.isEmpty(policyItemCreateInfo.getPolicyItemConditionCreateInfos())) {
                for (PolicyItemConditionCreateInfo conditionCreateInfo : policyItemCreateInfo
                        .getPolicyItemConditionCreateInfos()) {
                    Long conditionId = SmcSeqUtil.createConditionId();
                    StlPolicyItemCondition stlPolicyItemCondition = new StlPolicyItemCondition();
                    stlPolicyItemCondition.setConditionId(conditionId);
                    stlPolicyItemCondition.setTenantId(request.getTenantId());
                    stlPolicyItemCondition.setItemId(itemId);
                    stlPolicyItemCondition.setPolicyId(policyId);
                    stlPolicyItemCondition.setObjectId(conditionCreateInfo.getObjectId());
                    stlPolicyItemCondition.setElementId(conditionCreateInfo.getElementId());
                    stlPolicyItemCondition.setMatchType(conditionCreateInfo.getMatchType());
                    stlPolicyItemCondition.setMatchValue(conditionCreateInfo.getMatchValue());
                    MapperFactory.getStlPolicyItemConditionMapper().insert(stlPolicyItemCondition);
                }
            }
            for (PolicyItemPlanCreateInfo policyItemPlanCreateInfo : policyItemCreateInfo
                    .getPolicyItemPlanCreateInfos()) {
                Long planId = SmcSeqUtil.createPlanId();
                StlPolicyItemPlan stlPolicyItemPlan = new StlPolicyItemPlan();
                stlPolicyItemPlan.setPlanId(planId);
                stlPolicyItemPlan.setTenantId(request.getTenantId());
                stlPolicyItemPlan.setItemId(itemId);
                stlPolicyItemPlan.setPolicyId(policyId);
                stlPolicyItemPlan.setObjectId(policyItemPlanCreateInfo.getObjectId());
                stlPolicyItemPlan.setElementId(policyItemPlanCreateInfo.getElementId());
                stlPolicyItemPlan.setFeeItem(policyItemPlanCreateInfo.getFeeItem());
                stlPolicyItemPlan.setPlanType(policyItemPlanCreateInfo.getPlanType());
                stlPolicyItemPlan.setCalType(policyItemPlanCreateInfo.getCalType());
                if (SmcConstants.StlPolicyItemPlan.PlanType.NORMAL.equals(policyItemPlanCreateInfo
                        .getPlanType())) {
                    stlPolicyItemPlan.setCalValue(policyItemPlanCreateInfo.getNormalCalValue());
                } else {
                    List<SetpCalValueVO> calValueVOs = new ArrayList<SetpCalValueVO>();
                    for (StepCalValue stepCalValue : policyItemPlanCreateInfo.getStepCalValues()) {
                        SetpCalValueVO setpCalValueVO = new SetpCalValueVO();
                        setpCalValueVO.setStartValue(stepCalValue.getStartValue());
                        setpCalValueVO.setEndValue(stepCalValue.getEndValue());
                        setpCalValueVO.setValue(stepCalValue.getCalValue());
                        calValueVOs.add(setpCalValueVO);
                    }
                    stlPolicyItemPlan.setCalValue(JSON.toJSONString(calValueVOs));
                }
                MapperFactory.getStlPolicyItemPlanMapper().insert(stlPolicyItemPlan);
            }
        }
    }

    @Override
    public void modifyPolicy(PolicyModifyRequest request) {
        Long policyId = request.getPolicyId();
        // 校验租户
        StlPolicyCriteria criteria = new StlPolicyCriteria();
        criteria.createCriteria().andTenantIdEqualTo(request.getTenantId())
                .andPolicyIdEqualTo(request.getPolicyId());
        int count = MapperFactory.getStlPolicyMapper().countByExample(criteria);
        if (count <= 0) {
            throw new BusinessException(SmcExceptCodeConstant.NO_RESULT, "政策ID["
                    + request.getPolicyId() + "]不存在");
        }
        Timestamp sysdate = DateUtil.getSysDate();
        // update stl_policy
        StlPolicy stlPolicy = new StlPolicy();
        BeanUtils.copyVO(stlPolicy, request);
        stlPolicy.setTenantId(request.getTenantId());
        stlPolicy.setStartTime(DateUtil.getTimestamp(request.getStartTimeStr(), DateUtil.YYYYMMDD));
        stlPolicy.setEndTime(DateUtil.getTheDayLastSecond(DateUtil.getTimestamp(
                request.getEndTimeStr(), DateUtil.YYYYMMDD)));
        stlPolicy.setUpdateDeptId(request.getOptDeptId());
        stlPolicy.setUpdateOperId(request.getOptOperId());
        stlPolicy.setUpdateTime(sysdate);
        MapperFactory.getStlPolicyMapper().updateByExampleSelective(stlPolicy, criteria);
        // delete stl_policy_item
        StlPolicyItemCriteria stlPolicyItemCriteria = new StlPolicyItemCriteria();
        stlPolicyItemCriteria.createCriteria().andTenantIdEqualTo(request.getTenantId())
                .andPolicyIdEqualTo(request.getPolicyId());
        MapperFactory.getStlPolicyItemMapper().deleteByExample(stlPolicyItemCriteria);
        // delete stl_policy_item_condition
        StlPolicyItemConditionCriteria stlPolicyItemConditionCriteria = new StlPolicyItemConditionCriteria();
        stlPolicyItemConditionCriteria.createCriteria().andTenantIdEqualTo(request.getTenantId())
                .andPolicyIdEqualTo(request.getPolicyId());
        MapperFactory.getStlPolicyItemConditionMapper().deleteByExample(
                stlPolicyItemConditionCriteria);
        // delete stl_policy_item_plan
        StlPolicyItemPlanCriteria stlPolicyItemPlanCriteria = new StlPolicyItemPlanCriteria();
        stlPolicyItemPlanCriteria.createCriteria().andTenantIdEqualTo(request.getTenantId())
                .andPolicyIdEqualTo(request.getPolicyId());
        MapperFactory.getStlPolicyItemPlanMapper().deleteByExample(stlPolicyItemPlanCriteria);
        // 保存政策项
        for (PolicyItemCreateInfo policyItemCreateInfo : request.getPolicyItemModifyInfos()) {
            Long itemId = SmcSeqUtil.createItemId();
            StlPolicyItem stlPolicyItem = new StlPolicyItem();
            stlPolicyItem.setItemId(itemId);
            stlPolicyItem.setTenantId(request.getTenantId());
            stlPolicyItem.setPolicyId(policyId);
            MapperFactory.getStlPolicyItemMapper().insert(stlPolicyItem);
            if (!CollectionUtil.isEmpty(policyItemCreateInfo.getPolicyItemConditionCreateInfos())) {
                for (PolicyItemConditionCreateInfo conditionCreateInfo : policyItemCreateInfo
                        .getPolicyItemConditionCreateInfos()) {
                    Long conditionId = SmcSeqUtil.createConditionId();
                    StlPolicyItemCondition stlPolicyItemCondition = new StlPolicyItemCondition();
                    stlPolicyItemCondition.setConditionId(conditionId);
                    stlPolicyItemCondition.setTenantId(request.getTenantId());
                    stlPolicyItemCondition.setItemId(itemId);
                    stlPolicyItemCondition.setPolicyId(policyId);
                    stlPolicyItemCondition.setObjectId(conditionCreateInfo.getObjectId());
                    stlPolicyItemCondition.setElementId(conditionCreateInfo.getElementId());
                    stlPolicyItemCondition.setMatchType(conditionCreateInfo.getMatchType());
                    stlPolicyItemCondition.setMatchValue(conditionCreateInfo.getMatchValue());
                    MapperFactory.getStlPolicyItemConditionMapper().insert(stlPolicyItemCondition);
                }
            }
            for (PolicyItemPlanCreateInfo policyItemPlanCreateInfo : policyItemCreateInfo
                    .getPolicyItemPlanCreateInfos()) {
                Long planId = SmcSeqUtil.createPlanId();
                StlPolicyItemPlan stlPolicyItemPlan = new StlPolicyItemPlan();
                stlPolicyItemPlan.setPlanId(planId);
                stlPolicyItemPlan.setTenantId(request.getTenantId());
                stlPolicyItemPlan.setItemId(itemId);
                stlPolicyItemPlan.setPolicyId(policyId);
                stlPolicyItemPlan.setObjectId(policyItemPlanCreateInfo.getObjectId());
                stlPolicyItemPlan.setElementId(policyItemPlanCreateInfo.getElementId());
                stlPolicyItemPlan.setFeeItem(policyItemPlanCreateInfo.getFeeItem());
                stlPolicyItemPlan.setPlanType(policyItemPlanCreateInfo.getPlanType());
                stlPolicyItemPlan.setCalType(policyItemPlanCreateInfo.getCalType());
                if (SmcConstants.StlPolicyItemPlan.PlanType.NORMAL.equals(policyItemPlanCreateInfo
                        .getPlanType())) {
                    stlPolicyItemPlan.setCalValue(policyItemPlanCreateInfo.getNormalCalValue());
                } else {
                    List<SetpCalValueVO> calValueVOs = new ArrayList<SetpCalValueVO>();
                    for (StepCalValue stepCalValue : policyItemPlanCreateInfo.getStepCalValues()) {
                        SetpCalValueVO setpCalValueVO = new SetpCalValueVO();
                        setpCalValueVO.setStartValue(stepCalValue.getStartValue());
                        setpCalValueVO.setEndValue(stepCalValue.getEndValue());
                        setpCalValueVO.setValue(stepCalValue.getCalValue());
                        calValueVOs.add(setpCalValueVO);
                    }
                    stlPolicyItemPlan.setCalValue(JSON.toJSONString(calValueVOs));
                }
                MapperFactory.getStlPolicyItemPlanMapper().insert(stlPolicyItemPlan);
            }
        }
    }

    @Override
    public void cancelPolicy(PolicyCancelRequest request) {
        for (Long policyId : request.getPolicyIds()) {
            StlPolicyCriteria criteria = new StlPolicyCriteria();
            criteria.createCriteria().andTenantIdEqualTo(request.getTenantId())
                    .andPolicyIdEqualTo(policyId);
            StlPolicy stlPolicy = new StlPolicy();
            stlPolicy.setPolicyId(policyId);
            stlPolicy.setTenantId(request.getTenantId());
            stlPolicy.setState(SmcConstants.StlPolicy.State.CANCELLED);
            MapperFactory.getStlPolicyMapper().updateByExampleSelective(stlPolicy, criteria);
        }
    }

    @Override
    public PageInfo<PolicyListQueryInfo> queryPolicyList(PolicyListQueryRequest request) {
        PageInfo<PolicyListQueryInfo> pageInfo = request.getPageInfo();
        StlPolicyCriteria stlPolicyCriteria = new StlPolicyCriteria();
        StlPolicyCriteria.Criteria criteria = stlPolicyCriteria.createCriteria();
        assembleSql(request, criteria);
        int count = MapperFactory.getStlPolicyMapper().countByExample(stlPolicyCriteria);
        // 不分页
        if (pageInfo == null) {
            pageInfo = new PageInfo<PolicyListQueryInfo>();
            pageInfo.setPageNo(1);
            pageInfo.setPageSize(count == 0 ? 10 : count);
        }
        // 分页
        else {
            stlPolicyCriteria.setLimitStart(pageInfo.getStartRowIndex());
            stlPolicyCriteria.setLimitEnd(pageInfo.getEndRowIndex());
        }
        pageInfo.setCount(count);
        if (count > 0) {
            List<StlPolicy> stlPolicies = MapperFactory.getStlPolicyMapper().selectByExample(
                    stlPolicyCriteria);
            if (!CollectionUtil.isEmpty(stlPolicies)) {
                List<PolicyListQueryInfo> policyListQueryInfos = new ArrayList<PolicyListQueryInfo>();
                for (StlPolicy stlPolicy : stlPolicies) {
                    PolicyListQueryInfo policyListQueryInfo = new PolicyListQueryInfo();
                    BeanUtils.copyVO(policyListQueryInfo, stlPolicy);
                    policyListQueryInfo.setStartTimeStr(DateUtil.getDateString(
                            stlPolicy.getStartTime(), DateUtil.YYYYMMDD));
                    policyListQueryInfo.setEndTimeStr(DateUtil.getDateString(
                            stlPolicy.getEndTime(), DateUtil.YYYYMMDD));
                    if (stlPolicy.getCreateTime() != null) {
                        policyListQueryInfo.setCreateTimeStr(DateUtil.getDateString(
                                stlPolicy.getCreateTime(), DateUtil.YYYYMMDD));
                    }
                    if (stlPolicy.getUpdateTime() != null) {
                        policyListQueryInfo.setUpdateTimeStr(DateUtil.getDateString(
                                stlPolicy.getUpdateTime(), DateUtil.YYYYMMDD));
                    }
                    policyListQueryInfos.add(policyListQueryInfo);
                }
                pageInfo.setResult(policyListQueryInfos);
            }
        }
        return pageInfo;
    }

    public void assembleSql(PolicyListQueryRequest request, StlPolicyCriteria.Criteria criteria) {
        criteria.andTenantIdEqualTo(request.getTenantId());
        if (!LongUtil.isEmpty(request.getPolicyId())) {
            criteria.andPolicyIdEqualTo(request.getPolicyId());
        }
        if (!StringUtil.isBlank(request.getPolicyCode())) {
            criteria.andPolicyCodeEqualTo(request.getPolicyCode());
        }
        if (!StringUtil.isBlank(request.getPolicyName())) {
            criteria.andPolicyNameEqualTo(request.getPolicyName());
        }
        if (!StringUtil.isBlank(request.getStartTimeStr())) {
            criteria.andStartTimeEqualTo(DateUtil.getTimestamp(request.getStartTimeStr(),
                    DateUtil.YYYYMMDD));
        }
        if (!StringUtil.isBlank(request.getEndTimeStr())) {
            criteria.andEndTimeEqualTo(DateUtil.getTheDayLastSecond(DateUtil.getTimestamp(
                    request.getEndTimeStr(), DateUtil.YYYYMMDD)));
        }
        if (!StringUtil.isBlank(request.getPolicyType())) {
            criteria.andPolicyTypeEqualTo(request.getPolicyType());
        }
        if (!StringUtil.isBlank(request.getPolicyDesc())) {
            criteria.andPolicyDescEqualTo(request.getPolicyDesc());
        }
        if (!StringUtil.isBlank(request.getExecCycle())) {
            criteria.andExecCycleEqualTo(request.getExecCycle());

        }
        if (!StringUtil.isBlank(request.getExecTimeStr())) {
            criteria.andExecTimeStrEqualTo(request.getExecTimeStr());
        }
        if (!StringUtil.isBlank(request.getDataObjectId())) {
            criteria.andDataObjectIdEqualTo(request.getDataObjectId());
        }
        if (!LongUtil.isEmpty(request.getDataElementId())) {
            criteria.andDataElementIdEqualTo(request.getDataElementId());
        }
        if (!StringUtil.isBlank(request.getStlObjectId())) {
            criteria.andStlObjectIdEqualTo(request.getStlObjectId());
        }
        if (!LongUtil.isEmpty(request.getStlElementId())) {
            criteria.andStlElementIdEqualTo(request.getStlElementId());
        }
        if (!StringUtil.isBlank(request.getBillStyleSn())) {
            criteria.andBillStyleSnEqualTo(request.getBillStyleSn());
        }
        if (!StringUtil.isBlank(request.getCheckFeeFlag())) {
            criteria.andCheckFeeFlagEqualTo(request.getCheckFeeFlag());
        }
        if (!StringUtil.isBlank(request.getState())) {
            criteria.andStateEqualTo(request.getState());
        }
        if (!StringUtil.isBlank(request.getCreateOperId())) {
            criteria.andCreateDeptIdEqualTo(request.getCreateOperId());
        }
        if (!StringUtil.isBlank(request.getCreateOperId())) {
            criteria.andCreateOperIdEqualTo(request.getCreateOperId());
        }
        if (!StringUtil.isBlank(request.getCreateTimeStr())) {
            criteria.andCreateTimeEqualTo(DateUtil.getTimestamp(request.getCreateTimeStr(),
                    DateUtil.YYYYMMDD));
        }
        if (!StringUtil.isBlank(request.getUpdateDeptId())) {
            criteria.andUpdateDeptIdEqualTo(request.getUpdateDeptId());
        }
        if (!StringUtil.isBlank(request.getUpdateOperId())) {
            criteria.andUpdateOperIdEqualTo(request.getUpdateOperId());
        }
        if (!StringUtil.isBlank(request.getUpdateTimeStr())) {
            criteria.andUpdateTimeEqualTo(DateUtil.getTimestamp(request.getUpdateTimeStr(),
                    DateUtil.YYYYMMDD));
        }
    }

    @Override
    public PolicyDetailQueryResponse queryPolicyDetail(PolicyDetailQueryRequest request) {
        StlPolicyCriteria stlPolicyCriteria = new StlPolicyCriteria();
        stlPolicyCriteria.createCriteria().andTenantIdEqualTo(request.getTenantId())
                .andPolicyIdEqualTo(request.getPolicyId());
        List<StlPolicy> stlPolicies = MapperFactory.getStlPolicyMapper().selectByExample(
                stlPolicyCriteria);
        if (CollectionUtil.isEmpty(stlPolicies)) {
            return null;
        }
        StlPolicy stlPolicy = stlPolicies.get(0);
        PolicyDetailQueryResponse response = new PolicyDetailQueryResponse();
        BeanUtils.copyVO(response, stlPolicy);
        response.setStartTimeStr(DateUtil.getDateString(stlPolicy.getStartTime(), DateUtil.YYYYMMDD));
        response.setEndTimeStr(DateUtil.getDateString(stlPolicy.getEndTime(), DateUtil.YYYYMMDD));
        if (stlPolicy.getCreateTime() != null) {
            response.setCreateTimeStr(DateUtil.getDateString(stlPolicy.getCreateTime(),
                    DateUtil.YYYYMMDD));
        }
        if (stlPolicy.getUpdateTime() != null) {
            response.setUpdateTimeStr(DateUtil.getDateString(stlPolicy.getUpdateTime(),
                    DateUtil.YYYYMMDD));
        }
        StlPolicyItemCriteria stlPolicyItemCriteria = new StlPolicyItemCriteria();
        stlPolicyItemCriteria.createCriteria().andTenantIdEqualTo(request.getTenantId())
                .andPolicyIdEqualTo(request.getPolicyId());
        List<StlPolicyItem> stlPolicyItems = MapperFactory.getStlPolicyItemMapper()
                .selectByExample(stlPolicyItemCriteria);
        if (!CollectionUtil.isEmpty(stlPolicyItems)) {
            List<PolicyDetailQueryItemInfo> policyDetailQueryItemInfos = new ArrayList<PolicyDetailQueryItemInfo>();
            for (StlPolicyItem stlPolicyItem : stlPolicyItems) {
                PolicyDetailQueryItemInfo policyDetailQueryItemInfo = new PolicyDetailQueryItemInfo();
                policyDetailQueryItemInfo.setItemId(stlPolicyItem.getItemId());
                policyDetailQueryItemInfos.add(policyDetailQueryItemInfo);
                // condition
                StlPolicyItemConditionCriteria stlPolicyItemConditionCriteria = new StlPolicyItemConditionCriteria();
                stlPolicyItemConditionCriteria.createCriteria()
                        .andTenantIdEqualTo(request.getTenantId())
                        .andItemIdEqualTo(stlPolicyItem.getItemId());
                List<StlPolicyItemCondition> stlPolicyItemConditions = MapperFactory
                        .getStlPolicyItemConditionMapper().selectByExample(
                                stlPolicyItemConditionCriteria);
                if (!CollectionUtil.isEmpty(stlPolicyItemConditions)) {
                    List<PolicyDetailQueryConditionInfo> policyDetailQueryConditionInfos = new ArrayList<PolicyDetailQueryConditionInfo>();
                    for (StlPolicyItemCondition stlPolicyItemCondition : stlPolicyItemConditions) {
                        PolicyDetailQueryConditionInfo policyDetailQueryConditionInfo = new PolicyDetailQueryConditionInfo();
                        BeanUtils.copyVO(policyDetailQueryConditionInfo, stlPolicyItemCondition);
                        if (stlPolicyItemCondition.getUpdateTime() != null) {
                            policyDetailQueryConditionInfo.setUpdateTimeStr(DateUtil.getDateString(
                                    stlPolicyItemCondition.getUpdateTime(), DateUtil.YYYYMMDD));
                        }
                        policyDetailQueryConditionInfos.add(policyDetailQueryConditionInfo);
                    }
                    policyDetailQueryItemInfo
                            .setPolicyDetailQueryConditionInfos(policyDetailQueryConditionInfos);
                }
                // plan
                StlPolicyItemPlanCriteria stlPolicyItemPlanCriteria = new StlPolicyItemPlanCriteria();
                stlPolicyItemPlanCriteria.createCriteria()
                        .andTenantIdEqualTo(request.getTenantId())
                        .andItemIdEqualTo(stlPolicyItem.getItemId());
                List<StlPolicyItemPlan> stlPolicyItemPlans = MapperFactory
                        .getStlPolicyItemPlanMapper().selectByExample(stlPolicyItemPlanCriteria);
                if (!CollectionUtil.isEmpty(stlPolicyItemPlans)) {
                    List<PolicyDetailQueryPlanInfo> policyDetailQueryPlanInfos = new ArrayList<PolicyDetailQueryPlanInfo>();
                    for (StlPolicyItemPlan stlPolicyItemPlan : stlPolicyItemPlans) {
                        PolicyDetailQueryPlanInfo policyDetailQueryPlanInfo = new PolicyDetailQueryPlanInfo();
                        BeanUtils.copyVO(policyDetailQueryPlanInfo, stlPolicyItemPlan);
                        if (SmcConstants.StlPolicyItemPlan.PlanType.NORMAL.equals(stlPolicyItemPlan
                                .getPlanType())) {
                            policyDetailQueryPlanInfo.setNormalCalValue(stlPolicyItemPlan
                                    .getCalValue());
                        } else {
                            List<StepCalValue> stepCalValues = JSON.parseArray(
                                    stlPolicyItemPlan.getCalValue(), StepCalValue.class);
                            policyDetailQueryPlanInfo.setStepCalValues(stepCalValues);
                        }
                        if (stlPolicyItemPlan.getUpdateTime() != null) {
                            policyDetailQueryPlanInfo.setUpdateTimeStr(DateUtil.getDateString(
                                    stlPolicyItemPlan.getUpdateTime(), DateUtil.YYYYMMDD));
                        }
                        policyDetailQueryPlanInfos.add(policyDetailQueryPlanInfo);
                    }
                    policyDetailQueryItemInfo
                            .setPolicyDetailQueryPlanInfos(policyDetailQueryPlanInfos);
                }
            }
            response.setPolicyDetailQueryItemInfos(policyDetailQueryItemInfos);
        }
        return response;

    }

}

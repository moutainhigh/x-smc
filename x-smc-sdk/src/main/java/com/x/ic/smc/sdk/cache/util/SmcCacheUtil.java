package com.x.ic.smc.sdk.cache.util;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.x.ic.smc.sdk.cache.constants.CacheConstant;
import com.x.ic.smc.sdk.cache.vo.Element;
import com.x.ic.smc.sdk.cache.vo.ElementAttr;
import com.x.ic.smc.sdk.cache.vo.Node;
import com.x.ic.smc.sdk.cache.vo.NodeElementMapping;
import com.x.ic.smc.sdk.cache.vo.Policy;
import com.x.ic.smc.sdk.cache.vo.PolicyBillPlan;
import com.x.ic.smc.sdk.cache.vo.PolicyInstn;
import com.x.ic.smc.sdk.cache.vo.PolicyItem;
import com.x.ic.smc.sdk.cache.vo.PolicyItemCondition;
import com.x.ic.smc.sdk.cache.vo.PolicyItemPlan;
import com.x.ic.smc.sdk.cache.vo.PolicyItemPlanInstn;
import com.x.ic.smc.sdk.cache.vo.PolicyTaskCycle;
import com.x.ic.smc.sdk.cache.vo.SysParam;
import com.x.sdk.mcs.MCSClientFactory;
import com.x.sdk.util.StringUtil;

public class SmcCacheUtil {
	
	public static Policy getPolicyByPolicyId(String tenantId , Long policyId){
		String policyStr = MCSClientFactory.getCacheClient(CacheConstant.MSDNS).hget(CacheConstant.NameSpace.POLICY_CACHE,CacheKeyUtil.getPolicyKeyByPolicyId(tenantId, policyId));
		if(StringUtil.isBlank(policyStr)){
			return null;
		}else{
			return JSONObject.parseObject(policyStr, Policy.class);
		}
	}
	public static List<Policy> getPolicyByTenantId(String tenantId){
		String policyStr = MCSClientFactory.getCacheClient(CacheConstant.MSDNS).hget(CacheConstant.NameSpace.POLICY_CACHE,CacheKeyUtil.getPolicyKeyByTenantId(tenantId));
		if(StringUtil.isBlank(policyStr)){
			return null;
		}else{
			return JSONArray.parseArray(policyStr, Policy.class);
		}
	}
	public static List<Node> getNodeByContractId(String tenantId , String ContractId){
		String nodeStr = MCSClientFactory.getCacheClient(CacheConstant.MSDNS).hget(CacheConstant.NameSpace.NODE_CACHE,CacheKeyUtil.getNodeByContractId(tenantId, ContractId));
		if(StringUtil.isBlank(nodeStr)){
			return null;
		}else{
			return JSONArray.parseArray(nodeStr, Node.class);
		}
	}
	public static Node getNodeByNodeId(String tenantId , Long nodeId){
		String nodeStr = MCSClientFactory.getCacheClient(CacheConstant.MSDNS).hget(CacheConstant.NameSpace.NODE_CACHE,CacheKeyUtil.getNodeByNodeId(tenantId, nodeId));
		if(StringUtil.isBlank(nodeStr)){
			return null;
		}else{
			return JSONObject.parseObject(nodeStr, Node.class);
		}
	}
	public static List<NodeElementMapping> getNodeElementMappingByPolicyId(String tenantId , Long policyId){
		String mappingStr = MCSClientFactory.getCacheClient(CacheConstant.MSDNS).hget(CacheConstant.NameSpace.NODE_ELEMENT_MAPPING_CACHE,CacheKeyUtil.getNodeElementMappingByPolicyId(tenantId, policyId));
		if(StringUtil.isBlank(mappingStr)){
			return null;
		}else{
			return JSONArray.parseArray(mappingStr, NodeElementMapping.class);
		}
	}
	public static List<PolicyItem> getPolicyItemByPolicyId(String tenantId , Long policyId){
		String itemStr = MCSClientFactory.getCacheClient(CacheConstant.MSDNS).hget(CacheConstant.NameSpace.POLICY_ITEM_CACHE,CacheKeyUtil.getPolicyItemByPolicyId(tenantId, policyId));
		if(StringUtil.isBlank(itemStr)){
			return null;
		}else{
			return JSONArray.parseArray(itemStr, PolicyItem.class);
		}
	}
	public static List<PolicyItemPlan> getPolicyItemPlanByPolicyId(String tenantId , Long policyId){
		String planStr = MCSClientFactory.getCacheClient(CacheConstant.MSDNS).hget(CacheConstant.NameSpace.POLICY_ITEM_PLAN_CACHE,CacheKeyUtil.getPolicyItemPlanByPolicyId(tenantId, policyId));
		if(StringUtil.isBlank(planStr)){
			return null;
		}else{
			return JSONArray.parseArray(planStr, PolicyItemPlan.class);
		}
	}
	public static List<Element> getElementByPolicyId(String tenantId,Long policyId){
		String elementStr = MCSClientFactory.getCacheClient(CacheConstant.MSDNS).hget(CacheConstant.NameSpace.ELEMENT_CACHE, CacheKeyUtil.getElementByPolicyId(tenantId, policyId));
		if(StringUtil.isBlank(elementStr)){
			return null;
		}else{
			return JSONArray.parseArray(elementStr, Element.class);
		}
	}
	public static Element getElementByElementId(String tenantId,Long elementId){
		String elementStr = MCSClientFactory.getCacheClient(CacheConstant.MSDNS).hget(CacheConstant.NameSpace.ELEMENT_CACHE, CacheKeyUtil.getElementByElementId(tenantId, elementId));
		if(StringUtil.isBlank(elementStr)){
			return null;
		}else{
			return JSONObject.parseObject(elementStr, Element.class);
		}
	}
	public static List<PolicyItemCondition> getPolicyItemConditionByTenantId(String tenantId){
		String conditionStr = MCSClientFactory.getCacheClient(CacheConstant.MSDNS).hget(CacheConstant.NameSpace.POLICY_ITEM_CONDITION_CACHE, CacheKeyUtil.getPolicyItemConditionByTenantId(tenantId));
		if(StringUtil.isBlank(conditionStr)){
			return null;
		}else{
			return JSONArray.parseArray(conditionStr, PolicyItemCondition.class);
		}
	}
	public static List<PolicyItemCondition> getPolicyItemConditionByDataFormat(String tenantId,String dataFormat){
		String conditionStr = MCSClientFactory.getCacheClient(CacheConstant.MSDNS).hget(CacheConstant.NameSpace.POLICY_ITEM_CONDITION_CACHE, CacheKeyUtil.getPolicyItemConditionByDataFormat(tenantId,dataFormat));
		if(StringUtil.isBlank(conditionStr)){
			return null;
		}else{
			return JSONArray.parseArray(conditionStr, PolicyItemCondition.class);
		}
	}
	public static List<PolicyItemCondition> getPolicyItemConditionByContractId(String tenantId,String dataFormat,String contractId){
		String conditionStr = MCSClientFactory.getCacheClient(CacheConstant.MSDNS).hget(CacheConstant.NameSpace.POLICY_ITEM_CONDITION_CACHE, CacheKeyUtil.getPolicyItemConditionByContractId(tenantId, dataFormat, contractId));
		if(StringUtil.isBlank(conditionStr)){
			return null;
		}else{
			return JSONArray.parseArray(conditionStr, PolicyItemCondition.class);
		}
	}
	
	public static List<SysParam> getSysParamByTypeCode(String tenantId,String typeCode){
		String paramStr = MCSClientFactory.getCacheClient(CacheConstant.MSDNS).hget(CacheConstant.NameSpace.SYS_PARAM_CACHE, CacheKeyUtil.getSysParamByTypeCode(tenantId,typeCode));
		if(StringUtil.isBlank(paramStr)){
			return null;
		}else{
			return JSONArray.parseArray(paramStr, SysParam.class);
		}
	}
	public static List<SysParam> getSysParamByParamCode(String tenantId,String typeCode,String paramCode){
		String paramStr = MCSClientFactory.getCacheClient(CacheConstant.MSDNS).hget(CacheConstant.NameSpace.SYS_PARAM_CACHE, CacheKeyUtil.getSysParamByParamCode(tenantId, typeCode, paramCode));
		if(StringUtil.isBlank(paramStr)){
			return null;
		}else{
			return JSONArray.parseArray(paramStr, SysParam.class);
		}
	}
	public static SysParam getSysParamByColumnValue(String tenantId,String typeCode,String paramCode,String columnValue){
		String paramStr = MCSClientFactory.getCacheClient(CacheConstant.MSDNS).hget(CacheConstant.NameSpace.SYS_PARAM_CACHE, CacheKeyUtil.getSysParamByColumnValue(tenantId, typeCode, paramCode, columnValue));
		if(StringUtil.isBlank(paramStr)){
			return null;
		}else{
			return JSONObject.parseObject(paramStr, SysParam.class);
		}
	}
	public static  PolicyTaskCycle getPolicyTaskCycleByPolicyId(String tenantId,Long policyId){
		String cycleStr = MCSClientFactory.getCacheClient(CacheConstant.MSDNS).hget(CacheConstant.NameSpace.POLICY_TASK_CYCLE, CacheKeyUtil.getPolicyTaskCycleByPolicyId(tenantId, policyId));
		if(StringUtil.isBlank(cycleStr)){
			return null;
		}else{
			PolicyTaskCycle cycle = JSONObject.parseObject(cycleStr, PolicyTaskCycle.class);
			return cycle;
		}
	}
	public static  PolicyItemPlanInstn getPolicyItemPlanInstnByPolicyId(String tenantId,Long policyId,String objectCode){
		String instnStr = MCSClientFactory.getCacheClient(CacheConstant.MSDNS).hget(CacheConstant.NameSpace.POLICY_ITEM_PLAN_CACHE_INSTN, CacheKeyUtil.getPolicyItemPlanInstnByPolicyId(tenantId, policyId,objectCode));
		if(StringUtil.isBlank(instnStr)){
			return null;
		}else{
			PolicyItemPlanInstn instn = JSONObject.parseObject(instnStr, PolicyItemPlanInstn.class);
			return instn;
		}
	}
	public static final List<PolicyBillPlan> getPolicyBillPlanByPolicyId(String tenantId ,String policyId){
		String paramStr = MCSClientFactory.getCacheClient(CacheConstant.MSDNS).hget(CacheConstant.NameSpace.POLICY_BILL_PLAN_CACHE, 
				CacheKeyUtil.getPolicyBillPlanByPolicyId(tenantId, policyId));
		if (StringUtils.isBlank(paramStr)) {
			return null;
		}else {
			return JSONObject.parseArray(paramStr, PolicyBillPlan.class);

		}
	}
	public static final List<ElementAttr> getElementAttrByElementId(String tenantId ,Long elementId){
		String paramStr = MCSClientFactory.getCacheClient(CacheConstant.MSDNS).hget(CacheConstant.NameSpace.STL_ELEMENT_ATTR_CACHE, 
				CacheKeyUtil.getElementAttrByElementId(tenantId, elementId));
		if (StringUtils.isBlank(paramStr)) {
			return null;
		}else {
			return JSONObject.parseArray(paramStr, ElementAttr.class);

		}
	}
	public static final PolicyInstn getPolicyInstnByObjectCode(String tenantId ,Long elementId,String objectCode){
		String paramStr = MCSClientFactory.getCacheClient(CacheConstant.MSDNS).hget(CacheConstant.NameSpace.POLICY_INSTN_CACHE, 
				CacheKeyUtil.getPolicyInstnByObjectCode(tenantId, elementId,objectCode));
		if (StringUtils.isBlank(paramStr)) {
			return null;
		}else {
			return JSONObject.parseObject(paramStr, PolicyInstn.class);

		}
	}
	public static void main(String[] args) {
		//String str = JSON.toJSONString(getElementByPolicyId("pubgo",50001l));
		String str = JSON.toJSONString(SmcCacheUtil.getPolicyInstnByObjectCode("pubgo", 100002L,"101102001"));
		System.out.println(str);
	}
	
}

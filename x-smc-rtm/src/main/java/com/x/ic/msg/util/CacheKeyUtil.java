package com.x.ic.msg.util;

public class CacheKeyUtil {
	
	public static String getPolicyKeyByPolicyId(String tenantId,Long policyId){
		StringBuffer key = new StringBuffer();
		key.append("TenantId:").append(tenantId);
		key.append(".");
		key.append("PolicyId:").append(policyId);
		return key.toString();
	}
	
	public static String getPolicyKeyByTenantId(String tenantId){
		StringBuffer key = new StringBuffer();
		key.append("TenantId:").append(tenantId);
		return key.toString();
	}
	
	public static String getNodeByContractId(String tenantId , String ContractId){	
		StringBuffer key = new StringBuffer();
		key.append("TenantId:").append(tenantId);
		key.append(".");
		key.append("ContractId:").append(ContractId);
		return key.toString();
	}
	
	public static String getNodeByNodeId(String tenantId , Long nodeId){	
		StringBuffer key = new StringBuffer();
		key.append("TenantId:").append(tenantId);
		key.append(".");
		key.append("NodeId:").append(nodeId);
		return key.toString();
	}
	
	public static String getNodeElementMappingByPolicyId(String tenantId,Long policyId){
		StringBuffer key = new StringBuffer();
		key.append("TenantId:").append(tenantId);
		key.append(".");
		key.append("PolicyId:").append(policyId);
		return key.toString();
	}
	public static String getPolicyItemByPolicyId(String tenantId,Long policyId){
		StringBuffer key = new StringBuffer();
		key.append("TenantId:").append(tenantId);
		key.append(".");
		key.append("PolicyId:").append(policyId);
		return key.toString();
	}
	public static String getPolicyItemPlanByPolicyId(String tenantId,Long policyId){
		StringBuffer key = new StringBuffer();
		key.append("TenantId:").append(tenantId);
		key.append(".");
		key.append("PolicyId:").append(policyId);
		return key.toString();
	}
	public static String getElementByPolicyId(String tenantId,Long policyId){
		StringBuffer key = new StringBuffer();
		key.append("TenantId:").append(tenantId);
		key.append(".");
		key.append("PolicyId:").append(policyId);
		return key.toString();
	}
	public static String getElementByElementId(String tenantId,Long elementId){
		StringBuffer key = new StringBuffer();
		key.append("TenantId:").append(tenantId);
		key.append(".");
		key.append("ElementId:").append(elementId);
		return key.toString();
	}
	public static String getPolicyItemConditionByTenantId(String tenantId){
		StringBuffer key = new StringBuffer();
		key.append("TenantId:").append(tenantId);
		return key.toString();
	}
	public static String getPolicyItemConditionByDataFormat(String tenantId,String dataFormat){
		StringBuffer key = new StringBuffer();
		key.append("TenantId:").append(tenantId);
		key.append(".");
		key.append("DataFormat:").append(dataFormat);
		return key.toString();
	}
	public static String getPolicyItemConditionByContractId(String tenantId,String dataFormat,String contractId){
		StringBuffer key = new StringBuffer();
		key.append("TenantId:").append(tenantId);
		key.append(".");
		key.append("DataFormat:").append(dataFormat);
		key.append(".");
		key.append("ContractId:").append(contractId);
		return key.toString();
	}
	public static String getSysParamByTenantId(String tenantId){
		StringBuffer key = new StringBuffer();
		key.append("TenantId:").append(tenantId);
		return key.toString();
	}
	public static String getSysParamByTypeCode(String tenantId ,String typeCode){
		StringBuffer key = new StringBuffer();
		key.append("TenantId:").append(tenantId);
		key.append(".");
		key.append("TypeCode:").append(typeCode);
		return key.toString();
	}
	public static String getSysParamByParamCode(String tenantId ,String typeCode,String paramCode){
		StringBuffer key = new StringBuffer();
		key.append("TenantId:").append(tenantId);
		key.append(".");
		key.append("TypeCode:").append(typeCode);
		key.append(".");
		key.append("ParamCode:").append(paramCode);
		return key.toString();
	}
	public static String getSysParamByColumnValue(String tenantId ,String typeCode,String paramCode,String columnValue){
		StringBuffer key = new StringBuffer();
		key.append("TenantId:").append(tenantId);
		key.append(".");
		key.append("TypeCode:").append(typeCode);
		key.append(".");
		key.append("ParamCode:").append(paramCode);
		key.append(".");
		key.append("ColumnValue:").append(columnValue);
		return key.toString();
	}
	public static String getElementAttrByPolicyId(String tenantId,Long policyId){
		StringBuffer key = new StringBuffer();
		key.append("TenantId:").append(tenantId);
		key.append(".");
		key.append("PolicyId:").append(policyId);
		return key.toString();
	}
	public static String getElementAttrByElementId(String tenantId,Long elementId){
		StringBuffer key = new StringBuffer();
		key.append("TenantId:").append(tenantId);
		key.append(".");
		key.append("ElementId:").append(elementId);
		return key.toString();
	}
	public static String getPolicyTaskCycleByPolicyId(String tenantId,Long policyId){
		StringBuffer key = new StringBuffer();
		key.append("TenantId:").append(tenantId);
		key.append(".");
		key.append("PolicyId:").append(policyId);
		return key.toString();
	}
	public static String getPolicyItemPlanInstnByPolicyId(String tenantId,Long policyId,String objectCode){
		StringBuffer key = new StringBuffer();
		key.append("TenantId:").append(tenantId);
		key.append(".");
		key.append("PolicyId:").append(policyId);
		key.append(".");
		key.append("ObjectCode:").append(objectCode);
		return key.toString();
	}
	public static String getPolicyInstnByObjectCode(String tenantId,Long policyId,String objectCode){
		StringBuffer key = new StringBuffer();
		key.append("TenantId:").append(tenantId);
		key.append(".");
		key.append("PolicyId:").append(policyId);
		key.append(".");
		key.append("ObjectCode:").append(objectCode);
		return key.toString();
	}
}

package com.x.ic.smc.service.busi.interfaces;

import com.x.base.exception.SystemException;
import com.x.base.vo.PageInfo;
import com.x.ic.smc.api.policymanage.param.PolicyCancelRequest;
import com.x.ic.smc.api.policymanage.param.PolicyCreateRequest;
import com.x.ic.smc.api.policymanage.param.PolicyDetailQueryRequest;
import com.x.ic.smc.api.policymanage.param.PolicyDetailQueryResponse;
import com.x.ic.smc.api.policymanage.param.PolicyListQueryInfo;
import com.x.ic.smc.api.policymanage.param.PolicyListQueryRequest;
import com.x.ic.smc.api.policymanage.param.PolicyModifyRequest;

public interface IPolicyManageBusiSV {

    void createPolicy(PolicyCreateRequest request) throws SystemException;

    void modifyPolicy(PolicyModifyRequest request);

    void cancelPolicy(PolicyCancelRequest request);

    PageInfo<PolicyListQueryInfo> queryPolicyList(PolicyListQueryRequest request);

    PolicyDetailQueryResponse queryPolicyDetail(PolicyDetailQueryRequest request);

}

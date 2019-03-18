package com.x.ic.msg.service.atom.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import org.wltea.expression.ExpressionEvaluator;
import org.wltea.expression.datameta.Variable;

import com.jayway.jsonpath.JsonPath;
import com.x.ic.msg.constants.SmcConstants;
import com.x.ic.msg.exception.NoSuitableException;
import com.x.ic.msg.service.atom.interfaces.IMessageCondSV;
import com.x.ic.msg.util.IKin;
import com.x.ic.msg.util.JSONUtil;
import com.x.ic.msg.vo.MessageData;
import com.x.ic.smc.sdk.cache.util.SmcCacheUtil;
import com.x.ic.smc.sdk.cache.vo.Node;
import com.x.ic.smc.sdk.cache.vo.Policy;
import com.x.ic.smc.sdk.cache.vo.PolicyItemCondition;

@Service
public class MessageCondSVImpl implements IMessageCondSV {

	private static final Logger log = LogManager.getLogger(MessageCondSVImpl.class);
	
	@Override
	public List<Policy> suitPolicy(MessageData messageData) {
		log.info(messageData.getTopicName());
		List<Policy> resultPolicy = new ArrayList<>();
		List<PolicyItemCondition> policyItemConditionList = SmcCacheUtil.getPolicyItemConditionByContractId(messageData.getTenantId(), SmcConstants.StlPolicyItemCondition.DataFormat.MQ, messageData.getTopicName());

		Map<Long, List<PolicyItemCondition>> policyMap = new HashMap<>();
		
		for(PolicyItemCondition cond : policyItemConditionList){
			if(policyMap.containsKey(cond.getPolicyId())){
				policyMap.get(cond.getPolicyId()).add(cond);
			}else{
				List<PolicyItemCondition> conds = new ArrayList<>();
				conds.add(cond);
				policyMap.put(cond.getPolicyId(), conds);
			}
		}
		List<Long> policyIds = new ArrayList<>();
		for(Long policyId : policyMap.keySet()){
			
			boolean flag = true;
			List<PolicyItemCondition> conds = policyMap.get(policyId);
			for (PolicyItemCondition policyItemCondition : conds) {
				if(!flag) continue;
				Long nodeId = policyItemCondition.getElementId();
				String matchType = policyItemCondition.getMatchType();
				String matchValue = policyItemCondition.getMatchValue();
				Node node = SmcCacheUtil.getNodeByNodeId(messageData.getTenantId(), nodeId);

				String nodePath = node.getNodePath();
				String nodeType = node.getNodeType();
				String nodeValue = JSONUtil.readPath(messageData.getDataStr(), nodePath);
				if (matchType.equals("in")) {
	                flag = IKin.in(matchValue, nodeValue);
	            } else if (matchType.equals("nin")) {
	                flag = !IKin.in(matchValue, nodeValue);
	            } else if(matchType.equals("NotNULL")){
	            	flag = nodeValue!=null && !"".equals(nodeValue);
	            }else {
	                if (matchType.equals("=")) {
	                    matchType = "==";
	                }
	                String expression = "nodeValue" + matchType + "matchValue";
	                List<Variable> variables = new ArrayList<Variable>();
	                Variable v1 = new Variable("nodeValue", IKin.getDataType(nodeType), nodeValue);
	                Variable v2 = new Variable("matchValue", IKin.getDataType(nodeType), matchValue);
	                variables.add(v1);
	                variables.add(v2);
	                Object result = ExpressionEvaluator.evaluate(expression, variables);
	                flag = Boolean.parseBoolean(result.toString());
	            }	
			}
			if(flag){
				policyIds.add(policyId);
			}
			
		}
		
		if(policyIds.size()>0){
			for(Long policyId : policyIds){
				Policy policy = SmcCacheUtil.getPolicyByPolicyId(messageData.getTenantId(), policyId);
				
				resultPolicy.add(policy);
			}
		}else{
			throw new NoSuitableException();
		}
		return resultPolicy;
	}
	
	
}

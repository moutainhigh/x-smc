package com.x.smc.bill.service.process;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.wltea.expression.ExpressionEvaluator;
import org.wltea.expression.datameta.Variable;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.x.base.exception.BusinessException;
import com.x.hbase.base.IHbaseClientFactory;
import com.x.ic.smc.sdk.cache.util.SmcCacheUtil;
import com.x.ic.smc.sdk.cache.vo.PolicyBillPlan;
import com.x.sdk.constant.ExceptCodeConstants;
import com.x.sdk.util.CollectionUtil;
import com.x.smc.bill.constants.BillConstants;
import com.x.smc.bill.constants.BillConstants.BillDetailVo;
import com.x.smc.bill.dao.mapper.bo.PolicyTaskCycle;
import com.x.smc.bill.dao.mapper.bo.StlBillData;
import com.x.smc.bill.dao.mapper.bo.StlCalDataRecord;
import com.x.smc.bill.dao.mapper.bo.StlCalDataRecordCriteria;
import com.x.smc.bill.dao.mapper.bo.StlCalDataRecordCriteria.Criteria;
import com.x.smc.bill.dao.mapper.factory.MapperFactory;
import com.x.smc.bill.util.BillSeqUtil;
import com.x.smc.bill.util.DateUtils;
import com.x.smc.bill.vo.BillPlanRuleVo;

/**
 * 账单处理类
 * @author wangluyang
 *
 */
public class BillCalThread implements Runnable{

	private static Logger logger = LoggerFactory.getLogger(BillCalThread.class);
	
	private StlCalDataRecord dataRecord = null;
	
	public BillCalThread(StlCalDataRecord dataRecord) {
		this.dataRecord = dataRecord;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		if(dataRecord!=null) {
			String tenantId = dataRecord.getTenantId();
			String policyId = dataRecord.getPolicyId();
			String tableName = dataRecord.getHbaseTableNamePrefix()+dataRecord.getBillTimeSn();
			List<PolicyBillPlan> billPlans = SmcCacheUtil.getPolicyBillPlanByPolicyId(tenantId, policyId);
			if(CollectionUtil.isEmpty(billPlans)) {
				logger.info("policyId:"+policyId+"匹配的规则为空");
			}
			if(!IHbaseClientFactory.getDefaultHbaseClient().tableExists(tableName)) {
				throw new BusinessException(ExceptCodeConstants.Special.NO_RESULT, "hbase表"+tableName+"不存在");
			}
			try {
				List<Map<String, Object>> dataList = IHbaseClientFactory.getDefaultHbaseClient().scan(tableName);
				this.buildBillInfo(dataList, billPlans);
				logger.info("bsn"+dataRecord.getBillTimeSn()+"导出账单完成");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	private void buildBillInfo(List<Map<String, Object>> dataList, List<PolicyBillPlan> billPlans) {
		if(!CollectionUtil.isEmpty(dataList)) {
			Map<String, StlBillData> billDataMap = new HashMap<>();
			Map<String, Integer> countMap = new HashMap<>();
			
			for(Map<String, Object> map:dataList) {
				Map<String, Object> dataMap = (Map<String, Object>) map.get(BillConstants.BILL_DETAIL_HBASE_FAMILY_NAME);
				String objectId = (String)dataMap.get(BillConstants.BillDetailVo.OBJECT_TYPE) + ":" + 
						(String)dataMap.get(BillConstants.BillDetailVo.OBJECT_CODE);
				Integer curCount = countMap.get(objectId);
				StlBillData billData = billDataMap.get(objectId);
				if(curCount==null) {
					billData = new StlBillData();
					curCount = 1;
					initBillDataInfo(billData, dataMap);
				}else {
					curCount += 1;
				}
				Double curCountFee = StringUtils.isBlank(billData.getFinalFee())?new Double(0.00):Double.valueOf(billData.getFinalFee());
				String fee = (String) dataMap.get(BillConstants.BillDetailVo.TOTAL_FEE);
				Double value = StringUtils.isBlank(fee)?new Double(0.00):Double.valueOf(fee);
				
				Double curFee = this.calculateFee(curCount, curCountFee, value, billPlans);
				billData.setFinalFee(String.valueOf(curFee));
				billData.setOrigFee(String.valueOf(curFee));
				billData.setTotalCount(Long.valueOf(curCount));
				billData.setCreateTime(new Timestamp(System.currentTimeMillis()));
				billDataMap.put(objectId, billData);
				countMap.put(objectId, curCount);
			}
			
			for (Map.Entry<String, StlBillData> entry : billDataMap.entrySet()) {
				MapperFactory.getStlBillDataMapper().insert(entry.getValue());
			}
			
			StlCalDataRecord stlCalDataRecord = new StlCalDataRecord();
			int cycleValue = Integer.valueOf(dataRecord.getCycleValue())+1; 
			stlCalDataRecord.setCycleValue(String.valueOf(cycleValue));
			stlCalDataRecord.setRunState(BillConstants.RunStatus.FREE);
			
			StringBuffer bsn = new StringBuffer();
			bsn.append("BSN_")
			.append(dataRecord.getTenantId().toUpperCase()).append("_")
			.append(dataRecord.getPolicyId()).append("_")
			.append(dataRecord.getCycleType().toUpperCase())
			.append(String.valueOf((Integer.valueOf(dataRecord.getCycleValue())+1)));
			stlCalDataRecord.setBillTimeSn(bsn.toString());
			
			stlCalDataRecord.setNextCalDate(DateUtils.getTimeByUnit(dataRecord.getCalDate(), 
					dataRecord.getCycleType(), Integer.valueOf(dataRecord.getCycleValue())));
			StlCalDataRecordCriteria example = new StlCalDataRecordCriteria();
			Criteria criteria = example.createCriteria();
			criteria.andRecordIdEqualTo(this.dataRecord.getRecordId());
			MapperFactory.getStlCalDataRecordMapper().updateByExampleSelective(stlCalDataRecord, example);
		}
	}

	private Double calculateFee(int curCount, Double curCountFee, Double value, List<PolicyBillPlan> billPlans) {
		Double totalFee = curCountFee + value;
		if(!CollectionUtil.isEmpty(billPlans)) {
			Collections.sort(billPlans, new Comparator<PolicyBillPlan>() {
				@Override
				public int compare(PolicyBillPlan o1, PolicyBillPlan o2) {
					return o1.getSortIndex().compareTo(o2.getSortIndex());
				}
			});
			for(PolicyBillPlan billPlan:billPlans) {
				if(StringUtils.equals("0", billPlan.getCalPhase())) {
					if(StringUtils.equals(BillConstants.PolicyBillPlan.CalElementType.COUNT, billPlan.getCalElementType())) {
						String ruleValue = billPlan.getRuleValue();
						if(!StringUtils.isBlank(ruleValue)) {
							List<BillPlanRuleVo> array = JSONArray.parseArray(ruleValue, BillPlanRuleVo.class);
							Collections.sort(array, new Comparator<BillPlanRuleVo>() {
	        					@Override
	        					public int compare(BillPlanRuleVo o1, BillPlanRuleVo o2) {
	        						return o1.getSortIndex().compareTo(o2.getSortIndex());
	        					}
	        					});
							for(BillPlanRuleVo rule:array) {
								List<Variable> variables = new ArrayList<Variable>();
		        		        		variables.add(Variable.createVariable("n", curCount));
		        		        		variables.add(Variable.createVariable("p", totalFee));
		        		        		Object result = ExpressionEvaluator.evaluate(rule.getExpression(), variables);
		        		        		totalFee = (Double) result;
							}
						}
					}
				}
			}
		}
		return totalFee;
	}
	
	private void initBillDataInfo(StlBillData billData, Map<String, Object> map) {
		
		billData.setBillId(Long.valueOf(BillSeqUtil.getBillDataBillIdSeq()));
		billData.setBillTimeSn((String)map.get(BillDetailVo.BSN));
		billData.setTenantId((String)map.get(BillDetailVo.TENANT_ID));
		billData.setBillFrom((String)map.get(BillDetailVo.BILL_FROM));
		billData.setPolicyId((String)map.get(BillDetailVo.POLICY_ID));
		
		
		JSONObject msgHeader = JSONObject.parseObject((String)map.get(BillDetailVo.MSG_HEADER));
//		JSONObject msgBody = JSONObject.parseObject((String)map.get(BillDetailVo.MSG_BODY));
		
		String policyCycleId = msgHeader.getString(BillDetailVo.POLICY_CYCLE_ID);
		PolicyTaskCycle policyTaskCycle = MapperFactory.getPolicyTaskCycleMapper().selectByPrimaryKey(policyCycleId);
		if(policyTaskCycle!=null) {
			billData.setBillStartTime(policyTaskCycle.getStartTime());
			billData.setBillEndTime(policyTaskCycle.getEndTime());
		}
		billData.setCreateTime(new Timestamp(System.currentTimeMillis()));
		billData.setCycleType(msgHeader.getString("cycleType"));
		billData.setCycleValue(msgHeader.getString("cycleValue"));
		billData.setObjectType(msgHeader.getString("objectType"));
		billData.setObjectCode(msgHeader.getString("objectCode"));
//		billData.setStlElementId(stlElementId);
//		billData.setStlElementSn(stlElementSn);
	}
	
}

package com.x.smc.preprocess.topology.core.bolt;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.x.base.exception.BusinessException;
import com.x.ic.smc.sdk.cache.util.SmcCacheUtil;
import com.x.ic.smc.sdk.cache.vo.PolicyItemPlan;
import com.x.sdk.util.CollectionUtil;
import com.x.smc.preprocess.topology.core.billdetail.BillDetailHandler;
import com.x.smc.preprocess.topology.core.bo.StlPolicyItemPlan;
import com.x.smc.preprocess.topology.core.constant.SmcConstants;
import com.x.smc.preprocess.topology.core.constant.SmcExceptCodeConstant;
import com.x.smc.preprocess.topology.core.proxy.CalculateProxy;
import com.x.smc.preprocess.topology.core.util.LoadConfUtil;
import com.x.storm.failbill.FailBillHandler;
import com.x.storm.jdbc.JdbcProxy;
import com.x.storm.util.BaseConstants;
import com.x.storm.util.HBaseProxy;

import backtype.storm.task.TopologyContext;
import backtype.storm.topology.BasicOutputCollector;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseBasicBolt;
import backtype.storm.tuple.Tuple;

public class CostCalculatingBolt extends BaseBasicBolt{
	
	private static final Logger LOG = LoggerFactory.getLogger(CostCalculatingBolt.class);

	/**
	 * 
	 */
	private static final long serialVersionUID = -3214008757998306486L;

    private CalculateProxy calculateProxy;

    @SuppressWarnings("unchecked")
    @Override
    public void prepare(@SuppressWarnings("rawtypes")
    Map stormConf, TopologyContext context) {
    		LoadConfUtil.loadRedisConf(stormConf);
        JdbcProxy.loadDefaultResource(stormConf);
        HBaseProxy.loadResource(stormConf);
        calculateProxy = new CalculateProxy(stormConf);
        FailBillHandler.startup();
        BillDetailHandler.startup();
    }

    @Override
    public void execute(Tuple input, BasicOutputCollector collector) {
    		JSONObject msgObj = null;
        double value = 0;
        String tenantId = "";
        Long policyId = null;
        String objectType = "";
        String objectCode = "";
        String bsn = "";
        try {
            String inputData = input.getString(0);
            LOG.info("算费bolt接收数据 input = " + inputData);
            msgObj = JSONObject.parseObject(inputData);
			JSONObject msgHeader = msgObj.getJSONObject(SmcConstants.Message.HEADER);
			JSONObject msgBody = msgObj.getJSONObject(SmcConstants.Message.BODY);
            LOG.info("算费bolt接收数据 data = " + msgObj);
            bsn = msgHeader.getString(BaseConstants.BATCH_SERIAL_NUMBER);
            tenantId = msgHeader.getString(SmcConstants.Message.TENANT_ID);
			policyId = Long.valueOf(msgHeader.getString(SmcConstants.Message.POLICY_ID));
			objectType = msgHeader.getString(SmcConstants.Message.OBJECT_TYPE);
			objectCode = msgHeader.getString(SmcConstants.Message.OBJECT_CODE);
            // 处理政策结算项
            List<PolicyItemPlan> stlPolicyItemPlanList = SmcCacheUtil.getPolicyItemPlanByPolicyId(tenantId, policyId);
            // 匹配政策适配对象
            if (!CollectionUtil.isEmpty(stlPolicyItemPlanList)) {
                for (PolicyItemPlan stlPolicyItemPlan : stlPolicyItemPlanList) {
                    // 计算费用
                    value = calculateProxy.caculateFees(stlPolicyItemPlan, msgHeader, msgBody);
                    String billDataId = calculateProxy.dealBill(value, policyId.toString(), tenantId, objectType, objectCode,
                    		bsn, stlPolicyItemPlan.getFeeItem(), msgObj);
                    LOG.info("算费详单id = " + billDataId);
//                    data.put("bill_id", billDataId);
                }
            }else {
	            	throw new BusinessException(SmcConstants.Special.SYSTEM_ERROR,
	            			stlPolicyItemPlanList + "未查询到算费规则");
            }
        } catch (BusinessException e) {
            LOG.error("算费bolt出现业务异常", e);
            FailBillHandler.addFailBillMsg(msgObj, SmcConstants.SIMPLE_BOLT, e.getErrorCode(),
                    e.getErrorMessage());
        } catch (Exception e) {
            LOG.error("算费bolt出现系统异常", e);
            FailBillHandler.addFailBillMsg(msgObj, SmcConstants.SIMPLE_BOLT,
                    SmcExceptCodeConstant.SYSTEM_EXCEPTION, e.getMessage());
        }
    }

    @Override
    public void declareOutputFields(OutputFieldsDeclarer declarer) {
    }
	

}

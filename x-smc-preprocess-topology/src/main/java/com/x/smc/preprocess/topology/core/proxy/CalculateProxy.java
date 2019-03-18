package com.x.smc.preprocess.topology.core.proxy;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.util.Bytes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.wltea.expression.ExpressionEvaluator;
import org.wltea.expression.datameta.Variable;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.esotericsoftware.minlog.Log;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.mysql.jdbc.Statement;
import com.x.base.exception.BusinessException;
import com.x.ic.smc.sdk.cache.util.SmcCacheUtil;
import com.x.ic.smc.sdk.cache.vo.Element;
import com.x.ic.smc.sdk.cache.vo.PolicyItemPlan;
import com.x.sdk.util.CollectionUtil;
import com.x.smc.preprocess.topology.core.billdetail.BillDetailHandler;
import com.x.smc.preprocess.topology.core.bo.BillDetailVo;
import com.x.smc.preprocess.topology.core.bo.CountExpCalValue;
import com.x.smc.preprocess.topology.core.bo.CountFixedCalValue;
import com.x.smc.preprocess.topology.core.bo.StepCalValue;
import com.x.smc.preprocess.topology.core.bo.StlBillData;
import com.x.smc.preprocess.topology.core.bo.StlBillItemData;
import com.x.smc.preprocess.topology.core.bo.StlPolicy;
import com.x.smc.preprocess.topology.core.bo.StlPolicyItem;
import com.x.smc.preprocess.topology.core.bo.StlPolicyItemCondition;
import com.x.smc.preprocess.topology.core.bo.StlPolicyItemPlan;
import com.x.smc.preprocess.topology.core.bo.SwitchCalValue;
import com.x.smc.preprocess.topology.core.constant.SmcConstants;
import com.x.smc.preprocess.topology.core.constant.SmcExceptCodeConstant;
import com.x.smc.preprocess.topology.core.util.RedisUtil;
import com.x.smc.preprocess.topology.core.util.SmcCacheConstant;
import com.x.smc.preprocess.topology.core.util.SmcSeqUtil;
import com.x.smc.preprocess.topology.core.vo.StlElement;
import com.x.storm.jdbc.JdbcProxy;
import com.x.storm.sequence.datasource.SeqDataSourceLoader;
import com.x.storm.sequence.util.SeqUtil;
import com.x.storm.util.BaseConstants;
import com.x.storm.util.HBaseProxy;

public class CalculateProxy {
    private static final Logger log = LoggerFactory.getLogger(CalculateProxy.class);

    private String STL_BILL_DETAIL_DATA_ = "stl_bill_detail_data_";

    private String exportLocal = "~/export";

    private int export_max = 50000;

    /**
     * 默认列族名
     */
    public static final String COLUMN_DEF = "col_def";

    public CalculateProxy(Map<String, String> stormConf) {
        String localpath = stormConf.get("smc.calculate.export.local.temp");
        if (StringUtils.isNotBlank(localpath)) {
            this.exportLocal = localpath;
        }
        String lineMax = stormConf.get("smc.calculate.export.csv.line.max");
        if (StringUtils.isNotBlank(lineMax)) {
            export_max = Integer.parseInt(lineMax);
        }
        initSeq(stormConf.get(BaseConstants.JDBC_DEFAULT));
    }

    private void initSeq(String jsonJdbcParam) {
        JsonParser jsonParser = new JsonParser();
        JsonObject jsonObject = (JsonObject) jsonParser.parse(jsonJdbcParam);
        Map<String, String> config = new HashMap<String, String>();
        for (Entry<String, JsonElement> entry : jsonObject.entrySet()) {
            config.put(entry.getKey(), entry.getValue().getAsString());
        }
        SeqDataSourceLoader.initDefault(config);
    }

    /**
     * 根据对象类型获取该对象下有效政策
     * 
     * @param objectId
     * @param tenantId
     * @return
     */
    public List<StlPolicy> getPolicyList(String objectId, String tenantId) throws Exception {
//        ICacheClient cacheClient = MCSClientFactory
//                .getCacheClient(SmcCacheConstant.NameSpace.POLICY_CACHE);
        String policyAll = RedisUtil.getCacheClient().hget(SmcCacheConstant.NameSpace.POLICY_CACHE,
                SmcCacheConstant.POLICY_ALL);
        List<StlPolicy> stlPolicyList = new ArrayList<StlPolicy>();
        List<StlPolicy> policyList = JSON.parseArray(policyAll, StlPolicy.class);
        for (int i = 0; i < policyList.size(); i++) {
            StlPolicy stlPolicy = (StlPolicy) policyList.get(i);
            if (stlPolicy.getStlObjectId().equals(objectId)
                    && stlPolicy.getTenantId().equals(tenantId)) {
                stlPolicyList.add(stlPolicy);
            }
        }
        return stlPolicyList;
    }

    /**
     * 
     * @param policyId
     * @param tenantId
     * @return
     */
    public List<StlPolicyItem> getStlPolicyItemLists(Long policyId, String tenantId) {
//        ICacheClient cacheClient = MCSClientFactory
//                .getCacheClient(SmcCacheConstant.NameSpace.POLICY_CACHE);
        String policyItemAll = RedisUtil.getCacheClient().hget(SmcCacheConstant.NameSpace.POLICY_CACHE,
                SmcCacheConstant.POLICY_ITEM);
        List<StlPolicyItem> stlPolicyItemList = new ArrayList<StlPolicyItem>();
        List<StlPolicyItem> policyList = JSON.parseArray(policyItemAll, StlPolicyItem.class);
        for (StlPolicyItem stlPolicyItem : policyList) {
            if (stlPolicyItem.getPolicyId().longValue() == policyId.longValue()
                    && stlPolicyItem.getTenantId().equals(tenantId)) {
                stlPolicyItemList.add(stlPolicyItem);
            }
        }
        return stlPolicyItemList;
    }

    /**
     * 获取政策适配对象
     * 
     * @param policyId
     * @param tenantId
     * @return
     */
    public List<StlPolicyItemCondition> getPolicyItemList(Long itemId, String tenantId)
            throws Exception {
//        ICacheClient cacheClient = MCSClientFactory
//                .getCacheClient(SmcCacheConstant.NameSpace.POLICY_CACHE);
        String policyItemAll = RedisUtil.getCacheClient().hget(SmcCacheConstant.NameSpace.POLICY_CACHE,
                SmcCacheConstant.POLICY_ITEM_CONDITION);
        List<StlPolicyItemCondition> stlPolicyItemConditionList = new ArrayList<StlPolicyItemCondition>();
        List<StlPolicyItemCondition> policyList = JSON.parseArray(policyItemAll,
                StlPolicyItemCondition.class);
        for (StlPolicyItemCondition stlPolicyItemCondition : policyList) {
            if (stlPolicyItemCondition.getItemId().longValue() == itemId.longValue()
                    && stlPolicyItemCondition.getTenantId().equals(tenantId)) {
                stlPolicyItemConditionList.add(stlPolicyItemCondition);
            }
        }
        return stlPolicyItemConditionList;
    }

//    /**
//     * 是否匹配规则
//     * 
//     * @param stream
//     * @param paramList
//     * @param policyItemList
//     * @return
//     */
//    public boolean matchPolicy(Map<String, String> data, List<StlPolicyItemCondition> policyItemList) {
//        boolean flag = false;
////        ICacheClient elementcacheClient = MCSClientFactory
////                .getCacheClient(SmcCacheConstant.NameSpace.ELEMENT_CACHE);
//        for (StlPolicyItemCondition stlPolicyItemCondition : policyItemList) {
//            StringBuilder elementStr = new StringBuilder();
//            elementStr.append(stlPolicyItemCondition.getTenantId());
//            elementStr.append(".");
//            elementStr.append(String.valueOf(stlPolicyItemCondition.getElementId()));
//            String elementJson = RedisUtil.getCacheClient().hget(SmcCacheConstant.NameSpace.ELEMENT_CACHE,
//                    elementStr.toString());
//            if (StringUtils.isBlank(elementJson)) {
//                throw new BusinessException(SmcExceptCodeConstant.BUSINESS_EXCEPTION, "元素信息不存在[租户:"
//                        + stlPolicyItemCondition.getTenantId() + ", 元素ID:"
//                        + stlPolicyItemCondition.getElementId() + "]");
//            }
//            StlElement stlElement = JSON.parseObject(elementJson, StlElement.class);
//            String elementCode = stlElement.getElementCode();
//            String compare = "";
//            if (stlElement.getAttrType().equalsIgnoreCase(SmcConstants.STL_ELEMENT_ATTR_TYPE_STAT)) {
//                if (stlElement.getStatisticsType().equalsIgnoreCase(
//                        SmcConstants.STL_ELEMENT_STAT_TYPE_C_CNT)) {
//                    int len = StringUtils.defaultString(data.get(elementCode)).length();
//                    compare = String.valueOf(len);
//                } else {
//                    System.out.println("内存中目前没有统计数据，敬请期待。。。");
//                    flag = true;
//                    continue;
//                }
//            } else {
//                compare = data.get(elementCode);
//            }
//
//            String matchType = stlPolicyItemCondition.getMatchType();
//            String matchValue = stlPolicyItemCondition.getMatchValue();
//
//            if (matchType.equals("in")) {
//                flag = IKin.in(matchValue, compare);
//            } else if (matchType.equals("nin")) {
//                flag = !IKin.in(matchValue, compare);
//            } else {
//                if (matchType.equals("=")) {
//                    matchType = "==";
//                }
//                String expression = "a" + matchType + "b";
//                List<Variable> variables = new ArrayList<Variable>();
//                variables.add(Variable.createVariable("a", compare));
//                variables.add(Variable.createVariable("b", matchValue));
//                Object result = ExpressionEvaluator.evaluate(expression, variables);
//                flag = Boolean.parseBoolean(result.toString());
//            }
//
//            // 只要存在条件不满足,就退出
//            if (!flag) {
//                break;
//            }
//        }
//
//        // System.out.println("flag====="+flag);
//        return flag;
//    }

    public double caculateFees(PolicyItemPlan stlPolicyItemPlan, JSONObject msgHeader, JSONObject msgBody) {
        double value = docaculate(stlPolicyItemPlan, msgHeader, msgBody);
        msgBody.put("item_fee", String.valueOf(value));
        msgBody.put("fee_item_id", stlPolicyItemPlan.getFeeItem());
        return value;
    }

    /**
     * 算费
     * 
     * @param planType
     * @param calType
     * @return
     */
    public double docaculate(PolicyItemPlan policyDetailQueryPlanInfo, JSONObject msgHeader, JSONObject msgBody) {
        double value = 0;
//        ICacheClient elementcacheClient = MCSClientFactory
//                .getCacheClient(SmcCacheConstant.NameSpace.ELEMENT_CACHE);
        String planType = policyDetailQueryPlanInfo.getPlanType();
        String calType = policyDetailQueryPlanInfo.getCalType();// 算费方式
        Long elementId = policyDetailQueryPlanInfo.getElementId();

        StringBuilder elementStr = new StringBuilder();
        elementStr.append(policyDetailQueryPlanInfo.getTenantId());
        elementStr.append(".");
        elementStr.append(elementId);

        Element stlElement = SmcCacheUtil.getElementByElementId(policyDetailQueryPlanInfo.getTenantId(), elementId);
        if (stlElement==null) {
            throw new BusinessException(SmcExceptCodeConstant.BUSINESS_EXCEPTION, "元素信息不存在[租户:"
                    + policyDetailQueryPlanInfo.getTenantId() + ", 元素ID:" + elementId + "]");
        }
        String elementCode = stlElement.getElementCode();
        // long sortId = stlElement.getSortId();
        // int num = (int) sortId;
        String compare = "";
        if (stlElement.getAttrType().equalsIgnoreCase(SmcConstants.STL_ELEMENT_ATTR_TYPE_STAT)) {
            if (stlElement.getStatisticsType().equalsIgnoreCase(
                    SmcConstants.STL_ELEMENT_STAT_TYPE_C_CNT)) {
                int len = StringUtils.defaultString(msgBody.getString(elementCode)).length();
                compare = String.valueOf(len);
            } else {
                System.out.println("内存中目前没有统计数据，敬请期待。。。");
                return value;
            }
        } else {
            compare = msgBody.getString(elementCode);
        }
        // compare =(String)data.get("content");
        if (SmcConstants.PlanType.NORMAL.equals(planType)) {// 标准型
            // 可能出现错误，calValue是否是JSON，如果是需要解析转换后使用
            double calValue = Double.parseDouble(policyDetailQueryPlanInfo.getCalValue());
            if (calType.equals("ratio"))// 按比例
            {
                value = Double.parseDouble(compare) * calValue;
            } else if (calType.equals("fixed"))// 固定值
            {
                value = calValue;
            } else if (calType.equals("price"))// 单价
            {
                value = Double.parseDouble(compare) * calValue;
            }

        } else if (SmcConstants.PlanType.STEP.equals(planType)) {// 阶梯
            List<StepCalValue> stepCalValues = JSON.parseArray(
                    policyDetailQueryPlanInfo.getCalValue(), StepCalValue.class);
            String calValue = "";
            for (StepCalValue stepCalValue : stepCalValues) {
                double start = Double.parseDouble(stepCalValue.getStartValue());
                double end = Double.parseDouble(stepCalValue.getEndValue());
                if (end < value && start < value) {
                    calValue = stepCalValue.getCalValue();
                    value += Double.parseDouble(calValue) * (end - start);
                }
                if (value > start && value < end) {
                    calValue = stepCalValue.getCalValue();
                    value += Double.parseDouble(calValue) * (Double.parseDouble(compare) - start);
                }
                if (calType.equals("ratio")) {
                    value = Double.parseDouble(compare) * value;
                } else if (calType.equals("price")) {
                    value = Double.parseDouble(compare) * Double.parseDouble(calValue) * value;
                }

            }
        } else if (SmcConstants.PlanType.SWITCH.equals(planType)) {// 分档

            List<SwitchCalValue> stepCalValues = JSON.parseArray(
                    policyDetailQueryPlanInfo.getCalValue(), SwitchCalValue.class);
            String calValue = "0";
            double compareValue = Double.parseDouble(compare);
            for (SwitchCalValue stepCalValue : stepCalValues) {
                double start = Double.parseDouble(stepCalValue.getStart_value());
                double end = Double.parseDouble(stepCalValue.getEnd_value());
                if (compareValue > start && compareValue < end) {
                    calValue = stepCalValue.getValue();
                }
            }
            if (calType.equals("ratio")) {
                value = compareValue * Double.parseDouble(calValue);
            } else if (calType.equals("fixed")) {
                value = Double.parseDouble(calValue);
            } else if (calType.equals("price")) {
                value = compareValue * Double.parseDouble(calValue);
            }
        }else if(SmcConstants.PlanType.COUNT.equals(planType)) {// 统计
        		String objectType = msgHeader.getString(SmcConstants.Message.OBJECT_TYPE);
        		String objectValue = msgHeader.getString(SmcConstants.Message.OBJECT_CODE);
        		String bsn = msgHeader.getString("bsn");
        		String key = bsn+"_"+objectType+":"+objectValue;
        		Long curcount = RedisUtil.getCacheClient().hincrBy(SmcConstants.STATS_TIMES_KEY, key, 1);
        		if(SmcConstants.CalType.FIXED.equals(calType)) {
        			List<CountFixedCalValue> calValues = JSONArray.parseArray(policyDetailQueryPlanInfo.getCalValue(), CountFixedCalValue.class);
        			if(!CollectionUtil.isEmpty(calValues)) {
        				Collections.sort(calValues, new Comparator<CountFixedCalValue>() {
        					@Override
        					public int compare(CountFixedCalValue o1, CountFixedCalValue o2) {
        						return o1.getSortIndex().compareTo(o2.getSortIndex());
        					}
        				});
        			}
        			for(CountFixedCalValue calValue:calValues) {
        				String expression = "x>=a && x<=b";
        				List<Variable> variables = new ArrayList<Variable>();
        		        variables.add(Variable.createVariable("a", Long.valueOf(calValue.getStartNum())));
        		        variables.add(Variable.createVariable("b", Long.valueOf(calValue.getEndNum())));
        		        variables.add(Variable.createVariable("x", curcount));
        		        Object result = ExpressionEvaluator.evaluate(expression, variables);
        		        if(Boolean.parseBoolean(result.toString())) {
        		        		List<Variable> valVariables = new ArrayList<Variable>();
        		        		valVariables.add(Variable.createVariable("x", Double.valueOf(compare)));
        		        		value = Double.parseDouble(ExpressionEvaluator.evaluate(calValue.getCalValue(), valVariables).toString());
        		        		break;
        		        }
        			}
        			
        		}else if(SmcConstants.CalType.EXP.equals(calType)) {
        			CountExpCalValue expCalValue = JSONObject.parseObject(policyDetailQueryPlanInfo.getCalValue(), CountExpCalValue.class);
        			int sectionNum = -1;
        			if(SmcConstants.CalType.FIXED.equals(expCalValue.getSectionType())) {
        				List<JSONArray> sectionArray = JSONArray.parseArray(expCalValue.getSectionType(), JSONArray.class);
        				for(int i=0; i<sectionArray.size(); i++) {
        					JSONArray array = sectionArray.get(i);
        					String expression = "x>=a && x<=b";
            				List<Variable> variables = new ArrayList<Variable>();
            		        variables.add(Variable.createVariable("a", array.getLongValue(0)));
            		        variables.add(Variable.createVariable("b", array.getLongValue(1)));
            		        variables.add(Variable.createVariable("x", curcount));
            		        Object result = ExpressionEvaluator.evaluate(expression, variables);
            		        if(Boolean.parseBoolean(result.toString())) {
            		        		sectionNum = i;
            		        		break;
            		        }
        				}
        			}else if(SmcConstants.CalType.EXP.equals(expCalValue.getSectionType())) {
        				List<Variable> variables = new ArrayList<Variable>();
        				variables.add(Variable.createVariable("n", curcount));
        				Object result = ExpressionEvaluator.evaluate(expCalValue.getSectionValue(), variables);
        				sectionNum = Integer.valueOf(result.toString());
        			}
        			
        			if(sectionNum!=-1) {
        				if(SmcConstants.CalType.FIXED.equals(expCalValue.getCalType())) {
        					JSONArray array = JSONArray.parseArray(expCalValue.getCalValue());
        					String exp = array.getString(sectionNum);
        					List<Variable> variables = new ArrayList<Variable>();
            				variables.add(Variable.createVariable("v", Double.valueOf(compare)));
            				value = Double.parseDouble(ExpressionEvaluator.evaluate(exp, variables).toString());
        				}else if(SmcConstants.CalType.EXP.equals(expCalValue.getCalType())){
        					List<Variable> variables = new ArrayList<Variable>();
            				variables.add(Variable.createVariable("v", Double.valueOf(compare)));
            				value = Double.parseDouble(ExpressionEvaluator.evaluate(expCalValue.getCalValue(), variables).toString());
        				}
        			}
        		}
        }

        return value;
    }

    public String dealBill(double value, String policyId, String tenantId, String objectType, String objectCode,
    		String bsn, String feeItemId, JSONObject msgObj) throws Exception {
    	
        BillDetailVo detailVo = new BillDetailVo();
//        		detailVo.setPolicyCode(policyCode);
    		detailVo.setTenantId(tenantId);
    		detailVo.setPolicyId(policyId);
    		detailVo.setBillTimeSn(bsn);
    		detailVo.setOrigFee(String.valueOf(value));
        // stlBillData.setFeeItemId(feeItemId);
        // stlBillData.setBillId(Long.parseLong(SmcSeqUtil.getRandom()));
    		detailVo.setBillId(SeqUtil.getNewId(SmcConstants.STL_BILL_DATA$BILL_ID$SEQ));
    		detailVo.setBillFrom("sys");
    		detailVo.setFeeItemId(feeItemId);
//    		detailVo.setItemType(itemType);
    		detailVo.setTotalFee(String.valueOf(value));
    		detailVo.setObjectType(objectType);
    		detailVo.setObjectCode(objectCode);
    		detailVo.setMsgHeader(msgObj.getString(SmcConstants.Message.HEADER));
    		detailVo.setMsgBody(msgObj.getString(SmcConstants.Message.BODY));
    		BillDetailHandler.addBillDetailMsg(detailVo);
        return detailVo.getBillId().toString();
    }

    boolean contains(List<StlBillItemData> itemDatas, String feeItemId, double value) {
        for (StlBillItemData stlBillItemData : itemDatas) {
            if (feeItemId.equals(stlBillItemData.getFeeItemId())) {
                return true;
            }
        }
        return false;
    }

    private String assembleCacheKey(String... params) {
        StringBuilder key = new StringBuilder();
        for (String param : params) {
            key.append(param);
        }
        return key.toString();
    }

    public void outputDetailBill(String yyyymm, String row, Map<String, String> data)
            throws IOException {
        TableName tableName = TableName.valueOf(STL_BILL_DETAIL_DATA_ + yyyymm);
        Table table = HBaseProxy.getConnection().getTable(tableName);
        Put put = new Put(Bytes.toBytes(row));
        byte[] cf = Bytes.toBytes(COLUMN_DEF);
        
		if (!HBaseProxy.getConnection().getAdmin().isTableAvailable(TableName.valueOf(tableName.toString()))) {
	        HTableDescriptor tableDesc = new HTableDescriptor(TableName.valueOf(tableName.toString()));
        	tableDesc.addFamily(new HColumnDescriptor(cf));
	        HBaseProxy.getConnection().getAdmin().createTable(tableDesc);
		}
		for (Entry<String, String> entry : data.entrySet()) {
            put.addColumn(cf, Bytes.toBytes(entry.getKey()), Bytes.toBytes(entry.getValue()));
        }
		
        table.put(put);
        table.close();
    }

    public long getBillDataId(String policyCode) {
        long billDataId = 0;
//        ICacheClient billClient = MCSClientFactory
//                .getCacheClient(SmcCacheConstant.NameSpace.BILL_CACHE);
        String billAll = RedisUtil.getCacheClient().get("bill");
        List<StlBillData> dataList = JSON.parseArray(billAll, StlBillData.class);
        for (StlBillData stlBillData : dataList) {
            if (stlBillData.getPolicyCode().equals(policyCode)) {
                billDataId = stlBillData.getBillId();
            }
        }
        return billDataId;
    }

    public void insertBillData(String period, String bsn, String original) throws Exception {
//        ICacheClient billClient = MCSClientFactory
//                .getCacheClient(SmcCacheConstant.NameSpace.BILL_CACHE);
        Map<String, String> billMaps = RedisUtil.getCacheClient().hgetAll(assembleCacheKey(
                SmcCacheConstant.Cache.BILL_PREFIX, bsn));
        int opt_times = 0;
        StlBillData stlBillData = null;
        // for(String bill:billMaps.values()){
        for (Entry<String, String> entry : billMaps.entrySet()) {
            stlBillData = JSON.parseObject(entry.getValue(), StlBillData.class);
            if (insert(stlBillData, period, entry.getKey(), bsn)) {
                opt_times++;
            }
        }
        if (billMaps.size() == opt_times) {
            // 导出文件
//            exportFileAndFtp(bsn, original);

            RedisUtil.getCacheClient().del(SmcCacheConstant.Cache.BILL_PREFIX + bsn);
            RedisUtil.getCacheClient().del(SmcCacheConstant.Cache.BILL_ITEM_PREFIX + bsn);
            RedisUtil.getCacheClient().del(SmcCacheConstant.Cache.BILL_DATA_PREFIX + bsn);
            RedisUtil.getCacheClient().del(SmcCacheConstant.Cache.BILL_ITEM_DATA_PREFIX + bsn);
            RedisUtil.getCacheClient().hdel(SmcCacheConstant.Cache.lockKey, bsn);
            RedisUtil.getCacheClient().hdel(SmcCacheConstant.Cache.COUNTER, bsn);
        }
    }
    
    
//    public List<CalDataRecordVo> getCalDataRecords(Timestamp nextCaltime)throws Exception{
//    		Connection conn = null;
//    		PreparedStatement prest = null;
//    		List<CalDataRecordVo> dataRecordVos = new ArrayList<>();
//    		try {
//    	            conn = JdbcProxy.getConnection(BaseConstants.JDBC_DEFAULT);
//    	            conn.setAutoCommit(false);
//    	            
//    	            StringBuffer sql = new StringBuffer("select record_id, tenant_id, data_type, object_id, bill_time_sn, batch_no, cycle_type, " + 
//    	            		"cycle_value, hbase_table_name, current_count, update_time, cal_date, next_cal_date from stl_cal_data_record");
//    	            sql.append(" where NEXT_CAL_DATE >= ?");
//    	            prest = (PreparedStatement) conn.prepareCall(sql.toString());
//    	            prest.setTimestamp(1, nextCaltime);
//    	            ResultSet resultSet = prest.executeQuery();
//    	            dataRecordVos = DbUtil.populate(resultSet, CalDataRecordVo.class);
//    		} catch (Exception e) {
//    	            Log.error("error", e);
//    	            if (conn != null) {
//    	                try {
//    	                    conn.rollback();
//    	                } catch (SQLException e1) {
//    	                    Log.error("error", e);
//    	                }
//    	            }
//    	            throw e;
//    	    }finally {
//				if(prest!=null) {
//					prest.close();
//				}
//		}
//		return dataRecordVos;
//    	 	
//    }

    public boolean insert(StlBillData stlBillData, String period, String policyId, String bsn) throws Exception {
        Connection conn = null;
        Statement statement = null;
        boolean isSucc = false;
        try {
            conn = JdbcProxy.getConnection(BaseConstants.JDBC_DEFAULT);
            conn.setAutoCommit(false);
            String createTime = DateFormatUtils.format(new Date(), "yyyyMMddHHmmss");
            statement = (Statement) conn.createStatement();
            String origFee = RedisUtil.getCacheClient().hget(
                    assembleCacheKey(SmcCacheConstant.Cache.BILL_DATA_PREFIX, bsn), policyId);
            // System.out.println("origFee=="+origFee);
            insertBillData(stlBillData, period, createTime, statement, origFee);
            // List<StlBillItemData> itemDatas = stlBillData.getItemDatas();
            List<StlBillItemData> itemDatas = getItemDataByPolicyId(policyId, bsn);
            String billId = stlBillData.getBillId().toString();
            String totalFee = "0";
            for (StlBillItemData itemData : itemDatas) {
                totalFee = RedisUtil.getCacheClient().hget(
                        assembleCacheKey(SmcCacheConstant.Cache.BILL_ITEM_DATA_PREFIX, bsn),
                        assembleCacheKey(policyId, ":", itemData.getFeeItemId()));
                // System.out.println("totalFee---"+totalFee);
                insertBillItemData(itemData, billId, period, createTime, statement, totalFee);
            }
            conn.commit();
            isSucc = true;
        } catch (Exception e) {
            Log.error("error", e);
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException e1) {
                    Log.error("error", e);
                }
            }
            throw e;
        }finally {
			if(statement!=null) {
				statement.close();
			}
		}
        return isSucc;
    }

    private List<StlBillItemData> getItemDataByPolicyId(String policyId, String bsn) {
        List<StlBillItemData> itemDatas = new ArrayList<StlBillItemData>();
        Map<String, String> itemDataMap = RedisUtil.getCacheClient().hgetAll(assembleCacheKey(
                SmcCacheConstant.Cache.BILL_ITEM_PREFIX, bsn));
        String[] splits = null;
        StlBillItemData stlBillItemData = null;
        for (Entry<String, String> entry : itemDataMap.entrySet()) {
            splits = StringUtils.splitPreserveAllTokens(entry.getKey(), ":");
            if (policyId.equals(splits[0])) {
                stlBillItemData = JSON.parseObject(entry.getValue(), StlBillItemData.class);
                itemDatas.add(stlBillItemData);
            }
        }
        return itemDatas;
    }

    private int insertBillItemData(StlBillItemData itemData, String billId, String period,
            String createTime, Statement statement, String totalFee) throws SQLException {
        String billItemId = ObjectUtils.toString(
                SeqUtil.getNewId(SmcConstants.STL_BILL_ITEM_DATA$BILL_ITEM_ID$SEQ),
                SmcSeqUtil.getRandom());
        StringBuilder strSql = new StringBuilder("insert into ");
        strSql.append(SmcConstants.STL_BILL_ITEM_DATA_TABLE_PREFIX).append(period);
        strSql.append(" (bill_item_id,bill_id,tenant_id,item_type,fee_item_id,total_fee,create_time)");
        strSql.append(" values(");
        strSql.append(billItemId).append(",");
        strSql.append(billId).append(",'");
        strSql.append(itemData.getTenantId()).append("','");
        strSql.append(itemData.getItemType()).append("','");
        strSql.append(itemData.getFeeItemId()).append("',");
        strSql.append(totalFee).append(",");
        strSql.append(createTime).append(")");
        System.out.println("itemSql=" + strSql);
        return statement.executeUpdate(strSql.toString());
    }

    private int insertBillData(StlBillData stlBillData, String period, String createTime,
            Statement statement, String origFee) throws SQLException {

        StringBuilder strSql = new StringBuilder("insert into ");
        strSql.append(SmcConstants.STL_BILL_DATA_TABLE_PREFIX).append(period);
        strSql.append(" (bill_id,bill_from,batch_no,tenant_id,policy_code,stl_object_id,");
        strSql.append("stl_element_id,stl_element_sn,bill_style_sn,bill_time_sn,");
        strSql.append("bill_start_time,bill_end_time,orig_fee,create_time)");
        strSql.append(" values(");
        strSql.append(stlBillData.getBillId()).append(",'");
        strSql.append(stlBillData.getBillFrom()).append("','");
        strSql.append(stlBillData.getBatchNo()).append("','");
        strSql.append(stlBillData.getTenantId()).append("','");
        strSql.append(stlBillData.getPolicyCode()).append("','");
        strSql.append(stlBillData.getStlObjectId()).append("',");
        strSql.append(stlBillData.getStlElementId()).append(",'");
        strSql.append(stlBillData.getStlElementSn()).append("','");
        strSql.append(stlBillData.getBillStyleSn()).append("',");
        strSql.append(stlBillData.getBillTimeSn()).append(",'");
        strSql.append(stlBillData.getBillStartTime()).append("','");
        strSql.append(stlBillData.getBillEndTime()).append("',");
        strSql.append(origFee).append(",");
        strSql.append(createTime).append(")");

        System.out.println("sql=" + strSql);
        return statement.executeUpdate(strSql.toString());
    }

//    public void exportFileAndFtp(String bsn, String original) throws Exception {
////        ICacheClient billClient = MCSClientFactory
////                .getCacheClient(SmcCacheConstant.NameSpace.BILL_CACHE);
//        Map<String, String> billAll = RedisUtil.getCacheClient().hgetAll(SmcCacheConstant.Cache.BILL_PREFIX + bsn);
//        StlBillData stlBillData = null;
//        // for(String bill:billAll.values()){
//        String policyId = "", exportPath = "";
//        String tenantId = "";
//        String batchNo = "";
//        for (Entry<String, String> entry : billAll.entrySet()) {
//            policyId = entry.getKey();
//            stlBillData = JSON.parseObject(entry.getValue(), StlBillData.class);
//            tenantId = stlBillData.getTenantId();
//            batchNo = stlBillData.getBatchNo();
//            exportPath = exportExcel(stlBillData, policyId, bsn);
//            exportCsv(stlBillData, policyId, exportPath, original);
//            // 不用政策Id导出，用账单ID作为导出id
//        }
//        String zipFilePath = createZipFile(batchNo);
//        System.out.println("压缩文件生成本地路径--->>>" + zipFilePath);
//        if (uploadFile(tenantId, zipFilePath)) {
//            updateImportLog(zipFilePath, tenantId, batchNo);
//
//            System.out.println("正在清理打包文件...");
//            String rmPath = StringUtils.substringBeforeLast(zipFilePath, ".zip");
//            FileUtils.deleteQuietly(FileUtils.getFile(rmPath));
//            FileUtils.getFile(zipFilePath).delete();
//        }
//
//    }

//    private boolean updateImportLog(String zipFile, String tenantId, String batchNo) {
//        String fileName = FileUtils.getFile(zipFile).getName();
//        StlSysParam stlSysParam = getSysParamCache(new String[] { tenantId, TypeCode.SFTP_CONF,
//                ParamCode.UPLOAD_URL_DIFF_FILE });
//        String url = stlSysParam != null ? stlSysParam.getColumnValue() : "";
//        StringBuilder strSql = new StringBuilder("update stl_import_log s ");
//        strSql.append("set s.RST_FILE_NAME = ?,s.RST_FILE_URL = ?,");
//        strSql.append("s.STATE = '4',s.STATE_DESC='数据处理完成',");
//        strSql.append("s.STATE_CHG_TIME = ? ");
//        strSql.append("where s.BATCH_NO = ? and s.TENANT_ID=?");
//
//        Object[] params = new Object[5];
//        params[0] = fileName;
//        params[1] = url;
//        params[2] = DateFormatUtils.format(new Date(), "yyyyMMddHHmmss");
//        params[3] = batchNo;
//        params[4] = tenantId;
//        Connection conn = null;
//        boolean isSucc = false;
//        try {
//            conn = JdbcProxy.getConnection(BaseConstants.JDBC_DEFAULT);
//            conn.setAutoCommit(false);
//            JdbcTemplate.update(strSql.toString(), conn, params);
//            isSucc = true;
//        } catch (Exception e) {
//            log.error(e.getMessage());
//        }
//        return isSucc;
//    }
//
//    private boolean uploadFile(String tenantId, String zipFilePath)
//            throws Exception {
//        boolean isSucc = false;
//        Map<String, String> sftpCfg = getSftpConfig(tenantId);
//        if (!verifySftpConfigParam(sftpCfg)) {
//            throw new BusinessException(SmcExceptCodeConstant.BUSINESS_EXCEPTION, "读取上传SFTP参数失败:"
//                    + sftpCfg.toString());
//        }
//        System.out.println("sftp config=" + sftpCfg.toString());
//        SftpUtil sftpUtil = new SftpUtil(sftpCfg.get("user"), sftpCfg.get("pwd"),
//                sftpCfg.get("host"), "");
//        sftpUtil.connect();
//        sftpUtil.uploadFile(zipFilePath, sftpCfg.get("remote"));
//        sftpUtil.disconnect();
//        log.debug("上传数据完成!");
//        isSucc = true;
//        return isSucc;
//    }

//    private boolean verifySftpConfigParam(Map<String, String> sftpCfg) {
//        if (StringUtils.isNotBlank(sftpCfg.get("host"))
//                && StringUtils.isNotBlank(sftpCfg.get("remote"))
//                && StringUtils.isNotBlank(sftpCfg.get("user"))
//                && StringUtils.isNotBlank(sftpCfg.get("pwd"))) {
//            return true;
//        } else {
//            return false;
//        }
//    }
//
//    private Map<String, String> getSftpConfig(String tenantId) {
//        Map<String, String> config = Maps.newHashMap();
//        StlSysParam stlSysParam = getSysParamCache(new String[] { tenantId, TypeCode.SFTP_CONF,
//                ParamCode.UPLOAD_URL_DIFF_FILE });
//        String url = stlSysParam != null ? stlSysParam.getColumnValue() : "";
//        String[] split = url.split(":");
//        config.put("host", split[0]);
//        config.put("remote", split[1]);
//        stlSysParam = getSysParamCache(new String[] { tenantId, TypeCode.SFTP_CONF,
//                ParamCode.USER_NAME });
//        String user = stlSysParam != null ? stlSysParam.getColumnValue() : "";
//        config.put("user", user);
//        stlSysParam = getSysParamCache(new String[] { tenantId, TypeCode.SFTP_CONF, ParamCode.PWD });
//        String pwd = stlSysParam != null ? stlSysParam.getColumnValue() : "";
//        config.put("pwd", pwd);
//        return config;
//    }

//    private StlSysParam getSysParamCache(String[] params) {
////        ICacheClient client = SmcCacheFactory.getSysParamCacheClient();
//        String sysParamKey = Joiner.on(".").join(params);
//        String data = RedisUtil.getCacheClient().hget(SmcCacheConstant.NameSpace.SYS_PARAM_CACHE, sysParamKey);
//        if (StringUtils.isBlank(data)) {
//            return null;
//        }
//        return JSON.parseArray(data, StlSysParam.class).get(0);
//    }
//
//    private String createZipFile(String bsn) throws IOException {
//        String zipFilePath = Joiner.on(File.separator).join(exportLocal, bsn);
//        String zipFileName = zipFilePath.concat(".zip");
//        FileOutputStream outputStream;
//        ZipOutputStream out = null;
//        outputStream = new FileOutputStream(zipFileName);
//        out = new ZipOutputStream(new BufferedOutputStream(outputStream));
//        createCompressedFile(out, FileUtils.getFile(zipFilePath), "");
//        IOUtils.closeQuietly(out);
//        return zipFileName;
//    }

//    public String exportCsv(StlBillData stlBillData, String policyId, String exportPath,
//            String original) throws IOException {
//        String period = stlBillData.getBillTimeSn();
//        TableName tableName = TableName.valueOf(STL_BILL_DETAIL_DATA_ + period);
//        Table table = null;
//        ResultScanner scanner = null;
//        String rowKeyPrefix = Joiner.on(BaseConstants.COMMON_JOINER).join(
//                stlBillData.getTenantId(), stlBillData.getBillId().toString(), period);
//        table = HBaseProxy.getConnection().getTable(tableName);
//        Scan scan = new Scan();
//        scan.setCaching(300);
//        scan.setFilter(new RowFilter(CompareFilter.CompareOp.EQUAL, new SubstringComparator(
//                rowKeyPrefix)));
//        scanner = table.getScanner(scan);
//        outputExcelFile(stlBillData, exportPath, scanner, original);
//        if (scanner != null) {
//            scanner.close();
//        }
//        if (table != null) {
//            try {
//                table.close();
//            } catch (IOException e) {
//            }
//        }
//        return "";
//    }

//    private void outputExcelFile(StlBillData stlBillData, String exportPath, ResultScanner scanner,
//            String original) throws IOException {
//        int count = 0;
//        int fileCount = 1;
//        int countAll = 0;
//        List<NavigableMap<byte[], byte[]>> resultList = getMap(scanner);
//        String qualifierName = "", colunmValue = "";
//        List<String> columnNames = new ArrayList<String>();
//        XSSFSheet sheet = null;
//        Workbook wb = null;
//        Boolean flag = false;
//
//        int num = resultList.size();
//        System.out.println("从hbase中的详单表取到的数据的数量为：" + num);
//        for (NavigableMap<byte[], byte[]> map : resultList) {
//            if ((++countAll) == num) {
//                flag = true;
//            }
//            List<String> columnValues = new ArrayList<String>();
//
//            for (Map.Entry<byte[], byte[]> entry : map.entrySet()) {
//                // System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
//                // }
//                // for (KeyValue kv : res.raw()) {
//                qualifierName = new String(entry.getKey());
//                if (count == 0) {
//                    columnNames.add(qualifierName);
//                }
//                colunmValue = new String(entry.getValue());
//                columnValues.add(!qualifierName.equalsIgnoreCase("item_fee") ? colunmValue
//                        : formatUnit(colunmValue));
//            }
//            if (count == 0) {
//                wb = new XSSFWorkbook();
//                sheet = (XSSFSheet) wb.createSheet("详单");
//            }
//            if (count == 0) {
//
//                XSSFRow row0 = sheet.createRow(count);// 第一行
//                XSSFCell cell0 = row0.createCell(0);
//                cell0.setCellValue("批次号");
//                cell0 = row0.createCell(1);
//                cell0.setCellValue(stlBillData.getBatchNo());
//                cell0 = row0.createCell(2);
//                cell0.setCellValue("总记录数");
//                cell0 = row0.createCell(3);
//                cell0.setCellValue(num);
//
//                XSSFRow row1 = sheet.createRow(count + 1);// 第n行
//                XSSFRow row2 = sheet.createRow(count + 2);// 第n行
//                for (int i = 0; i < columnNames.size(); i++) {
//                    XSSFCell cell = row1.createCell(i);
//                    cell.setCellValue(columnNames.get(i));
//                }
//                for (int j = 0; j < columnValues.size(); j++) {
//                    XSSFCell cell = row2.createCell(j);
//                    cell.setCellValue(columnValues.get(j));
//                }
//            } else {
//                XSSFRow rown = sheet.createRow(count + 2);// 第n行
//                for (int i = 0; i < columnValues.size(); i++) {
//                    XSSFCell cell = rown.createCell(i);
//                    cell.setCellValue(columnValues.get(i));
//                }
//            }
//            count++;
//            if ((count >= export_max) || flag) {
//                String fileName = Joiner
//                        .on(BaseConstants.COMMON_JOINER)
//                        .join(stlBillData.getTenantId(), stlBillData.getStlElementSn(),
//                                stlBillData.getPolicyCode(), stlBillData.getBillTimeSn(), "详单",
//                                fileCount).concat(".xlsx");
//                String filePath = Joiner.on(File.separator).join(exportPath, fileName);
//                FileOutputStream fileOut = new FileOutputStream(filePath);
//                wb.write(fileOut);
//                wb.close();
//                fileCount++;
//                count = 0;
//            }
//        }
//    }

//    private List<NavigableMap<byte[], byte[]>> getMap(ResultScanner scanner) {
//
//        List<NavigableMap<byte[], byte[]>> result = new ArrayList<NavigableMap<byte[], byte[]>>();
//        for (Result res : scanner) {
//
//            NavigableMap<byte[], byte[]> map = res.getFamilyMap(COLUMN_DEF.getBytes());
//            result.add(map);
//        }
//        return result;
//    }

//    public String exportExcel(StlBillData stlBillData, String policyId, String bsn) throws Exception {
//        Workbook wb = new XSSFWorkbook();
//        XSSFCellStyle cellStyle = (XSSFCellStyle) wb.createCellStyle();
//        cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
//        cellStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
//        cellStyle.setAlignment(HSSFCellStyle.ALIGN_LEFT);
//
//        XSSFSheet sheet0 = (XSSFSheet) wb.createSheet("账单");
//        XSSFRow row0 = sheet0.createRow(0);// 第一行
//        XSSFCell cell = row0.createCell(0);
//        cell.setCellValue("结算方");
//        cell.setCellStyle(cellStyle);
//        cell = row0.createCell(1);
//        cell.setCellValue(stlBillData.getStlElementSn());
//        cell = row0.createCell(2);
//        cell.setCellValue("批次号");
//        cell.setCellStyle(cellStyle);
//        cell = row0.createCell(3);
//        cell.setCellValue(stlBillData.getBatchNo());
//
//        XSSFRow row1 = sheet0.createRow(1);// 第二行
//        cell = row1.createCell(0);
//        cell.setCellValue("政策编码");
//        cell.setCellStyle(cellStyle);
//        cell = row1.createCell(1);
//        cell.setCellValue(stlBillData.getPolicyCode());
//        cell = row1.createCell(2);
//        cell.setCellValue("账期");
//        cell.setCellStyle(cellStyle);
//        cell = row1.createCell(3);
//        cell.setCellValue(stlBillData.getBillTimeSn());
//
//        XSSFRow row2 = sheet0.createRow(2);// 第三行
//        cell = row2.createCell(0);
//        cell.setCellValue("开始时间");
//        cell.setCellStyle(cellStyle);
//        cell = row2.createCell(1);
//        cell.setCellValue(DateFormatUtils.format(stlBillData.getBillStartTime().getTime(),
//                "yyyy-MM-dd"));
//        cell = row2.createCell(2);
//        cell.setCellValue("结束时间");
//        cell.setCellStyle(cellStyle);
//        cell = row2.createCell(3);
//        cell.setCellValue(DateFormatUtils.format(stlBillData.getBillEndTime().getTime(),
//                "yyyy-MM-dd"));
//
//        XSSFRow row3 = sheet0.createRow(3);// 第四行
//        cell = row3.createCell(0);
//        cell.setCellValue("结算金额(元)");
//        cell.setCellStyle(cellStyle);
//        cell = row3.createCell(1);
//
//        String origFee = RedisUtil.getCacheClient().hget(
//                assembleCacheKey(SmcCacheConstant.Cache.BILL_DATA_PREFIX, bsn), policyId);
//        // if (StringUtils.isNotBlank(origFee)) {
//        // BigDecimal bOrigFee = new BigDecimal(Double.parseDouble(origFee));
//        // origFee = bOrigFee.divide(new BigDecimal(1000), 2,
//        // BigDecimal.ROUND_HALF_UP).toPlainString();
//        // }else{
//        // origFee = "0";
//        // }
//        cell.setCellValue(formatUnit(origFee));
//
//        XSSFRow row5 = sheet0.createRow(5);// 第六行
//        cell = row5.createCell(0);
//        cell.setCellValue("科目ID");
//        cell.setCellStyle(cellStyle);
//        cell = row5.createCell(1);
//        cell.setCellValue("科目名称");
//        cell.setCellStyle(cellStyle);
//        cell = row5.createCell(2);
//        cell.setCellValue("总金额(元)");
//        cell.setCellStyle(cellStyle);
//
//        int lineNo = 6;
//        // List<StlBillItemData> itemDatas = stlBillData.getItemDatas();
//        List<StlBillItemData> itemDatas = getItemDataByPolicyId(policyId, bsn);
//        String totalFee = "0";
//        String feeItemId = "";
//        for (StlBillItemData itemData : itemDatas) {
//            XSSFRow rowTmp = sheet0.createRow(lineNo);
//            cell = rowTmp.createCell(0);
//            feeItemId = itemData.getFeeItemId();
//            cell.setCellValue(feeItemId);
//            cell = rowTmp.createCell(1);
//            // cell.setCellValue("科目名称");
//            StlSysParam stlSysParam = getSysParamCache(new String[] { stlBillData.getTenantId(),
//                    TypeCode.STL_POLICY_ITEM_PLAN, ParamCode.FEE_ITEM, feeItemId });
//            String columnDesc = stlSysParam != null ? stlSysParam.getColumnDesc() : "";
//            cell.setCellValue(columnDesc);
//            cell = rowTmp.createCell(2);
//            totalFee = RedisUtil.getCacheClient().hget(
//                    assembleCacheKey(SmcCacheConstant.Cache.BILL_ITEM_DATA_PREFIX, bsn),
//                    assembleCacheKey(policyId, ":", itemData.getFeeItemId()));
//            cell.setCellValue(formatUnit(totalFee));
//            lineNo++;
//        }
//
//        String fileName = Joiner
//                .on(BaseConstants.COMMON_JOINER)
//                .join(stlBillData.getTenantId(), stlBillData.getStlElementSn(),
//                        stlBillData.getPolicyCode(), stlBillData.getBillTimeSn(),
//                        stlBillData.getBillId()).concat(".xlsx");
//
//        String local = Joiner.on(File.separator).join(exportLocal, stlBillData.getBatchNo(),
//                policyId);
//
//        FileUtils.forceMkdir(FileUtils.getFile(local.toString()));
//
//        FileOutputStream fileOut = new FileOutputStream(local + File.separator + fileName);
//        wb.write(fileOut);
//        wb.close();
//        return local.toString();
//    }

    private void createCompressedFile(ZipOutputStream out, File file, String dir)
            throws IOException {
        // 如果当前的是文件夹，则进行进一步处理
        if (file.isDirectory()) {
            // 得到文件列表信息
            File[] files = file.listFiles();
            // 将文件夹添加到下一级打包目录
            out.putNextEntry(new ZipEntry(dir + File.separator));
            dir = dir.length() == 0 ? "" : dir + File.separator;
            // 循环将文件夹中的文件打包
            for (int i = 0; i < files.length; i++) {
                createCompressedFile(out, files[i], dir + files[i].getName()); // 递归处理
            }
        } else { // 当前的是文件，打包处理
            // 文件输入流
            FileInputStream fis = new FileInputStream(file);
            out.putNextEntry(new ZipEntry(dir));
            // 进行写操作
            int j = 0;
            byte[] buffer = new byte[1024];
            while ((j = fis.read(buffer)) > 0) {
                out.write(buffer, 0, j);
            }
            // 关闭输入流
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private String formatUnit(String fee) {
        String formatFee = "0";
        if (StringUtils.isNotBlank(fee)) {
            BigDecimal bOrigFee = new BigDecimal(Double.parseDouble(fee));
            formatFee = bOrigFee.divide(new BigDecimal(1000), 2, BigDecimal.ROUND_HALF_UP)
                    .toPlainString();
        }
        return formatFee;
    }

}

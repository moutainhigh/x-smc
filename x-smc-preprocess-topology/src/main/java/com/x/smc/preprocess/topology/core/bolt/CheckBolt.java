package com.x.smc.preprocess.topology.core.bolt;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import backtype.storm.task.TopologyContext;
import backtype.storm.topology.BasicOutputCollector;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseBasicBolt;
import backtype.storm.tuple.Fields;
import backtype.storm.tuple.Tuple;
import backtype.storm.tuple.Values;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.x.base.exception.BusinessException;
import com.x.ic.smc.sdk.cache.util.SmcCacheUtil;
import com.x.ic.smc.sdk.cache.vo.Element;
import com.x.ic.smc.sdk.cache.vo.Policy;
import com.x.sdk.mds.vo.BusinessMessage;
import com.x.sdk.util.CollectionUtil;
import com.x.sdk.util.DateUtil;
import com.x.sdk.util.StringUtil;
import com.x.smc.preprocess.topology.core.constant.SmcConstants;
import com.x.smc.preprocess.topology.core.constant.SmcConstants.NameSpace;
import com.x.smc.preprocess.topology.core.constant.SmcConstants.StlElement.IsNecessary;
import com.x.smc.preprocess.topology.core.constant.SmcConstants.StlElement.type;
import com.x.smc.preprocess.topology.core.util.LoadConfUtil;
import com.x.smc.preprocess.topology.core.util.RedisUtil;
import com.x.smc.preprocess.topology.core.vo.StlSysParam;
import com.x.storm.failbill.FailBillHandler;
import com.x.storm.jdbc.JdbcProxy;
import com.x.storm.util.BaseConstants;
import com.x.storm.util.HBaseProxy;

public class CheckBolt extends BaseBasicBolt {

	private static final long serialVersionUID = -3214008757998306486L;

	private static final Logger logger = LoggerFactory.getLogger(CheckBolt.class);

	@SuppressWarnings("unchecked")
	@Override
	public void prepare(@SuppressWarnings("rawtypes") Map stormConf, TopologyContext context) {
		super.prepare(stormConf, context);
		LoadConfUtil.loadRedisConf(stormConf);
		FailBillHandler.startup();

		JdbcProxy.loadDefaultResource(stormConf);
		/* 初始化hbase */
		HBaseProxy.loadResource(stormConf);
	}

	@Override
	public void execute(Tuple input, BasicOutputCollector collector) {
		/* 接收输入报文 */
		if (StringUtil.isBlank(input.getString(0))) {
			logger.error("流水为空");
			return;
		}
		JSONObject msgObj = null;
		try {
			BusinessMessage msg = JSONObject.parseObject(input.getString(0), BusinessMessage.class);
			if (StringUtil.isBlank(msg.getData())) {
				logger.error("流水为空");
				return;
			}
			
			msgObj = JSONObject.parseObject(msg.getData());
			JSONObject msgHeader = msgObj.getJSONObject(SmcConstants.Message.HEADER);
			JSONObject msgBody = msgObj.getJSONObject(SmcConstants.Message.BODY);
			
			logger.info("数据校验bolt输入消息报文：[" + msgObj + "]...");
			logger.info("@校验@进入到校验bolt的header为" + msgObj.get(SmcConstants.Message.HEADER));
			logger.info("流水数据" + msgObj.get(SmcConstants.Message.BODY));

			String tenantId = msgHeader.getString(SmcConstants.Message.TENANT_ID);
			String policyId = msgHeader.getString(SmcConstants.Message.POLICY_ID);
			
			Policy policy = SmcCacheUtil.getPolicyByPolicyId(tenantId, Long.valueOf(policyId));
			if(policy==null) {
				throw new BusinessException(SmcConstants.Special.NO_DATA_OR_CACAE_ERROR,
						tenantId + "." + policyId + "租户id,policyId获取到的策略信息为空");
			}
			// 根据对象id获取元素ID
			List<Element> list = SmcCacheUtil.getElementByPolicyId(tenantId, Long.valueOf(policyId));
			if(CollectionUtil.isEmpty(list)) {
				throw new BusinessException(SmcConstants.Special.NO_DATA_OR_CACAE_ERROR,
						tenantId + "." + policyId + "租户id.流水对象id获得元素对象为空");
			}
			logger.info(tenantId + "." + policyId + "租户id.流水对象id获得元素对象为：" + list);
			
			String pKey = this.getElementsKeyFiled(list);
			StringBuffer primaryKey = new StringBuffer(pKey);
			primaryKey.append(":").append(msgBody.getString(pKey));
			msgObj.put("primaryKey", primaryKey.toString());
			
			String dateElementCode = "";
			for (Element stlElement : list) {
				if (stlElement.getAttrType().equals("normal")) {
					String element = msgBody.getString(stlElement.getElementCode());
					logger.info("元素id" + stlElement.getElementCode() + "元素值" + element);
					Boolean NecessaryResult = checkIsNecessary(element, stlElement);
					if (!NecessaryResult) {
						// 必填数据为空失败,KEY：租户ID_批次号_数据对象_流水ID_流水产生日期(YYYYMMDD)
//						assemResult(tenantId, billTimeSn, primaryKey.toString(), "失败", "必填元素为空",
//								data);
						throw new BusinessException(SmcConstants.Special.NO_DATA_OR_CACAE_ERROR,
								stlElement.getElementCode() + "校验失败，此elementcode为必填");
					} else {
						Boolean ValueTypeResult = checkValueType(element, stlElement);
						if (!ValueTypeResult) {
//							assemResult(tenantId, billTimeSn, primaryKey.toString(), "失败", "必填元素类型不匹配",
//									data);
							throw new BusinessException(SmcConstants.Special.NO_DATA_OR_CACAE_ERROR,
									stlElement.getElementCode() + "校验失败，此elementcode属性值类型错误");
						}
					}
				}
				if(StringUtils.equals("3", stlElement.getElementType())) {
					dateElementCode = stlElement.getElementCode();
				}
			}
			if(StringUtils.isBlank(dateElementCode)) {
				throw new BusinessException(SmcConstants.Special.NO_RESULT,
						"校验失败，未获取到消息的日期字断");
			}
			Timestamp msgTime = new Timestamp(Long.valueOf(msgBody.getString(dateElementCode)));
			String cycleType = policy.getExecCycle();
			Date startTime = policy.getStartTime();
			int timeUnitOffset = com.x.smc.preprocess.topology.core.util.DateUtil.timeUnitOffset(new Timestamp(startTime.getTime()), msgTime, cycleType);
			if(timeUnitOffset<0) {
				throw new BusinessException(SmcConstants.Special.PARAM_TYPE_NOT_RIGHT,
						"校验失败，计算周期值异常");
			}
			
			String cycleValue = String.valueOf(timeUnitOffset+1);
			StringBuffer billTimeSn = new StringBuffer();
			billTimeSn.append("BSN_")
			.append(tenantId.toUpperCase()).append("_")
			.append(policyId).append("_")
			.append(cycleType.toUpperCase())
			.append(cycleValue);
			
			msgHeader.put("bsn", billTimeSn.toString());
			msgHeader.put("cycleType", cycleType);
			msgHeader.put("cycleValue", cycleValue);
			logger.info("消息的policyId=" + policyId);
			logger.info("消息的billTimeSn=" + billTimeSn.toString());
			logger.info(tenantId + "." + policyId + "租户id.流水对象id获得元素对象为：" + list);
			msgObj.put(SmcConstants.Message.HEADER, msgHeader);
			collector.emit(new Values(msgObj.toString()));
		} catch (BusinessException e) {
			logger.error("@@@@@@@@@@@@@@预处理校验@校验bolt出现异常", e);
			FailBillHandler.addFailBillMsg(msgObj, SmcConstants.CHECK_BOLT, e.getErrorCode(), e.getErrorMessage());
		} catch (Exception e) {
			logger.error("@@@@@@@@@@@@@@校验@校验bolt的异常为：", e);
			logger.error("@@@@@@@@@@@@@@校验@校验bolt的异常流水为：" + input.getString(0));
			FailBillHandler.addFailBillMsg(msgObj, "预处理拓扑", "校验bolt", e.getMessage());
		}
	}

//	private void assemResult(String tenantId, String billTimeSn, String pk,
//			String verifyState, String verifydesc, String inputData) throws Exception {
//		StringBuilder stlOrderDatakey = new StringBuilder();
//		stlOrderDatakey.append(tenantId);
//		stlOrderDatakey.append("_");
//		stlOrderDatakey.append(billTimeSn);
//		stlOrderDatakey.append("_");
//		stlOrderDatakey.append(pk);
//		
//		String tableName = SmcHbaseConstants.TableName.STL_ORDER_DATA_ + billTimeSn;
//		Table tableStlOrderData = HBaseProxy.getConnection().getTable(TableName.valueOf(tableName));
//		Admin admin = HBaseProxy.getConnection().getAdmin();
//		if (!admin.isTableAvailable(TableName.valueOf(tableName))) {
//			HTableDescriptor tableDesc = new HTableDescriptor(TableName.valueOf(tableName));
//			tableDesc.addFamily(new HColumnDescriptor(FamilyColumnName.COLUMN_DEF.getBytes()));
//			admin.createTable(tableDesc);
//			System.out.println("新建的hbase表名为：" + tableName);
//		}
//		System.out.println("@校验@统计成功或失败，表名为：" + tableName);
//
//		Put put = new Put(stlOrderDatakey.toString().getBytes());
//		put.addColumn(FamilyColumnName.COLUMN_DEF.getBytes(), SmcHbaseConstants.StlOrderData.TENANT_ID.getBytes(),
//				tenantId.getBytes());
//		put.addColumn(FamilyColumnName.COLUMN_DEF.getBytes(), SmcHbaseConstants.StlOrderData.BSN.getBytes(),
//				billTimeSn.getBytes());
//		put.addColumn(FamilyColumnName.COLUMN_DEF.getBytes(), SmcHbaseConstants.StlOrderData.VERIFY_STATE.getBytes(),
//				verifyState.getBytes());
//		put.addColumn(FamilyColumnName.COLUMN_DEF.getBytes(), SmcHbaseConstants.StlOrderData.VERIFY_DESC.getBytes(),
//				verifydesc.getBytes());
//		put.addColumn(FamilyColumnName.COLUMN_DEF.getBytes(), SmcHbaseConstants.StlOrderData.DATA.getBytes(),
//				inputData.getBytes());
//		
//		System.out.println("@校验@统计成功或失败，key为：" + stlOrderDatakey.toString());
//		System.out.println("@校验@统计成功或失败，值为：" + "tenantId:" + tenantId + "bsn:" + billTimeSn + "pk:" + pk
//				+ "verifyState:" + verifyState + "verifydesc:" + verifydesc);
//		logger.info("@校验@统计成功或失败，key为：" + stlOrderDatakey.toString());
//		logger.info("@校验@统计成功或失败，值为：" + "tenantId:" + tenantId + "bsn:" + billTimeSn + "pk:" + pk
//				+ "verifyState:" + verifyState + "verifydesc:" + verifydesc);
//		logger.info("@校验@统计成功或失败流水为：" + inputData);
//		tableStlOrderData.put(put);
//	}
	
	private String getElementsKeyFiled(List<Element> elements) {
		for(Element element:elements) {
			if(StringUtils.equals(SmcConstants.StlElement.IsPrimaryKey.YES, element.getIsPrimaryKey())) {
				return element.getElementCode();
			}
		}
		return null;
	}

	private Boolean checkValueType(String element, Element stlElement) throws Exception {
		String valueType = stlElement.getValueType();
		if (type.ENUM.equals(valueType)) {
			Boolean flag = false; // 系统参数表中获得类型
			String result = RedisUtil.getCacheClient().hget(NameSpace.SYS_PARAM_CACHE,
					stlElement.getTenantId() + "." + "STL_ORDER_DATA" + "." + stlElement.getElementCode());
			if (StringUtil.isBlank(result)) {
				throw new BusinessException(SmcConstants.Special.PARAM_IS_NULL,
						stlElement.getTenantId() + stlElement.getElementCode() + "此租户id和元素编码对应的系统参数表数据为空");
			}
			List<StlSysParam> list = JSONArray.parseArray(result, StlSysParam.class);
			for (StlSysParam stlSysParam : list) {
				if (element.equals(stlSysParam.getColumnValue())) {
					flag = true;
					break;
				}
			}
			if (flag) {
				return true;
			} else {
				return false;
			}
		} else if (type.INT.equals(valueType)) {
			try {
				Integer.parseInt(element);
			} catch (Exception e) {
				throw new BusinessException(e.getMessage(), "int型转换失败");
			}
		} else if (type.FLOAT.equals(valueType)) {
			try {
				Float.parseFloat(element);
			} catch (Exception e) {
				throw new BusinessException(e.getMessage(), "Float型转换失败");
			}

		} else if (type.DATETIME.equals(valueType)) {
			try {
				SimpleDateFormat sdf = new SimpleDateFormat("YYYYMMDDhhmmss");
				sdf.parse(element); // Mon Jan 14 00:00:00 CST 2013

			} catch (Exception e) {
				throw new BusinessException(e.getMessage(), element + "日期yyyyMMddhhmmss型转换失败");
			}
		}
		return true;
	}

	private Boolean checkIsNecessary(String element, Element stlElement) throws BusinessException {
		Boolean result = true;
		// 根据元素编码获得流水中元素的值
		if (IsNecessary.YES.equals(stlElement.getIsNecessary()) && StringUtil.isBlank(element)) {
			result = false;

		}
		return result;
	}

	@Override
	public void declareOutputFields(OutputFieldsDeclarer declarer) {
		// TODO Auto-generated method stub
		declarer.declare(new Fields("DATA"));

	}
}

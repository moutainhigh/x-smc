package com.x.smc.preprocess.topology.core.bolt;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.wltea.expression.ExpressionEvaluator;
import org.wltea.expression.datameta.Variable;

import backtype.storm.task.TopologyContext;
import backtype.storm.topology.BasicOutputCollector;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseBasicBolt;
import backtype.storm.tuple.Fields;
import backtype.storm.tuple.Tuple;
import backtype.storm.tuple.Values;

import com.x.base.exception.BusinessException;
import com.x.ic.smc.sdk.cache.util.SmcCacheUtil;
import com.x.ic.smc.sdk.cache.vo.Element;
import com.x.ic.smc.sdk.cache.vo.ElementAttr;
import com.x.sdk.util.CollectionUtil;
import com.x.sdk.util.StringUtil;
import com.x.smc.preprocess.topology.core.constant.SmcConstants;
import com.x.smc.preprocess.topology.core.constant.SmcConstants.NameSpace;
import com.x.smc.preprocess.topology.core.util.IKin;
import com.x.smc.preprocess.topology.core.util.LoadConfUtil;
import com.x.smc.preprocess.topology.core.util.RedisUtil;
import com.x.smc.preprocess.topology.core.vo.StlElement;
import com.x.storm.failbill.FailBillHandler;
import com.x.storm.util.HBaseProxy;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class StatisticsBolt extends BaseBasicBolt {
	private static final long serialVersionUID = 8475030105476807164L;

	private static final Logger logger = LoggerFactory.getLogger(CheckBolt.class);

	@SuppressWarnings("unchecked")
	@Override
	public void prepare(@SuppressWarnings("rawtypes") Map stormConf, TopologyContext context) {
		super.prepare(stormConf, context);
		LoadConfUtil.loadRedisConf(stormConf);
		FailBillHandler.startup();

		/* 初始化hbase */
		HBaseProxy.loadResource(stormConf);
	}

	@Override
	public void execute(Tuple input, BasicOutputCollector collector) {
		/* 接收输入报文 */
		String inputData = input.getString(0);
		JSONObject msgObj = null;
		try {
			
			msgObj = JSONObject.parseObject(inputData);
			JSONObject msgHeader = msgObj.getJSONObject(SmcConstants.Message.HEADER);
			JSONObject msgBody = msgObj.getJSONObject(SmcConstants.Message.BODY);
			
			String tenantId = msgHeader.getString(SmcConstants.Message.TENANT_ID);
			String policyId = msgHeader.getString(SmcConstants.Message.POLICY_ID);
			// 根据对象id获取元素ID
			List<Element> elements = SmcCacheUtil.getElementByPolicyId(tenantId, Long.valueOf(policyId));
			logger.info(tenantId + "_" + policyId + ":@统计@此key获得的元素对象list为：" + JSONArray.toJSONString(elements));
			if (!CollectionUtil.isEmpty(elements)) {
				for (Element stlElement : elements) {
					// 获得统计元素属性表的对象list组个进行限定条件校验，
					List<ElementAttr> elementAttrlist = SmcCacheUtil.getElementAttrByElementId(tenantId, stlElement.getElementId());
					logger.info("取政策表的key为" + tenantId + "_" + stlElement.getElementId().toString());
					logger.info(tenantId + "_" + stlElement.getElementId().toString() + "_" + policyId
							+ "@统计@获得统计元素属性表的对象list值为：" + JSONArray.toJSONString(elementAttrlist));
					if (!CollectionUtil.isEmpty(elementAttrlist)) {
						boolean flag = true;
						for (ElementAttr stlElementAttr : elementAttrlist) {
							String matchType = stlElementAttr.getRelType();
							String matchValue = stlElementAttr.getRelValue();
							// 获得元素编码再获得值元素值
							String elementCode = getElementCode(tenantId, stlElementAttr.getSubElementId());
							String elementValue = msgBody.getString(elementCode);
							if (StringUtil.isBlank(matchType)) {
								throw new BusinessException(SmcConstants.Special.SYSTEM_ERROR,
										stlElementAttr.getAttrId() + "此AttrId对应的RelType为空");
							}
							if (StringUtil.isBlank(matchValue)) {
								throw new BusinessException(SmcConstants.Special.SYSTEM_ERROR,
										stlElementAttr.getAttrId() + "此AttrId对应的RelValue为空");
							}
							if (StringUtil.isBlank(elementValue)) {
								throw new BusinessException(SmcConstants.Special.SYSTEM_ERROR,
										stlElement.getElementCode() + "此elementCode对应的lementValue为空");
							}
							if (!checkRel(matchType, matchValue, elementValue)) {
								flag = false;
								break;
							}
						}
						if (!flag){// 如果不满足则存错单
							throw new BusinessException(SmcConstants.Special.SYSTEM_ERROR,
									stlElement.getElementCode() + "验证失败");
						}
					}
				}
			}
			collector.emit(new Values(inputData));
		} catch (BusinessException e) {
			logger.error("出现异常", e);
			FailBillHandler.addFailBillMsg(msgObj, SmcConstants.CHECK_BOLT, e.getErrorCode(), e.getErrorMessage());
		} catch (Exception e) {
			logger.error("@@@@@@@@@@@@@@统计@统计bolt的异常为：", e);
			logger.error("@@@@@@@@@@@@@@统计@统计bolt的异常流水为：", inputData);
		}
	}

	private String getElementCode(String tenantId, Long subElementId) throws BusinessException {
		StringBuilder sBuilder = new StringBuilder();
		sBuilder.append(tenantId).append(".").append(subElementId);
		String result = RedisUtil.getCacheClient().hget(NameSpace.ELEMENT_CACHE, sBuilder.toString());
		if (StringUtil.isBlank(result)) {
			throw new BusinessException(SmcConstants.Special.NO_DATA_OR_CACAE_ERROR,
					tenantId + "." + subElementId + "此租户id和元素id对应的元素为空");
		}
		StlElement stlElement = JSON.parseObject(result, StlElement.class);
		return stlElement.getElementCode();
	}

	private Boolean checkRel(String matchType, String matchValue, String elementValue) throws BusinessException {
		Boolean flag = false;
		if (matchType.equals("in")) {
			flag = IKin.in(elementValue, matchValue);
		} else if (matchType.equals("nin")) {
			flag = !IKin.in(elementValue, matchValue);
		} else if (matchType.equals("=")) {
			if ((matchValue.equals(elementValue) || (matchValue == elementValue))) {
				flag = true;
			}
		} else {
			String expression = "a" + matchType + "b";
			List<Variable> variables = new ArrayList<Variable>();
			variables.add(Variable.createVariable("a", matchValue));
			variables.add(Variable.createVariable("b", elementValue));
			Object resultss = ExpressionEvaluator.evaluate(expression, variables);
			if (resultss == null) {
				throw new BusinessException(SmcConstants.Special.SYSTEM_ERROR, "a=" + matchValue + "符号=" + matchType
						+ "b=" + elementValue + "此形式校验格式不正确,正确格式为a、b为数字，符号为大于小于等");
			}
			flag = Boolean.parseBoolean(resultss.toString());
		}
		return flag;
	}

	@Override
	public void declareOutputFields(OutputFieldsDeclarer declarer) {
		// TODO Auto-generated method stub
		declarer.declare(new Fields("DATA"));
	}
}

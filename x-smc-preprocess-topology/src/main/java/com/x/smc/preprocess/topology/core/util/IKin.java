package com.x.smc.preprocess.topology.core.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.storm.guava.collect.Lists;
import org.wltea.expression.ExpressionEvaluator;
import org.wltea.expression.datameta.Variable;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.x.smc.preprocess.topology.core.bo.CountExpCalValue;
import com.x.smc.preprocess.topology.core.bo.CountFixedCalValue;
import com.x.smc.preprocess.topology.core.constant.SmcConstants;

/**
 * 判断表达式是否包含
 * 
 * @author zhangbc
 *
 */
public  class IKin {

	public static boolean in(String a, String b) {
//		if (b.startsWith("{")) {
//			b = b.substring(1, b.length() - 1);
//		}
		String[] bs = b.split(",");
//		for (int i = 0; i < bs.length; i++) {
//			if (bs[i].equals(a)) {
//				return true;
//			}
//		}
		List<String> data = Lists.newArrayList(bs);
		if(data.contains(b)){
			return true;
		}else{
			return false;
		}
		//return false;
	}
	
	public static void main(String[] args) {
		String expression = "(n>40&&n%10==0)?p+50:p";
		List<Variable> variables = new ArrayList<Variable>();
        variables.add(Variable.createVariable("n", 50));
        variables.add(Variable.createVariable("p", 100));
//        variables.add(Variable.createVariable("x", 75));
        Object result = ExpressionEvaluator.evaluate(expression, variables);
        System.out.println(result);
		
//         String json = "{\"limitStart\":1,\"limitEnd\":10000,\"sectionType\":\"fixed\",\"sectionValue\":\"[[0,50],[51,100],[100,200]]\",\"calType\":\"exp\",\"calValue\":\"n\"}";
//         CountExpCalValue value = JSONObject.parseObject(json, CountExpCalValue.class);
//         List<JSONArray> array = JSONArray.parseArray(value.getSectionValue(), JSONArray.class);
//         System.out.println(array.get(0));
//         String json = "[{\"startValue\":\"0\",\"endValue\":\"50\",\"sortIndex\":\"1\",\"calValue\":\"1\"},{\"startValue\":\"51\",\"endValue\":\"100\",\"sortIndex\":\"2\",\"calValue\":\"2\"}]";
//         List<CountFixedCalValue> array = JSONArray.parseArray(json, CountFixedCalValue.class);
//         System.out.println(array.get(0).getCalValue());
		
	}

}
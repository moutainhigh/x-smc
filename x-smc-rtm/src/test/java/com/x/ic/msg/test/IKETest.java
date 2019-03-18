package com.x.ic.msg.test;

import java.util.ArrayList;
import java.util.List;

import org.elasticsearch.rest.RestRequest.Method;
import org.wltea.expression.ExpressionEvaluator;
import org.wltea.expression.datameta.BaseDataMeta.DataType;
import org.wltea.expression.datameta.Variable;
import org.wltea.expression.function.FunctionLoader;

import com.alibaba.fastjson.JSONObject;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.PathNotFoundException;
import com.x.ic.msg.util.JSONUtil;

public class IKETest {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException {
		List<Variable> variables = new ArrayList<Variable>();
		//variables.add(Variable.createVariable("state", "90"));
		//Variable ok = new Variable("ok", DataType.DATATYPE_STRING, "90");
		//Variable v1 = new Variable("v1", DataType.DATATYPE_STRING, "12");
		//Variable v2 = new Variable("v2", DataType.DATATYPE_STRING, "13");
		//variables.add(v1);
		//variables.add(v2);
		//variables.add(ok);
		//Object result = ExpressionEvaluator.evaluate("a+a+v", variables);
		
		//System.out.println(ExpressionEvaluator.evaluate("(state==ok)?v1:v2",variables));

		//FunctionLoader.addFunction("plus", new Calculate(), Calculate.class.getMethod("plus", Long.class,Long.class));
		
		//Variable x = new Variable("x", DataType.DATATYPE_LONG, 50);
		//Variable y = new Variable("y", DataType.DATATYPE_LONG, 10);
		//variables.add(x);
		//variables.add(y);
		String str = "{\"data\":{\"devCust\":\"1\",\"custCode\":\"2\"}}";
		Variable x = new Variable("a",DataType.DATATYPE_STRING,"");
		Variable y = new Variable("b", DataType.DATATYPE_STRING,"");
		variables.add(x);
		variables.add(y);
		System.out.println(ExpressionEvaluator.evaluate("a != null && a != b", variables));
		DocumentContext context = JsonPath.parse(str);
		String nodeValue = JSONUtil.readPath(context, "$.data.aaa");
		
		
				//JsonPath.read(context, "$.data.devCust1");
		System.out.println(nodeValue!=null);
		//Object result = ExpressionEvaluator.evaluate("$json(data,path) == 1", variables);
		//System.out.println(result);
		//System.out.println(JsonPath.read(data, "$.a").toString());
		//Variable v1 = new Variable("v1", DataType.valueOf("DATATYPE_LONG"), "12");
		//Variable v2 = new Variable("v2", DataType.valueOf("DATATYPE_LONG"), "53");
//		Variable v1 = Variable.createVariable("v1", "");
//		Variable v2 = Variable.createVariable("v2", "13");
//		variables.add(v1);
//		variables.add(v2);
//		System.out.println(ExpressionEvaluator.evaluate("v1 == null",variables));
//		
		
		
	}

}

package com.x.ic.msg.test;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPath;

public class ClassTypeTest {

	public static void main(String[] args) throws ClassNotFoundException {
		
		JSONObject json  = new JSONObject();
		json.put("x", "1");
		json.put("y", "2");
		Object obj = JSONPath.eval(json, "$.x");
		String type = "java.lang.Long";

		
	}

}

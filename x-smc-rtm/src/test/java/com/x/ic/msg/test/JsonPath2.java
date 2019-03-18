package com.x.ic.msg.test;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPath;
import com.jayway.jsonpath.JsonPath;

public class JsonPath2 {

	public static void main(String[] args) {
		String json = "{\"busiTypeId\":\"prodsale\",\"completeDate\":1526975950810,\"createDate\":1526975917000,\"orderId\":2000000019077208,\"orderProdDetailVos\":[{\"productId\":\"0000000000000723\",\"productPrice\":\"225\"}],\"orderTypeId\":\"1\",\"state\":\"90\",\"tenantId\":\"pubgo\",\"userId\":\"13243431238\"}";
		JsonPath path = JsonPath.compile("$.orderProdDetailVos");
		
//		Long completeDate = JsonPath.read(json, "$.completeDate");
//		System.out.println(completeDate);

	}

}

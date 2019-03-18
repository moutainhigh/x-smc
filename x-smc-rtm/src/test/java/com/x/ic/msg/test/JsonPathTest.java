package com.x.ic.msg.test;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.mortbay.util.ajax.JSONObjectConvertor;

import com.jayway.jsonpath.JsonPath;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import net.minidev.json.JSONValue;
import net.minidev.json.parser.JSONParser;

public class JsonPathTest {

	public static void main(String[] args) throws IOException {
		//String data = FileUtils.readFileToString(new File("E:/bonc/centers/x-smc-msg/src/test/java/com/x/ic/msg/test/data.json"));
		//ReadContext context = JsonPath.parse(data);
		//String action = context.read("$.action");
		String data = "{\"orderId\":true,\"product\":[{\"productId\":\"1\",\"productName\":\"a\",\"price\":\"1\"},{\"productId\":\"2\",\"productName\":\"b\",\"price\":\"2\"}]}";
		//List<Object> b = JsonPath.read(data, "$.result.records[*].mobile");
		//System.out.println(b);
//		JSONArray orderId = JsonPath.read(data, "$.product[*].productId");
//		JSONArray orderName = JsonPath.read(data, "$.product[*].productName");
//		System.out.println(orderId instanceof JSONArray);
//		for(int i = 0 ;i<orderName.size();i++){
//			System.out.println(orderId.get(i));
//		}
//		
//		
//		System.out.println(orderName);
//		JSONArray products = JsonPath.read(data, "$.product");
//		System.out.println(products);
//		for (int i=0;i<products.size();i++) {
//			String productId = JsonPath.read(data, "$.product["+i+"].productId");
//			String productName = JsonPath.read(data, "$.product["+i+"].productName");
//			System.out.println(productId);
//			System.out.println(productName);
//		}
//		Map<String, Object> json = JsonPath.read(data,"$.product[0]");
		//recursion(JsonPath.read(data, "$"),"");
		Object d = JSONValue.parse(data);
		//System.out.println(d instanceof JSONObject);
		//JSONObject jd = (JSONObject)d;
		//System.out.println(jd.get("product") instanceof JSONArray);
		recursion(d,"$");
	}
	public static void recursion(Object obj,Object path) {		
		if(obj instanceof JSONArray){
			JSONArray arr =  (JSONArray)obj;
			for(int i=0;i<arr.size();i++){
				Object self = path;
				self+="["+i+"]";
				recursion(arr.get(i),self);
			}
		}else if(obj instanceof JSONObject){
			JSONObject map = (JSONObject)obj;
			Set<Entry<String, Object>> entrys = map.entrySet();
			Iterator<Entry<String, Object>> iterator = entrys.iterator();
			while(iterator.hasNext()){
				Entry<String, Object> kv = iterator.next();
				path+="." + kv.getKey();
				recursion(kv.getValue(),path);
			}
		}else{
			System.out.println("path:" + path + "|value:" + obj + "|type:" + obj.getClass().getSimpleName());
		}
		
	}
	

}

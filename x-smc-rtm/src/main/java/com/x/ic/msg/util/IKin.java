package com.x.ic.msg.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.wltea.expression.datameta.BaseDataMeta.DataType;

import com.google.common.collect.Lists;


public class IKin {
	
	private static Map<String, DataType> dataTypeMap = new HashMap<>();
	
	{
		dataTypeMap.put("java.lang.String", DataType.DATATYPE_STRING);
		dataTypeMap.put("java.lang.Long", DataType.DATATYPE_LONG);
		dataTypeMap.put("java.lang.Boolean", DataType.DATATYPE_BOOLEAN);
		dataTypeMap.put("java.util.Date", DataType.DATATYPE_DATE);
		dataTypeMap.put("java.lang.Float", DataType.DATATYPE_FLOAT);
		dataTypeMap.put("java.lang.Integer", DataType.DATATYPE_INT);
		dataTypeMap.put("java.util.List", DataType.DATATYPE_LIST);
		dataTypeMap.put("java.lang.Object", DataType.DATATYPE_OBJECT);
	}
	
	public static DataType getDataType(String type){
		if(dataTypeMap.containsKey(type)){
			return dataTypeMap.get(type);
		}
		return DataType.DATATYPE_OBJECT;
	}
	
	public static boolean in(String a , String b){
		String[] bs = b.split(",");
		List<String> data = Lists.newArrayList(bs);
		if(data.contains(a)){
			return true;
		}else{
			return false;
		}
	}
	
}

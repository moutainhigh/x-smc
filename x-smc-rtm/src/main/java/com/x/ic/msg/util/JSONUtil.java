package com.x.ic.msg.util;

import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.PathNotFoundException;
import com.jayway.jsonpath.ReadContext;

public class JSONUtil {
	
	public static <T> T readPath(ReadContext context , String path){
		T value;
		try {
			value = context.read(path);
		} catch (PathNotFoundException e) {
			value = null;
		}
		return value;
	}
	public static <T> T readPath(String context , String path){
		T value;
		try {
			value = JsonPath.read(context, path);
		} catch (PathNotFoundException e) {
			value = null;
		}
		return value;
	}
}

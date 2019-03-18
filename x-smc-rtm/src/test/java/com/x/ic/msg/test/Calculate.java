package com.x.ic.msg.test;

import com.jayway.jsonpath.JsonPath;

public class Calculate {
	public Long puls(Long x, Long y) {
		if (x != null && y != null) {
			return x + y;
		} else {
			throw new NullPointerException("函数\"ENDSWITH\"参数为空");
		}
	}
	public Object json(String data,String path){
		if(data != null && path != null){
			return JsonPath.read(data, path);
		}else{
			throw new NullPointerException("函数\"ENDSWITH\"参数为空");
		}
	}
}

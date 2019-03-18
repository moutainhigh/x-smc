package com.x.smc.bill.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class PropertiesUtil {

	private static Logger logger = LoggerFactory.getLogger(PropertiesUtil.class);
	private ConcurrentHashMap<String, String> dataMap = new ConcurrentHashMap<String, String>();
	private static PropertiesUtil instance = new PropertiesUtil();
	
	public static void load(String resourcesName){
		if(StringUtils.isBlank(resourcesName)){
			return;
		}
		loadResources(resourcesName);
	}
	
	private static void loadResources(String fileName){
		Properties properties = loadProperties(fileName);
		if(properties==null){
			return;
		}
		Iterator<Entry<Object, Object>> itor = properties.entrySet().iterator();
		while (itor.hasNext()) {
			Entry<Object, Object> entry = itor.next();
			String name = (String) entry.getKey();
			String value = (String) entry.getValue();
			instance.dataMap.put(name, value);
		}
	}
	
	public static String getValue(String key) {
		String value = instance.dataMap.get(key);
		return value;
	}

	public static Object remove(String k) {
		Object v = instance.dataMap.remove(k);
		return v;
	}
	
	public static Properties loadProperties(String fileName){
		System.out.println("the filename is "+fileName);
		Properties properties = new Properties();
		InputStream inputStream = null;
		try{
			inputStream = PropertiesUtil.class.getClassLoader().getResourceAsStream(fileName);
			properties.load(inputStream);
		}catch(IOException e){
			logger.error("context", e);
			properties = null;
		}finally{
			if(inputStream!=null){
				try {
					inputStream.close();
				} catch (IOException e) {
					logger.error("context", e);
				}
			}
		}
		return properties;
	}
	
}

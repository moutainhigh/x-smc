package com.x.hbase.base;

import org.apache.commons.lang.StringUtils;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.x.base.exception.SystemException;
import com.x.hbase.base.impl.HbaseClient;
import com.x.hbase.base.interfaces.IHbaseClient;
import com.x.sdk.ccs.util.ConfigTool;

/**
 * 
 * @author wangluyang
 *
 */
public class IHbaseClientFactory {

	private IHbaseClientFactory() {}
	
	private static IHbaseClient iHbaseClient;
    
	/**
	 * 获取默认的hbase客户端,从配置中心获取配置
	 * @return
	 */
	public static IHbaseClient getDefaultHbaseClient() {
		if(iHbaseClient!=null) {
			return iHbaseClient;
		}
		return loadResource();
	}
	
	private synchronized static IHbaseClient loadResource() {
		
		String hbaseSite = ConfigTool.getConfigItem("hbase.param");
   		if (StringUtils.isBlank(hbaseSite)) {
             throw new SystemException("没有配置hbase.site属性信息!");
         }
   		JsonParser jsonParser = new JsonParser();
   		JsonObject jsonObject = (JsonObject) jsonParser.parse(hbaseSite);
	    if(iHbaseClient==null) {
	    		iHbaseClient = new HbaseClient(jsonObject);
	    }
   		return iHbaseClient;
   }
	
   /**
    * 获取默认的hbase客户端,从本地文件获取
    * @return
    */
   public IHbaseClient getHbaseClientByLocal() {
		return null;
	}
}

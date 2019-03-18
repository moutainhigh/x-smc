package com.x.smc.preprocess.topology.core.util;

import java.util.Map;
import java.util.Properties;

import com.x.sdk.mcs.interfaces.ICacheClient;

public class LoadConfUtil {

	// public static void loadPaasConf(Map<String, String> conf) {
	// Properties p = new Properties();
	// p.setProperty(SmcConstants.PAAS_AUTH_URL,
	// conf.get(SmcConstants.PAAS_AUTH_URL));
	// p.setProperty(SmcConstants.PAAS_AUTH_PID,
	// conf.get(SmcConstants.PAAS_AUTH_PID));
	// p.setProperty(SmcConstants.PAAS_CCS_SERVICEID,
	// conf.get(SmcConstants.PAAS_CCS_SERVICEID));
	// p.setProperty(SmcConstants.PAAS_CCS_SERVICEPASSWORD,
	// conf.get(SmcConstants.PAAS_CCS_SERVICEPASSWORD));
	// ComponentConfigLoader.loadPaaSConf(p);
	// }

	public static ICacheClient loadRedisConf(Map<String, Object> conf) {
		return RedisUtil.init(conf);
	}
}

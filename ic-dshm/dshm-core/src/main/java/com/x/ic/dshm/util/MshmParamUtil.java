package com.x.ic.dshm.util;



import java.util.Map;

import com.google.gson.Gson;
import com.x.ic.dshm.constants.MshmConstants;

public class MshmParamUtil {
	
	public static Map<String ,String> getParamMap(String applyParam) {
		Gson gson = new Gson();
		return gson.fromJson(applyParam, Map.class);
	}

	private static String successfulParam(String applyParam) {
		Map<String ,String> paramMap = getParamMap(applyParam);
		paramMap.remove(MshmConstants.USER_ID);
		paramMap.remove(MshmConstants.CLUSTER_TYPE);
		paramMap.remove(MshmConstants.APPLY_TYPE);
		paramMap.remove(MshmConstants.SERVICE_ID);
		paramMap.put(MshmConstants.RESULT_CODE, MshmConstants.SUCCESS_CODE);
		paramMap.put(MshmConstants.RESULT_MSG, MshmConstants.SUCCESS_INFO);
		Gson gson = new Gson();
		return gson.toJson(paramMap);
	}
	
	private static String failedParam(String applyParam) {
		Map<String ,String> paramMap = getParamMap(applyParam);
		paramMap.remove(MshmConstants.USER_ID);
		paramMap.remove(MshmConstants.CLUSTER_TYPE);
		paramMap.remove(MshmConstants.APPLY_TYPE);
		paramMap.remove(MshmConstants.SERVICE_ID);
		paramMap.put(MshmConstants.RESULT_CODE, MshmConstants.FAIL_CODE);
		paramMap.put(MshmConstants.RESULT_MSG, MshmConstants.FAIL_INFO);
		Gson gson = new Gson();
		return gson.toJson(paramMap);
	}
	
	public static String getReturn(String applyParam,String res){
		if(MshmConstants.SUCCESS_FLAG.equals(res))
			return successfulParam(applyParam);
		return failedParam(applyParam);
	}
	

}

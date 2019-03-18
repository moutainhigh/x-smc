package com.x.ic.smc.util;

import java.util.Collections;
import java.util.List;

import com.x.sdk.util.StringUtil;
import com.x.ic.smc.constants.SmcCacheConstant;
import com.x.ic.smc.dao.mapper.bo.StlSysParam;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

public final class SysParamUtil {
    private SysParamUtil() {
    }

    public static List<StlSysParam> getSysParams(String tenantId, String typeCode, String paramCode) {
//        ICacheClient cacheClient = MCSClientFactory
//                .getCacheClient(SmcCacheConstant.NameSpace.SYS_PARAM_CACHE);
        StringBuilder key = new StringBuilder();
        key.append(tenantId);
        key.append(".");
        key.append(typeCode);
        key.append(".");
        key.append(paramCode);
        String data = RedisUtil.getCacheClient().hget(SmcCacheConstant.NameSpace.SYS_PARAM_CACHE, key.toString());
        if (StringUtil.isBlank(data)) {
            return Collections.emptyList();
        }
        return JSONArray.parseArray(data, StlSysParam.class);
    }

    public static StlSysParam getSysParam(String tenantId, String typeCode, String paramCode,
            String columnValue) {
//        ICacheClient cacheClient = MCSClientFactory
//                .getCacheClient(SmcCacheConstant.NameSpace.SYS_PARAM_CACHE);
        StringBuilder key = new StringBuilder();
        key.append(tenantId);
        key.append(".");
        key.append(typeCode);
        key.append(".");
        key.append(paramCode);
        key.append(".");
        key.append(columnValue);
        String data = RedisUtil.getCacheClient().hget(SmcCacheConstant.NameSpace.SYS_PARAM_CACHE, key.toString());
        if (StringUtil.isBlank(data)) {
            return null;
        }
        return JSON.parseArray(data, StlSysParam.class).get(0);
    }

    public static String getSysParamDesc(String tenantId, String typeCode, String paramCode,
            String columnValue) {
        StlSysParam sysParam = getSysParam(tenantId, typeCode, paramCode, columnValue);
        return sysParam == null ? "" : sysParam.getColumnDesc();
    }

}

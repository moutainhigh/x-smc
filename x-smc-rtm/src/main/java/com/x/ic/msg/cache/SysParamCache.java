package com.x.ic.msg.cache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.x.ic.msg.constants.SmcCacheConstant;
import com.x.ic.msg.constants.SmcConstants;
import com.x.ic.msg.dao.mapper.bo.StlSysParam;
import com.x.ic.msg.dao.mapper.bo.StlSysParamExample;
import com.x.ic.msg.dao.mapper.interfaces.StlSysParamMapper;
import com.x.ic.msg.util.CacheKeyUtil;
import com.x.sdk.cache.base.AbstractCache;
import com.x.sdk.mcs.MCSClientFactory;
import com.x.sdk.util.CollectionUtil;

@Component
public class SysParamCache extends AbstractCache {
	
	private static final Logger log = LogManager.getLogger(SysParamCache.class);
	
	@Autowired
	private StlSysParamMapper stlSysParamMapper;

    @Override
    public void write() throws Exception {
        StlSysParamExample stlSysParamCriteria = new StlSysParamExample();
        stlSysParamCriteria.createCriteria().andStateEqualTo(SmcConstants.StlSysParam.State.NORMAL);
        List<StlSysParam> stlSysParams = stlSysParamMapper.selectByExample(stlSysParamCriteria);
        if (CollectionUtil.isEmpty(stlSysParams)) {
            return;
        }
        Map<String, List<StlSysParam>> map = new HashMap<String, List<StlSysParam>>();

        for (StlSysParam sysParam : stlSysParams) {
        	String paramTypeCode = CacheKeyUtil.getSysParamByTypeCode(sysParam.getTenantId(), sysParam.getTypeCode());
            if (map.containsKey(paramTypeCode)) {
                map.get(paramTypeCode).add(sysParam);
            } else {
                List<StlSysParam> listTmp = new ArrayList<StlSysParam>();
                listTmp.add(sysParam);
                map.put(paramTypeCode, listTmp);
            }
            String paramCodeKey = CacheKeyUtil.getSysParamByParamCode(sysParam.getTenantId(), sysParam.getTypeCode(), sysParam.getParamCode());
            if (map.containsKey(paramCodeKey)) {
                map.get(paramCodeKey).add(sysParam);
            } else {
                List<StlSysParam> listTmp = new ArrayList<StlSysParam>();
                listTmp.add(sysParam);
                map.put(paramCodeKey, listTmp);
            }
            String columnValueKey = CacheKeyUtil.getSysParamByColumnValue(sysParam.getTenantId(), sysParam.getTypeCode(), sysParam.getParamCode(), sysParam.getColumnValue());
            String columnValue = JSON.toJSONString(sysParam);
            MCSClientFactory.getCacheClient(SmcCacheConstant.MSDNS).hset(SmcCacheConstant.NameSpace.SYS_PARAM_CACHE, columnValueKey, columnValue);
        	log.debug("NameSpace:{}",SmcCacheConstant.NameSpace.ELEMENT_CACHE);
            log.debug("key:{}",columnValueKey);
            log.debug("value:{}",columnValue);
        }
        for (Entry<String, List<StlSysParam>> entry : map.entrySet()) {
        	String key = entry.getKey();
        	String value = JSON.toJSONString(entry.getValue());
        	MCSClientFactory.getCacheClient(SmcCacheConstant.MSDNS).hset(SmcCacheConstant.NameSpace.SYS_PARAM_CACHE, key, value);
        	log.debug("NameSpace:{}",SmcCacheConstant.NameSpace.ELEMENT_CACHE);
            log.debug("key:{}",key);
            log.debug("value:{}",value);
        }
    }

}

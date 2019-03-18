package com.x.ic.smc.cache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.stereotype.Component;

import com.x.sdk.cache.base.AbstractCache;
import com.x.sdk.util.CollectionUtil;
import com.x.ic.smc.constants.SmcCacheConstant;
import com.x.ic.smc.constants.SmcConstants;
import com.x.ic.smc.dao.mapper.bo.StlSysParam;
import com.x.ic.smc.dao.mapper.bo.StlSysParamCriteria;
import com.x.ic.smc.dao.mapper.factory.MapperFactory;
import com.x.ic.smc.util.RedisUtil;
import com.alibaba.fastjson.JSON;

@Component
public class SysParamCache extends AbstractCache {

    @Override
    public void write() throws Exception {
        StlSysParamCriteria stlSysParamCriteria = new StlSysParamCriteria();
        stlSysParamCriteria.createCriteria().andStateEqualTo(SmcConstants.StlSysParam.State.NORMAL);
        List<StlSysParam> stlSysParams = MapperFactory.getStlSysParamMapper().selectByExample(
                stlSysParamCriteria);
        if (CollectionUtil.isEmpty(stlSysParams)) {
            return;
        }
        Map<String, List<StlSysParam>> map = new HashMap<String, List<StlSysParam>>();

        for (StlSysParam stlSysParam : stlSysParams) {
            StringBuilder keyOne = new StringBuilder();
            keyOne.append(stlSysParam.getTenantId());
            keyOne.append(".");
            keyOne.append(stlSysParam.getTypeCode());
            keyOne.append(".");
            keyOne.append(stlSysParam.getParamCode());
            if (map.containsKey(keyOne.toString())) {
                List<StlSysParam> listTmp = map.get(keyOne.toString());
                listTmp.add(stlSysParam);
            } else {
                List<StlSysParam> listTmp = new ArrayList<StlSysParam>();
                listTmp.add(stlSysParam);
                map.put(keyOne.toString(), listTmp);
            }

            StringBuilder keyTwo = new StringBuilder(keyOne);
            keyTwo.append(".");
            keyTwo.append(stlSysParam.getColumnValue());

            if (map.containsKey(keyTwo.toString())) {
                List<StlSysParam> listTmp = map.get(keyTwo.toString());
                listTmp.add(stlSysParam);
            } else {
                List<StlSysParam> listTmp = new ArrayList<StlSysParam>();
                listTmp.add(stlSysParam);
                map.put(keyTwo.toString(), listTmp);
            }
        }
        for (Entry<String, List<StlSysParam>> entry : map.entrySet()) {
        	RedisUtil.getCacheClient().hset(SmcCacheConstant.NameSpace.SYS_PARAM_CACHE, entry.getKey(),
                    JSON.toJSONString(entry.getValue()));
        }
    }

}

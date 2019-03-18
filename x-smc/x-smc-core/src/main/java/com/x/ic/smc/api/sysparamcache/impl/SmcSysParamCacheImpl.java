package com.x.ic.smc.api.sysparamcache.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.x.sdk.util.BeanUtils;
import com.x.sdk.util.CollectionUtil;
import com.x.sdk.util.StringUtil;
import com.x.ic.smc.api.sysparamcache.interfaces.ISmcSysParamCache;
import com.x.ic.smc.api.sysparamcache.param.GetSysParamDescRequest;
import com.x.ic.smc.api.sysparamcache.param.GetSysParamListRequest;
import com.x.ic.smc.api.sysparamcache.param.GetSysParamRequest;
import com.x.ic.smc.api.sysparamcache.param.SmcSysParam;
import com.x.ic.smc.dao.mapper.bo.StlSysParam;
import com.x.ic.smc.util.SysParamUtil;
import com.alibaba.dubbo.config.annotation.Service;

@Service
@Component
public class SmcSysParamCacheImpl implements ISmcSysParamCache {
	
	private static final String PUB="PUB";

	@Override
	public List<SmcSysParam> getSysParams(GetSysParamListRequest request) {
		List<SmcSysParam> res=new ArrayList<SmcSysParam>();
		String tenantId=request.getTenantId();
        String typeCode= request.getTypeCode();
        String paramCode = request.getParamCode();
        List<StlSysParam> cacheList=SysParamUtil.getSysParams(tenantId, typeCode, paramCode);
		if(CollectionUtil.isEmpty(cacheList)){
			cacheList=SysParamUtil.getSysParams(PUB, typeCode, paramCode);
		}
		if(!CollectionUtil.isEmpty(cacheList)){
			for(StlSysParam cache:cacheList){
				SmcSysParam param=new SmcSysParam();
				BeanUtils.copyProperties(param, cache);
				res.add(param);
			}
		}
		return res;
	}

	@Override
	public SmcSysParam getSysParam(GetSysParamRequest request) {
		SmcSysParam res=new SmcSysParam();
		String tenantId=request.getTenantId();
        String typeCode= request.getTypeCode();
        String paramCode = request.getParamCode();
        String columnValue = request.getColumnValue();
        StlSysParam cache=SysParamUtil.getSysParam(tenantId, typeCode, paramCode, columnValue );
		if(cache==null){
			cache=SysParamUtil.getSysParam(PUB, typeCode, paramCode, columnValue);
		}
		if(cache!=null){
			BeanUtils.copyProperties(res, cache);
		}
		return res;
	}

	@Override
	public String getSysParamDesc(GetSysParamDescRequest request) {
	    String tenantId=request.getTenantId();
        String typeCode= request.getTypeCode();
        String paramCode = request.getParamCode();
        String columnValue = request.getColumnValue();
		String res=SysParamUtil.getSysParamDesc(tenantId, typeCode, paramCode, columnValue);
		if(StringUtil.isBlank(res)){
			res=SysParamUtil.getSysParamDesc(PUB, typeCode, paramCode, columnValue);
		}
		return res;
	}

}

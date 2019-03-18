package com.x.ic.smc.api.cacherefresh.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import com.x.base.exception.BusinessException;
import com.x.base.exception.SystemException;
import com.x.base.vo.BaseResponse;
import com.x.base.vo.ResponseHeader;
import com.x.ic.smc.api.cacherefresh.interfaces.ICacheRefreshSV;
import com.x.ic.smc.constants.SmcExceptCodeConstant;
import com.x.ic.smc.util.SmcCacheUtil;
import com.alibaba.dubbo.config.annotation.Service;

@Service
public class CacheRefreshSVImpl implements ICacheRefreshSV {
    private static final Logger LOGGER = LogManager.getLogger(CacheRefreshSVImpl.class);

    @Autowired
    private transient ApplicationContext context;

    public BaseResponse refresh() throws BusinessException, SystemException {
        LOGGER.info("开始刷新mcs缓存...");
        SmcCacheUtil.refreshMcs(context);
        LOGGER.info("刷新mcs缓存结束");
        BaseResponse response = new BaseResponse();
        response.setResponseHeader(new ResponseHeader(true, SmcExceptCodeConstant.SUCCESS, "成功"));
        return response;
    }

}

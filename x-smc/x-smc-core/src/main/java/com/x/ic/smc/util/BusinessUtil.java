package com.x.ic.smc.util;

import java.sql.Timestamp;
import java.util.Calendar;

import com.x.base.exception.BusinessException;
import com.x.base.exception.SystemException;
import com.x.base.vo.BaseInfo;
import com.x.base.vo.RequestHeader;
import com.x.sdk.util.StringUtil;
import com.x.ic.smc.constants.SmcExceptCodeConstant;
import com.x.ic.smc.util.vo.TimeDefference;

/**
 * 业务校验工具类<br>
 * Date: 2015年8月12日 <br>
 * Copyright (c) 2015 asiainfo.com <br>
 * 
 * @author mayt
 */
public final class BusinessUtil {

    private BusinessUtil() {
    }

    /**
     * 报文头校验<br>
     * 
     * @param requestHeader
     * @author mayt
     * @throws BusinessException
     * 
     */
    public static void checkRequestHeader(RequestHeader requestHeader) throws BusinessException {
        if (requestHeader == null) {
            throw new BusinessException(SmcExceptCodeConstant.PARAM_IS_NULL, "[请求报文头为空]");
        }
//        if (StringUtil.isBlank(requestHeader.getApplyChlId())) {
//            throw new BusinessException(SmcExceptCodeConstant.PARAM_IS_NULL, "[报文头渠道ID为空]");
//        }
        if (StringUtil.isBlank(requestHeader.getSystemId())) {
            throw new BusinessException(SmcExceptCodeConstant.PARAM_IS_NULL, "[报文头系统ID为空]");
        }
//        if (requestHeader.getOperId() == null || requestHeader.getOperId() == 0) {
//            throw new BusinessException(SmcExceptCodeConstant.PARAM_IS_NULL, "[报文头操作员ID为空]");
//        }
    }

    /**
     * 租户信息校验<br>
     * 
     * @param baseInfo
     * @author rui
     * @throws BusinessException
     * @ApiDocMethod
     */
    public static void checkBaseInfo(BaseInfo baseInfo) throws BusinessException {
        if (null == baseInfo) {
            throw new BusinessException(SmcExceptCodeConstant.PARAM_IS_NULL, "[请求报文]为空");
        }
        if (StringUtil.isBlank(baseInfo.getTenantId())) {
            throw new BusinessException(SmcExceptCodeConstant.PARAM_IS_NULL, "[租户ID]为空");
        }
    }

    public static TimeDefference getTimeDefference(Timestamp startTime, Timestamp endTime)
            throws SystemException {
        if (startTime.after(endTime)) {
            throw new SystemException("参数不合法");
        }
        Calendar calS = Calendar.getInstance();

        java.util.Date startDate = startTime;
        java.util.Date endDate = endTime;
        calS.setTime(startDate);
        int startY = calS.get(Calendar.YEAR);
        int startM = calS.get(Calendar.MONTH);
        int startD = calS.get(Calendar.DATE);
        int startDayOfMonth = calS.getActualMaximum(Calendar.DAY_OF_MONTH);

        calS.setTime(endDate);
        int endY = calS.get(Calendar.YEAR);
        int endM = calS.get(Calendar.MONTH);
        int endD = calS.get(Calendar.DATE) + 1;
        int endDayOfMonth = calS.getActualMaximum(Calendar.DAY_OF_MONTH);

        int lday = endD - startD;
        if (lday < 0) {
            endM = endM - 1;
            lday = startDayOfMonth + lday;
        }
        if (lday == endDayOfMonth) {
            endM = endM + 1;
            lday = 0;
        }
        int mos = (endY - startY) * 12 + (endM - startM);
        int lyear = mos / 12;
        int lmonth = mos % 12;
        TimeDefference timeDefference = new TimeDefference();
        timeDefference.setDay(lday);
        timeDefference.setMonth(lmonth);
        timeDefference.setYear(lyear);
        return timeDefference;
    }

}

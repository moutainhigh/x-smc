package com.x.smc.preprocess.topology.core.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

import com.x.smc.preprocess.topology.core.constant.SmcConstants;

public class DateUtil {

	
	public static Timestamp getFirstDay(String inDate,String inputFormat) throws ParseException{
		SimpleDateFormat df = new SimpleDateFormat(inputFormat);
		Date date = df.parse(inDate);
		Calendar calendar = Calendar.getInstance();
	    calendar.setTime(date);
	    calendar.add(Calendar.MONTH, 0);
	    calendar.set(Calendar.DAY_OF_MONTH,1);
	    //Date theDate = calendar.getTime();
	    return new Timestamp(calendar.getTimeInMillis());
	}
	
	public static Timestamp getLastDay(String inDate,String inputFormat) throws ParseException{
		SimpleDateFormat df = new SimpleDateFormat(inputFormat);
		Date date = df.parse(inDate);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
	    return new Timestamp(calendar.getTimeInMillis());
	}
	
	/**
	 * 根据日期和单位获得相应时间段后的日期
	 * @return
	 */
	public static Timestamp getTimeByUnit(Timestamp startTime, String timeUnit, int timeValue){
		
		 Calendar calendar = Calendar.getInstance();
		 calendar.setTime(startTime);
		 
		 if(StringUtils.equals(SmcConstants.TimeUnit.HOUR, timeUnit)){
			 calendar.add(Calendar.HOUR, timeValue);
		 }else if(StringUtils.equals(SmcConstants.TimeUnit.DAY, timeUnit)){
			 calendar.add(Calendar.DATE, timeValue);
		 }else if(StringUtils.equals(SmcConstants.TimeUnit.WEEK, timeUnit)){
			 calendar.add(Calendar.DATE, timeValue*7);
		 }else if(StringUtils.equals(SmcConstants.TimeUnit.MONTH, timeUnit)){
			 calendar.add(Calendar.MONTH, timeValue);
		 }else if(StringUtils.equals(SmcConstants.TimeUnit.QUARTER, timeUnit)){
			 calendar.add(Calendar.MONTH, timeValue*3);
		 }else if(StringUtils.equals(SmcConstants.TimeUnit.YEAR, timeUnit)){
			 calendar.add(Calendar.YEAR, timeValue);
		 }
		 return new Timestamp(calendar.getTimeInMillis());
	}
	
	/**
	 * 判断两个日期之前的时间差 ，时间单位 周 年 月 天
	 * @param startTime
	 * @param endTime
	 * @param timeUnit  
	 * @return
	 */
	public static int timeUnitOffset(Timestamp startTime, Timestamp endTime, String timeUnit) {
		if(StringUtils.equals(SmcConstants.TimeUnit.DAY, timeUnit)){
			return calcDayOffset(startTime, endTime);
		}else if(StringUtils.equals(SmcConstants.TimeUnit.WEEK, timeUnit)){
			return calcWeekOffset(startTime, endTime);
		}else if(StringUtils.equals(SmcConstants.TimeUnit.MONTH, timeUnit)){
			return calcMonthOffset(startTime, endTime);
		}else if(StringUtils.equals(SmcConstants.TimeUnit.YEAR, timeUnit)) {
			return calcYearOffset(startTime, endTime);
		}
		return -1;
	}
	
    /**
     * 计算两个日期相差周数
     * @param startTime
     * @param endTime
     * @return
     */
    public static int calcWeekOffset(Timestamp startTime, Timestamp endTime) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(startTime);
        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        dayOfWeek = dayOfWeek - 1;
        if (dayOfWeek == 0) dayOfWeek = 7;
 
        int dayOffset = calcDayOffset(startTime, endTime);
 
        int weekOffset = dayOffset / 7;
        int a;
        if (dayOffset > 0) {
            a = (dayOffset % 7 + dayOfWeek > 7) ? 1 : 0;
        } else {
            a = (dayOfWeek + dayOffset % 7 < 1) ? -1 : 0;
        }
        weekOffset = weekOffset + a;
        return Math.abs(weekOffset);
    }
    
    /**
     * 计算两个日期相差天数
     * @param startTime
     * @param endTime
     * @return
     */
    public static int calcDayOffset(Timestamp startTime, Timestamp endTime) {
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(startTime);
 
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(endTime);
        int day1 = cal1.get(Calendar.DAY_OF_YEAR);
        int day2 = cal2.get(Calendar.DAY_OF_YEAR);
 
        int year1 = cal1.get(Calendar.YEAR);
        int year2 = cal2.get(Calendar.YEAR);
        if (year1 != year2) {  //同一年
            int timeDistance = 0;
            for (int i = year1; i < year2; i++) {
                if (i % 4 == 0 && i % 100 != 0 || i % 400 == 0) {  //闰年
                    timeDistance += 366;
                } else {  //不是闰年
                    timeDistance += 365;
                }
            }
            return Math.abs(timeDistance + (day2 - day1));
        } else { //不同年
            return Math.abs(day2 - day1);
        }
    }
    
    /**
     * 计算两个日期相差的月份
     * @param startTime
     * @param endTime
     * @return
     */
    public static int calcMonthOffset(Timestamp startTime, Timestamp endTime){
        int result = 0;
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        c1.setTime(startTime);
        c2.setTime(endTime);
        result =  (c2.get(Calendar.YEAR)-c1.get(Calendar.YEAR))*12 + c2.get(Calendar.MONTH) - c1.get(Calendar.MONTH);
        return Math.abs(result);
    }
    
    public static int calcYearOffset(Timestamp startTime, Timestamp endTime) {
    	 	Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        c1.setTime(startTime);
        c2.setTime(endTime);
        return Math.abs(c2.get(Calendar.YEAR)-c1.get(Calendar.YEAR));
    }
}

package com.x.smc.bill.util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import com.x.base.exception.SystemException;
import com.x.sdk.util.StringUtil;
import com.x.smc.bill.constants.BillConstants;

/**
 * 时间格式化工具
 */
public class DateUtils {

	private static final Logger logger = Logger.getLogger(DateUtils.class);
	
	public static final String DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    public static final String DATE_FORMAT = "yyyy-MM-dd";

    public static final String YYYYMMDD = "yyyyMMdd";

    public static final String YYYYMM = "yyyyMM";

    public static final String YYYYMMDDHHMM = "yyyyMMddHHmm";

    public static final String YYYYMMDDHHMMSS = "yyyyMMddHHmmss";

    public static final String yyyyMMddHHmmssSSS = "yyyyMMddHHmmssSSS";
	
	private DateUtils(){}

	/**
	 * 返回时间的Timestamp实例
	 * @param date
	 * @return
     */
	public static Timestamp toTimeStamp(Date date){
		return date==null?null:new Timestamp(date.getTime());
	}

	public static Timestamp getTimestamp(String str,String pattern) {
		Timestamp result = null;
		SimpleDateFormat formatter = new SimpleDateFormat(pattern);
		try {
			return new Timestamp(formatter.parse(str).getTime());
		} catch (ParseException e) {
			logger.error("" ,e);
		}
		return result;
	}
	
	/**
     * 获取系统时间
     * 
     * @return
     */
	public static String getCurrentTime() throws SystemException {
        return getDateString(DATETIME_FORMAT);
    }
	
	/**
     * 获取系统时间
     * 
     * @return
     */
    public static Timestamp getSysDate() {
        return new Timestamp(System.currentTimeMillis());
    }
	
	/**
     * 根据指定的格式输入时间字符串
     * 
     * @param pattern
     * @return
     * @throws SystemException 
     */
    public static String getDateString(String pattern) throws SystemException {
        if (StringUtil.isBlank(pattern)) {
            throw new SystemException("请指定日期格式");
        }
        Timestamp time = getSysDate();
        DateFormat dfmt = new SimpleDateFormat(pattern);
        java.util.Date date = time;
        return dfmt.format(date);
    }

	/**
	 * 对时间进行格式化
	 * @param date
	 * @param pattern
     * @return
     */
	public static String format(Date date, String pattern){
		SimpleDateFormat formatter = new SimpleDateFormat(pattern);
		return formatter.format(date);
	}
	
	public static String getCurrMonth(){
		return format(new Date(),"yyyyMM");
	}
	
	public static Timestamp currTimeStamp(){
		return new Timestamp(System.currentTimeMillis());
	}

	/**
	 * 获取每月的开始,第一天零点零分零秒
	 *
	 * @param month yyyyMM
	 * @return
     */
	public static Timestamp getSartOfMonth(String month){
		String startStr = month+"01000000";
		Timestamp result = null;
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
		try {
			return new Timestamp(formatter.parse(startStr).getTime());
		} catch (ParseException e) {
			logger.error("" ,e);
		}
		return result;
	}

	/**
	 * 
	* @Title: monthsAdd 
	* @Description:
	* @param @param montstr
	* @param @param interval
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	public static String monthsAdd(String montstr,int interval){
		String yyyy = montstr.substring(0,4);
		String mm = montstr.substring(4,6);
		int diffyear ;
		int desMonth ;
		int norimonth = Integer.parseInt(mm);

		//原写法
        /*if ((norimonth + interval) > 0){
        	if ((norimonth + interval)%12 == 0){
				 diffyear = (norimonth + interval)/12 - 1;
				 desMonth = (norimonth + interval)%12 + 12;
        	}else{
				 diffyear = (norimonth + interval)/12;
				 desMonth = (norimonth + interval)%12;
        	}
        }else{
			 diffyear = (norimonth + interval)/12 - 1;
			 desMonth = (norimonth + interval)%12 + 12;
        }*/
		//改造后代码
		if ((norimonth + interval) > 0 && (norimonth + interval)%12 != 0){
			diffyear = (norimonth + interval)/12;
			desMonth = (norimonth + interval)%12;
		}else{
			diffyear = (norimonth + interval)/12 - 1;
			desMonth = (norimonth + interval)%12 + 12;
		}

		int ndesYear = Integer.parseInt(yyyy) + diffyear;
		String sdesmonth = Integer.toString(desMonth);
        if (desMonth<10){
        	sdesmonth = "0" + sdesmonth;
        }
        return Integer.toString(ndesYear) + sdesmonth;
	}
	
	/**
	 * 计算连个时间之间月份差值
	* @Title: monthDiffs
	* @param @param fisMonth
	* @param @param secMonth
	* @param @return    设定文件 
	* @return Integer    返回类型 
	* @throws
	 */

	public static Integer monthDiffs(String fisMonth,String secMonth){
		int nfstyyyy = Integer.parseInt(fisMonth.substring(0,4));
		int nfstMonth =  Integer.parseInt(fisMonth.substring(4,6));
		
		int nsecyyyy = Integer.parseInt(secMonth.substring(0,4));
		int nsecMonth = Integer.parseInt(secMonth.substring(4,6));
	
		int nMonth = nsecMonth -  nfstMonth;
		
		return (nsecyyyy - nfstyyyy)*12 + nMonth;
	}

	public static java.sql.Date getNowDate() {
		return new java.sql.Date(new Date().getTime());
	}
	
	/**
	 * 根据日期和单位获得相应时间段后的日期
	 * @return
	 */
	public static Timestamp getTimeByUnit(Timestamp startTime, String timeUnit, int timeValue){
		
		 Calendar calendar = Calendar.getInstance();
		 calendar.setTime(startTime);
		 
		 if(StringUtils.equals(BillConstants.TimeUnit.HOUR, timeUnit)){
			 calendar.add(Calendar.HOUR, timeValue);
		 }else if(StringUtils.equals(BillConstants.TimeUnit.DAY, timeUnit)){
			 calendar.add(Calendar.DATE, timeValue);
		 }else if(StringUtils.equals(BillConstants.TimeUnit.WEEK, timeUnit)){
			 calendar.add(Calendar.DATE, timeValue*7);
		 }else if(StringUtils.equals(BillConstants.TimeUnit.MONTH, timeUnit)){
			 calendar.add(Calendar.MONTH, timeValue);
		 }else if(StringUtils.equals(BillConstants.TimeUnit.QUARTER, timeUnit)){
			 calendar.add(Calendar.MONTH, timeValue*3);
		 }else if(StringUtils.equals(BillConstants.TimeUnit.YEAR, timeUnit)){
			 calendar.add(Calendar.YEAR, timeValue);
		 }
		 return new Timestamp(calendar.getTimeInMillis());
	}
}

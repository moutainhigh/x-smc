package com.x.smc.bill.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Timestamp;

import org.apache.commons.lang3.StringUtils;

import com.x.base.exception.SystemException;
import com.x.sdk.util.StringUtil;

public class DstBeanUtils {

	private DstBeanUtils(){};
	
	/**
     * 拷贝VO对象属性，只拷贝基础属性
     * 
     * @param dest
     * @param orign
     * @
     */
    public static void copyVO(Object destSVO, Object orignSVO) {
        /* 1.源对象与目标对象都不能为空 */
        if (destSVO == null || orignSVO == null) {
            throw new SystemException("拷贝VO属性值出错:源对象为空或目标对象为空");
        }
        /* 2.获取目标对象所有字段 */
        Field[] fields = destSVO.getClass().getDeclaredFields();
        if (fields == null || fields.length == 0) {
            return;
        }
        /* 3.依次拷贝每个字段取值 */
        for (Field field : fields) {
            String fieldName = field.getName();
            String fieldType = field.getType().getName();
            if (!"serialVersionUID".equals(fieldName)) {
                try {
                    boolean has = hasProperty(orignSVO, fieldName);
                    if (has) {
                        Field orignfield = orignSVO.getClass().getDeclaredField(fieldName);
                        String orignFieldType = orignfield.getType().getName();
                        if (orignFieldType.equals(fieldType)) {
                            Object orignValue = getVoFieldValue(orignSVO, fieldName);
                            setVoFieldValue(destSVO, fieldName, orignValue);
                        }else if(StringUtils.equals("java.lang.Long", orignFieldType) && StringUtils.equals("java.sql.Timestamp", fieldType)){
                        	Object orignValue = getVoFieldValue(orignSVO, fieldName);
                        	if(orignValue!=null){
                        		setVoFieldValue(destSVO, fieldName, new Timestamp((long)orignValue));
                        	}
                        }else if(StringUtils.equals("java.sql.Timestamp", orignFieldType) && StringUtils.equals("java.lang.Long", fieldType)){
                        	Object orignValue = getVoFieldValue(orignSVO, fieldName);
                        	if(orignValue!=null){
                        		setVoFieldValue(destSVO, fieldName, ((Timestamp) orignValue).getTime());
                        	}
                        }
                    }
                } catch (SecurityException e) {
                    throw new SystemException("拷贝VO属性值出错:SecurityException", e);
                } catch (NoSuchFieldException e) {
                    throw new SystemException("拷贝VO属性值出错:NoSuchFieldException", e);
                } catch (IllegalArgumentException e) {
                    throw new SystemException("拷贝VO属性值出错:IllegalArgumentException", e);
                }

            }
        }
    }
    
    /**
     * 获取VO指定属性值
     * 
     * @param object
     * @param fieldName
     * @return @
     */
    public static Object getVoFieldValue(Object object, String fieldName) {
        try {
            if (object == null || StringUtil.isBlank(fieldName)) {
                throw new SystemException("底层获取对象指定属性值出错,、对象为空或者指定字段为空");
            }
            String getmethodstr = "get" + setUpperCaseForFirstLetter(fieldName);
            Method getmethod = object.getClass().getMethod(getmethodstr);
            return getmethod.invoke(object);
        } catch (Exception ex) {
            String retMsg = ex.getCause() == null ? ex.getMessage() : ex.getCause().getMessage();
            throw new SystemException("系统错误[BeanCopyUtil.getVoFieldValue]:" + retMsg, ex);
        }
    }

    /**
     * 设定VO指定属性值
     * 
     * @param object
     * @param fieldName
     * @param fieldValue
     * @
     */
    public static void setVoFieldValue(Object object, String fieldName, Object fieldValue) {
        try {
            if (object == null || StringUtil.isBlank(fieldName)) {
                throw new SystemException("设置对象指定属性值出错,对象为空或者指定字段为空");
            }
            String setmethodstr = "set" + setUpperCaseForFirstLetter(fieldName);
            String getmethodstr = "get" + setUpperCaseForFirstLetter(fieldName);
            Method getmethod = object.getClass().getMethod(getmethodstr);
            Method setmethod = object.getClass().getMethod(setmethodstr, getmethod.getReturnType());
            setmethod.invoke(object, fieldValue);
        } catch (Exception ex) {
            String retMsg = ex.getCause() == null ? ex.getMessage() : ex.getCause().getMessage();
            throw new SystemException("系统错误[BeanCopyUtil.setVoFieldValue]:" + retMsg, ex);
        }
    }
    
    /**
     * 对象是否存在指定属性
     * 
     * @param object
     * @param fieldName
     * @return
     */
    public static boolean hasProperty(Object object, String fieldName) {
        Field[] fields = object.getClass().getDeclaredFields();
        if (fields == null || fields.length == 0) {
            return false;
        }
        for (Field field : fields) {
            String fieldN = field.getName();
            if (fieldN.equals(fieldName)) {
                return true;
            }
        }
        return false;
    }
    
    public static String setUpperCaseForFirstLetter(String name) {
        if (name.length() == 1) {
            return name.toUpperCase();
        }
        String firstLetter = name.substring(0, 1);
        String others = name.substring(1, name.length());
        return firstLetter.toUpperCase() + others;
    }
}

package com.x.ic.dshm.util;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class ApplicationContextUtil {
	private static final Logger log =LoggerFactory.getLogger(ApplicationContextUtil.class);
	//private static final Log log = LogFactory.getLog(ApplicationContextUtil.class);
	private static ApplicationContextUtil instance = null;
	private static ApplicationContext context = null;
	private static boolean finished = false;
	
	private ApplicationContextUtil(){}
	
	public static ApplicationContextUtil getInstance(){
		if(instance == null){
			synchronized(ApplicationContextUtil.class){
				if(instance == null){
					instance = new ApplicationContextUtil();
					loadResource();
				}
			}
		}
		return instance;
	}
	
	private static void loadResource(){
		//System.out.println("ApplicationContext 开始加载...!");
		context = new ClassPathXmlApplicationContext("classpath:context/core-context.xml");
		log.debug("ApplicationContext 已加载完成!");
		finished = true;
	}
	
	public Object getBean(String beanName) {
		if (beanName != null && !"".equals(beanName)) {
			return context.getBean(beanName);
		}
		return null;
	}
	
	/**
	 * 同步等待context加载完成
	 */
	public void syncWaitForLoading(){
		while(!finished){
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				log.error("context",e);
			}
		}
	}
	
}

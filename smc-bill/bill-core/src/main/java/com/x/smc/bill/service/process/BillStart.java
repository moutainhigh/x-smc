package com.x.smc.bill.service.process;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.x.base.exception.SystemException;
import com.x.smc.bill.util.PropertiesUtil;

public class BillStart {
	private static Logger logger = LoggerFactory.getLogger(BillStart.class);
	
	public void start(){
		logger.info("初始化资源....");
		try{
			PropertiesUtil.load("context/bill-core.properties");
			logger.info("读取配置文件成功........");
			ThreadPoolInit.create();
			logger.info("线程池初始化成功........");
			ProcessHandler.initProcessHandler();
			logger.info("消费队列初始化成功........");
		}catch(Exception e){
			logger.error("context", e);
			logger.debug("[资源加载失败...]");
			throw new SystemException("000001","[资源加载失败...]");
		}
		logger.debug("资源加载成功........");
	}
}

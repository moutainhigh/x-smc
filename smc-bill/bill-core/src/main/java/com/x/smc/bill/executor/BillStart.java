package com.x.smc.bill.executor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.x.base.exception.SystemException;
import com.x.smc.bill.service.process.ProcessHandler;
import com.x.smc.bill.service.process.ThreadPoolInit;
import com.x.smc.bill.util.PropertiesUtil;

/**
 * 工程启动时需要初始化的方法，
 * 初始化线程，加载配置文件
 * @author wangluyang
 *
 */
public class BillStart {

	private static Logger logger=LoggerFactory.getLogger(BillStart.class);
	
	public void start() {
		logger.debug("初始化资源....");
		try{
			runTool();
		}catch(Exception e){
			logger.error("context", e);
			logger.debug("[资源加载失败...]");
			throw new SystemException("000001","[资源加载失败...]");
		}
		logger.debug("资源加载成功........");
	}
	
	private void runTool() {
		PropertiesUtil.load("context/bill-core.properties");
		logger.debug("读取配置文件成功........");
		ThreadPoolInit.create();
		logger.debug("线程池创建成功......");
		ProcessHandler processHandler = new ProcessHandler();
		processHandler.start();
		logger.debug("任务处理器启动成功......");
	}
}

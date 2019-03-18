package com.x.smc.bill.service.process;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;

import com.x.smc.bill.util.PropertiesUtil;

public class ThreadPoolInit {
	private static int corePoolSize;
	private static int maxPoolSize;
	private static int keepAliveTime;
	private static int blockingQueueSize;
	private static ThreadPoolExecutor executor;
	
	private ThreadPoolInit(){
	}
	
	static{
		String strCorePoolSize = PropertiesUtil.getValue("ctp.bill.executor.corePoolSize");
		if(StringUtils.isNotBlank(strCorePoolSize)){
			corePoolSize = Integer.parseInt(strCorePoolSize);
		}
		String strMaxPoolSize = PropertiesUtil.getValue("ctp.bill.executor.maxPoolSize");
		if(StringUtils.isNotBlank(strMaxPoolSize)){
			maxPoolSize = Integer.parseInt(strMaxPoolSize);
		}
		String strKeepAliveTime = PropertiesUtil.getValue("ctp.bill.executor.keepAliveTime");
		if(StringUtils.isNotBlank(strKeepAliveTime)){
			keepAliveTime = Integer.parseInt(strKeepAliveTime);
		}
		String strBlockingQueueSize = PropertiesUtil.getValue("ctp.bill.executor.blockingQueueSize");
		if(StringUtils.isNotBlank(strBlockingQueueSize)){
			blockingQueueSize = Integer.parseInt(strBlockingQueueSize);
		}
	}
	
	public static void create(){
		if(executor == null){
			synchronized(ThreadPoolInit.class){
				if(executor == null){
					init();
				}
			}
		}
	}
	
	private static void init(){
		BlockingQueue<Runnable> queue = new ArrayBlockingQueue<Runnable>(blockingQueueSize);
		executor = new ThreadPoolExecutor(
				corePoolSize, 
				maxPoolSize, 
				keepAliveTime, 
				TimeUnit.SECONDS, queue,
				new ThreadPoolExecutor.CallerRunsPolicy());
	}
	
	public static void execute(Runnable runnable){
		executor.execute(runnable);
	}
}

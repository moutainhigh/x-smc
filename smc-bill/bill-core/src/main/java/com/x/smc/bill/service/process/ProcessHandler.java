package com.x.smc.bill.service.process;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.x.smc.bill.dao.mapper.bo.StlCalDataRecord;

/**
 * 账单处理类
 * @author wangluyang
 *
 */
public class ProcessHandler extends LoopThread{
	
	private static Logger logger = LoggerFactory.getLogger(ProcessHandler.class);
	public static BlockingQueue<StlCalDataRecord> billTaskQueue = new LinkedBlockingQueue<StlCalDataRecord>(1000);
	public static ProcessHandler processHandler = new ProcessHandler();
	
	public static void initProcessHandler() {
		if(processHandler==null) {
			synchronized (ProcessHandler.class) {
				processHandler = new ProcessHandler();
			}
		}
		processHandler.start();
	}
	
	@Override
	public boolean init() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean unInit() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void work() {
		// TODO Auto-generated method stub
		try {
			StlCalDataRecord record = billTaskQueue.take();
			logger.debug("the take billMessage is "+JSONObject.toJSONString(record));
			BillCalThread runnable = new BillCalThread(record);
			ThreadPoolInit.execute(runnable);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

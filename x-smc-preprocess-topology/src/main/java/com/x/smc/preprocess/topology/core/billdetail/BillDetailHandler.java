package com.x.smc.preprocess.topology.core.billdetail;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.x.smc.preprocess.topology.core.bo.BillDetailVo;
import com.x.storm.util.LoopThread;

public class BillDetailHandler extends LoopThread{

	private static Logger logger = LoggerFactory.getLogger(BillDetailHandler.class);
	private static BlockingQueue<BillDetailVo> msgQueue = new LinkedBlockingQueue<BillDetailVo>();
    private BillDetailDao billDetailDao = new BillDetailDao();
    private static BillDetailHandler billDetailHandler;
    
    /**
	 * 启动错单处理器
	 */
	public static void startup(){
		if(billDetailHandler == null){
			synchronized(BillDetailHandler.class){
				if(billDetailHandler == null){
					billDetailHandler = new BillDetailHandler();
					billDetailHandler.start();
					System.out.println("结算详单处理器启动中...");
					logger.debug("结算详单处理器启动中...");
				}
			}
		}
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
		BillDetailVo element = null;
		try{
			element = msgQueue.take();
		}catch(InterruptedException e){
			logger.error("context", e);
			exitFlag = true;
		}
		billDetailDao.insertBillDetailData(element);
	}
	
	/**
	 * 插入错单数据到队列
	 * @param data
	 * @param failStep
	 * @param failCode
	 * @param failReason
	 */
	public static void addBillDetailMsg(BillDetailVo detailVo){
		if(detailVo == null){
			return;
		}
		msgQueue.add(detailVo);
	}

}

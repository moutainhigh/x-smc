package com.x.smc.bill.service.task;

import java.sql.Timestamp;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONObject;
import com.x.sdk.util.CollectionUtil;
import com.x.smc.bill.constants.BillConstants;
import com.x.smc.bill.dao.mapper.bo.StlCalDataRecord;
import com.x.smc.bill.service.atom.interfaces.IStlCalDataRecordAtomSV;
import com.x.smc.bill.service.process.ProcessHandler;

/**
 * 定时遍历表，并找出当
 * 前时间大于等于next_precess_date 并且处于未处理状态的数据的数据
 * @author wangluyang
 *
 */
@Component
@Transactional
public class BillDataProcessTask {

	private static final Logger logger = LoggerFactory.getLogger(BillDataProcessTask.class);
	
	@Autowired
	private IStlCalDataRecordAtomSV calDataRecordAtomSV;
	
	/**
	 * 遍历stl_cal_data_record表，每30分钟执行一次
	 */
	@Scheduled(cron = "0/10 * * * * ?")
	public void process() {
		
		Timestamp currentTime = new Timestamp(System.currentTimeMillis());
		List<StlCalDataRecord> records = this.calDataRecordAtomSV.queryProcessData(null, BillConstants.RunStatus.FREE,
				BillConstants.Status.EFFECTIVE, currentTime);
		if(!CollectionUtil.isEmpty(records)) {
			for(StlCalDataRecord dataRecord:records) {
				try {
					ProcessHandler.billTaskQueue.put(dataRecord);
					this.calDataRecordAtomSV.updateRunStateByRecord(dataRecord.getRecordId(), BillConstants.RunStatus.RUNNING);
					logger.info("队列中放的message:"+JSONObject.toJSONString(dataRecord));
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}

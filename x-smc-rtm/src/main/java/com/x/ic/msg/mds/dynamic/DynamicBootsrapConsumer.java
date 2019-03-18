package com.x.ic.msg.mds.dynamic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.x.ic.msg.constants.SmcConstants;
import com.x.ic.msg.dao.mapper.bo.MdsConsumerMapped;
import com.x.ic.msg.dao.mapper.bo.MdsConsumerMappedExample;
import com.x.ic.msg.dao.mapper.interfaces.MdsConsumerMappedMapper;
import com.x.ic.msg.mds.factory.DynamicMdsClientFactory;
import com.x.ic.msg.mds.handler.MsgProcessorHandler;
import com.x.ic.msg.service.busi.interfaces.IMdsConsumerCfgSV;
import com.x.ic.msg.service.busi.interfaces.ITopicSupportSV;
import com.x.sdk.component.mds.IMessageConsumer;



@Component
public class DynamicBootsrapConsumer {
	
	@Autowired
	private IMdsConsumerCfgSV msdConsumerCfgSV;
	
	@Autowired
	private ITopicSupportSV supportSV;
	
	public void startConsumer(){
	
		List<MdsConsumerMapped> list = msdConsumerCfgSV.getConsumerMapped();
		
		for (MdsConsumerMapped mapped : list) {
			
			IMessageConsumer consumer = DynamicMdsClientFactory.getConsumerClient(mapped, new MsgProcessorHandler(supportSV), null);
			consumer.start();
			
		}
		
	}
	
}

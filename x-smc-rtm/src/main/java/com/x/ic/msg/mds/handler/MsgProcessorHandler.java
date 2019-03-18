package com.x.ic.msg.mds.handler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.x.ic.msg.mds.processor.MsgCommonsProcessor;
import com.x.ic.msg.service.busi.interfaces.ITopicSupportSV;
import com.x.sdk.component.mds.IMessageProcessor;
import com.x.sdk.component.mds.IMsgProcessorHandler;

public class MsgProcessorHandler implements IMsgProcessorHandler {
	
	private ITopicSupportSV supportSV;
	 
	public MsgProcessorHandler(ITopicSupportSV supportSV){
		this.supportSV = supportSV;
	}
	
	@Override
	public IMessageProcessor[] createInstances(int paramInt) {
		List<IMessageProcessor> processors = new ArrayList<>();
        IMessageProcessor processor;
        for (int i = 0; i < paramInt; i++) {
            processor = new MsgCommonsProcessor(supportSV);
            processors.add(processor);
        }
        return processors.toArray(new IMessageProcessor[processors.size()]);
	}

}

package com.x.ic.msg.mds.processor;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.alibaba.fastjson.JSON;
import com.x.ic.msg.service.busi.interfaces.ITopicSupportSV;
import com.x.ic.msg.vo.MessageData;
import com.x.sdk.component.mds.IMessageProcessor;
import com.x.sdk.component.mds.vo.MessageAndMetadata;

public class MsgCommonsProcessor implements IMessageProcessor {

	private static Logger log = LogManager.getLogger(MsgCommonsProcessor.class);
	
	ITopicSupportSV supportSV;
	public MsgCommonsProcessor(ITopicSupportSV supportSV){
		this.supportSV = supportSV;
	}
	
	@Override
	public void process(MessageAndMetadata message) throws Exception {

		
		
		MessageData messageData = MessageData.build(message);
		log.info("topicName:{}",messageData.getTopicName());
		log.info("createTime:{}",messageData.getCreateTime());
		log.info("messageId:{}",messageData.getMsgID());
		log.info("message:{}",messageData.getDataStr());
		
		supportSV.messageDispense(messageData);
		
	}

}

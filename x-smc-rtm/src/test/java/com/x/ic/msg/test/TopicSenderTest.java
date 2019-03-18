package com.x.ic.msg.test;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.UUID;

import com.alibaba.fastjson.JSONObject;
import com.x.sdk.component.mds.IMessageSender;
import com.x.sdk.component.mds.MDSClientFactory;
import com.x.sdk.mds.vo.BusinessMessage;

public class TopicSenderTest {
	static String[] devCustArr = new String[]{"101100","101101","101102","101103","101104","101105","101106","101107","101108","101109","1011061"};
	public static void main(String[] args) {
		for(int i=0;i<=99;i++){
			send();
		}
		

	}
	public static void send(){
		//RTM-CUSTREG-TEST-TOPIC
		IMessageSender sender = MDSClientFactory.getSenderClient("MAYT3-TEST-TOPIC");
		//RTM-ORDER-TEST-TOPIC
		//IMessageSender sender = MDSClientFactory.getSenderClient("MAYT3-TEST-TOPIC");
		BusinessMessage message = new BusinessMessage();
		
		JSONObject json = new JSONObject();
		JSONObject data = new JSONObject();
		int index = (int)(Math.random()*10);
		data.put("devCust", devCustArr[index]);
		data.put("custCode", String.valueOf(Math.random()).substring(3, 8));
		data.put("regTime", System.currentTimeMillis());
		json.put("data", data);
		
		message.setBusiType("prod");
		message.setCreateTime(Timestamp.valueOf(LocalDateTime.now()));
		message.setMsgID(UUID.randomUUID().toString());
		message.setMsgVersion("1.0");
		message.setData(json.toJSONString());
		sender.send(message, System.currentTimeMillis()%2);
	}

}

package com.x.ic.msg.mds.send;

import java.util.Properties;

import com.x.sdk.component.mds.IMessageSender;
import com.x.sdk.component.mds.MDSClientFactory;
import com.x.sdk.component.mds.MsgSenderCmpFactory;

public class Test {

	public static void main(String[] args) {
//		IMessageSender sender =	MDSClientFactory.getSenderClient("MDS_NS_ORDER_MAYT3_TOPIC");
//		sender.send("vvttttttv", System.currentTimeMillis()%2);
		//dynamic
		Properties kafaProps = new Properties();
		kafaProps.put("kafka.zookeeper.broker.path", "/brokers");
		kafaProps.put("kafka.zookeeper.hosts", "172.16.8.28:39181");
		kafaProps.put("kafka.zookeeper.user", "");
		kafaProps.put("kafka.zookeeper.user.passwd", "");
		kafaProps.put("mds.consumer.base.path", "/baas/MDS/order/test");
		kafaProps.put("mds.topic", "order-consumer-topic");
		kafaProps.put("mds.zookeeper.hosts", "172.16.8.28:39181");

		String topic = "";
		MsgSenderCmpFactory.getClient(kafaProps, topic);
	}

}

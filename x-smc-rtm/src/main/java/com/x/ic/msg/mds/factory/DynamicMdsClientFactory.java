package com.x.ic.msg.mds.factory;

import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.x.ic.msg.dao.mapper.bo.MdsConsumerMapped;
import com.x.sdk.ccs.base.ConfigLoader;
import com.x.sdk.ccs.util.ConfigTool;
import com.x.sdk.component.mds.IMessageConsumer;
import com.x.sdk.component.mds.IMessageSender;
import com.x.sdk.component.mds.IMsgProcessorHandler;
import com.x.sdk.component.mds.MsgConsumerCmpFactory;
import com.x.sdk.component.mds.constants.MDSConsumerConstants;
import com.x.sdk.exception.SDKException;
import com.x.sdk.util.StringUtil;

public class DynamicMdsClientFactory {
	
	private static final Logger LOG = LoggerFactory.getLogger(DynamicMdsClientFactory.class);
	private static Map<String, IMessageConsumer> consumerMap = new ConcurrentHashMap<String, IMessageConsumer>();
	
	private DynamicMdsClientFactory(){};
	
	public static IMessageConsumer getConsumerClient(MdsConsumerMapped mdsConsumerMapped, IMsgProcessorHandler msgProcessorHandler,
				String consumerId) {
	    	if(StringUtil.isBlank(consumerId)){
	    		consumerId="consumer";
			}
	    	
			String mdsId = mdsConsumerMapped.getMdsId();
	        String appname = ConfigLoader.getApp();
			String topicId = mdsConsumerMapped.getMdsTopic();
	        String keyId=appname + "."+mdsId + "." + consumerId;
			
			IMessageConsumer client;
			try {
				if (!consumerMap.containsKey(keyId)) {
					Properties kafkaConsumerProp = new Properties();
					kafkaConsumerProp.put(MDSConsumerConstants.KAFKA_ZOOKEEPER_HOSTS, mdsConsumerMapped.getKafkaZookeeperHosts());
					kafkaConsumerProp.put(MDSConsumerConstants.KAFKA_ZOOKEEPER_BROKER_PATH, mdsConsumerMapped.getKafkaZookeeperBrokerPath());
					kafkaConsumerProp.put(MDSConsumerConstants.KAFKA_ZOOKEEPER_USER, mdsConsumerMapped.getKafkaZookeeperUser()==null?"":mdsConsumerMapped.getKafkaZookeeperUser());
					kafkaConsumerProp.put(MDSConsumerConstants.KAFKA_ZOOKEEPER_USER_PASSWD, mdsConsumerMapped.getKafkaZookeeperUserPasswd()==null?"":mdsConsumerMapped.getKafkaZookeeperUserPasswd());
					kafkaConsumerProp.put(MDSConsumerConstants.MDS_CONSUMER_BASE_PATH, mdsConsumerMapped.getMdsConsumerBasePath());
					kafkaConsumerProp.put(MDSConsumerConstants.MDS_ZOOKEEPER_HOSTS, mdsConsumerMapped.getMdsZookeeperHosts());
					kafkaConsumerProp.put(MDSConsumerConstants.MDS_TOPIC, mdsConsumerMapped.getMdsTopic());
					kafkaConsumerProp.put(MDSConsumerConstants.KAFKA_CONSUMER_ID, consumerId);
					
					String mdsConsumerBasePath = kafkaConsumerProp.getProperty(MDSConsumerConstants.MDS_CONSUMER_BASE_PATH);
					String newMdsConsumerBasePath = mdsConsumerBasePath+"/"+consumerId;
					
					kafkaConsumerProp.put(MDSConsumerConstants.KAFKA_CONSUMER_ID, consumerId);
					kafkaConsumerProp.put(MDSConsumerConstants.MDS_PARTITION_RUNNINGLOCK_PATH, newMdsConsumerBasePath+ "/partitions/running");
					kafkaConsumerProp.put(MDSConsumerConstants.MDS_PARTITION_PAUSELOCK_PATH, newMdsConsumerBasePath+ "/partitions/pause");
					kafkaConsumerProp.put(MDSConsumerConstants.MDS_PARTITION_OFFSET_BASEPATH, newMdsConsumerBasePath+ "/offsets");
					
					client = MsgConsumerCmpFactory.getClient(kafkaConsumerProp , topicId , msgProcessorHandler);
					consumerMap.put(keyId, client);
				}
				else{
					client = consumerMap.get(keyId);
				}
			} catch (Exception e) {
				throw new SDKException("无法获取消息服务[" + mdsId + "]对应的客户端实例", e);
			}
			return client;
		}
	
}

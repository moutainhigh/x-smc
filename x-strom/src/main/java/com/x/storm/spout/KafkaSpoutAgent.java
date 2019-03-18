package com.x.storm.spout;

import java.util.Arrays;
import java.util.Map;
import java.util.UUID;

import com.x.storm.util.BaseConstants;

import storm.kafka.BrokerHosts;
import storm.kafka.KafkaSpout;
import storm.kafka.SpoutConfig;
import storm.kafka.StringScheme;
import storm.kafka.ZkHosts;
import backtype.storm.spout.SchemeAsMultiScheme;

public class KafkaSpoutAgent {
	private KafkaSpout kafkaSpout;
	
	public KafkaSpoutAgent(Map<String, Object> conf) {
		String topic = String.valueOf(conf.get(BaseConstants.KAFKA_SPOUT_TOPIC));
		String zkServerStr = String.valueOf(conf.get(BaseConstants.KAFKA_SPOUT_ZK_SERVER));
		int zkPort = Integer.parseInt((String) conf.get(BaseConstants.KAFKA_SPOUT_ZK_PORT));
		String zkAddr = String.valueOf(conf.get(BaseConstants.KAFKA_SPOUT_CONSUMER_ADDR));
		StringBuilder id = new StringBuilder();
		id.append(String.valueOf(conf.get(BaseConstants.TOPOLOGY_NAME)));
		id.append(BaseConstants.COMMON_JOINER);
		id.append(topic);
		BrokerHosts brokerHosts = new ZkHosts(zkAddr);
		//SpoutConfig spoutConf = new SpoutConfig(brokerHosts, topic, "/kafkainput", UUID.randomUUID().toString());
		SpoutConfig spoutConf = new SpoutConfig(brokerHosts, topic, "/kafkainput", id.toString());
		spoutConf.scheme = new SchemeAsMultiScheme(new StringScheme());
		spoutConf.forceFromStart = false;

		spoutConf.zkServers = Arrays.asList(zkServerStr.split(",", -1));
		spoutConf.zkPort = Integer.valueOf(zkPort);
		this.kafkaSpout = new KafkaSpout(spoutConf);
	}
	
	public KafkaSpout getKafkaSpout() {
		return this.kafkaSpout;
	}
}

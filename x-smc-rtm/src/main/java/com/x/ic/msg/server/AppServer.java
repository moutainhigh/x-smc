package com.x.ic.msg.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.x.ic.msg.mds.dynamic.DynamicBootsrapConsumer;

public class AppServer {
	private static final Logger LOG = LoggerFactory.getLogger(AppServer.class.getName());
	private final static String CONTEXT_PATH = "classpath:context/core-context.xml";
	
	
	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { CONTEXT_PATH });
		context.registerShutdownHook();
		context.start();
		startMdsConsumer(context);
		synchronized (AppServer.class) {
			while (true) {
				try {
					AppServer.class.wait();

				} catch (Exception e) {
					LOG.error("系统错误，具体信息为：" + e.getMessage(), e);
				}
			}
		}
	}
	private static void startMdsConsumer(ApplicationContext context){
		DynamicBootsrapConsumer consumer = context.getBean(DynamicBootsrapConsumer.class);
		consumer.startConsumer();
		
	}

}

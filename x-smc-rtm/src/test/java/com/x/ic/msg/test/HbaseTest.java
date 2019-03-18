package com.x.ic.msg.test;

import java.io.IOException;

import com.x.hbase.base.IHbaseClientFactory;

public class HbaseTest {

	public static void main(String[] args) throws IOException {
//		IHbaseClientFactory.getDefaultHbaseClient().creatTable("SRC_DATA", new String[]{"orderId","orderType"});
//		String str = ConfigTool.getConfigItem("hbase.param");
//		System.out.println(str);
//		IHbaseClientFactory.getDefaultHbaseClient().addRecord("SRC_DATA", "ROW1", "orderId", "id", "12345");
//		IHbaseClientFactory.getDefaultHbaseClient().addRecord("SRC_DATA", "ROW1", "orderType", "type", "45");
//		test(true);
//		System.out.println();
		while(true){
			System.out.println((int)(Math.random()*10));
		}

	}
	public static void test(boolean b){
		if(b){
			return;
		}else{
			System.out.println(b);
		}
	}

}

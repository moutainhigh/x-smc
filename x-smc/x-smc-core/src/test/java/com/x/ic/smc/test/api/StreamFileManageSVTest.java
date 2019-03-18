package com.x.ic.smc.test.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.x.base.vo.BaseResponse;
import com.x.ic.smc.api.streamfilemanage.interfaces.IStreamFileInputSV;
import com.x.ic.smc.api.streamfilemanage.param.StreamFileParam;
import com.x.ic.smc.constants.SmcCacheConstant;
import com.x.ic.smc.constants.SmcConstants;
import com.x.ic.smc.dao.mapper.bo.StlSysParam;
import com.x.ic.smc.util.HttpClientUtil;
import com.x.ic.smc.util.RedisUtil;
import com.x.rtm.api.datacollect.params.JsDataVO;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/context/core-context.xml" })
public class StreamFileManageSVTest {
    @Autowired
    protected IStreamFileInputSV streamService;

    @Test
    public void importBillDetailData() {
    	StreamFileParam streamFileParam = new StreamFileParam();
    	//{"operId":"1","filePosition":"10.1.130.84:/aifs01/users/pabas01/tmp/test",
    	//"fileName":"0005_20160427103610422.zip","accountPeriod":"201604",
    	//"dataObj":"mvne-msg","tenantId":"809730CBD17648EFBAD2F4684D1EF233"}
    	
    	streamFileParam.setAccountPeriod("201605");
    	streamFileParam.setDataObj("BIU-GZT");
    	streamFileParam.setFileName("BIU_201603_BIU-GZT_order.csv.zip");
    	streamFileParam.setFilePosition("172.16.13.160:/data/devweb01");
    	streamFileParam.setOperId("1");
    	streamFileParam.setTenantId("BIU");
    	System.out.println(JSONObject.toJSONString(streamFileParam));
		BaseResponse fileInport = streamService.fileInport(streamFileParam);
    	
//    	String message = "ifudataBIU-SF20160301001mvne123456BIU-SF201603010011001hxbw17091234562016/3/1 12:23\\\"短信发送测试内容\\\"\\\"短信发送测试内容\\\"\\\"短信发送测试内容.\\\"1\"";
//        JsDataVO dataVO = new JsDataVO();
//        dataVO.setMessage(message);
//        dataVO.setjSBsn(message);
////        LOGGER.error(" ====== 调用采集服务:[" + JSON.toJSONString(dataVO) + "]");
//        HttpResponse httpResponse = HttpClientUtil.send("http://172.16.63.19:20990/rtm-services/dataService/JsResource",
//                JSON.toJSONString(dataVO));
    	
//		System.out.println(JSONObject.toJSONString(httpResponse));
    }
    
    @Test
    public void testAddRedis() {
    	
//    	StlSysParam param = new StlSysParam();
//    	param.setGuidkey("193D9842D94F45878F4F5C8AAB48E8");
//    	param.setTenantId("ifudata");
//    	param.setTypeCode("data_collect");
//    	param.setParamCode("url");
//    	param.setColumnValue("http://192.168.0.14:10771/icrtm/dataService/JsResource");
//    	param.setColumnDesc("采集服务rest请求地址");
//    	param.setDispord(1);
//    	param.setState("1");
//    	List<StlSysParam> list = new ArrayList<>();
//    	list.add(param);
//    	RedisUtil.hset("com.x.ic.smc.cache.sysparam", "ifudata.data_collect.url", JSONObject.toJSONString(list));
    	
//    	StlSysParam param = new StlSysParam();
//    	param.setGuidkey("193D9842D94F45878F4F5C8AAB48E2");
//    	param.setTenantId("ifudata");
//    	param.setTypeCode("SFTP_CONF");
//    	param.setParamCode("USER_NAME");
//    	param.setColumnValue("thrdsoft01");
//    	param.setColumnDesc("sftp用户名");
//    	param.setDispord(1);
//    	param.setState("1");
//    	List<StlSysParam> list = new ArrayList<>();
//    	list.add(param);
//    	RedisUtil.hset("com.x.ic.smc.cache.sysparam", "ifudata.SFTP_CONF.USER_NAME", JSONObject.toJSONString(list));
    	
//    	StlSysParam param = new StlSysParam();
//    	param.setGuidkey("193D9842D94F45878F4F5C8AAB48E2");
//    	param.setTenantId("ifudata");
//    	param.setTypeCode("SFTP_CONF");
//    	param.setParamCode("PWD");
//    	param.setColumnValue("Linthrd01");
//    	param.setColumnDesc("sftp密码");
//    	param.setDispord(1);
//    	param.setState("1");
//    	List<StlSysParam> list = new ArrayList<>();
//    	list.add(param);
//    	RedisUtil.hset("com.x.ic.smc.cache.sysparam", "ifudata.SFTP_CONF.PWD", JSONObject.toJSONString(list));
    	
//    	StlSysParam param = new StlSysParam();
//    	param.setGuidkey("193D9842D94F45878F4F5C8AAB48E2");
//    	param.setTenantId("ifudata");
//    	param.setTypeCode("AUTH");
//    	param.setParamCode("USER_ID");
//    	param.setColumnValue("mvne");
//    	param.setColumnDesc("用户名");
//    	param.setDispord(1);
//    	param.setState("1");
//    	List<StlSysParam> list = new ArrayList<>();
//    	list.add(param);
//    	RedisUtil.hset("com.x.ic.smc.cache.sysparam", "ifudata.AUTH.USER_ID", JSONObject.toJSONString(list));
    	
//    	StlSysParam param = new StlSysParam();
//    	param.setGuidkey("193D9842D94F45878F4F5C8AAB48E2");
//    	param.setTenantId("ifudata");
//    	param.setTypeCode("AUTH");
//    	param.setParamCode("PASSWD");
//    	param.setColumnValue("123456");
//    	param.setColumnDesc("用户名");
//    	param.setDispord(1);
//    	param.setState("1");
//    	List<StlSysParam> list = new ArrayList<>();
//    	list.add(param);
//    	RedisUtil.hset("com.x.ic.smc.cache.sysparam", "ifudata.AUTH.PASSWD", JSONObject.toJSONString(list));
//		System.out.println(JSONObject.toJSONString(param));
    	
//    	RedisUtil.set("ifudata:mvne", "123456");
//    	RedisUtil.hset("ifudata:BIU-SF", "record_split", new String(new char[] { (char) 2 }));
//    	RedisUtil.hset("ifudata:BIU-SF", "field_split", new String(new char[] { (char) 1 }));
//    	RedisUtil.hset("BIU-SF", "start_time", "2:1");
//    	RedisUtil.set("BIU-SF:SN", "1:2:4:5");
//    	Map<String, String> map = new HashMap<>();
//    	map.put("40", "{\"indexKey\":\"batch_no:tenant_id\",\"record\":\"log_id:tenant_id:imp_file_name:imp_file_url:data_type:object_id:bill_time_sn:import_time:import_records:batch_no:rst_file_name:rst_file_url:state\",\"dbConnect\":\"dev_baas_smc1\",\"primaryKey\":\"log_id:tenant_id:imp_file_name:imp_file_url:data_type:object_id:bill_time_sn:import_time:import_records:batch_no:rst_file_name:rst_file_url:state\",\"tenantId\":\"ifudata\"}");
//    	RedisUtil.hmset("stl_import_log", map);
//    	RedisUtil.hgetAll("stl_import_log");
//    	RedisUtil.set("stl_import_log:batch_no:tenant_id", "40");
    }
    
    @Test
    public void testGZTAddRedis() {
    	
//    	StlSysParam param = new StlSysParam();
//    	param.setGuidkey("193D9842D94F45878F4F5C8AAB48E8");
//    	param.setTenantId("BIU");
//    	param.setTypeCode("data_collect");
//    	param.setParamCode("url");
//    	param.setColumnValue("http://192.168.0.14:10771/icrtm/dataService/JsResource");
//    	param.setColumnDesc("采集服务rest请求地址");
//    	param.setDispord(1);
//    	param.setState("1");
//    	List<StlSysParam> list = new ArrayList<>();
//    	list.add(param);
//    	RedisUtil.hset("com.x.ic.smc.cache.sysparam", "BIU.data_collect.url", JSONObject.toJSONString(list));
    	
//    	StlSysParam param = new StlSysParam();
//    	param.setGuidkey("193D9842D94F45878F4F5C8AAB48E2");
//    	param.setTenantId("BIU");
//    	param.setTypeCode("SFTP_CONF");
//    	param.setParamCode("USER_NAME");
//    	param.setColumnValue("thrdsoft01");
//    	param.setColumnDesc("sftp用户名");
//    	param.setDispord(1);
//    	param.setState("1");
//    	List<StlSysParam> list = new ArrayList<>();
//    	list.add(param);
//    	RedisUtil.hset("com.x.ic.smc.cache.sysparam", "BIU.SFTP_CONF.USER_NAME", JSONObject.toJSONString(list));
//    	
//    	StlSysParam param2 = new StlSysParam();
//    	param2.setGuidkey("193D9842D94F45878F4F5C8AAB48E2");
//    	param2.setTenantId("BIU");
//    	param2.setTypeCode("SFTP_CONF");
//    	param2.setParamCode("PWD");
//    	param2.setColumnValue("Linthrd01");
//    	param2.setColumnDesc("sftp密码");
//    	param2.setDispord(1);
//    	param2.setState("1");
//    	List<StlSysParam> list2 = new ArrayList<>();
//    	list2.add(param2);
//    	RedisUtil.hset("com.x.ic.smc.cache.sysparam", "BIU.SFTP_CONF.PWD", JSONObject.toJSONString(list2));
//    	
//    	StlSysParam param3 = new StlSysParam();
//    	param3.setGuidkey("193D9842D94F45878F4F5C8AAB48E2");
//    	param3.setTenantId("BIU");
//    	param3.setTypeCode("AUTH");
//    	param3.setParamCode("USER_ID");
//    	param3.setColumnValue("mvne");
//    	param3.setColumnDesc("用户名");
//    	param3.setDispord(1);
//    	param3.setState("1");
//    	List<StlSysParam> list3 = new ArrayList<>();
//    	list3.add(param3);
//    	RedisUtil.hset("com.x.ic.smc.cache.sysparam", "BIU.AUTH.USER_ID", JSONObject.toJSONString(list3));
//    	
//    	StlSysParam param4 = new StlSysParam();
//    	param4.setGuidkey("193D9842D94F45878F4F5C8AAB48E2");
//    	param4.setTenantId("BIU");
//    	param4.setTypeCode("AUTH");
//    	param4.setParamCode("PASSWD");
//    	param4.setColumnValue("123456");
//    	param4.setColumnDesc("用户名");
//    	param4.setDispord(1);
//    	param4.setState("1");
//    	List<StlSysParam> list4 = new ArrayList<>();
//    	list4.add(param4);
//    	RedisUtil.hset("com.x.ic.smc.cache.sysparam", "BIU.AUTH.PASSWD", JSONObject.toJSONString(list4));
//		System.out.println(JSONObject.toJSONString(param));
    	
//    		RedisUtil.getCacheClient().set("BIU:devweb01", "devweb01");
//    		RedisUtil.getCacheClient().hset("BIU:BIU-GZT", "record_split", new String(new char[] { (char) 2 }));
//    		RedisUtil.getCacheClient().hset("BIU:BIU-GZT", "field_split", new String(new char[] { (char) 1 }));
//    		RedisUtil.getCacheClient().hset("BIU-GZT", "start_time", "2:1");
//    		RedisUtil.getCacheClient().set("BIU-GZT:SN", "1:2:4:5");
//	    	Map<String, String> map = new HashMap<>();
//	    	map.put("40", "{\"indexKey\":\"batch_no:tenant_id\",\"record\":\"log_id:tenant_id:imp_file_name:imp_file_url:data_type:object_id:bill_time_sn:import_time:import_records:batch_no:rst_file_name:rst_file_url:state\",\"dbConnect\":\"dev_baas_smc1\",\"primaryKey\":\"log_id:tenant_id:imp_file_name:imp_file_url:data_type:object_id:bill_time_sn:import_time:import_records:batch_no:rst_file_name:rst_file_url:state\",\"tenantId\":\"BIU\"}");
//	    	RedisUtil.getCacheClient().hmset("stl_import_log", map);
//	    	RedisUtil.getCacheClient().hgetAll("stl_import_log");
//	    	RedisUtil.getCacheClient().set("stl_import_log:batch_no:tenant_id", "40");
//	    	
//	    	RedisUtil.getCacheClient().del("busidata_BIU_GZT20160501_stats_times");
	    	
    		RedisUtil.getCacheClient().hdel("smc_stat_counter",
                "JSBIU20180501");
	    	
	    	RedisUtil.getCacheClient().hset("stats_times", "smc_stat_times", "[{\"batchNo\":\"JSBIU20180501\",\"billTimeSn\":\"201805\",\"busidata\":\"busidata\",\"objectId\":\"BIU-GZT\",\"stats_times\":\"10\",\"tenantId\":\"BIU\"}]");
	    	
//	     	ReqParam req =new ReqParam();
//	    	String[] a=new String[]{"1"};
//	    	req.setTableId(a);
//	    	String[] b=new String[]{"stl_import_log"};
//	    	req.setTableNames(b);
//	    	int shmDelete = dshmSV.shmDelete(req);
    }
    
    @Test
    public void testInit() {
    		//rtm需要刷入缓存的基本配置信息
//    		RedisUtil.getCacheClient().set("BIU:devweb01", "devweb01");
//		RedisUtil.getCacheClient().hset("BIU:BIU-GZT", "record_split", new String(new char[] { (char) 2 }));
//		RedisUtil.getCacheClient().hset("BIU:BIU-GZT", "field_split", new String(new char[] { (char) 1 }));
//		RedisUtil.getCacheClient().hset("BIU-GZT", "start_time", "2:1");
//		RedisUtil.getCacheClient().set("BIU-GZT:SN", "1:2:4:5");
//	    	Map<String, String> map = new HashMap<>();
//	    	map.put("40", "{\"indexKey\":\"batch_no:tenant_id\",\"record\":\"log_id:tenant_id:imp_file_name:imp_file_url:data_type:object_id:bill_time_sn:import_time:import_records:batch_no:rst_file_name:rst_file_url:state\",\"dbConnect\":\"dev_baas_smc1\",\"primaryKey\":\"log_id:tenant_id:imp_file_name:imp_file_url:data_type:object_id:bill_time_sn:import_time:import_records:batch_no:rst_file_name:rst_file_url:state\",\"tenantId\":\"BIU\"}");
//	    	RedisUtil.getCacheClient().hmset("stl_import_log", map);
//	    	RedisUtil.getCacheClient().hgetAll("stl_import_log");
//	    	RedisUtil.getCacheClient().set("stl_import_log:batch_no:tenant_id", "40");
    	
	    	//重新跑流水需要删除的缓存
	    	RedisUtil.getCacheClient().del("busidata_BIU_GZT20160501_stats_times");
    	
		RedisUtil.getCacheClient().hdel("smc_stat_counter",
            "JSBIU20180501");
    		
		//结算拓扑需要从缓存取的数据
//		RedisUtil.getCacheClient().hset("stats_times", "smc_stat_times", "[{\"batchNo\":\"JSBIU20180501\",\"billTimeSn\":\"201805\",\"busidata\":\"busidata\",\"objectId\":\"BIU-GZT\",\"stats_times\":\"10\",\"tenantId\":\"BIU\"}]");
    	
    }
}

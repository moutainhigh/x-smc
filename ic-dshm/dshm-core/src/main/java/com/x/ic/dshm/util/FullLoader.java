package com.x.ic.dshm.util;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.x.ic.dshm.dto.FullTableLoad;
import com.x.ic.dshm.service.interfaces.ITransportService;
public class FullLoader implements Runnable{
	private static final Logger LOG = LoggerFactory.getLogger(FullLoader.class);
	public static void main(String[] args) {
		//加载spring容器
		ApplicationContextUtil appContextUtil = ApplicationContextUtil.getInstance();
		//运行loader
		new Thread((Runnable) appContextUtil.getBean("fullLoader")).start();
	}
	@Autowired
	private ITransportService transportService;
	ApplicationContextUtil appContextUtil = ApplicationContextUtil.getInstance();
	JdbcTemplate jdbcTemplate =(JdbcTemplate) appContextUtil.getBean("mysqlJdbcTemplate");
	public FullLoader() {
	}
	@Override
	public void run() {
		Boolean tableFlag=transportService.EbillingTable2Dso();
		if(tableFlag){
			//将表结构加载完毕之后需要选出需要加载的表名和租户id
			String sqlString=" select distinct table_name,tenant_id from ebilling_shm_table_info ";
			List<FullTableLoad> nameIds=jdbcTemplate.query(sqlString, new BeanPropertyRowMapper<FullTableLoad>(FullTableLoad.class));
			for(FullTableLoad nameid:nameIds){
				Map<String, String> infos=transportService.LoadTableInfo(nameid.getTableName().toLowerCase());
				for(Entry<String,String> infoentry:infos.entrySet()){
					String infoValue=infoentry.getValue();
					String tableId=infoentry.getKey();
					transportService.LoadData2Dso(nameid.getTableName().toLowerCase(), infoValue,tableId);
				}
			}
			//return 1;
		}
		else{
			LOG.error("load table info is error.......");
			//return -1;
		}
		
	}

}

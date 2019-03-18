package com.x.ic.dshm.util;

import org.slf4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.LoggerFactory;

import com.x.ic.dshm.dao.interfaces.EbillingShmTableDbMapper;
import com.x.ic.dshm.dto.EbillingShmTableDb;

/**
 * JDBC属性文件读取工具
 */
public class JDBCPropertiesUtils {
	private static final Logger LOG =LoggerFactory.getLogger(JDBCPropertiesUtils.class);
   // private static final Logger LOG = LogManager.getLogger(JDBCPropertiesUtils.class);
    
	private String username;
	private String password;
	private String url;
	private String driverClassName;
	private String type;
	
	public  JDBCPropertiesUtils(){
		
	}
	
	public static  JDBCPropertiesUtils  getInstance(SqlSessionTemplate sqlSessionTemplate, String dbName) {
	    
		EbillingShmTableDbMapper ebillingShmTableDbMapper=sqlSessionTemplate.getMapper(EbillingShmTableDbMapper.class);
		EbillingShmTableDb ebillingShmTableDb=ebillingShmTableDbMapper.selectByPrimaryKey(dbName);
		if(ebillingShmTableDb == null){
		    LOG.error("根据dbName["+dbName+"]查询表ebilling_shm_table_db结果为空，筛选字段为db_connect");
		    return null;
		}
		
		JDBCPropertiesUtils instance = new JDBCPropertiesUtils();
		String userName=ebillingShmTableDb.getUserName();
		String passWord=ebillingShmTableDb.getPassWord();
		String url=ebillingShmTableDb.getUrl();
		String driverClassName=ebillingShmTableDb.getDriverClassName();
		String type=ebillingShmTableDb.getDbType();
		
		instance.username = userName;
		instance.password = passWord;
		instance.url = url;
		instance.driverClassName = driverClassName;
		instance.type=type;
		
		return instance;
	}

	public static JDBCPropertiesUtils getInstance(String username,String password,String url,String driverClassName,String type){
		JDBCPropertiesUtils instance = new JDBCPropertiesUtils();
		instance.username = username;
		instance.password = password;
		instance.url = url;
		instance.driverClassName = driverClassName;
		instance.type=type;
		return instance;
	}
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public String getUrl() {
		return url;
	}
	public String getType() {
		return type;
	}
	public String getDriverClassName() {
		return driverClassName;
	}
	
}

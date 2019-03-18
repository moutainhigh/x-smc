package com.x.ic.dshm.util;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



/**
 * JDBC数据库操作公用类
 * 谨记：用完此类事例，一定要记得调用close方法
 * @author 
 *
 */
public class CommonDbByJdbc {
	private static final Logger LOG = LoggerFactory.getLogger(CommonDbByJdbc.class);
	//数据库连接
	private Connection connection;
	private Properties props;
	private String databaseName;
	
	/**
	 * 构造器
	 * 主要负责初始化数据库连接对象connection
	 */
	public CommonDbByJdbc(String params){
		try {
			//ResourceBundle rb = ResourceBundle.getBundle(fileName);
			String[] str=params.split(";");
			String  driverClassName = str[0];
			String  username = str[2];
			String  password = str[3];
			String  url = str[1];
			String  temp = "";
			String  dbName = "";
			if (driverClassName.contains("oracle")) {
				String[] array = url.split(":");
				dbName = array[array.length - 1];
				this.databaseName = "oracle";
			}else if (driverClassName.contains("mysql")) {
				temp = url.substring(13,url.indexOf("?"));
				dbName = temp.split("/")[1];
				this.databaseName = "mysql";
			}
			//mysql
			this.props =new Properties();
			props.put("database", dbName);
			props.put("user", username);
			props.put("password", password);
			props.put("remarksReporting","true");
			Class.forName(driverClassName);
			if (this.databaseName.equals("oracle")) {
				this.connection=DriverManager.getConnection(url, username, password);
			}else if (this.databaseName.equals("mysql")) {
				this.connection=DriverManager.getConnection(url, props);
			}
		} catch (Exception e) {
			LOG.error("CommonDbByJdbc:数据库连接失败！请检查数据连接参数！");
			//e.printStackTrace();
		}
	}
	
	/**
	 * 构造器
	 * 主要负责初始化数据库连接对象connection
	 */
	public CommonDbByJdbc(JDBCPropertiesUtils jdbcPropertiesUtils){
		try {
			Class.forName(jdbcPropertiesUtils.getDriverClassName());
			String  temp = "";
			String  dbName = "";
			if (jdbcPropertiesUtils.getDriverClassName().contains("oracle")) {
				String[] array = jdbcPropertiesUtils.getUrl().split(":");
				dbName = array[array.length - 1];
				this.databaseName = "oracle";
			}else if (jdbcPropertiesUtils.getDriverClassName().contains("mysql")) {
				temp = jdbcPropertiesUtils.getUrl().substring(13,jdbcPropertiesUtils.getUrl().indexOf("?"));
				dbName = temp.split("/")[1];
				//System.out.println("dbname--->>>>>"+dbName);
				this.databaseName = "mysql";
			}
			//mysql
			this.props =new Properties();
			props.put("database", dbName);
			props.put("user", jdbcPropertiesUtils.getUsername());
			props.put("password", jdbcPropertiesUtils.getPassword());
			props.put("remarksReporting","true");
			if (this.databaseName.equals("oracle")) {
				this.connection=DriverManager.getConnection(jdbcPropertiesUtils.getUrl(), jdbcPropertiesUtils.getUsername(), jdbcPropertiesUtils.getPassword());
			}else if (this.databaseName.equals("mysql")) {
				//System.out.println("111111111111111111111");
				this.connection=DriverManager.getConnection(jdbcPropertiesUtils.getUrl(), props);
				//System.out.println("222222222222222222222");
			}
		} catch (Exception e) {
			LOG.error("CommonDbByJdbc:数据库连接失败！请检查数据连接参数！");
			//e.printStackTrace();
		}
	}
	/**
	 * 获取数据库连接对象connection
	 * @return
	 */
	public Connection getConnection(){
		return this.connection;
	}
	/**
	 * 获取数据库连接属性
	 * @return
	 */
	public Properties getDatabaseInfo(){
		return this.props;
	}
	/**
	 * 此statement只能执行静态sql语句，意思就是此statement用的sql只能是拼接的sql字符串，
	 * 参数是拼接在sql字符串中的
	 * @return
	 * @throws SQLException
	 */
	public Statement getStatement() throws SQLException{
		return this.connection.createStatement();
	}
	/**
	 * 此statement是预编译的，就是sql语句可以带?来作为参数，
	 * 然后手动调用此statement给相应的?赋值，执行流程可以是多次的。
	 * 赋值，执行，赋值，执行。。。
	 * @param sql
	 * @return
	 * @throws SQLException
	 */
	public PreparedStatement getPreparedStatement(String sql) throws SQLException{
		return this.connection.prepareStatement(sql);
	}
	/**
	 * 用于执行存储过程的statement
	 * @param sql
	 * @return
	 * @throws SQLException
	 */
	public CallableStatement getCallableStatement(String sql) throws SQLException{
		return this.connection.prepareCall(sql);
	}
	/**
	 * 拼接sql的方式返回查询结果集
	 * @param sql
	 * @return
	 * @throws Exception
	 */
	public ResultSet select(String sql) throws Exception{
		return this.getStatement().executeQuery(sql);
	}
	/**
	 * 拼接sql的方式返回分页查询结果集
	 * 分页查询
	 * @param sql              sql字符串
	 * @param start           记录的第一行是从0开始的
	 * @param pageSize   每页的行数
	 * @return
	 * @throws Exception
	 */
	public ResultSet page(String sql,long start,long pageSize) throws Exception{
		return this.getStatement().executeQuery(sql+" LIMIT "+start+","+pageSize);
	}
	/**
	 * 拼接sql的方式返回查询结果的行数
	 * @param sql
	 * @return
	 * @throws Exception
	 */
	public long countRows(String sql) throws Exception{
		String countRowsSql="select count(*) from ";
		int fromIndex=sql.indexOf("from");
		countRowsSql+=sql.substring(fromIndex+4);
		ResultSet resultSet=this.getStatement().executeQuery(countRowsSql);
		while (resultSet.next()) {
			return resultSet.getLong(1);
		}
		return 0L;
	}
	/**
	 * 获取数据库所有表名组成的列表
	 * @return
	 * @throws Exception
	 */
	public List<String> getAllTableNames() throws Exception{
		List<String> tableNames=new ArrayList<String>();
		ResultSet resultSet=getConnection().getMetaData().getTables(null, null, null, new String[]{"TABLE"});
		//int tableCount=0;
		while (resultSet.next()) {
			tableNames.add(resultSet.getString("TABLE_NAME"));
			//tableCount++;
		}
		//System.out.println("共计有表"+tableCount+"个！！！分别为：");
		//System.out.println(tableNames);
		return tableNames;
	}
	/**
	 * 获取数据库所有表组成的列表，表的信息包括表名(TABLE_NAME)、类名(CLASS_NAME)、注释(REMARKS)
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, String>> getAllTables() throws Exception{
		List<Map<String, String>> tables=new ArrayList<Map<String,String>>();
		ResultSet resultSet=getConnection().getMetaData().getTables(null, null, null, new String[]{"TABLE"});
		int tableCount=0;
		while (resultSet.next()) {
			Map<String, String> tableMap=new HashMap<String, String>();
			tableMap.put("TABLE_NAME", resultSet.getString("TABLE_NAME"));
			tableMap.put("REMARKS", resultSet.getString("REMARKS"));
			tableMap.put("CLASS_NAME", NameUtil.getClassNameFromTableName(resultSet.getString("TABLE_NAME")));
			tableMap.put("TABLE_COMMENT", this.getTableComment(this.props.getProperty("database"), resultSet.getString("TABLE_NAME")));
			tables.add(tableMap);
			tableCount++;
		}
		LOG.debug("共计有表"+tableCount+"个！！！");
		
		return tables;
	}
	/**
	 * 获取某张表的所有字段名列表
	 * @param tableName
	 * @return
	 * @throws Exception
	 */
	public List<String> getAllColumnNames(String tableName) throws Exception{
		List<String> columnNames=new ArrayList<String>();
		ResultSet resultSet=getConnection().getMetaData().getColumns(null, null, tableName, null);
		int tableCount=0;
		while (resultSet.next()) {
			columnNames.add(resultSet.getString(4));
			tableCount++;
		}
		LOG.debug("共计表"+tableName+"有字段"+tableCount+"个！！！");
		return columnNames;
	}
	/**
	 * 获取某张表的所有字段列表，包括字段名(COLUMN_NAME)、字段类型(COLUMN_TYPE_NAME)、po属性名(PRO_NAME)、po属性类型(PRO_TYPE_NAME)
	 * @param tableName
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, String>> getAllColumns(String tableName) throws Exception{
		List<Map<String, String>> columns=new ArrayList<Map<String,String>>();
		ResultSet resultSet=getConnection().getMetaData().getColumns(null, null, tableName, null);
		int tableCount=0;
		while (resultSet.next()) {
			Map<String, String> column=new HashMap<String, String>();
			if (resultSet.getString("COLUMN_NAME").equals("id")) {
				column.put("COLUMN_IS_PRIMARY", "yes");//是否主键
			}
			column.put("COLUMN_NAME", resultSet.getString("COLUMN_NAME"));//sql字段名
			column.put("PRO_NAME", NameUtil.getProNameFromColumnName(resultSet.getString("COLUMN_NAME")));//po属性名
			column.put("COLUMN_TYPE_NAME", resultSet.getString("TYPE_NAME"));//sql字段类型
			column.put("COLUMN_TYPE_SIZE", resultSet.getString("COLUMN_SIZE"));//sql字段长度
			column.put("PRO_TYPE_NAME",JdbcUtil.getJavaTypeFromSqlType(Integer.parseInt(resultSet.getString("DATA_TYPE"))) );//po属性类型
			column.put("COLUMN_COMMENT", this.getColumnComment(this.props.getProperty("database"), tableName, resultSet.getString("COLUMN_NAME")));//sql字段注释
			column.put("PRO_COMMENT", this.getColumnComment(this.props.getProperty("database"), tableName, resultSet.getString("COLUMN_NAME")));//sql字段注释
			columns.add(column);
			tableCount++;
			System.out.println(column);
		}
		LOG.debug("共计表"+tableName+"有字段"+tableCount+"个！！！");
		return columns;
	}
	/**
	 * 从主表的角度获取所有引用此表的外键
	 * @param tableName
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, String>> getAllForeignsFromPri(String tableName) throws Exception{
		List<Map<String, String>> foreigns=new ArrayList<Map<String,String>>();
		ResultSet resultSet=getConnection().getMetaData().getExportedKeys(null, null, tableName);
		int tableCount=0;
		while (resultSet.next()) {
			Map<String, String> foreign=new HashMap<String, String>();
			foreign.put("PKTABLE_NAME", resultSet.getString("PKTABLE_NAME"));
			foreign.put("PKCOLUMN_NAME", resultSet.getString("PKCOLUMN_NAME"));
			foreign.put("FKTABLE_NAME", resultSet.getString("FKTABLE_NAME"));
			foreign.put("FKCOLUMN_NAME", resultSet.getString("FKCOLUMN_NAME"));
			foreigns.add(foreign);
			tableCount++;
		}
		LOG.debug("共计主表"+tableName+"有外键"+tableCount+"个！！！");
		return foreigns;
	}
	/**
	 * 以从表的角度获取此表的所有外键
	 * @param tableName
	 * @return
	 * @throws Exception
	 */
//	public List<Map<String, String>> getAllForeignsFromFor(String tableName) throws Exception{
//		List<Map<String, String>> foreigns=new ArrayList<Map<String,String>>();
//		ResultSet resultSet=getConnection().getMetaData().getImportedKeys(null, null, tableName);
//		int tableCount=0;
//		while (resultSet.next()) {
//			Map<String, String> foreign=new HashMap<String, String>();
//			foreign.put("PKTABLE_NAME", resultSet.getString("PKTABLE_NAME"));
//			foreign.put("PKCOLUMN_NAME", resultSet.getString("PKCOLUMN_NAME"));
//			foreign.put("FKTABLE_NAME", resultSet.getString("FKTABLE_NAME"));
//			foreign.put("FKCOLUMN_NAME", resultSet.getString("FKCOLUMN_NAME"));
//			//针对不同的情况，外键命名策略并不相同，第一个是根据主键表名来命名，第二个根据字段来命名
//			//foreign.put("PRO_NAME", NameUtil.getProNameFromColumnName(NameUtil.getClassNameFromTableName(resultSet.getString("PKTABLE_NAME"))));
//			foreign.put("PRO_NAME", NameUtil.getProNameFromColumnName(resultSet.getString("FKCOLUMN_NAME")));
//			foreign.put("PRO_TYPE_NAME", PoProUtil.changeProTypeName(NameUtil.getClassNameFromTableName(resultSet.getString("PKTABLE_NAME"))));
//			foreigns.add(foreign);
//			tableCount++;
//			System.out.println(foreign);
//		}
//		System.out.println("共计从表"+tableName+"有外键"+tableCount+"个！！！");
//		return foreigns;
//	}
	/**
	 * 根据一个表的结构（包括外键）生成po的属性列表，外键用其他po代替
	 * @param tableName
	 * @return
	 * @throws Exception
	 */
//	public List<Map<String, String>> getAllProsFromTable(String tableName) throws Exception{
//		List<Map<String, String>> columnMaps=getAllColumns(tableName);
//		List<Map<String, String>> foreignMaps=getAllForeignsFromFor(tableName);
//		for (int i = 0; i < columnMaps.size(); i++) {
//			Map<String, String> columnMap=columnMaps.get(i);
//			for (int j = 0; j < foreignMaps.size(); j++) {
//				Map<String, String> foreignMap=foreignMaps.get(j);
//				if (columnMap.get("COLUMN_NAME").equals(foreignMap.get("FKCOLUMN_NAME"))) {
//					columnMap.put("PRO_TYPE_NAME", foreignMap.get("PRO_TYPE_NAME"));
//					columnMap.put("PRO_NAME", foreignMap.get("PRO_NAME"));
//					columnMap.put("PRO_IS_FOREIGN", "yes");
//				}
//			}			
//		}		
//		System.out.println("修改完毕"+columnMaps);
//		return columnMaps;
//	}
	/**
	 * 根据表名获取po类的信息
	 * 包括po类名(PO_NAME)、po的包名(PO_PACKAGE_NAME)、po的所有属性(PO_PROS)
	 * @param tableName
	 * @param poPackage
	 * @return
	 * @throws Exception
	 */
//	public  Map<String, Object> getPoFromTableName(String tableName,String poPackage) throws Exception{
//		Map<String, Object> poMap=new HashMap<String, Object>();
//		poMap.put("TABLE_NAME", tableName);
//		poMap.put("PO_NAME", NameUtil.getClassNameFromTableName(tableName));
//		poMap.put("PO_COMMENT", getTableComment(this.props.getProperty("database"), tableName));
//		poMap.put("PO_PACKAGE_NAME", poPackage);
//		poMap.put("PO_PROS", getAllProsFromTable(tableName));
//		System.out.println(poMap);
//		return poMap;
//	}
	/**
	 * 获取数据库中的表中的某一个字段的注释，注意这都是mysql哦
	 * @param databaseName
	 * @param tableName
	 * @param columnName
	 * @return
	 * @throws Exception
	 */
	public String getColumnComment(String databaseName,String tableName,String columnName) throws Exception{
		try {
//			select * from   user_col_comments where table_name='AWF_PROCESS_COMMON_PARAM'
//			select * from USER_TAB_COMMENTS where table_name='AWF_PROCESS_COMMON_PARAM'
			if (this.databaseName.equals("oracle")) {
				ResultSet resultSet=this.select("select * from USER_TAB_COMMENTS where "
						+" TABLE_NAME='"+tableName+"' and COLUMN_NAME='"+columnName+"'");
				while (resultSet.next()) {
					String comment=resultSet.getString("COMMENTS");
					if (comment!=null&&"".equals(comment)) {
						comment="无注释，请添加！";
					}
					return comment;
				}
			}else if (this.databaseName.equals("mysql")) {
				ResultSet resultSet=this.select("select * from information_schema.COLUMNS where TABLE_SCHEMA='"+databaseName+"' and "
						+" TABLE_NAME='"+tableName+"' and COLUMN_NAME='"+columnName+"'");
				while (resultSet.next()) {
					String comment=resultSet.getString("COLUMN_COMMENT");
					if (comment!=null&&"".equals(comment)) {
						comment="无注释，请添加！";
					}
					return comment;
				}
			}
		} catch (Exception e) {
			LOG.error(e.getMessage());
		}
		return "无注释，请添加！";
	}
	/**
	 * 获取数据库中表的注释，注意这都是mysql哦
	 * @param databaseName
	 * @param tableName
	 * @return
	 * @throws Exception
	 */
	public String getTableComment(String databaseName,String tableName) throws Exception{
		try {
			if (this.databaseName.equals("oracle")) {
				ResultSet resultSet=this.select("select * from USER_TAB_COMMENTS where "
						+" TABLE_NAME='"+tableName+"'");
				while (resultSet.next()) {
					String comment=resultSet.getString("COMMENTS");
					if (comment!=null&&"".equals(comment)) {
						comment="无注释，请添加！";
					}
					return comment;
				}
			}else if (this.databaseName.equals("mysql")) {
				ResultSet resultSet=this.select("select * from information_schema.TABLES where TABLE_SCHEMA='"+databaseName+"' and "
						+" TABLE_NAME='"+tableName+"'");
				while (resultSet.next()) {
					String comment=resultSet.getString("TABLE_COMMENT");
					if (comment!=null&&"".equals(comment)) {
						comment="无注释，请添加！";
					}
					return comment;
				}
			}
		} catch (Exception e) {
			LOG.error(e.getMessage());
		}
		return "无注释，请添加！";
	}
	/**
	 * 关闭数据库连接
	 * 谨记：使用完此类实例，一定要记得关闭
	 */
	public void close(){
		try {
			if (connection!=null) {
				connection.close();
			}    
		} catch (Exception e) {
			LOG.debug("CommonDbByJdbc:关闭数据库连接失败！");
		//	e.printStackTrace();
		}
	}
	public static void main(String[] args) throws Exception {
		CommonDbByJdbc commonDbByJdbc=new CommonDbByJdbc("jdbc");
		//commonDbByJdbc.getAllTables();
		/*List<String> tableNames=commonDbByJdbc.getAllTableNames();
		for (int i = 0; i < tableNames.size(); i++) {
			List<Map<String, String>> columns=commonDbByJdbc.getAllColumns(tableNames.get(i));
			//commonDbByJdbc.getAllForeignsFromFor(tableNames.get(i));
			//commonDbByJdbc.getAllProsFromTable(tableNames.get(i));
			//commonDbByJdbc.getPoFromTableName(tableNames.get(i), "com.xx.yy.common.po");			
		}*/
		//System.out.println(commonDbByJdbc.getDatabaseInfo());;
		System.out.println(commonDbByJdbc.getColumnComment("onex", "wis_onex_answer", "id"));
		//System.out.println(commonDbByJdbc.getTableComment("onex", "wis_onex_answer"));
		commonDbByJdbc.close();
	}
}

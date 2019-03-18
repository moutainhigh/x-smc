package com.x.hbase.base.interfaces;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.hadoop.hbase.filter.FilterList;

import com.x.hbase.base.model.FamilyVO;
import com.x.hbase.base.model.PutVO;

import org.apache.hadoop.hbase.filter.CompareFilter.CompareOp;

/**
 * 
 * @author wangluyang
 *
 */
public interface IHbaseClient {

	/**
	 * 创建表
	 * @param tableName
	 * @param family
	 * @return
	 */
	int creatTable(String tableName, String[] family);
	
	/**
	 * 增加记录
	 * @param tableName
	 * @param rowKey
	 * @param family
	 * @param qualifier
	 * @param value
	 * @throws IOException
	 */
	void addRecord(String tableName, String rowKey, String family, String qualifier, String value)
			throws IOException;
	
	/**
	 * 增加多条记录
	 * @param tableName
	 * @param puts
	 * @throws IOException
	 */
	void addRecords(String tableName, List<PutVO> puts)	throws IOException;
	
	/**
	 * 查看某行数据
	 * @param tablename
	 * @param rowKey
	 * @return
	 * @throws Exception
	 */
	Map<String, Object> get(String tablename, String rowKey) throws Exception;
	
	/**
	 * 
	 * @param tablename
	 * @param columnFamily
	 * @param qualifier
	 * @param data
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> queryequal(String tablename, String columnFamily, String qualifier, String data) throws Exception;
	
	/**
	 * 查询范围
	 * @param tablename
	 * @param columnFamily
	 * @param qualifier
	 * @param mindata
	 * @param maxdata
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> queryagebetween(String tablename, String columnFamily, String qualifier, String mindata, String maxdata) throws Exception;
	
	/**
	 * 根据条件查询
	 * @param tablename
	 * @param filterList
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> query(String tablename, FilterList filterList) throws Exception;
	
	/**
	 * 查看表所有数据
	 * @param tablename
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> scan(String tablename) throws Exception;
	
	/**
	 * rowkey匹配完整字节数组 
	 * @param tablename
	 * @param rowCompareOp
	 * @param filterStr
	 * @return
	 * @throws IOException
	 */
	List<Map<String, Object>> rowkeyBinaryComparator(String tablename, CompareOp rowCompareOp, String filterStr) throws IOException;
	
	/**
	 * rowkey匹配字节数组前缀
	 * @param tablename
	 * @param rowCompareOp
	 * @param filterStr
	 * @return
	 * @throws IOException
	 */
	List<Map<String, Object>> rowkeyBinaryPrefixComparator(String tablename, CompareOp rowCompareOp, String filterStr) throws IOException;
	
	/**
	 * 正则表达式匹配rowkey
	 * @param tablename
	 * @param rowCompareOp
	 * @param filterStr
	 * @return
	 * @throws IOException
	 */
	List<Map<String, Object>> rowkeyRegexStringComparator(String tablename, CompareOp rowCompareOp, String filterStr) throws IOException;
	
	/**
	 * rowkey是否包含
	 * @param tablename
	 * @param rowCompareOp
	 * @param filterStr
	 * @return
	 * @throws IOException
	 */
	List<Map<String, Object>> rowkeySubstringComparator(String tablename, CompareOp rowCompareOp, String filterStr) throws IOException;
	
	boolean deleteColumnFamily(String tableName,String columnFamilyName) throws IOException;
	
	boolean deleteQualifier(String tableName,String rowName,String columnFamilyName,String qualifierName) 
			throws IOException;
	
	boolean deleteRow(String tableName,String rowName) throws IOException;
	
	/**
	 * 删除表
	 * @param tableName
	 * @return
	 */
	boolean deleteTable(String tableName) throws IOException;
	
	/**
	 * 判断表是否存在
	 * @param tableName
	 * @return
	 */
	boolean tableExists(String tableName);
	
}

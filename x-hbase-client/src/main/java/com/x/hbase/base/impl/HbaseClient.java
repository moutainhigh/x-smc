package com.x.hbase.base.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.apache.hadoop.hbase.client.Delete;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.HBaseAdmin;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.filter.Filter;
import org.apache.hadoop.hbase.filter.FilterList;
import org.apache.hadoop.hbase.filter.RegexStringComparator;
import org.apache.hadoop.hbase.filter.RowFilter;
import org.apache.hadoop.hbase.filter.SingleColumnValueFilter;
import org.apache.hadoop.hbase.filter.SubstringComparator;
import org.apache.hadoop.hbase.filter.CompareFilter.CompareOp;
import org.apache.hadoop.hbase.util.Bytes;
import org.apache.hadoop.hbase.filter.BinaryComparator;
import org.apache.hadoop.hbase.filter.BinaryPrefixComparator;
import org.apache.hadoop.hbase.filter.CompareFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.x.base.exception.SystemException;
import com.x.hbase.base.interfaces.IHbaseClient;
import com.x.hbase.base.model.FamilyVO;
import com.x.hbase.base.model.PutVO;
import com.x.hbase.base.model.QualifierVO;
import com.x.hbase.util.HbaseUtil;

public class HbaseClient implements IHbaseClient{

	private static transient final Logger log = LoggerFactory.getLogger(HbaseClient.class);
	
	private static Connection connection;
	
	private static Configuration conf;
	
	public HbaseClient(JsonObject jsonObject) {
		synchronized (HbaseClient.class) {
			if(conf==null) {
				conf = HBaseConfiguration.create();
			}
			for (Entry<String, JsonElement> entry : jsonObject.entrySet()) {
		      conf.set(entry.getKey(), entry.getValue().getAsString());
		    }
			try {
				if(connection==null) {
					connection = ConnectionFactory.createConnection(conf);
				}
	        } catch (IOException e) {
	            throw new SystemException(e);
	        }
		} 
	}

	@Override
	public int creatTable(String tableName, String[] family) {
		// TODO Auto-generated method stub
		try {
            HBaseAdmin admin = (HBaseAdmin) connection.getAdmin();
            
            HTableDescriptor desc = new HTableDescriptor(TableName.valueOf(tableName));
            for (int i = 0; i < family.length; i++) {
                desc.addFamily(new HColumnDescriptor(family[i]));
            }

            if (!admin.tableExists(tableName)) {
                admin.createTable(desc);
                log.info("create HBase table " + tableName + " success!");
                return 1;
            } else {
            		log.info("HBase table " + tableName + " already exist");
            }
        } catch (IOException e) {
            throw new SystemException(e);
        }
		
		return 0;
	}

	@Override
	public void addRecord(String tableName, String rowKey, String family, String qualifier, String value)
			throws IOException {
		// TODO Auto-generated method stub
		Table table = null;
		try {
			log.info("habse add record start........");
			// System.out.println("habse add record start........");
			table = connection.getTable(TableName.valueOf(tableName));
			Put put = new Put(Bytes.toBytes(rowKey));
			put.addColumn(Bytes.toBytes(family), Bytes.toBytes(qualifier), Bytes.toBytes(value));
			table.put(put);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (table != null) {
				table.close();
			}
		}
	}

	@Override
	public Map<String, Object> get(String tablename, String rowKey) throws Exception {
		// TODO Auto-generated method stub
		
		Table table = connection.getTable(TableName.valueOf(tablename));  
        Get get = new Get(Bytes.toBytes(rowKey));  
        Result result = table.get(get);  
        log.info("Get: " + result);  
        table.close();
        return HbaseUtil.resultToMap(result);  
	}

	@Override
	public List<Map<String, Object>> scan(String tablename) throws Exception {
		// TODO Auto-generated method stub
		Table table = connection.getTable(TableName.valueOf(tablename));  
        Scan s = new Scan();  
        ResultScanner rs = table.getScanner(s);  
  
        List<Map<String, Object>> resList = new ArrayList<Map<String, Object>>();  
        for (Result r : rs) {  
            Map<String, Object> tempmap = HbaseUtil.resultToMap(r);  
            resList.add(tempmap);  
        }  
        rs.close();
        table.close();
        return resList;  
	}

	@Override
	public boolean deleteColumnFamily(String tableName, String columnFamilyName) throws IOException {
		// TODO Auto-generated method stub
		HBaseAdmin admin = (HBaseAdmin) connection.getAdmin();  
        if (admin.tableExists(tableName)) {  
            try {  
                admin.deleteColumn(tableName, columnFamilyName);  
            } catch (Exception e) {  
                e.printStackTrace();  
                return false;  
            }  
        }  
        return true;  
	}

	@Override
	public boolean deleteQualifier(String tableName, String rowName, String columnFamilyName, String qualifierName)
			throws IOException {
		// TODO Auto-generated method stub
		HBaseAdmin admin = (HBaseAdmin) connection.getAdmin();  
        Table table = connection.getTable(TableName.valueOf(tableName));  
        if (admin.tableExists(tableName)) {  
            try {  
                Delete delete = new Delete(rowName.getBytes());  
                delete.addColumns(columnFamilyName.getBytes(), qualifierName.getBytes());  
                table.delete(delete);  
            } catch (Exception e) {  
                e.printStackTrace();  
                return false;  
            } 
        }  
        table.close();
        return true; 
	}

	@Override
	public boolean deleteRow(String tableName, String rowName) throws IOException {
		// TODO Auto-generated method stub
		HBaseAdmin admin = (HBaseAdmin) connection.getAdmin();  
        Table table = connection.getTable(TableName.valueOf(tableName));  
        if (admin.tableExists(tableName)) {  
            try {  
                Delete delete = new Delete(rowName.getBytes());  
                table.delete(delete);  
            } catch (Exception e) {  
                e.printStackTrace();  
                return false;  
            }  
        }  
        table.close();
        return true;
	}

	@Override
	public boolean deleteTable(String tableName) throws IOException{
		// TODO Auto-generated method stub
		HBaseAdmin admin = (HBaseAdmin) connection.getAdmin();  
        if (admin.tableExists(tableName)) {  
            try {  
                admin.disableTable(tableName);  
                admin.deleteTable(tableName);  
            } catch (Exception e) {  
                e.printStackTrace();  
                return false;  
            }  
        }  
        return true;  
	}

	@Override
	public boolean tableExists(String tableName) {
		// TODO Auto-generated method stub
		boolean tableExists = false;
        try {
            tableExists = connection.getAdmin().tableExists(TableName.valueOf(tableName));
        } catch (IOException e) {
            throw new SystemException(e);
        }
        return tableExists;
	}

	@Override
	public List<Map<String, Object>> queryequal(String tablename, String columnFamily, String qualifier, String data)
			throws Exception {
		// TODO Auto-generated method stub
		//某列等于data的  
        Filter filter = new SingleColumnValueFilter(Bytes.toBytes(columnFamily), Bytes.toBytes(qualifier),  
                CompareFilter.CompareOp.EQUAL, Bytes.toBytes(data));  
        FilterList filterList = new FilterList();  
        filterList.addFilter(filter);  

        return query(tablename, filterList);
	}

	@Override
	public List<Map<String, Object>> queryagebetween(String tablename, String columnFamily, String qualifier,
			String mindata, String maxdata) throws Exception {
		// TODO Auto-generated method stub
		Filter filter = new SingleColumnValueFilter(Bytes.toBytes(columnFamily), Bytes.toBytes(qualifier),  
                CompareFilter.CompareOp.LESS_OR_EQUAL, Bytes.toBytes(maxdata));  
        Filter filter1 = new SingleColumnValueFilter(Bytes.toBytes(columnFamily), Bytes.toBytes(qualifier),  
                CompareFilter.CompareOp.GREATER_OR_EQUAL, Bytes.toBytes(mindata));  
        FilterList filterList = new FilterList();  
        filterList.addFilter(filter);  
        filterList.addFilter(filter1);  
        return query(tablename, filterList); 
	}

	@Override
	public List<Map<String, Object>> query(String tablename, FilterList filterList) throws Exception {
		// TODO Auto-generated method stub
		Table table = connection.getTable(TableName.valueOf(tablename));  
        Scan s = new Scan();  
        s.setFilter(filterList);  
        ResultScanner rs = table.getScanner(s);  
  
        List<Map<String, Object>> resList = new ArrayList<Map<String, Object>>();  
        for (Result r : rs) {  
            Map<String, Object> tempmap = HbaseUtil.resultToMap(r);  
            resList.add(tempmap);  
        }  
        rs.close();
        table.close();
        return resList;
	}

	@Override
	public List<Map<String, Object>> rowkeyBinaryComparator(String tablename, CompareOp rowCompareOp, String filterStr)
			throws IOException {
		// TODO Auto-generated method stub
		Table table = connection.getTable(TableName.valueOf(tablename));  
		Scan scan = new Scan();
	    	Filter filter1 = new RowFilter(rowCompareOp, new BinaryComparator(filterStr.getBytes()));
		scan.setFilter(filter1);
		ResultScanner scanner = table.getScanner(scan);
		List<Map<String, Object>> resList = new ArrayList<Map<String, Object>>();
		for (Result res : scanner) {
			Map<String, Object> tempmap = HbaseUtil.resultToMap(res);  
            resList.add(tempmap);  
		}
		scanner.close();
		table.close();
		return resList;
	}

	@Override
	public List<Map<String, Object>> rowkeyBinaryPrefixComparator(String tablename, CompareOp rowCompareOp, String filterStr)
			throws IOException {
		// TODO Auto-generated method stub
		Table table = connection.getTable(TableName.valueOf(tablename));  
		Scan scan = new Scan();
	    	Filter filter1 = new RowFilter(rowCompareOp, new BinaryPrefixComparator(filterStr.getBytes()));
		scan.setFilter(filter1);
		ResultScanner scanner = table.getScanner(scan);
		List<Map<String, Object>> resList = new ArrayList<Map<String, Object>>();
		for (Result res : scanner) {
			Map<String, Object> tempmap = HbaseUtil.resultToMap(res);  
            resList.add(tempmap);  
		}
		scanner.close();
		table.close();
		return resList;
	}

	@Override
	public List<Map<String, Object>> rowkeyRegexStringComparator(String tablename, CompareOp rowCompareOp, String filterStr)
			throws IOException {
		// TODO Auto-generated method stub
		Table table = connection.getTable(TableName.valueOf(tablename));  
		Scan scan = new Scan();
	    	Filter filter1 = new RowFilter(rowCompareOp, new RegexStringComparator(filterStr));
		scan.setFilter(filter1);
		ResultScanner scanner = table.getScanner(scan);
		List<Map<String, Object>> resList = new ArrayList<Map<String, Object>>();
		for (Result res : scanner) {
			Map<String, Object> tempmap = HbaseUtil.resultToMap(res);  
            resList.add(tempmap);  
		}
		scanner.close();
		table.close();
		return resList;
	}

	@Override
	public List<Map<String, Object>> rowkeySubstringComparator(String tablename, CompareOp rowCompareOp, String filterStr)
			throws IOException {
		// TODO Auto-generated method stub
		Table table = connection.getTable(TableName.valueOf(tablename));  
		Scan scan = new Scan();
	    	Filter filter1 = new RowFilter(rowCompareOp, new SubstringComparator(filterStr));
		scan.setFilter(filter1);
		ResultScanner scanner = table.getScanner(scan);
		List<Map<String, Object>> resList = new ArrayList<Map<String, Object>>();
		for (Result res : scanner) {
			Map<String, Object> tempmap = HbaseUtil.resultToMap(res);  
            resList.add(tempmap);  
		}
		scanner.close();
		table.close();
		return resList;
	}

	@Override
	public void addRecords(String tableName, List<PutVO> puts) throws IOException {
		// TODO Auto-generated method stub
		Table table = null;
		try {
			log.info("habse add record start........");
			// System.out.println("habse add record start........");
			table = connection.getTable(TableName.valueOf(tableName));
			if(puts!=null && puts.size()>0) {
				for(PutVO putVO : puts) {
					Put put = new Put(Bytes.toBytes(putVO.getRowkey()));
					for(FamilyVO family:putVO.getFamilies()) {
						for(QualifierVO qualifier:family.getQualifiers()) {
							put.addColumn(Bytes.toBytes(family.getFamily()), Bytes.toBytes(qualifier.getQualifier()), Bytes.toBytes(qualifier.getValue()));
						}
					}
					table.put(put);
				}
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (table != null) {
				table.close();
			}
		}
	}
	
}

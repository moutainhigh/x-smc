package com.x.smc.preprocess.topology.core.billdetail;

import java.io.IOException;
import java.sql.Timestamp;

import org.apache.commons.lang3.StringUtils;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.util.Bytes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.x.smc.preprocess.topology.core.bo.BillDetailVo;
import com.x.smc.preprocess.topology.core.constant.SmcConstants;
import com.x.storm.util.HBaseProxy;

public class BillDetailDao {

	private static Logger logger = LoggerFactory.getLogger(BillDetailDao.class);
	private byte[] column_family = Bytes.toBytes(SmcConstants.BILL_DETAIL_HBASE_FAMILY_NAME);
	
	/**
	 * 将详单数据保存到HBase中
	 * @param failureBill
	 */
	public void insertBillDetailData(BillDetailVo billDetailVo){
		String rowKey = assembleRowKey(billDetailVo);
		Table table=null;
		try {
			String tableNameStr = SmcConstants.BILL_DETAIL_HBASE_TABLE_NAME_PREFIX+billDetailVo.getBillTimeSn();
			TableName tableName = TableName.valueOf(tableNameStr);
			//如果表不存在，创建表
			if(!HBaseProxy.getConnection().getAdmin().tableExists(tableName)) {
				HTableDescriptor desc = new HTableDescriptor(tableName);
                desc.addFamily(new HColumnDescriptor(column_family));
                HBaseProxy.getConnection().getAdmin().createTable(desc);
			}
			table = HBaseProxy.getConnection().getTable(tableName);
			Put put = new Put(rowKey.getBytes());
			putData(put, billDetailVo);
			table.put(put);			
		} catch (IOException e) {
			logger.error("error", e);
		} finally{
			if(table != null){
				try {
					table.close();
				} catch (IOException e) {
					logger.error("error", e);
				}
			}
		}
	}
	
	private void putData(Put put, BillDetailVo billDetailVo) {
		put.addColumn(column_family, Bytes.toBytes("tenant_id"), toBytes(billDetailVo.getTenantId()));
		put.addColumn(column_family, Bytes.toBytes("policy_id"), toBytes(billDetailVo.getPolicyId()));
		put.addColumn(column_family, Bytes.toBytes("bsn"), toBytes(billDetailVo.getBillTimeSn()));
		put.addColumn(column_family, Bytes.toBytes("orig_fee"), toBytes(billDetailVo.getOrigFee()));
		put.addColumn(column_family, Bytes.toBytes("bill_id"), toBytes(billDetailVo.getBillId()));
		put.addColumn(column_family, Bytes.toBytes("bill_from"), toBytes(billDetailVo.getBillFrom()));
		put.addColumn(column_family, Bytes.toBytes("fee_item_id"), toBytes(billDetailVo.getFeeItemId()));
		put.addColumn(column_family, Bytes.toBytes("total_fee"), toBytes(billDetailVo.getTotalFee()));
		put.addColumn(column_family, Bytes.toBytes("object_type"), toBytes(billDetailVo.getObjectType()));
		put.addColumn(column_family, Bytes.toBytes("object_code"), toBytes(billDetailVo.getObjectCode()));
		put.addColumn(column_family, Bytes.toBytes("msg_header"), toBytes(billDetailVo.getMsgHeader()));
		put.addColumn(column_family, Bytes.toBytes("msg_body"), toBytes(billDetailVo.getMsgBody()));
	}
	
	private byte[] toBytes(Object data){
		if(data==null) {
			return "".getBytes();
		}
		if(data instanceof String) {
			return (StringUtils.isNotBlank((String)data)?(String)data:"").getBytes();
		}else if(data instanceof Long){
			return data.toString().getBytes();
		}else if(data instanceof Timestamp) {
			Long ts = ((Timestamp) data).getTime();
			return ts.toString().getBytes();
		}else if(data instanceof Double) {
			byte[] b = new byte[8];    
	        long l = Double.doubleToLongBits((Double) data);    
	        for (int i = 0; i < 8; i++) {    
	            b[i] = new Long(l).byteValue();    
	            l = l >> 8;    
	        }  
			return b;
		}
		return "".getBytes();
	}
	
	/**
	 * bsn=tenentid+policyId+cycle
	 * rowkey = bsn+objectId+feeItemId+billId
	 * @param billDetailVo
	 * @return
	 */
	private String assembleRowKey(BillDetailVo billDetailVo) {
		StringBuffer rowKey = new StringBuffer();
		rowKey.append(billDetailVo.getBillTimeSn()).append(SmcConstants.FIELD_SPLIT)
		.append(billDetailVo.getObjectType()).append(SmcConstants.FIELD_SPLIT)
		.append(billDetailVo.getObjectCode()).append(SmcConstants.FIELD_SPLIT)
		.append(billDetailVo.getFeeItemId()).append(SmcConstants.FIELD_SPLIT)
		.append(billDetailVo.getBillId());
		return rowKey.toString();
	}
}

package com.x.ic.msg.vo;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPath;
import com.x.ic.smc.sdk.cache.vo.Node;
import com.x.ic.smc.sdk.cache.vo.NodeElementMapping;
import com.x.ic.smc.sdk.cache.vo.Policy;
import com.x.ic.smc.sdk.mds.vo.SmcBusinessMessage;
import com.x.sdk.component.mds.vo.MessageAndMetadata;
import com.x.sdk.mds.vo.BusinessMessage;

public class MessageData implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String msgID;
	private String busiType;
	private String msgVersion;
	private Timestamp createTime;
	private String topicName;
	private long offset;
	private String partitionId;
	private JSONObject dataJson;
	private String dataStr;
	private List<Node> nodes;
	private String tenantId = "pubgo";
	private List<NodeElementMapping> nodeMappings;
	private List<Policy> policys;
	private List<BusinessMessage> messages = new ArrayList<>();
	private MessageData(){};
	
	
	public static MessageData build(MessageAndMetadata message) throws UnsupportedEncodingException{
		return new MessageData(message);
	}
	private  MessageData(MessageAndMetadata message) throws UnsupportedEncodingException{
		this.topicName = message.getTopic();
		this.offset = message.getOffset();
		this.partitionId = message.getPartitionId();
		
		BusinessMessage businessMessage =  JSONObject.parseObject(new String(message.getMessage(), "UTF-8"), BusinessMessage.class);
		this.busiType = businessMessage.getBusiType();
		this.createTime = businessMessage.getCreateTime();
		this.msgID = businessMessage.getMsgID();
		this.msgVersion = businessMessage.getMsgVersion();
		this.dataStr = businessMessage.getData();
		this.dataJson = JSON.parseObject(businessMessage.getData());
	}
	
	public String getStringForData(String path){
		return path;
	}
	public static void main(String[] args) {
		String str = "{\"accountId\":95,\"accountName\":\"\",\"busiTypeId\":\"prodsale\",\"completeDate\":1526975950810,\"createDate\":1526975917000,\"lastModifyDate\":1526975917000,\"ordFeeTotalVo\":{\"createDate\":1526975917000,\"feeNumberId\":1105,\"freeFee\":4,\"ordFeeDetailVos\":[{\"batchId\":12321312,\"feeNumberId\":1105,\"feeType\":\"KQ\",\"payDate\":1526975917000,\"payFee\":4,\"tenantId\":\"pubgo\"}],\"orderId\":2000000019077208,\"tenantId\":\"pubgo\",\"totalFee\":10,\"userPayFee\":6},\"orderId\":2000000019077208,\"orderProdDetailVos\":[{\"afterSale\":\"\",\"discountAmount\":\"\",\"discountRate\":\"\",\"isProductExists\":\"Y\",\"number\":\"2\",\"orderId\":2000000019077208,\"proDetailContent\":\"\",\"productCatId\":\"\",\"productId\":\"0000000000000723\",\"productModeDesc\":\"\",\"productModeParams\":\"\",\"productName\":\"会员\",\"productPrice\":\"225\",\"productStoreBarcode\":\"\",\"productType\":\"\",\"remark\":\"商品备注\",\"subtotal\":\"45\",\"tenantId\":\"pubgo\"}],\"orderTypeId\":\"1\",\"phoneNumber\":\"18988888888\",\"remark\":\"备注\",\"source\":\"\",\"state\":\"90\",\"tenantId\":\"pubgo\",\"userId\":\"13243431238\",\"userName\":\"13243431235\"}";
		JSONObject json = JSONObject.parseObject(str);
		
		//System.out.println("@当前元素："+JSONPath.eval(json, "@"));
		Object result = JSONPath.eval(json, "$.orderProdDetailVos");
		//System.out.println("array："+JSONPath.eval(json, "$.orderProdDetailVos.productId"));
		//System.out.println(result instanceof JSONArray); 
		System.out.println(JSONPath.eval(json, "$.orderProdDetailVos.size()"));
	}
	public String getMsgID() {
		return msgID;
	}
	public void setMsgID(String msgID) {
		this.msgID = msgID;
	}
	public String getBusiType() {
		return busiType;
	}
	public void setBusiType(String busiType) {
		this.busiType = busiType;
	}
	public String getMsgVersion() {
		return msgVersion;
	}
	public void setMsgVersion(String msgVersion) {
		this.msgVersion = msgVersion;
	}
	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	public String getTopicName() {
		return topicName;
	}
	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}
	public long getOffset() {
		return offset;
	}
	public void setOffset(long offset) {
		this.offset = offset;
	}
	public String getPartitionId() {
		return partitionId;
	}
	public void setPartitionId(String partitionId) {
		this.partitionId = partitionId;
	}
	
	public JSONObject getDataJson() {
		return dataJson;
	}
	public void setDataJson(JSONObject dataJson) {
		this.dataJson = dataJson;
	}
	public String getDataStr() {
		return dataStr;
	}
	public void setDataStr(String dataStr) {
		this.dataStr = dataStr;
	}
	
	
	public List<Node> getNodes() {
		return nodes;
	}


	public void setNodes(List<Node> nodes) {
		this.nodes = nodes;
	}


	public List<NodeElementMapping> getNodeMappings() {
		return nodeMappings;
	}


	public void setNodeMappings(List<NodeElementMapping> nodeMappings) {
		this.nodeMappings = nodeMappings;
	}


	public List<Policy> getPolicys() {
		return policys;
	}


	public void setPolicys(List<Policy> policys) {
		this.policys = policys;
	}


	public String getTenantId() {
		return tenantId;
	}
	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}


	public List<BusinessMessage> getMessages() {
		return messages;
	}


	public void setMessages(List<BusinessMessage> messages) {
		this.messages = messages;
	}


	
	


	
	
	
}

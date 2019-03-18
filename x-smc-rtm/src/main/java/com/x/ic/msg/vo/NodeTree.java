package com.x.ic.msg.vo;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class NodeTree {
   private Long nodeId;
   private String nodeName;
   private String nodeCode;
   private NodeTree parentNode;
   private List<NodeTree> childNodes;
   private String nodePath;
   private String nodeType;
   private String isNeedCheck;
   private String state;
   private Date createTime;
   private Date lastestTime;
   private String description;
   private String tenantId;
   private String contractId;
   
	public Long getNodeId() {
		return nodeId;
	}
	public void setNodeId(Long nodeId) {
		this.nodeId = nodeId;
	}
	public String getNodeName() {
		return nodeName;
	}
	public void setNodeName(String nodeName) {
		this.nodeName = nodeName;
	}
	public String getNodeCode() {
		return nodeCode;
	}
	public void setNodeCode(String nodeCode) {
		this.nodeCode = nodeCode;
	}
	public NodeTree getParentNode() {
		return parentNode;
	}
	public void setParentNode(NodeTree parentNode) {
		this.parentNode = parentNode;
	}
	public List<NodeTree> getChildNodes() {
		return childNodes;
	}
	public void setChildNodes(List<NodeTree> childNodes) {
		this.childNodes = childNodes;
	}
	public void addChildNode(NodeTree childNode){
		if(this.childNodes == null){
			this.childNodes = new ArrayList<NodeTree>();
			this.childNodes.add(childNode);
		}
	}
	public String getNodePath() {
		return nodePath;
	}
	public void setNodePath(String nodePath) {
		this.nodePath = nodePath;
	}
	public String getNodeType() {
		return nodeType;
	}
	public void setNodeType(String nodeType) {
		this.nodeType = nodeType;
	}
	public String getIsNeedCheck() {
		return isNeedCheck;
	}
	public void setIsNeedCheck(String isNeedCheck) {
		this.isNeedCheck = isNeedCheck;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getLastestTime() {
		return lastestTime;
	}
	public void setLastestTime(Date lastestTime) {
		this.lastestTime = lastestTime;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getTenantId() {
		return tenantId;
	}
	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}
	public String getContractId() {
		return contractId;
	}
	public void setContractId(String contractId) {
		this.contractId = contractId;
	}
   
   
}

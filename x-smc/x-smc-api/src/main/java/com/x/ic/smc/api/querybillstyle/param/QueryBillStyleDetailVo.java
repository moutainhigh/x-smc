package com.x.ic.smc.api.querybillstyle.param;

import java.io.Serializable;
import java.sql.Timestamp;

public class QueryBillStyleDetailVo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 元素编码
     */
    private String itemCode;

    /**
     * 元素标题
     */
    private String itemTitle;

    /**
     * 账单项归属
     */
    private String itemOwner;

    /**
     * 核对标识
     */
    private String checkFlag;

    /**
     * 序号
     */
    private Integer sortId;

    /**
     * 取值对象ID
     */
    private String objectId;

    /**
     * 取值元素ID
     */
    private Long elementId;

    /**
     * 创建部门
     */
    private String createDeptId;

    /**
     * 创建工号
     */
    private String createOperId;

    /**
     * 创建时间
     */
    private Timestamp createTime;

    /**
     * 更新部门
     */
    private String updateDeptId;

    /**
     * 更新工号
     */
    private String updateOperId;

    /**
     * 更新时间
     */
    private Timestamp updateTime;

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemTitle() {
        return itemTitle;
    }

    public void setItemTitle(String itemTitle) {
        this.itemTitle = itemTitle;
    }

    public String getItemOwner() {
        return itemOwner;
    }

    public void setItemOwner(String itemOwner) {
        this.itemOwner = itemOwner;
    }

    public Integer getSortId() {
        return sortId;
    }

    public void setSortId(Integer sortId) {
        this.sortId = sortId;
    }

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public Long getElementId() {
        return elementId;
    }

    public void setElementId(Long elementId) {
        this.elementId = elementId;
    }

    public String getCreateDeptId() {
        return createDeptId;
    }

    public void setCreateDeptId(String createDeptId) {
        this.createDeptId = createDeptId;
    }

    public String getCreateOperId() {
        return createOperId;
    }

    public void setCreateOperId(String createOperId) {
        this.createOperId = createOperId;
    }

    public String getUpdateDeptId() {
        return updateDeptId;
    }

    public void setUpdateDeptId(String updateDeptId) {
        this.updateDeptId = updateDeptId;
    }

    public String getUpdateOperId() {
        return updateOperId;
    }

    public void setUpdateOperId(String updateOperId) {
        this.updateOperId = updateOperId;
    }

    public Timestamp getCreateTime() {
        return createTime == null ? null : new Timestamp(createTime.getTime());
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = (createTime == null ? null : new Timestamp(createTime.getTime()));
    }

    public Timestamp getUpdateTime() {
        return updateTime == null ? null : new Timestamp(updateTime.getTime());
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = (updateTime == null ? null : new Timestamp(updateTime.getTime()));
    }

    public String getCheckFlag() {
        return checkFlag;
    }

    public void setCheckFlag(String checkFlag) {
        this.checkFlag = checkFlag;
    }

}

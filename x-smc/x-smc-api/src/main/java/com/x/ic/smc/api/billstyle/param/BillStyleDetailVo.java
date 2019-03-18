package com.x.ic.smc.api.billstyle.param;

import java.io.Serializable;

public class BillStyleDetailVo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 元素编码 必填
     */
    private String itemCode;

    /**
     * 元素标题 必填
     */
    private String itemTitle;

    /**
     * 账单项归属 必填
     */
    private String itemOwner;

    /**
     * 序号 必填
     */
    private Integer sortId;

    /**
     * 核对标识 必填
     */
    private String checkFlag;

    /**
     * 取值对象ID 必填
     */
    private String objectId;

    /**
     * 取值元素ID 必填
     */
    private Long elementId;

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

    public String getCheckFlag() {
        return checkFlag;
    }

    public void setCheckFlag(String checkFlag) {
        this.checkFlag = checkFlag;
    }

}

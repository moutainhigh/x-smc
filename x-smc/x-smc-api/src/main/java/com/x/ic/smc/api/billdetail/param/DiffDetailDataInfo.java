package com.x.ic.smc.api.billdetail.param;

import java.io.Serializable;

public class DiffDetailDataInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 行键
     */
    private String rowKey;

    /**
     * 租户ID
     */
    private String tenantId;

    /**
     * 账单ID
     */
    private Long billId;

    /**
     * 数据项
     */
    private String data;

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public Long getBillId() {
        return billId;
    }

    public void setBillId(Long billId) {
        this.billId = billId;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getRowKey() {
        return rowKey;
    }

    public void setRowKey(String rowKey) {
        this.rowKey = rowKey;
    }
}

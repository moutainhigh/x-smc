package com.x.ic.smc.api.billdata.param;

import java.io.Serializable;

public class BillItemData implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 科目ID
     */
    private String feeItemId;

    /**
     * 科目名称
     */
    private String feeItemName;

    /**
     * 金额
     */
    private float totalFee;

    public String getFeeItemId() {
        return feeItemId;
    }

    public void setFeeItemId(String feeItemId) {
        this.feeItemId = feeItemId;
    }

    public String getFeeItemName() {
        return feeItemName;
    }

    public void setFeeItemName(String feeItemName) {
        this.feeItemName = feeItemName;
    }

    public float getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(float totalFee) {
        this.totalFee = totalFee;
    }

}
package com.x.ic.smc.api.billdetail.param;

import java.io.Serializable;

public class FeeItemData implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 科目ID
     */
    private String feeItemId;

    /**
     * 科目金额
     */
    private Float totalFee;

    /**
     * 科目名称
     */
    private String feeItemName;

    /**
     * 差异金额
     */
    private Float diffFee;

    public String getFeeItemId() {
        return feeItemId;
    }

    public void setFeeItemId(String feeItemId) {
        this.feeItemId = feeItemId;
    }

    public Float getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(Float totalFee) {
        this.totalFee = totalFee;
    }

    public Float getDiffFee() {
        return diffFee;
    }

    public void setDiffFee(Float diffFee) {
        this.diffFee = diffFee;
    }

    public String getFeeItemName() {
        return feeItemName;
    }

    public void setFeeItemName(String feeItemName) {
        this.feeItemName = feeItemName;
    }

}

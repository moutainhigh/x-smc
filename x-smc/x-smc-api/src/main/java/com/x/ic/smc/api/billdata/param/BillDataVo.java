package com.x.ic.smc.api.billdata.param;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

public class BillDataVo implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 账单ID
     */
    private Long billId;

    /**
     * 政策编码
     */
    private String policyCode;

    /**
     * 结算对象
     */
    private String stlObjectId;

    /**
     * 结算账期
     */
    private String billTimeSn;

    /**
     * 账单开始时间
     */
    private Timestamp billStartTime;

    /**
     * 账单截止时间
     */
    private Timestamp billEndTime;

    /**
     * 对账结果
     */
    private String checkState;

    /**
     * 对账结果描述
     */
    private String checkStateDesc;

    /**
     * 生成对账时间
     */
    private Timestamp checkTime;

    /**
     * 调账后总金额
     */
    private Float finalFee;

    /**
     * 账单科目
     */
    private List<BillItemData> billItemDatas;

    public List<BillItemData> getBillItemDatas() {
        return billItemDatas;
    }

    public void setBillItemDatas(List<BillItemData> billItemDatas) {
        this.billItemDatas = billItemDatas;
    }

    public Long getBillId() {
        return billId;
    }

    public void setBillId(Long billId) {
        this.billId = billId;
    }

    public String getPolicyCode() {
        return policyCode;
    }

    public void setPolicyCode(String policyCode) {
        this.policyCode = policyCode == null ? null : policyCode.trim();
    }

    public String getStlObjectId() {
        return stlObjectId;
    }

    public void setStlObjectId(String stlObjectId) {
        this.stlObjectId = stlObjectId == null ? null : stlObjectId.trim();
    }

    public String getBillTimeSn() {
        return billTimeSn;
    }

    public void setBillTimeSn(String billTimeSn) {
        this.billTimeSn = billTimeSn == null ? null : billTimeSn.trim();
    }

    public Timestamp getBillStartTime() {
        return billStartTime;
    }

    public void setBillStartTime(Timestamp billStartTime) {
        this.billStartTime = billStartTime;
    }

    public Timestamp getBillEndTime() {
        return billEndTime;
    }

    public void setBillEndTime(Timestamp billEndTime) {
        this.billEndTime = billEndTime;
    }

    public String getCheckState() {
        return checkState;
    }

    public void setCheckState(String checkState) {
        this.checkState = checkState == null ? null : checkState.trim();
    }

    public String getCheckStateDesc() {
        return checkStateDesc;
    }

    public void setCheckStateDesc(String checkStateDesc) {
        this.checkStateDesc = checkStateDesc == null ? null : checkStateDesc.trim();
    }

    public Timestamp getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(Timestamp checkTime) {
        this.checkTime = checkTime;
    }

    public Float getFinalFee() {
        return finalFee;
    }

    public void setFinalFee(Float finalFee) {
        this.finalFee = finalFee;
    }
}

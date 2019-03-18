package com.x.ic.smc.api.billdetail.param;

import java.util.List;

import com.x.base.vo.BaseResponse;


public class CheckResultQueryResponse extends BaseResponse {
    private static final long serialVersionUID = 1L;

    /**
     * 账单ID
     */
    private Long billId;

    /**
     * 租户ID
     */
    private String tenantId;

    /**
     * 政策编码
     */
    private String policyCode;

    /**
     * 结算对象
     */
    private String stlObjectId;

    /**
     * 账期
     */
    private String billTimeSn;

    /**
     * 账单开始时间
     */
    private String billStartTimeStr;

    /**
     * 账单截止时间
     */
    private String billEndTimeStr;

    /**
     * 生成时间
     */
    private String createTimeStr;

    /**
     * 总费用
     */
    private Float origFee;

    /**
     * 对账结果
     */
    private String checkState;

    /**
     * 差异金额
     */
    private Float diffFee;

    /**
     * 对账结果描述
     */
    private String checkStateDesc;

    /**
     * 账单科目
     */
    private List<FeeItemData> feeItemDatas;

    public Long getBillId() {
        return billId;
    }

    public void setBillId(Long billId) {
        this.billId = billId;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getPolicyCode() {
        return policyCode;
    }

    public void setPolicyCode(String policyCode) {
        this.policyCode = policyCode;
    }

    public String getStlObjectId() {
        return stlObjectId;
    }

    public void setStlObjectId(String stlObjectId) {
        this.stlObjectId = stlObjectId;
    }

    public String getBillTimeSn() {
        return billTimeSn;
    }

    public void setBillTimeSn(String billTimeSn) {
        this.billTimeSn = billTimeSn;
    }

    public Float getOrigFee() {
        return origFee;
    }

    public void setOrigFee(Float origFee) {
        this.origFee = origFee;
    }

    public String getCheckState() {
        return checkState;
    }

    public void setCheckState(String checkState) {
        this.checkState = checkState;
    }

    public Float getDiffFee() {
        return diffFee;
    }

    public void setDiffFee(Float diffFee) {
        this.diffFee = diffFee;
    }

    public String getCheckStateDesc() {
        return checkStateDesc;
    }

    public void setCheckStateDesc(String checkStateDesc) {
        this.checkStateDesc = checkStateDesc;
    }

    public List<FeeItemData> getFeeItemDatas() {
        return feeItemDatas;
    }

    public void setFeeItemDatas(List<FeeItemData> feeItemDatas) {
        this.feeItemDatas = feeItemDatas;
    }

    public String getBillStartTimeStr() {
        return billStartTimeStr;
    }

    public void setBillStartTimeStr(String billStartTimeStr) {
        this.billStartTimeStr = billStartTimeStr;
    }

    public String getBillEndTimeStr() {
        return billEndTimeStr;
    }

    public void setBillEndTimeStr(String billEndTimeStr) {
        this.billEndTimeStr = billEndTimeStr;
    }

    public String getCreateTimeStr() {
        return createTimeStr;
    }

    public void setCreateTimeStr(String createTimeStr) {
        this.createTimeStr = createTimeStr;
    }
}

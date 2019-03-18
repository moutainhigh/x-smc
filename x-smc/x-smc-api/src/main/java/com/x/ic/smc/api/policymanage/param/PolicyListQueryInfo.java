package com.x.ic.smc.api.policymanage.param;

import java.io.Serializable;

public class PolicyListQueryInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 政策ID
     */
    private Long policyId;

    /**
     * 租户ID
     */
    private String tenantId;

    /**
     * 政策编码
     */
    private String policyCode;

    /**
     * 政策名称
     */
    private String policyName;

    /**
     * 政策生效时间
     */
    private String startTimeStr;

    /**
     * 政策失效时间
     */
    private String endTimeStr;

    /**
     * 政策类型
     */
    private String policyType;

    /**
     * 政策描述
     */
    private String policyDesc;

    /**
     * 执行周期，realtime:实时 day:天 week:周 month:月 year:年
     */
    private String execCycle;

    /**
     * 执行时间设定
     */
    private String execTimeStr;

    /**
     * 政策对应业务数据，cust：客户 subs：订购 order：使用流水
     */
    private String dataObjectId;

    /**
     * 执行周期对应时间元素ID
     */
    private Long dataElementId;

    /**
     * 结算对象
     */
    private String stlObjectId;

    /**
     * 结算属性
     */
    private Long stlElementId;

    /**
     * 具体结算方(合同号)
     */
    private String stlElementSn;

    /**
     * 账单样式编码
     */
    private String billStyleSn;

    /**
     * 对账标识,1：是 0：否
     */
    private String checkFeeFlag;

    /**
     * 政策状态,1：正常 0：注销
     */
    private String state;

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
    private String createTimeStr;

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
    private String updateTimeStr;

    public Long getPolicyId() {
        return policyId;
    }

    public void setPolicyId(Long policyId) {
        this.policyId = policyId;
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

    public String getPolicyName() {
        return policyName;
    }

    public void setPolicyName(String policyName) {
        this.policyName = policyName;
    }

    public String getStartTimeStr() {
        return startTimeStr;
    }

    public void setStartTimeStr(String startTimeStr) {
        this.startTimeStr = startTimeStr;
    }

    public String getEndTimeStr() {
        return endTimeStr;
    }

    public void setEndTimeStr(String endTimeStr) {
        this.endTimeStr = endTimeStr;
    }

    public String getPolicyType() {
        return policyType;
    }

    public void setPolicyType(String policyType) {
        this.policyType = policyType;
    }

    public String getPolicyDesc() {
        return policyDesc;
    }

    public void setPolicyDesc(String policyDesc) {
        this.policyDesc = policyDesc;
    }

    public String getExecCycle() {
        return execCycle;
    }

    public void setExecCycle(String execCycle) {
        this.execCycle = execCycle;
    }

    public String getExecTimeStr() {
        return execTimeStr;
    }

    public void setExecTimeStr(String execTimeStr) {
        this.execTimeStr = execTimeStr;
    }

    public String getDataObjectId() {
        return dataObjectId;
    }

    public void setDataObjectId(String dataObjectId) {
        this.dataObjectId = dataObjectId;
    }

    public Long getDataElementId() {
        return dataElementId;
    }

    public void setDataElementId(Long dataElementId) {
        this.dataElementId = dataElementId;
    }

    public String getStlObjectId() {
        return stlObjectId;
    }

    public void setStlObjectId(String stlObjectId) {
        this.stlObjectId = stlObjectId;
    }

    public Long getStlElementId() {
        return stlElementId;
    }

    public void setStlElementId(Long stlElementId) {
        this.stlElementId = stlElementId;
    }

    public String getBillStyleSn() {
        return billStyleSn;
    }

    public void setBillStyleSn(String billStyleSn) {
        this.billStyleSn = billStyleSn;
    }

    public String getCheckFeeFlag() {
        return checkFeeFlag;
    }

    public void setCheckFeeFlag(String checkFeeFlag) {
        this.checkFeeFlag = checkFeeFlag;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
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

    public String getCreateTimeStr() {
        return createTimeStr;
    }

    public void setCreateTimeStr(String createTimeStr) {
        this.createTimeStr = createTimeStr;
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

    public String getUpdateTimeStr() {
        return updateTimeStr;
    }

    public void setUpdateTimeStr(String updateTimeStr) {
        this.updateTimeStr = updateTimeStr;
    }

    public String getStlElementSn() {
        return stlElementSn;
    }

    public void setStlElementSn(String stlElementSn) {
        this.stlElementSn = stlElementSn;
    }
}

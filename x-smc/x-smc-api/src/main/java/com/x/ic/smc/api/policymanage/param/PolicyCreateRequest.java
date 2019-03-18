package com.x.ic.smc.api.policymanage.param;

import java.util.List;

import com.x.base.vo.BaseInfo;


public class PolicyCreateRequest extends BaseInfo {

    private static final long serialVersionUID = 1L;

    /**
     * 政策编码，本租户唯一
     */
    private String policyCode;

    /**
     * 政策名称
     */
    private String policyName;

    /**
     * 政策生效时间，yyyymmdd格式
     */
    private String startTimeStr;

    /**
     * 政策失效时间，yyyymmdd格式
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
     * 执行周期枚举值<br>
     * Date: 2016年3月17日 <br>
     * Copyright (c) 2016 asiainfo.com <br>
     * 
     * @author mayt
     */
    public static final class ExecCycle {
        private ExecCycle() {
        }

        /**
         * 实时
         */
        public static final String REALTIME = "realtime";

        /**
         * 天
         */
        public static final String DAY = "day";

        /**
         * 周
         */
        public static final String WEEK = "week";

        /**
         * 月
         */
        public static final String MONTH = "month";

        /**
         * 年
         */
        public static final String YEAR = "year";
    }

    /**
     * 执行时间设定
     */
    private String execTimeStr;

    /**
     * 政策对应业务数据，cust：客户 subs：订购 order：使用流水
     */
    private String dataObjectId;

    /**
     * 政策对应业务数据枚举值<br>
     * Date: 2016年3月17日 <br>
     * Copyright (c) 2016 asiainfo.com <br>
     * 
     * @author mayt
     */
    public static final class DataObjectId {
        private DataObjectId() {
        }

        /**
         * 客户
         */
        public static final String CUST = "cust";

        /**
         * 订购
         */
        public static final String SUBS = "subs";

        /**
         * 使用流水
         */
        public static final String ORDER = "order";
    }

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
     * 对账标识
     */
    private String checkFeeFlag;

    /**
     * 操作部门
     */
    private String optDeptId;

    /**
     * 操作工号
     */
    private String optOperId;

    /**
     * 政策项
     */
    private List<PolicyItemCreateInfo> policyItemCreateInfo;

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

    public void setStartTimeStr(String startTime) {
        this.startTimeStr = startTime;
    }

    public String getEndTimeStr() {
        return endTimeStr;
    }

    public void setEndTimeStr(String endTime) {
        this.endTimeStr = endTime;
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

    public String getOptDeptId() {
        return optDeptId;
    }

    public void setOptDeptId(String optDeptId) {
        this.optDeptId = optDeptId;
    }

    public String getOptOperId() {
        return optOperId;
    }

    public void setOptOperId(String optOperId) {
        this.optOperId = optOperId;
    }

    public List<PolicyItemCreateInfo> getPolicyItemCreateInfo() {
        return policyItemCreateInfo;
    }

    public void setPolicyItemCreateInfo(List<PolicyItemCreateInfo> policyItemCreateInfo) {
        this.policyItemCreateInfo = policyItemCreateInfo;
    }

    public String getStlElementSn() {
        return stlElementSn;
    }

    public void setStlElementSn(String stlElementSn) {
        this.stlElementSn = stlElementSn;
    }

}

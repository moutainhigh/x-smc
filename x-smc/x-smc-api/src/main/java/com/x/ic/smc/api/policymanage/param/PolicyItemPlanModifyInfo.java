package com.x.ic.smc.api.policymanage.param;

import java.io.Serializable;
import java.util.List;

public class PolicyItemPlanModifyInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 算费属性
     */
    private Long elementId;

    /**
     * 费用科目
     */
    private String feeItem;

    /**
     * 策略类型，normal 标准： 统一的策略 step 阶梯：分阶梯计费， switch 分档：满足某档后，所有数据所此当费率计算
     */
    private String planType;

    public static final class PlanType {private PlanType() {
    }
        /**
         * 标准
         */
        public static final String NORMAL = "normal";

        /**
         * 阶梯
         */
        public static final String STEP = "step";

        /**
         * 分档
         */
        public static final String GRADING = "switch";
    }

    /**
     * 算费方式，ratio：按比例 fixed：按固定金额 price：单价
     */
    private String calType;

    public static final class CalType {private CalType() {
    }
        /**
         * 按比例
         */
        public static final String RATIO = "ratio";

        /**
         * 按固定金额
         */
        public static final String FIXED = "fixed";

        /**
         * 单价
         */
        public static final String PRICE = "price";
    }

    /**
     * 标准策略取值,策略类型选normal 标准时必填
     */
    private String normalCalValue;

    /**
     * 阶梯或分档策略取值,策略类型选step阶梯或switch分档时必填
     */
    private List<StepCalValue> stepCalValues;

    public Long getElementId() {
        return elementId;
    }

    public void setElementId(Long elementId) {
        this.elementId = elementId;
    }

    public String getFeeItem() {
        return feeItem;
    }

    public void setFeeItem(String feeItem) {
        this.feeItem = feeItem;
    }

    public String getPlanType() {
        return planType;
    }

    public void setPlanType(String planType) {
        this.planType = planType;
    }

    public String getCalType() {
        return calType;
    }

    public void setCalType(String calType) {
        this.calType = calType;
    }

    public String getNormalCalValue() {
        return normalCalValue;
    }

    public void setNormalCalValue(String normalCalValue) {
        this.normalCalValue = normalCalValue;
    }

    public List<StepCalValue> getStepCalValues() {
        return stepCalValues;
    }

    public void setStepCalValues(List<StepCalValue> stepCalValues) {
        this.stepCalValues = stepCalValues;
    }
}

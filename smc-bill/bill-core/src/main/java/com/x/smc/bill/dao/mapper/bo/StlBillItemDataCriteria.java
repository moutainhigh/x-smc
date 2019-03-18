package com.x.smc.bill.dao.mapper.bo;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class StlBillItemDataCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public StlBillItemDataCriteria() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public void setLimitStart(Integer limitStart) {
        this.limitStart=limitStart;
    }

    public Integer getLimitStart() {
        return limitStart;
    }

    public void setLimitEnd(Integer limitEnd) {
        this.limitEnd=limitEnd;
    }

    public Integer getLimitEnd() {
        return limitEnd;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andBillItemIdIsNull() {
            addCriterion("BILL_ITEM_ID is null");
            return (Criteria) this;
        }

        public Criteria andBillItemIdIsNotNull() {
            addCriterion("BILL_ITEM_ID is not null");
            return (Criteria) this;
        }

        public Criteria andBillItemIdEqualTo(Long value) {
            addCriterion("BILL_ITEM_ID =", value, "billItemId");
            return (Criteria) this;
        }

        public Criteria andBillItemIdNotEqualTo(Long value) {
            addCriterion("BILL_ITEM_ID <>", value, "billItemId");
            return (Criteria) this;
        }

        public Criteria andBillItemIdGreaterThan(Long value) {
            addCriterion("BILL_ITEM_ID >", value, "billItemId");
            return (Criteria) this;
        }

        public Criteria andBillItemIdGreaterThanOrEqualTo(Long value) {
            addCriterion("BILL_ITEM_ID >=", value, "billItemId");
            return (Criteria) this;
        }

        public Criteria andBillItemIdLessThan(Long value) {
            addCriterion("BILL_ITEM_ID <", value, "billItemId");
            return (Criteria) this;
        }

        public Criteria andBillItemIdLessThanOrEqualTo(Long value) {
            addCriterion("BILL_ITEM_ID <=", value, "billItemId");
            return (Criteria) this;
        }

        public Criteria andBillItemIdIn(List<Long> values) {
            addCriterion("BILL_ITEM_ID in", values, "billItemId");
            return (Criteria) this;
        }

        public Criteria andBillItemIdNotIn(List<Long> values) {
            addCriterion("BILL_ITEM_ID not in", values, "billItemId");
            return (Criteria) this;
        }

        public Criteria andBillItemIdBetween(Long value1, Long value2) {
            addCriterion("BILL_ITEM_ID between", value1, value2, "billItemId");
            return (Criteria) this;
        }

        public Criteria andBillItemIdNotBetween(Long value1, Long value2) {
            addCriterion("BILL_ITEM_ID not between", value1, value2, "billItemId");
            return (Criteria) this;
        }

        public Criteria andBillIdIsNull() {
            addCriterion("BILL_ID is null");
            return (Criteria) this;
        }

        public Criteria andBillIdIsNotNull() {
            addCriterion("BILL_ID is not null");
            return (Criteria) this;
        }

        public Criteria andBillIdEqualTo(Long value) {
            addCriterion("BILL_ID =", value, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdNotEqualTo(Long value) {
            addCriterion("BILL_ID <>", value, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdGreaterThan(Long value) {
            addCriterion("BILL_ID >", value, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdGreaterThanOrEqualTo(Long value) {
            addCriterion("BILL_ID >=", value, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdLessThan(Long value) {
            addCriterion("BILL_ID <", value, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdLessThanOrEqualTo(Long value) {
            addCriterion("BILL_ID <=", value, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdIn(List<Long> values) {
            addCriterion("BILL_ID in", values, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdNotIn(List<Long> values) {
            addCriterion("BILL_ID not in", values, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdBetween(Long value1, Long value2) {
            addCriterion("BILL_ID between", value1, value2, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdNotBetween(Long value1, Long value2) {
            addCriterion("BILL_ID not between", value1, value2, "billId");
            return (Criteria) this;
        }

        public Criteria andTenantIdIsNull() {
            addCriterion("TENANT_ID is null");
            return (Criteria) this;
        }

        public Criteria andTenantIdIsNotNull() {
            addCriterion("TENANT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andTenantIdEqualTo(String value) {
            addCriterion("TENANT_ID =", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdNotEqualTo(String value) {
            addCriterion("TENANT_ID <>", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdGreaterThan(String value) {
            addCriterion("TENANT_ID >", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdGreaterThanOrEqualTo(String value) {
            addCriterion("TENANT_ID >=", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdLessThan(String value) {
            addCriterion("TENANT_ID <", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdLessThanOrEqualTo(String value) {
            addCriterion("TENANT_ID <=", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdLike(String value) {
            addCriterion("TENANT_ID like", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdNotLike(String value) {
            addCriterion("TENANT_ID not like", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdIn(List<String> values) {
            addCriterion("TENANT_ID in", values, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdNotIn(List<String> values) {
            addCriterion("TENANT_ID not in", values, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdBetween(String value1, String value2) {
            addCriterion("TENANT_ID between", value1, value2, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdNotBetween(String value1, String value2) {
            addCriterion("TENANT_ID not between", value1, value2, "tenantId");
            return (Criteria) this;
        }

        public Criteria andItemTypeIsNull() {
            addCriterion("ITEM_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andItemTypeIsNotNull() {
            addCriterion("ITEM_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andItemTypeEqualTo(String value) {
            addCriterion("ITEM_TYPE =", value, "itemType");
            return (Criteria) this;
        }

        public Criteria andItemTypeNotEqualTo(String value) {
            addCriterion("ITEM_TYPE <>", value, "itemType");
            return (Criteria) this;
        }

        public Criteria andItemTypeGreaterThan(String value) {
            addCriterion("ITEM_TYPE >", value, "itemType");
            return (Criteria) this;
        }

        public Criteria andItemTypeGreaterThanOrEqualTo(String value) {
            addCriterion("ITEM_TYPE >=", value, "itemType");
            return (Criteria) this;
        }

        public Criteria andItemTypeLessThan(String value) {
            addCriterion("ITEM_TYPE <", value, "itemType");
            return (Criteria) this;
        }

        public Criteria andItemTypeLessThanOrEqualTo(String value) {
            addCriterion("ITEM_TYPE <=", value, "itemType");
            return (Criteria) this;
        }

        public Criteria andItemTypeLike(String value) {
            addCriterion("ITEM_TYPE like", value, "itemType");
            return (Criteria) this;
        }

        public Criteria andItemTypeNotLike(String value) {
            addCriterion("ITEM_TYPE not like", value, "itemType");
            return (Criteria) this;
        }

        public Criteria andItemTypeIn(List<String> values) {
            addCriterion("ITEM_TYPE in", values, "itemType");
            return (Criteria) this;
        }

        public Criteria andItemTypeNotIn(List<String> values) {
            addCriterion("ITEM_TYPE not in", values, "itemType");
            return (Criteria) this;
        }

        public Criteria andItemTypeBetween(String value1, String value2) {
            addCriterion("ITEM_TYPE between", value1, value2, "itemType");
            return (Criteria) this;
        }

        public Criteria andItemTypeNotBetween(String value1, String value2) {
            addCriterion("ITEM_TYPE not between", value1, value2, "itemType");
            return (Criteria) this;
        }

        public Criteria andFeeItemIdIsNull() {
            addCriterion("FEE_ITEM_ID is null");
            return (Criteria) this;
        }

        public Criteria andFeeItemIdIsNotNull() {
            addCriterion("FEE_ITEM_ID is not null");
            return (Criteria) this;
        }

        public Criteria andFeeItemIdEqualTo(String value) {
            addCriterion("FEE_ITEM_ID =", value, "feeItemId");
            return (Criteria) this;
        }

        public Criteria andFeeItemIdNotEqualTo(String value) {
            addCriterion("FEE_ITEM_ID <>", value, "feeItemId");
            return (Criteria) this;
        }

        public Criteria andFeeItemIdGreaterThan(String value) {
            addCriterion("FEE_ITEM_ID >", value, "feeItemId");
            return (Criteria) this;
        }

        public Criteria andFeeItemIdGreaterThanOrEqualTo(String value) {
            addCriterion("FEE_ITEM_ID >=", value, "feeItemId");
            return (Criteria) this;
        }

        public Criteria andFeeItemIdLessThan(String value) {
            addCriterion("FEE_ITEM_ID <", value, "feeItemId");
            return (Criteria) this;
        }

        public Criteria andFeeItemIdLessThanOrEqualTo(String value) {
            addCriterion("FEE_ITEM_ID <=", value, "feeItemId");
            return (Criteria) this;
        }

        public Criteria andFeeItemIdLike(String value) {
            addCriterion("FEE_ITEM_ID like", value, "feeItemId");
            return (Criteria) this;
        }

        public Criteria andFeeItemIdNotLike(String value) {
            addCriterion("FEE_ITEM_ID not like", value, "feeItemId");
            return (Criteria) this;
        }

        public Criteria andFeeItemIdIn(List<String> values) {
            addCriterion("FEE_ITEM_ID in", values, "feeItemId");
            return (Criteria) this;
        }

        public Criteria andFeeItemIdNotIn(List<String> values) {
            addCriterion("FEE_ITEM_ID not in", values, "feeItemId");
            return (Criteria) this;
        }

        public Criteria andFeeItemIdBetween(String value1, String value2) {
            addCriterion("FEE_ITEM_ID between", value1, value2, "feeItemId");
            return (Criteria) this;
        }

        public Criteria andFeeItemIdNotBetween(String value1, String value2) {
            addCriterion("FEE_ITEM_ID not between", value1, value2, "feeItemId");
            return (Criteria) this;
        }

        public Criteria andTotalFeeIsNull() {
            addCriterion("TOTAL_FEE is null");
            return (Criteria) this;
        }

        public Criteria andTotalFeeIsNotNull() {
            addCriterion("TOTAL_FEE is not null");
            return (Criteria) this;
        }

        public Criteria andTotalFeeEqualTo(Float value) {
            addCriterion("TOTAL_FEE =", value, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeNotEqualTo(Float value) {
            addCriterion("TOTAL_FEE <>", value, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeGreaterThan(Float value) {
            addCriterion("TOTAL_FEE >", value, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeGreaterThanOrEqualTo(Float value) {
            addCriterion("TOTAL_FEE >=", value, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeLessThan(Float value) {
            addCriterion("TOTAL_FEE <", value, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeLessThanOrEqualTo(Float value) {
            addCriterion("TOTAL_FEE <=", value, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeIn(List<Float> values) {
            addCriterion("TOTAL_FEE in", values, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeNotIn(List<Float> values) {
            addCriterion("TOTAL_FEE not in", values, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeBetween(Float value1, Float value2) {
            addCriterion("TOTAL_FEE between", value1, value2, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeNotBetween(Float value1, Float value2) {
            addCriterion("TOTAL_FEE not between", value1, value2, "totalFee");
            return (Criteria) this;
        }

        public Criteria andCheckStateIsNull() {
            addCriterion("CHECK_STATE is null");
            return (Criteria) this;
        }

        public Criteria andCheckStateIsNotNull() {
            addCriterion("CHECK_STATE is not null");
            return (Criteria) this;
        }

        public Criteria andCheckStateEqualTo(String value) {
            addCriterion("CHECK_STATE =", value, "checkState");
            return (Criteria) this;
        }

        public Criteria andCheckStateNotEqualTo(String value) {
            addCriterion("CHECK_STATE <>", value, "checkState");
            return (Criteria) this;
        }

        public Criteria andCheckStateGreaterThan(String value) {
            addCriterion("CHECK_STATE >", value, "checkState");
            return (Criteria) this;
        }

        public Criteria andCheckStateGreaterThanOrEqualTo(String value) {
            addCriterion("CHECK_STATE >=", value, "checkState");
            return (Criteria) this;
        }

        public Criteria andCheckStateLessThan(String value) {
            addCriterion("CHECK_STATE <", value, "checkState");
            return (Criteria) this;
        }

        public Criteria andCheckStateLessThanOrEqualTo(String value) {
            addCriterion("CHECK_STATE <=", value, "checkState");
            return (Criteria) this;
        }

        public Criteria andCheckStateLike(String value) {
            addCriterion("CHECK_STATE like", value, "checkState");
            return (Criteria) this;
        }

        public Criteria andCheckStateNotLike(String value) {
            addCriterion("CHECK_STATE not like", value, "checkState");
            return (Criteria) this;
        }

        public Criteria andCheckStateIn(List<String> values) {
            addCriterion("CHECK_STATE in", values, "checkState");
            return (Criteria) this;
        }

        public Criteria andCheckStateNotIn(List<String> values) {
            addCriterion("CHECK_STATE not in", values, "checkState");
            return (Criteria) this;
        }

        public Criteria andCheckStateBetween(String value1, String value2) {
            addCriterion("CHECK_STATE between", value1, value2, "checkState");
            return (Criteria) this;
        }

        public Criteria andCheckStateNotBetween(String value1, String value2) {
            addCriterion("CHECK_STATE not between", value1, value2, "checkState");
            return (Criteria) this;
        }

        public Criteria andDiffFeeIsNull() {
            addCriterion("DIFF_FEE is null");
            return (Criteria) this;
        }

        public Criteria andDiffFeeIsNotNull() {
            addCriterion("DIFF_FEE is not null");
            return (Criteria) this;
        }

        public Criteria andDiffFeeEqualTo(Float value) {
            addCriterion("DIFF_FEE =", value, "diffFee");
            return (Criteria) this;
        }

        public Criteria andDiffFeeNotEqualTo(Float value) {
            addCriterion("DIFF_FEE <>", value, "diffFee");
            return (Criteria) this;
        }

        public Criteria andDiffFeeGreaterThan(Float value) {
            addCriterion("DIFF_FEE >", value, "diffFee");
            return (Criteria) this;
        }

        public Criteria andDiffFeeGreaterThanOrEqualTo(Float value) {
            addCriterion("DIFF_FEE >=", value, "diffFee");
            return (Criteria) this;
        }

        public Criteria andDiffFeeLessThan(Float value) {
            addCriterion("DIFF_FEE <", value, "diffFee");
            return (Criteria) this;
        }

        public Criteria andDiffFeeLessThanOrEqualTo(Float value) {
            addCriterion("DIFF_FEE <=", value, "diffFee");
            return (Criteria) this;
        }

        public Criteria andDiffFeeIn(List<Float> values) {
            addCriterion("DIFF_FEE in", values, "diffFee");
            return (Criteria) this;
        }

        public Criteria andDiffFeeNotIn(List<Float> values) {
            addCriterion("DIFF_FEE not in", values, "diffFee");
            return (Criteria) this;
        }

        public Criteria andDiffFeeBetween(Float value1, Float value2) {
            addCriterion("DIFF_FEE between", value1, value2, "diffFee");
            return (Criteria) this;
        }

        public Criteria andDiffFeeNotBetween(Float value1, Float value2) {
            addCriterion("DIFF_FEE not between", value1, value2, "diffFee");
            return (Criteria) this;
        }

        public Criteria andCheckStateDescIsNull() {
            addCriterion("CHECK_STATE_DESC is null");
            return (Criteria) this;
        }

        public Criteria andCheckStateDescIsNotNull() {
            addCriterion("CHECK_STATE_DESC is not null");
            return (Criteria) this;
        }

        public Criteria andCheckStateDescEqualTo(String value) {
            addCriterion("CHECK_STATE_DESC =", value, "checkStateDesc");
            return (Criteria) this;
        }

        public Criteria andCheckStateDescNotEqualTo(String value) {
            addCriterion("CHECK_STATE_DESC <>", value, "checkStateDesc");
            return (Criteria) this;
        }

        public Criteria andCheckStateDescGreaterThan(String value) {
            addCriterion("CHECK_STATE_DESC >", value, "checkStateDesc");
            return (Criteria) this;
        }

        public Criteria andCheckStateDescGreaterThanOrEqualTo(String value) {
            addCriterion("CHECK_STATE_DESC >=", value, "checkStateDesc");
            return (Criteria) this;
        }

        public Criteria andCheckStateDescLessThan(String value) {
            addCriterion("CHECK_STATE_DESC <", value, "checkStateDesc");
            return (Criteria) this;
        }

        public Criteria andCheckStateDescLessThanOrEqualTo(String value) {
            addCriterion("CHECK_STATE_DESC <=", value, "checkStateDesc");
            return (Criteria) this;
        }

        public Criteria andCheckStateDescLike(String value) {
            addCriterion("CHECK_STATE_DESC like", value, "checkStateDesc");
            return (Criteria) this;
        }

        public Criteria andCheckStateDescNotLike(String value) {
            addCriterion("CHECK_STATE_DESC not like", value, "checkStateDesc");
            return (Criteria) this;
        }

        public Criteria andCheckStateDescIn(List<String> values) {
            addCriterion("CHECK_STATE_DESC in", values, "checkStateDesc");
            return (Criteria) this;
        }

        public Criteria andCheckStateDescNotIn(List<String> values) {
            addCriterion("CHECK_STATE_DESC not in", values, "checkStateDesc");
            return (Criteria) this;
        }

        public Criteria andCheckStateDescBetween(String value1, String value2) {
            addCriterion("CHECK_STATE_DESC between", value1, value2, "checkStateDesc");
            return (Criteria) this;
        }

        public Criteria andCheckStateDescNotBetween(String value1, String value2) {
            addCriterion("CHECK_STATE_DESC not between", value1, value2, "checkStateDesc");
            return (Criteria) this;
        }

        public Criteria andCheckTimeIsNull() {
            addCriterion("CHECK_TIME is null");
            return (Criteria) this;
        }

        public Criteria andCheckTimeIsNotNull() {
            addCriterion("CHECK_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andCheckTimeEqualTo(Timestamp value) {
            addCriterion("CHECK_TIME =", value, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeNotEqualTo(Timestamp value) {
            addCriterion("CHECK_TIME <>", value, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeGreaterThan(Timestamp value) {
            addCriterion("CHECK_TIME >", value, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeGreaterThanOrEqualTo(Timestamp value) {
            addCriterion("CHECK_TIME >=", value, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeLessThan(Timestamp value) {
            addCriterion("CHECK_TIME <", value, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeLessThanOrEqualTo(Timestamp value) {
            addCriterion("CHECK_TIME <=", value, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeIn(List<Timestamp> values) {
            addCriterion("CHECK_TIME in", values, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeNotIn(List<Timestamp> values) {
            addCriterion("CHECK_TIME not in", values, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeBetween(Timestamp value1, Timestamp value2) {
            addCriterion("CHECK_TIME between", value1, value2, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeNotBetween(Timestamp value1, Timestamp value2) {
            addCriterion("CHECK_TIME not between", value1, value2, "checkTime");
            return (Criteria) this;
        }

        public Criteria andAdjustTimeIsNull() {
            addCriterion("ADJUST_TIME is null");
            return (Criteria) this;
        }

        public Criteria andAdjustTimeIsNotNull() {
            addCriterion("ADJUST_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andAdjustTimeEqualTo(Timestamp value) {
            addCriterion("ADJUST_TIME =", value, "adjustTime");
            return (Criteria) this;
        }

        public Criteria andAdjustTimeNotEqualTo(Timestamp value) {
            addCriterion("ADJUST_TIME <>", value, "adjustTime");
            return (Criteria) this;
        }

        public Criteria andAdjustTimeGreaterThan(Timestamp value) {
            addCriterion("ADJUST_TIME >", value, "adjustTime");
            return (Criteria) this;
        }

        public Criteria andAdjustTimeGreaterThanOrEqualTo(Timestamp value) {
            addCriterion("ADJUST_TIME >=", value, "adjustTime");
            return (Criteria) this;
        }

        public Criteria andAdjustTimeLessThan(Timestamp value) {
            addCriterion("ADJUST_TIME <", value, "adjustTime");
            return (Criteria) this;
        }

        public Criteria andAdjustTimeLessThanOrEqualTo(Timestamp value) {
            addCriterion("ADJUST_TIME <=", value, "adjustTime");
            return (Criteria) this;
        }

        public Criteria andAdjustTimeIn(List<Timestamp> values) {
            addCriterion("ADJUST_TIME in", values, "adjustTime");
            return (Criteria) this;
        }

        public Criteria andAdjustTimeNotIn(List<Timestamp> values) {
            addCriterion("ADJUST_TIME not in", values, "adjustTime");
            return (Criteria) this;
        }

        public Criteria andAdjustTimeBetween(Timestamp value1, Timestamp value2) {
            addCriterion("ADJUST_TIME between", value1, value2, "adjustTime");
            return (Criteria) this;
        }

        public Criteria andAdjustTimeNotBetween(Timestamp value1, Timestamp value2) {
            addCriterion("ADJUST_TIME not between", value1, value2, "adjustTime");
            return (Criteria) this;
        }

        public Criteria andAdjustOperIdIsNull() {
            addCriterion("ADJUST_OPER_ID is null");
            return (Criteria) this;
        }

        public Criteria andAdjustOperIdIsNotNull() {
            addCriterion("ADJUST_OPER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andAdjustOperIdEqualTo(String value) {
            addCriterion("ADJUST_OPER_ID =", value, "adjustOperId");
            return (Criteria) this;
        }

        public Criteria andAdjustOperIdNotEqualTo(String value) {
            addCriterion("ADJUST_OPER_ID <>", value, "adjustOperId");
            return (Criteria) this;
        }

        public Criteria andAdjustOperIdGreaterThan(String value) {
            addCriterion("ADJUST_OPER_ID >", value, "adjustOperId");
            return (Criteria) this;
        }

        public Criteria andAdjustOperIdGreaterThanOrEqualTo(String value) {
            addCriterion("ADJUST_OPER_ID >=", value, "adjustOperId");
            return (Criteria) this;
        }

        public Criteria andAdjustOperIdLessThan(String value) {
            addCriterion("ADJUST_OPER_ID <", value, "adjustOperId");
            return (Criteria) this;
        }

        public Criteria andAdjustOperIdLessThanOrEqualTo(String value) {
            addCriterion("ADJUST_OPER_ID <=", value, "adjustOperId");
            return (Criteria) this;
        }

        public Criteria andAdjustOperIdLike(String value) {
            addCriterion("ADJUST_OPER_ID like", value, "adjustOperId");
            return (Criteria) this;
        }

        public Criteria andAdjustOperIdNotLike(String value) {
            addCriterion("ADJUST_OPER_ID not like", value, "adjustOperId");
            return (Criteria) this;
        }

        public Criteria andAdjustOperIdIn(List<String> values) {
            addCriterion("ADJUST_OPER_ID in", values, "adjustOperId");
            return (Criteria) this;
        }

        public Criteria andAdjustOperIdNotIn(List<String> values) {
            addCriterion("ADJUST_OPER_ID not in", values, "adjustOperId");
            return (Criteria) this;
        }

        public Criteria andAdjustOperIdBetween(String value1, String value2) {
            addCriterion("ADJUST_OPER_ID between", value1, value2, "adjustOperId");
            return (Criteria) this;
        }

        public Criteria andAdjustOperIdNotBetween(String value1, String value2) {
            addCriterion("ADJUST_OPER_ID not between", value1, value2, "adjustOperId");
            return (Criteria) this;
        }

        public Criteria andAdjustDescIsNull() {
            addCriterion("ADJUST_DESC is null");
            return (Criteria) this;
        }

        public Criteria andAdjustDescIsNotNull() {
            addCriterion("ADJUST_DESC is not null");
            return (Criteria) this;
        }

        public Criteria andAdjustDescEqualTo(String value) {
            addCriterion("ADJUST_DESC =", value, "adjustDesc");
            return (Criteria) this;
        }

        public Criteria andAdjustDescNotEqualTo(String value) {
            addCriterion("ADJUST_DESC <>", value, "adjustDesc");
            return (Criteria) this;
        }

        public Criteria andAdjustDescGreaterThan(String value) {
            addCriterion("ADJUST_DESC >", value, "adjustDesc");
            return (Criteria) this;
        }

        public Criteria andAdjustDescGreaterThanOrEqualTo(String value) {
            addCriterion("ADJUST_DESC >=", value, "adjustDesc");
            return (Criteria) this;
        }

        public Criteria andAdjustDescLessThan(String value) {
            addCriterion("ADJUST_DESC <", value, "adjustDesc");
            return (Criteria) this;
        }

        public Criteria andAdjustDescLessThanOrEqualTo(String value) {
            addCriterion("ADJUST_DESC <=", value, "adjustDesc");
            return (Criteria) this;
        }

        public Criteria andAdjustDescLike(String value) {
            addCriterion("ADJUST_DESC like", value, "adjustDesc");
            return (Criteria) this;
        }

        public Criteria andAdjustDescNotLike(String value) {
            addCriterion("ADJUST_DESC not like", value, "adjustDesc");
            return (Criteria) this;
        }

        public Criteria andAdjustDescIn(List<String> values) {
            addCriterion("ADJUST_DESC in", values, "adjustDesc");
            return (Criteria) this;
        }

        public Criteria andAdjustDescNotIn(List<String> values) {
            addCriterion("ADJUST_DESC not in", values, "adjustDesc");
            return (Criteria) this;
        }

        public Criteria andAdjustDescBetween(String value1, String value2) {
            addCriterion("ADJUST_DESC between", value1, value2, "adjustDesc");
            return (Criteria) this;
        }

        public Criteria andAdjustDescNotBetween(String value1, String value2) {
            addCriterion("ADJUST_DESC not between", value1, value2, "adjustDesc");
            return (Criteria) this;
        }

        public Criteria andCreateDeptIdIsNull() {
            addCriterion("CREATE_DEPT_ID is null");
            return (Criteria) this;
        }

        public Criteria andCreateDeptIdIsNotNull() {
            addCriterion("CREATE_DEPT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDeptIdEqualTo(String value) {
            addCriterion("CREATE_DEPT_ID =", value, "createDeptId");
            return (Criteria) this;
        }

        public Criteria andCreateDeptIdNotEqualTo(String value) {
            addCriterion("CREATE_DEPT_ID <>", value, "createDeptId");
            return (Criteria) this;
        }

        public Criteria andCreateDeptIdGreaterThan(String value) {
            addCriterion("CREATE_DEPT_ID >", value, "createDeptId");
            return (Criteria) this;
        }

        public Criteria andCreateDeptIdGreaterThanOrEqualTo(String value) {
            addCriterion("CREATE_DEPT_ID >=", value, "createDeptId");
            return (Criteria) this;
        }

        public Criteria andCreateDeptIdLessThan(String value) {
            addCriterion("CREATE_DEPT_ID <", value, "createDeptId");
            return (Criteria) this;
        }

        public Criteria andCreateDeptIdLessThanOrEqualTo(String value) {
            addCriterion("CREATE_DEPT_ID <=", value, "createDeptId");
            return (Criteria) this;
        }

        public Criteria andCreateDeptIdLike(String value) {
            addCriterion("CREATE_DEPT_ID like", value, "createDeptId");
            return (Criteria) this;
        }

        public Criteria andCreateDeptIdNotLike(String value) {
            addCriterion("CREATE_DEPT_ID not like", value, "createDeptId");
            return (Criteria) this;
        }

        public Criteria andCreateDeptIdIn(List<String> values) {
            addCriterion("CREATE_DEPT_ID in", values, "createDeptId");
            return (Criteria) this;
        }

        public Criteria andCreateDeptIdNotIn(List<String> values) {
            addCriterion("CREATE_DEPT_ID not in", values, "createDeptId");
            return (Criteria) this;
        }

        public Criteria andCreateDeptIdBetween(String value1, String value2) {
            addCriterion("CREATE_DEPT_ID between", value1, value2, "createDeptId");
            return (Criteria) this;
        }

        public Criteria andCreateDeptIdNotBetween(String value1, String value2) {
            addCriterion("CREATE_DEPT_ID not between", value1, value2, "createDeptId");
            return (Criteria) this;
        }

        public Criteria andCreateOperIdIsNull() {
            addCriterion("CREATE_OPER_ID is null");
            return (Criteria) this;
        }

        public Criteria andCreateOperIdIsNotNull() {
            addCriterion("CREATE_OPER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andCreateOperIdEqualTo(String value) {
            addCriterion("CREATE_OPER_ID =", value, "createOperId");
            return (Criteria) this;
        }

        public Criteria andCreateOperIdNotEqualTo(String value) {
            addCriterion("CREATE_OPER_ID <>", value, "createOperId");
            return (Criteria) this;
        }

        public Criteria andCreateOperIdGreaterThan(String value) {
            addCriterion("CREATE_OPER_ID >", value, "createOperId");
            return (Criteria) this;
        }

        public Criteria andCreateOperIdGreaterThanOrEqualTo(String value) {
            addCriterion("CREATE_OPER_ID >=", value, "createOperId");
            return (Criteria) this;
        }

        public Criteria andCreateOperIdLessThan(String value) {
            addCriterion("CREATE_OPER_ID <", value, "createOperId");
            return (Criteria) this;
        }

        public Criteria andCreateOperIdLessThanOrEqualTo(String value) {
            addCriterion("CREATE_OPER_ID <=", value, "createOperId");
            return (Criteria) this;
        }

        public Criteria andCreateOperIdLike(String value) {
            addCriterion("CREATE_OPER_ID like", value, "createOperId");
            return (Criteria) this;
        }

        public Criteria andCreateOperIdNotLike(String value) {
            addCriterion("CREATE_OPER_ID not like", value, "createOperId");
            return (Criteria) this;
        }

        public Criteria andCreateOperIdIn(List<String> values) {
            addCriterion("CREATE_OPER_ID in", values, "createOperId");
            return (Criteria) this;
        }

        public Criteria andCreateOperIdNotIn(List<String> values) {
            addCriterion("CREATE_OPER_ID not in", values, "createOperId");
            return (Criteria) this;
        }

        public Criteria andCreateOperIdBetween(String value1, String value2) {
            addCriterion("CREATE_OPER_ID between", value1, value2, "createOperId");
            return (Criteria) this;
        }

        public Criteria andCreateOperIdNotBetween(String value1, String value2) {
            addCriterion("CREATE_OPER_ID not between", value1, value2, "createOperId");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("CREATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("CREATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Timestamp value) {
            addCriterion("CREATE_TIME =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Timestamp value) {
            addCriterion("CREATE_TIME <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Timestamp value) {
            addCriterion("CREATE_TIME >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Timestamp value) {
            addCriterion("CREATE_TIME >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Timestamp value) {
            addCriterion("CREATE_TIME <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Timestamp value) {
            addCriterion("CREATE_TIME <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Timestamp> values) {
            addCriterion("CREATE_TIME in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Timestamp> values) {
            addCriterion("CREATE_TIME not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Timestamp value1, Timestamp value2) {
            addCriterion("CREATE_TIME between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Timestamp value1, Timestamp value2) {
            addCriterion("CREATE_TIME not between", value1, value2, "createTime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}
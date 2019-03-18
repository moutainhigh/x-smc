package com.x.smc.bill.dao.mapper.bo;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class StlBillDataCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public StlBillDataCriteria() {
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

        public Criteria andBillFromIsNull() {
            addCriterion("BILL_FROM is null");
            return (Criteria) this;
        }

        public Criteria andBillFromIsNotNull() {
            addCriterion("BILL_FROM is not null");
            return (Criteria) this;
        }

        public Criteria andBillFromEqualTo(String value) {
            addCriterion("BILL_FROM =", value, "billFrom");
            return (Criteria) this;
        }

        public Criteria andBillFromNotEqualTo(String value) {
            addCriterion("BILL_FROM <>", value, "billFrom");
            return (Criteria) this;
        }

        public Criteria andBillFromGreaterThan(String value) {
            addCriterion("BILL_FROM >", value, "billFrom");
            return (Criteria) this;
        }

        public Criteria andBillFromGreaterThanOrEqualTo(String value) {
            addCriterion("BILL_FROM >=", value, "billFrom");
            return (Criteria) this;
        }

        public Criteria andBillFromLessThan(String value) {
            addCriterion("BILL_FROM <", value, "billFrom");
            return (Criteria) this;
        }

        public Criteria andBillFromLessThanOrEqualTo(String value) {
            addCriterion("BILL_FROM <=", value, "billFrom");
            return (Criteria) this;
        }

        public Criteria andBillFromLike(String value) {
            addCriterion("BILL_FROM like", value, "billFrom");
            return (Criteria) this;
        }

        public Criteria andBillFromNotLike(String value) {
            addCriterion("BILL_FROM not like", value, "billFrom");
            return (Criteria) this;
        }

        public Criteria andBillFromIn(List<String> values) {
            addCriterion("BILL_FROM in", values, "billFrom");
            return (Criteria) this;
        }

        public Criteria andBillFromNotIn(List<String> values) {
            addCriterion("BILL_FROM not in", values, "billFrom");
            return (Criteria) this;
        }

        public Criteria andBillFromBetween(String value1, String value2) {
            addCriterion("BILL_FROM between", value1, value2, "billFrom");
            return (Criteria) this;
        }

        public Criteria andBillFromNotBetween(String value1, String value2) {
            addCriterion("BILL_FROM not between", value1, value2, "billFrom");
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

        public Criteria andPolicyIdIsNull() {
            addCriterion("POLICY_ID is null");
            return (Criteria) this;
        }

        public Criteria andPolicyIdIsNotNull() {
            addCriterion("POLICY_ID is not null");
            return (Criteria) this;
        }

        public Criteria andPolicyIdEqualTo(String value) {
            addCriterion("POLICY_ID =", value, "policyId");
            return (Criteria) this;
        }

        public Criteria andPolicyIdNotEqualTo(String value) {
            addCriterion("POLICY_ID <>", value, "policyId");
            return (Criteria) this;
        }

        public Criteria andPolicyIdGreaterThan(String value) {
            addCriterion("POLICY_ID >", value, "policyId");
            return (Criteria) this;
        }

        public Criteria andPolicyIdGreaterThanOrEqualTo(String value) {
            addCriterion("POLICY_ID >=", value, "policyId");
            return (Criteria) this;
        }

        public Criteria andPolicyIdLessThan(String value) {
            addCriterion("POLICY_ID <", value, "policyId");
            return (Criteria) this;
        }

        public Criteria andPolicyIdLessThanOrEqualTo(String value) {
            addCriterion("POLICY_ID <=", value, "policyId");
            return (Criteria) this;
        }

        public Criteria andPolicyIdLike(String value) {
            addCriterion("POLICY_ID like", value, "policyId");
            return (Criteria) this;
        }

        public Criteria andPolicyIdNotLike(String value) {
            addCriterion("POLICY_ID not like", value, "policyId");
            return (Criteria) this;
        }

        public Criteria andPolicyIdIn(List<String> values) {
            addCriterion("POLICY_ID in", values, "policyId");
            return (Criteria) this;
        }

        public Criteria andPolicyIdNotIn(List<String> values) {
            addCriterion("POLICY_ID not in", values, "policyId");
            return (Criteria) this;
        }

        public Criteria andPolicyIdBetween(String value1, String value2) {
            addCriterion("POLICY_ID between", value1, value2, "policyId");
            return (Criteria) this;
        }

        public Criteria andPolicyIdNotBetween(String value1, String value2) {
            addCriterion("POLICY_ID not between", value1, value2, "policyId");
            return (Criteria) this;
        }

        public Criteria andObjectTypeIsNull() {
            addCriterion("OBJECT_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andObjectTypeIsNotNull() {
            addCriterion("OBJECT_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andObjectTypeEqualTo(String value) {
            addCriterion("OBJECT_TYPE =", value, "objectType");
            return (Criteria) this;
        }

        public Criteria andObjectTypeNotEqualTo(String value) {
            addCriterion("OBJECT_TYPE <>", value, "objectType");
            return (Criteria) this;
        }

        public Criteria andObjectTypeGreaterThan(String value) {
            addCriterion("OBJECT_TYPE >", value, "objectType");
            return (Criteria) this;
        }

        public Criteria andObjectTypeGreaterThanOrEqualTo(String value) {
            addCriterion("OBJECT_TYPE >=", value, "objectType");
            return (Criteria) this;
        }

        public Criteria andObjectTypeLessThan(String value) {
            addCriterion("OBJECT_TYPE <", value, "objectType");
            return (Criteria) this;
        }

        public Criteria andObjectTypeLessThanOrEqualTo(String value) {
            addCriterion("OBJECT_TYPE <=", value, "objectType");
            return (Criteria) this;
        }

        public Criteria andObjectTypeLike(String value) {
            addCriterion("OBJECT_TYPE like", value, "objectType");
            return (Criteria) this;
        }

        public Criteria andObjectTypeNotLike(String value) {
            addCriterion("OBJECT_TYPE not like", value, "objectType");
            return (Criteria) this;
        }

        public Criteria andObjectTypeIn(List<String> values) {
            addCriterion("OBJECT_TYPE in", values, "objectType");
            return (Criteria) this;
        }

        public Criteria andObjectTypeNotIn(List<String> values) {
            addCriterion("OBJECT_TYPE not in", values, "objectType");
            return (Criteria) this;
        }

        public Criteria andObjectTypeBetween(String value1, String value2) {
            addCriterion("OBJECT_TYPE between", value1, value2, "objectType");
            return (Criteria) this;
        }

        public Criteria andObjectTypeNotBetween(String value1, String value2) {
            addCriterion("OBJECT_TYPE not between", value1, value2, "objectType");
            return (Criteria) this;
        }

        public Criteria andObjectCodeIsNull() {
            addCriterion("OBJECT_CODE is null");
            return (Criteria) this;
        }

        public Criteria andObjectCodeIsNotNull() {
            addCriterion("OBJECT_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andObjectCodeEqualTo(String value) {
            addCriterion("OBJECT_CODE =", value, "objectCode");
            return (Criteria) this;
        }

        public Criteria andObjectCodeNotEqualTo(String value) {
            addCriterion("OBJECT_CODE <>", value, "objectCode");
            return (Criteria) this;
        }

        public Criteria andObjectCodeGreaterThan(String value) {
            addCriterion("OBJECT_CODE >", value, "objectCode");
            return (Criteria) this;
        }

        public Criteria andObjectCodeGreaterThanOrEqualTo(String value) {
            addCriterion("OBJECT_CODE >=", value, "objectCode");
            return (Criteria) this;
        }

        public Criteria andObjectCodeLessThan(String value) {
            addCriterion("OBJECT_CODE <", value, "objectCode");
            return (Criteria) this;
        }

        public Criteria andObjectCodeLessThanOrEqualTo(String value) {
            addCriterion("OBJECT_CODE <=", value, "objectCode");
            return (Criteria) this;
        }

        public Criteria andObjectCodeLike(String value) {
            addCriterion("OBJECT_CODE like", value, "objectCode");
            return (Criteria) this;
        }

        public Criteria andObjectCodeNotLike(String value) {
            addCriterion("OBJECT_CODE not like", value, "objectCode");
            return (Criteria) this;
        }

        public Criteria andObjectCodeIn(List<String> values) {
            addCriterion("OBJECT_CODE in", values, "objectCode");
            return (Criteria) this;
        }

        public Criteria andObjectCodeNotIn(List<String> values) {
            addCriterion("OBJECT_CODE not in", values, "objectCode");
            return (Criteria) this;
        }

        public Criteria andObjectCodeBetween(String value1, String value2) {
            addCriterion("OBJECT_CODE between", value1, value2, "objectCode");
            return (Criteria) this;
        }

        public Criteria andObjectCodeNotBetween(String value1, String value2) {
            addCriterion("OBJECT_CODE not between", value1, value2, "objectCode");
            return (Criteria) this;
        }

        public Criteria andStlElementIdIsNull() {
            addCriterion("STL_ELEMENT_ID is null");
            return (Criteria) this;
        }

        public Criteria andStlElementIdIsNotNull() {
            addCriterion("STL_ELEMENT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andStlElementIdEqualTo(Long value) {
            addCriterion("STL_ELEMENT_ID =", value, "stlElementId");
            return (Criteria) this;
        }

        public Criteria andStlElementIdNotEqualTo(Long value) {
            addCriterion("STL_ELEMENT_ID <>", value, "stlElementId");
            return (Criteria) this;
        }

        public Criteria andStlElementIdGreaterThan(Long value) {
            addCriterion("STL_ELEMENT_ID >", value, "stlElementId");
            return (Criteria) this;
        }

        public Criteria andStlElementIdGreaterThanOrEqualTo(Long value) {
            addCriterion("STL_ELEMENT_ID >=", value, "stlElementId");
            return (Criteria) this;
        }

        public Criteria andStlElementIdLessThan(Long value) {
            addCriterion("STL_ELEMENT_ID <", value, "stlElementId");
            return (Criteria) this;
        }

        public Criteria andStlElementIdLessThanOrEqualTo(Long value) {
            addCriterion("STL_ELEMENT_ID <=", value, "stlElementId");
            return (Criteria) this;
        }

        public Criteria andStlElementIdIn(List<Long> values) {
            addCriterion("STL_ELEMENT_ID in", values, "stlElementId");
            return (Criteria) this;
        }

        public Criteria andStlElementIdNotIn(List<Long> values) {
            addCriterion("STL_ELEMENT_ID not in", values, "stlElementId");
            return (Criteria) this;
        }

        public Criteria andStlElementIdBetween(Long value1, Long value2) {
            addCriterion("STL_ELEMENT_ID between", value1, value2, "stlElementId");
            return (Criteria) this;
        }

        public Criteria andStlElementIdNotBetween(Long value1, Long value2) {
            addCriterion("STL_ELEMENT_ID not between", value1, value2, "stlElementId");
            return (Criteria) this;
        }

        public Criteria andStlElementSnIsNull() {
            addCriterion("STL_ELEMENT_SN is null");
            return (Criteria) this;
        }

        public Criteria andStlElementSnIsNotNull() {
            addCriterion("STL_ELEMENT_SN is not null");
            return (Criteria) this;
        }

        public Criteria andStlElementSnEqualTo(String value) {
            addCriterion("STL_ELEMENT_SN =", value, "stlElementSn");
            return (Criteria) this;
        }

        public Criteria andStlElementSnNotEqualTo(String value) {
            addCriterion("STL_ELEMENT_SN <>", value, "stlElementSn");
            return (Criteria) this;
        }

        public Criteria andStlElementSnGreaterThan(String value) {
            addCriterion("STL_ELEMENT_SN >", value, "stlElementSn");
            return (Criteria) this;
        }

        public Criteria andStlElementSnGreaterThanOrEqualTo(String value) {
            addCriterion("STL_ELEMENT_SN >=", value, "stlElementSn");
            return (Criteria) this;
        }

        public Criteria andStlElementSnLessThan(String value) {
            addCriterion("STL_ELEMENT_SN <", value, "stlElementSn");
            return (Criteria) this;
        }

        public Criteria andStlElementSnLessThanOrEqualTo(String value) {
            addCriterion("STL_ELEMENT_SN <=", value, "stlElementSn");
            return (Criteria) this;
        }

        public Criteria andStlElementSnLike(String value) {
            addCriterion("STL_ELEMENT_SN like", value, "stlElementSn");
            return (Criteria) this;
        }

        public Criteria andStlElementSnNotLike(String value) {
            addCriterion("STL_ELEMENT_SN not like", value, "stlElementSn");
            return (Criteria) this;
        }

        public Criteria andStlElementSnIn(List<String> values) {
            addCriterion("STL_ELEMENT_SN in", values, "stlElementSn");
            return (Criteria) this;
        }

        public Criteria andStlElementSnNotIn(List<String> values) {
            addCriterion("STL_ELEMENT_SN not in", values, "stlElementSn");
            return (Criteria) this;
        }

        public Criteria andStlElementSnBetween(String value1, String value2) {
            addCriterion("STL_ELEMENT_SN between", value1, value2, "stlElementSn");
            return (Criteria) this;
        }

        public Criteria andStlElementSnNotBetween(String value1, String value2) {
            addCriterion("STL_ELEMENT_SN not between", value1, value2, "stlElementSn");
            return (Criteria) this;
        }

        public Criteria andBillTimeSnIsNull() {
            addCriterion("BILL_TIME_SN is null");
            return (Criteria) this;
        }

        public Criteria andBillTimeSnIsNotNull() {
            addCriterion("BILL_TIME_SN is not null");
            return (Criteria) this;
        }

        public Criteria andBillTimeSnEqualTo(String value) {
            addCriterion("BILL_TIME_SN =", value, "billTimeSn");
            return (Criteria) this;
        }

        public Criteria andBillTimeSnNotEqualTo(String value) {
            addCriterion("BILL_TIME_SN <>", value, "billTimeSn");
            return (Criteria) this;
        }

        public Criteria andBillTimeSnGreaterThan(String value) {
            addCriterion("BILL_TIME_SN >", value, "billTimeSn");
            return (Criteria) this;
        }

        public Criteria andBillTimeSnGreaterThanOrEqualTo(String value) {
            addCriterion("BILL_TIME_SN >=", value, "billTimeSn");
            return (Criteria) this;
        }

        public Criteria andBillTimeSnLessThan(String value) {
            addCriterion("BILL_TIME_SN <", value, "billTimeSn");
            return (Criteria) this;
        }

        public Criteria andBillTimeSnLessThanOrEqualTo(String value) {
            addCriterion("BILL_TIME_SN <=", value, "billTimeSn");
            return (Criteria) this;
        }

        public Criteria andBillTimeSnLike(String value) {
            addCriterion("BILL_TIME_SN like", value, "billTimeSn");
            return (Criteria) this;
        }

        public Criteria andBillTimeSnNotLike(String value) {
            addCriterion("BILL_TIME_SN not like", value, "billTimeSn");
            return (Criteria) this;
        }

        public Criteria andBillTimeSnIn(List<String> values) {
            addCriterion("BILL_TIME_SN in", values, "billTimeSn");
            return (Criteria) this;
        }

        public Criteria andBillTimeSnNotIn(List<String> values) {
            addCriterion("BILL_TIME_SN not in", values, "billTimeSn");
            return (Criteria) this;
        }

        public Criteria andBillTimeSnBetween(String value1, String value2) {
            addCriterion("BILL_TIME_SN between", value1, value2, "billTimeSn");
            return (Criteria) this;
        }

        public Criteria andBillTimeSnNotBetween(String value1, String value2) {
            addCriterion("BILL_TIME_SN not between", value1, value2, "billTimeSn");
            return (Criteria) this;
        }

        public Criteria andBillStartTimeIsNull() {
            addCriterion("BILL_START_TIME is null");
            return (Criteria) this;
        }

        public Criteria andBillStartTimeIsNotNull() {
            addCriterion("BILL_START_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andBillStartTimeEqualTo(Timestamp value) {
            addCriterion("BILL_START_TIME =", value, "billStartTime");
            return (Criteria) this;
        }

        public Criteria andBillStartTimeNotEqualTo(Timestamp value) {
            addCriterion("BILL_START_TIME <>", value, "billStartTime");
            return (Criteria) this;
        }

        public Criteria andBillStartTimeGreaterThan(Timestamp value) {
            addCriterion("BILL_START_TIME >", value, "billStartTime");
            return (Criteria) this;
        }

        public Criteria andBillStartTimeGreaterThanOrEqualTo(Timestamp value) {
            addCriterion("BILL_START_TIME >=", value, "billStartTime");
            return (Criteria) this;
        }

        public Criteria andBillStartTimeLessThan(Timestamp value) {
            addCriterion("BILL_START_TIME <", value, "billStartTime");
            return (Criteria) this;
        }

        public Criteria andBillStartTimeLessThanOrEqualTo(Timestamp value) {
            addCriterion("BILL_START_TIME <=", value, "billStartTime");
            return (Criteria) this;
        }

        public Criteria andBillStartTimeIn(List<Timestamp> values) {
            addCriterion("BILL_START_TIME in", values, "billStartTime");
            return (Criteria) this;
        }

        public Criteria andBillStartTimeNotIn(List<Timestamp> values) {
            addCriterion("BILL_START_TIME not in", values, "billStartTime");
            return (Criteria) this;
        }

        public Criteria andBillStartTimeBetween(Timestamp value1, Timestamp value2) {
            addCriterion("BILL_START_TIME between", value1, value2, "billStartTime");
            return (Criteria) this;
        }

        public Criteria andBillStartTimeNotBetween(Timestamp value1, Timestamp value2) {
            addCriterion("BILL_START_TIME not between", value1, value2, "billStartTime");
            return (Criteria) this;
        }

        public Criteria andBillEndTimeIsNull() {
            addCriterion("BILL_END_TIME is null");
            return (Criteria) this;
        }

        public Criteria andBillEndTimeIsNotNull() {
            addCriterion("BILL_END_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andBillEndTimeEqualTo(Timestamp value) {
            addCriterion("BILL_END_TIME =", value, "billEndTime");
            return (Criteria) this;
        }

        public Criteria andBillEndTimeNotEqualTo(Timestamp value) {
            addCriterion("BILL_END_TIME <>", value, "billEndTime");
            return (Criteria) this;
        }

        public Criteria andBillEndTimeGreaterThan(Timestamp value) {
            addCriterion("BILL_END_TIME >", value, "billEndTime");
            return (Criteria) this;
        }

        public Criteria andBillEndTimeGreaterThanOrEqualTo(Timestamp value) {
            addCriterion("BILL_END_TIME >=", value, "billEndTime");
            return (Criteria) this;
        }

        public Criteria andBillEndTimeLessThan(Timestamp value) {
            addCriterion("BILL_END_TIME <", value, "billEndTime");
            return (Criteria) this;
        }

        public Criteria andBillEndTimeLessThanOrEqualTo(Timestamp value) {
            addCriterion("BILL_END_TIME <=", value, "billEndTime");
            return (Criteria) this;
        }

        public Criteria andBillEndTimeIn(List<Timestamp> values) {
            addCriterion("BILL_END_TIME in", values, "billEndTime");
            return (Criteria) this;
        }

        public Criteria andBillEndTimeNotIn(List<Timestamp> values) {
            addCriterion("BILL_END_TIME not in", values, "billEndTime");
            return (Criteria) this;
        }

        public Criteria andBillEndTimeBetween(Timestamp value1, Timestamp value2) {
            addCriterion("BILL_END_TIME between", value1, value2, "billEndTime");
            return (Criteria) this;
        }

        public Criteria andBillEndTimeNotBetween(Timestamp value1, Timestamp value2) {
            addCriterion("BILL_END_TIME not between", value1, value2, "billEndTime");
            return (Criteria) this;
        }

        public Criteria andCycleTypeIsNull() {
            addCriterion("CYCLE_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andCycleTypeIsNotNull() {
            addCriterion("CYCLE_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andCycleTypeEqualTo(String value) {
            addCriterion("CYCLE_TYPE =", value, "cycleType");
            return (Criteria) this;
        }

        public Criteria andCycleTypeNotEqualTo(String value) {
            addCriterion("CYCLE_TYPE <>", value, "cycleType");
            return (Criteria) this;
        }

        public Criteria andCycleTypeGreaterThan(String value) {
            addCriterion("CYCLE_TYPE >", value, "cycleType");
            return (Criteria) this;
        }

        public Criteria andCycleTypeGreaterThanOrEqualTo(String value) {
            addCriterion("CYCLE_TYPE >=", value, "cycleType");
            return (Criteria) this;
        }

        public Criteria andCycleTypeLessThan(String value) {
            addCriterion("CYCLE_TYPE <", value, "cycleType");
            return (Criteria) this;
        }

        public Criteria andCycleTypeLessThanOrEqualTo(String value) {
            addCriterion("CYCLE_TYPE <=", value, "cycleType");
            return (Criteria) this;
        }

        public Criteria andCycleTypeLike(String value) {
            addCriterion("CYCLE_TYPE like", value, "cycleType");
            return (Criteria) this;
        }

        public Criteria andCycleTypeNotLike(String value) {
            addCriterion("CYCLE_TYPE not like", value, "cycleType");
            return (Criteria) this;
        }

        public Criteria andCycleTypeIn(List<String> values) {
            addCriterion("CYCLE_TYPE in", values, "cycleType");
            return (Criteria) this;
        }

        public Criteria andCycleTypeNotIn(List<String> values) {
            addCriterion("CYCLE_TYPE not in", values, "cycleType");
            return (Criteria) this;
        }

        public Criteria andCycleTypeBetween(String value1, String value2) {
            addCriterion("CYCLE_TYPE between", value1, value2, "cycleType");
            return (Criteria) this;
        }

        public Criteria andCycleTypeNotBetween(String value1, String value2) {
            addCriterion("CYCLE_TYPE not between", value1, value2, "cycleType");
            return (Criteria) this;
        }

        public Criteria andCycleValueIsNull() {
            addCriterion("CYCLE_VALUE is null");
            return (Criteria) this;
        }

        public Criteria andCycleValueIsNotNull() {
            addCriterion("CYCLE_VALUE is not null");
            return (Criteria) this;
        }

        public Criteria andCycleValueEqualTo(String value) {
            addCriterion("CYCLE_VALUE =", value, "cycleValue");
            return (Criteria) this;
        }

        public Criteria andCycleValueNotEqualTo(String value) {
            addCriterion("CYCLE_VALUE <>", value, "cycleValue");
            return (Criteria) this;
        }

        public Criteria andCycleValueGreaterThan(String value) {
            addCriterion("CYCLE_VALUE >", value, "cycleValue");
            return (Criteria) this;
        }

        public Criteria andCycleValueGreaterThanOrEqualTo(String value) {
            addCriterion("CYCLE_VALUE >=", value, "cycleValue");
            return (Criteria) this;
        }

        public Criteria andCycleValueLessThan(String value) {
            addCriterion("CYCLE_VALUE <", value, "cycleValue");
            return (Criteria) this;
        }

        public Criteria andCycleValueLessThanOrEqualTo(String value) {
            addCriterion("CYCLE_VALUE <=", value, "cycleValue");
            return (Criteria) this;
        }

        public Criteria andCycleValueLike(String value) {
            addCriterion("CYCLE_VALUE like", value, "cycleValue");
            return (Criteria) this;
        }

        public Criteria andCycleValueNotLike(String value) {
            addCriterion("CYCLE_VALUE not like", value, "cycleValue");
            return (Criteria) this;
        }

        public Criteria andCycleValueIn(List<String> values) {
            addCriterion("CYCLE_VALUE in", values, "cycleValue");
            return (Criteria) this;
        }

        public Criteria andCycleValueNotIn(List<String> values) {
            addCriterion("CYCLE_VALUE not in", values, "cycleValue");
            return (Criteria) this;
        }

        public Criteria andCycleValueBetween(String value1, String value2) {
            addCriterion("CYCLE_VALUE between", value1, value2, "cycleValue");
            return (Criteria) this;
        }

        public Criteria andCycleValueNotBetween(String value1, String value2) {
            addCriterion("CYCLE_VALUE not between", value1, value2, "cycleValue");
            return (Criteria) this;
        }

        public Criteria andOrigFeeIsNull() {
            addCriterion("ORIG_FEE is null");
            return (Criteria) this;
        }

        public Criteria andOrigFeeIsNotNull() {
            addCriterion("ORIG_FEE is not null");
            return (Criteria) this;
        }

        public Criteria andOrigFeeEqualTo(String value) {
            addCriterion("ORIG_FEE =", value, "origFee");
            return (Criteria) this;
        }

        public Criteria andOrigFeeNotEqualTo(String value) {
            addCriterion("ORIG_FEE <>", value, "origFee");
            return (Criteria) this;
        }

        public Criteria andOrigFeeGreaterThan(String value) {
            addCriterion("ORIG_FEE >", value, "origFee");
            return (Criteria) this;
        }

        public Criteria andOrigFeeGreaterThanOrEqualTo(String value) {
            addCriterion("ORIG_FEE >=", value, "origFee");
            return (Criteria) this;
        }

        public Criteria andOrigFeeLessThan(String value) {
            addCriterion("ORIG_FEE <", value, "origFee");
            return (Criteria) this;
        }

        public Criteria andOrigFeeLessThanOrEqualTo(String value) {
            addCriterion("ORIG_FEE <=", value, "origFee");
            return (Criteria) this;
        }

        public Criteria andOrigFeeLike(String value) {
            addCriterion("ORIG_FEE like", value, "origFee");
            return (Criteria) this;
        }

        public Criteria andOrigFeeNotLike(String value) {
            addCriterion("ORIG_FEE not like", value, "origFee");
            return (Criteria) this;
        }

        public Criteria andOrigFeeIn(List<String> values) {
            addCriterion("ORIG_FEE in", values, "origFee");
            return (Criteria) this;
        }

        public Criteria andOrigFeeNotIn(List<String> values) {
            addCriterion("ORIG_FEE not in", values, "origFee");
            return (Criteria) this;
        }

        public Criteria andOrigFeeBetween(String value1, String value2) {
            addCriterion("ORIG_FEE between", value1, value2, "origFee");
            return (Criteria) this;
        }

        public Criteria andOrigFeeNotBetween(String value1, String value2) {
            addCriterion("ORIG_FEE not between", value1, value2, "origFee");
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

        public Criteria andDiffFeeEqualTo(String value) {
            addCriterion("DIFF_FEE =", value, "diffFee");
            return (Criteria) this;
        }

        public Criteria andDiffFeeNotEqualTo(String value) {
            addCriterion("DIFF_FEE <>", value, "diffFee");
            return (Criteria) this;
        }

        public Criteria andDiffFeeGreaterThan(String value) {
            addCriterion("DIFF_FEE >", value, "diffFee");
            return (Criteria) this;
        }

        public Criteria andDiffFeeGreaterThanOrEqualTo(String value) {
            addCriterion("DIFF_FEE >=", value, "diffFee");
            return (Criteria) this;
        }

        public Criteria andDiffFeeLessThan(String value) {
            addCriterion("DIFF_FEE <", value, "diffFee");
            return (Criteria) this;
        }

        public Criteria andDiffFeeLessThanOrEqualTo(String value) {
            addCriterion("DIFF_FEE <=", value, "diffFee");
            return (Criteria) this;
        }

        public Criteria andDiffFeeLike(String value) {
            addCriterion("DIFF_FEE like", value, "diffFee");
            return (Criteria) this;
        }

        public Criteria andDiffFeeNotLike(String value) {
            addCriterion("DIFF_FEE not like", value, "diffFee");
            return (Criteria) this;
        }

        public Criteria andDiffFeeIn(List<String> values) {
            addCriterion("DIFF_FEE in", values, "diffFee");
            return (Criteria) this;
        }

        public Criteria andDiffFeeNotIn(List<String> values) {
            addCriterion("DIFF_FEE not in", values, "diffFee");
            return (Criteria) this;
        }

        public Criteria andDiffFeeBetween(String value1, String value2) {
            addCriterion("DIFF_FEE between", value1, value2, "diffFee");
            return (Criteria) this;
        }

        public Criteria andDiffFeeNotBetween(String value1, String value2) {
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

        public Criteria andAdjustFeeIsNull() {
            addCriterion("ADJUST_FEE is null");
            return (Criteria) this;
        }

        public Criteria andAdjustFeeIsNotNull() {
            addCriterion("ADJUST_FEE is not null");
            return (Criteria) this;
        }

        public Criteria andAdjustFeeEqualTo(String value) {
            addCriterion("ADJUST_FEE =", value, "adjustFee");
            return (Criteria) this;
        }

        public Criteria andAdjustFeeNotEqualTo(String value) {
            addCriterion("ADJUST_FEE <>", value, "adjustFee");
            return (Criteria) this;
        }

        public Criteria andAdjustFeeGreaterThan(String value) {
            addCriterion("ADJUST_FEE >", value, "adjustFee");
            return (Criteria) this;
        }

        public Criteria andAdjustFeeGreaterThanOrEqualTo(String value) {
            addCriterion("ADJUST_FEE >=", value, "adjustFee");
            return (Criteria) this;
        }

        public Criteria andAdjustFeeLessThan(String value) {
            addCriterion("ADJUST_FEE <", value, "adjustFee");
            return (Criteria) this;
        }

        public Criteria andAdjustFeeLessThanOrEqualTo(String value) {
            addCriterion("ADJUST_FEE <=", value, "adjustFee");
            return (Criteria) this;
        }

        public Criteria andAdjustFeeLike(String value) {
            addCriterion("ADJUST_FEE like", value, "adjustFee");
            return (Criteria) this;
        }

        public Criteria andAdjustFeeNotLike(String value) {
            addCriterion("ADJUST_FEE not like", value, "adjustFee");
            return (Criteria) this;
        }

        public Criteria andAdjustFeeIn(List<String> values) {
            addCriterion("ADJUST_FEE in", values, "adjustFee");
            return (Criteria) this;
        }

        public Criteria andAdjustFeeNotIn(List<String> values) {
            addCriterion("ADJUST_FEE not in", values, "adjustFee");
            return (Criteria) this;
        }

        public Criteria andAdjustFeeBetween(String value1, String value2) {
            addCriterion("ADJUST_FEE between", value1, value2, "adjustFee");
            return (Criteria) this;
        }

        public Criteria andAdjustFeeNotBetween(String value1, String value2) {
            addCriterion("ADJUST_FEE not between", value1, value2, "adjustFee");
            return (Criteria) this;
        }

        public Criteria andFinalFeeIsNull() {
            addCriterion("FINAL_FEE is null");
            return (Criteria) this;
        }

        public Criteria andFinalFeeIsNotNull() {
            addCriterion("FINAL_FEE is not null");
            return (Criteria) this;
        }

        public Criteria andFinalFeeEqualTo(String value) {
            addCriterion("FINAL_FEE =", value, "finalFee");
            return (Criteria) this;
        }

        public Criteria andFinalFeeNotEqualTo(String value) {
            addCriterion("FINAL_FEE <>", value, "finalFee");
            return (Criteria) this;
        }

        public Criteria andFinalFeeGreaterThan(String value) {
            addCriterion("FINAL_FEE >", value, "finalFee");
            return (Criteria) this;
        }

        public Criteria andFinalFeeGreaterThanOrEqualTo(String value) {
            addCriterion("FINAL_FEE >=", value, "finalFee");
            return (Criteria) this;
        }

        public Criteria andFinalFeeLessThan(String value) {
            addCriterion("FINAL_FEE <", value, "finalFee");
            return (Criteria) this;
        }

        public Criteria andFinalFeeLessThanOrEqualTo(String value) {
            addCriterion("FINAL_FEE <=", value, "finalFee");
            return (Criteria) this;
        }

        public Criteria andFinalFeeLike(String value) {
            addCriterion("FINAL_FEE like", value, "finalFee");
            return (Criteria) this;
        }

        public Criteria andFinalFeeNotLike(String value) {
            addCriterion("FINAL_FEE not like", value, "finalFee");
            return (Criteria) this;
        }

        public Criteria andFinalFeeIn(List<String> values) {
            addCriterion("FINAL_FEE in", values, "finalFee");
            return (Criteria) this;
        }

        public Criteria andFinalFeeNotIn(List<String> values) {
            addCriterion("FINAL_FEE not in", values, "finalFee");
            return (Criteria) this;
        }

        public Criteria andFinalFeeBetween(String value1, String value2) {
            addCriterion("FINAL_FEE between", value1, value2, "finalFee");
            return (Criteria) this;
        }

        public Criteria andFinalFeeNotBetween(String value1, String value2) {
            addCriterion("FINAL_FEE not between", value1, value2, "finalFee");
            return (Criteria) this;
        }

        public Criteria andTotalCountIsNull() {
            addCriterion("TOTAL_COUNT is null");
            return (Criteria) this;
        }

        public Criteria andTotalCountIsNotNull() {
            addCriterion("TOTAL_COUNT is not null");
            return (Criteria) this;
        }

        public Criteria andTotalCountEqualTo(Long value) {
            addCriterion("TOTAL_COUNT =", value, "totalCount");
            return (Criteria) this;
        }

        public Criteria andTotalCountNotEqualTo(Long value) {
            addCriterion("TOTAL_COUNT <>", value, "totalCount");
            return (Criteria) this;
        }

        public Criteria andTotalCountGreaterThan(Long value) {
            addCriterion("TOTAL_COUNT >", value, "totalCount");
            return (Criteria) this;
        }

        public Criteria andTotalCountGreaterThanOrEqualTo(Long value) {
            addCriterion("TOTAL_COUNT >=", value, "totalCount");
            return (Criteria) this;
        }

        public Criteria andTotalCountLessThan(Long value) {
            addCriterion("TOTAL_COUNT <", value, "totalCount");
            return (Criteria) this;
        }

        public Criteria andTotalCountLessThanOrEqualTo(Long value) {
            addCriterion("TOTAL_COUNT <=", value, "totalCount");
            return (Criteria) this;
        }

        public Criteria andTotalCountIn(List<Long> values) {
            addCriterion("TOTAL_COUNT in", values, "totalCount");
            return (Criteria) this;
        }

        public Criteria andTotalCountNotIn(List<Long> values) {
            addCriterion("TOTAL_COUNT not in", values, "totalCount");
            return (Criteria) this;
        }

        public Criteria andTotalCountBetween(Long value1, Long value2) {
            addCriterion("TOTAL_COUNT between", value1, value2, "totalCount");
            return (Criteria) this;
        }

        public Criteria andTotalCountNotBetween(Long value1, Long value2) {
            addCriterion("TOTAL_COUNT not between", value1, value2, "totalCount");
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

        public Criteria andExtendStrIsNull() {
            addCriterion("EXTEND_STR is null");
            return (Criteria) this;
        }

        public Criteria andExtendStrIsNotNull() {
            addCriterion("EXTEND_STR is not null");
            return (Criteria) this;
        }

        public Criteria andExtendStrEqualTo(String value) {
            addCriterion("EXTEND_STR =", value, "extendStr");
            return (Criteria) this;
        }

        public Criteria andExtendStrNotEqualTo(String value) {
            addCriterion("EXTEND_STR <>", value, "extendStr");
            return (Criteria) this;
        }

        public Criteria andExtendStrGreaterThan(String value) {
            addCriterion("EXTEND_STR >", value, "extendStr");
            return (Criteria) this;
        }

        public Criteria andExtendStrGreaterThanOrEqualTo(String value) {
            addCriterion("EXTEND_STR >=", value, "extendStr");
            return (Criteria) this;
        }

        public Criteria andExtendStrLessThan(String value) {
            addCriterion("EXTEND_STR <", value, "extendStr");
            return (Criteria) this;
        }

        public Criteria andExtendStrLessThanOrEqualTo(String value) {
            addCriterion("EXTEND_STR <=", value, "extendStr");
            return (Criteria) this;
        }

        public Criteria andExtendStrLike(String value) {
            addCriterion("EXTEND_STR like", value, "extendStr");
            return (Criteria) this;
        }

        public Criteria andExtendStrNotLike(String value) {
            addCriterion("EXTEND_STR not like", value, "extendStr");
            return (Criteria) this;
        }

        public Criteria andExtendStrIn(List<String> values) {
            addCriterion("EXTEND_STR in", values, "extendStr");
            return (Criteria) this;
        }

        public Criteria andExtendStrNotIn(List<String> values) {
            addCriterion("EXTEND_STR not in", values, "extendStr");
            return (Criteria) this;
        }

        public Criteria andExtendStrBetween(String value1, String value2) {
            addCriterion("EXTEND_STR between", value1, value2, "extendStr");
            return (Criteria) this;
        }

        public Criteria andExtendStrNotBetween(String value1, String value2) {
            addCriterion("EXTEND_STR not between", value1, value2, "extendStr");
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
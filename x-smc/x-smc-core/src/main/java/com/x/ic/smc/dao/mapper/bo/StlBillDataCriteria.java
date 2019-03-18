package com.x.ic.smc.dao.mapper.bo;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class StlBillDataCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    protected String yyyyMm;

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
        this.limitStart = limitStart;
    }

    public Integer getLimitStart() {
        return limitStart;
    }

    public void setLimitEnd(Integer limitEnd) {
        this.limitEnd = limitEnd;
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

        public Criteria andBatchNoIsNull() {
            addCriterion("BATCH_NO is null");
            return (Criteria) this;
        }

        public Criteria andBatchNoIsNotNull() {
            addCriterion("BATCH_NO is not null");
            return (Criteria) this;
        }

        public Criteria andBatchNoEqualTo(String value) {
            addCriterion("BATCH_NO =", value, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoNotEqualTo(String value) {
            addCriterion("BATCH_NO <>", value, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoGreaterThan(String value) {
            addCriterion("BATCH_NO >", value, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoGreaterThanOrEqualTo(String value) {
            addCriterion("BATCH_NO >=", value, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoLessThan(String value) {
            addCriterion("BATCH_NO <", value, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoLessThanOrEqualTo(String value) {
            addCriterion("BATCH_NO <=", value, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoLike(String value) {
            addCriterion("BATCH_NO like", value, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoNotLike(String value) {
            addCriterion("BATCH_NO not like", value, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoIn(List<String> values) {
            addCriterion("BATCH_NO in", values, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoNotIn(List<String> values) {
            addCriterion("BATCH_NO not in", values, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoBetween(String value1, String value2) {
            addCriterion("BATCH_NO between", value1, value2, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoNotBetween(String value1, String value2) {
            addCriterion("BATCH_NO not between", value1, value2, "batchNo");
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

        public Criteria andPolicyCodeIsNull() {
            addCriterion("POLICY_CODE is null");
            return (Criteria) this;
        }

        public Criteria andPolicyCodeIsNotNull() {
            addCriterion("POLICY_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andPolicyCodeEqualTo(String value) {
            addCriterion("POLICY_CODE =", value, "policyCode");
            return (Criteria) this;
        }

        public Criteria andPolicyCodeNotEqualTo(String value) {
            addCriterion("POLICY_CODE <>", value, "policyCode");
            return (Criteria) this;
        }

        public Criteria andPolicyCodeGreaterThan(String value) {
            addCriterion("POLICY_CODE >", value, "policyCode");
            return (Criteria) this;
        }

        public Criteria andPolicyCodeGreaterThanOrEqualTo(String value) {
            addCriterion("POLICY_CODE >=", value, "policyCode");
            return (Criteria) this;
        }

        public Criteria andPolicyCodeLessThan(String value) {
            addCriterion("POLICY_CODE <", value, "policyCode");
            return (Criteria) this;
        }

        public Criteria andPolicyCodeLessThanOrEqualTo(String value) {
            addCriterion("POLICY_CODE <=", value, "policyCode");
            return (Criteria) this;
        }

        public Criteria andPolicyCodeLike(String value) {
            addCriterion("POLICY_CODE like", value, "policyCode");
            return (Criteria) this;
        }

        public Criteria andPolicyCodeNotLike(String value) {
            addCriterion("POLICY_CODE not like", value, "policyCode");
            return (Criteria) this;
        }

        public Criteria andPolicyCodeIn(List<String> values) {
            addCriterion("POLICY_CODE in", values, "policyCode");
            return (Criteria) this;
        }

        public Criteria andPolicyCodeNotIn(List<String> values) {
            addCriterion("POLICY_CODE not in", values, "policyCode");
            return (Criteria) this;
        }

        public Criteria andPolicyCodeBetween(String value1, String value2) {
            addCriterion("POLICY_CODE between", value1, value2, "policyCode");
            return (Criteria) this;
        }

        public Criteria andPolicyCodeNotBetween(String value1, String value2) {
            addCriterion("POLICY_CODE not between", value1, value2, "policyCode");
            return (Criteria) this;
        }

        public Criteria andStlObjectIdIsNull() {
            addCriterion("STL_OBJECT_ID is null");
            return (Criteria) this;
        }

        public Criteria andStlObjectIdIsNotNull() {
            addCriterion("STL_OBJECT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andStlObjectIdEqualTo(String value) {
            addCriterion("STL_OBJECT_ID =", value, "stlObjectId");
            return (Criteria) this;
        }

        public Criteria andStlObjectIdNotEqualTo(String value) {
            addCriterion("STL_OBJECT_ID <>", value, "stlObjectId");
            return (Criteria) this;
        }

        public Criteria andStlObjectIdGreaterThan(String value) {
            addCriterion("STL_OBJECT_ID >", value, "stlObjectId");
            return (Criteria) this;
        }

        public Criteria andStlObjectIdGreaterThanOrEqualTo(String value) {
            addCriterion("STL_OBJECT_ID >=", value, "stlObjectId");
            return (Criteria) this;
        }

        public Criteria andStlObjectIdLessThan(String value) {
            addCriterion("STL_OBJECT_ID <", value, "stlObjectId");
            return (Criteria) this;
        }

        public Criteria andStlObjectIdLessThanOrEqualTo(String value) {
            addCriterion("STL_OBJECT_ID <=", value, "stlObjectId");
            return (Criteria) this;
        }

        public Criteria andStlObjectIdLike(String value) {
            addCriterion("STL_OBJECT_ID like", value, "stlObjectId");
            return (Criteria) this;
        }

        public Criteria andStlObjectIdNotLike(String value) {
            addCriterion("STL_OBJECT_ID not like", value, "stlObjectId");
            return (Criteria) this;
        }

        public Criteria andStlObjectIdIn(List<String> values) {
            addCriterion("STL_OBJECT_ID in", values, "stlObjectId");
            return (Criteria) this;
        }

        public Criteria andStlObjectIdNotIn(List<String> values) {
            addCriterion("STL_OBJECT_ID not in", values, "stlObjectId");
            return (Criteria) this;
        }

        public Criteria andStlObjectIdBetween(String value1, String value2) {
            addCriterion("STL_OBJECT_ID between", value1, value2, "stlObjectId");
            return (Criteria) this;
        }

        public Criteria andStlObjectIdNotBetween(String value1, String value2) {
            addCriterion("STL_OBJECT_ID not between", value1, value2, "stlObjectId");
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

        public Criteria andBillStyleSnIsNull() {
            addCriterion("BILL_STYLE_SN is null");
            return (Criteria) this;
        }

        public Criteria andBillStyleSnIsNotNull() {
            addCriterion("BILL_STYLE_SN is not null");
            return (Criteria) this;
        }

        public Criteria andBillStyleSnEqualTo(String value) {
            addCriterion("BILL_STYLE_SN =", value, "billStyleSn");
            return (Criteria) this;
        }

        public Criteria andBillStyleSnNotEqualTo(String value) {
            addCriterion("BILL_STYLE_SN <>", value, "billStyleSn");
            return (Criteria) this;
        }

        public Criteria andBillStyleSnGreaterThan(String value) {
            addCriterion("BILL_STYLE_SN >", value, "billStyleSn");
            return (Criteria) this;
        }

        public Criteria andBillStyleSnGreaterThanOrEqualTo(String value) {
            addCriterion("BILL_STYLE_SN >=", value, "billStyleSn");
            return (Criteria) this;
        }

        public Criteria andBillStyleSnLessThan(String value) {
            addCriterion("BILL_STYLE_SN <", value, "billStyleSn");
            return (Criteria) this;
        }

        public Criteria andBillStyleSnLessThanOrEqualTo(String value) {
            addCriterion("BILL_STYLE_SN <=", value, "billStyleSn");
            return (Criteria) this;
        }

        public Criteria andBillStyleSnLike(String value) {
            addCriterion("BILL_STYLE_SN like", value, "billStyleSn");
            return (Criteria) this;
        }

        public Criteria andBillStyleSnNotLike(String value) {
            addCriterion("BILL_STYLE_SN not like", value, "billStyleSn");
            return (Criteria) this;
        }

        public Criteria andBillStyleSnIn(List<String> values) {
            addCriterion("BILL_STYLE_SN in", values, "billStyleSn");
            return (Criteria) this;
        }

        public Criteria andBillStyleSnNotIn(List<String> values) {
            addCriterion("BILL_STYLE_SN not in", values, "billStyleSn");
            return (Criteria) this;
        }

        public Criteria andBillStyleSnBetween(String value1, String value2) {
            addCriterion("BILL_STYLE_SN between", value1, value2, "billStyleSn");
            return (Criteria) this;
        }

        public Criteria andBillStyleSnNotBetween(String value1, String value2) {
            addCriterion("BILL_STYLE_SN not between", value1, value2, "billStyleSn");
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

        public Criteria andOrigFeeIsNull() {
            addCriterion("ORIG_FEE is null");
            return (Criteria) this;
        }

        public Criteria andOrigFeeIsNotNull() {
            addCriterion("ORIG_FEE is not null");
            return (Criteria) this;
        }

        public Criteria andOrigFeeEqualTo(Float value) {
            addCriterion("ORIG_FEE =", value, "origFee");
            return (Criteria) this;
        }

        public Criteria andOrigFeeNotEqualTo(Float value) {
            addCriterion("ORIG_FEE <>", value, "origFee");
            return (Criteria) this;
        }

        public Criteria andOrigFeeGreaterThan(Float value) {
            addCriterion("ORIG_FEE >", value, "origFee");
            return (Criteria) this;
        }

        public Criteria andOrigFeeGreaterThanOrEqualTo(Float value) {
            addCriterion("ORIG_FEE >=", value, "origFee");
            return (Criteria) this;
        }

        public Criteria andOrigFeeLessThan(Float value) {
            addCriterion("ORIG_FEE <", value, "origFee");
            return (Criteria) this;
        }

        public Criteria andOrigFeeLessThanOrEqualTo(Float value) {
            addCriterion("ORIG_FEE <=", value, "origFee");
            return (Criteria) this;
        }

        public Criteria andOrigFeeIn(List<Float> values) {
            addCriterion("ORIG_FEE in", values, "origFee");
            return (Criteria) this;
        }

        public Criteria andOrigFeeNotIn(List<Float> values) {
            addCriterion("ORIG_FEE not in", values, "origFee");
            return (Criteria) this;
        }

        public Criteria andOrigFeeBetween(Float value1, Float value2) {
            addCriterion("ORIG_FEE between", value1, value2, "origFee");
            return (Criteria) this;
        }

        public Criteria andOrigFeeNotBetween(Float value1, Float value2) {
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

        public Criteria andAdjustFeeIsNull() {
            addCriterion("ADJUST_FEE is null");
            return (Criteria) this;
        }

        public Criteria andAdjustFeeIsNotNull() {
            addCriterion("ADJUST_FEE is not null");
            return (Criteria) this;
        }

        public Criteria andAdjustFeeEqualTo(Float value) {
            addCriterion("ADJUST_FEE =", value, "adjustFee");
            return (Criteria) this;
        }

        public Criteria andAdjustFeeNotEqualTo(Float value) {
            addCriterion("ADJUST_FEE <>", value, "adjustFee");
            return (Criteria) this;
        }

        public Criteria andAdjustFeeGreaterThan(Float value) {
            addCriterion("ADJUST_FEE >", value, "adjustFee");
            return (Criteria) this;
        }

        public Criteria andAdjustFeeGreaterThanOrEqualTo(Float value) {
            addCriterion("ADJUST_FEE >=", value, "adjustFee");
            return (Criteria) this;
        }

        public Criteria andAdjustFeeLessThan(Float value) {
            addCriterion("ADJUST_FEE <", value, "adjustFee");
            return (Criteria) this;
        }

        public Criteria andAdjustFeeLessThanOrEqualTo(Float value) {
            addCriterion("ADJUST_FEE <=", value, "adjustFee");
            return (Criteria) this;
        }

        public Criteria andAdjustFeeIn(List<Float> values) {
            addCriterion("ADJUST_FEE in", values, "adjustFee");
            return (Criteria) this;
        }

        public Criteria andAdjustFeeNotIn(List<Float> values) {
            addCriterion("ADJUST_FEE not in", values, "adjustFee");
            return (Criteria) this;
        }

        public Criteria andAdjustFeeBetween(Float value1, Float value2) {
            addCriterion("ADJUST_FEE between", value1, value2, "adjustFee");
            return (Criteria) this;
        }

        public Criteria andAdjustFeeNotBetween(Float value1, Float value2) {
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

        public Criteria andFinalFeeEqualTo(Float value) {
            addCriterion("FINAL_FEE =", value, "finalFee");
            return (Criteria) this;
        }

        public Criteria andFinalFeeNotEqualTo(Float value) {
            addCriterion("FINAL_FEE <>", value, "finalFee");
            return (Criteria) this;
        }

        public Criteria andFinalFeeGreaterThan(Float value) {
            addCriterion("FINAL_FEE >", value, "finalFee");
            return (Criteria) this;
        }

        public Criteria andFinalFeeGreaterThanOrEqualTo(Float value) {
            addCriterion("FINAL_FEE >=", value, "finalFee");
            return (Criteria) this;
        }

        public Criteria andFinalFeeLessThan(Float value) {
            addCriterion("FINAL_FEE <", value, "finalFee");
            return (Criteria) this;
        }

        public Criteria andFinalFeeLessThanOrEqualTo(Float value) {
            addCriterion("FINAL_FEE <=", value, "finalFee");
            return (Criteria) this;
        }

        public Criteria andFinalFeeIn(List<Float> values) {
            addCriterion("FINAL_FEE in", values, "finalFee");
            return (Criteria) this;
        }

        public Criteria andFinalFeeNotIn(List<Float> values) {
            addCriterion("FINAL_FEE not in", values, "finalFee");
            return (Criteria) this;
        }

        public Criteria andFinalFeeBetween(Float value1, Float value2) {
            addCriterion("FINAL_FEE between", value1, value2, "finalFee");
            return (Criteria) this;
        }

        public Criteria andFinalFeeNotBetween(Float value1, Float value2) {
            addCriterion("FINAL_FEE not between", value1, value2, "finalFee");
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

    public String getYyyyMm() {
        return yyyyMm;
    }

    public void setYyyyMm(String yyyyMm) {
        this.yyyyMm = yyyyMm;
    }

}
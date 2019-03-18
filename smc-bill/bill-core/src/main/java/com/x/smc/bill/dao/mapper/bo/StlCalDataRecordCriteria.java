package com.x.smc.bill.dao.mapper.bo;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class StlCalDataRecordCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public StlCalDataRecordCriteria() {
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

        public Criteria andRecordIdIsNull() {
            addCriterion("RECORD_ID is null");
            return (Criteria) this;
        }

        public Criteria andRecordIdIsNotNull() {
            addCriterion("RECORD_ID is not null");
            return (Criteria) this;
        }

        public Criteria andRecordIdEqualTo(Long value) {
            addCriterion("RECORD_ID =", value, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdNotEqualTo(Long value) {
            addCriterion("RECORD_ID <>", value, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdGreaterThan(Long value) {
            addCriterion("RECORD_ID >", value, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdGreaterThanOrEqualTo(Long value) {
            addCriterion("RECORD_ID >=", value, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdLessThan(Long value) {
            addCriterion("RECORD_ID <", value, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdLessThanOrEqualTo(Long value) {
            addCriterion("RECORD_ID <=", value, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdIn(List<Long> values) {
            addCriterion("RECORD_ID in", values, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdNotIn(List<Long> values) {
            addCriterion("RECORD_ID not in", values, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdBetween(Long value1, Long value2) {
            addCriterion("RECORD_ID between", value1, value2, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdNotBetween(Long value1, Long value2) {
            addCriterion("RECORD_ID not between", value1, value2, "recordId");
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

        public Criteria andDataTypeIsNull() {
            addCriterion("DATA_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andDataTypeIsNotNull() {
            addCriterion("DATA_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andDataTypeEqualTo(String value) {
            addCriterion("DATA_TYPE =", value, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeNotEqualTo(String value) {
            addCriterion("DATA_TYPE <>", value, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeGreaterThan(String value) {
            addCriterion("DATA_TYPE >", value, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeGreaterThanOrEqualTo(String value) {
            addCriterion("DATA_TYPE >=", value, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeLessThan(String value) {
            addCriterion("DATA_TYPE <", value, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeLessThanOrEqualTo(String value) {
            addCriterion("DATA_TYPE <=", value, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeLike(String value) {
            addCriterion("DATA_TYPE like", value, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeNotLike(String value) {
            addCriterion("DATA_TYPE not like", value, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeIn(List<String> values) {
            addCriterion("DATA_TYPE in", values, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeNotIn(List<String> values) {
            addCriterion("DATA_TYPE not in", values, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeBetween(String value1, String value2) {
            addCriterion("DATA_TYPE between", value1, value2, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeNotBetween(String value1, String value2) {
            addCriterion("DATA_TYPE not between", value1, value2, "dataType");
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

        public Criteria andObjectIdIsNull() {
            addCriterion("OBJECT_ID is null");
            return (Criteria) this;
        }

        public Criteria andObjectIdIsNotNull() {
            addCriterion("OBJECT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andObjectIdEqualTo(String value) {
            addCriterion("OBJECT_ID =", value, "objectId");
            return (Criteria) this;
        }

        public Criteria andObjectIdNotEqualTo(String value) {
            addCriterion("OBJECT_ID <>", value, "objectId");
            return (Criteria) this;
        }

        public Criteria andObjectIdGreaterThan(String value) {
            addCriterion("OBJECT_ID >", value, "objectId");
            return (Criteria) this;
        }

        public Criteria andObjectIdGreaterThanOrEqualTo(String value) {
            addCriterion("OBJECT_ID >=", value, "objectId");
            return (Criteria) this;
        }

        public Criteria andObjectIdLessThan(String value) {
            addCriterion("OBJECT_ID <", value, "objectId");
            return (Criteria) this;
        }

        public Criteria andObjectIdLessThanOrEqualTo(String value) {
            addCriterion("OBJECT_ID <=", value, "objectId");
            return (Criteria) this;
        }

        public Criteria andObjectIdLike(String value) {
            addCriterion("OBJECT_ID like", value, "objectId");
            return (Criteria) this;
        }

        public Criteria andObjectIdNotLike(String value) {
            addCriterion("OBJECT_ID not like", value, "objectId");
            return (Criteria) this;
        }

        public Criteria andObjectIdIn(List<String> values) {
            addCriterion("OBJECT_ID in", values, "objectId");
            return (Criteria) this;
        }

        public Criteria andObjectIdNotIn(List<String> values) {
            addCriterion("OBJECT_ID not in", values, "objectId");
            return (Criteria) this;
        }

        public Criteria andObjectIdBetween(String value1, String value2) {
            addCriterion("OBJECT_ID between", value1, value2, "objectId");
            return (Criteria) this;
        }

        public Criteria andObjectIdNotBetween(String value1, String value2) {
            addCriterion("OBJECT_ID not between", value1, value2, "objectId");
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

        public Criteria andHbaseTableNamePrefixIsNull() {
            addCriterion("HBASE_TABLE_NAME_PREFIX is null");
            return (Criteria) this;
        }

        public Criteria andHbaseTableNamePrefixIsNotNull() {
            addCriterion("HBASE_TABLE_NAME_PREFIX is not null");
            return (Criteria) this;
        }

        public Criteria andHbaseTableNamePrefixEqualTo(String value) {
            addCriterion("HBASE_TABLE_NAME_PREFIX =", value, "hbaseTableNamePrefix");
            return (Criteria) this;
        }

        public Criteria andHbaseTableNamePrefixNotEqualTo(String value) {
            addCriterion("HBASE_TABLE_NAME_PREFIX <>", value, "hbaseTableNamePrefix");
            return (Criteria) this;
        }

        public Criteria andHbaseTableNamePrefixGreaterThan(String value) {
            addCriterion("HBASE_TABLE_NAME_PREFIX >", value, "hbaseTableNamePrefix");
            return (Criteria) this;
        }

        public Criteria andHbaseTableNamePrefixGreaterThanOrEqualTo(String value) {
            addCriterion("HBASE_TABLE_NAME_PREFIX >=", value, "hbaseTableNamePrefix");
            return (Criteria) this;
        }

        public Criteria andHbaseTableNamePrefixLessThan(String value) {
            addCriterion("HBASE_TABLE_NAME_PREFIX <", value, "hbaseTableNamePrefix");
            return (Criteria) this;
        }

        public Criteria andHbaseTableNamePrefixLessThanOrEqualTo(String value) {
            addCriterion("HBASE_TABLE_NAME_PREFIX <=", value, "hbaseTableNamePrefix");
            return (Criteria) this;
        }

        public Criteria andHbaseTableNamePrefixLike(String value) {
            addCriterion("HBASE_TABLE_NAME_PREFIX like", value, "hbaseTableNamePrefix");
            return (Criteria) this;
        }

        public Criteria andHbaseTableNamePrefixNotLike(String value) {
            addCriterion("HBASE_TABLE_NAME_PREFIX not like", value, "hbaseTableNamePrefix");
            return (Criteria) this;
        }

        public Criteria andHbaseTableNamePrefixIn(List<String> values) {
            addCriterion("HBASE_TABLE_NAME_PREFIX in", values, "hbaseTableNamePrefix");
            return (Criteria) this;
        }

        public Criteria andHbaseTableNamePrefixNotIn(List<String> values) {
            addCriterion("HBASE_TABLE_NAME_PREFIX not in", values, "hbaseTableNamePrefix");
            return (Criteria) this;
        }

        public Criteria andHbaseTableNamePrefixBetween(String value1, String value2) {
            addCriterion("HBASE_TABLE_NAME_PREFIX between", value1, value2, "hbaseTableNamePrefix");
            return (Criteria) this;
        }

        public Criteria andHbaseTableNamePrefixNotBetween(String value1, String value2) {
            addCriterion("HBASE_TABLE_NAME_PREFIX not between", value1, value2, "hbaseTableNamePrefix");
            return (Criteria) this;
        }

        public Criteria andCurrentCountIsNull() {
            addCriterion("CURRENT_COUNT is null");
            return (Criteria) this;
        }

        public Criteria andCurrentCountIsNotNull() {
            addCriterion("CURRENT_COUNT is not null");
            return (Criteria) this;
        }

        public Criteria andCurrentCountEqualTo(String value) {
            addCriterion("CURRENT_COUNT =", value, "currentCount");
            return (Criteria) this;
        }

        public Criteria andCurrentCountNotEqualTo(String value) {
            addCriterion("CURRENT_COUNT <>", value, "currentCount");
            return (Criteria) this;
        }

        public Criteria andCurrentCountGreaterThan(String value) {
            addCriterion("CURRENT_COUNT >", value, "currentCount");
            return (Criteria) this;
        }

        public Criteria andCurrentCountGreaterThanOrEqualTo(String value) {
            addCriterion("CURRENT_COUNT >=", value, "currentCount");
            return (Criteria) this;
        }

        public Criteria andCurrentCountLessThan(String value) {
            addCriterion("CURRENT_COUNT <", value, "currentCount");
            return (Criteria) this;
        }

        public Criteria andCurrentCountLessThanOrEqualTo(String value) {
            addCriterion("CURRENT_COUNT <=", value, "currentCount");
            return (Criteria) this;
        }

        public Criteria andCurrentCountLike(String value) {
            addCriterion("CURRENT_COUNT like", value, "currentCount");
            return (Criteria) this;
        }

        public Criteria andCurrentCountNotLike(String value) {
            addCriterion("CURRENT_COUNT not like", value, "currentCount");
            return (Criteria) this;
        }

        public Criteria andCurrentCountIn(List<String> values) {
            addCriterion("CURRENT_COUNT in", values, "currentCount");
            return (Criteria) this;
        }

        public Criteria andCurrentCountNotIn(List<String> values) {
            addCriterion("CURRENT_COUNT not in", values, "currentCount");
            return (Criteria) this;
        }

        public Criteria andCurrentCountBetween(String value1, String value2) {
            addCriterion("CURRENT_COUNT between", value1, value2, "currentCount");
            return (Criteria) this;
        }

        public Criteria andCurrentCountNotBetween(String value1, String value2) {
            addCriterion("CURRENT_COUNT not between", value1, value2, "currentCount");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("UPDATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("UPDATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Timestamp value) {
            addCriterion("UPDATE_TIME =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Timestamp value) {
            addCriterion("UPDATE_TIME <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Timestamp value) {
            addCriterion("UPDATE_TIME >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Timestamp value) {
            addCriterion("UPDATE_TIME >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Timestamp value) {
            addCriterion("UPDATE_TIME <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Timestamp value) {
            addCriterion("UPDATE_TIME <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Timestamp> values) {
            addCriterion("UPDATE_TIME in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Timestamp> values) {
            addCriterion("UPDATE_TIME not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Timestamp value1, Timestamp value2) {
            addCriterion("UPDATE_TIME between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Timestamp value1, Timestamp value2) {
            addCriterion("UPDATE_TIME not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andCalDateIsNull() {
            addCriterion("CAL_DATE is null");
            return (Criteria) this;
        }

        public Criteria andCalDateIsNotNull() {
            addCriterion("CAL_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andCalDateEqualTo(Timestamp value) {
            addCriterion("CAL_DATE =", value, "calDate");
            return (Criteria) this;
        }

        public Criteria andCalDateNotEqualTo(Timestamp value) {
            addCriterion("CAL_DATE <>", value, "calDate");
            return (Criteria) this;
        }

        public Criteria andCalDateGreaterThan(Timestamp value) {
            addCriterion("CAL_DATE >", value, "calDate");
            return (Criteria) this;
        }

        public Criteria andCalDateGreaterThanOrEqualTo(Timestamp value) {
            addCriterion("CAL_DATE >=", value, "calDate");
            return (Criteria) this;
        }

        public Criteria andCalDateLessThan(Timestamp value) {
            addCriterion("CAL_DATE <", value, "calDate");
            return (Criteria) this;
        }

        public Criteria andCalDateLessThanOrEqualTo(Timestamp value) {
            addCriterion("CAL_DATE <=", value, "calDate");
            return (Criteria) this;
        }

        public Criteria andCalDateIn(List<Timestamp> values) {
            addCriterion("CAL_DATE in", values, "calDate");
            return (Criteria) this;
        }

        public Criteria andCalDateNotIn(List<Timestamp> values) {
            addCriterion("CAL_DATE not in", values, "calDate");
            return (Criteria) this;
        }

        public Criteria andCalDateBetween(Timestamp value1, Timestamp value2) {
            addCriterion("CAL_DATE between", value1, value2, "calDate");
            return (Criteria) this;
        }

        public Criteria andCalDateNotBetween(Timestamp value1, Timestamp value2) {
            addCriterion("CAL_DATE not between", value1, value2, "calDate");
            return (Criteria) this;
        }

        public Criteria andNextCalDateIsNull() {
            addCriterion("NEXT_CAL_DATE is null");
            return (Criteria) this;
        }

        public Criteria andNextCalDateIsNotNull() {
            addCriterion("NEXT_CAL_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andNextCalDateEqualTo(Timestamp value) {
            addCriterion("NEXT_CAL_DATE =", value, "nextCalDate");
            return (Criteria) this;
        }

        public Criteria andNextCalDateNotEqualTo(Timestamp value) {
            addCriterion("NEXT_CAL_DATE <>", value, "nextCalDate");
            return (Criteria) this;
        }

        public Criteria andNextCalDateGreaterThan(Timestamp value) {
            addCriterion("NEXT_CAL_DATE >", value, "nextCalDate");
            return (Criteria) this;
        }

        public Criteria andNextCalDateGreaterThanOrEqualTo(Timestamp value) {
            addCriterion("NEXT_CAL_DATE >=", value, "nextCalDate");
            return (Criteria) this;
        }

        public Criteria andNextCalDateLessThan(Timestamp value) {
            addCriterion("NEXT_CAL_DATE <", value, "nextCalDate");
            return (Criteria) this;
        }

        public Criteria andNextCalDateLessThanOrEqualTo(Timestamp value) {
            addCriterion("NEXT_CAL_DATE <=", value, "nextCalDate");
            return (Criteria) this;
        }

        public Criteria andNextCalDateIn(List<Timestamp> values) {
            addCriterion("NEXT_CAL_DATE in", values, "nextCalDate");
            return (Criteria) this;
        }

        public Criteria andNextCalDateNotIn(List<Timestamp> values) {
            addCriterion("NEXT_CAL_DATE not in", values, "nextCalDate");
            return (Criteria) this;
        }

        public Criteria andNextCalDateBetween(Timestamp value1, Timestamp value2) {
            addCriterion("NEXT_CAL_DATE between", value1, value2, "nextCalDate");
            return (Criteria) this;
        }

        public Criteria andNextCalDateNotBetween(Timestamp value1, Timestamp value2) {
            addCriterion("NEXT_CAL_DATE not between", value1, value2, "nextCalDate");
            return (Criteria) this;
        }

        public Criteria andRunStateIsNull() {
            addCriterion("RUN_STATE is null");
            return (Criteria) this;
        }

        public Criteria andRunStateIsNotNull() {
            addCriterion("RUN_STATE is not null");
            return (Criteria) this;
        }

        public Criteria andRunStateEqualTo(String value) {
            addCriterion("RUN_STATE =", value, "runState");
            return (Criteria) this;
        }

        public Criteria andRunStateNotEqualTo(String value) {
            addCriterion("RUN_STATE <>", value, "runState");
            return (Criteria) this;
        }

        public Criteria andRunStateGreaterThan(String value) {
            addCriterion("RUN_STATE >", value, "runState");
            return (Criteria) this;
        }

        public Criteria andRunStateGreaterThanOrEqualTo(String value) {
            addCriterion("RUN_STATE >=", value, "runState");
            return (Criteria) this;
        }

        public Criteria andRunStateLessThan(String value) {
            addCriterion("RUN_STATE <", value, "runState");
            return (Criteria) this;
        }

        public Criteria andRunStateLessThanOrEqualTo(String value) {
            addCriterion("RUN_STATE <=", value, "runState");
            return (Criteria) this;
        }

        public Criteria andRunStateLike(String value) {
            addCriterion("RUN_STATE like", value, "runState");
            return (Criteria) this;
        }

        public Criteria andRunStateNotLike(String value) {
            addCriterion("RUN_STATE not like", value, "runState");
            return (Criteria) this;
        }

        public Criteria andRunStateIn(List<String> values) {
            addCriterion("RUN_STATE in", values, "runState");
            return (Criteria) this;
        }

        public Criteria andRunStateNotIn(List<String> values) {
            addCriterion("RUN_STATE not in", values, "runState");
            return (Criteria) this;
        }

        public Criteria andRunStateBetween(String value1, String value2) {
            addCriterion("RUN_STATE between", value1, value2, "runState");
            return (Criteria) this;
        }

        public Criteria andRunStateNotBetween(String value1, String value2) {
            addCriterion("RUN_STATE not between", value1, value2, "runState");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("STATE is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("STATE is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(String value) {
            addCriterion("STATE =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(String value) {
            addCriterion("STATE <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(String value) {
            addCriterion("STATE >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(String value) {
            addCriterion("STATE >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(String value) {
            addCriterion("STATE <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(String value) {
            addCriterion("STATE <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLike(String value) {
            addCriterion("STATE like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotLike(String value) {
            addCriterion("STATE not like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<String> values) {
            addCriterion("STATE in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<String> values) {
            addCriterion("STATE not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(String value1, String value2) {
            addCriterion("STATE between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(String value1, String value2) {
            addCriterion("STATE not between", value1, value2, "state");
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
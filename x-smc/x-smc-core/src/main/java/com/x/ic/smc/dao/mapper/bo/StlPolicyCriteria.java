package com.x.ic.smc.dao.mapper.bo;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class StlPolicyCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public StlPolicyCriteria() {
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

        public Criteria andPolicyIdIsNull() {
            addCriterion("POLICY_ID is null");
            return (Criteria) this;
        }

        public Criteria andPolicyIdIsNotNull() {
            addCriterion("POLICY_ID is not null");
            return (Criteria) this;
        }

        public Criteria andPolicyIdEqualTo(Long value) {
            addCriterion("POLICY_ID =", value, "policyId");
            return (Criteria) this;
        }

        public Criteria andPolicyIdNotEqualTo(Long value) {
            addCriterion("POLICY_ID <>", value, "policyId");
            return (Criteria) this;
        }

        public Criteria andPolicyIdGreaterThan(Long value) {
            addCriterion("POLICY_ID >", value, "policyId");
            return (Criteria) this;
        }

        public Criteria andPolicyIdGreaterThanOrEqualTo(Long value) {
            addCriterion("POLICY_ID >=", value, "policyId");
            return (Criteria) this;
        }

        public Criteria andPolicyIdLessThan(Long value) {
            addCriterion("POLICY_ID <", value, "policyId");
            return (Criteria) this;
        }

        public Criteria andPolicyIdLessThanOrEqualTo(Long value) {
            addCriterion("POLICY_ID <=", value, "policyId");
            return (Criteria) this;
        }

        public Criteria andPolicyIdIn(List<Long> values) {
            addCriterion("POLICY_ID in", values, "policyId");
            return (Criteria) this;
        }

        public Criteria andPolicyIdNotIn(List<Long> values) {
            addCriterion("POLICY_ID not in", values, "policyId");
            return (Criteria) this;
        }

        public Criteria andPolicyIdBetween(Long value1, Long value2) {
            addCriterion("POLICY_ID between", value1, value2, "policyId");
            return (Criteria) this;
        }

        public Criteria andPolicyIdNotBetween(Long value1, Long value2) {
            addCriterion("POLICY_ID not between", value1, value2, "policyId");
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

        public Criteria andPolicyNameIsNull() {
            addCriterion("POLICY_NAME is null");
            return (Criteria) this;
        }

        public Criteria andPolicyNameIsNotNull() {
            addCriterion("POLICY_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andPolicyNameEqualTo(String value) {
            addCriterion("POLICY_NAME =", value, "policyName");
            return (Criteria) this;
        }

        public Criteria andPolicyNameNotEqualTo(String value) {
            addCriterion("POLICY_NAME <>", value, "policyName");
            return (Criteria) this;
        }

        public Criteria andPolicyNameGreaterThan(String value) {
            addCriterion("POLICY_NAME >", value, "policyName");
            return (Criteria) this;
        }

        public Criteria andPolicyNameGreaterThanOrEqualTo(String value) {
            addCriterion("POLICY_NAME >=", value, "policyName");
            return (Criteria) this;
        }

        public Criteria andPolicyNameLessThan(String value) {
            addCriterion("POLICY_NAME <", value, "policyName");
            return (Criteria) this;
        }

        public Criteria andPolicyNameLessThanOrEqualTo(String value) {
            addCriterion("POLICY_NAME <=", value, "policyName");
            return (Criteria) this;
        }

        public Criteria andPolicyNameLike(String value) {
            addCriterion("POLICY_NAME like", value, "policyName");
            return (Criteria) this;
        }

        public Criteria andPolicyNameNotLike(String value) {
            addCriterion("POLICY_NAME not like", value, "policyName");
            return (Criteria) this;
        }

        public Criteria andPolicyNameIn(List<String> values) {
            addCriterion("POLICY_NAME in", values, "policyName");
            return (Criteria) this;
        }

        public Criteria andPolicyNameNotIn(List<String> values) {
            addCriterion("POLICY_NAME not in", values, "policyName");
            return (Criteria) this;
        }

        public Criteria andPolicyNameBetween(String value1, String value2) {
            addCriterion("POLICY_NAME between", value1, value2, "policyName");
            return (Criteria) this;
        }

        public Criteria andPolicyNameNotBetween(String value1, String value2) {
            addCriterion("POLICY_NAME not between", value1, value2, "policyName");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNull() {
            addCriterion("START_TIME is null");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNotNull() {
            addCriterion("START_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andStartTimeEqualTo(Timestamp value) {
            addCriterion("START_TIME =", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotEqualTo(Timestamp value) {
            addCriterion("START_TIME <>", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThan(Timestamp value) {
            addCriterion("START_TIME >", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThanOrEqualTo(Timestamp value) {
            addCriterion("START_TIME >=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThan(Timestamp value) {
            addCriterion("START_TIME <", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThanOrEqualTo(Timestamp value) {
            addCriterion("START_TIME <=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeIn(List<Timestamp> values) {
            addCriterion("START_TIME in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotIn(List<Timestamp> values) {
            addCriterion("START_TIME not in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeBetween(Timestamp value1, Timestamp value2) {
            addCriterion("START_TIME between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotBetween(Timestamp value1, Timestamp value2) {
            addCriterion("START_TIME not between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNull() {
            addCriterion("END_TIME is null");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNotNull() {
            addCriterion("END_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andEndTimeEqualTo(Timestamp value) {
            addCriterion("END_TIME =", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotEqualTo(Timestamp value) {
            addCriterion("END_TIME <>", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThan(Timestamp value) {
            addCriterion("END_TIME >", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThanOrEqualTo(Timestamp value) {
            addCriterion("END_TIME >=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThan(Timestamp value) {
            addCriterion("END_TIME <", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThanOrEqualTo(Timestamp value) {
            addCriterion("END_TIME <=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIn(List<Timestamp> values) {
            addCriterion("END_TIME in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotIn(List<Timestamp> values) {
            addCriterion("END_TIME not in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeBetween(Timestamp value1, Timestamp value2) {
            addCriterion("END_TIME between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotBetween(Timestamp value1, Timestamp value2) {
            addCriterion("END_TIME not between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andPolicyTypeIsNull() {
            addCriterion("POLICY_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andPolicyTypeIsNotNull() {
            addCriterion("POLICY_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andPolicyTypeEqualTo(String value) {
            addCriterion("POLICY_TYPE =", value, "policyType");
            return (Criteria) this;
        }

        public Criteria andPolicyTypeNotEqualTo(String value) {
            addCriterion("POLICY_TYPE <>", value, "policyType");
            return (Criteria) this;
        }

        public Criteria andPolicyTypeGreaterThan(String value) {
            addCriterion("POLICY_TYPE >", value, "policyType");
            return (Criteria) this;
        }

        public Criteria andPolicyTypeGreaterThanOrEqualTo(String value) {
            addCriterion("POLICY_TYPE >=", value, "policyType");
            return (Criteria) this;
        }

        public Criteria andPolicyTypeLessThan(String value) {
            addCriterion("POLICY_TYPE <", value, "policyType");
            return (Criteria) this;
        }

        public Criteria andPolicyTypeLessThanOrEqualTo(String value) {
            addCriterion("POLICY_TYPE <=", value, "policyType");
            return (Criteria) this;
        }

        public Criteria andPolicyTypeLike(String value) {
            addCriterion("POLICY_TYPE like", value, "policyType");
            return (Criteria) this;
        }

        public Criteria andPolicyTypeNotLike(String value) {
            addCriterion("POLICY_TYPE not like", value, "policyType");
            return (Criteria) this;
        }

        public Criteria andPolicyTypeIn(List<String> values) {
            addCriterion("POLICY_TYPE in", values, "policyType");
            return (Criteria) this;
        }

        public Criteria andPolicyTypeNotIn(List<String> values) {
            addCriterion("POLICY_TYPE not in", values, "policyType");
            return (Criteria) this;
        }

        public Criteria andPolicyTypeBetween(String value1, String value2) {
            addCriterion("POLICY_TYPE between", value1, value2, "policyType");
            return (Criteria) this;
        }

        public Criteria andPolicyTypeNotBetween(String value1, String value2) {
            addCriterion("POLICY_TYPE not between", value1, value2, "policyType");
            return (Criteria) this;
        }

        public Criteria andPolicyDescIsNull() {
            addCriterion("POLICY_DESC is null");
            return (Criteria) this;
        }

        public Criteria andPolicyDescIsNotNull() {
            addCriterion("POLICY_DESC is not null");
            return (Criteria) this;
        }

        public Criteria andPolicyDescEqualTo(String value) {
            addCriterion("POLICY_DESC =", value, "policyDesc");
            return (Criteria) this;
        }

        public Criteria andPolicyDescNotEqualTo(String value) {
            addCriterion("POLICY_DESC <>", value, "policyDesc");
            return (Criteria) this;
        }

        public Criteria andPolicyDescGreaterThan(String value) {
            addCriterion("POLICY_DESC >", value, "policyDesc");
            return (Criteria) this;
        }

        public Criteria andPolicyDescGreaterThanOrEqualTo(String value) {
            addCriterion("POLICY_DESC >=", value, "policyDesc");
            return (Criteria) this;
        }

        public Criteria andPolicyDescLessThan(String value) {
            addCriterion("POLICY_DESC <", value, "policyDesc");
            return (Criteria) this;
        }

        public Criteria andPolicyDescLessThanOrEqualTo(String value) {
            addCriterion("POLICY_DESC <=", value, "policyDesc");
            return (Criteria) this;
        }

        public Criteria andPolicyDescLike(String value) {
            addCriterion("POLICY_DESC like", value, "policyDesc");
            return (Criteria) this;
        }

        public Criteria andPolicyDescNotLike(String value) {
            addCriterion("POLICY_DESC not like", value, "policyDesc");
            return (Criteria) this;
        }

        public Criteria andPolicyDescIn(List<String> values) {
            addCriterion("POLICY_DESC in", values, "policyDesc");
            return (Criteria) this;
        }

        public Criteria andPolicyDescNotIn(List<String> values) {
            addCriterion("POLICY_DESC not in", values, "policyDesc");
            return (Criteria) this;
        }

        public Criteria andPolicyDescBetween(String value1, String value2) {
            addCriterion("POLICY_DESC between", value1, value2, "policyDesc");
            return (Criteria) this;
        }

        public Criteria andPolicyDescNotBetween(String value1, String value2) {
            addCriterion("POLICY_DESC not between", value1, value2, "policyDesc");
            return (Criteria) this;
        }

        public Criteria andExecCycleIsNull() {
            addCriterion("EXEC_CYCLE is null");
            return (Criteria) this;
        }

        public Criteria andExecCycleIsNotNull() {
            addCriterion("EXEC_CYCLE is not null");
            return (Criteria) this;
        }

        public Criteria andExecCycleEqualTo(String value) {
            addCriterion("EXEC_CYCLE =", value, "execCycle");
            return (Criteria) this;
        }

        public Criteria andExecCycleNotEqualTo(String value) {
            addCriterion("EXEC_CYCLE <>", value, "execCycle");
            return (Criteria) this;
        }

        public Criteria andExecCycleGreaterThan(String value) {
            addCriterion("EXEC_CYCLE >", value, "execCycle");
            return (Criteria) this;
        }

        public Criteria andExecCycleGreaterThanOrEqualTo(String value) {
            addCriterion("EXEC_CYCLE >=", value, "execCycle");
            return (Criteria) this;
        }

        public Criteria andExecCycleLessThan(String value) {
            addCriterion("EXEC_CYCLE <", value, "execCycle");
            return (Criteria) this;
        }

        public Criteria andExecCycleLessThanOrEqualTo(String value) {
            addCriterion("EXEC_CYCLE <=", value, "execCycle");
            return (Criteria) this;
        }

        public Criteria andExecCycleLike(String value) {
            addCriterion("EXEC_CYCLE like", value, "execCycle");
            return (Criteria) this;
        }

        public Criteria andExecCycleNotLike(String value) {
            addCriterion("EXEC_CYCLE not like", value, "execCycle");
            return (Criteria) this;
        }

        public Criteria andExecCycleIn(List<String> values) {
            addCriterion("EXEC_CYCLE in", values, "execCycle");
            return (Criteria) this;
        }

        public Criteria andExecCycleNotIn(List<String> values) {
            addCriterion("EXEC_CYCLE not in", values, "execCycle");
            return (Criteria) this;
        }

        public Criteria andExecCycleBetween(String value1, String value2) {
            addCriterion("EXEC_CYCLE between", value1, value2, "execCycle");
            return (Criteria) this;
        }

        public Criteria andExecCycleNotBetween(String value1, String value2) {
            addCriterion("EXEC_CYCLE not between", value1, value2, "execCycle");
            return (Criteria) this;
        }

        public Criteria andExecTimeStrIsNull() {
            addCriterion("EXEC_TIME_STR is null");
            return (Criteria) this;
        }

        public Criteria andExecTimeStrIsNotNull() {
            addCriterion("EXEC_TIME_STR is not null");
            return (Criteria) this;
        }

        public Criteria andExecTimeStrEqualTo(String value) {
            addCriterion("EXEC_TIME_STR =", value, "execTimeStr");
            return (Criteria) this;
        }

        public Criteria andExecTimeStrNotEqualTo(String value) {
            addCriterion("EXEC_TIME_STR <>", value, "execTimeStr");
            return (Criteria) this;
        }

        public Criteria andExecTimeStrGreaterThan(String value) {
            addCriterion("EXEC_TIME_STR >", value, "execTimeStr");
            return (Criteria) this;
        }

        public Criteria andExecTimeStrGreaterThanOrEqualTo(String value) {
            addCriterion("EXEC_TIME_STR >=", value, "execTimeStr");
            return (Criteria) this;
        }

        public Criteria andExecTimeStrLessThan(String value) {
            addCriterion("EXEC_TIME_STR <", value, "execTimeStr");
            return (Criteria) this;
        }

        public Criteria andExecTimeStrLessThanOrEqualTo(String value) {
            addCriterion("EXEC_TIME_STR <=", value, "execTimeStr");
            return (Criteria) this;
        }

        public Criteria andExecTimeStrLike(String value) {
            addCriterion("EXEC_TIME_STR like", value, "execTimeStr");
            return (Criteria) this;
        }

        public Criteria andExecTimeStrNotLike(String value) {
            addCriterion("EXEC_TIME_STR not like", value, "execTimeStr");
            return (Criteria) this;
        }

        public Criteria andExecTimeStrIn(List<String> values) {
            addCriterion("EXEC_TIME_STR in", values, "execTimeStr");
            return (Criteria) this;
        }

        public Criteria andExecTimeStrNotIn(List<String> values) {
            addCriterion("EXEC_TIME_STR not in", values, "execTimeStr");
            return (Criteria) this;
        }

        public Criteria andExecTimeStrBetween(String value1, String value2) {
            addCriterion("EXEC_TIME_STR between", value1, value2, "execTimeStr");
            return (Criteria) this;
        }

        public Criteria andExecTimeStrNotBetween(String value1, String value2) {
            addCriterion("EXEC_TIME_STR not between", value1, value2, "execTimeStr");
            return (Criteria) this;
        }

        public Criteria andDataObjectIdIsNull() {
            addCriterion("DATA_OBJECT_ID is null");
            return (Criteria) this;
        }

        public Criteria andDataObjectIdIsNotNull() {
            addCriterion("DATA_OBJECT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andDataObjectIdEqualTo(String value) {
            addCriterion("DATA_OBJECT_ID =", value, "dataObjectId");
            return (Criteria) this;
        }

        public Criteria andDataObjectIdNotEqualTo(String value) {
            addCriterion("DATA_OBJECT_ID <>", value, "dataObjectId");
            return (Criteria) this;
        }

        public Criteria andDataObjectIdGreaterThan(String value) {
            addCriterion("DATA_OBJECT_ID >", value, "dataObjectId");
            return (Criteria) this;
        }

        public Criteria andDataObjectIdGreaterThanOrEqualTo(String value) {
            addCriterion("DATA_OBJECT_ID >=", value, "dataObjectId");
            return (Criteria) this;
        }

        public Criteria andDataObjectIdLessThan(String value) {
            addCriterion("DATA_OBJECT_ID <", value, "dataObjectId");
            return (Criteria) this;
        }

        public Criteria andDataObjectIdLessThanOrEqualTo(String value) {
            addCriterion("DATA_OBJECT_ID <=", value, "dataObjectId");
            return (Criteria) this;
        }

        public Criteria andDataObjectIdLike(String value) {
            addCriterion("DATA_OBJECT_ID like", value, "dataObjectId");
            return (Criteria) this;
        }

        public Criteria andDataObjectIdNotLike(String value) {
            addCriterion("DATA_OBJECT_ID not like", value, "dataObjectId");
            return (Criteria) this;
        }

        public Criteria andDataObjectIdIn(List<String> values) {
            addCriterion("DATA_OBJECT_ID in", values, "dataObjectId");
            return (Criteria) this;
        }

        public Criteria andDataObjectIdNotIn(List<String> values) {
            addCriterion("DATA_OBJECT_ID not in", values, "dataObjectId");
            return (Criteria) this;
        }

        public Criteria andDataObjectIdBetween(String value1, String value2) {
            addCriterion("DATA_OBJECT_ID between", value1, value2, "dataObjectId");
            return (Criteria) this;
        }

        public Criteria andDataObjectIdNotBetween(String value1, String value2) {
            addCriterion("DATA_OBJECT_ID not between", value1, value2, "dataObjectId");
            return (Criteria) this;
        }

        public Criteria andDataElementIdIsNull() {
            addCriterion("DATA_ELEMENT_ID is null");
            return (Criteria) this;
        }

        public Criteria andDataElementIdIsNotNull() {
            addCriterion("DATA_ELEMENT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andDataElementIdEqualTo(Long value) {
            addCriterion("DATA_ELEMENT_ID =", value, "dataElementId");
            return (Criteria) this;
        }

        public Criteria andDataElementIdNotEqualTo(Long value) {
            addCriterion("DATA_ELEMENT_ID <>", value, "dataElementId");
            return (Criteria) this;
        }

        public Criteria andDataElementIdGreaterThan(Long value) {
            addCriterion("DATA_ELEMENT_ID >", value, "dataElementId");
            return (Criteria) this;
        }

        public Criteria andDataElementIdGreaterThanOrEqualTo(Long value) {
            addCriterion("DATA_ELEMENT_ID >=", value, "dataElementId");
            return (Criteria) this;
        }

        public Criteria andDataElementIdLessThan(Long value) {
            addCriterion("DATA_ELEMENT_ID <", value, "dataElementId");
            return (Criteria) this;
        }

        public Criteria andDataElementIdLessThanOrEqualTo(Long value) {
            addCriterion("DATA_ELEMENT_ID <=", value, "dataElementId");
            return (Criteria) this;
        }

        public Criteria andDataElementIdIn(List<Long> values) {
            addCriterion("DATA_ELEMENT_ID in", values, "dataElementId");
            return (Criteria) this;
        }

        public Criteria andDataElementIdNotIn(List<Long> values) {
            addCriterion("DATA_ELEMENT_ID not in", values, "dataElementId");
            return (Criteria) this;
        }

        public Criteria andDataElementIdBetween(Long value1, Long value2) {
            addCriterion("DATA_ELEMENT_ID between", value1, value2, "dataElementId");
            return (Criteria) this;
        }

        public Criteria andDataElementIdNotBetween(Long value1, Long value2) {
            addCriterion("DATA_ELEMENT_ID not between", value1, value2, "dataElementId");
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
            addCriterion("stl_element_sn is null");
            return (Criteria) this;
        }

        public Criteria andStlElementSnIsNotNull() {
            addCriterion("stl_element_sn is not null");
            return (Criteria) this;
        }

        public Criteria andStlElementSnEqualTo(String value) {
            addCriterion("stl_element_sn =", value, "stlElementSn");
            return (Criteria) this;
        }

        public Criteria andStlElementSnNotEqualTo(String value) {
            addCriterion("stl_element_sn <>", value, "stlElementSn");
            return (Criteria) this;
        }

        public Criteria andStlElementSnGreaterThan(String value) {
            addCriterion("stl_element_sn >", value, "stlElementSn");
            return (Criteria) this;
        }

        public Criteria andStlElementSnGreaterThanOrEqualTo(String value) {
            addCriterion("stl_element_sn >=", value, "stlElementSn");
            return (Criteria) this;
        }

        public Criteria andStlElementSnLessThan(String value) {
            addCriterion("stl_element_sn <", value, "stlElementSn");
            return (Criteria) this;
        }

        public Criteria andStlElementSnLessThanOrEqualTo(String value) {
            addCriterion("stl_element_sn <=", value, "stlElementSn");
            return (Criteria) this;
        }

        public Criteria andStlElementSnLike(String value) {
            addCriterion("stl_element_sn like", value, "stlElementSn");
            return (Criteria) this;
        }

        public Criteria andStlElementSnNotLike(String value) {
            addCriterion("stl_element_sn not like", value, "stlElementSn");
            return (Criteria) this;
        }

        public Criteria andStlElementSnIn(List<String> values) {
            addCriterion("stl_element_sn in", values, "stlElementSn");
            return (Criteria) this;
        }

        public Criteria andStlElementSnNotIn(List<String> values) {
            addCriterion("stl_element_sn not in", values, "stlElementSn");
            return (Criteria) this;
        }

        public Criteria andStlElementSnBetween(String value1, String value2) {
            addCriterion("stl_element_sn between", value1, value2, "stlElementSn");
            return (Criteria) this;
        }

        public Criteria andStlElementSnNotBetween(String value1, String value2) {
            addCriterion("stl_element_sn not between", value1, value2, "stlElementSn");
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

        public Criteria andCheckFeeFlagIsNull() {
            addCriterion("CHECK_FEE_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andCheckFeeFlagIsNotNull() {
            addCriterion("CHECK_FEE_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andCheckFeeFlagEqualTo(String value) {
            addCriterion("CHECK_FEE_FLAG =", value, "checkFeeFlag");
            return (Criteria) this;
        }

        public Criteria andCheckFeeFlagNotEqualTo(String value) {
            addCriterion("CHECK_FEE_FLAG <>", value, "checkFeeFlag");
            return (Criteria) this;
        }

        public Criteria andCheckFeeFlagGreaterThan(String value) {
            addCriterion("CHECK_FEE_FLAG >", value, "checkFeeFlag");
            return (Criteria) this;
        }

        public Criteria andCheckFeeFlagGreaterThanOrEqualTo(String value) {
            addCriterion("CHECK_FEE_FLAG >=", value, "checkFeeFlag");
            return (Criteria) this;
        }

        public Criteria andCheckFeeFlagLessThan(String value) {
            addCriterion("CHECK_FEE_FLAG <", value, "checkFeeFlag");
            return (Criteria) this;
        }

        public Criteria andCheckFeeFlagLessThanOrEqualTo(String value) {
            addCriterion("CHECK_FEE_FLAG <=", value, "checkFeeFlag");
            return (Criteria) this;
        }

        public Criteria andCheckFeeFlagLike(String value) {
            addCriterion("CHECK_FEE_FLAG like", value, "checkFeeFlag");
            return (Criteria) this;
        }

        public Criteria andCheckFeeFlagNotLike(String value) {
            addCriterion("CHECK_FEE_FLAG not like", value, "checkFeeFlag");
            return (Criteria) this;
        }

        public Criteria andCheckFeeFlagIn(List<String> values) {
            addCriterion("CHECK_FEE_FLAG in", values, "checkFeeFlag");
            return (Criteria) this;
        }

        public Criteria andCheckFeeFlagNotIn(List<String> values) {
            addCriterion("CHECK_FEE_FLAG not in", values, "checkFeeFlag");
            return (Criteria) this;
        }

        public Criteria andCheckFeeFlagBetween(String value1, String value2) {
            addCriterion("CHECK_FEE_FLAG between", value1, value2, "checkFeeFlag");
            return (Criteria) this;
        }

        public Criteria andCheckFeeFlagNotBetween(String value1, String value2) {
            addCriterion("CHECK_FEE_FLAG not between", value1, value2, "checkFeeFlag");
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

        public Criteria andUpdateDeptIdIsNull() {
            addCriterion("UPDATE_DEPT_ID is null");
            return (Criteria) this;
        }

        public Criteria andUpdateDeptIdIsNotNull() {
            addCriterion("UPDATE_DEPT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateDeptIdEqualTo(String value) {
            addCriterion("UPDATE_DEPT_ID =", value, "updateDeptId");
            return (Criteria) this;
        }

        public Criteria andUpdateDeptIdNotEqualTo(String value) {
            addCriterion("UPDATE_DEPT_ID <>", value, "updateDeptId");
            return (Criteria) this;
        }

        public Criteria andUpdateDeptIdGreaterThan(String value) {
            addCriterion("UPDATE_DEPT_ID >", value, "updateDeptId");
            return (Criteria) this;
        }

        public Criteria andUpdateDeptIdGreaterThanOrEqualTo(String value) {
            addCriterion("UPDATE_DEPT_ID >=", value, "updateDeptId");
            return (Criteria) this;
        }

        public Criteria andUpdateDeptIdLessThan(String value) {
            addCriterion("UPDATE_DEPT_ID <", value, "updateDeptId");
            return (Criteria) this;
        }

        public Criteria andUpdateDeptIdLessThanOrEqualTo(String value) {
            addCriterion("UPDATE_DEPT_ID <=", value, "updateDeptId");
            return (Criteria) this;
        }

        public Criteria andUpdateDeptIdLike(String value) {
            addCriterion("UPDATE_DEPT_ID like", value, "updateDeptId");
            return (Criteria) this;
        }

        public Criteria andUpdateDeptIdNotLike(String value) {
            addCriterion("UPDATE_DEPT_ID not like", value, "updateDeptId");
            return (Criteria) this;
        }

        public Criteria andUpdateDeptIdIn(List<String> values) {
            addCriterion("UPDATE_DEPT_ID in", values, "updateDeptId");
            return (Criteria) this;
        }

        public Criteria andUpdateDeptIdNotIn(List<String> values) {
            addCriterion("UPDATE_DEPT_ID not in", values, "updateDeptId");
            return (Criteria) this;
        }

        public Criteria andUpdateDeptIdBetween(String value1, String value2) {
            addCriterion("UPDATE_DEPT_ID between", value1, value2, "updateDeptId");
            return (Criteria) this;
        }

        public Criteria andUpdateDeptIdNotBetween(String value1, String value2) {
            addCriterion("UPDATE_DEPT_ID not between", value1, value2, "updateDeptId");
            return (Criteria) this;
        }

        public Criteria andUpdateOperIdIsNull() {
            addCriterion("UPDATE_OPER_ID is null");
            return (Criteria) this;
        }

        public Criteria andUpdateOperIdIsNotNull() {
            addCriterion("UPDATE_OPER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateOperIdEqualTo(String value) {
            addCriterion("UPDATE_OPER_ID =", value, "updateOperId");
            return (Criteria) this;
        }

        public Criteria andUpdateOperIdNotEqualTo(String value) {
            addCriterion("UPDATE_OPER_ID <>", value, "updateOperId");
            return (Criteria) this;
        }

        public Criteria andUpdateOperIdGreaterThan(String value) {
            addCriterion("UPDATE_OPER_ID >", value, "updateOperId");
            return (Criteria) this;
        }

        public Criteria andUpdateOperIdGreaterThanOrEqualTo(String value) {
            addCriterion("UPDATE_OPER_ID >=", value, "updateOperId");
            return (Criteria) this;
        }

        public Criteria andUpdateOperIdLessThan(String value) {
            addCriterion("UPDATE_OPER_ID <", value, "updateOperId");
            return (Criteria) this;
        }

        public Criteria andUpdateOperIdLessThanOrEqualTo(String value) {
            addCriterion("UPDATE_OPER_ID <=", value, "updateOperId");
            return (Criteria) this;
        }

        public Criteria andUpdateOperIdLike(String value) {
            addCriterion("UPDATE_OPER_ID like", value, "updateOperId");
            return (Criteria) this;
        }

        public Criteria andUpdateOperIdNotLike(String value) {
            addCriterion("UPDATE_OPER_ID not like", value, "updateOperId");
            return (Criteria) this;
        }

        public Criteria andUpdateOperIdIn(List<String> values) {
            addCriterion("UPDATE_OPER_ID in", values, "updateOperId");
            return (Criteria) this;
        }

        public Criteria andUpdateOperIdNotIn(List<String> values) {
            addCriterion("UPDATE_OPER_ID not in", values, "updateOperId");
            return (Criteria) this;
        }

        public Criteria andUpdateOperIdBetween(String value1, String value2) {
            addCriterion("UPDATE_OPER_ID between", value1, value2, "updateOperId");
            return (Criteria) this;
        }

        public Criteria andUpdateOperIdNotBetween(String value1, String value2) {
            addCriterion("UPDATE_OPER_ID not between", value1, value2, "updateOperId");
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
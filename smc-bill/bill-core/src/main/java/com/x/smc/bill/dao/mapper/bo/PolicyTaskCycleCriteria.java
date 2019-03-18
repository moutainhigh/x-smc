package com.x.smc.bill.dao.mapper.bo;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class PolicyTaskCycleCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public PolicyTaskCycleCriteria() {
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

        public Criteria andPolicyCycleIdIsNull() {
            addCriterion("POLICY_CYCLE_ID is null");
            return (Criteria) this;
        }

        public Criteria andPolicyCycleIdIsNotNull() {
            addCriterion("POLICY_CYCLE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andPolicyCycleIdEqualTo(String value) {
            addCriterion("POLICY_CYCLE_ID =", value, "policyCycleId");
            return (Criteria) this;
        }

        public Criteria andPolicyCycleIdNotEqualTo(String value) {
            addCriterion("POLICY_CYCLE_ID <>", value, "policyCycleId");
            return (Criteria) this;
        }

        public Criteria andPolicyCycleIdGreaterThan(String value) {
            addCriterion("POLICY_CYCLE_ID >", value, "policyCycleId");
            return (Criteria) this;
        }

        public Criteria andPolicyCycleIdGreaterThanOrEqualTo(String value) {
            addCriterion("POLICY_CYCLE_ID >=", value, "policyCycleId");
            return (Criteria) this;
        }

        public Criteria andPolicyCycleIdLessThan(String value) {
            addCriterion("POLICY_CYCLE_ID <", value, "policyCycleId");
            return (Criteria) this;
        }

        public Criteria andPolicyCycleIdLessThanOrEqualTo(String value) {
            addCriterion("POLICY_CYCLE_ID <=", value, "policyCycleId");
            return (Criteria) this;
        }

        public Criteria andPolicyCycleIdLike(String value) {
            addCriterion("POLICY_CYCLE_ID like", value, "policyCycleId");
            return (Criteria) this;
        }

        public Criteria andPolicyCycleIdNotLike(String value) {
            addCriterion("POLICY_CYCLE_ID not like", value, "policyCycleId");
            return (Criteria) this;
        }

        public Criteria andPolicyCycleIdIn(List<String> values) {
            addCriterion("POLICY_CYCLE_ID in", values, "policyCycleId");
            return (Criteria) this;
        }

        public Criteria andPolicyCycleIdNotIn(List<String> values) {
            addCriterion("POLICY_CYCLE_ID not in", values, "policyCycleId");
            return (Criteria) this;
        }

        public Criteria andPolicyCycleIdBetween(String value1, String value2) {
            addCriterion("POLICY_CYCLE_ID between", value1, value2, "policyCycleId");
            return (Criteria) this;
        }

        public Criteria andPolicyCycleIdNotBetween(String value1, String value2) {
            addCriterion("POLICY_CYCLE_ID not between", value1, value2, "policyCycleId");
            return (Criteria) this;
        }

        public Criteria andPolicyCycleCodeIsNull() {
            addCriterion("POLICY_CYCLE_CODE is null");
            return (Criteria) this;
        }

        public Criteria andPolicyCycleCodeIsNotNull() {
            addCriterion("POLICY_CYCLE_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andPolicyCycleCodeEqualTo(String value) {
            addCriterion("POLICY_CYCLE_CODE =", value, "policyCycleCode");
            return (Criteria) this;
        }

        public Criteria andPolicyCycleCodeNotEqualTo(String value) {
            addCriterion("POLICY_CYCLE_CODE <>", value, "policyCycleCode");
            return (Criteria) this;
        }

        public Criteria andPolicyCycleCodeGreaterThan(String value) {
            addCriterion("POLICY_CYCLE_CODE >", value, "policyCycleCode");
            return (Criteria) this;
        }

        public Criteria andPolicyCycleCodeGreaterThanOrEqualTo(String value) {
            addCriterion("POLICY_CYCLE_CODE >=", value, "policyCycleCode");
            return (Criteria) this;
        }

        public Criteria andPolicyCycleCodeLessThan(String value) {
            addCriterion("POLICY_CYCLE_CODE <", value, "policyCycleCode");
            return (Criteria) this;
        }

        public Criteria andPolicyCycleCodeLessThanOrEqualTo(String value) {
            addCriterion("POLICY_CYCLE_CODE <=", value, "policyCycleCode");
            return (Criteria) this;
        }

        public Criteria andPolicyCycleCodeLike(String value) {
            addCriterion("POLICY_CYCLE_CODE like", value, "policyCycleCode");
            return (Criteria) this;
        }

        public Criteria andPolicyCycleCodeNotLike(String value) {
            addCriterion("POLICY_CYCLE_CODE not like", value, "policyCycleCode");
            return (Criteria) this;
        }

        public Criteria andPolicyCycleCodeIn(List<String> values) {
            addCriterion("POLICY_CYCLE_CODE in", values, "policyCycleCode");
            return (Criteria) this;
        }

        public Criteria andPolicyCycleCodeNotIn(List<String> values) {
            addCriterion("POLICY_CYCLE_CODE not in", values, "policyCycleCode");
            return (Criteria) this;
        }

        public Criteria andPolicyCycleCodeBetween(String value1, String value2) {
            addCriterion("POLICY_CYCLE_CODE between", value1, value2, "policyCycleCode");
            return (Criteria) this;
        }

        public Criteria andPolicyCycleCodeNotBetween(String value1, String value2) {
            addCriterion("POLICY_CYCLE_CODE not between", value1, value2, "policyCycleCode");
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

        public Criteria andStatusIsNull() {
            addCriterion("STATUS is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("STATUS =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("STATUS <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("STATUS >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("STATUS >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("STATUS <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("STATUS <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("STATUS like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("STATUS not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("STATUS in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("STATUS not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("STATUS between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("STATUS not between", value1, value2, "status");
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

        public Criteria andCreateDateIsNull() {
            addCriterion("CREATE_DATE is null");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNotNull() {
            addCriterion("CREATE_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDateEqualTo(Timestamp value) {
            addCriterion("CREATE_DATE =", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotEqualTo(Timestamp value) {
            addCriterion("CREATE_DATE <>", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThan(Timestamp value) {
            addCriterion("CREATE_DATE >", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThanOrEqualTo(Timestamp value) {
            addCriterion("CREATE_DATE >=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThan(Timestamp value) {
            addCriterion("CREATE_DATE <", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThanOrEqualTo(Timestamp value) {
            addCriterion("CREATE_DATE <=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateIn(List<Timestamp> values) {
            addCriterion("CREATE_DATE in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotIn(List<Timestamp> values) {
            addCriterion("CREATE_DATE not in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateBetween(Timestamp value1, Timestamp value2) {
            addCriterion("CREATE_DATE between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotBetween(Timestamp value1, Timestamp value2) {
            addCriterion("CREATE_DATE not between", value1, value2, "createDate");
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

        public Criteria andCreateStaffIdIsNull() {
            addCriterion("CREATE_STAFF_ID is null");
            return (Criteria) this;
        }

        public Criteria andCreateStaffIdIsNotNull() {
            addCriterion("CREATE_STAFF_ID is not null");
            return (Criteria) this;
        }

        public Criteria andCreateStaffIdEqualTo(String value) {
            addCriterion("CREATE_STAFF_ID =", value, "createStaffId");
            return (Criteria) this;
        }

        public Criteria andCreateStaffIdNotEqualTo(String value) {
            addCriterion("CREATE_STAFF_ID <>", value, "createStaffId");
            return (Criteria) this;
        }

        public Criteria andCreateStaffIdGreaterThan(String value) {
            addCriterion("CREATE_STAFF_ID >", value, "createStaffId");
            return (Criteria) this;
        }

        public Criteria andCreateStaffIdGreaterThanOrEqualTo(String value) {
            addCriterion("CREATE_STAFF_ID >=", value, "createStaffId");
            return (Criteria) this;
        }

        public Criteria andCreateStaffIdLessThan(String value) {
            addCriterion("CREATE_STAFF_ID <", value, "createStaffId");
            return (Criteria) this;
        }

        public Criteria andCreateStaffIdLessThanOrEqualTo(String value) {
            addCriterion("CREATE_STAFF_ID <=", value, "createStaffId");
            return (Criteria) this;
        }

        public Criteria andCreateStaffIdLike(String value) {
            addCriterion("CREATE_STAFF_ID like", value, "createStaffId");
            return (Criteria) this;
        }

        public Criteria andCreateStaffIdNotLike(String value) {
            addCriterion("CREATE_STAFF_ID not like", value, "createStaffId");
            return (Criteria) this;
        }

        public Criteria andCreateStaffIdIn(List<String> values) {
            addCriterion("CREATE_STAFF_ID in", values, "createStaffId");
            return (Criteria) this;
        }

        public Criteria andCreateStaffIdNotIn(List<String> values) {
            addCriterion("CREATE_STAFF_ID not in", values, "createStaffId");
            return (Criteria) this;
        }

        public Criteria andCreateStaffIdBetween(String value1, String value2) {
            addCriterion("CREATE_STAFF_ID between", value1, value2, "createStaffId");
            return (Criteria) this;
        }

        public Criteria andCreateStaffIdNotBetween(String value1, String value2) {
            addCriterion("CREATE_STAFF_ID not between", value1, value2, "createStaffId");
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
package com.x.ic.msg.dao.mapper.bo;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class StlPolicyBillPlanCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public StlPolicyBillPlanCriteria() {
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

        public Criteria andBillPlanIdIsNull() {
            addCriterion("BILL_PLAN_ID is null");
            return (Criteria) this;
        }

        public Criteria andBillPlanIdIsNotNull() {
            addCriterion("BILL_PLAN_ID is not null");
            return (Criteria) this;
        }

        public Criteria andBillPlanIdEqualTo(Long value) {
            addCriterion("BILL_PLAN_ID =", value, "billPlanId");
            return (Criteria) this;
        }

        public Criteria andBillPlanIdNotEqualTo(Long value) {
            addCriterion("BILL_PLAN_ID <>", value, "billPlanId");
            return (Criteria) this;
        }

        public Criteria andBillPlanIdGreaterThan(Long value) {
            addCriterion("BILL_PLAN_ID >", value, "billPlanId");
            return (Criteria) this;
        }

        public Criteria andBillPlanIdGreaterThanOrEqualTo(Long value) {
            addCriterion("BILL_PLAN_ID >=", value, "billPlanId");
            return (Criteria) this;
        }

        public Criteria andBillPlanIdLessThan(Long value) {
            addCriterion("BILL_PLAN_ID <", value, "billPlanId");
            return (Criteria) this;
        }

        public Criteria andBillPlanIdLessThanOrEqualTo(Long value) {
            addCriterion("BILL_PLAN_ID <=", value, "billPlanId");
            return (Criteria) this;
        }

        public Criteria andBillPlanIdIn(List<Long> values) {
            addCriterion("BILL_PLAN_ID in", values, "billPlanId");
            return (Criteria) this;
        }

        public Criteria andBillPlanIdNotIn(List<Long> values) {
            addCriterion("BILL_PLAN_ID not in", values, "billPlanId");
            return (Criteria) this;
        }

        public Criteria andBillPlanIdBetween(Long value1, Long value2) {
            addCriterion("BILL_PLAN_ID between", value1, value2, "billPlanId");
            return (Criteria) this;
        }

        public Criteria andBillPlanIdNotBetween(Long value1, Long value2) {
            addCriterion("BILL_PLAN_ID not between", value1, value2, "billPlanId");
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

        public Criteria andPlanNameIsNull() {
            addCriterion("PLAN_NAME is null");
            return (Criteria) this;
        }

        public Criteria andPlanNameIsNotNull() {
            addCriterion("PLAN_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andPlanNameEqualTo(String value) {
            addCriterion("PLAN_NAME =", value, "planName");
            return (Criteria) this;
        }

        public Criteria andPlanNameNotEqualTo(String value) {
            addCriterion("PLAN_NAME <>", value, "planName");
            return (Criteria) this;
        }

        public Criteria andPlanNameGreaterThan(String value) {
            addCriterion("PLAN_NAME >", value, "planName");
            return (Criteria) this;
        }

        public Criteria andPlanNameGreaterThanOrEqualTo(String value) {
            addCriterion("PLAN_NAME >=", value, "planName");
            return (Criteria) this;
        }

        public Criteria andPlanNameLessThan(String value) {
            addCriterion("PLAN_NAME <", value, "planName");
            return (Criteria) this;
        }

        public Criteria andPlanNameLessThanOrEqualTo(String value) {
            addCriterion("PLAN_NAME <=", value, "planName");
            return (Criteria) this;
        }

        public Criteria andPlanNameLike(String value) {
            addCriterion("PLAN_NAME like", value, "planName");
            return (Criteria) this;
        }

        public Criteria andPlanNameNotLike(String value) {
            addCriterion("PLAN_NAME not like", value, "planName");
            return (Criteria) this;
        }

        public Criteria andPlanNameIn(List<String> values) {
            addCriterion("PLAN_NAME in", values, "planName");
            return (Criteria) this;
        }

        public Criteria andPlanNameNotIn(List<String> values) {
            addCriterion("PLAN_NAME not in", values, "planName");
            return (Criteria) this;
        }

        public Criteria andPlanNameBetween(String value1, String value2) {
            addCriterion("PLAN_NAME between", value1, value2, "planName");
            return (Criteria) this;
        }

        public Criteria andPlanNameNotBetween(String value1, String value2) {
            addCriterion("PLAN_NAME not between", value1, value2, "planName");
            return (Criteria) this;
        }

        public Criteria andPlanDescribeIsNull() {
            addCriterion("PLAN_DESCRIBE is null");
            return (Criteria) this;
        }

        public Criteria andPlanDescribeIsNotNull() {
            addCriterion("PLAN_DESCRIBE is not null");
            return (Criteria) this;
        }

        public Criteria andPlanDescribeEqualTo(String value) {
            addCriterion("PLAN_DESCRIBE =", value, "planDescribe");
            return (Criteria) this;
        }

        public Criteria andPlanDescribeNotEqualTo(String value) {
            addCriterion("PLAN_DESCRIBE <>", value, "planDescribe");
            return (Criteria) this;
        }

        public Criteria andPlanDescribeGreaterThan(String value) {
            addCriterion("PLAN_DESCRIBE >", value, "planDescribe");
            return (Criteria) this;
        }

        public Criteria andPlanDescribeGreaterThanOrEqualTo(String value) {
            addCriterion("PLAN_DESCRIBE >=", value, "planDescribe");
            return (Criteria) this;
        }

        public Criteria andPlanDescribeLessThan(String value) {
            addCriterion("PLAN_DESCRIBE <", value, "planDescribe");
            return (Criteria) this;
        }

        public Criteria andPlanDescribeLessThanOrEqualTo(String value) {
            addCriterion("PLAN_DESCRIBE <=", value, "planDescribe");
            return (Criteria) this;
        }

        public Criteria andPlanDescribeLike(String value) {
            addCriterion("PLAN_DESCRIBE like", value, "planDescribe");
            return (Criteria) this;
        }

        public Criteria andPlanDescribeNotLike(String value) {
            addCriterion("PLAN_DESCRIBE not like", value, "planDescribe");
            return (Criteria) this;
        }

        public Criteria andPlanDescribeIn(List<String> values) {
            addCriterion("PLAN_DESCRIBE in", values, "planDescribe");
            return (Criteria) this;
        }

        public Criteria andPlanDescribeNotIn(List<String> values) {
            addCriterion("PLAN_DESCRIBE not in", values, "planDescribe");
            return (Criteria) this;
        }

        public Criteria andPlanDescribeBetween(String value1, String value2) {
            addCriterion("PLAN_DESCRIBE between", value1, value2, "planDescribe");
            return (Criteria) this;
        }

        public Criteria andPlanDescribeNotBetween(String value1, String value2) {
            addCriterion("PLAN_DESCRIBE not between", value1, value2, "planDescribe");
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

        public Criteria andCalElementTypeIsNull() {
            addCriterion("CAL_ELEMENT_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andCalElementTypeIsNotNull() {
            addCriterion("CAL_ELEMENT_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andCalElementTypeEqualTo(String value) {
            addCriterion("CAL_ELEMENT_TYPE =", value, "calElementType");
            return (Criteria) this;
        }

        public Criteria andCalElementTypeNotEqualTo(String value) {
            addCriterion("CAL_ELEMENT_TYPE <>", value, "calElementType");
            return (Criteria) this;
        }

        public Criteria andCalElementTypeGreaterThan(String value) {
            addCriterion("CAL_ELEMENT_TYPE >", value, "calElementType");
            return (Criteria) this;
        }

        public Criteria andCalElementTypeGreaterThanOrEqualTo(String value) {
            addCriterion("CAL_ELEMENT_TYPE >=", value, "calElementType");
            return (Criteria) this;
        }

        public Criteria andCalElementTypeLessThan(String value) {
            addCriterion("CAL_ELEMENT_TYPE <", value, "calElementType");
            return (Criteria) this;
        }

        public Criteria andCalElementTypeLessThanOrEqualTo(String value) {
            addCriterion("CAL_ELEMENT_TYPE <=", value, "calElementType");
            return (Criteria) this;
        }

        public Criteria andCalElementTypeLike(String value) {
            addCriterion("CAL_ELEMENT_TYPE like", value, "calElementType");
            return (Criteria) this;
        }

        public Criteria andCalElementTypeNotLike(String value) {
            addCriterion("CAL_ELEMENT_TYPE not like", value, "calElementType");
            return (Criteria) this;
        }

        public Criteria andCalElementTypeIn(List<String> values) {
            addCriterion("CAL_ELEMENT_TYPE in", values, "calElementType");
            return (Criteria) this;
        }

        public Criteria andCalElementTypeNotIn(List<String> values) {
            addCriterion("CAL_ELEMENT_TYPE not in", values, "calElementType");
            return (Criteria) this;
        }

        public Criteria andCalElementTypeBetween(String value1, String value2) {
            addCriterion("CAL_ELEMENT_TYPE between", value1, value2, "calElementType");
            return (Criteria) this;
        }

        public Criteria andCalElementTypeNotBetween(String value1, String value2) {
            addCriterion("CAL_ELEMENT_TYPE not between", value1, value2, "calElementType");
            return (Criteria) this;
        }

        public Criteria andCalPhaseIsNull() {
            addCriterion("CAL_PHASE is null");
            return (Criteria) this;
        }

        public Criteria andCalPhaseIsNotNull() {
            addCriterion("CAL_PHASE is not null");
            return (Criteria) this;
        }

        public Criteria andCalPhaseEqualTo(String value) {
            addCriterion("CAL_PHASE =", value, "calPhase");
            return (Criteria) this;
        }

        public Criteria andCalPhaseNotEqualTo(String value) {
            addCriterion("CAL_PHASE <>", value, "calPhase");
            return (Criteria) this;
        }

        public Criteria andCalPhaseGreaterThan(String value) {
            addCriterion("CAL_PHASE >", value, "calPhase");
            return (Criteria) this;
        }

        public Criteria andCalPhaseGreaterThanOrEqualTo(String value) {
            addCriterion("CAL_PHASE >=", value, "calPhase");
            return (Criteria) this;
        }

        public Criteria andCalPhaseLessThan(String value) {
            addCriterion("CAL_PHASE <", value, "calPhase");
            return (Criteria) this;
        }

        public Criteria andCalPhaseLessThanOrEqualTo(String value) {
            addCriterion("CAL_PHASE <=", value, "calPhase");
            return (Criteria) this;
        }

        public Criteria andCalPhaseLike(String value) {
            addCriterion("CAL_PHASE like", value, "calPhase");
            return (Criteria) this;
        }

        public Criteria andCalPhaseNotLike(String value) {
            addCriterion("CAL_PHASE not like", value, "calPhase");
            return (Criteria) this;
        }

        public Criteria andCalPhaseIn(List<String> values) {
            addCriterion("CAL_PHASE in", values, "calPhase");
            return (Criteria) this;
        }

        public Criteria andCalPhaseNotIn(List<String> values) {
            addCriterion("CAL_PHASE not in", values, "calPhase");
            return (Criteria) this;
        }

        public Criteria andCalPhaseBetween(String value1, String value2) {
            addCriterion("CAL_PHASE between", value1, value2, "calPhase");
            return (Criteria) this;
        }

        public Criteria andCalPhaseNotBetween(String value1, String value2) {
            addCriterion("CAL_PHASE not between", value1, value2, "calPhase");
            return (Criteria) this;
        }

        public Criteria andRuleValueIsNull() {
            addCriterion("RULE_VALUE is null");
            return (Criteria) this;
        }

        public Criteria andRuleValueIsNotNull() {
            addCriterion("RULE_VALUE is not null");
            return (Criteria) this;
        }

        public Criteria andRuleValueEqualTo(String value) {
            addCriterion("RULE_VALUE =", value, "ruleValue");
            return (Criteria) this;
        }

        public Criteria andRuleValueNotEqualTo(String value) {
            addCriterion("RULE_VALUE <>", value, "ruleValue");
            return (Criteria) this;
        }

        public Criteria andRuleValueGreaterThan(String value) {
            addCriterion("RULE_VALUE >", value, "ruleValue");
            return (Criteria) this;
        }

        public Criteria andRuleValueGreaterThanOrEqualTo(String value) {
            addCriterion("RULE_VALUE >=", value, "ruleValue");
            return (Criteria) this;
        }

        public Criteria andRuleValueLessThan(String value) {
            addCriterion("RULE_VALUE <", value, "ruleValue");
            return (Criteria) this;
        }

        public Criteria andRuleValueLessThanOrEqualTo(String value) {
            addCriterion("RULE_VALUE <=", value, "ruleValue");
            return (Criteria) this;
        }

        public Criteria andRuleValueLike(String value) {
            addCriterion("RULE_VALUE like", value, "ruleValue");
            return (Criteria) this;
        }

        public Criteria andRuleValueNotLike(String value) {
            addCriterion("RULE_VALUE not like", value, "ruleValue");
            return (Criteria) this;
        }

        public Criteria andRuleValueIn(List<String> values) {
            addCriterion("RULE_VALUE in", values, "ruleValue");
            return (Criteria) this;
        }

        public Criteria andRuleValueNotIn(List<String> values) {
            addCriterion("RULE_VALUE not in", values, "ruleValue");
            return (Criteria) this;
        }

        public Criteria andRuleValueBetween(String value1, String value2) {
            addCriterion("RULE_VALUE between", value1, value2, "ruleValue");
            return (Criteria) this;
        }

        public Criteria andRuleValueNotBetween(String value1, String value2) {
            addCriterion("RULE_VALUE not between", value1, value2, "ruleValue");
            return (Criteria) this;
        }

        public Criteria andSortIndexIsNull() {
            addCriterion("SORT_INDEX is null");
            return (Criteria) this;
        }

        public Criteria andSortIndexIsNotNull() {
            addCriterion("SORT_INDEX is not null");
            return (Criteria) this;
        }

        public Criteria andSortIndexEqualTo(Long value) {
            addCriterion("SORT_INDEX =", value, "sortIndex");
            return (Criteria) this;
        }

        public Criteria andSortIndexNotEqualTo(Long value) {
            addCriterion("SORT_INDEX <>", value, "sortIndex");
            return (Criteria) this;
        }

        public Criteria andSortIndexGreaterThan(Long value) {
            addCriterion("SORT_INDEX >", value, "sortIndex");
            return (Criteria) this;
        }

        public Criteria andSortIndexGreaterThanOrEqualTo(Long value) {
            addCriterion("SORT_INDEX >=", value, "sortIndex");
            return (Criteria) this;
        }

        public Criteria andSortIndexLessThan(Long value) {
            addCriterion("SORT_INDEX <", value, "sortIndex");
            return (Criteria) this;
        }

        public Criteria andSortIndexLessThanOrEqualTo(Long value) {
            addCriterion("SORT_INDEX <=", value, "sortIndex");
            return (Criteria) this;
        }

        public Criteria andSortIndexIn(List<Long> values) {
            addCriterion("SORT_INDEX in", values, "sortIndex");
            return (Criteria) this;
        }

        public Criteria andSortIndexNotIn(List<Long> values) {
            addCriterion("SORT_INDEX not in", values, "sortIndex");
            return (Criteria) this;
        }

        public Criteria andSortIndexBetween(Long value1, Long value2) {
            addCriterion("SORT_INDEX between", value1, value2, "sortIndex");
            return (Criteria) this;
        }

        public Criteria andSortIndexNotBetween(Long value1, Long value2) {
            addCriterion("SORT_INDEX not between", value1, value2, "sortIndex");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("REMARK is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("REMARK is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("REMARK =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("REMARK <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("REMARK >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("REMARK >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("REMARK <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("REMARK <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("REMARK like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("REMARK not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("REMARK in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("REMARK not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("REMARK between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("REMARK not between", value1, value2, "remark");
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
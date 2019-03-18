package com.x.ic.smc.dao.mapper.bo;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class StlPolicyItemPlanCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public StlPolicyItemPlanCriteria() {
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

        public Criteria andPlanIdIsNull() {
            addCriterion("PLAN_ID is null");
            return (Criteria) this;
        }

        public Criteria andPlanIdIsNotNull() {
            addCriterion("PLAN_ID is not null");
            return (Criteria) this;
        }

        public Criteria andPlanIdEqualTo(Long value) {
            addCriterion("PLAN_ID =", value, "planId");
            return (Criteria) this;
        }

        public Criteria andPlanIdNotEqualTo(Long value) {
            addCriterion("PLAN_ID <>", value, "planId");
            return (Criteria) this;
        }

        public Criteria andPlanIdGreaterThan(Long value) {
            addCriterion("PLAN_ID >", value, "planId");
            return (Criteria) this;
        }

        public Criteria andPlanIdGreaterThanOrEqualTo(Long value) {
            addCriterion("PLAN_ID >=", value, "planId");
            return (Criteria) this;
        }

        public Criteria andPlanIdLessThan(Long value) {
            addCriterion("PLAN_ID <", value, "planId");
            return (Criteria) this;
        }

        public Criteria andPlanIdLessThanOrEqualTo(Long value) {
            addCriterion("PLAN_ID <=", value, "planId");
            return (Criteria) this;
        }

        public Criteria andPlanIdIn(List<Long> values) {
            addCriterion("PLAN_ID in", values, "planId");
            return (Criteria) this;
        }

        public Criteria andPlanIdNotIn(List<Long> values) {
            addCriterion("PLAN_ID not in", values, "planId");
            return (Criteria) this;
        }

        public Criteria andPlanIdBetween(Long value1, Long value2) {
            addCriterion("PLAN_ID between", value1, value2, "planId");
            return (Criteria) this;
        }

        public Criteria andPlanIdNotBetween(Long value1, Long value2) {
            addCriterion("PLAN_ID not between", value1, value2, "planId");
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

        public Criteria andItemIdIsNull() {
            addCriterion("ITEM_ID is null");
            return (Criteria) this;
        }

        public Criteria andItemIdIsNotNull() {
            addCriterion("ITEM_ID is not null");
            return (Criteria) this;
        }

        public Criteria andItemIdEqualTo(Long value) {
            addCriterion("ITEM_ID =", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdNotEqualTo(Long value) {
            addCriterion("ITEM_ID <>", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdGreaterThan(Long value) {
            addCriterion("ITEM_ID >", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdGreaterThanOrEqualTo(Long value) {
            addCriterion("ITEM_ID >=", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdLessThan(Long value) {
            addCriterion("ITEM_ID <", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdLessThanOrEqualTo(Long value) {
            addCriterion("ITEM_ID <=", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdIn(List<Long> values) {
            addCriterion("ITEM_ID in", values, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdNotIn(List<Long> values) {
            addCriterion("ITEM_ID not in", values, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdBetween(Long value1, Long value2) {
            addCriterion("ITEM_ID between", value1, value2, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdNotBetween(Long value1, Long value2) {
            addCriterion("ITEM_ID not between", value1, value2, "itemId");
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

        public Criteria andElementIdIsNull() {
            addCriterion("ELEMENT_ID is null");
            return (Criteria) this;
        }

        public Criteria andElementIdIsNotNull() {
            addCriterion("ELEMENT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andElementIdEqualTo(Long value) {
            addCriterion("ELEMENT_ID =", value, "elementId");
            return (Criteria) this;
        }

        public Criteria andElementIdNotEqualTo(Long value) {
            addCriterion("ELEMENT_ID <>", value, "elementId");
            return (Criteria) this;
        }

        public Criteria andElementIdGreaterThan(Long value) {
            addCriterion("ELEMENT_ID >", value, "elementId");
            return (Criteria) this;
        }

        public Criteria andElementIdGreaterThanOrEqualTo(Long value) {
            addCriterion("ELEMENT_ID >=", value, "elementId");
            return (Criteria) this;
        }

        public Criteria andElementIdLessThan(Long value) {
            addCriterion("ELEMENT_ID <", value, "elementId");
            return (Criteria) this;
        }

        public Criteria andElementIdLessThanOrEqualTo(Long value) {
            addCriterion("ELEMENT_ID <=", value, "elementId");
            return (Criteria) this;
        }

        public Criteria andElementIdIn(List<Long> values) {
            addCriterion("ELEMENT_ID in", values, "elementId");
            return (Criteria) this;
        }

        public Criteria andElementIdNotIn(List<Long> values) {
            addCriterion("ELEMENT_ID not in", values, "elementId");
            return (Criteria) this;
        }

        public Criteria andElementIdBetween(Long value1, Long value2) {
            addCriterion("ELEMENT_ID between", value1, value2, "elementId");
            return (Criteria) this;
        }

        public Criteria andElementIdNotBetween(Long value1, Long value2) {
            addCriterion("ELEMENT_ID not between", value1, value2, "elementId");
            return (Criteria) this;
        }

        public Criteria andFeeItemIsNull() {
            addCriterion("FEE_ITEM is null");
            return (Criteria) this;
        }

        public Criteria andFeeItemIsNotNull() {
            addCriterion("FEE_ITEM is not null");
            return (Criteria) this;
        }

        public Criteria andFeeItemEqualTo(String value) {
            addCriterion("FEE_ITEM =", value, "feeItem");
            return (Criteria) this;
        }

        public Criteria andFeeItemNotEqualTo(String value) {
            addCriterion("FEE_ITEM <>", value, "feeItem");
            return (Criteria) this;
        }

        public Criteria andFeeItemGreaterThan(String value) {
            addCriterion("FEE_ITEM >", value, "feeItem");
            return (Criteria) this;
        }

        public Criteria andFeeItemGreaterThanOrEqualTo(String value) {
            addCriterion("FEE_ITEM >=", value, "feeItem");
            return (Criteria) this;
        }

        public Criteria andFeeItemLessThan(String value) {
            addCriterion("FEE_ITEM <", value, "feeItem");
            return (Criteria) this;
        }

        public Criteria andFeeItemLessThanOrEqualTo(String value) {
            addCriterion("FEE_ITEM <=", value, "feeItem");
            return (Criteria) this;
        }

        public Criteria andFeeItemLike(String value) {
            addCriterion("FEE_ITEM like", value, "feeItem");
            return (Criteria) this;
        }

        public Criteria andFeeItemNotLike(String value) {
            addCriterion("FEE_ITEM not like", value, "feeItem");
            return (Criteria) this;
        }

        public Criteria andFeeItemIn(List<String> values) {
            addCriterion("FEE_ITEM in", values, "feeItem");
            return (Criteria) this;
        }

        public Criteria andFeeItemNotIn(List<String> values) {
            addCriterion("FEE_ITEM not in", values, "feeItem");
            return (Criteria) this;
        }

        public Criteria andFeeItemBetween(String value1, String value2) {
            addCriterion("FEE_ITEM between", value1, value2, "feeItem");
            return (Criteria) this;
        }

        public Criteria andFeeItemNotBetween(String value1, String value2) {
            addCriterion("FEE_ITEM not between", value1, value2, "feeItem");
            return (Criteria) this;
        }

        public Criteria andPlanTypeIsNull() {
            addCriterion("PLAN_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andPlanTypeIsNotNull() {
            addCriterion("PLAN_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andPlanTypeEqualTo(String value) {
            addCriterion("PLAN_TYPE =", value, "planType");
            return (Criteria) this;
        }

        public Criteria andPlanTypeNotEqualTo(String value) {
            addCriterion("PLAN_TYPE <>", value, "planType");
            return (Criteria) this;
        }

        public Criteria andPlanTypeGreaterThan(String value) {
            addCriterion("PLAN_TYPE >", value, "planType");
            return (Criteria) this;
        }

        public Criteria andPlanTypeGreaterThanOrEqualTo(String value) {
            addCriterion("PLAN_TYPE >=", value, "planType");
            return (Criteria) this;
        }

        public Criteria andPlanTypeLessThan(String value) {
            addCriterion("PLAN_TYPE <", value, "planType");
            return (Criteria) this;
        }

        public Criteria andPlanTypeLessThanOrEqualTo(String value) {
            addCriterion("PLAN_TYPE <=", value, "planType");
            return (Criteria) this;
        }

        public Criteria andPlanTypeLike(String value) {
            addCriterion("PLAN_TYPE like", value, "planType");
            return (Criteria) this;
        }

        public Criteria andPlanTypeNotLike(String value) {
            addCriterion("PLAN_TYPE not like", value, "planType");
            return (Criteria) this;
        }

        public Criteria andPlanTypeIn(List<String> values) {
            addCriterion("PLAN_TYPE in", values, "planType");
            return (Criteria) this;
        }

        public Criteria andPlanTypeNotIn(List<String> values) {
            addCriterion("PLAN_TYPE not in", values, "planType");
            return (Criteria) this;
        }

        public Criteria andPlanTypeBetween(String value1, String value2) {
            addCriterion("PLAN_TYPE between", value1, value2, "planType");
            return (Criteria) this;
        }

        public Criteria andPlanTypeNotBetween(String value1, String value2) {
            addCriterion("PLAN_TYPE not between", value1, value2, "planType");
            return (Criteria) this;
        }

        public Criteria andCalTypeIsNull() {
            addCriterion("CAL_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andCalTypeIsNotNull() {
            addCriterion("CAL_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andCalTypeEqualTo(String value) {
            addCriterion("CAL_TYPE =", value, "calType");
            return (Criteria) this;
        }

        public Criteria andCalTypeNotEqualTo(String value) {
            addCriterion("CAL_TYPE <>", value, "calType");
            return (Criteria) this;
        }

        public Criteria andCalTypeGreaterThan(String value) {
            addCriterion("CAL_TYPE >", value, "calType");
            return (Criteria) this;
        }

        public Criteria andCalTypeGreaterThanOrEqualTo(String value) {
            addCriterion("CAL_TYPE >=", value, "calType");
            return (Criteria) this;
        }

        public Criteria andCalTypeLessThan(String value) {
            addCriterion("CAL_TYPE <", value, "calType");
            return (Criteria) this;
        }

        public Criteria andCalTypeLessThanOrEqualTo(String value) {
            addCriterion("CAL_TYPE <=", value, "calType");
            return (Criteria) this;
        }

        public Criteria andCalTypeLike(String value) {
            addCriterion("CAL_TYPE like", value, "calType");
            return (Criteria) this;
        }

        public Criteria andCalTypeNotLike(String value) {
            addCriterion("CAL_TYPE not like", value, "calType");
            return (Criteria) this;
        }

        public Criteria andCalTypeIn(List<String> values) {
            addCriterion("CAL_TYPE in", values, "calType");
            return (Criteria) this;
        }

        public Criteria andCalTypeNotIn(List<String> values) {
            addCriterion("CAL_TYPE not in", values, "calType");
            return (Criteria) this;
        }

        public Criteria andCalTypeBetween(String value1, String value2) {
            addCriterion("CAL_TYPE between", value1, value2, "calType");
            return (Criteria) this;
        }

        public Criteria andCalTypeNotBetween(String value1, String value2) {
            addCriterion("CAL_TYPE not between", value1, value2, "calType");
            return (Criteria) this;
        }

        public Criteria andCalValueIsNull() {
            addCriterion("CAL_VALUE is null");
            return (Criteria) this;
        }

        public Criteria andCalValueIsNotNull() {
            addCriterion("CAL_VALUE is not null");
            return (Criteria) this;
        }

        public Criteria andCalValueEqualTo(String value) {
            addCriterion("CAL_VALUE =", value, "calValue");
            return (Criteria) this;
        }

        public Criteria andCalValueNotEqualTo(String value) {
            addCriterion("CAL_VALUE <>", value, "calValue");
            return (Criteria) this;
        }

        public Criteria andCalValueGreaterThan(String value) {
            addCriterion("CAL_VALUE >", value, "calValue");
            return (Criteria) this;
        }

        public Criteria andCalValueGreaterThanOrEqualTo(String value) {
            addCriterion("CAL_VALUE >=", value, "calValue");
            return (Criteria) this;
        }

        public Criteria andCalValueLessThan(String value) {
            addCriterion("CAL_VALUE <", value, "calValue");
            return (Criteria) this;
        }

        public Criteria andCalValueLessThanOrEqualTo(String value) {
            addCriterion("CAL_VALUE <=", value, "calValue");
            return (Criteria) this;
        }

        public Criteria andCalValueLike(String value) {
            addCriterion("CAL_VALUE like", value, "calValue");
            return (Criteria) this;
        }

        public Criteria andCalValueNotLike(String value) {
            addCriterion("CAL_VALUE not like", value, "calValue");
            return (Criteria) this;
        }

        public Criteria andCalValueIn(List<String> values) {
            addCriterion("CAL_VALUE in", values, "calValue");
            return (Criteria) this;
        }

        public Criteria andCalValueNotIn(List<String> values) {
            addCriterion("CAL_VALUE not in", values, "calValue");
            return (Criteria) this;
        }

        public Criteria andCalValueBetween(String value1, String value2) {
            addCriterion("CAL_VALUE between", value1, value2, "calValue");
            return (Criteria) this;
        }

        public Criteria andCalValueNotBetween(String value1, String value2) {
            addCriterion("CAL_VALUE not between", value1, value2, "calValue");
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
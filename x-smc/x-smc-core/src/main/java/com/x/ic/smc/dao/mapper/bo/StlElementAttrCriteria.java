package com.x.ic.smc.dao.mapper.bo;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class StlElementAttrCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public StlElementAttrCriteria() {
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

        public Criteria andAttrIdIsNull() {
            addCriterion("ATTR_ID is null");
            return (Criteria) this;
        }

        public Criteria andAttrIdIsNotNull() {
            addCriterion("ATTR_ID is not null");
            return (Criteria) this;
        }

        public Criteria andAttrIdEqualTo(Long value) {
            addCriterion("ATTR_ID =", value, "attrId");
            return (Criteria) this;
        }

        public Criteria andAttrIdNotEqualTo(Long value) {
            addCriterion("ATTR_ID <>", value, "attrId");
            return (Criteria) this;
        }

        public Criteria andAttrIdGreaterThan(Long value) {
            addCriterion("ATTR_ID >", value, "attrId");
            return (Criteria) this;
        }

        public Criteria andAttrIdGreaterThanOrEqualTo(Long value) {
            addCriterion("ATTR_ID >=", value, "attrId");
            return (Criteria) this;
        }

        public Criteria andAttrIdLessThan(Long value) {
            addCriterion("ATTR_ID <", value, "attrId");
            return (Criteria) this;
        }

        public Criteria andAttrIdLessThanOrEqualTo(Long value) {
            addCriterion("ATTR_ID <=", value, "attrId");
            return (Criteria) this;
        }

        public Criteria andAttrIdIn(List<Long> values) {
            addCriterion("ATTR_ID in", values, "attrId");
            return (Criteria) this;
        }

        public Criteria andAttrIdNotIn(List<Long> values) {
            addCriterion("ATTR_ID not in", values, "attrId");
            return (Criteria) this;
        }

        public Criteria andAttrIdBetween(Long value1, Long value2) {
            addCriterion("ATTR_ID between", value1, value2, "attrId");
            return (Criteria) this;
        }

        public Criteria andAttrIdNotBetween(Long value1, Long value2) {
            addCriterion("ATTR_ID not between", value1, value2, "attrId");
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

        public Criteria andSubObjectIdIsNull() {
            addCriterion("sub_object_id is null");
            return (Criteria) this;
        }

        public Criteria andSubObjectIdIsNotNull() {
            addCriterion("sub_object_id is not null");
            return (Criteria) this;
        }

        public Criteria andSubObjectIdEqualTo(String value) {
            addCriterion("sub_object_id =", value, "subObjectId");
            return (Criteria) this;
        }

        public Criteria andSubObjectIdNotEqualTo(String value) {
            addCriterion("sub_object_id <>", value, "subObjectId");
            return (Criteria) this;
        }

        public Criteria andSubObjectIdGreaterThan(String value) {
            addCriterion("sub_object_id >", value, "subObjectId");
            return (Criteria) this;
        }

        public Criteria andSubObjectIdGreaterThanOrEqualTo(String value) {
            addCriterion("sub_object_id >=", value, "subObjectId");
            return (Criteria) this;
        }

        public Criteria andSubObjectIdLessThan(String value) {
            addCriterion("sub_object_id <", value, "subObjectId");
            return (Criteria) this;
        }

        public Criteria andSubObjectIdLessThanOrEqualTo(String value) {
            addCriterion("sub_object_id <=", value, "subObjectId");
            return (Criteria) this;
        }

        public Criteria andSubObjectIdLike(String value) {
            addCriterion("sub_object_id like", value, "subObjectId");
            return (Criteria) this;
        }

        public Criteria andSubObjectIdNotLike(String value) {
            addCriterion("sub_object_id not like", value, "subObjectId");
            return (Criteria) this;
        }

        public Criteria andSubObjectIdIn(List<String> values) {
            addCriterion("sub_object_id in", values, "subObjectId");
            return (Criteria) this;
        }

        public Criteria andSubObjectIdNotIn(List<String> values) {
            addCriterion("sub_object_id not in", values, "subObjectId");
            return (Criteria) this;
        }

        public Criteria andSubObjectIdBetween(String value1, String value2) {
            addCriterion("sub_object_id between", value1, value2, "subObjectId");
            return (Criteria) this;
        }

        public Criteria andSubObjectIdNotBetween(String value1, String value2) {
            addCriterion("sub_object_id not between", value1, value2, "subObjectId");
            return (Criteria) this;
        }

        public Criteria andSubElementIdIsNull() {
            addCriterion("SUB_ELEMENT_ID is null");
            return (Criteria) this;
        }

        public Criteria andSubElementIdIsNotNull() {
            addCriterion("SUB_ELEMENT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andSubElementIdEqualTo(Long value) {
            addCriterion("SUB_ELEMENT_ID =", value, "subElementId");
            return (Criteria) this;
        }

        public Criteria andSubElementIdNotEqualTo(Long value) {
            addCriterion("SUB_ELEMENT_ID <>", value, "subElementId");
            return (Criteria) this;
        }

        public Criteria andSubElementIdGreaterThan(Long value) {
            addCriterion("SUB_ELEMENT_ID >", value, "subElementId");
            return (Criteria) this;
        }

        public Criteria andSubElementIdGreaterThanOrEqualTo(Long value) {
            addCriterion("SUB_ELEMENT_ID >=", value, "subElementId");
            return (Criteria) this;
        }

        public Criteria andSubElementIdLessThan(Long value) {
            addCriterion("SUB_ELEMENT_ID <", value, "subElementId");
            return (Criteria) this;
        }

        public Criteria andSubElementIdLessThanOrEqualTo(Long value) {
            addCriterion("SUB_ELEMENT_ID <=", value, "subElementId");
            return (Criteria) this;
        }

        public Criteria andSubElementIdIn(List<Long> values) {
            addCriterion("SUB_ELEMENT_ID in", values, "subElementId");
            return (Criteria) this;
        }

        public Criteria andSubElementIdNotIn(List<Long> values) {
            addCriterion("SUB_ELEMENT_ID not in", values, "subElementId");
            return (Criteria) this;
        }

        public Criteria andSubElementIdBetween(Long value1, Long value2) {
            addCriterion("SUB_ELEMENT_ID between", value1, value2, "subElementId");
            return (Criteria) this;
        }

        public Criteria andSubElementIdNotBetween(Long value1, Long value2) {
            addCriterion("SUB_ELEMENT_ID not between", value1, value2, "subElementId");
            return (Criteria) this;
        }

        public Criteria andRelTypeIsNull() {
            addCriterion("REL_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andRelTypeIsNotNull() {
            addCriterion("REL_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andRelTypeEqualTo(String value) {
            addCriterion("REL_TYPE =", value, "relType");
            return (Criteria) this;
        }

        public Criteria andRelTypeNotEqualTo(String value) {
            addCriterion("REL_TYPE <>", value, "relType");
            return (Criteria) this;
        }

        public Criteria andRelTypeGreaterThan(String value) {
            addCriterion("REL_TYPE >", value, "relType");
            return (Criteria) this;
        }

        public Criteria andRelTypeGreaterThanOrEqualTo(String value) {
            addCriterion("REL_TYPE >=", value, "relType");
            return (Criteria) this;
        }

        public Criteria andRelTypeLessThan(String value) {
            addCriterion("REL_TYPE <", value, "relType");
            return (Criteria) this;
        }

        public Criteria andRelTypeLessThanOrEqualTo(String value) {
            addCriterion("REL_TYPE <=", value, "relType");
            return (Criteria) this;
        }

        public Criteria andRelTypeLike(String value) {
            addCriterion("REL_TYPE like", value, "relType");
            return (Criteria) this;
        }

        public Criteria andRelTypeNotLike(String value) {
            addCriterion("REL_TYPE not like", value, "relType");
            return (Criteria) this;
        }

        public Criteria andRelTypeIn(List<String> values) {
            addCriterion("REL_TYPE in", values, "relType");
            return (Criteria) this;
        }

        public Criteria andRelTypeNotIn(List<String> values) {
            addCriterion("REL_TYPE not in", values, "relType");
            return (Criteria) this;
        }

        public Criteria andRelTypeBetween(String value1, String value2) {
            addCriterion("REL_TYPE between", value1, value2, "relType");
            return (Criteria) this;
        }

        public Criteria andRelTypeNotBetween(String value1, String value2) {
            addCriterion("REL_TYPE not between", value1, value2, "relType");
            return (Criteria) this;
        }

        public Criteria andRelValueIsNull() {
            addCriterion("REL_VALUE is null");
            return (Criteria) this;
        }

        public Criteria andRelValueIsNotNull() {
            addCriterion("REL_VALUE is not null");
            return (Criteria) this;
        }

        public Criteria andRelValueEqualTo(String value) {
            addCriterion("REL_VALUE =", value, "relValue");
            return (Criteria) this;
        }

        public Criteria andRelValueNotEqualTo(String value) {
            addCriterion("REL_VALUE <>", value, "relValue");
            return (Criteria) this;
        }

        public Criteria andRelValueGreaterThan(String value) {
            addCriterion("REL_VALUE >", value, "relValue");
            return (Criteria) this;
        }

        public Criteria andRelValueGreaterThanOrEqualTo(String value) {
            addCriterion("REL_VALUE >=", value, "relValue");
            return (Criteria) this;
        }

        public Criteria andRelValueLessThan(String value) {
            addCriterion("REL_VALUE <", value, "relValue");
            return (Criteria) this;
        }

        public Criteria andRelValueLessThanOrEqualTo(String value) {
            addCriterion("REL_VALUE <=", value, "relValue");
            return (Criteria) this;
        }

        public Criteria andRelValueLike(String value) {
            addCriterion("REL_VALUE like", value, "relValue");
            return (Criteria) this;
        }

        public Criteria andRelValueNotLike(String value) {
            addCriterion("REL_VALUE not like", value, "relValue");
            return (Criteria) this;
        }

        public Criteria andRelValueIn(List<String> values) {
            addCriterion("REL_VALUE in", values, "relValue");
            return (Criteria) this;
        }

        public Criteria andRelValueNotIn(List<String> values) {
            addCriterion("REL_VALUE not in", values, "relValue");
            return (Criteria) this;
        }

        public Criteria andRelValueBetween(String value1, String value2) {
            addCriterion("REL_VALUE between", value1, value2, "relValue");
            return (Criteria) this;
        }

        public Criteria andRelValueNotBetween(String value1, String value2) {
            addCriterion("REL_VALUE not between", value1, value2, "relValue");
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
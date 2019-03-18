package com.x.ic.dshm.dto;

import java.util.ArrayList;
import java.util.List;

public class EbillingShmTableDbCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public EbillingShmTableDbCriteria() {
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

        public Criteria andDbConnectIsNull() {
            addCriterion("DB_CONNECT is null");
            return (Criteria) this;
        }

        public Criteria andDbConnectIsNotNull() {
            addCriterion("DB_CONNECT is not null");
            return (Criteria) this;
        }

        public Criteria andDbConnectEqualTo(String value) {
            addCriterion("DB_CONNECT =", value, "dbConnect");
            return (Criteria) this;
        }

        public Criteria andDbConnectNotEqualTo(String value) {
            addCriterion("DB_CONNECT <>", value, "dbConnect");
            return (Criteria) this;
        }

        public Criteria andDbConnectGreaterThan(String value) {
            addCriterion("DB_CONNECT >", value, "dbConnect");
            return (Criteria) this;
        }

        public Criteria andDbConnectGreaterThanOrEqualTo(String value) {
            addCriterion("DB_CONNECT >=", value, "dbConnect");
            return (Criteria) this;
        }

        public Criteria andDbConnectLessThan(String value) {
            addCriterion("DB_CONNECT <", value, "dbConnect");
            return (Criteria) this;
        }

        public Criteria andDbConnectLessThanOrEqualTo(String value) {
            addCriterion("DB_CONNECT <=", value, "dbConnect");
            return (Criteria) this;
        }

        public Criteria andDbConnectLike(String value) {
            addCriterion("DB_CONNECT like", value, "dbConnect");
            return (Criteria) this;
        }

        public Criteria andDbConnectNotLike(String value) {
            addCriterion("DB_CONNECT not like", value, "dbConnect");
            return (Criteria) this;
        }

        public Criteria andDbConnectIn(List<String> values) {
            addCriterion("DB_CONNECT in", values, "dbConnect");
            return (Criteria) this;
        }

        public Criteria andDbConnectNotIn(List<String> values) {
            addCriterion("DB_CONNECT not in", values, "dbConnect");
            return (Criteria) this;
        }

        public Criteria andDbConnectBetween(String value1, String value2) {
            addCriterion("DB_CONNECT between", value1, value2, "dbConnect");
            return (Criteria) this;
        }

        public Criteria andDbConnectNotBetween(String value1, String value2) {
            addCriterion("DB_CONNECT not between", value1, value2, "dbConnect");
            return (Criteria) this;
        }

        public Criteria andIdIsNull() {
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNull() {
            addCriterion("USER_NAME is null");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNotNull() {
            addCriterion("USER_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andUserNameEqualTo(String value) {
            addCriterion("USER_NAME =", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotEqualTo(String value) {
            addCriterion("USER_NAME <>", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThan(String value) {
            addCriterion("USER_NAME >", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("USER_NAME >=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThan(String value) {
            addCriterion("USER_NAME <", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThanOrEqualTo(String value) {
            addCriterion("USER_NAME <=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLike(String value) {
            addCriterion("USER_NAME like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotLike(String value) {
            addCriterion("USER_NAME not like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameIn(List<String> values) {
            addCriterion("USER_NAME in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotIn(List<String> values) {
            addCriterion("USER_NAME not in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameBetween(String value1, String value2) {
            addCriterion("USER_NAME between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotBetween(String value1, String value2) {
            addCriterion("USER_NAME not between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andPassWordIsNull() {
            addCriterion("PASS_WORD is null");
            return (Criteria) this;
        }

        public Criteria andPassWordIsNotNull() {
            addCriterion("PASS_WORD is not null");
            return (Criteria) this;
        }

        public Criteria andPassWordEqualTo(String value) {
            addCriterion("PASS_WORD =", value, "passWord");
            return (Criteria) this;
        }

        public Criteria andPassWordNotEqualTo(String value) {
            addCriterion("PASS_WORD <>", value, "passWord");
            return (Criteria) this;
        }

        public Criteria andPassWordGreaterThan(String value) {
            addCriterion("PASS_WORD >", value, "passWord");
            return (Criteria) this;
        }

        public Criteria andPassWordGreaterThanOrEqualTo(String value) {
            addCriterion("PASS_WORD >=", value, "passWord");
            return (Criteria) this;
        }

        public Criteria andPassWordLessThan(String value) {
            addCriterion("PASS_WORD <", value, "passWord");
            return (Criteria) this;
        }

        public Criteria andPassWordLessThanOrEqualTo(String value) {
            addCriterion("PASS_WORD <=", value, "passWord");
            return (Criteria) this;
        }

        public Criteria andPassWordLike(String value) {
            addCriterion("PASS_WORD like", value, "passWord");
            return (Criteria) this;
        }

        public Criteria andPassWordNotLike(String value) {
            addCriterion("PASS_WORD not like", value, "passWord");
            return (Criteria) this;
        }

        public Criteria andPassWordIn(List<String> values) {
            addCriterion("PASS_WORD in", values, "passWord");
            return (Criteria) this;
        }

        public Criteria andPassWordNotIn(List<String> values) {
            addCriterion("PASS_WORD not in", values, "passWord");
            return (Criteria) this;
        }

        public Criteria andPassWordBetween(String value1, String value2) {
            addCriterion("PASS_WORD between", value1, value2, "passWord");
            return (Criteria) this;
        }

        public Criteria andPassWordNotBetween(String value1, String value2) {
            addCriterion("PASS_WORD not between", value1, value2, "passWord");
            return (Criteria) this;
        }

        public Criteria andUrlIsNull() {
            addCriterion("URL is null");
            return (Criteria) this;
        }

        public Criteria andUrlIsNotNull() {
            addCriterion("URL is not null");
            return (Criteria) this;
        }

        public Criteria andUrlEqualTo(String value) {
            addCriterion("URL =", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotEqualTo(String value) {
            addCriterion("URL <>", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThan(String value) {
            addCriterion("URL >", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThanOrEqualTo(String value) {
            addCriterion("URL >=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThan(String value) {
            addCriterion("URL <", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThanOrEqualTo(String value) {
            addCriterion("URL <=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLike(String value) {
            addCriterion("URL like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotLike(String value) {
            addCriterion("URL not like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlIn(List<String> values) {
            addCriterion("URL in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotIn(List<String> values) {
            addCriterion("URL not in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlBetween(String value1, String value2) {
            addCriterion("URL between", value1, value2, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotBetween(String value1, String value2) {
            addCriterion("URL not between", value1, value2, "url");
            return (Criteria) this;
        }

        public Criteria andDriverClassNameIsNull() {
            addCriterion("DRIVER_CLASS_NAME is null");
            return (Criteria) this;
        }

        public Criteria andDriverClassNameIsNotNull() {
            addCriterion("DRIVER_CLASS_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andDriverClassNameEqualTo(String value) {
            addCriterion("DRIVER_CLASS_NAME =", value, "driverClassName");
            return (Criteria) this;
        }

        public Criteria andDriverClassNameNotEqualTo(String value) {
            addCriterion("DRIVER_CLASS_NAME <>", value, "driverClassName");
            return (Criteria) this;
        }

        public Criteria andDriverClassNameGreaterThan(String value) {
            addCriterion("DRIVER_CLASS_NAME >", value, "driverClassName");
            return (Criteria) this;
        }

        public Criteria andDriverClassNameGreaterThanOrEqualTo(String value) {
            addCriterion("DRIVER_CLASS_NAME >=", value, "driverClassName");
            return (Criteria) this;
        }

        public Criteria andDriverClassNameLessThan(String value) {
            addCriterion("DRIVER_CLASS_NAME <", value, "driverClassName");
            return (Criteria) this;
        }

        public Criteria andDriverClassNameLessThanOrEqualTo(String value) {
            addCriterion("DRIVER_CLASS_NAME <=", value, "driverClassName");
            return (Criteria) this;
        }

        public Criteria andDriverClassNameLike(String value) {
            addCriterion("DRIVER_CLASS_NAME like", value, "driverClassName");
            return (Criteria) this;
        }

        public Criteria andDriverClassNameNotLike(String value) {
            addCriterion("DRIVER_CLASS_NAME not like", value, "driverClassName");
            return (Criteria) this;
        }

        public Criteria andDriverClassNameIn(List<String> values) {
            addCriterion("DRIVER_CLASS_NAME in", values, "driverClassName");
            return (Criteria) this;
        }

        public Criteria andDriverClassNameNotIn(List<String> values) {
            addCriterion("DRIVER_CLASS_NAME not in", values, "driverClassName");
            return (Criteria) this;
        }

        public Criteria andDriverClassNameBetween(String value1, String value2) {
            addCriterion("DRIVER_CLASS_NAME between", value1, value2, "driverClassName");
            return (Criteria) this;
        }

        public Criteria andDriverClassNameNotBetween(String value1, String value2) {
            addCriterion("DRIVER_CLASS_NAME not between", value1, value2, "driverClassName");
            return (Criteria) this;
        }

        public Criteria andDbTypeIsNull() {
            addCriterion("DB_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andDbTypeIsNotNull() {
            addCriterion("DB_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andDbTypeEqualTo(String value) {
            addCriterion("DB_TYPE =", value, "dbType");
            return (Criteria) this;
        }

        public Criteria andDbTypeNotEqualTo(String value) {
            addCriterion("DB_TYPE <>", value, "dbType");
            return (Criteria) this;
        }

        public Criteria andDbTypeGreaterThan(String value) {
            addCriterion("DB_TYPE >", value, "dbType");
            return (Criteria) this;
        }

        public Criteria andDbTypeGreaterThanOrEqualTo(String value) {
            addCriterion("DB_TYPE >=", value, "dbType");
            return (Criteria) this;
        }

        public Criteria andDbTypeLessThan(String value) {
            addCriterion("DB_TYPE <", value, "dbType");
            return (Criteria) this;
        }

        public Criteria andDbTypeLessThanOrEqualTo(String value) {
            addCriterion("DB_TYPE <=", value, "dbType");
            return (Criteria) this;
        }

        public Criteria andDbTypeLike(String value) {
            addCriterion("DB_TYPE like", value, "dbType");
            return (Criteria) this;
        }

        public Criteria andDbTypeNotLike(String value) {
            addCriterion("DB_TYPE not like", value, "dbType");
            return (Criteria) this;
        }

        public Criteria andDbTypeIn(List<String> values) {
            addCriterion("DB_TYPE in", values, "dbType");
            return (Criteria) this;
        }

        public Criteria andDbTypeNotIn(List<String> values) {
            addCriterion("DB_TYPE not in", values, "dbType");
            return (Criteria) this;
        }

        public Criteria andDbTypeBetween(String value1, String value2) {
            addCriterion("DB_TYPE between", value1, value2, "dbType");
            return (Criteria) this;
        }

        public Criteria andDbTypeNotBetween(String value1, String value2) {
            addCriterion("DB_TYPE not between", value1, value2, "dbType");
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
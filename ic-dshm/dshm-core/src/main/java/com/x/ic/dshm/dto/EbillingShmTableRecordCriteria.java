package com.x.ic.dshm.dto;

import java.util.ArrayList;
import java.util.List;

public class EbillingShmTableRecordCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public EbillingShmTableRecordCriteria() {
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

        public Criteria andTableIdIsNull() {
            addCriterion("TABLE_ID is null");
            return (Criteria) this;
        }

        public Criteria andTableIdIsNotNull() {
            addCriterion("TABLE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andTableIdEqualTo(Integer value) {
            addCriterion("TABLE_ID =", value, "tableId");
            return (Criteria) this;
        }

        public Criteria andTableIdNotEqualTo(Integer value) {
            addCriterion("TABLE_ID <>", value, "tableId");
            return (Criteria) this;
        }

        public Criteria andTableIdGreaterThan(Integer value) {
            addCriterion("TABLE_ID >", value, "tableId");
            return (Criteria) this;
        }

        public Criteria andTableIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("TABLE_ID >=", value, "tableId");
            return (Criteria) this;
        }

        public Criteria andTableIdLessThan(Integer value) {
            addCriterion("TABLE_ID <", value, "tableId");
            return (Criteria) this;
        }

        public Criteria andTableIdLessThanOrEqualTo(Integer value) {
            addCriterion("TABLE_ID <=", value, "tableId");
            return (Criteria) this;
        }

        public Criteria andTableIdIn(List<Integer> values) {
            addCriterion("TABLE_ID in", values, "tableId");
            return (Criteria) this;
        }

        public Criteria andTableIdNotIn(List<Integer> values) {
            addCriterion("TABLE_ID not in", values, "tableId");
            return (Criteria) this;
        }

        public Criteria andTableIdBetween(Integer value1, Integer value2) {
            addCriterion("TABLE_ID between", value1, value2, "tableId");
            return (Criteria) this;
        }

        public Criteria andTableIdNotBetween(Integer value1, Integer value2) {
            addCriterion("TABLE_ID not between", value1, value2, "tableId");
            return (Criteria) this;
        }

        public Criteria andTableNameIsNull() {
            addCriterion("TABLE_NAME is null");
            return (Criteria) this;
        }

        public Criteria andTableNameIsNotNull() {
            addCriterion("TABLE_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andTableNameEqualTo(String value) {
            addCriterion("TABLE_NAME =", value, "tableName");
            return (Criteria) this;
        }

        public Criteria andTableNameNotEqualTo(String value) {
            addCriterion("TABLE_NAME <>", value, "tableName");
            return (Criteria) this;
        }

        public Criteria andTableNameGreaterThan(String value) {
            addCriterion("TABLE_NAME >", value, "tableName");
            return (Criteria) this;
        }

        public Criteria andTableNameGreaterThanOrEqualTo(String value) {
            addCriterion("TABLE_NAME >=", value, "tableName");
            return (Criteria) this;
        }

        public Criteria andTableNameLessThan(String value) {
            addCriterion("TABLE_NAME <", value, "tableName");
            return (Criteria) this;
        }

        public Criteria andTableNameLessThanOrEqualTo(String value) {
            addCriterion("TABLE_NAME <=", value, "tableName");
            return (Criteria) this;
        }

        public Criteria andTableNameLike(String value) {
            addCriterion("TABLE_NAME like", value, "tableName");
            return (Criteria) this;
        }

        public Criteria andTableNameNotLike(String value) {
            addCriterion("TABLE_NAME not like", value, "tableName");
            return (Criteria) this;
        }

        public Criteria andTableNameIn(List<String> values) {
            addCriterion("TABLE_NAME in", values, "tableName");
            return (Criteria) this;
        }

        public Criteria andTableNameNotIn(List<String> values) {
            addCriterion("TABLE_NAME not in", values, "tableName");
            return (Criteria) this;
        }

        public Criteria andTableNameBetween(String value1, String value2) {
            addCriterion("TABLE_NAME between", value1, value2, "tableName");
            return (Criteria) this;
        }

        public Criteria andTableNameNotBetween(String value1, String value2) {
            addCriterion("TABLE_NAME not between", value1, value2, "tableName");
            return (Criteria) this;
        }

        public Criteria andFieldSeqIsNull() {
            addCriterion("FIELD_SEQ is null");
            return (Criteria) this;
        }

        public Criteria andFieldSeqIsNotNull() {
            addCriterion("FIELD_SEQ is not null");
            return (Criteria) this;
        }

        public Criteria andFieldSeqEqualTo(Integer value) {
            addCriterion("FIELD_SEQ =", value, "fieldSeq");
            return (Criteria) this;
        }

        public Criteria andFieldSeqNotEqualTo(Integer value) {
            addCriterion("FIELD_SEQ <>", value, "fieldSeq");
            return (Criteria) this;
        }

        public Criteria andFieldSeqGreaterThan(Integer value) {
            addCriterion("FIELD_SEQ >", value, "fieldSeq");
            return (Criteria) this;
        }

        public Criteria andFieldSeqGreaterThanOrEqualTo(Integer value) {
            addCriterion("FIELD_SEQ >=", value, "fieldSeq");
            return (Criteria) this;
        }

        public Criteria andFieldSeqLessThan(Integer value) {
            addCriterion("FIELD_SEQ <", value, "fieldSeq");
            return (Criteria) this;
        }

        public Criteria andFieldSeqLessThanOrEqualTo(Integer value) {
            addCriterion("FIELD_SEQ <=", value, "fieldSeq");
            return (Criteria) this;
        }

        public Criteria andFieldSeqIn(List<Integer> values) {
            addCriterion("FIELD_SEQ in", values, "fieldSeq");
            return (Criteria) this;
        }

        public Criteria andFieldSeqNotIn(List<Integer> values) {
            addCriterion("FIELD_SEQ not in", values, "fieldSeq");
            return (Criteria) this;
        }

        public Criteria andFieldSeqBetween(Integer value1, Integer value2) {
            addCriterion("FIELD_SEQ between", value1, value2, "fieldSeq");
            return (Criteria) this;
        }

        public Criteria andFieldSeqNotBetween(Integer value1, Integer value2) {
            addCriterion("FIELD_SEQ not between", value1, value2, "fieldSeq");
            return (Criteria) this;
        }

        public Criteria andFieldNameIsNull() {
            addCriterion("FIELD_NAME is null");
            return (Criteria) this;
        }

        public Criteria andFieldNameIsNotNull() {
            addCriterion("FIELD_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andFieldNameEqualTo(String value) {
            addCriterion("FIELD_NAME =", value, "fieldName");
            return (Criteria) this;
        }

        public Criteria andFieldNameNotEqualTo(String value) {
            addCriterion("FIELD_NAME <>", value, "fieldName");
            return (Criteria) this;
        }

        public Criteria andFieldNameGreaterThan(String value) {
            addCriterion("FIELD_NAME >", value, "fieldName");
            return (Criteria) this;
        }

        public Criteria andFieldNameGreaterThanOrEqualTo(String value) {
            addCriterion("FIELD_NAME >=", value, "fieldName");
            return (Criteria) this;
        }

        public Criteria andFieldNameLessThan(String value) {
            addCriterion("FIELD_NAME <", value, "fieldName");
            return (Criteria) this;
        }

        public Criteria andFieldNameLessThanOrEqualTo(String value) {
            addCriterion("FIELD_NAME <=", value, "fieldName");
            return (Criteria) this;
        }

        public Criteria andFieldNameLike(String value) {
            addCriterion("FIELD_NAME like", value, "fieldName");
            return (Criteria) this;
        }

        public Criteria andFieldNameNotLike(String value) {
            addCriterion("FIELD_NAME not like", value, "fieldName");
            return (Criteria) this;
        }

        public Criteria andFieldNameIn(List<String> values) {
            addCriterion("FIELD_NAME in", values, "fieldName");
            return (Criteria) this;
        }

        public Criteria andFieldNameNotIn(List<String> values) {
            addCriterion("FIELD_NAME not in", values, "fieldName");
            return (Criteria) this;
        }

        public Criteria andFieldNameBetween(String value1, String value2) {
            addCriterion("FIELD_NAME between", value1, value2, "fieldName");
            return (Criteria) this;
        }

        public Criteria andFieldNameNotBetween(String value1, String value2) {
            addCriterion("FIELD_NAME not between", value1, value2, "fieldName");
            return (Criteria) this;
        }

        public Criteria andFieldTypeIsNull() {
            addCriterion("FIELD_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andFieldTypeIsNotNull() {
            addCriterion("FIELD_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andFieldTypeEqualTo(Integer value) {
            addCriterion("FIELD_TYPE =", value, "fieldType");
            return (Criteria) this;
        }

        public Criteria andFieldTypeNotEqualTo(Integer value) {
            addCriterion("FIELD_TYPE <>", value, "fieldType");
            return (Criteria) this;
        }

        public Criteria andFieldTypeGreaterThan(Integer value) {
            addCriterion("FIELD_TYPE >", value, "fieldType");
            return (Criteria) this;
        }

        public Criteria andFieldTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("FIELD_TYPE >=", value, "fieldType");
            return (Criteria) this;
        }

        public Criteria andFieldTypeLessThan(Integer value) {
            addCriterion("FIELD_TYPE <", value, "fieldType");
            return (Criteria) this;
        }

        public Criteria andFieldTypeLessThanOrEqualTo(Integer value) {
            addCriterion("FIELD_TYPE <=", value, "fieldType");
            return (Criteria) this;
        }

        public Criteria andFieldTypeIn(List<Integer> values) {
            addCriterion("FIELD_TYPE in", values, "fieldType");
            return (Criteria) this;
        }

        public Criteria andFieldTypeNotIn(List<Integer> values) {
            addCriterion("FIELD_TYPE not in", values, "fieldType");
            return (Criteria) this;
        }

        public Criteria andFieldTypeBetween(Integer value1, Integer value2) {
            addCriterion("FIELD_TYPE between", value1, value2, "fieldType");
            return (Criteria) this;
        }

        public Criteria andFieldTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("FIELD_TYPE not between", value1, value2, "fieldType");
            return (Criteria) this;
        }

        public Criteria andFieldFormatIsNull() {
            addCriterion("FIELD_FORMAT is null");
            return (Criteria) this;
        }

        public Criteria andFieldFormatIsNotNull() {
            addCriterion("FIELD_FORMAT is not null");
            return (Criteria) this;
        }

        public Criteria andFieldFormatEqualTo(String value) {
            addCriterion("FIELD_FORMAT =", value, "fieldFormat");
            return (Criteria) this;
        }

        public Criteria andFieldFormatNotEqualTo(String value) {
            addCriterion("FIELD_FORMAT <>", value, "fieldFormat");
            return (Criteria) this;
        }

        public Criteria andFieldFormatGreaterThan(String value) {
            addCriterion("FIELD_FORMAT >", value, "fieldFormat");
            return (Criteria) this;
        }

        public Criteria andFieldFormatGreaterThanOrEqualTo(String value) {
            addCriterion("FIELD_FORMAT >=", value, "fieldFormat");
            return (Criteria) this;
        }

        public Criteria andFieldFormatLessThan(String value) {
            addCriterion("FIELD_FORMAT <", value, "fieldFormat");
            return (Criteria) this;
        }

        public Criteria andFieldFormatLessThanOrEqualTo(String value) {
            addCriterion("FIELD_FORMAT <=", value, "fieldFormat");
            return (Criteria) this;
        }

        public Criteria andFieldFormatLike(String value) {
            addCriterion("FIELD_FORMAT like", value, "fieldFormat");
            return (Criteria) this;
        }

        public Criteria andFieldFormatNotLike(String value) {
            addCriterion("FIELD_FORMAT not like", value, "fieldFormat");
            return (Criteria) this;
        }

        public Criteria andFieldFormatIn(List<String> values) {
            addCriterion("FIELD_FORMAT in", values, "fieldFormat");
            return (Criteria) this;
        }

        public Criteria andFieldFormatNotIn(List<String> values) {
            addCriterion("FIELD_FORMAT not in", values, "fieldFormat");
            return (Criteria) this;
        }

        public Criteria andFieldFormatBetween(String value1, String value2) {
            addCriterion("FIELD_FORMAT between", value1, value2, "fieldFormat");
            return (Criteria) this;
        }

        public Criteria andFieldFormatNotBetween(String value1, String value2) {
            addCriterion("FIELD_FORMAT not between", value1, value2, "fieldFormat");
            return (Criteria) this;
        }

        public Criteria andFieldSizeIsNull() {
            addCriterion("FIELD_SIZE is null");
            return (Criteria) this;
        }

        public Criteria andFieldSizeIsNotNull() {
            addCriterion("FIELD_SIZE is not null");
            return (Criteria) this;
        }

        public Criteria andFieldSizeEqualTo(Integer value) {
            addCriterion("FIELD_SIZE =", value, "fieldSize");
            return (Criteria) this;
        }

        public Criteria andFieldSizeNotEqualTo(Integer value) {
            addCriterion("FIELD_SIZE <>", value, "fieldSize");
            return (Criteria) this;
        }

        public Criteria andFieldSizeGreaterThan(Integer value) {
            addCriterion("FIELD_SIZE >", value, "fieldSize");
            return (Criteria) this;
        }

        public Criteria andFieldSizeGreaterThanOrEqualTo(Integer value) {
            addCriterion("FIELD_SIZE >=", value, "fieldSize");
            return (Criteria) this;
        }

        public Criteria andFieldSizeLessThan(Integer value) {
            addCriterion("FIELD_SIZE <", value, "fieldSize");
            return (Criteria) this;
        }

        public Criteria andFieldSizeLessThanOrEqualTo(Integer value) {
            addCriterion("FIELD_SIZE <=", value, "fieldSize");
            return (Criteria) this;
        }

        public Criteria andFieldSizeIn(List<Integer> values) {
            addCriterion("FIELD_SIZE in", values, "fieldSize");
            return (Criteria) this;
        }

        public Criteria andFieldSizeNotIn(List<Integer> values) {
            addCriterion("FIELD_SIZE not in", values, "fieldSize");
            return (Criteria) this;
        }

        public Criteria andFieldSizeBetween(Integer value1, Integer value2) {
            addCriterion("FIELD_SIZE between", value1, value2, "fieldSize");
            return (Criteria) this;
        }

        public Criteria andFieldSizeNotBetween(Integer value1, Integer value2) {
            addCriterion("FIELD_SIZE not between", value1, value2, "fieldSize");
            return (Criteria) this;
        }

        public Criteria andIsHashkeyIsNull() {
            addCriterion("IS_HASHKEY is null");
            return (Criteria) this;
        }

        public Criteria andIsHashkeyIsNotNull() {
            addCriterion("IS_HASHKEY is not null");
            return (Criteria) this;
        }

        public Criteria andIsHashkeyEqualTo(Integer value) {
            addCriterion("IS_HASHKEY =", value, "isHashkey");
            return (Criteria) this;
        }

        public Criteria andIsHashkeyNotEqualTo(Integer value) {
            addCriterion("IS_HASHKEY <>", value, "isHashkey");
            return (Criteria) this;
        }

        public Criteria andIsHashkeyGreaterThan(Integer value) {
            addCriterion("IS_HASHKEY >", value, "isHashkey");
            return (Criteria) this;
        }

        public Criteria andIsHashkeyGreaterThanOrEqualTo(Integer value) {
            addCriterion("IS_HASHKEY >=", value, "isHashkey");
            return (Criteria) this;
        }

        public Criteria andIsHashkeyLessThan(Integer value) {
            addCriterion("IS_HASHKEY <", value, "isHashkey");
            return (Criteria) this;
        }

        public Criteria andIsHashkeyLessThanOrEqualTo(Integer value) {
            addCriterion("IS_HASHKEY <=", value, "isHashkey");
            return (Criteria) this;
        }

        public Criteria andIsHashkeyIn(List<Integer> values) {
            addCriterion("IS_HASHKEY in", values, "isHashkey");
            return (Criteria) this;
        }

        public Criteria andIsHashkeyNotIn(List<Integer> values) {
            addCriterion("IS_HASHKEY not in", values, "isHashkey");
            return (Criteria) this;
        }

        public Criteria andIsHashkeyBetween(Integer value1, Integer value2) {
            addCriterion("IS_HASHKEY between", value1, value2, "isHashkey");
            return (Criteria) this;
        }

        public Criteria andIsHashkeyNotBetween(Integer value1, Integer value2) {
            addCriterion("IS_HASHKEY not between", value1, value2, "isHashkey");
            return (Criteria) this;
        }

        public Criteria andIsPrimaryIsNull() {
            addCriterion("IS_PRIMARY is null");
            return (Criteria) this;
        }

        public Criteria andIsPrimaryIsNotNull() {
            addCriterion("IS_PRIMARY is not null");
            return (Criteria) this;
        }

        public Criteria andIsPrimaryEqualTo(Integer value) {
            addCriterion("IS_PRIMARY =", value, "isPrimary");
            return (Criteria) this;
        }

        public Criteria andIsPrimaryNotEqualTo(Integer value) {
            addCriterion("IS_PRIMARY <>", value, "isPrimary");
            return (Criteria) this;
        }

        public Criteria andIsPrimaryGreaterThan(Integer value) {
            addCriterion("IS_PRIMARY >", value, "isPrimary");
            return (Criteria) this;
        }

        public Criteria andIsPrimaryGreaterThanOrEqualTo(Integer value) {
            addCriterion("IS_PRIMARY >=", value, "isPrimary");
            return (Criteria) this;
        }

        public Criteria andIsPrimaryLessThan(Integer value) {
            addCriterion("IS_PRIMARY <", value, "isPrimary");
            return (Criteria) this;
        }

        public Criteria andIsPrimaryLessThanOrEqualTo(Integer value) {
            addCriterion("IS_PRIMARY <=", value, "isPrimary");
            return (Criteria) this;
        }

        public Criteria andIsPrimaryIn(List<Integer> values) {
            addCriterion("IS_PRIMARY in", values, "isPrimary");
            return (Criteria) this;
        }

        public Criteria andIsPrimaryNotIn(List<Integer> values) {
            addCriterion("IS_PRIMARY not in", values, "isPrimary");
            return (Criteria) this;
        }

        public Criteria andIsPrimaryBetween(Integer value1, Integer value2) {
            addCriterion("IS_PRIMARY between", value1, value2, "isPrimary");
            return (Criteria) this;
        }

        public Criteria andIsPrimaryNotBetween(Integer value1, Integer value2) {
            addCriterion("IS_PRIMARY not between", value1, value2, "isPrimary");
            return (Criteria) this;
        }

        public Criteria andSearchTypeIsNull() {
            addCriterion("SEARCH_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andSearchTypeIsNotNull() {
            addCriterion("SEARCH_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andSearchTypeEqualTo(String value) {
            addCriterion("SEARCH_TYPE =", value, "searchType");
            return (Criteria) this;
        }

        public Criteria andSearchTypeNotEqualTo(String value) {
            addCriterion("SEARCH_TYPE <>", value, "searchType");
            return (Criteria) this;
        }

        public Criteria andSearchTypeGreaterThan(String value) {
            addCriterion("SEARCH_TYPE >", value, "searchType");
            return (Criteria) this;
        }

        public Criteria andSearchTypeGreaterThanOrEqualTo(String value) {
            addCriterion("SEARCH_TYPE >=", value, "searchType");
            return (Criteria) this;
        }

        public Criteria andSearchTypeLessThan(String value) {
            addCriterion("SEARCH_TYPE <", value, "searchType");
            return (Criteria) this;
        }

        public Criteria andSearchTypeLessThanOrEqualTo(String value) {
            addCriterion("SEARCH_TYPE <=", value, "searchType");
            return (Criteria) this;
        }

        public Criteria andSearchTypeLike(String value) {
            addCriterion("SEARCH_TYPE like", value, "searchType");
            return (Criteria) this;
        }

        public Criteria andSearchTypeNotLike(String value) {
            addCriterion("SEARCH_TYPE not like", value, "searchType");
            return (Criteria) this;
        }

        public Criteria andSearchTypeIn(List<String> values) {
            addCriterion("SEARCH_TYPE in", values, "searchType");
            return (Criteria) this;
        }

        public Criteria andSearchTypeNotIn(List<String> values) {
            addCriterion("SEARCH_TYPE not in", values, "searchType");
            return (Criteria) this;
        }

        public Criteria andSearchTypeBetween(String value1, String value2) {
            addCriterion("SEARCH_TYPE between", value1, value2, "searchType");
            return (Criteria) this;
        }

        public Criteria andSearchTypeNotBetween(String value1, String value2) {
            addCriterion("SEARCH_TYPE not between", value1, value2, "searchType");
            return (Criteria) this;
        }

        public Criteria andTenantIdIsNull() {
            addCriterion("tenant_id is null");
            return (Criteria) this;
        }

        public Criteria andTenantIdIsNotNull() {
            addCriterion("tenant_id is not null");
            return (Criteria) this;
        }

        public Criteria andTenantIdEqualTo(String value) {
            addCriterion("tenant_id =", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdNotEqualTo(String value) {
            addCriterion("tenant_id <>", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdGreaterThan(String value) {
            addCriterion("tenant_id >", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdGreaterThanOrEqualTo(String value) {
            addCriterion("tenant_id >=", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdLessThan(String value) {
            addCriterion("tenant_id <", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdLessThanOrEqualTo(String value) {
            addCriterion("tenant_id <=", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdLike(String value) {
            addCriterion("tenant_id like", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdNotLike(String value) {
            addCriterion("tenant_id not like", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdIn(List<String> values) {
            addCriterion("tenant_id in", values, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdNotIn(List<String> values) {
            addCriterion("tenant_id not in", values, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdBetween(String value1, String value2) {
            addCriterion("tenant_id between", value1, value2, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdNotBetween(String value1, String value2) {
            addCriterion("tenant_id not between", value1, value2, "tenantId");
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
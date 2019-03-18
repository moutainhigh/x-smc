package com.x.ic.dshm.dto;

import java.util.ArrayList;
import java.util.List;

public class EbillingShmTableInfoCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public EbillingShmTableInfoCriteria() {
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

        public Criteria andIsEnableIsNull() {
            addCriterion("IS_ENABLE is null");
            return (Criteria) this;
        }

        public Criteria andIsEnableIsNotNull() {
            addCriterion("IS_ENABLE is not null");
            return (Criteria) this;
        }

        public Criteria andIsEnableEqualTo(Integer value) {
            addCriterion("IS_ENABLE =", value, "isEnable");
            return (Criteria) this;
        }

        public Criteria andIsEnableNotEqualTo(Integer value) {
            addCriterion("IS_ENABLE <>", value, "isEnable");
            return (Criteria) this;
        }

        public Criteria andIsEnableGreaterThan(Integer value) {
            addCriterion("IS_ENABLE >", value, "isEnable");
            return (Criteria) this;
        }

        public Criteria andIsEnableGreaterThanOrEqualTo(Integer value) {
            addCriterion("IS_ENABLE >=", value, "isEnable");
            return (Criteria) this;
        }

        public Criteria andIsEnableLessThan(Integer value) {
            addCriterion("IS_ENABLE <", value, "isEnable");
            return (Criteria) this;
        }

        public Criteria andIsEnableLessThanOrEqualTo(Integer value) {
            addCriterion("IS_ENABLE <=", value, "isEnable");
            return (Criteria) this;
        }

        public Criteria andIsEnableIn(List<Integer> values) {
            addCriterion("IS_ENABLE in", values, "isEnable");
            return (Criteria) this;
        }

        public Criteria andIsEnableNotIn(List<Integer> values) {
            addCriterion("IS_ENABLE not in", values, "isEnable");
            return (Criteria) this;
        }

        public Criteria andIsEnableBetween(Integer value1, Integer value2) {
            addCriterion("IS_ENABLE between", value1, value2, "isEnable");
            return (Criteria) this;
        }

        public Criteria andIsEnableNotBetween(Integer value1, Integer value2) {
            addCriterion("IS_ENABLE not between", value1, value2, "isEnable");
            return (Criteria) this;
        }

        public Criteria andIndexKeyIsNull() {
            addCriterion("INDEX_KEY is null");
            return (Criteria) this;
        }

        public Criteria andIndexKeyIsNotNull() {
            addCriterion("INDEX_KEY is not null");
            return (Criteria) this;
        }

        public Criteria andIndexKeyEqualTo(String value) {
            addCriterion("INDEX_KEY =", value, "indexKey");
            return (Criteria) this;
        }

        public Criteria andIndexKeyNotEqualTo(String value) {
            addCriterion("INDEX_KEY <>", value, "indexKey");
            return (Criteria) this;
        }

        public Criteria andIndexKeyGreaterThan(String value) {
            addCriterion("INDEX_KEY >", value, "indexKey");
            return (Criteria) this;
        }

        public Criteria andIndexKeyGreaterThanOrEqualTo(String value) {
            addCriterion("INDEX_KEY >=", value, "indexKey");
            return (Criteria) this;
        }

        public Criteria andIndexKeyLessThan(String value) {
            addCriterion("INDEX_KEY <", value, "indexKey");
            return (Criteria) this;
        }

        public Criteria andIndexKeyLessThanOrEqualTo(String value) {
            addCriterion("INDEX_KEY <=", value, "indexKey");
            return (Criteria) this;
        }

        public Criteria andIndexKeyLike(String value) {
            addCriterion("INDEX_KEY like", value, "indexKey");
            return (Criteria) this;
        }

        public Criteria andIndexKeyNotLike(String value) {
            addCriterion("INDEX_KEY not like", value, "indexKey");
            return (Criteria) this;
        }

        public Criteria andIndexKeyIn(List<String> values) {
            addCriterion("INDEX_KEY in", values, "indexKey");
            return (Criteria) this;
        }

        public Criteria andIndexKeyNotIn(List<String> values) {
            addCriterion("INDEX_KEY not in", values, "indexKey");
            return (Criteria) this;
        }

        public Criteria andIndexKeyBetween(String value1, String value2) {
            addCriterion("INDEX_KEY between", value1, value2, "indexKey");
            return (Criteria) this;
        }

        public Criteria andIndexKeyNotBetween(String value1, String value2) {
            addCriterion("INDEX_KEY not between", value1, value2, "indexKey");
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

        public Criteria andIndexModeIsNull() {
            addCriterion("INDEX_MODE is null");
            return (Criteria) this;
        }

        public Criteria andIndexModeIsNotNull() {
            addCriterion("INDEX_MODE is not null");
            return (Criteria) this;
        }

        public Criteria andIndexModeEqualTo(Integer value) {
            addCriterion("INDEX_MODE =", value, "indexMode");
            return (Criteria) this;
        }

        public Criteria andIndexModeNotEqualTo(Integer value) {
            addCriterion("INDEX_MODE <>", value, "indexMode");
            return (Criteria) this;
        }

        public Criteria andIndexModeGreaterThan(Integer value) {
            addCriterion("INDEX_MODE >", value, "indexMode");
            return (Criteria) this;
        }

        public Criteria andIndexModeGreaterThanOrEqualTo(Integer value) {
            addCriterion("INDEX_MODE >=", value, "indexMode");
            return (Criteria) this;
        }

        public Criteria andIndexModeLessThan(Integer value) {
            addCriterion("INDEX_MODE <", value, "indexMode");
            return (Criteria) this;
        }

        public Criteria andIndexModeLessThanOrEqualTo(Integer value) {
            addCriterion("INDEX_MODE <=", value, "indexMode");
            return (Criteria) this;
        }

        public Criteria andIndexModeIn(List<Integer> values) {
            addCriterion("INDEX_MODE in", values, "indexMode");
            return (Criteria) this;
        }

        public Criteria andIndexModeNotIn(List<Integer> values) {
            addCriterion("INDEX_MODE not in", values, "indexMode");
            return (Criteria) this;
        }

        public Criteria andIndexModeBetween(Integer value1, Integer value2) {
            addCriterion("INDEX_MODE between", value1, value2, "indexMode");
            return (Criteria) this;
        }

        public Criteria andIndexModeNotBetween(Integer value1, Integer value2) {
            addCriterion("INDEX_MODE not between", value1, value2, "indexMode");
            return (Criteria) this;
        }

        public Criteria andStorageTypeIsNull() {
            addCriterion("STORAGE_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andStorageTypeIsNotNull() {
            addCriterion("STORAGE_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andStorageTypeEqualTo(Integer value) {
            addCriterion("STORAGE_TYPE =", value, "storageType");
            return (Criteria) this;
        }

        public Criteria andStorageTypeNotEqualTo(Integer value) {
            addCriterion("STORAGE_TYPE <>", value, "storageType");
            return (Criteria) this;
        }

        public Criteria andStorageTypeGreaterThan(Integer value) {
            addCriterion("STORAGE_TYPE >", value, "storageType");
            return (Criteria) this;
        }

        public Criteria andStorageTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("STORAGE_TYPE >=", value, "storageType");
            return (Criteria) this;
        }

        public Criteria andStorageTypeLessThan(Integer value) {
            addCriterion("STORAGE_TYPE <", value, "storageType");
            return (Criteria) this;
        }

        public Criteria andStorageTypeLessThanOrEqualTo(Integer value) {
            addCriterion("STORAGE_TYPE <=", value, "storageType");
            return (Criteria) this;
        }

        public Criteria andStorageTypeIn(List<Integer> values) {
            addCriterion("STORAGE_TYPE in", values, "storageType");
            return (Criteria) this;
        }

        public Criteria andStorageTypeNotIn(List<Integer> values) {
            addCriterion("STORAGE_TYPE not in", values, "storageType");
            return (Criteria) this;
        }

        public Criteria andStorageTypeBetween(Integer value1, Integer value2) {
            addCriterion("STORAGE_TYPE between", value1, value2, "storageType");
            return (Criteria) this;
        }

        public Criteria andStorageTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("STORAGE_TYPE not between", value1, value2, "storageType");
            return (Criteria) this;
        }

        public Criteria andIndexCountIsNull() {
            addCriterion("INDEX_COUNT is null");
            return (Criteria) this;
        }

        public Criteria andIndexCountIsNotNull() {
            addCriterion("INDEX_COUNT is not null");
            return (Criteria) this;
        }

        public Criteria andIndexCountEqualTo(Long value) {
            addCriterion("INDEX_COUNT =", value, "indexCount");
            return (Criteria) this;
        }

        public Criteria andIndexCountNotEqualTo(Long value) {
            addCriterion("INDEX_COUNT <>", value, "indexCount");
            return (Criteria) this;
        }

        public Criteria andIndexCountGreaterThan(Long value) {
            addCriterion("INDEX_COUNT >", value, "indexCount");
            return (Criteria) this;
        }

        public Criteria andIndexCountGreaterThanOrEqualTo(Long value) {
            addCriterion("INDEX_COUNT >=", value, "indexCount");
            return (Criteria) this;
        }

        public Criteria andIndexCountLessThan(Long value) {
            addCriterion("INDEX_COUNT <", value, "indexCount");
            return (Criteria) this;
        }

        public Criteria andIndexCountLessThanOrEqualTo(Long value) {
            addCriterion("INDEX_COUNT <=", value, "indexCount");
            return (Criteria) this;
        }

        public Criteria andIndexCountIn(List<Long> values) {
            addCriterion("INDEX_COUNT in", values, "indexCount");
            return (Criteria) this;
        }

        public Criteria andIndexCountNotIn(List<Long> values) {
            addCriterion("INDEX_COUNT not in", values, "indexCount");
            return (Criteria) this;
        }

        public Criteria andIndexCountBetween(Long value1, Long value2) {
            addCriterion("INDEX_COUNT between", value1, value2, "indexCount");
            return (Criteria) this;
        }

        public Criteria andIndexCountNotBetween(Long value1, Long value2) {
            addCriterion("INDEX_COUNT not between", value1, value2, "indexCount");
            return (Criteria) this;
        }

        public Criteria andDataCountIsNull() {
            addCriterion("DATA_COUNT is null");
            return (Criteria) this;
        }

        public Criteria andDataCountIsNotNull() {
            addCriterion("DATA_COUNT is not null");
            return (Criteria) this;
        }

        public Criteria andDataCountEqualTo(Long value) {
            addCriterion("DATA_COUNT =", value, "dataCount");
            return (Criteria) this;
        }

        public Criteria andDataCountNotEqualTo(Long value) {
            addCriterion("DATA_COUNT <>", value, "dataCount");
            return (Criteria) this;
        }

        public Criteria andDataCountGreaterThan(Long value) {
            addCriterion("DATA_COUNT >", value, "dataCount");
            return (Criteria) this;
        }

        public Criteria andDataCountGreaterThanOrEqualTo(Long value) {
            addCriterion("DATA_COUNT >=", value, "dataCount");
            return (Criteria) this;
        }

        public Criteria andDataCountLessThan(Long value) {
            addCriterion("DATA_COUNT <", value, "dataCount");
            return (Criteria) this;
        }

        public Criteria andDataCountLessThanOrEqualTo(Long value) {
            addCriterion("DATA_COUNT <=", value, "dataCount");
            return (Criteria) this;
        }

        public Criteria andDataCountIn(List<Long> values) {
            addCriterion("DATA_COUNT in", values, "dataCount");
            return (Criteria) this;
        }

        public Criteria andDataCountNotIn(List<Long> values) {
            addCriterion("DATA_COUNT not in", values, "dataCount");
            return (Criteria) this;
        }

        public Criteria andDataCountBetween(Long value1, Long value2) {
            addCriterion("DATA_COUNT between", value1, value2, "dataCount");
            return (Criteria) this;
        }

        public Criteria andDataCountNotBetween(Long value1, Long value2) {
            addCriterion("DATA_COUNT not between", value1, value2, "dataCount");
            return (Criteria) this;
        }

        public Criteria andIsParaIsNull() {
            addCriterion("IS_PARA is null");
            return (Criteria) this;
        }

        public Criteria andIsParaIsNotNull() {
            addCriterion("IS_PARA is not null");
            return (Criteria) this;
        }

        public Criteria andIsParaEqualTo(Integer value) {
            addCriterion("IS_PARA =", value, "isPara");
            return (Criteria) this;
        }

        public Criteria andIsParaNotEqualTo(Integer value) {
            addCriterion("IS_PARA <>", value, "isPara");
            return (Criteria) this;
        }

        public Criteria andIsParaGreaterThan(Integer value) {
            addCriterion("IS_PARA >", value, "isPara");
            return (Criteria) this;
        }

        public Criteria andIsParaGreaterThanOrEqualTo(Integer value) {
            addCriterion("IS_PARA >=", value, "isPara");
            return (Criteria) this;
        }

        public Criteria andIsParaLessThan(Integer value) {
            addCriterion("IS_PARA <", value, "isPara");
            return (Criteria) this;
        }

        public Criteria andIsParaLessThanOrEqualTo(Integer value) {
            addCriterion("IS_PARA <=", value, "isPara");
            return (Criteria) this;
        }

        public Criteria andIsParaIn(List<Integer> values) {
            addCriterion("IS_PARA in", values, "isPara");
            return (Criteria) this;
        }

        public Criteria andIsParaNotIn(List<Integer> values) {
            addCriterion("IS_PARA not in", values, "isPara");
            return (Criteria) this;
        }

        public Criteria andIsParaBetween(Integer value1, Integer value2) {
            addCriterion("IS_PARA between", value1, value2, "isPara");
            return (Criteria) this;
        }

        public Criteria andIsParaNotBetween(Integer value1, Integer value2) {
            addCriterion("IS_PARA not between", value1, value2, "isPara");
            return (Criteria) this;
        }

        public Criteria andIndexIdIsNull() {
            addCriterion("INDEX_ID is null");
            return (Criteria) this;
        }

        public Criteria andIndexIdIsNotNull() {
            addCriterion("INDEX_ID is not null");
            return (Criteria) this;
        }

        public Criteria andIndexIdEqualTo(Integer value) {
            addCriterion("INDEX_ID =", value, "indexId");
            return (Criteria) this;
        }

        public Criteria andIndexIdNotEqualTo(Integer value) {
            addCriterion("INDEX_ID <>", value, "indexId");
            return (Criteria) this;
        }

        public Criteria andIndexIdGreaterThan(Integer value) {
            addCriterion("INDEX_ID >", value, "indexId");
            return (Criteria) this;
        }

        public Criteria andIndexIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("INDEX_ID >=", value, "indexId");
            return (Criteria) this;
        }

        public Criteria andIndexIdLessThan(Integer value) {
            addCriterion("INDEX_ID <", value, "indexId");
            return (Criteria) this;
        }

        public Criteria andIndexIdLessThanOrEqualTo(Integer value) {
            addCriterion("INDEX_ID <=", value, "indexId");
            return (Criteria) this;
        }

        public Criteria andIndexIdIn(List<Integer> values) {
            addCriterion("INDEX_ID in", values, "indexId");
            return (Criteria) this;
        }

        public Criteria andIndexIdNotIn(List<Integer> values) {
            addCriterion("INDEX_ID not in", values, "indexId");
            return (Criteria) this;
        }

        public Criteria andIndexIdBetween(Integer value1, Integer value2) {
            addCriterion("INDEX_ID between", value1, value2, "indexId");
            return (Criteria) this;
        }

        public Criteria andIndexIdNotBetween(Integer value1, Integer value2) {
            addCriterion("INDEX_ID not between", value1, value2, "indexId");
            return (Criteria) this;
        }

        public Criteria andHashTypeIsNull() {
            addCriterion("HASH_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andHashTypeIsNotNull() {
            addCriterion("HASH_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andHashTypeEqualTo(Integer value) {
            addCriterion("HASH_TYPE =", value, "hashType");
            return (Criteria) this;
        }

        public Criteria andHashTypeNotEqualTo(Integer value) {
            addCriterion("HASH_TYPE <>", value, "hashType");
            return (Criteria) this;
        }

        public Criteria andHashTypeGreaterThan(Integer value) {
            addCriterion("HASH_TYPE >", value, "hashType");
            return (Criteria) this;
        }

        public Criteria andHashTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("HASH_TYPE >=", value, "hashType");
            return (Criteria) this;
        }

        public Criteria andHashTypeLessThan(Integer value) {
            addCriterion("HASH_TYPE <", value, "hashType");
            return (Criteria) this;
        }

        public Criteria andHashTypeLessThanOrEqualTo(Integer value) {
            addCriterion("HASH_TYPE <=", value, "hashType");
            return (Criteria) this;
        }

        public Criteria andHashTypeIn(List<Integer> values) {
            addCriterion("HASH_TYPE in", values, "hashType");
            return (Criteria) this;
        }

        public Criteria andHashTypeNotIn(List<Integer> values) {
            addCriterion("HASH_TYPE not in", values, "hashType");
            return (Criteria) this;
        }

        public Criteria andHashTypeBetween(Integer value1, Integer value2) {
            addCriterion("HASH_TYPE between", value1, value2, "hashType");
            return (Criteria) this;
        }

        public Criteria andHashTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("HASH_TYPE not between", value1, value2, "hashType");
            return (Criteria) this;
        }

        public Criteria andLesseeNameIsNull() {
            addCriterion("LESSEE_NAME is null");
            return (Criteria) this;
        }

        public Criteria andLesseeNameIsNotNull() {
            addCriterion("LESSEE_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andLesseeNameEqualTo(String value) {
            addCriterion("LESSEE_NAME =", value, "lesseeName");
            return (Criteria) this;
        }

        public Criteria andLesseeNameNotEqualTo(String value) {
            addCriterion("LESSEE_NAME <>", value, "lesseeName");
            return (Criteria) this;
        }

        public Criteria andLesseeNameGreaterThan(String value) {
            addCriterion("LESSEE_NAME >", value, "lesseeName");
            return (Criteria) this;
        }

        public Criteria andLesseeNameGreaterThanOrEqualTo(String value) {
            addCriterion("LESSEE_NAME >=", value, "lesseeName");
            return (Criteria) this;
        }

        public Criteria andLesseeNameLessThan(String value) {
            addCriterion("LESSEE_NAME <", value, "lesseeName");
            return (Criteria) this;
        }

        public Criteria andLesseeNameLessThanOrEqualTo(String value) {
            addCriterion("LESSEE_NAME <=", value, "lesseeName");
            return (Criteria) this;
        }

        public Criteria andLesseeNameLike(String value) {
            addCriterion("LESSEE_NAME like", value, "lesseeName");
            return (Criteria) this;
        }

        public Criteria andLesseeNameNotLike(String value) {
            addCriterion("LESSEE_NAME not like", value, "lesseeName");
            return (Criteria) this;
        }

        public Criteria andLesseeNameIn(List<String> values) {
            addCriterion("LESSEE_NAME in", values, "lesseeName");
            return (Criteria) this;
        }

        public Criteria andLesseeNameNotIn(List<String> values) {
            addCriterion("LESSEE_NAME not in", values, "lesseeName");
            return (Criteria) this;
        }

        public Criteria andLesseeNameBetween(String value1, String value2) {
            addCriterion("LESSEE_NAME between", value1, value2, "lesseeName");
            return (Criteria) this;
        }

        public Criteria andLesseeNameNotBetween(String value1, String value2) {
            addCriterion("LESSEE_NAME not between", value1, value2, "lesseeName");
            return (Criteria) this;
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

        public Criteria andTableKeyIsNull() {
            addCriterion("table_key is null");
            return (Criteria) this;
        }

        public Criteria andTableKeyIsNotNull() {
            addCriterion("table_key is not null");
            return (Criteria) this;
        }

        public Criteria andTableKeyEqualTo(String value) {
            addCriterion("table_key =", value, "tableKey");
            return (Criteria) this;
        }

        public Criteria andTableKeyNotEqualTo(String value) {
            addCriterion("table_key <>", value, "tableKey");
            return (Criteria) this;
        }

        public Criteria andTableKeyGreaterThan(String value) {
            addCriterion("table_key >", value, "tableKey");
            return (Criteria) this;
        }

        public Criteria andTableKeyGreaterThanOrEqualTo(String value) {
            addCriterion("table_key >=", value, "tableKey");
            return (Criteria) this;
        }

        public Criteria andTableKeyLessThan(String value) {
            addCriterion("table_key <", value, "tableKey");
            return (Criteria) this;
        }

        public Criteria andTableKeyLessThanOrEqualTo(String value) {
            addCriterion("table_key <=", value, "tableKey");
            return (Criteria) this;
        }

        public Criteria andTableKeyLike(String value) {
            addCriterion("table_key like", value, "tableKey");
            return (Criteria) this;
        }

        public Criteria andTableKeyNotLike(String value) {
            addCriterion("table_key not like", value, "tableKey");
            return (Criteria) this;
        }

        public Criteria andTableKeyIn(List<String> values) {
            addCriterion("table_key in", values, "tableKey");
            return (Criteria) this;
        }

        public Criteria andTableKeyNotIn(List<String> values) {
            addCriterion("table_key not in", values, "tableKey");
            return (Criteria) this;
        }

        public Criteria andTableKeyBetween(String value1, String value2) {
            addCriterion("table_key between", value1, value2, "tableKey");
            return (Criteria) this;
        }

        public Criteria andTableKeyNotBetween(String value1, String value2) {
            addCriterion("table_key not between", value1, value2, "tableKey");
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
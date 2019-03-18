package com.x.ic.smc.dao.mapper.bo;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class StlImportLogCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public StlImportLogCriteria() {
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

        public Criteria andLogIdIsNull() {
            addCriterion("LOG_ID is null");
            return (Criteria) this;
        }

        public Criteria andLogIdIsNotNull() {
            addCriterion("LOG_ID is not null");
            return (Criteria) this;
        }

        public Criteria andLogIdEqualTo(Long value) {
            addCriterion("LOG_ID =", value, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdNotEqualTo(Long value) {
            addCriterion("LOG_ID <>", value, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdGreaterThan(Long value) {
            addCriterion("LOG_ID >", value, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdGreaterThanOrEqualTo(Long value) {
            addCriterion("LOG_ID >=", value, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdLessThan(Long value) {
            addCriterion("LOG_ID <", value, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdLessThanOrEqualTo(Long value) {
            addCriterion("LOG_ID <=", value, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdIn(List<Long> values) {
            addCriterion("LOG_ID in", values, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdNotIn(List<Long> values) {
            addCriterion("LOG_ID not in", values, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdBetween(Long value1, Long value2) {
            addCriterion("LOG_ID between", value1, value2, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdNotBetween(Long value1, Long value2) {
            addCriterion("LOG_ID not between", value1, value2, "logId");
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

        public Criteria andImpFileNameIsNull() {
            addCriterion("IMP_FILE_NAME is null");
            return (Criteria) this;
        }

        public Criteria andImpFileNameIsNotNull() {
            addCriterion("IMP_FILE_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andImpFileNameEqualTo(String value) {
            addCriterion("IMP_FILE_NAME =", value, "impFileName");
            return (Criteria) this;
        }

        public Criteria andImpFileNameNotEqualTo(String value) {
            addCriterion("IMP_FILE_NAME <>", value, "impFileName");
            return (Criteria) this;
        }

        public Criteria andImpFileNameGreaterThan(String value) {
            addCriterion("IMP_FILE_NAME >", value, "impFileName");
            return (Criteria) this;
        }

        public Criteria andImpFileNameGreaterThanOrEqualTo(String value) {
            addCriterion("IMP_FILE_NAME >=", value, "impFileName");
            return (Criteria) this;
        }

        public Criteria andImpFileNameLessThan(String value) {
            addCriterion("IMP_FILE_NAME <", value, "impFileName");
            return (Criteria) this;
        }

        public Criteria andImpFileNameLessThanOrEqualTo(String value) {
            addCriterion("IMP_FILE_NAME <=", value, "impFileName");
            return (Criteria) this;
        }

        public Criteria andImpFileNameLike(String value) {
            addCriterion("IMP_FILE_NAME like", value, "impFileName");
            return (Criteria) this;
        }

        public Criteria andImpFileNameNotLike(String value) {
            addCriterion("IMP_FILE_NAME not like", value, "impFileName");
            return (Criteria) this;
        }

        public Criteria andImpFileNameIn(List<String> values) {
            addCriterion("IMP_FILE_NAME in", values, "impFileName");
            return (Criteria) this;
        }

        public Criteria andImpFileNameNotIn(List<String> values) {
            addCriterion("IMP_FILE_NAME not in", values, "impFileName");
            return (Criteria) this;
        }

        public Criteria andImpFileNameBetween(String value1, String value2) {
            addCriterion("IMP_FILE_NAME between", value1, value2, "impFileName");
            return (Criteria) this;
        }

        public Criteria andImpFileNameNotBetween(String value1, String value2) {
            addCriterion("IMP_FILE_NAME not between", value1, value2, "impFileName");
            return (Criteria) this;
        }

        public Criteria andImpFileUrlIsNull() {
            addCriterion("IMP_FILE_URL is null");
            return (Criteria) this;
        }

        public Criteria andImpFileUrlIsNotNull() {
            addCriterion("IMP_FILE_URL is not null");
            return (Criteria) this;
        }

        public Criteria andImpFileUrlEqualTo(String value) {
            addCriterion("IMP_FILE_URL =", value, "impFileUrl");
            return (Criteria) this;
        }

        public Criteria andImpFileUrlNotEqualTo(String value) {
            addCriterion("IMP_FILE_URL <>", value, "impFileUrl");
            return (Criteria) this;
        }

        public Criteria andImpFileUrlGreaterThan(String value) {
            addCriterion("IMP_FILE_URL >", value, "impFileUrl");
            return (Criteria) this;
        }

        public Criteria andImpFileUrlGreaterThanOrEqualTo(String value) {
            addCriterion("IMP_FILE_URL >=", value, "impFileUrl");
            return (Criteria) this;
        }

        public Criteria andImpFileUrlLessThan(String value) {
            addCriterion("IMP_FILE_URL <", value, "impFileUrl");
            return (Criteria) this;
        }

        public Criteria andImpFileUrlLessThanOrEqualTo(String value) {
            addCriterion("IMP_FILE_URL <=", value, "impFileUrl");
            return (Criteria) this;
        }

        public Criteria andImpFileUrlLike(String value) {
            addCriterion("IMP_FILE_URL like", value, "impFileUrl");
            return (Criteria) this;
        }

        public Criteria andImpFileUrlNotLike(String value) {
            addCriterion("IMP_FILE_URL not like", value, "impFileUrl");
            return (Criteria) this;
        }

        public Criteria andImpFileUrlIn(List<String> values) {
            addCriterion("IMP_FILE_URL in", values, "impFileUrl");
            return (Criteria) this;
        }

        public Criteria andImpFileUrlNotIn(List<String> values) {
            addCriterion("IMP_FILE_URL not in", values, "impFileUrl");
            return (Criteria) this;
        }

        public Criteria andImpFileUrlBetween(String value1, String value2) {
            addCriterion("IMP_FILE_URL between", value1, value2, "impFileUrl");
            return (Criteria) this;
        }

        public Criteria andImpFileUrlNotBetween(String value1, String value2) {
            addCriterion("IMP_FILE_URL not between", value1, value2, "impFileUrl");
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

        public Criteria andImportTimeIsNull() {
            addCriterion("IMPORT_TIME is null");
            return (Criteria) this;
        }

        public Criteria andImportTimeIsNotNull() {
            addCriterion("IMPORT_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andImportTimeEqualTo(Timestamp value) {
            addCriterion("IMPORT_TIME =", value, "importTime");
            return (Criteria) this;
        }

        public Criteria andImportTimeNotEqualTo(Timestamp value) {
            addCriterion("IMPORT_TIME <>", value, "importTime");
            return (Criteria) this;
        }

        public Criteria andImportTimeGreaterThan(Timestamp value) {
            addCriterion("IMPORT_TIME >", value, "importTime");
            return (Criteria) this;
        }

        public Criteria andImportTimeGreaterThanOrEqualTo(Timestamp value) {
            addCriterion("IMPORT_TIME >=", value, "importTime");
            return (Criteria) this;
        }

        public Criteria andImportTimeLessThan(Timestamp value) {
            addCriterion("IMPORT_TIME <", value, "importTime");
            return (Criteria) this;
        }

        public Criteria andImportTimeLessThanOrEqualTo(Timestamp value) {
            addCriterion("IMPORT_TIME <=", value, "importTime");
            return (Criteria) this;
        }

        public Criteria andImportTimeIn(List<Timestamp> values) {
            addCriterion("IMPORT_TIME in", values, "importTime");
            return (Criteria) this;
        }

        public Criteria andImportTimeNotIn(List<Timestamp> values) {
            addCriterion("IMPORT_TIME not in", values, "importTime");
            return (Criteria) this;
        }

        public Criteria andImportTimeBetween(Timestamp value1, Timestamp value2) {
            addCriterion("IMPORT_TIME between", value1, value2, "importTime");
            return (Criteria) this;
        }

        public Criteria andImportTimeNotBetween(Timestamp value1, Timestamp value2) {
            addCriterion("IMPORT_TIME not between", value1, value2, "importTime");
            return (Criteria) this;
        }

        public Criteria andImportRecordsIsNull() {
            addCriterion("IMPORT_RECORDS is null");
            return (Criteria) this;
        }

        public Criteria andImportRecordsIsNotNull() {
            addCriterion("IMPORT_RECORDS is not null");
            return (Criteria) this;
        }

        public Criteria andImportRecordsEqualTo(Long value) {
            addCriterion("IMPORT_RECORDS =", value, "importRecords");
            return (Criteria) this;
        }

        public Criteria andImportRecordsNotEqualTo(Long value) {
            addCriterion("IMPORT_RECORDS <>", value, "importRecords");
            return (Criteria) this;
        }

        public Criteria andImportRecordsGreaterThan(Long value) {
            addCriterion("IMPORT_RECORDS >", value, "importRecords");
            return (Criteria) this;
        }

        public Criteria andImportRecordsGreaterThanOrEqualTo(Long value) {
            addCriterion("IMPORT_RECORDS >=", value, "importRecords");
            return (Criteria) this;
        }

        public Criteria andImportRecordsLessThan(Long value) {
            addCriterion("IMPORT_RECORDS <", value, "importRecords");
            return (Criteria) this;
        }

        public Criteria andImportRecordsLessThanOrEqualTo(Long value) {
            addCriterion("IMPORT_RECORDS <=", value, "importRecords");
            return (Criteria) this;
        }

        public Criteria andImportRecordsIn(List<Long> values) {
            addCriterion("IMPORT_RECORDS in", values, "importRecords");
            return (Criteria) this;
        }

        public Criteria andImportRecordsNotIn(List<Long> values) {
            addCriterion("IMPORT_RECORDS not in", values, "importRecords");
            return (Criteria) this;
        }

        public Criteria andImportRecordsBetween(Long value1, Long value2) {
            addCriterion("IMPORT_RECORDS between", value1, value2, "importRecords");
            return (Criteria) this;
        }

        public Criteria andImportRecordsNotBetween(Long value1, Long value2) {
            addCriterion("IMPORT_RECORDS not between", value1, value2, "importRecords");
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

        public Criteria andRstFileNameIsNull() {
            addCriterion("RST_FILE_NAME is null");
            return (Criteria) this;
        }

        public Criteria andRstFileNameIsNotNull() {
            addCriterion("RST_FILE_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andRstFileNameEqualTo(String value) {
            addCriterion("RST_FILE_NAME =", value, "rstFileName");
            return (Criteria) this;
        }

        public Criteria andRstFileNameNotEqualTo(String value) {
            addCriterion("RST_FILE_NAME <>", value, "rstFileName");
            return (Criteria) this;
        }

        public Criteria andRstFileNameGreaterThan(String value) {
            addCriterion("RST_FILE_NAME >", value, "rstFileName");
            return (Criteria) this;
        }

        public Criteria andRstFileNameGreaterThanOrEqualTo(String value) {
            addCriterion("RST_FILE_NAME >=", value, "rstFileName");
            return (Criteria) this;
        }

        public Criteria andRstFileNameLessThan(String value) {
            addCriterion("RST_FILE_NAME <", value, "rstFileName");
            return (Criteria) this;
        }

        public Criteria andRstFileNameLessThanOrEqualTo(String value) {
            addCriterion("RST_FILE_NAME <=", value, "rstFileName");
            return (Criteria) this;
        }

        public Criteria andRstFileNameLike(String value) {
            addCriterion("RST_FILE_NAME like", value, "rstFileName");
            return (Criteria) this;
        }

        public Criteria andRstFileNameNotLike(String value) {
            addCriterion("RST_FILE_NAME not like", value, "rstFileName");
            return (Criteria) this;
        }

        public Criteria andRstFileNameIn(List<String> values) {
            addCriterion("RST_FILE_NAME in", values, "rstFileName");
            return (Criteria) this;
        }

        public Criteria andRstFileNameNotIn(List<String> values) {
            addCriterion("RST_FILE_NAME not in", values, "rstFileName");
            return (Criteria) this;
        }

        public Criteria andRstFileNameBetween(String value1, String value2) {
            addCriterion("RST_FILE_NAME between", value1, value2, "rstFileName");
            return (Criteria) this;
        }

        public Criteria andRstFileNameNotBetween(String value1, String value2) {
            addCriterion("RST_FILE_NAME not between", value1, value2, "rstFileName");
            return (Criteria) this;
        }

        public Criteria andRstFileUrlIsNull() {
            addCriterion("RST_FILE_URL is null");
            return (Criteria) this;
        }

        public Criteria andRstFileUrlIsNotNull() {
            addCriterion("RST_FILE_URL is not null");
            return (Criteria) this;
        }

        public Criteria andRstFileUrlEqualTo(String value) {
            addCriterion("RST_FILE_URL =", value, "rstFileUrl");
            return (Criteria) this;
        }

        public Criteria andRstFileUrlNotEqualTo(String value) {
            addCriterion("RST_FILE_URL <>", value, "rstFileUrl");
            return (Criteria) this;
        }

        public Criteria andRstFileUrlGreaterThan(String value) {
            addCriterion("RST_FILE_URL >", value, "rstFileUrl");
            return (Criteria) this;
        }

        public Criteria andRstFileUrlGreaterThanOrEqualTo(String value) {
            addCriterion("RST_FILE_URL >=", value, "rstFileUrl");
            return (Criteria) this;
        }

        public Criteria andRstFileUrlLessThan(String value) {
            addCriterion("RST_FILE_URL <", value, "rstFileUrl");
            return (Criteria) this;
        }

        public Criteria andRstFileUrlLessThanOrEqualTo(String value) {
            addCriterion("RST_FILE_URL <=", value, "rstFileUrl");
            return (Criteria) this;
        }

        public Criteria andRstFileUrlLike(String value) {
            addCriterion("RST_FILE_URL like", value, "rstFileUrl");
            return (Criteria) this;
        }

        public Criteria andRstFileUrlNotLike(String value) {
            addCriterion("RST_FILE_URL not like", value, "rstFileUrl");
            return (Criteria) this;
        }

        public Criteria andRstFileUrlIn(List<String> values) {
            addCriterion("RST_FILE_URL in", values, "rstFileUrl");
            return (Criteria) this;
        }

        public Criteria andRstFileUrlNotIn(List<String> values) {
            addCriterion("RST_FILE_URL not in", values, "rstFileUrl");
            return (Criteria) this;
        }

        public Criteria andRstFileUrlBetween(String value1, String value2) {
            addCriterion("RST_FILE_URL between", value1, value2, "rstFileUrl");
            return (Criteria) this;
        }

        public Criteria andRstFileUrlNotBetween(String value1, String value2) {
            addCriterion("RST_FILE_URL not between", value1, value2, "rstFileUrl");
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

        public Criteria andStateDescIsNull() {
            addCriterion("STATE_DESC is null");
            return (Criteria) this;
        }

        public Criteria andStateDescIsNotNull() {
            addCriterion("STATE_DESC is not null");
            return (Criteria) this;
        }

        public Criteria andStateDescEqualTo(String value) {
            addCriterion("STATE_DESC =", value, "stateDesc");
            return (Criteria) this;
        }

        public Criteria andStateDescNotEqualTo(String value) {
            addCriterion("STATE_DESC <>", value, "stateDesc");
            return (Criteria) this;
        }

        public Criteria andStateDescGreaterThan(String value) {
            addCriterion("STATE_DESC >", value, "stateDesc");
            return (Criteria) this;
        }

        public Criteria andStateDescGreaterThanOrEqualTo(String value) {
            addCriterion("STATE_DESC >=", value, "stateDesc");
            return (Criteria) this;
        }

        public Criteria andStateDescLessThan(String value) {
            addCriterion("STATE_DESC <", value, "stateDesc");
            return (Criteria) this;
        }

        public Criteria andStateDescLessThanOrEqualTo(String value) {
            addCriterion("STATE_DESC <=", value, "stateDesc");
            return (Criteria) this;
        }

        public Criteria andStateDescLike(String value) {
            addCriterion("STATE_DESC like", value, "stateDesc");
            return (Criteria) this;
        }

        public Criteria andStateDescNotLike(String value) {
            addCriterion("STATE_DESC not like", value, "stateDesc");
            return (Criteria) this;
        }

        public Criteria andStateDescIn(List<String> values) {
            addCriterion("STATE_DESC in", values, "stateDesc");
            return (Criteria) this;
        }

        public Criteria andStateDescNotIn(List<String> values) {
            addCriterion("STATE_DESC not in", values, "stateDesc");
            return (Criteria) this;
        }

        public Criteria andStateDescBetween(String value1, String value2) {
            addCriterion("STATE_DESC between", value1, value2, "stateDesc");
            return (Criteria) this;
        }

        public Criteria andStateDescNotBetween(String value1, String value2) {
            addCriterion("STATE_DESC not between", value1, value2, "stateDesc");
            return (Criteria) this;
        }

        public Criteria andOptDeptIdIsNull() {
            addCriterion("OPT_DEPT_ID is null");
            return (Criteria) this;
        }

        public Criteria andOptDeptIdIsNotNull() {
            addCriterion("OPT_DEPT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andOptDeptIdEqualTo(String value) {
            addCriterion("OPT_DEPT_ID =", value, "optDeptId");
            return (Criteria) this;
        }

        public Criteria andOptDeptIdNotEqualTo(String value) {
            addCriterion("OPT_DEPT_ID <>", value, "optDeptId");
            return (Criteria) this;
        }

        public Criteria andOptDeptIdGreaterThan(String value) {
            addCriterion("OPT_DEPT_ID >", value, "optDeptId");
            return (Criteria) this;
        }

        public Criteria andOptDeptIdGreaterThanOrEqualTo(String value) {
            addCriterion("OPT_DEPT_ID >=", value, "optDeptId");
            return (Criteria) this;
        }

        public Criteria andOptDeptIdLessThan(String value) {
            addCriterion("OPT_DEPT_ID <", value, "optDeptId");
            return (Criteria) this;
        }

        public Criteria andOptDeptIdLessThanOrEqualTo(String value) {
            addCriterion("OPT_DEPT_ID <=", value, "optDeptId");
            return (Criteria) this;
        }

        public Criteria andOptDeptIdLike(String value) {
            addCriterion("OPT_DEPT_ID like", value, "optDeptId");
            return (Criteria) this;
        }

        public Criteria andOptDeptIdNotLike(String value) {
            addCriterion("OPT_DEPT_ID not like", value, "optDeptId");
            return (Criteria) this;
        }

        public Criteria andOptDeptIdIn(List<String> values) {
            addCriterion("OPT_DEPT_ID in", values, "optDeptId");
            return (Criteria) this;
        }

        public Criteria andOptDeptIdNotIn(List<String> values) {
            addCriterion("OPT_DEPT_ID not in", values, "optDeptId");
            return (Criteria) this;
        }

        public Criteria andOptDeptIdBetween(String value1, String value2) {
            addCriterion("OPT_DEPT_ID between", value1, value2, "optDeptId");
            return (Criteria) this;
        }

        public Criteria andOptDeptIdNotBetween(String value1, String value2) {
            addCriterion("OPT_DEPT_ID not between", value1, value2, "optDeptId");
            return (Criteria) this;
        }

        public Criteria andOptOperIdIsNull() {
            addCriterion("OPT_OPER_ID is null");
            return (Criteria) this;
        }

        public Criteria andOptOperIdIsNotNull() {
            addCriterion("OPT_OPER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andOptOperIdEqualTo(String value) {
            addCriterion("OPT_OPER_ID =", value, "optOperId");
            return (Criteria) this;
        }

        public Criteria andOptOperIdNotEqualTo(String value) {
            addCriterion("OPT_OPER_ID <>", value, "optOperId");
            return (Criteria) this;
        }

        public Criteria andOptOperIdGreaterThan(String value) {
            addCriterion("OPT_OPER_ID >", value, "optOperId");
            return (Criteria) this;
        }

        public Criteria andOptOperIdGreaterThanOrEqualTo(String value) {
            addCriterion("OPT_OPER_ID >=", value, "optOperId");
            return (Criteria) this;
        }

        public Criteria andOptOperIdLessThan(String value) {
            addCriterion("OPT_OPER_ID <", value, "optOperId");
            return (Criteria) this;
        }

        public Criteria andOptOperIdLessThanOrEqualTo(String value) {
            addCriterion("OPT_OPER_ID <=", value, "optOperId");
            return (Criteria) this;
        }

        public Criteria andOptOperIdLike(String value) {
            addCriterion("OPT_OPER_ID like", value, "optOperId");
            return (Criteria) this;
        }

        public Criteria andOptOperIdNotLike(String value) {
            addCriterion("OPT_OPER_ID not like", value, "optOperId");
            return (Criteria) this;
        }

        public Criteria andOptOperIdIn(List<String> values) {
            addCriterion("OPT_OPER_ID in", values, "optOperId");
            return (Criteria) this;
        }

        public Criteria andOptOperIdNotIn(List<String> values) {
            addCriterion("OPT_OPER_ID not in", values, "optOperId");
            return (Criteria) this;
        }

        public Criteria andOptOperIdBetween(String value1, String value2) {
            addCriterion("OPT_OPER_ID between", value1, value2, "optOperId");
            return (Criteria) this;
        }

        public Criteria andOptOperIdNotBetween(String value1, String value2) {
            addCriterion("OPT_OPER_ID not between", value1, value2, "optOperId");
            return (Criteria) this;
        }

        public Criteria andStateChgTimeIsNull() {
            addCriterion("STATE_CHG_TIME is null");
            return (Criteria) this;
        }

        public Criteria andStateChgTimeIsNotNull() {
            addCriterion("STATE_CHG_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andStateChgTimeEqualTo(Timestamp value) {
            addCriterion("STATE_CHG_TIME =", value, "stateChgTime");
            return (Criteria) this;
        }

        public Criteria andStateChgTimeNotEqualTo(Timestamp value) {
            addCriterion("STATE_CHG_TIME <>", value, "stateChgTime");
            return (Criteria) this;
        }

        public Criteria andStateChgTimeGreaterThan(Timestamp value) {
            addCriterion("STATE_CHG_TIME >", value, "stateChgTime");
            return (Criteria) this;
        }

        public Criteria andStateChgTimeGreaterThanOrEqualTo(Timestamp value) {
            addCriterion("STATE_CHG_TIME >=", value, "stateChgTime");
            return (Criteria) this;
        }

        public Criteria andStateChgTimeLessThan(Timestamp value) {
            addCriterion("STATE_CHG_TIME <", value, "stateChgTime");
            return (Criteria) this;
        }

        public Criteria andStateChgTimeLessThanOrEqualTo(Timestamp value) {
            addCriterion("STATE_CHG_TIME <=", value, "stateChgTime");
            return (Criteria) this;
        }

        public Criteria andStateChgTimeIn(List<Timestamp> values) {
            addCriterion("STATE_CHG_TIME in", values, "stateChgTime");
            return (Criteria) this;
        }

        public Criteria andStateChgTimeNotIn(List<Timestamp> values) {
            addCriterion("STATE_CHG_TIME not in", values, "stateChgTime");
            return (Criteria) this;
        }

        public Criteria andStateChgTimeBetween(Timestamp value1, Timestamp value2) {
            addCriterion("STATE_CHG_TIME between", value1, value2, "stateChgTime");
            return (Criteria) this;
        }

        public Criteria andStateChgTimeNotBetween(Timestamp value1, Timestamp value2) {
            addCriterion("STATE_CHG_TIME not between", value1, value2, "stateChgTime");
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
package com.x.ic.smc.vo.dshm;

import java.sql.Timestamp;

public class ImportLogDshmVO {
    private Long log_id;

    private String tenant_id;

    private String imp_file_name;

    private String imp_file_url;

    private String data_type;

    private String object_id;

    private String bill_time_sn;

    private Timestamp import_time;

    private Long import_records;

    private String batch_no;

    private String rst_file_name;

    private String rst_file_url;

    private String state;

    private String state_desc;

    private String opt_dept_id;

    private String opt_oper_id;

    public Long getLog_id() {
        return log_id;
    }

    public void setLog_id(Long log_id) {
        this.log_id = log_id;
    }

    public String getTenant_id() {
        return tenant_id;
    }

    public void setTenant_id(String tenant_id) {
        this.tenant_id = tenant_id;
    }

    public String getImp_file_name() {
        return imp_file_name;
    }

    public void setImp_file_name(String imp_file_name) {
        this.imp_file_name = imp_file_name;
    }

    public String getImp_file_url() {
        return imp_file_url;
    }

    public void setImp_file_url(String imp_file_url) {
        this.imp_file_url = imp_file_url;
    }

    public String getData_type() {
        return data_type;
    }

    public void setData_type(String data_type) {
        this.data_type = data_type;
    }

    public String getObject_id() {
        return object_id;
    }

    public void setObject_id(String object_id) {
        this.object_id = object_id;
    }

    public String getBill_time_sn() {
        return bill_time_sn;
    }

    public void setBill_time_sn(String bill_time_sn) {
        this.bill_time_sn = bill_time_sn;
    }

    public Timestamp getImport_time() {
        return import_time;
    }

    public void setImport_time(Timestamp import_time) {
        this.import_time = import_time;
    }

    public Long getImport_records() {
        return import_records;
    }

    public void setImport_records(Long import_records) {
        this.import_records = import_records;
    }

    public String getBatch_no() {
        return batch_no;
    }

    public void setBatch_no(String batch_no) {
        this.batch_no = batch_no;
    }

    public String getRst_file_name() {
        return rst_file_name;
    }

    public void setRst_file_name(String rst_file_name) {
        this.rst_file_name = rst_file_name;
    }

    public String getRst_file_url() {
        return rst_file_url;
    }

    public void setRst_file_url(String rst_file_url) {
        this.rst_file_url = rst_file_url;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getState_desc() {
        return state_desc;
    }

    public void setState_desc(String state_desc) {
        this.state_desc = state_desc;
    }

    public String getOpt_dept_id() {
        return opt_dept_id;
    }

    public void setOpt_dept_id(String opt_dept_id) {
        this.opt_dept_id = opt_dept_id;
    }

    public String getOpt_oper_id() {
        return opt_oper_id;
    }

    public void setOpt_oper_id(String opt_oper_id) {
        this.opt_oper_id = opt_oper_id;
    }

}
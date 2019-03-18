package com.x.ic.smc.api.sysparammanage.param;

import java.sql.Timestamp;

import com.x.base.vo.BaseInfo;


public class SysParamInfo extends BaseInfo {

    private static final long serialVersionUID = 1L;

    /**
     * 流水主键 必填
     */
    private String guidkey;

    /**
     * 参数对应表名
     */
    private String typeCode;

    /**
     * 参数对应的字段
     */
    private String paramCode;

    /**
     * 参数编码
     */
    private String columnValue;

    /**
     * 参数显示值
     */
    private String columnDesc;

    /**
     * 参数子类
     */
    private String subParamCode;

    /**
     * 父级取值
     */
    private String parentValue;

    /**
     * 显示顺序
     */
    private Integer dispord;

    /**
     * 参详说明
     */
    private String descb;

    /**
     * 更新部门
     */
    private String updateDeptId;

    /**
     * 更新工号
     */
    private String updateOperId;

    /**
     * 更新时间
     */
    private Timestamp updateTime;

    public String getGuidkey() {
        return guidkey;
    }

    public void setGuidkey(String guidkey) {
        this.guidkey = guidkey == null ? null : guidkey.trim();
    }

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode == null ? null : typeCode.trim();
    }

    public String getParamCode() {
        return paramCode;
    }

    public void setParamCode(String paramCode) {
        this.paramCode = paramCode == null ? null : paramCode.trim();
    }

    public String getColumnValue() {
        return columnValue;
    }

    public void setColumnValue(String columnValue) {
        this.columnValue = columnValue == null ? null : columnValue.trim();
    }

    public String getColumnDesc() {
        return columnDesc;
    }

    public void setColumnDesc(String columnDesc) {
        this.columnDesc = columnDesc == null ? null : columnDesc.trim();
    }

    public String getSubParamCode() {
        return subParamCode;
    }

    public void setSubParamCode(String subParamCode) {
        this.subParamCode = subParamCode == null ? null : subParamCode.trim();
    }

    public String getParentValue() {
        return parentValue;
    }

    public void setParentValue(String parentValue) {
        this.parentValue = parentValue == null ? null : parentValue.trim();
    }

    public Integer getDispord() {
        return dispord;
    }

    public void setDispord(Integer dispord) {
        this.dispord = dispord;
    }

    public String getDescb() {
        return descb;
    }

    public void setDescb(String descb) {
        this.descb = descb == null ? null : descb.trim();
    }

    public String getUpdateDeptId() {
        return updateDeptId;
    }

    public void setUpdateDeptId(String updateDeptId) {
        this.updateDeptId = updateDeptId == null ? null : updateDeptId.trim();
    }

    public String getUpdateOperId() {
        return updateOperId;
    }

    public void setUpdateOperId(String updateOperId) {
        this.updateOperId = updateOperId == null ? null : updateOperId.trim();
    }

    public Timestamp getUpdateTime() {
        return updateTime == null ? null : new Timestamp(updateTime.getTime());
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = (updateTime == null ? null : new Timestamp(updateTime.getTime()));
    }

}

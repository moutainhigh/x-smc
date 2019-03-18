package com.x.ic.smc.api.querybillstyle.param;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import com.x.base.vo.BaseResponse;


public class QueryBillStyleInfo extends BaseResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 租户Id
     */
    private String tenantId;

    /**
     * 账单样式ID
     */
    private Long billStyleId;

    /**
     * 账单样式编码
     */
    private String billStyleSn;

    /**
     * 账单标题
     */
    private String billTitle;

    /**
     * 创建部门
     */
    private String createDeptId;

    /**
     * 创建工号
     */
    private String createOperId;

    /**
     * 创建时间
     */
    private Timestamp createTime;

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

    /**
     * 账单项
     */
    private List<QueryBillStyleVo> queryBillStyleVos;

    /**
     * 详单项
     */
    private List<QueryBillStyleDetailVo> queryBillStyleDetailVos;

    public String getBillStyleSn() {
        return billStyleSn;
    }

    public void setBillStyleSn(String billStyleSn) {
        this.billStyleSn = billStyleSn;
    }

    public String getBillTitle() {
        return billTitle;
    }

    public void setBillTitle(String billTitle) {
        this.billTitle = billTitle;
    }

    public String getCreateDeptId() {
        return createDeptId;
    }

    public void setCreateDeptId(String createDeptId) {
        this.createDeptId = createDeptId;
    }

    public String getCreateOperId() {
        return createOperId;
    }

    public void setCreateOperId(String createOperId) {
        this.createOperId = createOperId;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public Long getBillStyleId() {
        return billStyleId;
    }

    public void setBillStyleId(Long billStyleId) {
        this.billStyleId = billStyleId;
    }

    public String getUpdateDeptId() {
        return updateDeptId;
    }

    public void setUpdateDeptId(String updateDeptId) {
        this.updateDeptId = updateDeptId;
    }

    public String getUpdateOperId() {
        return updateOperId;
    }

    public void setUpdateOperId(String updateOperId) {
        this.updateOperId = updateOperId;
    }

    public List<QueryBillStyleVo> getQueryBillStyleVos() {
        return queryBillStyleVos;
    }

    public void setQueryBillStyleVos(List<QueryBillStyleVo> queryBillStyleVos) {
        this.queryBillStyleVos = queryBillStyleVos;
    }

    public List<QueryBillStyleDetailVo> getQueryBillStyleDetailVos() {
        return queryBillStyleDetailVos;
    }

    public void setQueryBillStyleDetailVos(List<QueryBillStyleDetailVo> queryBillStyleDetailVos) {
        this.queryBillStyleDetailVos = queryBillStyleDetailVos;
    }

    public Timestamp getCreateTime() {
        return createTime == null ? null : new Timestamp(createTime.getTime());
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = (createTime == null ? null : new Timestamp(createTime.getTime()));
    }

    public Timestamp getUpdateTime() {
        return updateTime == null ? null : new Timestamp(updateTime.getTime());
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = (updateTime == null ? null : new Timestamp(updateTime.getTime()));
    }

}

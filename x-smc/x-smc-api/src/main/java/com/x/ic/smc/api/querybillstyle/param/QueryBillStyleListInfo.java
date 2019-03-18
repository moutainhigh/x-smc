package com.x.ic.smc.api.querybillstyle.param;

import java.io.Serializable;
import java.sql.Timestamp;

import com.x.base.vo.BaseInfo;
import com.x.base.vo.PageInfo;


public class QueryBillStyleListInfo extends BaseInfo implements Serializable {

    private static final long serialVersionUID = 1L;

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
     * 状态
     */
    private String state;

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
     * 分页信息,分页查询时必填
     */
    private PageInfo<QueryBillStyleListVo> pageInfo;

    public Long getBillStyleId() {
        return billStyleId;
    }

    public void setBillStyleId(Long billStyleId) {
        this.billStyleId = billStyleId;
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

    public String getBillStyleSn() {
        return billStyleSn;
    }

    public void setBillStyleSn(String billStyleSn) {
        this.billStyleSn = billStyleSn;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
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

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    public PageInfo<QueryBillStyleListVo> getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfo<QueryBillStyleListVo> pageInfo) {
        this.pageInfo = pageInfo;
    }

}

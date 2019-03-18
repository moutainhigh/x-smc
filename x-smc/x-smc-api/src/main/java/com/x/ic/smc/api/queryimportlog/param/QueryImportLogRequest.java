package com.x.ic.smc.api.queryimportlog.param;

import com.x.base.vo.BaseInfo;
import com.x.base.vo.PageInfo;
import com.x.ic.smc.api.querybillstyle.param.QueryBillStyleListVo;

public class QueryImportLogRequest extends BaseInfo {

    private static final long serialVersionUID = 1L;

    /**
     * 文件名
     */
    private String impFileName;

    /**
     * 数据类型
     */
    private String dataType;

    /**
     * 数据对象
     */
    private String objectId;

    /**
     * 开始时间（这个时间以后）
     */
    private String startTime;

    /**
     * 结束时间（这个时间以前）
     */
    private String endTime;

    /**
     * 批次号
     */
    private String batchNo;

    /**
     * 状态
     */
    private String state;

    /**
     * 分页信息,分页查询时必填
     */
    private PageInfo<ImportLogVo> pageInfo;

    public String getImpFileName() {
        return impFileName;
    }

    public void setImpFileName(String impFileName) {
        this.impFileName = impFileName;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public String getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public PageInfo<ImportLogVo> getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfo<ImportLogVo> pageInfo) {
        this.pageInfo = pageInfo;
    }

}

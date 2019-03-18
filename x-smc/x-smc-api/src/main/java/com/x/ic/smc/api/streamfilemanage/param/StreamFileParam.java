package com.x.ic.smc.api.streamfilemanage.param;

import com.x.base.vo.BaseInfo;

public class StreamFileParam extends BaseInfo {

    private static final long serialVersionUID = 1L;

    /**
     * 操作工号
     */
    private String operId;

    /**
     * 操作部门
     */
    private String operDept;

    /**
     * 文件位置
     */
    private String filePosition;

    /**
     * 文件名
     */
    private String fileName;

    /**
     * 账期
     */
    private String accountPeriod;

    /**
     * 数据对象
     */
    private String dataObj;

    public String getOperId() {
        return operId;
    }

    public void setOperId(String operId) {
        this.operId = operId;
    }

    public String getOperDept() {
        return operDept;
    }

    public void setOperDept(String operDept) {
        this.operDept = operDept;
    }

    public String getFilePosition() {
        return filePosition;
    }

    public void setFilePosition(String filePosition) {
        this.filePosition = filePosition;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getAccountPeriod() {
        return accountPeriod;
    }

    public void setAccountPeriod(String accountPeriod) {
        this.accountPeriod = accountPeriod;
    }

    public String getDataObj() {
        return dataObj;
    }

    public void setDataObj(String dataObj) {
        this.dataObj = dataObj;
    }

}

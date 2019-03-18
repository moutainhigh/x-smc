package com.x.ic.smc.api.billdetail.param;

import com.x.base.vo.BaseInfo;

public class BillDetailDataImportRequest extends BaseInfo {
    private static final long serialVersionUID = 1L;

    /**
     * 账期
     */
    private String billTimeSn;

    /**
     * 数据对象
     */
    private String objectId;

    /**
     * 文件名
     */
    private String impFileName;

    /**
     * 文件位置
     */
    private String impFileUrl;

    /**
     * 操作部门
     */
    private String optDeptId;

    /**
     * 操作工号
     */
    private String optOperId;

    public static final class ObjectId {private ObjectId() {
    }
        /**
         * 短信流水
         */
        public static final String SMS = "sms";

        /**
         * 物流流水
         */
        public static final String EXP = "exp";

        /**
         * 短信业务
         */
        public static final String MVNE_MSG = "mvne-msg";

        /**
         * 物流业务
         */
        public static final String MVNE_WL = "mvne-wl";

        /**
         * 国证通业务
         */
        public static final String MVNE_GZT = "mvne-gzt";
    }

    public String getBillTimeSn() {
        return billTimeSn;
    }

    public void setBillTimeSn(String billTimeSn) {
        this.billTimeSn = billTimeSn;
    }

    public String getImpFileName() {
        return impFileName;
    }

    public void setImpFileName(String impFileName) {
        this.impFileName = impFileName;
    }

    public String getImpFileUrl() {
        return impFileUrl;
    }

    public void setImpFileUrl(String impFileUrl) {
        this.impFileUrl = impFileUrl;
    }

    public String getOptDeptId() {
        return optDeptId;
    }

    public void setOptDeptId(String optDeptId) {
        this.optDeptId = optDeptId;
    }

    public String getOptOperId() {
        return optOperId;
    }

    public void setOptOperId(String optOperId) {
        this.optOperId = optOperId;
    }

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }
}

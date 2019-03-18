package com.x.ic.smc.constants;

public final class SmcCacheConstant {
    private SmcCacheConstant() {
    }

    public static final String CACHE_KEY_SPLIT = ".";

    /**
     * 账单项
     */
    public static final String BILL_ITEM = "bill.item";

    /**
     * 详单项
     */
    public static final String BILL_DETAIL_ITEM = "bill.detail.item";

    /**
     * 政策列表
     */
    public static final String POLICY_ALL = "policy_all";

    public static final String POLICY_ITEM_CONDITION = "policy_item_condition";

    public static final String POLICY_ITEM = "policy_item";

    public static final String POLICY_ITEM_PLAN = "policy_item_plan";

    public static final class TypeCode {
        private TypeCode() {
        }

        public static final String STL_POLICY_ITEM_PLAN = "STL_POLICY_ITEM_PLAN";

        public static final String SFTP_CONF = "SFTP_CONF";

        public static final String AUTH = "AUTH";

        public static final String DATA_COLLECT = "data_collect";

    }

    public static final class ParamCode {
        private ParamCode() {
        }

        public static final String FEE_ITEM = "FEE_ITEM";

        public static final String USER_NAME = "USER_NAME";

        public static final String PWD = "PWD";

        public static final String USER_ID = "USER_ID";

        public static final String PAASWD = "PASSWD";

        public static final String URL = "url";
    }

    public static final class NameSpace {

        private NameSpace() {
        }
        
        public static final String SMC_CACHE_CLIENT = "com.x.ic.smc.cache";

        /**
         * sys_param
         */
        public static final String SYS_PARAM_CACHE = "com.x.ic.smc.cache.sysparam";

        public static final String POLICY_CACHE = "com.x.ic.smc.cache.policy";

        public static final String BILL_STYLE_CACHE = "com.x.ic.smc.cache.billstyle";

        public static final String ELEMENT_CACHE = "com.x.ic.smc.cache.element";

        /**
         * redis计数
         */
        public static final String CHECK_COUNT_CACHE = "com.x.ic.smc.cache.check.count";

        public static final String OBJECT_ELEMENT_CACHE = "com.x.ic.smc.cache.ObjectToElementCache";

        public static final String OBJECT_POLICY_CACHE = "com.x.ic.smc.cache.ObjectToPolicyCache";

        public static final String POLICY_ELEMENT_CACHE = "com.x.ic.smc.cache.PolicyToElementCache";

        public static final String STL_ELEMENT_ATTR_CACHE = "com.x.ic.smc.cache.StlElementAttrCache";

    }

    public static final class Dshm {private Dshm() {
    }
        public static final class TableName {private TableName() {
        }
            public static final String STL_IMPORT_LOG = "stl_import_log";
        }

        public static final class FieldName {private FieldName() {
        }

            public static final String TENANT_ID = "tenant_id";

            public static final String BATCH_NO = "batch_no";

            public static final String BILL_TIME_SN = "bill_time_sn";

            public static final String OBJECT_ID = "object_id";

            public static final String LOG_ID = "log_id";

        }

        public static final class OptType {private OptType() {
        }
            public static final int INSERT = 1;

            public static final int UPDATE = 0;
        }
    }
}

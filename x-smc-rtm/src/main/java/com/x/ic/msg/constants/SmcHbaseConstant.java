package com.x.ic.msg.constants;

public final class SmcHbaseConstant {
    private SmcHbaseConstant() {
    }

    public static final String ROWKEY_SPLIT = "_";

    public static final class TableName {private TableName() {
    }
        public static final String STL_BILL_DETAIL_DIFF_DATA = "stl_bill_detail_diff_data";

        /**
         * 详单数据表
         */
        public static final String STL_BILL_DETAIL_DATA = "stl_bill_detail_data";

    }

    public static final class ColumnName {private ColumnName() {
    }

        public static final String FEE_ITEM_ID = "fee_item_id";

        public static final String ITEM_FEE = "item_fee";

        public static final String BILL_DETAIL_ID = "bill_detail_id";

        public static final String DIFF_FEE = "diff_fee";

        public static final String CHECK_STATE = "check_state";

        public static final String ORDER_ID = "order_id";

        public static final String STL_ORDER_DATA_KEY = "stl_order_data_key";

        public static final String CHECK_STATE_DESC = "check_state_desc";

        public static final String VERIFY_STATE = "verify_state";

        public static final String VERIFY_DESC = "verify_desc";

        public static final String BILL_ID = "bill_id";

        public static final String TENANT_ID = "tenant_id";

        public static final String OBJECT_ID = "object_id";

        public static final String BILL_FROM = "bill_from";

        public static final String BATCH_NO = "batch_no";

        public static final String TOTAL_RECORD = "total_record";

        public static final String TOTAL_FEE = "total_fee";

    }

    /**
     * 列族<br>
     * Date: 2016年4月14日 <br>
     * Copyright (c) 2016 asiainfo.com <br>
     * 
     * @author mayt
     */
    public static final class FamilyName {private FamilyName() {
    }
        /**
         * 默认列族名
         */
        public static final String COLUMN_DEF = "col_def";
    }
}

package com.x.ic.msg.constants;

public final class SmcConstants {
	
	public final static String MDS_NS_SMC_DETAILED_TOPIC = "MDS_NS_SMC_DETAILED_TOPIC";
	
    private SmcConstants() {
    }

    public final static String CHARSET_UTF8 = "UTF-8";
    
    public final static String CHARSET_GBK = "GBK";

    public static final String FIELD_SPLIT = new String(new char[] { (char) 1 });

    public static final String RECORD_SPLIT = new String(new char[] { (char) 2 });

    public static final String HEADER_SPLIT = new String(new char[] { (char) 3 });

    public static final String CVSFILE_FEILD_SPLIT = ",";

    /**
     * 基础元素表<br>
     * Date: 2016年3月17日 <br>
     * Copyright (c) 2016 asiainfo.com <br>
     * 
     * @author mayt
     */
    public static final class StlElement {
        private StlElement() {
        }

        /**
         * 是否结算对象<br>
         * 1：是 0：否<br>
         * Date: 2016年3月17日 <br>
         * Copyright (c) 2016 asiainfo.com <br>
         * 
         * @author mayt
         */
        public static final class IsSettlement {
            private IsSettlement() {
            }

            public static final String YES = "1";

            public static final String NO = "0";
        }

        /**
         * 状态<br>
         * Date: 2016年3月17日 <br>
         * Copyright (c) 2016 asiainfo.com <br>
         * 
         * @author mayt
         */
        public static final class State {
            private State() {
            }

            /**
             * 正常
             */
            public static final String NORMAL = "1";

            /**
             * 注销
             */
            public static final String CANCELLED = "0";
        }

        public static final class Type {
            private Type() {
            }

            /**
             * 统计属性
             */
            public static final String STATISTICS = "statistics";

            /**
             * 数值合计
             */
            public static final String VALUE_SUM = "value_sum";

            /**
             * int
             */
            public static final String INT = "int";

            /**
             * float
             */
            public static final String FLOAT = "float";

            /**
             * enum
             */
            public static final String ENUM = "enum";

            /**
             * string
             */
            public static final String STRING = "string";
        }

        /**
         * 是否必填<br>
         * Date: 2016年4月16日 <br>
         * Copyright (c) 2016 asiainfo.com <br>
         * 
         * @author mayt
         */
        public static final class IsNecessary {
            private IsNecessary() {
            }

            public static final String YES = "1";

            public static final String NO = "0";
        }
        public static final class IsPrimaryKey {
            private IsPrimaryKey() {
            }

            public static final String YES = "1";

            public static final String NO = "0";
        }
        public static final class ElementType {
            private ElementType() {
            }

            public static final String TIMESTAMP = "3";
        }
    }

    /**
     * 账单格式定义<br>
     * Date: 2016年3月17日 <br>
     * Copyright (c) 2016 asiainfo.com <br>
     * 
     * @author mayt
     */
    public static class StlBillStyle {
        private StlBillStyle() {
        }

        public static class State {
            private State() {
            }

            /**
             * 正常
             */
            public static final String NORMAL = "1";

            /**
             * 注销
             */
            public static final String CANCELLED = "0";
        }
    }
    public static final class StlPolicyItemCondition{
    	private StlPolicyItemCondition(){};
    	public static final class DataFormat{
    		public static final String FILE = "FILE";
    		public static final String MQ = "MQ";
    	}
    	
    }
    public static final class StlPolicyItemPlan {
        private StlPolicyItemPlan() {
        }

        /**
         * 策略类型<br>
         * Date: 2016年3月17日 <br>
         * Copyright (c) 2016 asiainfo.com <br>
         * 
         * @author mayt
         */
        public static final class PlanType {
            private PlanType() {
            }

            /**
             * 标准
             */
            public static final String NORMAL = "normal";

            /**
             * 阶梯
             */
            public static final String STEP = "step";

            /**
             * 分档
             */
            public static final String GRADING = "switch";
        }

        public static final class CalType {
            private CalType() {
            }

            /**
             * 按比例
             */
            public static final String RATIO = "ratio";

            /**
             * 按固定金额
             */
            public static final String FIXED = "fixed";

            /**
             * 单价
             */
            public static final String PRICE = "price";
        }
    }

    public static final class StlPolicy {
        private StlPolicy() {
        }

        /**
         * 执行周期枚举值<br>
         * Date: 2016年3月17日 <br>
         * Copyright (c) 2016 asiainfo.com <br>
         * 
         * @author mayt
         */
        public static final class ExecCycle {
            private ExecCycle() {
            }

            /**
             * 实时
             */
            public static final String REALTIME = "realtime";

            /**
             * 天
             */
            public static final String DAY = "day";

            /**
             * 周
             */
            public static final String WEEK = "week";

            /**
             * 月
             */
            public static final String MONTH = "month";

            /**
             * 年
             */
            public static final String YEAR = "year";
        }

        /**
         * 政策对应业务数据 <br>
         * Date: 2016年3月22日 <br>
         * Copyright (c) 2016 asiainfo.com <br>
         * 
         * @author mayt
         */
        public static final class DataObjectId {
            private DataObjectId() {
            }

            /**
             * 客户
             */
            public static final String CUST = "cust";

            /**
             * 订购
             */
            public static final String SUBS = "subs";

            /**
             * 使用流水
             */
            public static final String ORDER = "order";
        }

        /**
         * 对账标识 Date: 2016年3月22日 <br>
         * Copyright (c) 2016 asiainfo.com <br>
         * 
         * @author mayt
         */
        public static final class CheckFeeFlag {
            private CheckFeeFlag() {
            }

            /**
             * 是
             */
            public static final String YES = "1";

            /**
             * 否
             */
            public static final String NO = "0";
        }

        /**
         * 政策状态<br>
         * Date: 2016年3月17日 <br>
         * Copyright (c) 2016 asiainfo.com <br>
         * 
         * @author mayt
         */
        public static final class State {
            private State() {
            }

            /**
             * 正常
             */
            public static final String NORMAL = "1";

            /**
             * 注销
             */
            public static final String CANCELLED = "0";
        }
    }

    public static final class StlSysParam {
        private StlSysParam() {
        }

        public static final class State {
            private State() {
            }

            /**
             * 正常
             */
            public static final String NORMAL = "1";

            /**
             * 失效
             */
            public static final String INVALID = "0";
        }
    }

    public static final class StlImportLog {
        private StlImportLog() {
        }

        public static final class DataType {
            private DataType() {
            }

            /**
             * 业务流水
             */
            public static final String ORDER = "order";

            /**
             * 账单
             */
            public static final String BILL = "bill";
        }

        public static final class State {
            private State() {
            }

            /**
             * 已上传
             */
            public static final String uploaded = "0";

            /**
             * 导入处理中
             */
            public static final String IMPORT_PROCESSING = "1";

            /**
             * 导入完成
             */
            public static final String IMPORT_SUCCESS = "2";

            /**
             * 数据处理中
             */
            public static final String DATA_PROCESSING = "3";

            /**
             * 数据处理完成
             */
            public static final String DATA_SUCCESS = "4";

            /**
             * 异常
             */
            public static final String EXCEPTION = "9";
        }

        public static final class StateDesc {
            private StateDesc() {
            }

            public static final String uploaded = "已上传";

            public static final String IMPORT_PROCESSING = "导入处理中";

            public static final String IMPORT_SUCCESS = "导入完成";

            public static final String DATA_PROCESSING = "数据处理中";

            public static final String DATA_SUCCESS = "数据处理完成";

            public static final String EXCEPTION = "异常";
        }
    }

    public static final class StlBillData {
        private StlBillData() {
        }

        public static final class BillFrom {
            private BillFrom() {
            }

            /**
             * 系统生成
             */
            public static final String SYS = "sys";

            /**
             * 第三方导入
             */
            public static final String IMPORT = "3pl";
        }

        public static final class CheckState {
            private CheckState() {
            }

            /**
             * 一致
             */
            public static final String UNANIMOUS = "3";

            /**
             * 不一致
             */
            public static final String INCONFORMITY = "4";
        }

        public static final class CheckStateDesc {
            private CheckStateDesc() {
            }

            /**
             * 账单一致
             */
            public static final String BILL_UNANIMOUS = "账单一致";

            /**
             * 有差异
             */
            public static final String HAS_DIFFERENCE = "有差异";
        }
    }

    public static final class StlBillItemData {
        private StlBillItemData() {
        }

        public static final class ItemType {
            private ItemType() {
            }

            /**
             * 正常科目
             */
            public static final String NORMAL = "1";

            /**
             * 调账科目
             */
            public static final String ADJUST = "2";
        }

        public static final class CheckState {
            private CheckState() {
            }

            /**
             * 一致
             */
            public static final String UNANIMOUS = "1";

            /**
             * 不一致
             */
            public static final String INCONFORMITY = "2";
        }

        public static final class CheckStateDesc {
            private CheckStateDesc() {
            }

            /**
             * 一致
             */
            public static final String UNANIMOUS = "一致";

            /**
             * 不一致
             */
            public static final String INCONFORMITY = "不一致";
        }

        public static final class VerifyState {
            private VerifyState() {
            }

            /**
             * 通过
             */
            public static final String PASS = "1";

            /**
             * 不通过
             */
            public static final String NOT_PASS = "0";
        }

    }

    public static final class SpoutBusiType {
        private SpoutBusiType() {
        }

        public static final String SMC_CHECK = "smc-check";
    }

    public static final class StlBillDetailDiffData {
        private StlBillDetailDiffData() {
        }

        public static final class CheckState {
            private CheckState() {
            }

            /**
             * 一致
             */
            public static final String SAME = "1";

            /**
             * 不一致
             */
            public static final String DIFF = "2";
        }
    }

    public static final class StlBillDetailStyleItem {
        private StlBillDetailStyleItem() {
        }

        public static final class IsSplitItem {
            private IsSplitItem() {
            }

            public static final String YES = "YES";

            public static final String NO = "NO";
        }
    }

    public static final class StlNode{
    	private StlNode(){};
    	
    	public static final class State{
    		/**
             * 正常
             */
            public static final String NORMAL = "1";

            /**
             * 注销
             */
            public static final String CANCELLED = "0";
    	}
    	public static final class Check{
    		/**
             * 正常
             */
            public static final String YES = "Y";

            /**
             * 注销
             */
            public static final String NO = "N";
    	}
//    	1：String
//    	2：Number
//    	3：Object
//    	4：DATE
//    	7：JsonArray
//    	8：JSON
//    	9：XML
    	public static final class NodeType{
    		public static final String STRING = "1";
    		public static final String NUMBER = "2";
    		public static final String OBJECT = "3";
    		public static final String DATA = "4";
    		public static final String JAONARRAY = "7";
    		public static final String JSON = "8";
    		public static final String XML = "9";
    	}
    	
    	
    }
    public static final class StlNodeElementMapping{
    	private StlNodeElementMapping(){};
    	
    	public static final class State{
    		/**
             * 正常
             */
            public static final String NORMAL = "1";

            /**
             * 注销
             */
            public static final String CANCELLED = "0";
    	}
    	
    }
    public static final class MdsState{
    	private MdsState(){};
    	/**
         * 正常
         */
        public static final String NORMAL = "1";

        /**
         * 注销
         */
        public static final String CANCELLED = "0";
    }
    public static final class MdsType{
    	private MdsType(){};
    	/**
         * 自动启动
         */
        public static final String AUTO = "0";

        /**
         * 手动启动
         */
        public static final String MANUAL = "1";
    }
    public static final class Hbase{
    	private Hbase(){};
    	/**
         * 源数据错单表
         */
        public static final String MESSAGE_INPUT_SRC_FAILURE = "MESSAGE_INPUT_SRC_FAILURE";


    }
}

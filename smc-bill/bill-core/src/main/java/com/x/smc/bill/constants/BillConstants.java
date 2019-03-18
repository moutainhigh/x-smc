package com.x.smc.bill.constants;

/**
 * 系统变量
 * @author wangluyang
 *
 */
public final class BillConstants {
	private BillConstants(){}
	
	public static final class NameSpace{
		private NameSpace() {}
		public static final String BILL_CACHE_CLIENT = "com.x.smc.bill.cache";
	}
	
	public static final class RunStatus{
		private RunStatus(){}
		public static final String FREE = "0";//0：空闲
		public static final String RUNNING = "1";//1：正在执行
	}
	
	public static final class Status{
		private Status(){}
		public static final String DELETED = "0";//0：删除
		public static final String EFFECTIVE = "1";//1：生效
	}
	
	/**
	 * 详单vo
	 * @author wangluyang
	 *
	 */
	public static final class BillDetailVo{
		private BillDetailVo() {}
		public static final String TENANT_ID = "tenant_id";
		public static final String POLICY_ID = "policy_id";
		/**
		 * 
		 */
		public static final String POLICY_CYCLE_ID = "policyCycleId";
		public static final String BSN = "bsn";
		public static final String ORIG_FEE = "orig_fee";
		public static final String BILL_ID = "bill_id";
		public static final String BILL_FROM = "bill_from";
		public static final String FEE_ITEM_ID = "fee_item_id";
		public static final String TOTAL_FEE = "total_fee";
		public static final String OBJECT_TYPE = "object_type";
		public static final String OBJECT_CODE = "object_code";
		public static final String MSG_HEADER = "msg_header";
		public static final String MSG_BODY = "msg_body";
	}
	
	public static final class PolicyBillPlan{
		private PolicyBillPlan() {}
		
		public static final class CalElementType{
			private CalElementType() {}
			public static final String PRICE = "price";
			public static final String COUNT = "count";
		}
		
		public static final class RuleType{
			private RuleType() {}
			public static final String FIXED = "fixed";
			public static final String EXP = "exp";
		}
	}
	
	/**
	 * 时间单位
	 * @author wangluyang
	 *
	 */
	public static final class TimeUnit{
		private TimeUnit(){}
		/**
		 * 小时
		 */
		public static final String HOUR="hour";
		/**
		 * 天
		 */
		public static final String DAY="day";
		/**
		 * 周
		 */
		public static final String WEEK="week";
		/**
		 * 月
		 */
		public static final String MONTH="month";
		/**
		 * 季度
		 */
		public static final String QUARTER="quarter";
		/**
		 * 年
		 */
		public static final String YEAR="year";
	}
	
	public static final class Seq{

		private Seq() {}
		/**
		 * 账单
		 */
		public static final String STL_BILL_DATA_BILL_ID_SEQ = "STL_BILL_DATA$BILL_ID$SEQ";
		
		
	}
	
	public static final String BILL_DETAIL_HBASE_FAMILY_NAME = "bill_col_def";
}

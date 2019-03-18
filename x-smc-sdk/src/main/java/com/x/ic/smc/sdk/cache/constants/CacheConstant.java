package com.x.ic.smc.sdk.cache.constants;

public final class CacheConstant {
    private CacheConstant() {
    }
    public static final String MSDNS = "com.x.smc.msg.order";
   
    public static final class NameSpace {

        private NameSpace() {
        }
        
        public static final String SMC_CACHE_CLIENT = "com.x.ic.smc.cache";

        /**
         * sys_param
         */
        public static final String SYS_PARAM_CACHE = "com.x.ic.smc.cache.sysparam";

        public static final String POLICY_CACHE = "com.x.ic.smc.cache.policy";
        public static final String POLICY_INSTN_CACHE = "com.x.ic.smc.cache.policyInstn";
        public static final String POLICY_ITEM_CACHE = "com.x.ic.smc.cache.policyItem";
        public static final String POLICY_ITEM_PLAN_CACHE = "com.x.ic.smc.cache.policyItemPlan";
        public static final String POLICY_ITEM_PLAN_CACHE_INSTN = "com.x.ic.smc.cache.policyItemPlanInstn";
        public static final String POLICY_ITEM_CONDITION_CACHE = "com.x.ic.smc.cache.policyItemCondition";
        public static final String BILL_STYLE_CACHE = "com.x.ic.smc.cache.billstyle";

        public static final String ELEMENT_CACHE = "com.x.ic.smc.cache.element";
        
        public static final String NODE_CACHE = "com.x.ic.smc.cache.node";
        
        public static final String NODE_ELEMENT_MAPPING_CACHE = "com.x.ic.smc.cache.nodeelementmapping";
        
        public static final String POLICY_BILL_PLAN_CACHE = "com.x.ic.smc.cache.policybillplan";

        /**
         * redis计数
         */
        public static final String CHECK_COUNT_CACHE = "com.x.ic.smc.cache.check.count";

        public static final String OBJECT_ELEMENT_CACHE = "com.x.ic.smc.cache.ObjectToElementCache";

        public static final String OBJECT_POLICY_CACHE = "com.x.ic.smc.cache.ObjectToPolicyCache";

        public static final String POLICY_ELEMENT_CACHE = "com.x.ic.smc.cache.PolicyToElementCache";

        public static final String STL_ELEMENT_ATTR_CACHE = "com.x.ic.smc.cache.StlElementAttrCache";

        public static final String POLICY_TASK_CYCLE = "com.x.ic.smc.cache.policyTaskCycle";
    }

 
}

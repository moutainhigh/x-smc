package com.x.ic.msg.dao.mapper.interfaces;

import com.x.ic.msg.dao.mapper.bo.StlPolicyBillPlan;
import com.x.ic.msg.dao.mapper.bo.StlPolicyBillPlanCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StlPolicyBillPlanMapper {
    int countByExample(StlPolicyBillPlanCriteria example);

    int deleteByExample(StlPolicyBillPlanCriteria example);

    int deleteByPrimaryKey(Long billPlanId);

    int insert(StlPolicyBillPlan record);

    int insertSelective(StlPolicyBillPlan record);

    List<StlPolicyBillPlan> selectByExample(StlPolicyBillPlanCriteria example);

    StlPolicyBillPlan selectByPrimaryKey(Long billPlanId);

    int updateByExampleSelective(@Param("record") StlPolicyBillPlan record, @Param("example") StlPolicyBillPlanCriteria example);

    int updateByExample(@Param("record") StlPolicyBillPlan record, @Param("example") StlPolicyBillPlanCriteria example);

    int updateByPrimaryKeySelective(StlPolicyBillPlan record);

    int updateByPrimaryKey(StlPolicyBillPlan record);
}
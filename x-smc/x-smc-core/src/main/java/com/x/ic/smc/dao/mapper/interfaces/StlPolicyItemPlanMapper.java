package com.x.ic.smc.dao.mapper.interfaces;

import com.x.ic.smc.dao.mapper.bo.StlPolicyItemPlan;
import com.x.ic.smc.dao.mapper.bo.StlPolicyItemPlanCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StlPolicyItemPlanMapper {
    int countByExample(StlPolicyItemPlanCriteria example);

    int deleteByExample(StlPolicyItemPlanCriteria example);

    int deleteByPrimaryKey(Long planId);

    int insert(StlPolicyItemPlan record);

    int insertSelective(StlPolicyItemPlan record);

    List<StlPolicyItemPlan> selectByExample(StlPolicyItemPlanCriteria example);

    StlPolicyItemPlan selectByPrimaryKey(Long planId);

    int updateByExampleSelective(@Param("record") StlPolicyItemPlan record, @Param("example") StlPolicyItemPlanCriteria example);

    int updateByExample(@Param("record") StlPolicyItemPlan record, @Param("example") StlPolicyItemPlanCriteria example);

    int updateByPrimaryKeySelective(StlPolicyItemPlan record);

    int updateByPrimaryKey(StlPolicyItemPlan record);
}
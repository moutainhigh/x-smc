package com.x.ic.smc.dao.mapper.interfaces;

import com.x.ic.smc.dao.mapper.bo.StlPolicyItemCondition;
import com.x.ic.smc.dao.mapper.bo.StlPolicyItemConditionCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StlPolicyItemConditionMapper {
    int countByExample(StlPolicyItemConditionCriteria example);

    int deleteByExample(StlPolicyItemConditionCriteria example);

    int deleteByPrimaryKey(Long conditionId);

    int insert(StlPolicyItemCondition record);

    int insertSelective(StlPolicyItemCondition record);

    List<StlPolicyItemCondition> selectByExample(StlPolicyItemConditionCriteria example);

    StlPolicyItemCondition selectByPrimaryKey(Long conditionId);

    int updateByExampleSelective(@Param("record") StlPolicyItemCondition record, @Param("example") StlPolicyItemConditionCriteria example);

    int updateByExample(@Param("record") StlPolicyItemCondition record, @Param("example") StlPolicyItemConditionCriteria example);

    int updateByPrimaryKeySelective(StlPolicyItemCondition record);

    int updateByPrimaryKey(StlPolicyItemCondition record);
}
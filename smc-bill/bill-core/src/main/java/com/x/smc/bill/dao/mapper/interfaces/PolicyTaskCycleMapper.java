package com.x.smc.bill.dao.mapper.interfaces;

import com.x.smc.bill.dao.mapper.bo.PolicyTaskCycle;
import com.x.smc.bill.dao.mapper.bo.PolicyTaskCycleCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PolicyTaskCycleMapper {
    int countByExample(PolicyTaskCycleCriteria example);

    int deleteByExample(PolicyTaskCycleCriteria example);

    int deleteByPrimaryKey(String policyCycleId);

    int insert(PolicyTaskCycle record);

    int insertSelective(PolicyTaskCycle record);

    List<PolicyTaskCycle> selectByExample(PolicyTaskCycleCriteria example);

    PolicyTaskCycle selectByPrimaryKey(String policyCycleId);

    int updateByExampleSelective(@Param("record") PolicyTaskCycle record, @Param("example") PolicyTaskCycleCriteria example);

    int updateByExample(@Param("record") PolicyTaskCycle record, @Param("example") PolicyTaskCycleCriteria example);

    int updateByPrimaryKeySelective(PolicyTaskCycle record);

    int updateByPrimaryKey(PolicyTaskCycle record);
}
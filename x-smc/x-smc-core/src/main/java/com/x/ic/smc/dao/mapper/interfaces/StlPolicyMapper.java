package com.x.ic.smc.dao.mapper.interfaces;

import com.x.ic.smc.dao.mapper.bo.StlPolicy;
import com.x.ic.smc.dao.mapper.bo.StlPolicyCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StlPolicyMapper {
    int countByExample(StlPolicyCriteria example);

    int deleteByExample(StlPolicyCriteria example);

    int deleteByPrimaryKey(Long policyId);

    int insert(StlPolicy record);

    int insertSelective(StlPolicy record);

    List<StlPolicy> selectByExample(StlPolicyCriteria example);

    StlPolicy selectByPrimaryKey(Long policyId);

    int updateByExampleSelective(@Param("record") StlPolicy record, @Param("example") StlPolicyCriteria example);

    int updateByExample(@Param("record") StlPolicy record, @Param("example") StlPolicyCriteria example);

    int updateByPrimaryKeySelective(StlPolicy record);

    int updateByPrimaryKey(StlPolicy record);
}
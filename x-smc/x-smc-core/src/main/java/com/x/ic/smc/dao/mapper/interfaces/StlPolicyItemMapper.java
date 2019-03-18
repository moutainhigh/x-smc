package com.x.ic.smc.dao.mapper.interfaces;

import com.x.ic.smc.dao.mapper.bo.StlPolicyItem;
import com.x.ic.smc.dao.mapper.bo.StlPolicyItemCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StlPolicyItemMapper {
    int countByExample(StlPolicyItemCriteria example);

    int deleteByExample(StlPolicyItemCriteria example);

    int deleteByPrimaryKey(Long itemId);

    int insert(StlPolicyItem record);

    int insertSelective(StlPolicyItem record);

    List<StlPolicyItem> selectByExample(StlPolicyItemCriteria example);

    StlPolicyItem selectByPrimaryKey(Long itemId);

    int updateByExampleSelective(@Param("record") StlPolicyItem record, @Param("example") StlPolicyItemCriteria example);

    int updateByExample(@Param("record") StlPolicyItem record, @Param("example") StlPolicyItemCriteria example);

    int updateByPrimaryKeySelective(StlPolicyItem record);

    int updateByPrimaryKey(StlPolicyItem record);
}
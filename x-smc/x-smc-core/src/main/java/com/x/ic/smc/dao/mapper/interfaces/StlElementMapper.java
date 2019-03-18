package com.x.ic.smc.dao.mapper.interfaces;

import com.x.ic.smc.dao.mapper.bo.StlElement;
import com.x.ic.smc.dao.mapper.bo.StlElementCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StlElementMapper {
    int countByExample(StlElementCriteria example);

    int deleteByExample(StlElementCriteria example);

    int deleteByPrimaryKey(Long elementId);

    int insert(StlElement record);

    int insertSelective(StlElement record);

    List<StlElement> selectByExample(StlElementCriteria example);

    StlElement selectByPrimaryKey(Long elementId);

    int updateByExampleSelective(@Param("record") StlElement record, @Param("example") StlElementCriteria example);

    int updateByExample(@Param("record") StlElement record, @Param("example") StlElementCriteria example);

    int updateByPrimaryKeySelective(StlElement record);

    int updateByPrimaryKey(StlElement record);
}
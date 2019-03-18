package com.x.ic.smc.dao.mapper.interfaces;

import com.x.ic.smc.dao.mapper.bo.StlTest;
import com.x.ic.smc.dao.mapper.bo.StlTestCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StlTestMapper {
    int countByExample(StlTestCriteria example);

    int deleteByExample(StlTestCriteria example);

    int insert(StlTest record);

    int insertSelective(StlTest record);

    List<StlTest> selectByExample(StlTestCriteria example);

    int updateByExampleSelective(@Param("record") StlTest record, @Param("example") StlTestCriteria example);

    int updateByExample(@Param("record") StlTest record, @Param("example") StlTestCriteria example);
}
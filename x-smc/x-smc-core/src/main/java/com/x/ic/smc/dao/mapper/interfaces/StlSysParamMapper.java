package com.x.ic.smc.dao.mapper.interfaces;

import com.x.ic.smc.dao.mapper.bo.StlSysParam;
import com.x.ic.smc.dao.mapper.bo.StlSysParamCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StlSysParamMapper {
    int countByExample(StlSysParamCriteria example);

    int deleteByExample(StlSysParamCriteria example);

    int deleteByPrimaryKey(String guidkey);

    int insert(StlSysParam record);

    int insertSelective(StlSysParam record);

    List<StlSysParam> selectByExample(StlSysParamCriteria example);

    StlSysParam selectByPrimaryKey(String guidkey);

    int updateByExampleSelective(@Param("record") StlSysParam record, @Param("example") StlSysParamCriteria example);

    int updateByExample(@Param("record") StlSysParam record, @Param("example") StlSysParamCriteria example);

    int updateByPrimaryKeySelective(StlSysParam record);

    int updateByPrimaryKey(StlSysParam record);
}
package com.x.ic.smc.dao.mapper.interfaces;

import com.x.ic.smc.dao.mapper.bo.StlImportLog;
import com.x.ic.smc.dao.mapper.bo.StlImportLogCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StlImportLogMapper {
    int countByExample(StlImportLogCriteria example);

    int deleteByExample(StlImportLogCriteria example);

    int deleteByPrimaryKey(Long logId);

    int insert(StlImportLog record);

    int insertSelective(StlImportLog record);

    List<StlImportLog> selectByExample(StlImportLogCriteria example);

    StlImportLog selectByPrimaryKey(Long logId);

    int updateByExampleSelective(@Param("record") StlImportLog record, @Param("example") StlImportLogCriteria example);

    int updateByExample(@Param("record") StlImportLog record, @Param("example") StlImportLogCriteria example);

    int updateByPrimaryKeySelective(StlImportLog record);

    int updateByPrimaryKey(StlImportLog record);
}
package com.x.smc.bill.dao.mapper.interfaces;

import com.x.smc.bill.dao.mapper.bo.StlCalDataRecord;
import com.x.smc.bill.dao.mapper.bo.StlCalDataRecordCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StlCalDataRecordMapper {
    int countByExample(StlCalDataRecordCriteria example);

    int deleteByExample(StlCalDataRecordCriteria example);

    int deleteByPrimaryKey(Long recordId);

    int insert(StlCalDataRecord record);

    int insertSelective(StlCalDataRecord record);

    List<StlCalDataRecord> selectByExample(StlCalDataRecordCriteria example);

    StlCalDataRecord selectByPrimaryKey(Long recordId);

    int updateByExampleSelective(@Param("record") StlCalDataRecord record, @Param("example") StlCalDataRecordCriteria example);

    int updateByExample(@Param("record") StlCalDataRecord record, @Param("example") StlCalDataRecordCriteria example);

    int updateByPrimaryKeySelective(StlCalDataRecord record);

    int updateByPrimaryKey(StlCalDataRecord record);
}
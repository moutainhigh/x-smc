package com.x.ic.smc.dao.mapper.interfaces;

import com.x.ic.smc.dao.mapper.bo.StlBillData;
import com.x.ic.smc.dao.mapper.bo.StlBillDataCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StlBillDataMapper {
    int countByExample(StlBillDataCriteria example);

    int deleteByExample(StlBillDataCriteria example);

    int deleteByPrimaryKey(Long billId);

    int insert(StlBillData record);

    int insertSelective(StlBillData record);

    List<StlBillData> selectByExample(StlBillDataCriteria example);

    StlBillData selectByPrimaryKey(Long billId);

    int updateByExampleSelective(@Param("record") StlBillData record, @Param("example") StlBillDataCriteria example);

    int updateByExample(@Param("record") StlBillData record, @Param("example") StlBillDataCriteria example);

    int updateByPrimaryKeySelective(StlBillData record);

    int updateByPrimaryKey(StlBillData record);
}
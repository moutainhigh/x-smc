package com.x.ic.smc.dao.mapper.interfaces;

import com.x.ic.smc.dao.mapper.bo.StlBillItemData;
import com.x.ic.smc.dao.mapper.bo.StlBillItemDataCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StlBillItemDataMapper {
    int countByExample(StlBillItemDataCriteria example);

    int deleteByExample(StlBillItemDataCriteria example);

    int deleteByPrimaryKey(Long billItemId);

    int insert(StlBillItemData record);

    int insertSelective(StlBillItemData record);

    List<StlBillItemData> selectByExample(StlBillItemDataCriteria example);

    StlBillItemData selectByPrimaryKey(Long billItemId);

    int updateByExampleSelective(@Param("record") StlBillItemData record, @Param("example") StlBillItemDataCriteria example);

    int updateByExample(@Param("record") StlBillItemData record, @Param("example") StlBillItemDataCriteria example);

    int updateByPrimaryKeySelective(StlBillItemData record);

    int updateByPrimaryKey(StlBillItemData record);
}
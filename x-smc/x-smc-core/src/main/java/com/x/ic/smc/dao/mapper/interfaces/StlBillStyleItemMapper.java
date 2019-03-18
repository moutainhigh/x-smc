package com.x.ic.smc.dao.mapper.interfaces;

import com.x.ic.smc.dao.mapper.bo.StlBillStyleItem;
import com.x.ic.smc.dao.mapper.bo.StlBillStyleItemCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StlBillStyleItemMapper {
    int countByExample(StlBillStyleItemCriteria example);

    int deleteByExample(StlBillStyleItemCriteria example);

    int deleteByPrimaryKey(Long itemId);

    int insert(StlBillStyleItem record);

    int insertSelective(StlBillStyleItem record);

    List<StlBillStyleItem> selectByExample(StlBillStyleItemCriteria example);

    StlBillStyleItem selectByPrimaryKey(Long itemId);

    int updateByExampleSelective(@Param("record") StlBillStyleItem record, @Param("example") StlBillStyleItemCriteria example);

    int updateByExample(@Param("record") StlBillStyleItem record, @Param("example") StlBillStyleItemCriteria example);

    int updateByPrimaryKeySelective(StlBillStyleItem record);

    int updateByPrimaryKey(StlBillStyleItem record);
}
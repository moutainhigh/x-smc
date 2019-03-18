package com.x.ic.smc.dao.mapper.interfaces;

import com.x.ic.smc.dao.mapper.bo.StlBillDetailStyleItem;
import com.x.ic.smc.dao.mapper.bo.StlBillDetailStyleItemCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StlBillDetailStyleItemMapper {
    int countByExample(StlBillDetailStyleItemCriteria example);

    int deleteByExample(StlBillDetailStyleItemCriteria example);

    int deleteByPrimaryKey(Long itemId);

    int insert(StlBillDetailStyleItem record);

    int insertSelective(StlBillDetailStyleItem record);

    List<StlBillDetailStyleItem> selectByExample(StlBillDetailStyleItemCriteria example);

    StlBillDetailStyleItem selectByPrimaryKey(Long itemId);

    int updateByExampleSelective(@Param("record") StlBillDetailStyleItem record, @Param("example") StlBillDetailStyleItemCriteria example);

    int updateByExample(@Param("record") StlBillDetailStyleItem record, @Param("example") StlBillDetailStyleItemCriteria example);

    int updateByPrimaryKeySelective(StlBillDetailStyleItem record);

    int updateByPrimaryKey(StlBillDetailStyleItem record);
}
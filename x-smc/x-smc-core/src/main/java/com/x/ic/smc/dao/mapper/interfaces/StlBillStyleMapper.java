package com.x.ic.smc.dao.mapper.interfaces;

import com.x.ic.smc.dao.mapper.bo.StlBillStyle;
import com.x.ic.smc.dao.mapper.bo.StlBillStyleCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StlBillStyleMapper {
    int countByExample(StlBillStyleCriteria example);

    int deleteByExample(StlBillStyleCriteria example);

    int deleteByPrimaryKey(Long billStyleId);

    int insert(StlBillStyle record);

    int insertSelective(StlBillStyle record);

    List<StlBillStyle> selectByExample(StlBillStyleCriteria example);

    StlBillStyle selectByPrimaryKey(Long billStyleId);

    int updateByExampleSelective(@Param("record") StlBillStyle record, @Param("example") StlBillStyleCriteria example);

    int updateByExample(@Param("record") StlBillStyle record, @Param("example") StlBillStyleCriteria example);

    int updateByPrimaryKeySelective(StlBillStyle record);

    int updateByPrimaryKey(StlBillStyle record);
}
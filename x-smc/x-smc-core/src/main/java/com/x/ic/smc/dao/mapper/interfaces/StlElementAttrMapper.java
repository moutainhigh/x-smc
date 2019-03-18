package com.x.ic.smc.dao.mapper.interfaces;

import com.x.ic.smc.dao.mapper.bo.StlElementAttr;
import com.x.ic.smc.dao.mapper.bo.StlElementAttrCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StlElementAttrMapper {
    int countByExample(StlElementAttrCriteria example);

    int deleteByExample(StlElementAttrCriteria example);

    int deleteByPrimaryKey(Long attrId);

    int insert(StlElementAttr record);

    int insertSelective(StlElementAttr record);

    List<StlElementAttr> selectByExample(StlElementAttrCriteria example);

    StlElementAttr selectByPrimaryKey(Long attrId);

    int updateByExampleSelective(@Param("record") StlElementAttr record, @Param("example") StlElementAttrCriteria example);

    int updateByExample(@Param("record") StlElementAttr record, @Param("example") StlElementAttrCriteria example);

    int updateByPrimaryKeySelective(StlElementAttr record);

    int updateByPrimaryKey(StlElementAttr record);
}
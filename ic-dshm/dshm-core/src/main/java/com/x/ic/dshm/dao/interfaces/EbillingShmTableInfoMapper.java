package com.x.ic.dshm.dao.interfaces;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.x.ic.dshm.dto.EbillingShmTableInfo;
import com.x.ic.dshm.dto.EbillingShmTableInfoCriteria;

public interface EbillingShmTableInfoMapper {
    int countByExample(EbillingShmTableInfoCriteria example);

    int deleteByExample(EbillingShmTableInfoCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(EbillingShmTableInfo record);

    int insertSelective(EbillingShmTableInfo record);

    List<EbillingShmTableInfo> selectByExample(EbillingShmTableInfoCriteria example);

    EbillingShmTableInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") EbillingShmTableInfo record, @Param("example") EbillingShmTableInfoCriteria example);

    int updateByExample(@Param("record") EbillingShmTableInfo record, @Param("example") EbillingShmTableInfoCriteria example);

    int updateByPrimaryKeySelective(EbillingShmTableInfo record);

    int updateByPrimaryKey(EbillingShmTableInfo record);
    
    int maxByTableId();
}
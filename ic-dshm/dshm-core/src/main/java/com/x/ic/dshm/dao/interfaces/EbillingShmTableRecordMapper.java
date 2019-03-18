package com.x.ic.dshm.dao.interfaces;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.x.ic.dshm.dto.EbillingShmTableRecord;
import com.x.ic.dshm.dto.EbillingShmTableRecordCriteria;

public interface EbillingShmTableRecordMapper {
    int countByExample(EbillingShmTableRecordCriteria example);

    int deleteByExample(EbillingShmTableRecordCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(EbillingShmTableRecord record);

    int insertSelective(EbillingShmTableRecord record);

    List<EbillingShmTableRecord> selectByExample(EbillingShmTableRecordCriteria example);

    EbillingShmTableRecord selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") EbillingShmTableRecord record, @Param("example") EbillingShmTableRecordCriteria example);

    int updateByExample(@Param("record") EbillingShmTableRecord record, @Param("example") EbillingShmTableRecordCriteria example);

    int updateByPrimaryKeySelective(EbillingShmTableRecord record);

    int updateByPrimaryKey(EbillingShmTableRecord record);
    
    int maxById();
}
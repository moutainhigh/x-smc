package com.x.smc.bill.service.atom.interfaces;

import java.sql.Timestamp;
import java.util.List;

import com.x.smc.bill.dao.mapper.bo.StlCalDataRecord;
import com.x.smc.bill.dao.mapper.bo.StlCalDataRecordCriteria;

public interface IStlCalDataRecordAtomSV {

	List<StlCalDataRecord> selectByExample(StlCalDataRecordCriteria example);
	
	List<StlCalDataRecord> queryProcessData(String tenantId, String runState, String state, Timestamp nextCalDate);
	
	int updateRunStateByRecord(Long recordId, String runState);
}

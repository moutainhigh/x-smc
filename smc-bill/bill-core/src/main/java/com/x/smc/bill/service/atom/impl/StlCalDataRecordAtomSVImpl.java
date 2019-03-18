package com.x.smc.bill.service.atom.impl;

import java.sql.Timestamp;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import com.x.smc.bill.dao.mapper.bo.StlCalDataRecord;
import com.x.smc.bill.dao.mapper.bo.StlCalDataRecordCriteria;
import com.x.smc.bill.dao.mapper.bo.StlCalDataRecordCriteria.Criteria;
import com.x.smc.bill.dao.mapper.factory.MapperFactory;
import com.x.smc.bill.service.atom.interfaces.IStlCalDataRecordAtomSV;

@Component
public class StlCalDataRecordAtomSVImpl implements IStlCalDataRecordAtomSV{

	@Override
	public List<StlCalDataRecord> selectByExample(StlCalDataRecordCriteria example) {
		// TODO Auto-generated method stub
		return MapperFactory.getStlCalDataRecordMapper().selectByExample(example);
	}

	@Override
	public List<StlCalDataRecord> queryProcessData(String tenantId, String runState, String state, Timestamp nextCalDate) {
		// TODO Auto-generated method stub
		StlCalDataRecordCriteria dataRecordCriteria = new StlCalDataRecordCriteria();
		Criteria criteria = dataRecordCriteria.createCriteria();
		if(!StringUtils.isBlank(tenantId)) {
			criteria.andTenantIdEqualTo(tenantId);
		}
		criteria.andRunStateEqualTo(runState);
		criteria.andStateEqualTo(state);
		criteria.andNextCalDateLessThanOrEqualTo(nextCalDate);
		return MapperFactory.getStlCalDataRecordMapper().selectByExample(dataRecordCriteria);
	}

	@Override
	public int updateRunStateByRecord(Long recordId, String runState) {
		// TODO Auto-generated method stub
		StlCalDataRecord record = new StlCalDataRecord();
		record.setRunState(runState);
		StlCalDataRecordCriteria example = new StlCalDataRecordCriteria();
		Criteria criteria = example.createCriteria();
		criteria.andRecordIdEqualTo(recordId);
		return MapperFactory.getStlCalDataRecordMapper().updateByExampleSelective(record, example);
	}
	
}

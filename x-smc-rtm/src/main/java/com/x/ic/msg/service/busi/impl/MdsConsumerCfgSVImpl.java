package com.x.ic.msg.service.busi.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.x.ic.msg.constants.SmcConstants;
import com.x.ic.msg.dao.mapper.bo.MdsConsumerMapped;
import com.x.ic.msg.dao.mapper.bo.MdsConsumerMappedExample;
import com.x.ic.msg.dao.mapper.interfaces.MdsConsumerMappedMapper;
import com.x.ic.msg.service.busi.interfaces.IMdsConsumerCfgSV;

@Service
public class MdsConsumerCfgSVImpl implements IMdsConsumerCfgSV {

	@Autowired
	private MdsConsumerMappedMapper mapper;
	
	@Override
	public List<MdsConsumerMapped> getConsumerMapped() {
		MdsConsumerMappedExample example = new MdsConsumerMappedExample();
		MdsConsumerMappedExample.Criteria criteria = example.createCriteria();
		criteria.andStateEqualTo(SmcConstants.MdsState.NORMAL);
		criteria.andMdsTypeEqualTo(SmcConstants.MdsType.AUTO);
		List<MdsConsumerMapped> list = mapper.selectByExample(example);
		return list;
	}

}

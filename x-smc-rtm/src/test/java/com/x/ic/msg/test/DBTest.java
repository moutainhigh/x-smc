package com.x.ic.msg.test;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.x.ic.msg.dao.mapper.bo.StlPolicyTaskCycle;
import com.x.ic.msg.dao.mapper.bo.StlPolicyTaskCycleExample;
import com.x.ic.msg.dao.mapper.interfaces.StlPolicyTaskCycleMapper;

@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration({"classpath:context/core-context.xml"})  
public class DBTest {
	
	@Autowired
	private StlPolicyTaskCycleMapper mapper;
	
	@Test
	public void dbTest1(){
		StlPolicyTaskCycleExample example = new StlPolicyTaskCycleExample();
		StlPolicyTaskCycleExample.Criteria criteria = example.createCriteria();
		criteria.andTenantIdEqualTo("pubgo");
		criteria.andPolicyIdEqualTo(100001l);
		Date date = new Date();
		criteria.andStartTimeLessThan(date);
		criteria.andEndTimeGreaterThanOrEqualTo(date);
		List<StlPolicyTaskCycle> list = mapper.selectByExample(example);
		System.out.println(JSON.toJSONString(list));
		System.out.println(date);
	}
	public static void main(String[] args) {
		

	}
	
	

}

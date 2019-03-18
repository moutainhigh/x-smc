package com.x.smc.bill.dao.mapper.factory;

import javax.annotation.PostConstruct;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.x.smc.bill.dao.mapper.interfaces.PolicyTaskCycleMapper;
import com.x.smc.bill.dao.mapper.interfaces.StlBillDataMapper;
import com.x.smc.bill.dao.mapper.interfaces.StlCalDataRecordMapper;

@Component
public class MapperFactory {

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    private static SqlSessionTemplate st;

    @PostConstruct
    void init() {
    	setSqlSessionTemplate(sqlSessionTemplate);
    }
    public static void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        MapperFactory.st = sqlSessionTemplate;
    }
    
    public static StlCalDataRecordMapper getStlCalDataRecordMapper() {
        return st.getMapper(StlCalDataRecordMapper.class);
    }

    public static PolicyTaskCycleMapper getPolicyTaskCycleMapper() {
    		return st.getMapper(PolicyTaskCycleMapper.class);
    }
    
    public static StlBillDataMapper getStlBillDataMapper() {
		return st.getMapper(StlBillDataMapper.class);
    }
}

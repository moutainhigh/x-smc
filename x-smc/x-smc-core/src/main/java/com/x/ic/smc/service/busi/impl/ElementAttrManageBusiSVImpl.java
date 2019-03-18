package com.x.ic.smc.service.busi.impl;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.x.ic.smc.dao.mapper.bo.StlElementAttr;
import com.x.ic.smc.dao.mapper.bo.StlElementAttrCriteria;
import com.x.ic.smc.dao.mapper.factory.MapperFactory;
import com.x.ic.smc.service.busi.interfaces.IElementAttrManageBusiSV;
@Component
@Transactional
public class ElementAttrManageBusiSVImpl implements IElementAttrManageBusiSV{

	
	
	@Override
	public void createElementAttr(StlElementAttr elementAttr) {
		// TODO Auto-generated method stub
		MapperFactory.getElementAttrMapper().insert(elementAttr);
	}

	@Override
	public StlElementAttr searchElementAttrByElementId(Long elementId) {
		// TODO Auto-generated method stub
		StlElementAttr stlElementAttr=null;
		StlElementAttrCriteria stlElementAttrCriteria=new StlElementAttrCriteria();
		com.x.ic.smc.dao.mapper.bo.StlElementAttrCriteria.Criteria	criteria=stlElementAttrCriteria.createCriteria();
		criteria.andElementIdEqualTo(elementId);
	   List list=MapperFactory.getElementAttrMapper().selectByExample(stlElementAttrCriteria);
		if(list.size()>0)
		{
			stlElementAttr=(StlElementAttr) list.get(0);	
		}
		return stlElementAttr;
	}

	@Override
	public void updateElementAttr(StlElementAttr strElementAttr) {
		// TODO Auto-generated method stub
		MapperFactory.getElementAttrMapper().updateByPrimaryKey(strElementAttr);
	}
	
	
	
	

}

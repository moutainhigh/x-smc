package com.x.ic.smc.service.busi.interfaces;

import com.x.ic.smc.dao.mapper.bo.StlElementAttr;

public interface IElementAttrManageBusiSV {
	
	
	 void createElementAttr(StlElementAttr strElementAttr);
	 
	 StlElementAttr searchElementAttrByElementId(Long elementId);
	 
	 void updateElementAttr(StlElementAttr strElementAttr);
	 
}

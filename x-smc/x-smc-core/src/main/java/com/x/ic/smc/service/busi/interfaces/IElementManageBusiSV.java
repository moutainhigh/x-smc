package com.x.ic.smc.service.busi.interfaces;

import com.x.base.exception.BusinessException;
import com.x.base.vo.PageInfo;
import com.x.ic.smc.api.elementmanage.param.ElementSearchRequest;
import com.x.ic.smc.api.elementmanage.param.ElementSearchResponseVO;
import com.x.ic.smc.dao.mapper.bo.StlElement;

public interface IElementManageBusiSV {

	   void createElement(StlElement stlElement);
	   
	   void deleteElement(Long elementId,String tenantId)throws BusinessException;
	   
	   
	   void updateElement(StlElement stlElement);
	   
	   StlElement searchElementById(Long elementId) throws BusinessException;
	   
	   
	   PageInfo<ElementSearchResponseVO> searchElementList(ElementSearchRequest elementSearchRequest);
	   
	   boolean checkElementCode(StlElement stlElement);
}

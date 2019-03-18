//package com.x.smc.bill.api.demo.interfaces;
//
//import javax.ws.rs.Consumes;
//import javax.ws.rs.POST;
//import javax.ws.rs.Path;
//import javax.ws.rs.Produces;
//import javax.ws.rs.core.MediaType;
//
//import com.x.base.exception.BusinessException;
//import com.x.base.exception.SystemException;
//
//@Path("/dstDiscountLevel")
//@Consumes({ MediaType.APPLICATION_JSON })
//@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_XML })
//public interface IDstDiscountLevelSV {
//
//	/**
//	 * 客户级别定义信息查询
//	 * 
//	 * @param CustDiscountQueryParam
//	 * @return CustDiscountQueryResponse
//	 * @throws BusinessException
//	 * @throws SystemException
//	 * @author wangly
//	 * @ApiDocMethod
//	 * @ApiCode IDstDiscountLevelSV_001
//	 * @RestRelativeURL dstDiscountLevel/queryDstDiscountLevel
//	 */
//	@POST
//	@Path("/queryDstDiscountLevel")
//	DstDisCountLevelListResponse queryDstDiscountLevel(DstDisCountLevelListRequest request)
//			throws BusinessException, SystemException;
//
//}

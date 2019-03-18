//package com.x.centra.customer.api;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import com.alibaba.fastjson.JSON;
//import com.x.base.vo.PageInfo;
//import com.x.smc.bill.api.demo.param.DstDisCountLevelCRUDRequest;
//import com.x.smc.bill.api.demo.param.DstDisCountLevelCRUDResponse;
//import com.x.smc.bill.api.demo.param.DstDisCountLevelListRequest;
//import com.x.smc.bill.api.demo.param.DstDiscountInfoVO;
//import com.x.smc.bill.api.demo.param.DstDiscountLevelVO;
//import com.x.smc.bill.service.business.interfaces.IDstDiscountLevelBusiSV;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration({ "classpath*:/context/core-context.xml" })
//public class DstDiscountLevelTest {
//
//	@Autowired
//	private IDstDiscountLevelBusiSV iDstDiscountLevelBusiSV;
//
//	@Test
//	public void queryDstDiscountLevel() {
//		DstDisCountLevelListRequest request = new DstDisCountLevelListRequest();
//		DstDiscountLevelVO vo = new DstDiscountLevelVO();
//		vo.setStatus("1");
//		// vo.setLevelCode("baiyin");
//		request.setDstDiscountLevelVO(vo);
//		PageInfo<DstDiscountLevelVO> rep = iDstDiscountLevelBusiSV.queryDstDiscountLevel(request);
//		System.out.println(JSON.toJSONString(rep));
//	}
//
//	@Test
//	public void addDstDiscountLevel() {
//		DstDisCountLevelCRUDRequest request = new DstDisCountLevelCRUDRequest();
//		DstDiscountLevelVO dstDiscountLevelVO = new DstDiscountLevelVO();
//		dstDiscountLevelVO.setLevelCode("test3");
//		dstDiscountLevelVO.setLevelName("测试3");
//		dstDiscountLevelVO.setRemark("remark");
//		dstDiscountLevelVO.setTenantId("pubo");
//		request.setDstDiscountLevelVO(dstDiscountLevelVO);
//
//		List<DstDiscountInfoVO> dstDiscountInfoVOs = new ArrayList<>();
//		DstDiscountInfoVO e1 = new DstDiscountInfoVO();
//		e1.setDiscountId("3");
//		e1.setDiscountCode("c3");
//		dstDiscountInfoVOs.add(e1);
//		DstDiscountInfoVO e2 = new DstDiscountInfoVO();
//		e2.setDiscountId("4");
//		e2.setDiscountCode("c4");
//		dstDiscountInfoVOs.add(e2);
//
//		request.setDstDiscountInfoVOs(dstDiscountInfoVOs);
//		DstDisCountLevelCRUDResponse rep = iDstDiscountLevelBusiSV.addDstDiscountLevel(request);
//		System.out.println(JSON.toJSONString(rep));
//	}
//
//	@Test
//	public void deleteDstDiscountLevel() {
//		DstDisCountLevelCRUDRequest request = new DstDisCountLevelCRUDRequest();
//		request.setTenantId("pubo");
//		DstDiscountLevelVO dstDiscountLevelVO = new DstDiscountLevelVO();
//		dstDiscountLevelVO.setLevelId("0000000020");
//		dstDiscountLevelVO.setLevelCode("test2");
//		request.setDstDiscountLevelVO(dstDiscountLevelVO);
//
//		DstDisCountLevelCRUDResponse rep = iDstDiscountLevelBusiSV.deleteDstDiscountLevel(request);
//		System.out.println(JSON.toJSONString(rep));
//	}
//
//	@Test
//	public void updateDstDiscountLevel() {
//		DstDisCountLevelCRUDRequest request = new DstDisCountLevelCRUDRequest();
//		request.setTenantId("pubo");
//
//		DstDiscountLevelVO dstDiscountLevelVO = new DstDiscountLevelVO();
//		dstDiscountLevelVO.setLevelId("0000000024");
//		dstDiscountLevelVO.setLevelCode("test2");
//		dstDiscountLevelVO.setTenantId("pubo");
//		request.setDstDiscountLevelVO(dstDiscountLevelVO);
//		List<DstDiscountInfoVO> dstDiscountInfoVOs = new ArrayList<>();
//		DstDiscountInfoVO e1 = new DstDiscountInfoVO();
//		e1.setDiscountId("7");
//		e1.setDiscountCode("c7");
//		dstDiscountInfoVOs.add(e1);
//		DstDiscountInfoVO e2 = new DstDiscountInfoVO();
//		e2.setDiscountId("8");
//		e2.setDiscountCode("c8");
//		dstDiscountInfoVOs.add(e2);
//
//		request.setDstDiscountInfoVOs(dstDiscountInfoVOs);
//		DstDisCountLevelCRUDResponse rep = iDstDiscountLevelBusiSV.updateDstDiscountLevel(request);
//		System.out.println(JSON.toJSONString(rep));
//	}
//
//	@Test
//	public void queryDstDiscountLevelDetail() {
//		DstDisCountLevelCRUDRequest request = new DstDisCountLevelCRUDRequest();
//		request.setTenantId("pubgo");
//		DstDiscountLevelVO dstDiscountLevelVO = new DstDiscountLevelVO();
////		dstDiscountLevelVO.setLevelId("0000000020");
//		dstDiscountLevelVO.setLevelCode("LEVEL_DIAMEND");
//		request.setDstDiscountLevelVO(dstDiscountLevelVO);
//
//		DstDisCountLevelCRUDResponse rep = iDstDiscountLevelBusiSV.queryDstDiscountLevelDetail(request);
//		System.out.println(JSON.toJSONString(rep));
//	}
//
//	public static void main(String[] args) {
//	}
//}

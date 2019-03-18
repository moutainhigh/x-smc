package com.x.smc.bill.service.business.impl;
//package com.x.centra.dst.service.business.impl;
//
//import java.sql.Timestamp;
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.x.base.exception.BusinessException;
//import com.x.base.exception.SystemException;
//import com.x.base.vo.PageInfo;
//import com.x.base.vo.ResponseHeader;
//import com.x.centra.dst.api.discountlevel.param.DstDisCountLevelCRUDRequest;
//import com.x.centra.dst.api.discountlevel.param.DstDisCountLevelCRUDResponse;
//import com.x.centra.dst.api.discountlevel.param.DstDisCountLevelListRequest;
//import com.x.centra.dst.api.discountlevel.param.DstDiscountInfoVO;
//import com.x.centra.dst.api.discountlevel.param.DstDiscountLevelVO;
//import com.x.centra.dst.dao.mapper.bo.DstDiscountInfo;
//import com.x.centra.dst.dao.mapper.bo.DstDiscountLevel;
//import com.x.centra.dst.dao.mapper.bo.DstDiscountLevelCriteria;
//import com.x.centra.dst.dao.mapper.bo.DstDiscountLevelCriteria.Criteria;
//import com.x.centra.dst.dao.mapper.bo.DstDiscountLevelRelation;
//import com.x.centra.dst.dao.mapper.bo.DstDiscountLevelRelationCriteria;
//import com.x.centra.dst.service.atom.interfaces.IDstDiscountInfoAtomSV;
//import com.x.centra.dst.service.atom.interfaces.IDstDiscountLevelAtomSV;
//import com.x.centra.dst.service.atom.interfaces.IDstDiscountLevelRelationAtomSV;
//import com.x.centra.dst.service.business.interfaces.IDstDiscountLevelBusiSV;
//import com.x.centra.dst.util.DstSeqUtil;
//import com.x.sdk.constant.ExceptCodeConstants;
//import com.x.sdk.util.BeanUtils;
//import com.x.sdk.util.CollectionUtil;
//import com.x.sdk.util.DateUtil;
//import com.x.sdk.util.StringUtil;
//
//@Service
//@Transactional
//public class DstDiscountLevelBusiSVImpl implements IDstDiscountLevelBusiSV {
//
//	@Autowired
//	IDstDiscountLevelAtomSV iDstDiscountLevelAtomSV;
//	@Autowired
//	IDstDiscountLevelRelationAtomSV iDstDiscountLevelRelationAtomSV;
//	@Autowired
//	IDstDiscountInfoAtomSV iDstDiscountInfoAtomSV;
//
//	@Override
//	public PageInfo<DstDiscountLevelVO> queryDstDiscountLevel(DstDisCountLevelListRequest request) {
//		if (StringUtil.isBlank(request.getTenantId())) {
//			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "租户ID不能为空");
//		}
//		/* 1.参数校验 */
//		if (request.getPageNo() != null && request.getPageNo() <= 0) {
//			throw new BusinessException("", "pageNo必须大于0");
//		}
//		if (request.getPageSize() != null && request.getPageSize() <= 0) {
//			throw new BusinessException("", "pageSize必须大于0");
//		}
//		Integer pageNo = (null == request.getPageNo()) ? 1 : request.getPageNo();
//		Integer pageSize = (null == request.getPageSize()) ? 5 : request.getPageSize();
//		PageInfo<DstDiscountLevelVO> pageInfo = new PageInfo<>();
//		pageInfo.setPageNo(pageNo);
//		pageInfo.setPageSize(pageSize);
//		DstDiscountLevelVO vo = request.getDstDiscountLevelVO();
//		if (null == vo) {
//			return pageInfo;
//		}
//		DstDiscountLevelCriteria example = new DstDiscountLevelCriteria();
//		Criteria criteria = example.createCriteria();
//		criteria.andStatusEqualTo("1");
//		criteria.andTenantIdEqualTo(request.getTenantId());
//		String levelCode = vo.getLevelCode();
//		String status = vo.getStatus();
//		if (!StringUtil.isBlank(levelCode)) {
//			criteria.andLevelCodeEqualTo(levelCode);
//		}
//		if (!StringUtil.isBlank(status)) {
//			criteria.andStatusEqualTo(status);
//		}
//		if (!StringUtil.isBlank(vo.getLevelName())) {
//			criteria.andLevelNameLike("%"+vo.getLevelName()+"%");
//		}
//		int count = iDstDiscountLevelAtomSV.countByExample(example);
//
//		Integer pageInt = (pageNo - 1) * pageSize;
//		example.setLimitStart(pageInt);
//		example.setLimitEnd(pageSize);
//		example.setOrderByClause(" CREATE_DATE DESC");
//		List<DstDiscountLevel> results = iDstDiscountLevelAtomSV.selectByExample(example);
//		if (!CollectionUtil.isEmpty(results)) {
//			List<DstDiscountLevelVO> result = new ArrayList<>();
//			for (DstDiscountLevel bo : results) {
//				DstDiscountLevelVO vonew = new DstDiscountLevelVO();
//				BeanUtils.copyVO(vonew, bo);
//				result.add(vonew);
//			}
//			pageInfo.setResult(result);
//		}
//
//		pageInfo.setCount(count);
//		return pageInfo;
//	}
//
//	@Override
//	public DstDisCountLevelCRUDResponse addDstDiscountLevel(DstDisCountLevelCRUDRequest request)
//			throws BusinessException, SystemException {
//		if (StringUtil.isBlank(request.getTenantId())) {
//			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "租户ID不能为空");
//		}
//		Timestamp sysdate = DateUtil.getSysDate();
//		DstDisCountLevelCRUDResponse rep = new DstDisCountLevelCRUDResponse();
//		DstDiscountLevelVO vo = request.getDstDiscountLevelVO();
//		DstDiscountLevel record = new DstDiscountLevel();
//		BeanUtils.copyVO(record, vo);
//		String levelId = DstSeqUtil.getDiscountLevelId();
//		record.setLevelId(levelId);
//		record.setStatus("1");
//		record.setCreateDate(sysdate);
//		iDstDiscountLevelAtomSV.insert(record);
//		vo.setLevelId(levelId);
//		List<DstDiscountInfoVO> vos = request.getDstDiscountInfoVOs();
//		if (!CollectionUtil.isEmpty(vos)) {
//			for (DstDiscountInfoVO dstDiscountInfoVO : vos) {
//				DstDiscountLevelRelation recordrel = new DstDiscountLevelRelation();
//				recordrel.setCreateDate(sysdate);
//				recordrel.setCreateUserId(vo.getCreateUserId());
//				recordrel.setDiscountCode(dstDiscountInfoVO.getDiscountCode());
//				recordrel.setLevelCode(vo.getLevelCode());
//				recordrel.setRelStatus("1");
//				recordrel.setTenantId(vo.getTenantId());
//				iDstDiscountLevelRelationAtomSV.insert(recordrel);
//			}
//		}
//		rep.setDstDiscountLevelVO(vo);
//		rep.setDstDiscountInfoVOs(vos);
//
//		ResponseHeader responseHeader = new ResponseHeader(true, ExceptCodeConstants.Special.SUCCESS, "成功");
//		rep.setResponseHeader(responseHeader);
//		return rep;
//	}
//
//	@Override
//	public DstDisCountLevelCRUDResponse updateDstDiscountLevel(DstDisCountLevelCRUDRequest request)
//			throws BusinessException, SystemException {
//		if (StringUtil.isBlank(request.getTenantId())) {
//			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "租户ID不能为空");
//		}
//		Timestamp sysdate = DateUtil.getSysDate();
//		DstDisCountLevelCRUDResponse rep = new DstDisCountLevelCRUDResponse();
//		DstDiscountLevelVO vo = request.getDstDiscountLevelVO();
//		DstDiscountLevel record = new DstDiscountLevel();
//		BeanUtils.copyVO(record, vo);
//		record.setStatus("1");
//		record.setCreateDate(sysdate);
//		DstDiscountLevelCriteria example = new DstDiscountLevelCriteria();
//		Criteria criteria = example.createCriteria();
//		criteria.andLevelCodeEqualTo(vo.getLevelCode());
//		criteria.andTenantIdEqualTo(request.getTenantId());
//		iDstDiscountLevelAtomSV.updateByExampleSelective(record, example);
//		List<DstDiscountInfoVO> vos = request.getDstDiscountInfoVOs();
//		if (!CollectionUtil.isEmpty(vos)) {
//
//			/** 失效原来的关联关系 */
//			DstDiscountLevelRelationCriteria example1 = new DstDiscountLevelRelationCriteria();
//			example1.createCriteria().andTenantIdEqualTo(request.getTenantId())
//					.andLevelCodeEqualTo(request.getDstDiscountLevelVO().getLevelCode());
//			List<DstDiscountLevelRelation> resluts = iDstDiscountLevelRelationAtomSV.selectByExample(example1);
//			if (!CollectionUtil.isEmpty(resluts)) {
//				for (DstDiscountLevelRelation dstDiscountLevelRelation : resluts) {
//					DstDiscountLevelRelationCriteria example2 = new DstDiscountLevelRelationCriteria();
//					example2.createCriteria().andLevelCodeEqualTo(dstDiscountLevelRelation.getLevelCode())
//							.andDiscountCodeEqualTo(dstDiscountLevelRelation.getDiscountCode())
//							.andTenantIdEqualTo(dstDiscountLevelRelation.getTenantId());
//					dstDiscountLevelRelation.setRelStatus("0");
//					iDstDiscountLevelRelationAtomSV.updateByExampleSelective(dstDiscountLevelRelation, example2);
//				}
//			}
//
//			/** 绑定新的关联关系 */
//			for (DstDiscountInfoVO dstDiscountInfoVO : vos) {
//				DstDiscountLevelRelation recordrel = new DstDiscountLevelRelation();
//				recordrel.setCreateDate(sysdate);
//				recordrel.setCreateUserId(vo.getCreateUserId());
//				recordrel.setDiscountCode(dstDiscountInfoVO.getDiscountCode());
//				recordrel.setLevelCode(vo.getLevelCode());
//				recordrel.setRelStatus("1");
//				recordrel.setTenantId(vo.getTenantId());
//				iDstDiscountLevelRelationAtomSV.insert(recordrel);
//			}
//		}
//		rep.setDstDiscountLevelVO(vo);
//		rep.setDstDiscountInfoVOs(vos);
//
//		ResponseHeader responseHeader = new ResponseHeader(true, ExceptCodeConstants.Special.SUCCESS, "成功");
//		rep.setResponseHeader(responseHeader);
//		return rep;
//	}
//
//	@Override
//	public DstDisCountLevelCRUDResponse deleteDstDiscountLevel(DstDisCountLevelCRUDRequest request)
//			throws BusinessException, SystemException {
//		if (StringUtil.isBlank(request.getTenantId())) {
//			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "租户ID不能为空");
//		}
//		DstDisCountLevelCRUDResponse rep = new DstDisCountLevelCRUDResponse();
//		ResponseHeader responseHeader = new ResponseHeader(true, ExceptCodeConstants.Special.SUCCESS, "成功");
//		rep.setResponseHeader(responseHeader);
//		if (null == request.getDstDiscountLevelVO()) {
//			return rep;
//		}
//		DstDiscountLevelVO vo = request.getDstDiscountLevelVO();
//		String levelCode = vo.getLevelCode();
//		if (!StringUtil.isBlank(levelCode)) {
//			DstDiscountLevel record = new DstDiscountLevel();
//			record.setStatus("0");
//			DstDiscountLevelCriteria example = new DstDiscountLevelCriteria();
//			example.createCriteria().andLevelCodeEqualTo(levelCode).andTenantIdEqualTo(request.getTenantId());
//			iDstDiscountLevelAtomSV.updateByExampleSelective(record, example);
//
//			DstDiscountLevelRelationCriteria example1 = new DstDiscountLevelRelationCriteria();
//			example1.createCriteria().andLevelCodeEqualTo(levelCode).andTenantIdEqualTo(request.getTenantId());
//			List<DstDiscountLevelRelation> resluts = iDstDiscountLevelRelationAtomSV.selectByExample(example1);
//			if (!CollectionUtil.isEmpty(resluts)) {
//				for (DstDiscountLevelRelation dstDiscountLevelRelation : resluts) {
//					DstDiscountLevelRelationCriteria example2 = new DstDiscountLevelRelationCriteria();
//					example2.createCriteria().andLevelCodeEqualTo(levelCode)
//							.andDiscountCodeEqualTo(dstDiscountLevelRelation.getDiscountCode())
//							.andTenantIdEqualTo(dstDiscountLevelRelation.getTenantId());
//					dstDiscountLevelRelation.setRelStatus("0");
//					iDstDiscountLevelRelationAtomSV.updateByExampleSelective(dstDiscountLevelRelation, example2);
//				}
//			}
//		}
//		return rep;
//	}
//
//	@Override
//	public DstDisCountLevelCRUDResponse queryDstDiscountLevelDetail(DstDisCountLevelCRUDRequest request)
//			throws BusinessException, SystemException {
//		if (StringUtil.isBlank(request.getTenantId())) {
//			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "租户ID不能为空");
//		}
//		DstDisCountLevelCRUDResponse rep = new DstDisCountLevelCRUDResponse();
//		ResponseHeader responseHeader = new ResponseHeader(true, ExceptCodeConstants.Special.SUCCESS, "成功");
//		rep.setResponseHeader(responseHeader);
//		if (null == request.getDstDiscountLevelVO()) {
//			return rep;
//		}
//		String levelCode = request.getDstDiscountLevelVO().getLevelCode();
//		DstDiscountLevelCriteria example = new DstDiscountLevelCriteria();
//		Criteria criteria = example.createCriteria();
//		criteria.andLevelCodeEqualTo(levelCode);
//		criteria.andTenantIdEqualTo(request.getTenantId());
//		List<DstDiscountLevel> bos = iDstDiscountLevelAtomSV.selectByExample(example);
//		if (CollectionUtil.isEmpty(bos)) {
//			return rep;
//		}
//		DstDiscountLevel bo = bos.get(0);
//		DstDiscountLevelVO vo = new DstDiscountLevelVO();
//		BeanUtils.copyVO(vo, bo);
//		rep.setDstDiscountLevelVO(vo);
//
//		DstDiscountLevelRelationCriteria example1 = new DstDiscountLevelRelationCriteria();
//		example1.createCriteria().andLevelCodeEqualTo(request.getDstDiscountLevelVO().getLevelCode())
//				.andRelStatusEqualTo("1").andTenantIdEqualTo(request.getTenantId());
//		List<DstDiscountLevelRelation> resluts = iDstDiscountLevelRelationAtomSV.selectByExample(example1);
//		if (!CollectionUtil.isEmpty(resluts)) {
//			List<DstDiscountInfoVO> vos = new ArrayList<>();
//			for (DstDiscountLevelRelation dstDiscountLevelRelation : resluts) {
//				DstDiscountInfo ebo = iDstDiscountInfoAtomSV.getByDiscountCode(request.getTenantId(),
//						dstDiscountLevelRelation.getDiscountCode());
//				if (null != ebo) {
//					DstDiscountInfoVO evo = new DstDiscountInfoVO();
//					BeanUtils.copyVO(evo, ebo);
//					vos.add(evo);
//				}
//			}
//
//			rep.setDstDiscountInfoVOs(vos);
//		}
//
//		return rep;
//	}
//
//}

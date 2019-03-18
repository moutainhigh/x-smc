package com.x.ic.smc.service.busi.impl;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NavigableMap;

import org.apache.commons.lang.StringUtils;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.filter.BinaryPrefixComparator;
import org.apache.hadoop.hbase.filter.CompareFilter.CompareOp;
import org.apache.hadoop.hbase.filter.FilterList;
import org.apache.hadoop.hbase.filter.PageFilter;
import org.apache.hadoop.hbase.filter.RowFilter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.x.base.exception.BusinessException;
import com.x.base.exception.SystemException;
import com.x.base.vo.HBasePager;
import com.x.base.vo.ResponseHeader;
import com.x.sdk.util.BeanUtils;
import com.x.sdk.util.StringUtil;
import com.x.ic.smc.api.billdata.param.BillDataVo;
import com.x.ic.smc.api.billdata.param.BillItemData;
import com.x.ic.smc.api.billdata.param.QueryBillDataDetailRequest;
import com.x.ic.smc.api.billdata.param.QueryBillDataRequest;
import com.x.ic.smc.api.billdata.param.QueryBillDataResponse;
import com.x.ic.smc.api.billdata.param.QueryBillDetail;
import com.x.ic.smc.api.billdata.param.QueryBillDetailResponse;
import com.x.ic.smc.constants.SmcExceptCodeConstant;
import com.x.ic.smc.constants.SmcHbaseConstant;
import com.x.ic.smc.dao.mapper.bo.StlBillData;
import com.x.ic.smc.dao.mapper.bo.StlBillDataCriteria;
import com.x.ic.smc.dao.mapper.bo.StlBillDetailStyleItem;
import com.x.ic.smc.dao.mapper.bo.StlBillDetailStyleItemCriteria;
import com.x.ic.smc.dao.mapper.bo.StlBillItemData;
import com.x.ic.smc.dao.mapper.bo.StlBillItemDataCriteria;
import com.x.ic.smc.dao.mapper.bo.StlBillStyle;
import com.x.ic.smc.dao.mapper.bo.StlBillStyleCriteria;
import com.x.ic.smc.dao.mapper.factory.MapperFactory;
import com.x.ic.smc.dao.mapper.interfaces.StlBillDataMapper;
import com.x.ic.smc.dao.mapper.interfaces.StlBillDetailStyleItemMapper;
import com.x.ic.smc.dao.mapper.interfaces.StlBillItemDataMapper;
import com.x.ic.smc.dao.mapper.interfaces.StlBillStyleMapper;
import com.x.ic.smc.service.busi.interfaces.IBillDataBusiSV;
import com.x.ic.smc.util.HbaseClient;
import com.x.ic.smc.util.RedisUtil;
import com.alibaba.fastjson.JSON;

@Service
@Transactional
public class BillDataBusiSVImpl implements IBillDataBusiSV {

    @Override
    public QueryBillDataResponse queryBillData(QueryBillDataRequest queryBillDataRequest)
            throws BusinessException {
        // 根据
        QueryBillDataResponse queryBillDataResponse = new QueryBillDataResponse();
        List<BillDataVo> billDataVos = null;
        List<BillItemData> billItemDatas = null;
        String billTimeSn = queryBillDataRequest.getBillTimeSn();
        String subYearMonth = billTimeSn.substring(0, 6);
        String tenantId = queryBillDataRequest.getTenantId();
        StlBillDataCriteria stlBillDataCriteria = new StlBillDataCriteria();
        stlBillDataCriteria.setYyyyMm(subYearMonth);
        StlBillDataCriteria.Criteria criteria = stlBillDataCriteria.createCriteria();
        criteria.andTenantIdEqualTo(tenantId);
        if (!StringUtils.isBlank(queryBillDataRequest.getStlObjectId())) {
            criteria.andStlObjectIdEqualTo(queryBillDataRequest.getStlObjectId());
        }
        if (!StringUtils.isBlank(queryBillDataRequest.getPolicyCode())) {
            criteria.andPolicyCodeEqualTo(queryBillDataRequest.getPolicyCode());
        }
        StlBillDataMapper mapper = MapperFactory.getStlBillDataMapper();
        List<StlBillData> stlBillDatas = mapper.selectByExample(stlBillDataCriteria);
        if (stlBillDatas.size() != 0) {
            billDataVos = new ArrayList<BillDataVo>();
            for (StlBillData stlBillData : stlBillDatas) {
                BillDataVo billDataVo = new BillDataVo();
                BeanUtils.copyVO(billDataVo, stlBillData);
                StlBillItemDataCriteria stlBillItemDataCriteria = new StlBillItemDataCriteria();
                StlBillItemDataCriteria.Criteria criteria2 = stlBillItemDataCriteria
                        .createCriteria();
                stlBillItemDataCriteria.setYyyyMm(subYearMonth);
                criteria2.andTenantIdEqualTo(tenantId);
                criteria2.andBillIdEqualTo(stlBillData.getBillId());
                StlBillItemDataMapper stlBillItemDataMapper = MapperFactory
                        .getStlBillItemDataMapper();
                List<StlBillItemData> stlBillItemDatas = stlBillItemDataMapper
                        .selectByExample(stlBillItemDataCriteria);
                if (stlBillItemDatas.size() != 0) {
//                    ICacheClient cacheClient = CacheFactoryUtil
//                            .getCacheClient(CacheBLMapper.CACHE_BL_CAL_PARAM);
                    billItemDatas = new ArrayList<BillItemData>();
                    for (StlBillItemData stlBillItemData : stlBillItemDatas) {
                        BillItemData billItemData = new BillItemData();
                        BeanUtils.copyVO(billItemData, stlBillItemData);
                        String feeItemName = RedisUtil.getCacheClient().get(stlBillItemData.getFeeItemId());
                        if ("".equals(feeItemName)) {
                            throw new BusinessException(
                                    SmcExceptCodeConstant.NO_DATA_OR_CACAE_ERROR,
                                    stlBillItemData.getFeeItemId() + "此科目id对应的科目名称不存在");
                        }
                        billItemData.setFeeItemName(feeItemName);// 根据科目ID获得科目名称
                        billItemDatas.add(billItemData);
                    }
                }
                billDataVo.setBillItemDatas(billItemDatas);
                billDataVos.add(billDataVo);

            }
        }
        queryBillDataResponse.setBillDataVos(billDataVos);
        ResponseHeader responseHeader = new ResponseHeader(true, "000000", "成功");
        queryBillDataResponse.setResponseHeader(responseHeader);
        return queryBillDataResponse;
    }

    @Override
    public QueryBillDetailResponse queryBillDataDetail(
            QueryBillDataDetailRequest queryBillDataDetailRequest) throws BusinessException {
        // 详单数据项需要根据，账单ID从账单数据表中获取账单样式定义编码，再根据样式编码获取详单项定义，根据详单项定义读取详单内容
        // 根据账单id查询stl_bill_data_YYYYMM表获得
        QueryBillDetailResponse queryBillDetailResponse = new QueryBillDetailResponse();
        HBasePager<QueryBillDetail> hBasePagerResult = new HBasePager<QueryBillDetail>();
        List<QueryBillDetail> queryBillDetails = null;
        String billTimeSn = queryBillDataDetailRequest.getBillTimeSn();
        String tenantId = queryBillDataDetailRequest.getTenantId();
        Long billId = queryBillDataDetailRequest.getBillId();
        StlBillDataCriteria stlBillDataCriteria = new StlBillDataCriteria();
        StlBillDataCriteria.Criteria criteria = stlBillDataCriteria.createCriteria();
        criteria.andTenantIdEqualTo(tenantId);
        criteria.andBillIdEqualTo(queryBillDataDetailRequest.getBillId());
        stlBillDataCriteria.setYyyyMm(billTimeSn);
        List<StlBillData> stlBillDatas = null;
        StlBillDataMapper mapper = MapperFactory.getStlBillDataMapper();
        stlBillDatas = mapper.selectByExample(stlBillDataCriteria);

        if (stlBillDatas.size() == 0) {
            throw new BusinessException(SmcExceptCodeConstant.NO_DATA_OR_CACAE_ERROR,
                    queryBillDataDetailRequest.getBillId() + "此账单ID对应的账单表信息为空");
        }
        StlBillData stlBillData = stlBillDatas.get(0);
        String billStyleSn = stlBillData.getBillStyleSn();

        // 根据账单样式编码查询账单样式表
        StlBillStyleCriteria stlBillStyleCriteria = new StlBillStyleCriteria();
        StlBillStyleCriteria.Criteria criteria2 = stlBillStyleCriteria.createCriteria();
        criteria2.andTenantIdEqualTo(tenantId);
        criteria2.andBillStyleSnEqualTo(billStyleSn);
        StlBillStyleMapper mapper2 = MapperFactory.getStlBillStyleMapper();
        List<StlBillStyle> stlBillStyles = mapper2.selectByExample(stlBillStyleCriteria);
        if (stlBillStyles.size() == 0) {
            throw new BusinessException(SmcExceptCodeConstant.NO_DATA_OR_CACAE_ERROR, billStyleSn
                    + "此账单样式编码对应的账单表信息为空");
        }
        Long billStyleId = stlBillStyles.get(0).getBillStyleId();

        // 根据账单样式id查找详单项
        StlBillDetailStyleItemCriteria stlBillDetailStyleItemCriteria = new StlBillDetailStyleItemCriteria();
        StlBillDetailStyleItemCriteria.Criteria criteria3 = stlBillDetailStyleItemCriteria
                .createCriteria();
        criteria3.andTenantIdEqualTo(tenantId);
        criteria3.andBillStyleIdEqualTo(billStyleId);
        criteria3.andItemOwnerNotEqualTo("in");
        StlBillDetailStyleItemMapper mapper3 = MapperFactory.getStlBillDetailStyleItemMapper();
        List<StlBillDetailStyleItem> stlBillDetailStyleItems = mapper3
                .selectByExample(stlBillDetailStyleItemCriteria);
        if (stlBillDetailStyleItems.size() != 0) {
            List<String> columns = new ArrayList<String>();
            queryBillDetails = new ArrayList<QueryBillDetail>();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(tenantId);
            stringBuilder.append("_");
            stringBuilder.append(billId);
            stringBuilder.append("_");
            stringBuilder.append(stlBillData.getBillTimeSn());
            stringBuilder.append("_");
            stringBuilder.append(stlBillData.getStlObjectId());
            stringBuilder.append("_");
            stringBuilder.append(stlBillData.getBillFrom());

            FilterList filterList = new FilterList(FilterList.Operator.MUST_PASS_ALL);
            for (StlBillDetailStyleItem stlBillDetailStyleItem : stlBillDetailStyleItems) {
                columns.add(stlBillDetailStyleItem.getItemCode());
            }
            RowFilter filter = new RowFilter(CompareOp.EQUAL, new BinaryPrefixComparator(
                    stringBuilder.toString().getBytes()));
            filterList.addFilter(filter);

            Connection conn = HbaseClient.getInstance().getConnection();
            Table table;
            try {
                table = conn
                        .getTable(TableName.valueOf(SmcHbaseConstant.TableName.STL_BILL_DETAIL_DATA
                                + "_" + billTimeSn));// 月表拼上月份
            } catch (IOException e) {
                throw new SystemException(e);
            }
            if (queryBillDataDetailRequest.gethBasePager() == null) {
                hBasePagerResult = getHbaseWithoutPage(filterList, billTimeSn, tenantId, billId,
                        queryBillDetails, table, columns);
            } else {
                hBasePagerResult = getHbasePaging(queryBillDataDetailRequest.gethBasePager(),
                        filterList, billTimeSn, tenantId, billId, queryBillDetails, table, columns);
            }
        }

        ResponseHeader responseHeader = new ResponseHeader(true, "000000", "成功");
        queryBillDetailResponse.setResponseHeader(responseHeader);
        queryBillDetailResponse.sethBasePager(hBasePagerResult);
        return queryBillDetailResponse;
    }

    private HBasePager<QueryBillDetail> getHbasePaging(HBasePager<QueryBillDetail> hBasePager,
            FilterList filterList, String subYearMonth, String tenantId, Long billId,
            List<QueryBillDetail> queryBillDetails, Table table, List<String> columns) {
        HBasePager<QueryBillDetail> hBasePagerResult = new HBasePager<QueryBillDetail>();
        Scan scan = new Scan();
        // 查询第一页
        if (StringUtil.isBlank(hBasePager.getStartRow())
                && StringUtil.isBlank(hBasePager.getPreviousRow())) {
            PageFilter pageFilter = new PageFilter(hBasePager.getPageSize());
            filterList.addFilter(pageFilter);
        } else
        // 向后查一页
        if (StringUtil.isBlank(hBasePager.getStartRow())
                && !StringUtil.isBlank(hBasePager.getPreviousRow())) {
            PageFilter pageFilter = new PageFilter(hBasePager.getPageSize() + 1);
            filterList.addFilter(pageFilter);
            scan.setStartRow(hBasePager.getPreviousRow().getBytes());
        } else
        // 向前查一页
        if (!StringUtil.isBlank(hBasePager.getStartRow())) {
            PageFilter pageFilter = new PageFilter(hBasePager.getPageSize());
            filterList.addFilter(pageFilter);
            scan.setStartRow(hBasePager.getStartRow().getBytes());
        } else {
            throw new BusinessException(SmcExceptCodeConstant.PARAM_IS_NULL, "分页器参数不合法");
        }
        scan.setFilter(filterList);

        ResultScanner rs;
        try {
            rs = table.getScanner(scan);
        } catch (IOException e) {
            throw new SystemException(e);
        }
        int i = 0;
        for (Result r : rs) {
            if (i == 0 && StringUtil.isBlank(hBasePager.getStartRow())
                    && !StringUtil.isBlank(hBasePager.getPreviousRow())) {
                i++;
                continue;
            }
            i++;
            QueryBillDetail queryBillDetail = new QueryBillDetail();
            queryBillDetail.setTenantId(tenantId);
            queryBillDetail.setBillId(billId);

            Map<String, String> mapTmp = new HashMap<String, String>();
            NavigableMap<byte[], byte[]> navigableMap = r
                    .getFamilyMap(SmcHbaseConstant.FamilyName.COLUMN_DEF.getBytes());
            try{
                for (Entry<byte[], byte[]> entry : navigableMap.entrySet()) {
                    if (columns.contains(new String(entry.getKey(), "UTF-8")) ) {
                        mapTmp.put(new String(entry.getKey()), new String(entry.getValue()));
                    }
                }
            } catch (UnsupportedEncodingException e) {
                throw new BusinessException(e);
            }
            queryBillDetail.setResult(JSON.toJSONString(mapTmp));
            queryBillDetails.add(queryBillDetail);
        }
        hBasePagerResult.setResult(queryBillDetails);
        hBasePagerResult.setPageSize(queryBillDetails.size() == 0 ? 10 : queryBillDetails.size());
        return hBasePagerResult;
    }

    private HBasePager<QueryBillDetail> getHbaseWithoutPage(FilterList filterList,
            String subYearMonth, String tenantId, Long billId,
            List<QueryBillDetail> queryBillDetails, Table table, List<String> columns) {
        HBasePager<QueryBillDetail> hBasePagerResult = new HBasePager<QueryBillDetail>();
        PageFilter pageFilter = new PageFilter(500);// 不分页时只返回500条
        filterList.addFilter(pageFilter);
        Scan scan = new Scan();
        scan.setFilter(filterList);

        ResultScanner rs;
        try {
            rs = table.getScanner(scan);
        } catch (IOException e) {
            throw new SystemException(e);
        }
        for (Result r : rs) {
            QueryBillDetail queryBillDetail = new QueryBillDetail();
            queryBillDetail.setTenantId(tenantId);
            queryBillDetail.setBillId(billId);

            Map<String, String> mapTmp = new HashMap<String, String>();
            NavigableMap<byte[], byte[]> navigableMap = r
                    .getFamilyMap(SmcHbaseConstant.FamilyName.COLUMN_DEF.getBytes());
            for (Entry<byte[], byte[]> entry : navigableMap.entrySet()) {
                if (columns.contains(new String(entry.getKey()))) {
                    mapTmp.put(new String(entry.getKey()), new String(entry.getValue()));
                }
            }
            queryBillDetail.setResult(JSON.toJSONString(mapTmp));
            queryBillDetails.add(queryBillDetail);
        }
        hBasePagerResult.setResult(queryBillDetails);
        hBasePagerResult.setPageSize(queryBillDetails.size() == 0 ? 10 : queryBillDetails.size());
        return hBasePagerResult;
    }

}

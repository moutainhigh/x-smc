package com.x.ic.msg.cache;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.x.ic.msg.constants.SmcCacheConstant;
import com.x.ic.msg.constants.SmcConstants;
import com.x.ic.msg.dao.mapper.bo.StlBillDetailStyleItem;
import com.x.ic.msg.dao.mapper.bo.StlBillDetailStyleItemExample;
import com.x.ic.msg.dao.mapper.bo.StlBillStyle;
import com.x.ic.msg.dao.mapper.bo.StlBillStyleExample;
import com.x.ic.msg.dao.mapper.interfaces.StlBillDetailStyleItemMapper;
import com.x.ic.msg.dao.mapper.interfaces.StlBillStyleMapper;
import com.x.sdk.cache.base.AbstractCache;
import com.x.sdk.mcs.MCSClientFactory;
import com.x.sdk.util.CollectionUtil;

public class BillStyleCache extends AbstractCache {

	private static final Logger log = LogManager.getLogger(BillStyleCache.class);
	
	@Autowired
	private StlBillStyleMapper stlBillStyleMapper;
	@Autowired
	private StlBillDetailStyleItemMapper stlBillDetailStyleItemMapper;
    @Override
    public void write() throws Exception {
        StlBillStyleExample criteria = new StlBillStyleExample();
        criteria.createCriteria().andStateEqualTo(SmcConstants.StlBillStyle.State.NORMAL);
        List<StlBillStyle> billStyles = stlBillStyleMapper.selectByExample(
                criteria);
        if (CollectionUtil.isEmpty(billStyles)) {
            return;
        }
        for (StlBillStyle billStyle : billStyles) {
            // key:tenantId.billStyleSn,value:StlBillStyle
            StringBuilder keyOne = new StringBuilder();
            keyOne.append("TenantId:").append(billStyle.getTenantId());
            keyOne.append(".");
            keyOne.append("BillStyleSn:").append(billStyle.getBillStyleSn());
            String valueOne = JSON.toJSONString(billStyle);
            MCSClientFactory.getCacheClient(SmcCacheConstant.MSDNS).hset(SmcCacheConstant.NameSpace.BILL_STYLE_CACHE, keyOne.toString(),  valueOne);
            log.debug("NameSpace:{}",SmcCacheConstant.NameSpace.BILL_STYLE_CACHE);
            log.debug("key:{}",keyOne.toString());
            log.debug("value:{}",valueOne);
            // key:#tenantId#.#billStyleSn#.#bill.detail.item#,value:List<StlBillDetailStyleItem>
            StlBillDetailStyleItemExample billDetailStyleItemCriteria = new StlBillDetailStyleItemExample();
            billDetailStyleItemCriteria.setOrderByClause("sort_id");
            billDetailStyleItemCriteria.createCriteria().andBillStyleIdEqualTo(
                    billStyle.getBillStyleId());
            List<StlBillDetailStyleItem> stlBillDetailStyleItems = stlBillDetailStyleItemMapper.selectByExample(billDetailStyleItemCriteria);
            if (!CollectionUtil.isEmpty(stlBillDetailStyleItems)) {
                StringBuilder keyTwo = new StringBuilder();
                keyTwo.append("TenantId:").append(billStyle.getTenantId());
                keyTwo.append(".");
                keyTwo.append("BillStyleSn:").append(billStyle.getBillStyleSn());
                keyTwo.append(".");
                keyTwo.append(SmcCacheConstant.BILL_DETAIL_ITEM);
                String valueTwo = JSON.toJSONString(stlBillDetailStyleItems);
                MCSClientFactory.getCacheClient(SmcCacheConstant.MSDNS).hset(SmcCacheConstant.NameSpace.BILL_STYLE_CACHE, keyTwo.toString(), valueTwo);
                log.debug("NameSpace:{}",SmcCacheConstant.NameSpace.BILL_STYLE_CACHE);
                log.debug("key:{}",keyTwo.toString());
                log.debug("value:{}",valueTwo);
            }
        }
    }

}

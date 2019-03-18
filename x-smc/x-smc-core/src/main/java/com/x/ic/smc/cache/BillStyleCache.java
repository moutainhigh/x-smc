package com.x.ic.smc.cache;

import java.util.List;

import org.springframework.stereotype.Component;

import com.x.sdk.cache.base.AbstractCache;
import com.x.sdk.util.CollectionUtil;
import com.x.ic.smc.constants.SmcCacheConstant;
import com.x.ic.smc.constants.SmcConstants;
import com.x.ic.smc.dao.mapper.bo.StlBillDetailStyleItem;
import com.x.ic.smc.dao.mapper.bo.StlBillDetailStyleItemCriteria;
import com.x.ic.smc.dao.mapper.bo.StlBillStyle;
import com.x.ic.smc.dao.mapper.bo.StlBillStyleCriteria;
import com.x.ic.smc.dao.mapper.factory.MapperFactory;
import com.x.ic.smc.util.RedisUtil;
import com.alibaba.fastjson.JSON;

@Component
public class BillStyleCache extends AbstractCache {

    @Override
    public void write() throws Exception {
        StlBillStyleCriteria criteria = new StlBillStyleCriteria();
        criteria.createCriteria().andStateEqualTo(SmcConstants.StlBillStyle.State.NORMAL);
        List<StlBillStyle> billStyles = MapperFactory.getStlBillStyleMapper().selectByExample(
                criteria);
        if (CollectionUtil.isEmpty(billStyles)) {
            return;
        }
        for (StlBillStyle billStyle : billStyles) {
            // key:tenantId.billStyleSn,value:StlBillStyle
            StringBuilder keyOne = new StringBuilder();
            keyOne.append(billStyle.getTenantId());
            keyOne.append(".");
            keyOne.append(billStyle.getBillStyleSn());
            RedisUtil.getCacheClient().hset(SmcCacheConstant.NameSpace.BILL_STYLE_CACHE, keyOne.toString(),
                    JSON.toJSONString(billStyle));
            // key:#tenantId#.#billStyleSn#.#bill.detail.item#,value:List<StlBillDetailStyleItem>
            StlBillDetailStyleItemCriteria billDetailStyleItemCriteria = new StlBillDetailStyleItemCriteria();
            billDetailStyleItemCriteria.setOrderByClause("sort_id");
            billDetailStyleItemCriteria.createCriteria().andBillStyleIdEqualTo(
                    billStyle.getBillStyleId());
            List<StlBillDetailStyleItem> stlBillDetailStyleItems = MapperFactory
                    .getStlBillDetailStyleItemMapper().selectByExample(billDetailStyleItemCriteria);
            if (!CollectionUtil.isEmpty(stlBillDetailStyleItems)) {
                StringBuilder keyTwo = new StringBuilder();
                keyTwo.append(billStyle.getTenantId());
                keyTwo.append(".");
                keyTwo.append(billStyle.getBillStyleSn());
                keyTwo.append(".");
                keyTwo.append(SmcCacheConstant.BILL_DETAIL_ITEM);
                RedisUtil.getCacheClient().hset(SmcCacheConstant.NameSpace.BILL_STYLE_CACHE, keyTwo.toString(),
                        JSON.toJSONString(stlBillDetailStyleItems));
            }
        }
    }

}

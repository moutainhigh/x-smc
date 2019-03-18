package com.x.ic.smc.service.atom.impl;

import org.springframework.stereotype.Component;

import com.x.ic.smc.constants.SmcConstants;
import com.x.ic.smc.dao.mapper.bo.StlBillStyleCriteria;
import com.x.ic.smc.dao.mapper.factory.MapperFactory;
import com.x.ic.smc.service.atom.interfaces.IStlBillStyleAtomSV;

@Component
public class StlBillStyleAtomSVImpl implements IStlBillStyleAtomSV {

    @Override
    public boolean isValidBillStyleSn(String tenantId, String billStyleSn) {
        StlBillStyleCriteria criteria = new StlBillStyleCriteria();
        criteria.createCriteria().andTenantIdEqualTo(tenantId).andBillStyleSnEqualTo(billStyleSn)
                .andStateEqualTo(SmcConstants.StlBillStyle.State.NORMAL);
        int count = MapperFactory.getStlBillStyleMapper().countByExample(criteria);
        if (count > 0) {
            return true;
        }
        return false;
    }

}

package com.x.ic.smc.service.atom.impl;

import org.springframework.stereotype.Component;

import com.x.ic.smc.constants.SmcConstants;
import com.x.ic.smc.dao.mapper.bo.StlElementCriteria;
import com.x.ic.smc.dao.mapper.factory.MapperFactory;
import com.x.ic.smc.service.atom.interfaces.IStlElementAtomSV;

@Component
public class StlElementAtomSVImpl implements IStlElementAtomSV {

    @Override
    public boolean isValidSettlementElement(String tenantId, Long stlElementId) {
        StlElementCriteria criteria = new StlElementCriteria();
        criteria.createCriteria().andTenantIdEqualTo(tenantId).andElementIdEqualTo(stlElementId)
                .andStateEqualTo(SmcConstants.StlElement.State.NORMAL);
        int count = MapperFactory.getElementMapper().countByExample(criteria);
        if (count > 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isvalidElement(String tenantId, Long elementId) {
        StlElementCriteria criteria = new StlElementCriteria();
        criteria.createCriteria().andTenantIdEqualTo(tenantId).andElementIdEqualTo(elementId)
                .andStateEqualTo(SmcConstants.StlElement.State.NORMAL);
        int count = MapperFactory.getElementMapper().countByExample(criteria);
        if (count > 0) {
            return true;
        }
        return false;
    }

}

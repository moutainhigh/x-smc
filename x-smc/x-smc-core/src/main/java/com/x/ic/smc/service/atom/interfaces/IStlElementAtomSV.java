package com.x.ic.smc.service.atom.interfaces;

public interface IStlElementAtomSV {

    /**
     * 校验是否是有效的结算属性
     * 
     * @param tenantId
     * @param stlElementId
     * @return
     * @author mayt
     * @ApiDocMethod
     */
    boolean isValidSettlementElement(String tenantId, Long stlElementId);

    /**
     * 校验元素是否有效
     * 
     * @param tenantId
     * @param elementId
     * @author mayt
     * @ApiDocMethod
     */
    boolean isvalidElement(String tenantId, Long elementId);

}

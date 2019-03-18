package com.x.ic.smc.service.atom.interfaces;

public interface IPolicyManageAtomSV {

    /**
     * 判断政策编码是否已存在
     * 
     * @param tenantId
     * @param policyCode
     * @return
     * @author mayt
     * @ApiDocMethod
     */
    boolean isExistPolicyCode(String tenantId, String policyCode);

}

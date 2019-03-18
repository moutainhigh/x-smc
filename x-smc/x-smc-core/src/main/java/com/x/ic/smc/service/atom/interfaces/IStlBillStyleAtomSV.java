package com.x.ic.smc.service.atom.interfaces;

public interface IStlBillStyleAtomSV {

    /**
     * 校验样式编码是否有效
     * 
     * @param tenantId
     * @param billStyleSn
     * @return
     * @author mayt
     * @ApiDocMethod
     */
    boolean isValidBillStyleSn(String tenantId, String billStyleSn);

}

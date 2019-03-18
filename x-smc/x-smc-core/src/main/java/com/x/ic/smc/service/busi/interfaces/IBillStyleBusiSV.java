package com.x.ic.smc.service.busi.interfaces;

import com.x.base.vo.BaseResponse;
import com.x.ic.smc.api.billstyle.param.AddBillStyleInfo;
import com.x.ic.smc.api.billstyle.param.CancelBillStyleInfo;
import com.x.ic.smc.api.billstyle.param.UpdateBillStyleInfo;

public interface IBillStyleBusiSV {
    /**
     * 增加账单样式<br>
     * 
     * @param addBillStyleInfo
     * @author wangjl9
     * @ApiDocMethod
     */
    BaseResponse addBillStyle(AddBillStyleInfo addBillStyleInfo);

    /**
     * 修改账单样式<br>
     * 
     * @param updateBillStyleInfo
     * @author wangjl9
     * @ApiDocMethod
     */
    BaseResponse updateBillStyle(UpdateBillStyleInfo updateBillStyleInfo);

    /**
     * 账单样式注销<br>
     * 
     * @param cancelBillStyleInfo
     * @author wangjl9
     * @ApiDocMethod
     */
    BaseResponse cancleBillStyle(CancelBillStyleInfo cancelBillStyleInfo);
}

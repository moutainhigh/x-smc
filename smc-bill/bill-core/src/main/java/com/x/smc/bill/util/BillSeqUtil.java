package com.x.smc.bill.util;

import com.x.sdk.component.sequence.util.SeqUtil;
import com.x.smc.bill.constants.BillConstants.Seq;

/**
 * seq 工具类
 * @author wangluyang
 *
 */
public final class BillSeqUtil {

    private BillSeqUtil() {}

    public static String getBillDataBillIdSeq() {
        return SeqUtil.getNewId(Seq.STL_BILL_DATA_BILL_ID_SEQ, 10);
    }
}

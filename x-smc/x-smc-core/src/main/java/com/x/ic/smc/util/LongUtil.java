package com.x.ic.smc.util;

public final class LongUtil {

    private LongUtil() {
    }

    /**
     * 判断是否为空或为0<br>
     * 注意使用场景，像金额类的字段是可以为零的<br>
     * 
     * @param id
     * @return
     * @author mayt
     */
    public static boolean isEmpty(Long id) {
        if (id == null || id == 0) {
            return true;
        }
        return false;
    }
}

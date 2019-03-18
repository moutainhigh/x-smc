package com.x.ic.smc.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;


public final class ServiceFactoryUtil {
    private ServiceFactoryUtil() {
    }

    static Map<String, String> map = new HashMap<String, String>();

//    public static String getIOrderCancelAtomSVName(String busiOperCode, String tenantId) {
//        String key = IOrderCancelAtomSV.class.getSimpleName() + "." + busiOperCode;
//        if (!map.containsKey(key)) {
//            readConf();
//        }
//        String sv = map.get(key);
//        if (sv == null) {
//            throw new SystemException("获取订单取消服务失败，请检查服务组件配置[key=" + key + "]");
//        }
//        return sv;
//
//    }

//    private static void readConf() throws SystemException {
//        InputStream in = ServiceFactoryUtil.class.getClassLoader().getResourceAsStream(
//                "service/config/service-config.properties");
//        if (in == null) {
//            throw new SystemException("读取服务组件配置文件失败");
//        }
//        Properties p = new Properties();
//        try {
//            p.load(in);
//        } catch (IOException e) {
//            throw new SystemException(e);
//        }
//        Iterator<Entry<Object, Object>> it = p.entrySet().iterator();
//        while (it.hasNext()) {
//            Entry<Object, Object> entry = it.next();
//            String key = StringUtil.toString(entry.getKey());
//            String value = StringUtil.toString(entry.getValue());
//            map.put(key, value);
//        }
//
//    }

//    public static String getIOrderInstallServiceAtomSVName(String busiOperCode, String tenantId) {
//        String key = IOrderInstallServiceAtomSV.class.getSimpleName() + "." + busiOperCode;
//        if (!map.containsKey(key)) {
//            readConf();
//        }
//        String sv = map.get(key);
//        if (sv == null) {
//            throw new SystemException("获取订单开通服务失败，请检查服务组件配置[key=" + key + "]");
//        }
//        return sv;
//
//    }
}

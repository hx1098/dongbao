package com.hx.dongbao.utils;

import org.apache.logging.log4j.util.PropertySource;

import java.util.*;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2022/5/9 20:32
 * @description
 * @editUser hx
 * @editTime 2022/5/9 20:32
 * @editDescription 生成sign
 */
public class CheckUtil {

    /**
     * app secret 和 appId  一一对应
     */
    public static String appSecret = "14g123432ds";

    /**
     * 根据map生成签名
     */
    public static String generatorSign(Map<String, Object> map) {
        //   排序
        Map<String, Object> map1 = sortMapKey(map);
        //    转格式
        Set<Map.Entry<String, Object>> entries = map1.entrySet();
        //    组装secret
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Object> entry : entries) {
            sb.append(entry.getKey() + "," + entry.getValue()).append("#");
        }

        sb.append("secret").append(appSecret);
        //生成签名
        return MD5Util.md5(sb.toString());
    }

    //排序
    public static Map<String, Object> sortMapKey(Map<String, Object> map) {
        Map<String, Object> sortMap = new TreeMap<>(new MyMapComparator());
        return sortMap;
    }

    private static class MyMapComparator implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            return o1.compareTo(o2);
        }
    }

    public static void main(String[] args) {
        HashMap map = new HashMap();
        map.put("appId", 1);
        map.put("name", 2);
        map.put("timestamp", 1652102502616L);
        //9ba15cc8852ab58bdc0772363e2324c1
        String s = generatorSign(map);
        System.out.println(s);

    }
}

package com.unicdata.util;

import java.util.*;

/**
 * @Description: map使用工具
 * @Author: muchunfa
 * @CreateDate: 2018/3/1 14:58
 */
public class MapUtil {
    /**
     *升序
     * @param map
     */
    public static void sortAS(Map<Object,Object> map) {
        List<Map.Entry<Object,Object>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Object, Object>>() {
            @Override
            public int compare(Map.Entry<Object, Object> o1, Map.Entry<Object, Object> o2) {
                return String.valueOf(o1.getKey()).compareTo(String.valueOf(o2.getKey()));
            }
        });
    }
}

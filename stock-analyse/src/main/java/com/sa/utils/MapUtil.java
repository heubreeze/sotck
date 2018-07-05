package com.sa.utils;

import java.util.Arrays;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class MapUtil {
    /**
     * map排序
     * @Authoer xuguoyin
     * @param 
     * @Date 2015年8月10日 下午2:19:48
     * @return
     */
    public static <T> SortedMap<String, T> mapSortByKey(Map<String, T> unsort_map) {
        TreeMap<String, T> result = new TreeMap<String, T>();

        Object[] unsort_key = unsort_map.keySet().toArray();
        Arrays.sort(unsort_key);

        for (int i = 0; i < unsort_key.length; i++) {
            result.put(unsort_key[i].toString(), unsort_map.get(unsort_key[i]));
        }
        return result.tailMap(result.firstKey());
    }
}

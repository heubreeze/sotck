package com.sa.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class PropertiesHelper {

    protected static final Logger      LOG      = LogManager.getLogger(PropertiesHelper.class);

    private static final String[]      fileName = { "/properties/config.properties" };

    private static Map<Object, Object> map      = null;

    private PropertiesHelper() {

    }

    public synchronized static void init() {
        InputStream in = null;

        try {
            map = new HashMap<Object, Object>();
            for (String name : fileName) {
                in = PropertiesHelper.class.getResourceAsStream(name);
                Properties props = new Properties();
                props.load(in);
                Set<Object> keys = props.keySet();
                for (Object o : keys) {
                    Object t = props.get(o);
                    map.put(o, t);
                }
                in.close();
            }

        } catch (IOException e) {
            LOG.error("[search-properties]:" + fileName + "读取失败�?");
        } finally {
            try {
                if (in != null)
                    in.close();
            } catch (IOException e) {
                LOG.error("[search-properties]:" + fileName + "关闭失败�?");
            }
        }
    }

    public static String getProperty(String key) {
        if (map == null)
            init();
        try {
            if (LOG.isDebugEnabled()) {
                LOG.debug("没有转换前的配置信息�?" + (String) map.get(key));
            }
            return (String) map.get(key);
        } catch (Exception e) {
            LOG.error("[search-properties]:读取" + key + "属�?�异�?" + e);
            return null;
        }
    }

    /**
     * 从配置文件中获取�?有的特殊转义字符
     */
    private static Map<String, String> getStringRegex() {
        String str = PropertiesHelper.getProperty("stringRegex");
        Map<String, String> map = new HashMap<String, String>();
        if (null == str || str.trim().length() <= 0) {
            return null;
        }
        for (String s : str.split(",")) {
            if (null == s || s.trim().length() <= 0) {
                continue;
            }
            String[] mark = s.split("-");
            if (mark.length > 0) {
                map.put(mark[0].toString(), mark[1].toString());
            }
        }
        return map;
    }

    /**
     * 过滤字符串中�?要转义的html标记
     * 
     * @param str
     * @return
     */
    public static String regexString(String str) {
        if (null == str || str.trim().length() <= 0)
            return null;
        Map<String, String> map = getStringRegex();
        if (null != map) {
            for (String regex : map.keySet()) {
                String replacement = map.get(regex);
                str = str.replaceAll(regex, replacement);
            }
        }
        return str;
    }
}
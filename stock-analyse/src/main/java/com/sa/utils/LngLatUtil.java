package com.sa.utils;

/**
 * 有关经纬度计算的工具类
 *                       
 * @Filename: LngLatUtil.java
 * @Version: 1.0
 * @Author: xuguoyin
 *
 */
public class LngLatUtil {
    private final static double EARTH_RADIUS = 6378.137; //地球半径

    public static double rad(double d) {
        return d * Math.PI / 180.0000;
    }

    /**
     * 获得两点间距离
     * @param lat1 第一点维度
     * @param lng1 第一点经度
     * @param lat2 第二点维度
     * @param lng2 第二点经度
     * @return
     */
    public static double GetDistance(double lat1, double lng1, double lat2, double lng2) {
        double radLat1 = rad(lat1);
        double radLat2 = rad(lat2);
        double a = radLat1 - radLat2;
        double b = rad(lng1) - rad(lng2);

        double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a / 2), 2) + Math.cos(radLat1)
                                           * Math.cos(radLat2) * Math.pow(Math.sin(b / 2), 2)));
        s = s * EARTH_RADIUS;
        //        s = Math.round(s * 1000000) / 1000000;
        return s;
    }

    public static void main(String[] args) {
        double ss = GetDistance(30.7532074, 120.725336, 30.759241, 120.732045);
        System.out.println(ss);

    }
}

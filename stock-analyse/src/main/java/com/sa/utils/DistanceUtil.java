package com.sa.utils;

/**
 * 计算两个经纬度之间的距离
 * 和sql计算规则一致
 * @Author: xuguoyin                     
 * @Filename: DistanceUtil.java
 * @Version: 1.0
 * @Date 2016年4月15日 上午9:48:21
 * @Description 
 * All rights Reserved, Designed By xuguoyin
 * Comapy JiuChaCha JiaXin LTD .
 */
public class DistanceUtil {
    private static double EARTH_RADIUS = 6378.137;

    private static double rad(double d) {
        return d * Math.PI / 180.0;
    }

    // 返回值单位米
    public static double GetDistance(double lng1, double lat1, double lng2, double lat2) {
        double radLat1 = rad(lat1);
        double radLat2 = rad(lat2);
        double a = radLat1 - radLat2;
        double b = rad(lng1) - rad(lng2);
        double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a / 2), 2) + Math.cos(radLat1)
                                           * Math.cos(radLat2) * Math.pow(Math.sin(b / 2), 2)));
        s = s * EARTH_RADIUS;
        s = Math.round(s * 10000 * 1000) / 10000;
        //     s = Math.round(s * 10000) / 10000;
        return s;
    }

    public static void main(String[] args) {
        Double s = GetDistance(120.682524, 30.763577, 120.6568769285629, 30.79944105783053);
        System.out.println("s===>" + s);
    }
}

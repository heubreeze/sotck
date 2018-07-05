package com.sa.utils;

import java.math.BigDecimal;
import java.util.Random;

public class DoubleUtil {
    /**
     * bigdecimal转double
     * @Authoer xuguoyin
     * @param 
     * @Date 2015年8月6日 下午2:19:27
     * @return
     */
    public static Double converto2Double(BigDecimal b) {
        if (b == null) {
            b = new BigDecimal(0.0);
        }
        Double d = b.doubleValue();
        return d;
    }

    /**
     * 保留任意位小数
     */
    public static Double saveManyDecimal(Double d, int i) {
        if (d == null) {
            d = 0d;
        }
        Double f = d;
        BigDecimal b = new BigDecimal(f);
        Double f1 = b.setScale(i, BigDecimal.ROUND_HALF_UP).doubleValue();
        return f1;
    }

    /**
     * 得到0.01到max的保留两位小数的double
     * @Authoer xuguoyin
     * @param 
     * @Date 2016年3月14日 下午4:11:20
     * @return
     */
    public static Double getRandomDouble(Integer max) {
        Random r = new Random();
        Double result = saveManyDecimal(r.nextDouble() * max, 2);
        return result;
    }

    public static Double nullSafe(Double d) {
        return d == null ? 0.0 : d;
    }

    public static void main(String[] args) {
        Double d = 0.63443;
        System.out.println(saveManyDecimal(d, 0));
    }
}

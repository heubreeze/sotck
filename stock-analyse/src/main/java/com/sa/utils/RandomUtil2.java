package com.sa.utils;

import java.util.Random;

/**
 * 
 * @Author: xuguoyin                     
 * @Filename: RandomUtil2.java
 * @Version: 1.0
 * @Date 2015年11月18日 下午3:14:36
 * @Description 
 * All rights Reserved, Designed By xuguoyin
 * Comapy JiuChaCha JiaXin LTD .
 */
public class RandomUtil2 {

    /**
     * 得到0~一万的一个随机整数
     * @Authoer xuguoyin
     * @param 
     * @Date 2015年11月18日 下午3:16:20
     * @return
     */
    public static Integer get0To10000Number() {
        Random ran = new Random();
        Float f = ran.nextFloat() * 10000;
        String ss = String.valueOf(f);
        ss = ss.substring(0, ss.indexOf("."));
        Integer result = Integer.valueOf(ss);
        return result;
    }

    /**
     * 得到0~一千的一个随机整数
     * @Authoer xuguoyin
     * @param 
     * @Date 2015年11月18日 下午5:01:21
     * @return
     */
    public static Integer get0To1000Number() {
        Random ran = new Random();
        Float f = ran.nextFloat() * 1000;
        String ss = String.valueOf(f);
        ss = ss.substring(0, ss.indexOf("."));
        Integer result = Integer.valueOf(ss);
        return result;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            Integer aa = get0To1000Number();
            if (aa <= 50) {
                System.out.println("红包");
            }
        }

    }
}

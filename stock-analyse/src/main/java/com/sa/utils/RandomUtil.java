package com.sa.utils;

public class RandomUtil {
    /** 
        * 0出现的概率为%35 
        */
    public static double rate0 = 0.35;
    /** 
        * 1出现的概率为%20 
        */
    public static double rate1 = 0.20;
    /** 
        * 2出现的概率为%20 
        */
    public static double rate2 = 0.20;
    /** 
        * 3出现的概率为%10 
        */
    public static double rate3 = 0.10;
    /** 
        * 4出现的概率为%5 
        */
    public static double rate4 = 0.05;
    /** 
        * 5出现的概率为%10 
        */
    public static double rate5 = 0.10;

    /** 
     * Math.random()产生一个double型的随机数，判断一下 
     * 例如0出现的概率为%50，则介于0到0.50中间的返回0 
        * @return int 
        * 
        */
    public static int PercentageRandom() {
        double randomNumber;
        randomNumber = Math.random();
        if (randomNumber >= 0 && randomNumber <= rate0) {
            return 0;
        } else if (randomNumber >= rate0 / 100 && randomNumber <= rate0 + rate1) {
            return 1;
        } else if (randomNumber >= rate0 + rate1 && randomNumber <= rate0 + rate1 + rate2) {
            return 2;
        } else if (randomNumber >= rate0 + rate1 + rate2
                   && randomNumber <= rate0 + rate1 + rate2 + rate3) {
            return 3;
        } else if (randomNumber >= rate0 + rate1 + rate2 + rate3
                   && randomNumber <= rate0 + rate1 + rate2 + rate3 + rate4) {
            return 4;
        } else if (randomNumber >= rate0 + rate1 + rate2 + rate3 + rate4
                   && randomNumber <= rate0 + rate1 + rate2 + rate3 + rate4 + rate5) {
            return 5;
        }
        return -1;
    }

    /** 
     * 测试主程序 
        * @param agrs 
        */
    public static void main(String[] agrs) {
        int i = 1;
        RandomUtil a = new RandomUtil();
        for (i = 0; i <= 10; i++)//打印100个测试概率的准确性  
        {
            System.out.println(a.PercentageRandom());
        }
    }
}

package com.sa.utils;

/**
 * 加密解密工具类
 * @Author: xuguoyin                     
 * @Filename: JiaMiJieMiUtil.java
 * @Version: 1.0
 * @Date 2015年8月10日 下午3:04:39
 * @Description 
 * All rights Reserved, Designed By xuguoyin
 * Comapy JiuChaCha JiaXin LTD .
 */
public class JiaMiJieMiUtil {

    // 加密算法
    public static String jiaMi(String str) {
        if (str.length() < 6) {
            int weiShu = 6 - str.length();
            switch (weiShu) {
                case 0:
                    break;
                case 1:
                    str = IntegerUtil.getRandomInteger(true, 1) + str;
                    break;
                case 2:
                    str = IntegerUtil.getRandomInteger(true, 2) + str;
                    break;
                case 3:
                    str = IntegerUtil.getRandomInteger(true, 3) + str;
                    break;
                case 4:
                    str = IntegerUtil.getRandomInteger(true, 4) + str;
                    break;
                case 5:
                    str = IntegerUtil.getRandomInteger(true, 5) + str;
                default:
                    str = IntegerUtil.getRandomInteger(true, 6);
                    break;
            }
        }
        String jiaMiResult = randomInt2String(str);
        return jiaMiResult;
    }

    /**
     * 解密算法
     * @Authoer xuguoyin
     * @param addCount 当id不足6位时，前面补全的数量
     * @Date 2015年8月10日 下午3:58:51
     * @return
     */
    public static String jieMi(String str, int addCount) {
        String jieMiResult = "";
        for (int i = 1; i <= str.length(); i++) {
            String ss = string2Int(str.substring(i - 1, i));
            jieMiResult += ss;
        }
        if (addCount > 0) {
            jieMiResult = jieMiResult.substring(addCount, jieMiResult.length());
        }
        return jieMiResult;
    }

    /**
     * 数字 转 英文字母
     * @Authoer xuguoyin
     * @param 
     * @Date 2015年8月10日 下午3:39:16
     * @return
     */
    public static String randomInt2String(String old) {
        String strResult = "";
        for (int i = 1; i <= old.length(); i++) {
            String ss = int2String(Integer.valueOf(old.substring(i - 1, i)));
            strResult += ss;
        }
        return strResult;
    }

    /**
     * int 转 String
     * @Authoer xuguoyin
     * @param 
     * @Date 2015年8月10日 下午3:38:47
     * @return
     */
    public static String int2String(int i) {
        String ss = "";
        switch (i) {
            case 0:
                ss = "a";
                break;
            case 1:
                ss = "b";
                break;
            case 2:
                ss = "c";
                break;
            case 3:
                ss = "d";
                break;
            case 4:
                ss = "e";
                break;
            case 5:
                ss = "f";
                break;
            case 6:
                ss = "g";
                break;
            case 7:
                ss = "h";
                break;
            case 8:
                ss = "i";
                break;
            case 9:
                ss = "j";
                break;

            default:
                ss = "";
                break;
        }
        return ss;
    }

    public static String string2Int(String s) {
        String ss = "";
        if (s.equals("a")) {
            ss = "0";
        } else if (s.equals("b")) {
            ss = "1";
        } else if (s.equals("c")) {
            ss = "2";
        } else if (s.equals("d")) {
            ss = "3";
        } else if (s.equals("e")) {
            ss = "4";
        } else if (s.equals("f")) {
            ss = "5";
        } else if (s.equals("g")) {
            ss = "6";
        } else if (s.equals("h")) {
            ss = "7";
        } else if (s.equals("i")) {
            ss = "8";
        } else if (s.equals("j")) {
            ss = "9";
        } else {
            ss = "";
        }
        return ss;
    }

    public static void main(String[] args) {
        String ss = jiaMi("118");
        System.out.println(ss);
    }
}

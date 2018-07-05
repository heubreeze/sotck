package com.sa.utils;

/**
 * 整数工具类
 *                       
 * @Filename: IntegerUtil.java
 * @Version: 1.0
 * @Author: xuguoyin
 *
 */
public class IntegerUtil {

    public static String getRandomInteger(boolean numberFlag, int length) {
        String retStr = "";
        String strTable = numberFlag ? "1234567890" : "1234567890abcdefghijkmnpqrstuvwxyz";
        int len = strTable.length();
        boolean bDone = true;
        do {
            retStr = "";
            int count = 0;
            for (int i = 0; i < length; i++) {
                double dblR = Math.random() * len;
                int intR = (int) Math.floor(dblR);
                char c = strTable.charAt(intR);
                if (('0' <= c) && (c <= '9')) {
                    count++;
                }
                retStr += strTable.charAt(intR);
            }
            if (count >= 2) {
                bDone = false;
            }
        } while (bDone);
        // 如果是0开头的，用1~9替换
        String ss = retStr.substring(0, 1);
        String ss2 = retStr.substring(1, retStr.length());
        if (ss.equals("0")) {
            retStr = "7" + ss2;
        }
        return retStr;
    }

    public static int get0to100Integer() {
        int ran = (int) (100 * Math.random() + 0);
        return ran;
    }

    public static int get0to200Integer() {
        int ran = (int) (200 * Math.random());
        if (ran == 0) {
            ran = 1;
        } else if (ran > 200) {
            ran = 200;
        }
        return ran;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 500; i++) {
            int ran = get0to200Integer();
            System.out.println(ran);
        }

    }
}

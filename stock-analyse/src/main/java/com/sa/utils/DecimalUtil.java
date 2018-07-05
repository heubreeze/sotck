package com.sa.utils;

import java.util.regex.Pattern;

public final class DecimalUtil {
    private static final String decimalReg = "([1-9]+[0-9]*|0)(\\.[\\d]+)?";

    public static boolean isDecimal(String str) {
        return Pattern.compile(decimalReg).matcher(str).matches();
    }

    public static void main(String[] args) {
        /* String ss = "1_23_2__3";
         String s = ss.substring(ss.indexOf("_") + 1, ss.length());
         System.out.println(s);*/
    }
}

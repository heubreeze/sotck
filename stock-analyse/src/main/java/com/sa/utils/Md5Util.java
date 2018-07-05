package com.sa.utils;

import java.security.MessageDigest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * MD5 操作类
 *                       
 * @Filename: Md5Util.java
 * @Version: 1.0
 * @Author: xuguoyin
 *
 */
public class Md5Util {
    /**
     * 转换为MD5
     * @param str
     * @return
     */
    public static String string2MD5(String str) {
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (Exception e) {
            System.out.println(e.toString());
            e.printStackTrace();
            return "";
        }
        char[] charArray = str.toCharArray();
        byte[] byteArray = new byte[charArray.length];

        for (int i = 0; i < charArray.length; i++)
            byteArray[i] = (byte) charArray[i];
        byte[] md5Bytes = md5.digest(byteArray);
        StringBuffer hexValue = new StringBuffer();
        for (int i = 0; i < md5Bytes.length; i++) {
            int val = (md5Bytes[i]) & 0xff;
            if (val < 16)
                hexValue.append("0");
            hexValue.append(Integer.toHexString(val));
        }
        return hexValue.toString();
    }

    /**
     * 加密、解密算法：加密执行一次，解密执行两次
     * @param str
     * @return
     */
    public static String convertMD5(String str) {
        char[] a = str.toCharArray();
        for (int i = 0; i < a.length; i++) {
            a[i] = (char) (a[i] ^ 't');
        }
        String s = new String(a);
        return s;
    }

    public static String JM(String inStr) {
        char[] a = inStr.toCharArray();
        for (int i = 0; i < a.length; i++) {
            a[i] = (char) (a[i] ^ 't');
        }
        String k = new String(a);
        return k;
    }

    public static String MD5(String inStr) {
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (Exception e) {
            System.out.println(e.toString());
            e.printStackTrace();
            return "";
        }
        char[] charArray = inStr.toCharArray();
        byte[] byteArray = new byte[charArray.length];

        for (int i = 0; i < charArray.length; i++)
            byteArray[i] = (byte) charArray[i];

        byte[] md5Bytes = md5.digest(byteArray);

        StringBuffer hexValue = new StringBuffer();

        for (int i = 0; i < md5Bytes.length; i++) {
            int val = (md5Bytes[i]) & 0xff;
            if (val < 16)
                hexValue.append("0");
            hexValue.append(Integer.toHexString(val));
        }

        return hexValue.toString();
    }

    public static void main(String[] args) {
        //        String s = new String("qwe123");
        //        System.out.println("原始：" + s);
        //        System.out.println("MD5后：" + string2MD5(s));
        //        System.out.println("加密的：" + convertMD5(s));
        //        System.out.println("解密的：" + convertMD5(convertMD5(s)));
        System.out.println("________");
        //        System.out.println(string2MD5(string2MD5("0210564").concat("4188")));
        //        System.out.println(string2MD5(string2MD5("aweifeg001").concat("7680"))); //spx200用户
        //        System.out.println(string2MD5(string2MD5("123123").concat("6954")));//test用户
        System.out.println("=================================================================");
        //        String pw1 = string2MD5("wwwwww");
        //        Boolean isC = judgeLogin(pw1, "e10adc3949ba59abbe56e057f20f883e", "", "0");
        //        System.out.println(isC);
        System.out.println(judgeLogin("123123", "4297f44b13955235245b2497399d7a93", null, "0"));
        System.out.println("_____________________________");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//小写的mm表示的是分钟  
        try {
            Date d = sdf.parse("0000-00-00");
            System.out.println(d);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * EC_SHOP 加密转换规则
     * @param pw1
     * @param pw2
     * @param ec_salt
     * @param salt
     * @return
     */
    public static Boolean judgeLogin(String pw1, String pw2, String ec_salt, String salt) {
        if (string2MD5(pw1).equals(pw2)) { //1
            System.out.println("1");
            return true;
        }
        if (string2MD5(string2MD5(pw1).concat(ec_salt)).equals(pw2)) {
            System.out.println("2");
            return true;
        }
        if (string2MD5(salt != null ? salt : "".concat(string2MD5(pw1))).equals(pw2)) {
            System.out.println("3");
            return true;
        }
        if (string2MD5(string2MD5(pw1).concat(salt != null ? salt : "")).equals(pw2)) {
            System.out.println("4");
            return true;
        }

        return false;

    }
}

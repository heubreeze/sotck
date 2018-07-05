package com.sa.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 字符串工具类
 * @Author: xuguoyin                     
 * @Filename: StringUtil.java
 * @Version: 1.0
 * @Date 2015年9月4日 上午11:08:37
 * @Description 
 * All rights Reserved, Designed By xuguoyin
 * Comapy JiuChaCha JiaXin LTD .
 */
public final class StringUtil {
    private static final String regValidatorIp = "^[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}$";

    /**
     * �?查字符串是否为空
     * <p>为null或�?�长度为0视为空字符串
     * @param value 要检查的字符�?
     * @param trim 是否去掉头尾的特定字�?
     * @param trimChars 要去掉的特定字符
     * @return
     */
    public static boolean isEmpty(String value, boolean trim, char... trimChars) {
        if (trim)
            return value == null || trim(value, trimChars).length() <= 0;
        return value == null || value.length() <= 0;
    }

    /**
     * �?查字符串是否为空
     * <p>为null或�?�长度为0视为空字符串
     * @param value 要检查的字符�?
     * @param trim 是否去掉头尾的空�?
     * @return
     */
    public static boolean isEmpty(String value, boolean trim) {
        return isEmpty(value, trim, ' ');
    }

    /**
     * �?查字符串是否为空
     * <p>为null或�?�长度为0视为空字符串
     * @param value 要检查的字符�?
     * @return
     */
    public static boolean isEmpty(String value) {
        return isEmpty(value, false);
    }

    /**
     * 如果为null，转换为""
     * @param value
     * @return
     */
    public static String nullSafeString(String value) {
        return value == null ? "" : value;
    }

    /**
     * 确保存入数据库的string值不会引起数据库报错�?
     * <p>
     * 1. 数据库不允许为null，value为nul时返�?""�?<br />
     * 2. 超过�?大长度时截断字符串�??
     * @param value 要存入数据库的字符串值�??
     * @param nullable 是否允许为null�?
     * @param maxLength �?大长度�??
     * @return
     */
    public static String dbSafeString(String value, boolean nullable, int maxLength) {
        if (value == null) {
            if (nullable)
                return null;
            return nullSafeString(value);
        }
        if (value.length() > maxLength)
            return value.substring(0, maxLength);
        return value;
    }

    /**
     * 去掉头尾空格字符
     * @param value 待处理的字符�?
     * @return
     */
    public static String trim(String value) {
        return trim(3, value, ' ');
    }

    /**
     * 去除字符串头尾的特定字符
     * 
     * @param value 待处理的字符�?
     * @param chars �?要去掉的特定字符
     * @return
     */
    public static String trim(String value, char... chars) {
        return trim(3, value, chars);
    }

    /**
     * 去除字符串头部的特定字符
     * 
     * @param value 待处理的字符�?
     * @param chars �?要去掉的特定字符
     * @return
     */
    public static String trimStart(String value, char... chars) {
        return trim(1, value, chars);
    }

    /**
     * 去除字符串尾部的特定字符
     * @param value 待处理的字符�?
     * @param chars �?要去掉的特定字符
     * @return
     */
    public static String trimEnd(String value, char... chars) {
        return trim(2, value, chars);
    }

    /**
     * 去掉字符串头尾特定字�?
     * @param mode 
     * <li>1: 去掉头部特定字符�?
     * <li>2: 去掉尾部特定字符�?
     * <li>3: 去掉头尾特定字符�?
     * @param value 待处理的字符�?
     * @param chars �?要去掉的特定字符
     * @return
     */
    private static String trim(int mode, String value, char... chars) {
        if (value == null || value.length() <= 0)
            return value;

        int startIndex = 0, endIndex = value.length(), index = 0;
        if (mode == 1 || mode == 3) {
            // trim头部
            while (index < endIndex) {
                if (contains(chars, value.charAt(index++))) {
                    startIndex++;
                    continue;
                }
                break;
            }
        }

        if (startIndex >= endIndex)
            return "";

        if (mode == 2 || mode == 3) {
            // trim尾部
            index = endIndex - 1;
            while (index >= 0) {
                if (contains(chars, value.charAt(index--))) {
                    endIndex--;
                    continue;
                }
                break;
            }
        }

        if (startIndex >= endIndex)
            return "";
        if (startIndex == 0 && endIndex == value.length() - 1)
            return value;

        return value.substring(startIndex, endIndex);
    }

    private static boolean contains(char[] chars, char chr) {
        if (chars == null || chars.length <= 0)
            return false;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == chr)
                return true;
        }
        return false;
    }

    /**
     * 判断是否是有效的IP地址�?
     * @param value
     * @return
     */
    public static boolean isIp(String value) {
        if (isEmpty(value))
            return false;
        return value.matches(regValidatorIp);
    }

    /**
     * 生成制定位数的英文字符串
     * @author xuguoyin
     * @param currentTime
     * @return
     */
    public static String getRandomString(int length) {
        char[] ss = new char[length];
        int i = 0;
        while (i < length) {
            int f = (int) (Math.random() * 3);
            if (f == 0)
                ss[i] = (char) ('A' + Math.random() * 26);
            else if (f == 1)
                ss[i] = (char) ('A' + Math.random() * 26);//a
            else
                ss[i] = (char) ('A' + Math.random() * 10);//0
            i++;
        }
        String is = new String(ss);
        return is;
    }

    /**
     * 得到字符串的unicode编码
     * @param source
     * @return
     */
    public static String getUnicode(String source) {
        String returnUniCode = null;
        String uniCodeTemp = null;
        for (int i = 0; i < source.length(); i++) {
            uniCodeTemp = "\\u" + Integer.toHexString(source.charAt(i));
            returnUniCode = returnUniCode == null ? uniCodeTemp : returnUniCode + uniCodeTemp;
        }
        //        System.out.print(source + " 's unicode = " + returnUniCode);
        return returnUniCode;
    }

    /**
     * 移除字符串中不是数字的非法字符
     * @Authoer xuguoyin
     * @param 
     * @Date 2015年7月31日 下午4:36:36
     * @return
     */
    public static String removeNotNumber(String str) {
        return str.replaceAll("\\D", "");
    }

    /**
     * 检测是否只含有中文、英文、数字
     * @Authoer xuguoyin
     * @param 
     * @Date 2015年8月21日 下午4:53:57
     * @return
     */
    public static boolean checkUserName(String userName) {
        String regex = "^[a-zA-Z0-9\u4E00-\u9FA5]+$";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(userName);
        return m.matches();
    }

    /**
     * 检测是否只含有英文、数字、下划线
     * @Authoer xuguoyin
     * @param 
     * @Date 2015年8月21日 下午4:55:30
     * @return
     */
    public static boolean checkUserNameOnly(String userName) {
        //        String regex = "^[a-zA-Z0-9]+$";
        String regex = "^[0-9A-Za-z_]+$";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(userName);
        return m.matches();
    }

    /**
     * 检测手机号是否合法
     * @Authoer xuguoyin
     * @param 
     * @Date 2015年8月21日 下午5:08:04
     * @return
     */
    public static boolean checkMobilePhone(String mobilePhone) {
        //        String regex = "^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$";
        //        Pattern p = Pattern.compile(regex);
        //        Matcher m = p.matcher(mobilePhone);
        //        return m.matches();
        if (mobilePhone.length() == 11) {
            return true;
        } else {
            return false;
        }

    }

    public static boolean judgeIsNumber(String s) {
        boolean isNum = s.matches("[0-9]+");
        return isNum;
    }

    public static void main(String[] args) {
        boolean ss = judgeIsNumber("$%*23556");
        System.out.println(ss);
    }

}
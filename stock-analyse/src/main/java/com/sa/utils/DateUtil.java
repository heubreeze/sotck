package com.sa.utils;

import java.sql.Timestamp;
import java.util.Calendar;

/**
 * 日期时间类
 * @Author: xuguoyin                     
 * @Filename: DateUtil.java
 * @Version: 1.0
 * @Date 2015年11月27日 下午1:44:27
 * @Description 
 * All rights Reserved, Designed By xuguoyin
 * Comapy JiuChaCha JiaXin LTD .
 */

public class DateUtil {

    /**
     * 根据生日得到年龄
     * @Authoer xuguoyin
     * @param 
     * @Date 2015年11月27日 下午1:44:48
     * @return
     */
    public static int getAgeByBirthday(java.sql.Date birthday) {
        Calendar cal = Calendar.getInstance();

        if (cal.before(birthday)) {
            throw new IllegalArgumentException("The birthDay is before Now.It's unbelievable!");
        }

        int yearNow = cal.get(Calendar.YEAR);
        int monthNow = cal.get(Calendar.MONTH) + 1;
        int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH);

        cal.setTime(birthday);
        int yearBirth = cal.get(Calendar.YEAR);
        int monthBirth = cal.get(Calendar.MONTH) + 1;
        int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);

        int age = yearNow - yearBirth;

        if (monthNow <= monthBirth) {
            if (monthNow == monthBirth) {
                // monthNow==monthBirth 
                if (dayOfMonthNow < dayOfMonthBirth) {
                    age--;
                }
            } else {
                // monthNow>monthBirth 
                age--;
            }
        }
        return age;
    }

    /**
     * yyyyMMddHhmmss格式的日期转为timestamp
     * @Authoer xuguoyin
     * @param 
     * @Date 2016年1月25日 下午3:39:07
     * @return
     */
    public static Timestamp yyyyMMddHHmmss2Timestamp(String date) {
        String reg = "(\\d{4})(\\d{2})(\\d{2})(\\d{2})(\\d{2})(\\d{2})";
        date = date.replaceAll(reg, "$1-$2-$3 $4:$5:$6");
        Timestamp t = Timestamp.valueOf(date);
        return t;
    }

    public static void main(String[] args) {
    }
}
package com.sa.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class DateUtil2 {

    public static String[] getStringDate(String date) throws ParseException {
        String[] weeks = new String[7];//返回的这周的日期
        String[] a = date.split("-");
        int week = getDayOfWeek(a[0], a[1], a[2]);//获取周几
        int minWeek = 0;
        int maxWeek = 7;
        String format = "yyyy-MM-dd";

        if (week == 1) {//如果是周日（老外是从周日开始算一周，所以有点恶心）
            weeks[6] = date;
            for (int i = 5; i >= 0; i--) {
                weeks[i] = getFormatDateAdd(getStrToDate(date, format), -1, format);
                date = weeks[i];
            }
        } else {
            int temp = week - 2;
            weeks[temp] = date;
            for (int i = temp - 1; i >= minWeek; i--) {
                weeks[i] = getFormatDateAdd(getStrToDate(date, format), -1, format);
                date = weeks[i];
            }
            date = weeks[temp];
            for (int i = temp + 1; i < maxWeek; i++) {
                weeks[i] = getFormatDateAdd(getStrToDate(date, format), 1, format);
                date = weeks[i];
            }
        }

        return weeks;
    }

    /**
    * 根据指定的年、月、日返回当前是星期几。1表示星期天、2表示星期一、7表示星期六。
    * 
    * @param year
    * @param month
    * month是从1开始的12结束
    * @param day
    * @return 返回一个代表当期日期是星期几的数字。1表示星期天、2表示星期一、7表示星期六。
    */
    public static int getDayOfWeek(String year, String month, String day) {
        Calendar cal = new GregorianCalendar(new Integer(year).intValue(),
            new Integer(month).intValue() - 1, new Integer(day).intValue());
        return cal.get(Calendar.DAY_OF_WEEK);
    }

    /**
    * 取得给定日期加上一定天数后的日期对象.
    * 
    * @param date
    * 给定的日期对象
    * @param amount
    * 需要添加的天数，如果是向前的天数，使用负数就可以.
    * @param format
    * 输出格式.
    * @return Date 加上一定天数以后的Date对象.
    */
    public static String getFormatDateAdd(Date date, int amount, String format) {
        Calendar cal = new GregorianCalendar();
        cal.setTime(date);
        cal.add(GregorianCalendar.DATE, amount);
        return getFormatDateTime(cal.getTime(), format);
    }

    /**
    * 根据给定的格式与时间(Date类型的)，返回时间字符串。最为通用。<br>
    * 
    * @param date
    * 指定的日期
    * @param format
    * 日期格式字符串
    * @return String 指定格式的日期字符串.
    */
    public static String getFormatDateTime(Date date, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }

    /**
    * 返回制定日期字符串的date格式
    * 
    * @param date
    * @param format
    * @return
    * @throws ParseException
    */
    public static Date getStrToDate(String date, String format) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.parse(date);
    }

    /**
     * 得到当前日期的29天以前的那一天的时间
     * @Authoer xuguoyin
     * @param 
     * @Date 2015年9月29日 下午4:20:27
     * @return
     */
    public static String get29DayAgoDate() {
        Calendar theCa = Calendar.getInstance();
        theCa.setTime(new Date());
        theCa.add(theCa.DATE, -29);
        Date date = theCa.getTime();
        SimpleDateFormat simp = new SimpleDateFormat("yyyy-MM-dd");
        String dateStr = simp.format(date);
        return dateStr;
    }

    /**
     * 得到当前时间 YYYYMMddHHmmss格式的
     * @Authoer xuguoyin
     * @param 
     * @Date 2016年3月11日 下午12:00:46
     * @return
     */
    public static String getCurrentTimeYYYYMMddHHmmss() {
        String msg = "";
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("YYYYMMddHHmmss");
        msg = sdf.format(date);
        return msg;
    }

    public static String getCurrentTimeYYYY_MM_dd_HH_mm_ss() {
        String msg = "";
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
        msg = sdf.format(date);
        return msg;
    }

    /**
     * 得到当月天数
     */
    public static int getCurrentMonthDayCount() {
        Calendar a = Calendar.getInstance();
        a.set(Calendar.DATE, 1);
        a.roll(Calendar.DATE, -1);
        int maxDate = a.get(Calendar.DATE);
        return maxDate;
    }

    /**
     * 得到昨天的日期
     */
    public static String getLastDay(String nowDay) {
        Date today = null;
        if (nowDay != null && !nowDay.equals("")) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            try {
                today = sdf.parse(nowDay);
            } catch (ParseException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } else {
            today = new Date(System.currentTimeMillis());
        }
        Date lastDay = new Date(today.getTime() - 24 * 60 * 60 * 1000);
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        String last = f.format(lastDay);
        return last;
    }

    /**
     * 得到今天之前的多少天
     * @Authoer xuguoyin
     * @param 
     * @Date 2016年6月1日 上午9:43:08
     * @return
     */
    public static String getSomeDayAgoDay(int i) {
        Date today = new Date(System.currentTimeMillis());
        Date thatDay = new Date(today.getTime() - i * 24 * 60 * 60 * 1000);
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        String that = f.format(thatDay);
        return that;
    }

    public static String getSomeDayAgoSomeDay(int i, String someDay) {
        Date sss = java.sql.Date.valueOf(someDay);
        Date thatDay = new Date(sss.getTime() - i * 24 * 60 * 60 * 1000);
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        String that = f.format(thatDay);
        return that;
    }

    /** 
    * 获得指定日期的前一天 
    * @param specifiedDay 
    * @return 
    * @throws Exception 
    */
    public static String getSpecifiedDayBefore(String specifiedDay) {
        //SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd"); 
        Calendar c = Calendar.getInstance();
        Date date = null;
        try {
            date = new SimpleDateFormat("yy-MM-dd").parse(specifiedDay);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        c.setTime(date);
        int day = c.get(Calendar.DATE);
        c.set(Calendar.DATE, day - 1);

        String dayBefore = new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());
        return dayBefore;
    }

    /** 
    * 获得指定日期的后一天 
    * @param specifiedDay 
    * @return 
    */
    public static String getSpecifiedDayAfter(String specifiedDay) {
        Calendar c = Calendar.getInstance();
        Date date = null;
        try {
            date = new SimpleDateFormat("yy-MM-dd").parse(specifiedDay);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        c.setTime(date);
        int day = c.get(Calendar.DATE);
        c.set(Calendar.DATE, day + 1);

        String dayAfter = new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());
        return dayAfter;
    }

    /**
     * 得到两个日期中的所有日期
     * 
     * @author xuguoyin
     * 2017年12月21日下午2:57:45
     */
    public static List<Date> getBetweenDates(Date start, Date end) {
        List<Date> result = new ArrayList<Date>();
        Calendar tempStart = Calendar.getInstance();
        tempStart.setTime(start);
        tempStart.add(Calendar.DAY_OF_YEAR, 1);

        Calendar tempEnd = Calendar.getInstance();
        tempEnd.setTime(end);
        while (tempStart.before(tempEnd)) {
            result.add(tempStart.getTime());
            tempStart.add(Calendar.DAY_OF_YEAR, 1);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(DateUtil2.getSomeDayAgoSomeDay(13, "2017-09-13"));
    }
}
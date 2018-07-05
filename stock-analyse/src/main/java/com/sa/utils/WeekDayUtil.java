package com.sa.utils;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class WeekDayUtil {
    
    /**
     * 获得当天是周几
     * @return
     */
    public static String getTodayWeekDay(){ 
        Date today = new Date();
        String result = "";
        String[] weekDays = {"星期7", "星期1", "星期2", "星期3", "星期4", "星期5", "星期6"};
        Calendar cal = Calendar.getInstance();
        cal.setTime(today);
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0)
            w = 0;
        return weekDays[w];
    } 
    
    /**
     * 判断当前时间是否在某个时间段内
     * @param time1
     * @param time2
     * @return
     */
    public static boolean judgeNowTimeInTimeScope(String strTime1,String strTime2){
        Time time1 = Time.valueOf(strTime1);
        Time time2 = Time.valueOf(strTime2);
        Date today = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String todayStr = format.format(today); 
        Long l1 = Timestamp.valueOf(todayStr+" "+time1).getTime();
        long l2 = Timestamp.valueOf(todayStr+" "+time2).getTime();
        Long now = System.currentTimeMillis();
        boolean flag = false;
        if(now>l1&&now<l2){
            flag = true;
        }
        return flag;
    }
    
    public static void main(String[] args) {
        Integer re = Integer.parseInt(WeekDayUtil.getTodayWeekDay().substring(2, 3));
        System.out.println(re);
    }
}

package com.isuperone.lining.common.helper;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.TimeZone;

/**
 * @Author yang
 * @Date: 2019/4/1 15:38
 * @Version 1.0
 */
public class DateUtil {


    public static String getISO8601Timestamp(Date date){
        TimeZone tz = TimeZone.getTimeZone("Asia/Shanghai");
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        df.setTimeZone(tz);
        String nowAsISO = df.format(date);
        System.out.println(nowAsISO);
        return nowAsISO;
    }
    public static void main(String[] args) {
        DateUtil.getISO8601Timestamp(Date.from(Instant.now()));
    }

}
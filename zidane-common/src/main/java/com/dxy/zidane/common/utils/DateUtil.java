package com.dxy.zidane.common.utils;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;

import java.text.ParseException;
import java.util.Date;

public class DateUtil {

    public static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

    public static String format() {
        return DateFormatUtils.format(new Date(), DEFAULT_DATE_FORMAT);
    }

    public static String format(Date date) {
        return DateFormatUtils.format(date, DEFAULT_DATE_FORMAT);
    }

    public static String format(String pattern) {
        return DateFormatUtils.format(new Date(), pattern);
    }

    public static String format(Date date, String pattern) {
        return DateFormatUtils.format(date, pattern);
    }

    public static Date parse(String date) {
        return parse(date, DEFAULT_DATE_FORMAT);
    }

    public static Date parse(String date, String pattern) {
        try {
            return DateUtils.parseDate(date, pattern);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(format("yyyy-MM-dd"));
        System.out.println(parse("2019-08-19 18:09:28"));
    }
}

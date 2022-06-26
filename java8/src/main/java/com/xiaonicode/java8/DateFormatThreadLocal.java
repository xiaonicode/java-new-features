package com.xiaonicode.java8;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期格式化的 ThreadLocal
 *
 * @author xiaoni
 * @since 2022-06-24
 */
public class DateFormatThreadLocal {

    private static final ThreadLocal<DateFormat> df = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyyMMdd"));

    public static Date convert(String source) throws ParseException {
        return df.get().parse(source);
    }

}

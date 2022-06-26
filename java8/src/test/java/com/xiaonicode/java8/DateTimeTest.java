package com.xiaonicode.java8;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;

/**
 * 日期和时间 API 的测试类
 * <p>
 * Java 8 在 API 层面的新特性
 *
 * @author xiaoni
 * @see <a href="https://openjdk.org/jeps/150">JEP 150: Date & Time API</a>
 * @since 2022-06-24
 */
public class DateTimeTest {

    /**
     * LocalDate, LocalTime, LocalDateTime
     */
    @Test
    public void test1() {
        LocalDateTime ldt = LocalDateTime.now();
        System.out.println(ldt);

        LocalDateTime ldt2 = LocalDateTime.of(2022, 6, 24, 13, 44, 59);
        System.out.println(ldt2);

        LocalDateTime ldt3 = ldt.plusYears(2);
        System.out.println(ldt3);

        LocalDateTime ldt4 = ldt.minusMonths(2);
        System.out.println(ldt4);

        System.out.println(ldt.getYear());
        System.out.println(ldt.getMonthValue());
        System.out.println(ldt.getDayOfMonth());
        System.out.println(ldt.getHour());
        System.out.println(ldt.getMinute());
        System.out.println(ldt.getSecond());
    }

    /**
     * Instant: 时间戳 (以 Unix 元年: 1970年1月1日 00:00:00 到某个时间之间的毫秒值)
     */
    @Test
    public void test2() {
        Instant ins1 = Instant.now(); // 默认获取以 UTC 为基础的时间
        System.out.println(ins1);

        System.out.println(ins1.toEpochMilli());

        OffsetDateTime odt = ins1.atOffset(ZoneOffset.ofHours(8));
        System.out.println(odt);

        Instant ins2 = Instant.ofEpochSecond(60);
        System.out.println(ins2);
    }

    /**
     * Duration: 计算两个 "时间" 之间的间隔<br/>
     * Period: 计算两个 "日期" 之间的间隔
     */
    @Test
    public void test3() {
        Instant ins1 = Instant.now();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Instant ins2 = Instant.now();
        Duration duration = Duration.between(ins1, ins2);
        System.out.println(duration.toMillis());

        LocalDate ld1 = LocalDate.of(2020, 1, 1);
        LocalDate ld2 = LocalDate.now();
        Period period = Period.between(ld1, ld2);
        System.out.println(period.getYears());
        System.out.println(period.getMonths());
        System.out.println(period.getDays());
    }

    /**
     * TemporalAdjuster: 时间校正器
     */
    @Test
    public void test4() {
        LocalDateTime ldt1 = LocalDateTime.now();
        System.out.println(ldt1);

        LocalDateTime ldt2 = ldt1.withDayOfMonth(10);
        System.out.println(ldt2);

        LocalDateTime ldt3 = ldt1.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));
        System.out.println(ldt3);

        // 计算下一个工作日
        LocalDateTime ldt4 = ldt1.with(temporal -> {
            LocalDateTime ldt = (LocalDateTime) temporal;
            DayOfWeek dow = ldt.getDayOfWeek();
            if (dow.equals(DayOfWeek.FRIDAY)) {
                return ldt.plusDays(3);
            } else if (dow.equals(DayOfWeek.SATURDAY)) {
                return ldt.plusDays(2);
            } else {
                return ldt.plusDays(1);
            }
        });
        System.out.println(ldt4);
    }

    /**
     * DateTimeFormatter: 格式化时间 / 日期
     */
    @Test
    public void test5() {
        LocalDateTime ldt = LocalDateTime.now();

        DateTimeFormatter dtf1 = DateTimeFormatter.ISO_DATE;
        System.out.println(ldt.format(dtf1));

        DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String dateTimeStr = ldt.format(dtf2);
        System.out.println(dateTimeStr);

        LocalDateTime ldt2 = LocalDateTime.parse(dateTimeStr, dtf2);
        System.out.println(ldt2);
    }

    /**
     * ZonedDate, ZonedTime, ZonedDateTime
     */
    @Test
    public void test6() {
        // Set<String> azs = ZoneId.getAvailableZoneIds();
        // for (String az : azs) {
        //     System.out.println(az);
        // }
        LocalDateTime ldt1 = LocalDateTime.now(ZoneId.of("Asia/Shanghai"));
        System.out.println(ldt1);

        LocalDateTime ldt2 = LocalDateTime.now();
        ZonedDateTime zdt = ldt2.atZone(ZoneId.of("Asia/Shanghai"));
        System.out.println(zdt);
    }

}

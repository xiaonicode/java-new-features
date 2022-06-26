package com.xiaonicode.java8;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

/**
 * 日期格式化的测试类
 *
 * @author xiaoni
 * @since 2022-06-24
 */
public class DateFormatTest {

    private ExecutorService pool;

    @Before
    public void setUp() {
        pool = Executors.newFixedThreadPool(10);
    }

    @After
    public void tearDown() {
        pool.shutdown();
    }

    /**
     * {@link SimpleDateFormat}
     */
    @Test
    public void test1() throws ExecutionException, InterruptedException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Callable<Date> task = () -> sdf.parse("20220624");

        List<Future<Date>> res = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            res.add(pool.submit(task));
        }

        for (Future<Date> future : res) {
            System.out.println(future.get());
        }

    }

    /**
     * {@link ThreadLocal}
     */
    @Test
    public void test2() throws ExecutionException, InterruptedException {
        Callable<Date> task = () -> DateFormatThreadLocal.convert("20220624");

        List<Future<Date>> res = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            res.add(pool.submit(task));
        }

        for (Future<Date> future : res) {
            System.out.println(future.get());
        }

    }

    /**
     * Java 8 Time
     * <p>
     * {@link DateTimeFormatter}, {@link LocalDate}
     *
     * @see <a href="https://openjdk.org/jeps/150">JEP 150: Date & Time API</a>
     */
    @Test
    public void test3() throws ExecutionException, InterruptedException {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd");
        Callable<LocalDate> task = () -> LocalDate.parse("20220624", dtf);

        List<Future<LocalDate>> res = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            res.add(pool.submit(task));
        }

        for (Future<LocalDate> future : res) {
            System.out.println(future.get());
        }
    }

}

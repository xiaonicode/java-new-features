package com.xiaonicode.java9;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

/**
 * Stream API 的测试类
 * <p>
 * 在 Java 9 中, 新增
 * {@link Stream#takeWhile(Predicate)},
 * {@link Stream#dropWhile(Predicate)},
 * {@link Stream#ofNullable(Object)},
 * {@link Stream#iterate(Object, UnaryOperator)},
 * {@link Stream#iterate(Object, Predicate, UnaryOperator)}
 *
 * @author xiaoni
 * @since 2022-06-24
 */
public class StreamTest {

    @Test
    public void test1() {
        List<Integer> list = Arrays.asList(45, 56, 33, 77, 44, 98, 76, 78, 33);
        list.stream()
                .takeWhile(x -> x < 70)
                .forEach(System.out::println);
    }

    @Test
    public void test2() {
        List<Integer> list = Arrays.asList(45, 56, 33, 77, 44, 98, 76, 78, 33);
        list.stream()
                .dropWhile(x -> x < 70)
                .forEach(System.out::println);
    }

    @Test
    public void test3() {
        Stream<Integer> stream1 = Stream.of(1, 2, 3, null);
        stream1.forEach(System.out::println);

        // java.lang.NullPointerException: Cannot read the array length because "array" is null
        // Stream<Object> stream2 = Stream.of(null);

        Stream<Object> stream3 = Stream.ofNullable("Tom");
        System.out.println(stream3.count());

        Stream<Object> stream4 = Stream.ofNullable(null);
        System.out.println(stream4.count());
    }

    @Test
    public void test4() {
        Stream.iterate(0, x -> x + 2)
                .limit(10)
                .forEach(System.out::println);

        System.out.println("=========================");

        Stream.iterate(0, x -> x < 10, x -> x + 2)
                .forEach(System.out::println);
    }

}

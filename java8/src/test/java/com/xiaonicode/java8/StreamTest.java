package com.xiaonicode.java8;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Stream;

/**
 * Stream API 的测试类
 * <p>
 * Java 8 在 API 层面的新特性
 *
 * @author xiaoni
 * @since 2022-06-23
 */
public class StreamTest {

    /**
     * Stream 的步骤一: 创建 Stream
     */
    @Test
    public void test1() {
        // 1. 通过 Collection 系列集合提供的 stream() 或 parallelStream()
        List<String> list = new ArrayList<>();
        Stream<String> stream1 = list.stream();

        // 2. 通过 Arrays 中静态方法 stream() 获取数组流
        String[] strs = new String[10];
        Stream<String> stream2 = Arrays.stream(strs);

        // 3. 通过 Stream 类中的静态方法 of()
        Stream<String> stream3 = Stream.of("aa", "bb", "cc");

        // 4. 创建无限流
        // 迭代
        Stream<Integer> stream4 = Stream.iterate(0, x -> x + 2);
        // 生成
        Stream<Double> stream5 = Stream.generate(Math::random);
    }

    List<Employee> employees = Arrays.asList(
            new Employee("张三", 18, 9999.99),
            new Employee("李四", 38, 5555.99),
            new Employee("王五", 50, 6666.66),
            new Employee("赵六", 16, 3333.33),
            new Employee("田七", 8, 7777.77)
    );

    /**
     * Stream 的步骤二: 中间操作
     * <p>
     * 1) 筛选与切片:<br/>
     * {@link Stream#filter(Predicate)}: 接收 Lambda, 从流中排除某些元素<br/>
     * {@link Stream#limit(long)}: 截断流, 使其元素不超过给定元素<br/>
     * {@link Stream#skip(long)}: 跳过元素, 返回一个扔掉了前 n 个元素的流. 若流中元素不足 n 个, 则返回一个空流, 与 limit(n) 互补<br/>
     * {@link Stream#distinct()}: 筛选, 通过流所生成元素的 hashCode() 和 equals() 去除重复元素
     * <p>
     * 2) 映射:<br/>
     * {@link Stream#map(Function)}: 接收 Lambda, 将元素转换成其他形式或提取信息. 接收一个函数作为参数, 该函数会被应用到每个元素上, 并将其映射成一个新的元素<br/>
     * {@link Stream#flatMap(Function)}: 接收一个函数作为参数, 将流中的每个值都换成另一个流, 然后把所有流连接成一个流
     * <p>
     * 3) 排序:<br/>
     * {@link Stream#sorted()}: 自然排序 (Comparable)<br/>
     * {@link Stream#sorted(Comparator)}: 定制排序 (Comparator)
     */
    @Test
    public void test2() {
        // 中间操作: 不会执行任何操作
        // 终止操作: 一次性执行全部内容, 即 "惰性求值"

        // filter
        Stream<Employee> stream1 = employees.stream()
                .filter(account -> {
                    System.out.println("Stream 的中间操作");
                    return account.getId() > 102;
                });
        stream1.forEach(System.out::println);

        System.out.println("======================================");

        // limit
        employees.stream()
                .filter(account -> {
                    System.out.println("短路!");
                    return account.getSalary() > 20000;
                })
                .limit(2)
                .forEach(System.out::println);

        System.out.println("======================================");

        // skip, distinct
        employees.stream()
                .filter(account -> account.getSalary() > 20000)
                .skip(2)
                .distinct()
                .forEach(System.out::println);

        System.out.println("======================================");

        List<String> strs = Arrays.asList("bb", "aa", "cc", "dd", "ee");

        // map
        strs.stream()
                .map(String::toUpperCase)
                .forEach(System.out::println);

        System.out.println("======================================");

        employees.stream()
                .map(Employee::getName)
                .forEach(System.out::println);

        System.out.println("======================================");

        strs.stream()
                .map(StreamTest::filterCharacter) // { {a, a}, {b, b} }
                .forEach(cs -> cs.forEach(System.out::println));

        System.out.println("======================================");

        // flatMap
        strs.stream()
                .flatMap(StreamTest::filterCharacter) // // { a, a, b, b }
                .forEach(System.out::println);

        System.out.println("======================================");

        // sorted()
        strs.stream()
                .sorted()
                .forEach(System.out::println);

        System.out.println("======================================");

        // sorted(Comparator com)
        employees.stream()
                .sorted((a1, a2) -> {
                    if (a1.getName().equals(a2.getName())) {
                        return a1.getId().compareTo(a2.getId());
                    } else {
                        return a1.getName().compareTo(a2.getName());
                    }
                }).forEach(System.out::println);
    }

    private static Stream<Character> filterCharacter(String str) {
        List<Character> res = new ArrayList<>();
        for (Character ch : str.toCharArray()) {
            res.add(ch);
        }
        return res.stream();
    }

    /**
     * Stream 的步骤三: 终止操作
     * <p>
     * 1) 查找与匹配:<br/>
     * {@link Stream#allMatch(Predicate)}: 检查是否匹配所有元素<br/>
     * {@link Stream#anyMatch(Predicate)}: 检查是否至少匹配一个元素<br/>
     * {@link Stream#noneMatch(Predicate)}: 检查是否没有匹配所有元素<br/>
     * {@link Stream#findFirst()}: 返回第一个元素<br/>
     * {@link Stream#findAny()}: 返回当前流中的任意元素<br/>
     * {@link Stream#count()}: 返回流中元素的总个数<br/>
     * {@link Stream#max(Comparator)}: 返回流中最大值<br/>
     * {@link Stream#min(Comparator)}: 返回流中最小值<br/>
     * <p>
     * 2) 归约:<br/>
     * {@link Stream#reduce(Object, BinaryOperator)} / {@link Stream#reduce(BinaryOperator)}: 可以将流中元素反复结合起来, 得到一个值
     * <p>
     * 3) 收集<br/>
     * {@link Stream#collect(Collector)}: 将流转换为其他形式. 接收一个 Collector 接口的实现, 用于给 Stream 中元素做汇总的方法
     */
    @Test
    public void test3() {

    }

}

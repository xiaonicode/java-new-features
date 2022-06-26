package com.xiaonicode.java9;

import org.junit.Test;

import java.util.*;

/**
 * 集合框架的测试类
 *
 * @author xiaoni
 * @since 2022-06-24
 */
public class CollectionMapTest {

    /**
     * Java 8 及之前创建一个只读的集合
     */
    @Test
    public void test1() {
        // list:
        List<Integer> list = Collections.unmodifiableList(Arrays.asList(1, 2, 3));
        // list.add(4);
        list.forEach(System.out::println);

        // set:
        Set<Integer> set = Collections.unmodifiableSet(new HashSet<>(Arrays.asList(1, 2, 3)));
        // set.add(4);
        set.forEach(System.out::println);

        // map:
        Map<String, Integer> map = Collections.unmodifiableMap(new HashMap<String, Integer>() {
            {
                put("Tom", 78);
                put("Jerry", 88);
                put("Lilei", 58);
            }
        });
        // map.put("Tim", 98);
        map.forEach((k, v) -> System.out.println(k + ":" + v));
    }

    /**
     * Java 9 使用集合工厂创建一个只读的集合
     *
     * @see <a href="https://openjdk.org/jeps/269">JEP 269: Convenience Factory Methods for Collections</a>
     */
    @Test
    public void test2() {
        // list:
        List<Integer> list = List.of(1, 2, 3);
        // list.add(4);
        list.forEach(System.out::println);

        // set:
        Set<Integer> set = Set.of(1, 2, 3);
        // set.add(4);
        set.forEach(System.out::println);

        // map:
        Map<String, Integer> map1 = Map.of(
                "Tom", 78,
                "Jerry", 88,
                "Lilei", 58
        );
        // map1.put("Tim", 98);
        map1.forEach((k, v) -> System.out.println(k + ":" + v));

        Map<String, Integer> map2 = Map.ofEntries(
                Map.entry("Tom", 78),
                Map.entry("Jerry", 88),
                Map.entry("Lilei", 58)
        );
        // map2.put("Tim", 98);
        map2.forEach((k, v) -> System.out.println(k + ":" + v));
    }

}

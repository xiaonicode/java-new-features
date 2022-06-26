package com.xiaonicode.java9;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * Optional 的测试类
 * <p>
 * 在 Java 9 中, 新增 {@link Optional#stream()}
 *
 * @author xiaoni
 * @since 2022-06-24
 */
public class OptionalTest {

    @Test
    public void test1() {
        List<String> list = new ArrayList<>();

        list.add("Tom");
        list.add("Jerry");
        list.add("Lilei");

        Optional<List<String>> optional = Optional.of(list);

        Stream<String> stream = optional.stream().flatMap(Collection::stream);

        stream.forEach(System.out::println);
    }

}

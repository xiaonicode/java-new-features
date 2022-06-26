package com.xiaonicode.java11;

import org.junit.Test;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * Optional 的测试类
 * <p>
 * 在 Java 11 中, 新增
 * {@link Optional#isEmpty()},
 * {@link Optional#orElseThrow()},
 * {@link Optional#orElseThrow(Supplier)},
 * {@link Optional#or(Supplier)},
 * {@link Optional#ifPresentOrElse(Consumer, Runnable)}
 *
 * @author xiaoni
 * @since 2022-06-25
 */
public class OptionalTest {

    @Test
    public void test1() {
        // isEmpty(): Java 11 新增
        var optional1 = Optional.empty();
        System.out.println(optional1.isPresent()); // 判断内部的 value 是否存在
        System.out.println(optional1.isEmpty()); // 判断内部的 value 是否为空

        // orElseThrow(): Java 10 新增
        // value非空, 返回value; 否则抛异常 NoSuchElementException
        optional1 = Optional.of("abc");
        var obj = optional1.orElseThrow();
        System.out.println(obj);

        // optional1 = Optional.empty();
        var optional2 = Optional.of("Hello");
        // or(): Java 9 新增
        // value 非空, 返回对应的 Optional; value 为空, 返回形参封装的 Optional
        var optional3 = optional1.or(() -> optional2);
        System.out.println(optional3.get());

        // ifPresentOrElse(): Java 9 新增
    }

}

package com.xiaonicode.java8;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

// TODO 确定新特性出处

/**
 * 钻石操作符的测试类
 *
 * @author xiaoni
 * @see <a href="https://openjdk.org/jeps/101">JEP 101: Generalized Target-Type Inference</a>
 * @since 2022-06-24
 */
public class DiamondOperatorTest {

    @Test
    public void test1() {
        Set<String> set = new HashSet<>(); // 类型推断, 省略钻石操作符中的泛型
        // Set<String> set = new HashSet<String>(){}; // 此处, 在 Java 8 中的钻石操作符要带泛型

        set.add("MM");
        set.add("JJ");
        set.add("GG");
        set.add("DD");

        for (String s : set) {
            System.out.println(s);
        }
    }

}

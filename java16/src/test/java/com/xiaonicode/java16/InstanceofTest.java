package com.xiaonicode.java16;

import org.junit.Test;

/**
 * Instanceof 模式匹配的测试类
 * <p>
 * Instanceof 模式匹配最先在 java 14 中进行预览发布, 在 Java 15 中处于第二次预览, 最后正式发布于 Java 16.<br/>
 * 该模式匹配省去了显式强制类型转换
 *
 * @author xiaoni
 * @see <a href="https://openjdk.org/jeps/305">JEP 305: Pattern Matching for instanceof (Preview)</a>
 * @see <a href="https://openjdk.org/jeps/375">JEP 375: Pattern Matching for instanceof (Second Preview)</a>
 * @see <a href="https://openjdk.org/jeps/394">JEP 394: Pattern Matching for instanceof</a>
 * @since 2022-06-25
 */
public class InstanceofTest {

    @Test
    public void test1() {
        Object obj = "Hello World!";
        if (obj instanceof String) {
            String str = (String) obj;
            System.out.println(str.contains("World"));
        } else {
            System.out.println("非String类型");
        }
    }

    @Test
    public void test2() {
        Object obj = "Hello World!";
        if (obj instanceof String str) {
            System.out.println(str.contains("World"));
        } else {
            System.out.println("非String类型");
        }
    }

}

class Monitor {

    private String model;
    private double price;

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Monitor other) {
            return model.equals(other.model) && price == other.price;
        }
        return false;
    }

}

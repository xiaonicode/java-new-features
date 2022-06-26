package com.xiaonicode.java11;

import org.junit.Test;

/**
 * String 类的测试类
 * <p>
 * 在 Java 11 中, 新增
 * {@link String#isBlank()},
 * {@link String#strip()},
 * {@link String#stripTrailing()},
 * {@link String#stripLeading()},
 * {@link String#repeat(int)},
 * {@link String#lines()} 等
 *
 * @author xiaoni
 * @since 2022-06-25
 */
public class StringTest {

    @Test
    public void test1() {
        System.out.println(" \t \t \n ".isBlank());
        System.out.println("--------" + " \t abc \t \n ".strip() + "--------");
        System.out.println("--------" + " \t abc \t \n ".stripTrailing() + "--------");
        System.out.println("--------" + " \t abc \t \n ".stripLeading() + "--------");

        var str1 = "abc";
        var str2 = str1.repeat(5);
        System.out.println(str2);

        var str3 = "abc\ndef\ng";
        System.out.println(str3.lines().count());
    }

}

package com.xiaonicode.java9;

import org.junit.Test;

/**
 * 下划线标识的测试类
 *
 * @author xiaoni
 * @since 2022-06-24
 */
public class UnderScoreTest {

    @Test
    public void test1() {
        // String _ = "Hello"; // As of Java 9, '_' is a keyword, and may not be used as an identifier

        String _hello = "beijing";
        System.out.println(_hello);
    }

}

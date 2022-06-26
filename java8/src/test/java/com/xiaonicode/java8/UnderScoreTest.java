package com.xiaonicode.java8;

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
        String _ = "Hello"; // Use of '_' as an identifier is not supported in releases since Java 9
        System.out.println(_);

        String _hello = "beijing";
        System.out.println(_hello);
    }

}

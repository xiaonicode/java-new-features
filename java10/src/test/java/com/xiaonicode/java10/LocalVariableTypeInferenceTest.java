package com.xiaonicode.java10;

import org.junit.Test;

import java.util.ArrayList;

/**
 * 局部变量类型推断的测试类
 *
 * @author xiaoni
 * @see <a href="http://openjdk.java.net/jeps/286">JEP 286: Local-Variable Type Inference</a>
 * @since 2022-06-25
 */
public class LocalVariableTypeInferenceTest {

    @Test
    public void test1() {
        var num = 10;

        var list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);

        for (var i : list) {
            System.out.println(i);
            System.out.println(i.getClass());
        }

        for (var i = 0; i < 10; i++) {
            System.out.println(i);
        }
    }

}

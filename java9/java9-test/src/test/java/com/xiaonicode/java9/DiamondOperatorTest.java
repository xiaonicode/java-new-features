package com.xiaonicode.java9;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

// TODO 确定新特性出处

/**
 * 钻石操作符的测试类
 *
 * @author xiaoni
 * @since 2022-06-24
 */
public class DiamondOperatorTest {

    @Test
    public void test1() {
        // 创建了一个继承于 HashSet 的匿名子类的对象
        Set<String> set = new HashSet<>() {
        };

        set.add("MM");
        set.add("JJ");
        set.add("GG");
        set.add("DD");

        for (String s : set) {
            System.out.println(s);
        }
    }

}

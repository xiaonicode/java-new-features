package com.xiaonicode.java11;

import org.junit.Test;

import java.util.function.Consumer;

/**
 * Lambda 参数的局部变量语法的测试类
 *
 * @author xiaoni
 * @see <a href="https://openjdk.org/jeps/323">JEP 323: Local-Variable Syntax for Lambda Parameters</a>
 * @since 2022-06-25
 */
public class LocalVariableForLambdaParamsTest {

    @Test
    public void test1() {
        // 错误的形式: 必须要有类型, 可以加上 var
        // Consumer<String> con = (@Deprecated t) -> System.out.println(t.toUpperCase());
        // 正确的形式: 使用 var 的好处是在使用 Lambda 表达式时给参数加上注解
        Consumer<String> con = (@Deprecated var t) -> System.out.println(t.toUpperCase());
    }

}

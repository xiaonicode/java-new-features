package com.xiaonicode.java8;

/**
 * 接口的测试类
 * <p>
 * 在 Java 8 中, 接口内可以声明默认方法和静态方法, 不能声明私有方法
 *
 * @author xiaoni
 * @since 2022-06-24
 */
public class MyInterfaceTest {

}

interface MyInterface {

    /**
     * Java 7: 只能声明全局常量 (public static final) 和抽象方法 (public abstract)
     */
    void method1();

    /**
     * Java 8: 声明静态方法
     */
    static void method2() {
        System.out.println("method2");
    }

    /**
     * Java 8: 声明默认方法
     */
    default void method3() {
        System.out.println("method3");
    }

}

package com.xiaonicode.java9;

import org.junit.Test;

/**
 * 接口的测试类
 * <p>
 * 在 Java 9 中, 接口内可以声明默认方法, 静态方法, 私有方法
 *
 * @author xiaoni
 * @since 2022-06-24
 */
public class MyInterfaceTest {

    @Test
    public void test() {
        MyInterfaceImpl mi = new MyInterfaceImpl();
        mi.method1();
        MyInterface.method2();
        mi.method3();
    }

}

/**
 * 抽象类 vs 接口: (Java 7, Java 8, Java 9)
 * <p>
 * 1) 两者定义: a) 声明方式; b) 内部结构<br/>
 * 2) 共同点: a) 不能实例化; b) 以多态的方式使用
 * 3) 不同点: a) 单继承; b) 多实现
 */
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

    /**
     * Java 9: 声明私有方法
     */
    private void method4() {
        System.out.println("私有方法");
    }

}

class MyInterfaceImpl implements MyInterface {

    @Override
    public void method1() {
        System.out.println("实现接口中的抽象方法method1()");
    }

}

package com.xiaonicode.java8;

import org.junit.Test;

import java.lang.annotation.Repeatable;
import java.lang.reflect.Method;

/**
 * 注解的测试类
 * <p>
 * Java 8 的新特性: {@link Repeatable} 重复注解, {@link MyAnnotation} 类型注解
 *
 * @author xiaoni
 * @see <a href="https://openjdk.org/jeps/120">JEP 120: Repeating Annotations</a>
 * @see <a href="https://openjdk.org/jeps/104">JEP 104: Type Annotations</a>
 * @since 2022-06-24
 */
public class AnnotationsTest {

    @MyAnnotation("Hello")
    @MyAnnotation("World")
    public void show() {

    }

    public void show(@MyAnnotation("abc") String str) {

    }

    @Test
    public void test1() throws NoSuchMethodException {
        Class<AnnotationsTest> clazz = AnnotationsTest.class;
        Method m1 = clazz.getMethod("show");
        MyAnnotation[] annotations = m1.getAnnotationsByType(MyAnnotation.class);
        for (MyAnnotation annotation : annotations) {
            String value = annotation.value();
            System.out.println(value);
        }
    }

}

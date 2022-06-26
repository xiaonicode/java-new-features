package com.xiaonicode.java8;

/**
 * 自定义函数式接口
 *
 * @author xiaoni
 * @since 2022-06-23
 */
@FunctionalInterface
public interface MyFunction<T> {

    T getValue(T t);

}

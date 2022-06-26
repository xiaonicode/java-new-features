package com.xiaonicode.java8;

/**
 * 自定义过滤规则
 * <p>
 * Lambda 表达式需要 "函数式接口" 的支持, 接口中只有一个抽象方法的接口, 称为函数式接口, 可以使用 @FunctionalInterface 修饰, 检查是否为函数式接口
 *
 * @author xiaoni
 * @since 2022-06-23
 */
@FunctionalInterface
public interface MyPredicate<T> {

    boolean test(T t);

}

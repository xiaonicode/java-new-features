package com.xiaonicode.java16;

/**
 * 人
 *
 * @author xiaoni
 * @since 2022-06-25
 */
public record Person(String name, Person partner) {

    /**
     * 静态属性
     */
    public static String nation;

    /**
     * 静态方法
     */
    public static String getNation() {
        return nation;
    }

    /**
     * 构造器
     */
    public Person(String name) {
        this(name, null);
    }

    /**
     * 实例方法
     */
    public String getNameUpperCase() {
        return name.toUpperCase();
    }

    // 注意事项:
    // 1) 不可以在 Record 中定义实例变量
    // public Integer id;

}

// 2) Record 不可以声明为 abstract
// abstract record User() {}

// 3) Record 不可以显式地继承其他父类
// record User() extends Thread {}

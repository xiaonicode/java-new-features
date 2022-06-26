package com.xiaonicode.java16;

import org.junit.Test;

import java.util.HashSet;

/**
 * Records 的测试类
 * <p>
 * Records 初次预览发布于 Java 14, 在 Java 15 中处于第二次预览, 正式发布于 Java 16
 *
 * @author xiaoni
 * @see <a href="https://openjdk.org/jeps/359">JEP 359: Records (Preview)</a>
 * @see <a href="https://openjdk.org/jeps/384">JEP 384: Records (Second Preview)</a>
 * @see <a href="https://openjdk.org/jeps/395">JEP 395: Records</a>
 * @since 2022-06-25
 */
public class RecordsTest {

    @Test
    public void test1() {
        // constructor
        var p1 = new Person("罗密欧", new Person("朱丽叶", null));

        // toString
        System.out.println(p1);

        // equals
        var p2 = new Person("罗密欧", new Person("朱丽叶", null));
        System.out.println(p1.equals(p2));

        // hashCode
        var set = new HashSet<Person>();
        set.add(p1);
        set.add(p2);
        for (Person person : set) {
            System.out.println(person);
        }

        // getter
        System.out.println(p1.name());
        System.out.println(p2.partner());
    }

    @Test
    public void test2() {
        var p1 = new Person("zhuyingtai");
        System.out.println(p1.getNameUpperCase());

        Person.nation = "CHINA";
        System.out.println(Person.nation);
    }

}

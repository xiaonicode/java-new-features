package com.xiaonicode.java10;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 集合框架的测试类
 * <p>
 * 在 Java 10 中, 新增 {@link List#copyOf(Collection)}
 *
 * @author xiaoni
 * @since 2022-06-25
 */
public class CollectionsMapTest {

    /**
     * 示例 1 和 2 代码基本一致, 为什么一个为true, 一个为false
     * <p>
     * 结论: copyOf(Xxx coll): 如果参数 coll 本身就是一个只读集合, 则 copyOf() 返回值即为 coll;<br/>
     * 如果参数 coll 不是一个只读集合, 则 copyOf() 返回一个新的集合, 这个集合是只读的.
     */
    @Test
    public void test1() {
        // 示例 1
        var list1 = List.of("Java", "Python", "C");
        var copy1 = List.copyOf(list1);
        System.out.println(list1 == copy1); // true

        // 示例 2
        var list2 = new ArrayList<String>();
        var copy2 = List.copyOf(list2);
        System.out.println(list2 == copy2); // false
    }

}

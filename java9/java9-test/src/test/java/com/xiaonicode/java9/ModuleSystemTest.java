package com.xiaonicode.java9;

import com.xiaonicode.java9.demo.bean.Person;
import org.junit.Test;

import java.util.logging.Logger;

/**
 * 模块系统的测试类
 *
 * @author xiaoni
 * @see <a href="https://openjdk.org/jeps/261">JEP 261: Module System</a>
 * @since 2022-06-24
 */
public class ModuleSystemTest {

    // ... module java9test does not read module java.logging
    private final Logger log = Logger.getLogger("hello");

    @Test
    public void test1() {
        Person p1 = new Person("Tom", 12);
        System.out.println(p1);

        // ... module java9demo does not export com.xiaonicode.java9.demo.entity to module java9test
        // User u1 = new User();
        log.info("world");
    }

}

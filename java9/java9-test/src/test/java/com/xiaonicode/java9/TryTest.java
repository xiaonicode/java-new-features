package com.xiaonicode.java9;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * try 的测试类
 *
 * @author xiaoni
 * @since 2022-06-24
 */
public class TryTest {

    /**
     * 举例1
     */
    @Test
    public void test1() {
        InputStreamReader reader = null;
        try {
            reader = new InputStreamReader(System.in);
            reader.read();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 举例2: 在举例1基础上, 升级的写法. 不用显式的处理资源的关闭
     * <p>
     * Java 8 要求资源对象的实例化, 必须放在 try() 中完成;<br/>
     * Java 9 可以在 try() 中调用已经实例化的资源对象.<br/>
     */
    @Test
    public void test2() {
        try (InputStreamReader reader = new InputStreamReader(System.in)) {
            reader.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 在 Java 9 中, 可以在 try() 中调用已经实例化的资源对象
     */
    @Test
    public void test3() {
        InputStreamReader reader = new InputStreamReader(System.in);
        OutputStreamWriter writer = new OutputStreamWriter(System.out);
        // 如下的操作不可以在 Java 8 及之前的版本中使用
        try (reader; writer) { // 此处 reader 是 final 的
            reader.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

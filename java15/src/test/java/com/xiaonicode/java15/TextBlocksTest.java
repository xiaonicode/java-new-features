package com.xiaonicode.java15;

import org.junit.Test;

/**
 * 文本块的测试类
 * <p>
 * 文本块首先在 Java 13 中进行预览发布, 在 Java 14 中处于第二次预览, 正式发布于 Java 15
 *
 * @author xiaoni
 * @see <a href="https://openjdk.org/jeps/355">JEP 355: Text Blocks (Preview)</a>
 * @see <a href="https://openjdk.org/jeps/368">JEP 368: Text Blocks (Second Preview)</a>
 * @see <a href="https://openjdk.org/jeps/378">JEP 378: Text Blocks</a>
 * @since 2022-06-25
 */
public class TextBlocksTest {

    /**
     * Java 13 之前
     */
    @Test
    public void test1() {
        var html = "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Title</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<p>Hello, World!</p>\n" +
                "</body>\n" +
                "</html>\n";
        System.out.println(html);
    }

    /**
     * Java 13 新特性
     */
    @Test
    public void test2() {
        var html = """
                <!DOCTYPE html>
                <html lang="en">
                <head>
                    <meta charset="UTF-8">
                    <title>Title</title>
                </head>
                <body>
                <p>Hello, World!</p>
                </body>
                </html>
                """;
        System.out.println(html);
    }

    /**
     * Java 14 新特性
     */
    @Test
    public void test3() {
        var sql1 = """
                SELECT *
                FROM users
                WHERE id > 10
                ORDER BY age DESC
                """;
        System.out.println(sql1);
        System.out.println(sql1.length());

        System.out.println("---------------------------------");

        // \: 取消换行
        // \s: 表示空格
        var sql2 = """
                SELECT * \
                FROM users\s\
                WHERE id > 10\s\
                ORDER BY age DESC\
                """;
        System.out.println(sql2);
        System.out.println(sql2.length());
    }

}

package com.xiaonicode.java14;

import org.junit.Test;

/**
 * Switch 表达式的测试类
 * <p>
 * Switch 表达式最先在 Java 12 中进行预览发布, 之后在 Java 13 中处于第二次预览 (加入 yield 关键字), 最后在 Java 14 中正式发布
 *
 * @author xiaoni
 * @see <a href="https://openjdk.org/jeps/325">JEP 325: Switch Expressions (Preview)</a>
 * @see <a href="https://openjdk.org/jeps/354">JEP 354: Switch Expressions (Second Preview)</a>
 * @see <a href="https://openjdk.org/jeps/361">JEP 361: Switch Expressions</a>
 * @since 2022-06-25
 */
public class SwitchExpressionsTest {

    /**
     * Java 8 及之前的 switch 表达式
     */
    @Test
    public void test1() {
        int numberOfLetters;
        Fruit fruit = Fruit.APPLE;
        switch (fruit) {
            case PEAR:
                numberOfLetters = 4;
                break;
            case APPLE:
            case GRAPE:
            case MANGO:
                numberOfLetters = 5;
                break;
            case ORANGE:
            case PAPAYA:
                numberOfLetters = 6;
                break;
            default:
                throw new IllegalStateException("No Such Fruit:" + fruit);
        }
        System.out.println(numberOfLetters);
    }

    @Test
    public void test2() {
        Fruit fruit = Fruit.APPLE;
        switch (fruit) {
            case PEAR -> System.out.println(4);
            case APPLE, GRAPE, MANGO -> System.out.println(5);
            case ORANGE, PAPAYA -> System.out.println(6);
            default -> throw new IllegalStateException("No Such Fruit:" + fruit);
        }
    }

    @Test
    public void test3() {
        Fruit fruit = Fruit.APPLE;
        var numberOfLetters = switch (fruit) {
            case PEAR -> 4;
            case APPLE, GRAPE, MANGO -> 5;
            case ORANGE, PAPAYA -> 6;
            default -> throw new IllegalStateException("No Such Fruit:" + fruit);
        };
        System.out.println(numberOfLetters);
    }

    @Test
    public void test4() {
        var x = "1";
        var i = switch (x) {
            case "1" -> 5;
            case "2" -> 6;
            default -> {
                yield 7; // yield 结束 switch 结构; return 结束方法
            }
        };
        System.out.println(i);
    }

    @Test
    public void test5() {
        var x = "1";
        var i = switch (x) {
            case "1":
                yield 5;
            case "2":
                yield 6;
            default:
                yield 7;
        };
        System.out.println(i);
    }

}

enum Fruit {
    PEAR, APPLE, GRAPE, MANGO, ORANGE, PAPAYA
}

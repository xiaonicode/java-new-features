package com.xiaonicode.java17;

import com.xiaonicode.java17.calculate.Divide;
import com.xiaonicode.java17.calculate.Multiple;
import com.xiaonicode.java17.calculate.Plus;
import com.xiaonicode.java17.calculate.Subtract;
import com.xiaonicode.java17.shape.Circle;
import com.xiaonicode.java17.shape.Rectangle;
import com.xiaonicode.java17.shape.Shape;
import org.junit.Test;

/**
 * 密封类的测试类
 * <p>
 * 密封类首次在 Java 15 中进行预览发布, 之后在 Java 16 中进行优化, 最后在 Java 17 中正式发布
 *
 * @author xiaoni
 * @see <a href="https://openjdk.org/jeps/360">JEP 360: Sealed Classes (Preview)</a>
 * @see <a href="https://openjdk.org/jeps/397">JEP 409: Sealed Classes</a>
 * @see <a href="https://openjdk.org/jeps/409">JEP 409: Sealed Classes</a>
 * @since 2022-06-25
 */
public class SealedClassesTest {

    @Test
    public void test1() {
        var plus = new Plus();
        System.out.println(plus.doCalculate(5, 2));

        var subtract = new Subtract();
        System.out.println(subtract.doCalculate(5, 2));

        var multiple = new Multiple();
        System.out.println(multiple.doCalculate(5, 2));

        var divide = new Divide();
        System.out.println(divide.doCalculate(5, 2));
    }

    @Test
    public void test2() {
        var shape = new Circle();
        rotate(shape, 30);
        rotate(shape, 60);
    }

    private void rotate(Shape shape, double angle) {
        /* if (shape instanceof Circle) {
            System.out.println("Circle rotates " + angle + " angle");
        } else if (shape instanceof Rectangle) {
            System.out.println("Rectangle " + angle + " angle");
        } */

        switch (shape) {
            case Circle c -> System.out.println(c + ", Circle rotates " + angle + " angle");
            case Rectangle r -> System.out.println(r + ", Rectangle " + angle + " angle");
            default -> throw new IllegalStateException("Unexpected value: " + shape);
        }
    }

}

package com.xiaonicode.java8;

import org.junit.Test;

import java.util.*;
import java.util.function.*;

/**
 * Lambda 表达式的测试类
 * <p>
 * Java 8 在语法层面的新特性
 *
 * @author xiaoni
 * @see <a href="https://openjdk.org/jeps/126">JEP 126: Lambda Expressions & Virtual Extension Methods</a>
 * @since 2022-06-22
 */
public class LambdaExpressionsTest {

    /**
     * Java 8 之前的匿名内部类
     */
    @Test
    public void test1() {
        Comparator<Integer> com = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };

        TreeSet<Integer> ts = new TreeSet<>(com);
    }

    /**
     * Lambda 表达式
     */
    @Test
    public void test2() {
        Comparator<Integer> com = Integer::compare;
        TreeSet<Integer> ts = new TreeSet<>(com);
    }

    List<Employee> employees = Arrays.asList(
            new Employee("张三", 18, 9999.99),
            new Employee("李四", 38, 5555.99),
            new Employee("王五", 50, 6666.66),
            new Employee("赵六", 16, 3333.33),
            new Employee("田七", 8, 7777.77)
    );

    @Test
    public void test3() {
        List<Employee> emps = filterEmployees(employees);
        for (Employee emp : emps) {
            System.out.println(emp);
        }
    }

    /**
     * 获取当前公司中员工年龄大于 35 岁的员工信息
     */
    private List<Employee> filterEmployees(List<Employee> employees) {
        List<Employee> emps = new ArrayList<>();

        for (Employee emp : employees) {
            if (emp.getAge() >= 35) {
                emps.add(emp);
            }
        }

        return emps;
    }

    /**
     * 获取当前公司中员工工资大于 5000 的员工信息
     */
    private List<Employee> filterEmployees2(List<Employee> employees) {
        List<Employee> emps = new ArrayList<>();

        for (Employee emp : employees) {
            if (emp.getSalary() >= 6000) {
                emps.add(emp);
            }
        }

        return emps;
    }

    @Test
    public void test4() {
        List<Employee> emps = filterEmployees(employees, new FilterEmployeeByAge());
        for (Employee emp : emps) {
            System.out.println(emp);
        }

        System.out.println("=========================================");
        emps = filterEmployees(emps, new FilterEmployeeBySalary());
        for (Employee employee : emps) {
            System.out.println(employee);
        }
    }

    /**
     * 优化方式一: 策略设计模式
     */
    private List<Employee> filterEmployees(List<Employee> employees, MyPredicate<Employee> predicate) {
        List<Employee> emps = new ArrayList<>();

        for (Employee emp : employees) {
            if (predicate.test(emp)) {
                emps.add(emp);
            }
        }

        return emps;
    }

    /**
     * 优化方式二: 匿名内部类
     */
    @Test
    public void test5() {
        List<Employee> emps = filterEmployees(employees, new MyPredicate<Employee>() {
            @Override
            public boolean test(Employee employee) {
                return employee.getSalary() >= 6000;
            }
        });

        for (Employee emp : emps) {
            System.out.println(emp);
        }
    }

    /**
     * 优化方式三: Lambda 表达式
     */
    @Test
    public void test6() {
        List<Employee> emps = filterEmployees(employees, (emp) -> {
            return emp.getSalary() >= 6000;
        });
        emps.forEach(System.out::println);
    }

    /**
     * 优化方式四: Stream API
     */
    @Test
    public void test7() {
        employees.stream()
                .filter(emp -> emp.getAge() >= 35)
                .filter(emp -> emp.getSalary() >= 6000)
                .forEach(System.out::println);

        System.out.println("=========================================");

        employees.stream()
                .map(Employee::getName)
                .forEach(System.out::println);
    }

    @Test
    public void test8() {
        int num = 0;

        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello World! " + num);
            }
        };
        r1.run();

        System.out.println("=========================================");

        // Lambda 语法格式一: 无参数, 无返回值
        Runnable r2 = () -> System.out.println("Hello Lambda! " + num);
        r2.run();

        // Lambda 语法格式二: 有一个参数, 并且无返回值
        Consumer<String> con1 = (s) -> System.out.println(s);
        con1.accept("xiaonicode");

        // Lambda 语法格式三: 若只有一个参数, 圆括号可以省略
        Consumer<String> con2 = s -> System.out.println(s);
        con2.accept("xiaonicode");

        // Lambda 语法格式四: 有两个以上的参数, 有返回值, 并且 Lambda 体中有多条语句
        Comparator<Integer> com1 = (x, y) -> {
            System.out.println("函数式接口");
            return Integer.compare(x, y);
        };

        // Lambda 语法格式五: 若 Lambda 体中只有一条语句, return 和大括号都可以省略
        Comparator<Long> com2 = (x, y) -> Long.compare(x, y);

        // Lambda 语法格式六: Lambda 表达式的参数列表的数据类型可以省略,
        // 因为 Java 8 中的 JVM 编译器通过上下文推断出数据类型, 即 "类型推断"
        Comparator<Long> com3 = (Long x, Long y) -> Long.compare(x, y);

        // Lambda 语法格式七: 若 Lambda 体中只有一条语句, 且 return 和大括号省略后,
        // 该 Lambda 表达式还可以替换为 "方法引用"
        Comparator<Long> com4 = Long::compare;
    }

    /**
     * 对一个数进行运算
     */
    @Test
    public void test9() {
        Integer res = operation(100, x -> x * x);
        System.out.println(res);

        System.out.println("=========================================");
        System.out.println(operation(200, y -> 2 * y));
    }

    private Integer operation(Integer num, MyFunction<Integer> myFunc) {
        return myFunc.getValue(num);
    }

    /**
     * Java 8 内置的四大核心函数式接口
     * <p>
     * Consumer<T> 消费型接口, eg: void accept(T t);<br/>
     * Supplier<T> 供给型接口, eg: T get();<br/>
     * Function<T> 函数式接口, eg: R apply(T t);<br/>
     * Predicate<T> 断言型接口, eg: boolean test(T t);
     */
    @Test
    public void test10() {
        happy(10000, money -> System.out.println("购买了Y9000K, 消费了" + money + "元"));

        System.out.println("=========================================");

        List<Integer> nums = getNumList(5, () -> (int) (Math.random() * 100));
        for (Integer num : nums) {
            System.out.println(num);
        }

        System.out.println("=========================================");

        String res = strHandler("\t\t\t Hello Function! ", String::trim);
        System.out.println(res);

        System.out.println("=========================================");

        List<String> rawStrs = Arrays.asList("Hello", "Xiaoni", "Lambda", "www", "ok");
        List<String> newStrs = filterStr(rawStrs, str -> str.length() > 3);
        for (String str : newStrs) {
            System.out.println(str);
        }
    }

    /**
     * 消费型接口: 接受一个值
     */
    private void happy(double money, Consumer<Double> con) {
        con.accept(money);
    }

    /**
     * 供给型接口: 产生指定个数的整数, 并放入列表
     */
    private List<Integer> getNumList(int size, Supplier<Integer> sup) {
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            Integer num = sup.get();
            res.add(num);
        }

        return res;
    }

    /**
     * 函数式接口: 用于处理字符串
     */
    private String strHandler(String str, Function<String, String> func) {
        return func.apply(str);
    }

    /**
     * 断言型接口: 将满足条件的字符串, 放入集合中
     */
    private List<String> filterStr(List<String> strs, Predicate<String> pre) {
        List<String> res = new ArrayList<>();

        for (String str : strs) {
            if (pre.test(str)) {
                res.add(str);
            }
        }

        return res;
    }

    /**
     * 方法引用: 若 Lambda 体中的内容有方法已经实现了, 可以替换为 "方法引用"
     * <p>
     * 主要有三种语法形式:<br/>
     * 对象::实例方法名<br/>
     * 类::静态方法名<br/>
     * 类::实例方法名<br/>
     * <p>
     * 注意:
     * Lambda 体中调用方法的参数列表与返回值类型, 要与函数式接口中抽象方法的函数列表和返回值类型保持一致!<br/>
     * 若 Lambda 参数列表中的第一个参数是实例方法的调用者, 而第二个参数是实例方法的参数时, 可以使用 ClassName::methodName
     */
    @Test
    public void test11() {
        // 语法形式一: 对象::实例方法名
        // Consumer<String> con = x -> System.out.println(x);
        Consumer<String> con = System.out::println;
        con.accept("abc");

        Employee emp = new Employee();
        // Supplier<String> sup = () -> emp.getName();
        Supplier<String> sup = emp::getName;
        String name = sup.get();
        System.out.println(name);

        // 语法形式二: 类::静态方法名
        // Comparator<Integer> com = (x, y) -> Integer.compare(x, y);
        Comparator<Integer> com = Integer::compare;

        // 语法形式三: 类::实例方法名
        // BiPredicate<String, String> bp = (x, y) -> x.equals(y);
        BiPredicate<String, String> bp = String::equals;
    }

    /**
     * 构造器引用
     * <p>
     * 格式: ClassName::new
     * <p>
     * 注意: 需要调用的构造器的参数列表要与函数式接口中抽象方法的参数列表保持一致
     */
    @Test
    public void test12() {
        // Supplier<Employee> sup = () -> new Employee();
        Supplier<Employee> sup = Employee::new;
        Employee emp = sup.get();
        System.out.println("emp = " + emp);

        // Function<String, Employee> func1 = name -> new Employee(name);
        Function<String, Employee> func1 = Employee::new;
        Employee emp1 = func1.apply("tom");
        System.out.println("emp1 = " + emp1);

        BiFunction<String, Integer, Employee> func2 = Employee::new;
        Employee emp2 = func2.apply("mary", 24);
        System.out.println("emp2 = " + emp2);
    }

    /**
     * 数组引用
     * <p>
     * 格式: Type[]::new
     */
    @Test
    public void test13() {
        // Function<Integer, String[]> func = size -> new String[size];
        Function<Integer, String[]> func = String[]::new;
        String[] strs = func.apply(10);
        System.out.println(strs.length);
    }

}

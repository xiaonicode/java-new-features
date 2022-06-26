package com.xiaonicode.java8;

/**
 * 根据年龄过滤员工信息
 *
 * @author xiaoni
 * @since 2022-06-23
 */
public class FilterEmployeeByAge implements MyPredicate<Employee> {

    @Override
    public boolean test(Employee employee) {
        return employee.getAge() >= 35;
    }

}

package com.xiaonicode.java8;

/**
 * 根据工资过滤员工信息
 *
 * @author xiaoni
 * @since 2022-06-23
 */
public class FilterEmployeeBySalary implements MyPredicate<Employee> {

    @Override
    public boolean test(Employee employee) {
        return employee.getSalary() >= 6000;
    }

}

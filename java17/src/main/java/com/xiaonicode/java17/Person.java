package com.xiaonicode.java17;

/**
 * 人
 */
public sealed class Person permits Teacher, Student, Worker {

}

/**
 * 教师
 */
final class Teacher extends Person {

}

/**
 * 学生
 * <p>
 * 同一源文件中, 省略 permits, 编译时推断出允许的子类
 */
sealed class Student extends Person /* permits UndergraduateStudent, GraduateStudent */ {

}

/**
 * 本科生
 */
final class UndergraduateStudent extends Student {

}

/**
 * 研究生
 */
final class GraduateStudent extends Student {

}

/**
 * 工人
 */
non-sealed class Worker extends Person {

}

/**
 * 铁路工人
 */
class RailwayWorker extends Worker {

}

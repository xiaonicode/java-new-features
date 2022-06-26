package com.xiaonicode.java17.shape;

/**
 * 抽象的密封类
 * <p>
 * 不同包中不允许扩展密封类
 *
 * @author xiaoni
 * @since 2022-06-26
 */
public abstract sealed class Shape permits Circle, Rectangle, Square, Triangle {

}

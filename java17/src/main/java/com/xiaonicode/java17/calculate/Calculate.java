package com.xiaonicode.java17.calculate;

/**
 * 密封接口
 *
 * @author xiaoni
 * @since 2022-06-26
 */
public sealed interface Calculate permits Plus, Subtract, Multiple, Divide {

    int doCalculate(int a, int b);

}

package com.xiaonicode.java17.calculate;

/**
 * 加法
 *
 * @author xiaoni
 * @since 2022-06-26
 */
public final class Plus implements Calculate {

    @Override
    public int doCalculate(int a, int b) {
        return a + b;
    }

}

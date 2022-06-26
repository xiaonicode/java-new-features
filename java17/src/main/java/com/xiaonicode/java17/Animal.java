package com.xiaonicode.java17;

/**
 * 密封接口
 * <p>
 * Record 是隐式 final
 *
 * @author xiaoni
 * @since 2022-06-26
 */
public sealed interface Animal permits Cat, Dog {

}

record Cat() implements Animal {

}

record Dog() implements Animal {

}

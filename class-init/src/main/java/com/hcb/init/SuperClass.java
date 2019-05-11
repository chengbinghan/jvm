package com.hcb.init;

/**
 * 被动使用类字段演示一：
 * 通过子类引用父类的静态字段，不会导致子类初始化
 **/
public class SuperClass {
    static {
        System.out.println("SuperClass init！");//调用
    }

    public static int value = 123;
}



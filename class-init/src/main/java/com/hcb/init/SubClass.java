package com.hcb.init;

public class SubClass extends SuperClass {
    static {
        System.out.println("SubClass init！");//不会被执行
    }
}
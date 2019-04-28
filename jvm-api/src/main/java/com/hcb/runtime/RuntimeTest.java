package com.hcb.runtime;

/**
 * @author ice
 * @date 21:29  2019-03-23
 * @description
 */
public class RuntimeTest {
    public static void main(String[] args) {

        //-Xmx128m -Xms128m


        System.out.println("maxMemory:" + Runtime.getRuntime().maxMemory());
        System.out.println("totalMemory:" + Runtime.getRuntime().totalMemory());
        System.out.println("freeMemory" + Runtime.getRuntime().freeMemory());
        byte[] allocateMemory = new byte[1024*1024*10];
        for (int i = 0; i < allocateMemory.length; i++) {
            allocateMemory[i] = 1;
        }
        System.out.println("=============》分配了" + allocateMemory.length + " byte ");
        System.out.println("maxMemory:" + Runtime.getRuntime().maxMemory());
        System.out.println("totalMemory:" + Runtime.getRuntime().totalMemory());
        System.out.println("freeMemory" + Runtime.getRuntime().freeMemory());


    }
}


package com.hcb.jvm.param.tlab;

import java.lang.management.ManagementFactory;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author ice
 * @date 19:47  2019-05-07
 * @description -XX:-UseTLAB ， -XX:+UseTLAB
 */
public class UseTlABTest {
    public static void main(String[] args) {
        List<String> inputArgs = ManagementFactory.getRuntimeMXBean().getInputArguments();
        System.out.println("\n#####################运行时设置的JVM参数#######################");
        System.out.println(inputArgs);
        new UseTlABTest().new Obj();

         ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(400, 400, 1000L, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(1024));
        for (int i = 0; i < 300; i++) {


         threadPoolExecutor.execute(new UseTlABTest().new MyRunnable());
        }
        System.exit(0);

    }


    class MyRunnable implements Runnable {

        public void run() {
            for (int i = 0; i < 1000000; i++) {
                Obj obj = new Obj();
            }


        }
    }

    class Obj {
        byte[] bytes = new byte[1024 * 10];
        Long a = 1024L;
    }


}

package com.ice.dump;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Main {




    private static Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 100, 1000L, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(1024));
        for (int i = 0; i < 300; i++) {
            threadPoolExecutor.execute(new MyRunnable());
        }
    }

}

class MyRunnable implements Runnable {
    static ConcurrentHashMap<String,Obj> map = new ConcurrentHashMap<String, Obj>();
    private static Logger log = LoggerFactory.getLogger(MyRunnable.class);

    public void run() {
        while (true) {
             Obj obj = new Obj();
             map.put(new Date().getTime() +"",obj);
        }


    }
}

class Obj{
    byte[] bytes = new byte[20240];

}
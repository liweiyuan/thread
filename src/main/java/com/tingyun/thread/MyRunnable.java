package com.tingyun.thread;

/**
 * Created by tingyun on 2017/7/3.
 */
public class MyRunnable implements Runnable {
    public void run() {
        System.out.println("MyThread running");
    }

    public static void main(String[] args) {
        MyRunnable myRunnable=new MyRunnable();
        Thread thread=new Thread(myRunnable,"new Thread");
        thread.start();
        System.err.println("id:"+thread.getId()+",name:"+thread.getName()+",property:"+thread.getPriority());

        String name =Thread.currentThread().getName();
        System.out.println("name:"+name);
    }
}

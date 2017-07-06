package com.tingyun.thread;

/**
 * Created by tingyun on 2017/7/3.
 */
public class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("MyThread running");
    }

    public static void main(String[] args) {
        MyThread myThread=new MyThread();
        myThread.start();
    }
}

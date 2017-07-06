package com.tingyun.thread;

import com.tingyun.bean.Counter;

/**
 * Created by tingyun on 2017/7/3.
 */
public class ThreadExample {

    public static void main(String[] args) {
        System.out.println("name:"+Thread.currentThread().getName()+",ClassLoad:"+Thread.currentThread().getContextClassLoader());
        for(int i=0;i<10;i++){
            new Thread(""+i){
                @Override
                public void run() {
                    //System.err.println("Thread:"+getName()+"running");
                    int num=new Counter().add(1);
                    System.out.println("值:"+num+",Thread:"+getName()+"running");
                }
            }.start();
        }
    }
}

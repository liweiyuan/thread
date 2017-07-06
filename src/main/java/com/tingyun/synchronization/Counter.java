package com.tingyun.synchronization;

/**
 * Created by tingyun on 2017/7/4.
 */
public class Counter {
    long count=0;
    public synchronized void add(int value,String name){
        count+=value;
        System.err.println(count+",name:"+name);
    }
}

class CounterThread extends Thread{
    protected Counter counter=null;

    public CounterThread(Counter counter){
        this.counter=counter;
    }

    @Override
    public void run() {
        for(int i=0; i<10; i++){
            counter.add(i,currentThread().getName());
        }

    }
}

class Example{
    public static void main(String[] args) {
        Counter counter=new Counter();
        Counter counter1=new Counter();
        Thread thread1=new CounterThread(counter);
        Thread thread2=new CounterThread(counter1);
        thread1.start();
        thread2.start();
    }
}

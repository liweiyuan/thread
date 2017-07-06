package org.tarena;

public class Run {
    public static void main(String[] args) {
        MyThread myThread1=new MyThread("A");
        MyThread myThread2=new MyThread("B");
        MyThread myThread3=new MyThread("C");
        myThread1.start();
        myThread2.start();
        myThread3.start();

    }
}

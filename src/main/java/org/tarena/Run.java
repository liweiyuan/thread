package org.tarena;

public class Run {
    public static void main(String[] args) throws InterruptedException {
        MyThread myThread1=new MyThread("A");
        MyThread myThread2=new MyThread("B");
        MyThread myThread3=new MyThread("C");
        MyThread myThread4=new MyThread("D");
        MyThread myThread5=new MyThread("E");
        myThread1.start();
        myThread2.start();
        myThread3.start();
        myThread4.start();
        myThread5.start();

        Thread.sleep(2000);
        System.err.println("myThread5:"+myThread5.isAlive());

    }
}

package org.tarena.thread;

/**
 * Created by tingyun on 2017/7/7.
 */
public class Run {
    public static void main(String[] args) {
        try {
            MyThread myThread=new MyThread();
            myThread.start();
            Thread.sleep(1000);
            myThread.interrupt();
            System.out.println("this Thread1:"+myThread.isInterrupted());
            System.out.println("this Thread2:"+myThread.isInterrupted());
        } catch (Exception e) {
            System.out.println("main catch");
            e.printStackTrace();
        }
    }
}

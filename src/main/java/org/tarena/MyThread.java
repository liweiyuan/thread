package org.tarena;


public class MyThread extends Thread{

    private int count=5;

    public MyThread(String name) {
        super();
        this.setName(name);
    }

    @Override
    public void run() {
        //不共享数据
        /*while(count>0){
            count--;
            System.out.println("由  "+Thread.currentThread().getName()+"  计算,count="+count);
        }*/
        //共享数据--明显线程不安全
        count--;
        System.out.println("由  "+Thread.currentThread().getName()+"  计算,count="+count);
    }
}

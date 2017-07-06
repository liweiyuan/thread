package org.tarena;


public class MyThread extends Thread{

    private int count=20;

    public MyThread(String name) {
        super();
        this.setName(name);
    }

    @Override
    public void run() {
        while(count>0){
            count--;
            System.out.println("由  "+Thread.currentThread().getName()+"  计算,count="+count);
        }
    }
}

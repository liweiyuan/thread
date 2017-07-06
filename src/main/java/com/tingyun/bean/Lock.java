package com.tingyun.bean;


import com.tingyun.communication.MonitorObject;

public class Lock {
    protected MonitorObject monitorObject = new MonitorObject();
    protected boolean isLocked = false;

    public void lock() throws InterruptedException{
        synchronized(this){//第一层锁
            while(!isLocked){
                synchronized(this.monitorObject){//第二层锁
                    System.out.print("0000");
                    this.monitorObject.wait();
                }
            }
            isLocked = true;
        }
    }
    public void unlock(){
        synchronized(this){
            this.isLocked = false;
            synchronized(this.monitorObject){
                this.monitorObject.notify();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Lock lock=new Lock();
        lock.lock();
        System.out.println("please go on..");
        lock.unlock();
    }
}

package com.tingyun.lock;




public class Synchronizer{
    Lock lock = new Lock();
    public void doSynchronized() throws InterruptedException{
        this.lock.lock();
        //critical section, do a lot of work which takes a long time
        this.lock.unlock();
    }


    public static void main(String[] args) throws InterruptedException {
        Synchronizer synchronizer=new Synchronizer();

        synchronizer.doSynchronized();
    }
}

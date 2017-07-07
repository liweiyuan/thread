package org.tarena.lock;

public class Reentrant2 {

    private Lock lock=new Lock();
    Reentrant reentrant=new Reentrant();

    public void outer() throws InterruptedException {
        lock.lock();//锁住该对象
        inner();
        lock.unLock();
    }

    public synchronized void inner() throws InterruptedException {
        lock.lock();//尝试再次锁住，但是已经锁住了，就会出现异常
        //do something
        lock.unLock();
    }


    public static void main(String[] args) throws InterruptedException {
        Reentrant2 reentrant2=new Reentrant2();
        reentrant2.outer();
    }
}

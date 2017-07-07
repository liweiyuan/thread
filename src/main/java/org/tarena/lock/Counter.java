package org.tarena.lock;

public class Counter {

    private Lock lock=new Lock();
    private int count=0;

    public int inc() throws InterruptedException {
        lock.lock();
        int newCount=++count;
        lock.notify();
        return newCount;
    }
}

class Lock {
    private boolean isLocked = false;

    public synchronized void lock() throws InterruptedException {
        while (isLocked) {
            wait();
        }
        isLocked = true;
    }

    public synchronized void unLock() {
        isLocked = false;
        notify();
    }
}

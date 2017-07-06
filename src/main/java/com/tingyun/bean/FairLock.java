package com.tingyun.bean;


import java.util.ArrayList;
import java.util.List;

//Fair Lock implementation with nested monitor lockout problem
public class FairLock {
    private boolean isLocked = false;
    private Thread lockingThread = null;
    private List waitingThreads =
            new ArrayList();

    public void lock() throws InterruptedException{
        QueueObject queueObject = new QueueObject();

        synchronized(this){
            waitingThreads.add(queueObject);

            while(!isLocked ||
                    waitingThreads.get(0) != queueObject){

                synchronized(queueObject){
                    try{
                        queueObject.wait();
                    }catch(InterruptedException e){
                        waitingThreads.remove(queueObject);
                        throw e;
                    }
                }
            }
            waitingThreads.remove(queueObject);
            isLocked = true;
            lockingThread = Thread.currentThread();
        }
    }

    public synchronized void unlock(){
        if(this.lockingThread != Thread.currentThread()){
            throw new IllegalMonitorStateException(
                    "Calling thread has not locked this lock");
        }
        isLocked = false;
        lockingThread = null;
        if(waitingThreads.size() > 0){
            QueueObject queueObject = (QueueObject) waitingThreads.get(0);
            synchronized(queueObject){
                queueObject.notify();
            }
        }
    }


    public static void main(String[] args) throws InterruptedException {
        FairLock fairLock=new FairLock();
        fairLock.lock();
        System.out.println("please go on..");
        fairLock.unlock();
    }
}
class QueueObject {}

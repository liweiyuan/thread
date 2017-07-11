package test.wade.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by spark on 17-7-10.
 */
public class PrintQueue {
    private Lock queueLock=new ReentrantLock();

    public void printJob(Object document){
        try {
            queueLock.lock();
            System.out.println(Thread.currentThread().getName() + ": Going to print a document");
            Long duration=(long)(Math.random()*10000);
            System.out.println(Thread.currentThread().getName() + ":PrintQueue: Printing a Job during " + (duration / 10));
            Thread.sleep(duration);
            System.out.printf(Thread.currentThread().getName() + ": The document has been printed\n");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            queueLock.unlock();
        }
    }

}
class Job implements Runnable{

    private PrintQueue printQueue;

    public Job(PrintQueue printQueue) {
        this.printQueue = printQueue;
    }

    public void run() {
        printQueue.printJob(new Object());
    }
}

class Test{
    public static void main(String[] args) {
        PrintQueue printQueue=new PrintQueue();
        Thread[] threads=new Thread[10];
        for(int i=0;i<threads.length;i++){
            threads[i]=new Thread(new Job(printQueue),"Thread:"+i);
        }
        for(int i=0;i<threads.length;i++){
            threads[i].start();
        }
    }
}

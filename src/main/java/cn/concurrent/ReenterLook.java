package cn.concurrent;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by spark on 17-8-29.
 */
public class ReenterLook implements Runnable {

    //引入锁，保证临界区数据的安全性
    //把它声明为成员变量而不是局部变量
    private static ReentrantLock lock = new ReentrantLock();
    public static int i = 0;

    @Override
    public void run() {
        for (int j = 0; j < 1000000; j++) {
            lock.lock();
            try {
                i++;
                //操作redis取出、
                //操作redis刪除
                /**
                 * 为什么叫重入锁？
                 */
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReenterLook t1 = new ReenterLook();
        Thread thread1 = new Thread(t1, "the thread1");
        Thread thread2 = new Thread(t1, "the thread2");
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println("the final i:" + i);
    }
}

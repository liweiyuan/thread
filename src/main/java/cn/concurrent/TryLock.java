package cn.concurrent;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by spark on 17-8-29.
 */
public class TryLock implements Runnable {

    private static ReentrantLock lock1 = new ReentrantLock();
    private static ReentrantLock lock2 = new ReentrantLock();
    int lock;

    public TryLock(int lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        if (lock == 1) {
            while (true) {
                if (lock1.tryLock()) {
                    try {
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {

                        }
                        if (lock2.tryLock()) {
                            try {
                                System.out.println(Thread.currentThread().getName()+ ":My Job done.");
                                return;
                            } finally {
                                lock2.unlock();
                            }
                        }
                    } finally {
                        lock1.unlock();
                    }
                }
            }
        } else {
            while (true) {
                if (lock2.tryLock()) {
                    try {
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {

                        }
                        if (lock1.tryLock()) {
                            try {
                                System.out.println(Thread.currentThread().getName() + ":My Job done");
                                return;
                            } finally {
                                lock1.unlock();
                            }
                        }
                    } finally {
                        lock2.unlock();
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        TryLock r1 = new TryLock(1);
        TryLock r2 = new TryLock(2);
        Thread thread1 = new Thread(r1,"r1_name");
        Thread thread2 = new Thread(r2,"r2.name");
        thread1.start();
        Thread.sleep(500);
        thread2.start();

    }
}

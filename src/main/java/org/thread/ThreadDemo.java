package org.thread;

/**
 * Created by spark on 17-10-16.
 * <p>
 * 如何让两个线程依次执行？
 * 那如何让 两个线程按照指定方式有序交叉运行呢？
 * 四个线程 A B C D，其中 D 要等到 A B C 全执行完毕后才执行，而且 A B C 是同步运行的
 * 三个运动员各自准备，等到三个人都准备好后，再一起跑
 * 子线程完成某件任务后，把得到的结果回传给主线程
 * </p>
 */
public class ThreadDemo {


    public static void main(String[] args) {
        //demo1();
        //demo2();
        demo3();
    }

    private static void demo1() {
        Thread A = new Thread(new Runnable() {
            @Override
            public void run() {
                printNumber("A");
            }
        });
        Thread B = new Thread(new Runnable() {
            @Override
            public void run() {
                printNumber("B");
            }
        });
        A.start();
        B.start();

        /**
         * result:
         * A print: 1
         B print: 1
         A print: 2
         B print: 2
         A print: 3
         B print: 3
         可以看到是同时打印的
         */
    }

    private static void demo2() {
        Thread A = new Thread(new Runnable() {
            @Override
            public void run() {
                printNumber("A");
            }
        });
        Thread B = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("B 开始等待 A");
                try {
                    A.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                printNumber("B");
            }
        });
        B.start();
        A.start();
        /**
         * B 开始等待 A
         A print: 1
         A print: 2
         A print: 3
         B print: 1
         B print: 2
         B print: 3
         所以我们能看到 A.join() 方法会让 B 一直等待直到 A 运行完毕。
         */
    }

    /**
     * A 1, B 1, B 2, B 3, A 2, A 3
     */
    private static void demo3() {
        Object lock = new Object();
        Thread A = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    System.out.println("A 1");
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("A 2");
                    System.out.println("A 3");
                }
            }
        });
        Thread B = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    System.out.println("B 1");
                    System.out.println("B 2");
                    System.out.println("B 3");
                    lock.notify();
                }
            }
        });
        A.start();
        B.start();

        /**
         *
         1.首先创建一个 A 和 B 共享的对象锁 lock = new Object();
         2.当 A 得到锁后，先打印 1，然后调用 lock.wait() 方法，交出锁的控制权，进入 wait 状态；
         3.对 B 而言，由于 A 最开始得到了锁，导致 B 无法执行；直到 A 调用 lock.wait() 释放控制权后， B 才得到了锁；
         4.B 在得到锁后打印 1， 2， 3；然后调用 lock.notify() 方法，唤醒正在 wait 的 A;
         5.A 被唤醒后，继续打印剩下的 2，3。
         */
    }

    private static void printNumber(String b) {
        int j = 0;
        while (j++ < 3) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(b + " print: " + j);
        }
    }
}

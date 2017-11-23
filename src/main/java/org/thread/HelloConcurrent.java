package org.thread;

import java.util.Random;
import java.util.concurrent.*;

/**
 * Created by spark on 17-10-16.
 * 最开始我们介绍了 thread.join()，可以让一个线程等另一个线程运行完毕后再继续执行，
 * 那我们可以在 D 线程里依次 join A B C，不过这也就使得 A B C 必须依次执行，而我们要的是这三者能同步运行。
 *
 *
 * https://github.com/liweiyuan/HelloJava/blob/master/multi-thread/src/HelloConcurrent.java
 */
public class HelloConcurrent {
    public static void main(String[] args) {
        //runABC();
        runABCWhenAllReady();
    }

    private static void runABC() {
        int worker = 3;
        final CountDownLatch countDownLatch = new CountDownLatch(worker);
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("D is waiting for other three threads");
                try {
                    countDownLatch.await();
                    System.out.println("All done, D starts working");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        for (char threadName = 'A'; threadName <= 'C'; threadName++) {
            final String tN = String.valueOf(threadName);
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(tN + "is working");
                    try {
                        Thread.sleep(100);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    System.out.println(tN + "finished");
                    countDownLatch.countDown();
                }
            }).start();
        }
    }

    /**
     * 其实简单点来说，CountDownLatch 就是一个倒计数器，我们把初始计数值设置为3，
     * 当 D 运行时，先调用 countDownLatch.await() 检查计数器值是否为 0，若不为 0
     * 则保持等待状态；当A B C 各自运行完后都会利用countDownLatch.countDown()，
     * 将倒计数器减 1，当三个都运行完后，计数器被减至 0；此时立即触发 D 的 await() 运行结束，继续向下执行。
     */


    /**
     * Only if A, B, C are all finished, D starts working
     */
    private static void runABCWhenAllReady() {
        int worker = 3;
        final CyclicBarrier cyclicBarrier = new CyclicBarrier(worker);
        final Random random=new Random();
        for(char threadName='A';threadName<='C';threadName++){
            final String rN = String.valueOf(threadName);
            new Thread(new Runnable() {
                @Override
                public void run() {
                    long prepareTime = random.nextInt(10000) + 100;
                    System.out.println(rN + " is preparing for time: " + prepareTime);
                    try {
                        Thread.sleep(prepareTime);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(rN + " is prepared, waiting for others");
                    try {
                        cyclicBarrier.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                    System.out.println(rN + " starts running");
                }
            }).start();
        }
    }
    /**
     * 1.先创建一个公共 CyclicBarrier 对象，设置 同时等待 的线程数，
     * CyclicBarrier cyclicBarrier = new CyclicBarrier(3);
       2.这些线程同时开始自己做准备，自身准备完毕后，需要等待别人准备完毕，
     这时调用 cyclicBarrier.await(); 即可开始等待别人；
       3.当指定的 同时等待 的线程数都调用了 cyclicBarrier.await();时，
     意味着这些线程都准备完毕好，然后这些线程才 同时继续执行
     */



}

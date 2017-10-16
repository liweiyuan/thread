package org.thread;

import java.util.concurrent.CountDownLatch;

/**
 * Created by spark on 17-10-16.
 * 最开始我们介绍了 thread.join()，可以让一个线程等另一个线程运行完毕后再继续执行，
 * 那我们可以在 D 线程里依次 join A B C，不过这也就使得 A B C 必须依次执行，而我们要的是这三者能同步运行。
 */
public class HelloConcurrent {
    public static void main(String[] args) {
        runABC();
    }

    private static void runABC() {
        int worker = 3;
        CountDownLatch countDownLatch = new CountDownLatch(worker);
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
}

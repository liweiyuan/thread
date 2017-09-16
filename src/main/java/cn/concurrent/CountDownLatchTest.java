package cn.concurrent;

import java.util.concurrent.CountDownLatch;

/**
 * Created by spark on 17-9-16.
 */
public class CountDownLatchTest {

    public static long timeTasks(int nThreads, final Runnable task) throws InterruptedException {
        final CountDownLatch startGate = new CountDownLatch(1);
        final CountDownLatch endGate = new CountDownLatch(nThreads);

        for (int i = 0; i < nThreads; i++) {
            Thread t = new Thread() {
                @Override
                public void run() {
                    try {
                        System.out.println("it is start" );
                        startGate.await();
                        try {
                            task.run();
                        } finally {
                            endGate.countDown();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            t.start();
        }

        long start = System.currentTimeMillis();
        startGate.countDown();
        endGate.await();
        long end = System.currentTimeMillis();
        return end - start;
    }

    static class Task implements Runnable {
        @Override
        public void run() {
            System.out.println("this is task");
        }
    }

    public static void main(String[] args) throws InterruptedException {

        Task task = new Task();

        long time = timeTasks(10, task);


        System.out.println(time);
    }
}


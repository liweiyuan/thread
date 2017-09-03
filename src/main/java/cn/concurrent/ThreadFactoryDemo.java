package cn.concurrent;

import java.util.concurrent.*;

/**
 * Created by spark on 17-9-3.
 */
public class ThreadFactoryDemo {
    private static class MyTask implements Runnable {
        @Override
        public void run() {
            System.out.println("the current Thread name:" + Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyTask myTask = new MyTask();
        ExecutorService es = new ThreadPoolExecutor(5, 5, 0L, TimeUnit.MILLISECONDS,
                new SynchronousQueue<Runnable>(),
                new ThreadFactory() {
                    @Override
                    public Thread newThread(Runnable runnable) {
                        Thread t=new Thread(runnable);
                        t.setDaemon(true);
                        System.out.println("create:"+t);
                        return t;
                    }
                });
        for(int i=0;i<5;i++){
            es.submit(myTask);
        }
        Thread.sleep(2000);
    }
}

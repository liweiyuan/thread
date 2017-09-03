package cn.concurrent;

import java.util.concurrent.*;

/**
 * Created by spark on 17-9-3.
 * 主要演示线程池的拒绝策略实现的接口RejectedExecutionHandler
 */
public class RejectThreadPoolDemo {

    public static class MyTask implements Runnable {
        @Override
        public void run() {
            System.out.println(System.currentTimeMillis() + ":Thread ID:" + Thread.currentThread().getId());
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    //实现RejectExecutionHandler
    public static void main(String[] args) throws InterruptedException {
        MyTask myTask = new MyTask();
        //创建一个线程池
        ExecutorService es = new ThreadPoolExecutor(5, 5, 0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingDeque<Runnable>(10),
                Executors.defaultThreadFactory(),
                new RejectedExecutionHandler() {
                    //自定义拒绝策略的处理
                    @Override
                    public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
                        System.out.println(runnable.toString() + " is discard");
                    }
                });
        for(int i=0;i<Integer.MAX_VALUE;i++){
            es.submit(myTask);
            Thread.sleep(10);
        }
    }
}

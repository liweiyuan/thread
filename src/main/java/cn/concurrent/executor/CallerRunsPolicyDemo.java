package cn.concurrent.executor;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by spark on 17-9-24.
 */
public class CallerRunsPolicyDemo {
    public static void main(String[] args) {
        ThreadPoolExecutor pool=new ThreadPoolExecutor(1,1,0, TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(1));
        //添加饱和策略为丢弃策略
        pool.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        for (int i = 0; i < 6; i++) {
            MyRunnable myRunnable = new MyRunnable("this is " + i + " task");
            pool.submit(myRunnable);
        }
        pool.shutdown();
    }
    static class MyRunnable implements Runnable {

        private String name;

        public MyRunnable(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            System.err.println(this.name + ": is running.");
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

package cn.concurrent.executor;

import java.util.concurrent.*;

/**
 * Created by spark on 17-9-24.
 */
public class AbortPolicyDemo {

    public static void main(String[] args) {
        //初始化一个初始化容量大小为1，阻塞队列容量为1，maxmumPoolSize大小为1的线程池
        ThreadPoolExecutor pool = new ThreadPoolExecutor(1, 1,
                0, TimeUnit.SECONDS, new LinkedBlockingQueue<>(1));
        //设置饱和策略为AbortPolicy---拒绝策略/**/,用户可以捕获这个异常
        pool.setRejectedExecutionHandler(new ThreadPoolExecutor.AbortPolicy());
        //创建线程执行
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            MyRunnable myRunnable = new MyRunnable();
            pool.execute(myRunnable);
        }
        pool.shutdown();
    }


    static class MyRunnable implements Runnable {
        @Override
        public void run() {
            System.err.println(Thread.currentThread().getId() + ":正在执行");
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

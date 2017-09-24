package cn.concurrent.executor;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by spark on 17-9-24.
 * 线程池pool的"最大池大小"和"核心池大小"都为1(THREADS_SIZE)，这意味着"线程池能同时运行的任务数量最大只能是1"。
 线程池pool的阻塞队列是ArrayBlockingQueue，ArrayBlockingQueue是一个有界的阻塞队列，ArrayBlockingQueue的容量为1。这也意味着线程池的阻塞队列只能有一个线程池阻塞等待。
 根据""中分析的execute()代码可知：线程池中共运行了2个任务。第1个任务直接放到Worker中，通过线程去执行；第2个任务放到阻塞队列中等待。其他的任务都被丢弃了！
 */
public class DiscardPolicy {

    public static void main(String[] args) {
        ThreadPoolExecutor pool=new ThreadPoolExecutor(1,1,0, TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(1));
        //添加饱和策略为丢弃策略
        pool.setRejectedExecutionHandler(new ThreadPoolExecutor.DiscardPolicy());
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

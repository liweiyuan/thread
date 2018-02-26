package cn.concurrent;

import java.util.concurrent.*;

/**
 * Created by spark on 17-9-3.
 */
public class TranceThreadPoolExecutor extends ThreadPoolExecutor {
    public TranceThreadPoolExecutor(
            int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit timeUnit,
            BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, timeUnit, workQueue);
    }

    @Override
    public void execute(Runnable task) {
        super.execute(wrap(task, clientTrace(), Thread.currentThread().getName()));
    }

    @Override
    public Future<?> submit(Runnable task) {
        return super.submit(wrap(task, clientTrace(), Thread.currentThread().getName()));
    }

    private Exception clientTrace() {
        return new Exception("Client stack trace");
    }

    private Runnable wrap(final Runnable task, final Exception clienttack,
                          String clientThreadName) {
        return new Runnable() {
            @Override
            public void run() {
                try {
                    task.run();
                } catch (Exception e) {
                    e.printStackTrace();
                    //throw e;
                }
            }
        };

    }

    //尝试打印堆栈信息
    public static void main(String[] args) {
        ThreadPoolExecutor pools=new TranceThreadPoolExecutor(0,Integer.MAX_VALUE,
                0L,TimeUnit.SECONDS,new SynchronousQueue<Runnable>());
        /**
         * 错误信息堆栈打印
         */
        for(int i=0;i<5;i++){
            pools.execute(new DivTask(100,i));
        }
    }
}

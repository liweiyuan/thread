package cn.concurrent;

import java.util.concurrent.*;

/**
 * Created by spark on 17-9-3.
 * 线程池中寻找堆栈信息
 */
public class DivTask implements Runnable {
    int a, b;

    public DivTask(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public void run() {
        double re = a / b;
        System.out.println(re);
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 0L,
                TimeUnit.SECONDS,
                new SynchronousQueue<Runnable>());
        for (int i = 0; i < 5; i++) {
            //这样不会输出异常信息
            //poolExecutor.submit(new DivTask(100, i));
            //method 1
            poolExecutor.execute(new DivTask(100, i));
            //method 2
            //Future future=poolExecutor.submit(new DivTask(100,i));
            //future.get();
        }
    }
}

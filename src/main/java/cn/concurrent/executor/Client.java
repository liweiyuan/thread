package cn.concurrent.executor;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by spark on 17-9-24.
 */
public class Client {


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(4);
        Task1 t1 = new Task1(1, 1);
        Task1 t2 = new Task1(1, 2);
        Task1 t3 = new Task1(1, 3);
        Task1 t4 = new Task1(1, 4);

        //获取结果
        Future<Integer> f1 = pool.submit(t1);
        Future<Integer> f2 = pool.submit(t2);
        Future<Integer> f3 = pool.submit(t3);
        Future<Integer> f4 = pool.submit(t4);

        //Future调用get方法时，如果线程还没有执行完，程序阻塞在这里
        Task2 f5 = new Task2(f1.get(), f2.get(), f3.get(), f4.get());
        Future<Integer> f6 = pool.submit(f5);
        System.out.println(f6.get());
        pool.shutdown();

    }
}

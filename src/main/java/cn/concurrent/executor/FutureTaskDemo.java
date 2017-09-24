package cn.concurrent.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * Created by spark on 17-9-24.
 */
public class FutureTaskDemo extends FutureTask<String> {
    public FutureTaskDemo(Runnable runnable, String s) {
        super(runnable, s);
        System.out.println(s);
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            System.out.println("this is running.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        FutureTaskDemo futureTaskDemo = new FutureTaskDemo(new Runnable() {
            @Override
            public void run() {
                System.out.println("this is wade.");
            }
        }, "wade");

        ExecutorService es = Executors.newFixedThreadPool(1);
        FutureTask<String> task = (FutureTask<String>) es.submit(futureTaskDemo);
        System.out.println("hello:"+task);
        es.shutdown();
    }
}

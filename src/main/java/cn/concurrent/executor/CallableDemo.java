package cn.concurrent.executor;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * Created by spark on 17-9-24.
 */
public class CallableDemo implements Callable<String> {

    private String name;

    public CallableDemo(String name) {
        this.name = name;
    }

    @Override
    public String call() throws Exception {
        //执行任务的相关逻辑
        Thread.sleep(1000);
        return name + " : this is task is successed.";
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CallableDemo callableDemo = new CallableDemo("wade");
        //异步执行的结果
        FutureTask<String> future = new FutureTask<String>(callableDemo);
        new Thread(future).start();
        //調用get()方法--阻塞
        String result=future.get();
        System.out.println("hello : " + result);
    }
}

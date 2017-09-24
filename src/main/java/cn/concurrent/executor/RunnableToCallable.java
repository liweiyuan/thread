package cn.concurrent.executor;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * Created by spark on 17-9-24.
 */
public class RunnableToCallable implements Runnable {

    String name;

    public RunnableToCallable(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            System.out.println(name + " :任务执行完毕！");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        RunnableToCallable task=new RunnableToCallable("wade");
        //转变为有返回值的任务
        Callable<Object> future=Executors.callable(task);
        FutureTask<Object> futureTask=new FutureTask<Object>(future);
        new Thread(futureTask).start();
        //調用get()方法--阻塞
        Object result=futureTask.get();
        System.out.println("hello : " + result);
    }
}

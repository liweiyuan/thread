package cn.concurrent.jdk.future;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * Created by spark on 17-9-6.
 */
public class FutureMain {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //构造FutureTask
        FutureTask<String> task = new FutureTask<String>(new RealData("a"));
        ExecutorService executors = Executors.newFixedThreadPool(1);
        //执行FutureTask,相当于上例中的client.request("a")发送请求
        //在这里开启线程进行RealTask的call()执行
        executors.submit(task);
        System.out.println("请求完毕");
        try {
            //模拟其他耗时的业务逻辑
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //这里相当于上一节data.getResult().取回call()方法返回的值
        //如果call()方法没有执行完毕，则依然会等待。
        System.out.println("数据=" + task.get());
    }
}

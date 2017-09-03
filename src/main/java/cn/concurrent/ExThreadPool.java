package cn.concurrent;


import java.util.concurrent.*;

/**
 * Created by spark on 17-9-3.
 * 扩展线程池，主要针对线程池的beforeExecute()与afterExecute()方法
 */
public class ExThreadPool {
    public static class MyTask implements Runnable {
        public String name;

        public MyTask(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            System.out.println("增在进行:" + ":Thread ID:" + Thread.currentThread().getId() + ",Task Name:" + name);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService es = new ThreadPoolExecutor(5, 5, 0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>()) {
            @Override
            protected void beforeExecute(Thread thread, Runnable runnable) {
                System.out.println("准备执行:" + ((MyTask) runnable).name);
                if(runnable instanceof MyTask){
                    System.out.println("this is my house");
                }else{
                    System.out.println(runnable.toString());
                }

            }

            @Override
            protected void afterExecute(Runnable runnable, Throwable throwable) {
                System.out.println("執行完畢:" + ((MyTask) runnable).name);
            }

            @Override
            protected void terminated() {
                System.out.println("线程池退出");
            }
        };
        for (int i = 0; i < 5; i++) {
            MyTask myTask = new MyTask("Task-geym" + i);
            //es.submit(myTask);
            es.execute(myTask);
            Thread.sleep(10);
        }
        es.shutdown();
    }
}

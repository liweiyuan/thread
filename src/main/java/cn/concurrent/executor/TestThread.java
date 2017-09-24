package cn.concurrent.executor;

import java.util.concurrent.*;

/**
 * Created by spark on 17-9-24.
 * 一般情况，我们实现多线程都是Thread或者Runnable(后者比较多)，但是，这两种都是没返回值的，
 * 所以我们需要使用callable(有返回值的多线程)和future(获得线程的返回值)来实现了
 */
public class TestThread {


    static class TimeCount implements Callable<Integer> {

        private int type;

        public TimeCount(int type) {
            this.type = type;
        }

        @Override
        public Integer call() throws Exception {
            if (type == 1) {
                System.out.println("C盘统计大小");
                return 1;
            } else if (type == 2) {
                System.out.println("D盘统计大小");
                return 2;
            } else if (type == 3) {
                System.out.println("E盘统计大小");
                return 3;
            } else if (type == 4) {
                System.out.println("F盘统计大小");
                return 4;
            }
            return null;
        }
    }

    public static void main(String[] args) {
        TimeCount count = null;
        ExecutorService ex = Executors.newCachedThreadPool();
        CompletionService<Integer> cs = new ExecutorCompletionService<Integer>(ex);
        for (int i = 0; i < 4; i++) {
            count = new TimeCount(i + 1);
            cs.submit(count);
        }
        //添加结束，及时shutdown，不然主线程不会结束
        ex.shutdown();
        int total=0;
        for(int i=0;i<4;i++){
            try {
                total+=cs.take().get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        System.out.println(total);
    }
}

package cn.concurrent.executor;

import java.util.concurrent.*;

/**
 * Created by spark on 17-9-24.
 */
public class ThreadExceptionTest {


    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        CallableTest callableTest = new CallableTest();
        Future<Boolean> task = executorService.submit(callableTest);
        try {
            Boolean b = task.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }

    static class CallableTest implements Callable<Boolean> {

        @Override
        public Boolean call() throws Exception {
            int num = 3 / 0;
            return false;
        }
    }
}


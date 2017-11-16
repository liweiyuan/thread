package cn.concurrent.fork_join;

import cn.concurrent.CountTask;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

/**
 * Created by tingyun on 2017/11/16.
 * <p>fork/join框架详解</p>
 */
public class CountTaskTmp extends RecursiveTask<Integer> {

    private static final int THRESHOLD = 2;

    private int start;

    private int end;

    public CountTaskTmp(int start, int end) {
        this.start = start;
        this.end = end;
    }

    /**
     * 核心逻辑
     *
     * @return
     */
    @Override
    protected Integer compute() {
        int sum = 0;
        boolean canCompute = (end - start) < THRESHOLD;
        if (canCompute) {
            for (int i = start; i < end; i++) {
                sum += sum;
            }
        }else{
            //如果任务大于阀值，就分裂成两个子任务计算
            int midumn=(end+start)/2;
            CountTask leftTask=new CountTask(start,midumn);
            CountTask rightTask=new CountTask(midumn,end);
            //执行子任务
            leftTask.fork();
            rightTask.fork();
            //等待子任务执行完，并得到结果
            int leftResult = Math.toIntExact(leftTask.join());
            int rightResult = Math.toIntExact(rightTask.join());
            sum = leftResult + rightResult;
        }
        return sum;
    }

    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();

        //生成一个计算资格，负责计算1+2+3+4
        CountTask task = new CountTask(1, 4);
        Future<Integer> result = (Future<Integer>) forkJoinPool.submit((Runnable) task);
        try {
            System.out.println(result.get());
        } catch (Exception e) {
        }
    }
}

package cn.concurrent.task;

import java.math.BigInteger;
import java.util.concurrent.BlockingQueue;

/**
 * Created by spark on 17-9-19.
 * 通过中断来处理取消生产端往阻塞队列中放入对象。保证put方法可以恢复
 */
public class PrimeProducer extends Thread {

    private final BlockingQueue<BigInteger> queue;

    public PrimeProducer(BlockingQueue<BigInteger> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {

        try {
            BigInteger p = BigInteger.ONE;
            while (!Thread.currentThread().isInterrupted()) {
                queue.put(p = p.nextProbablePrime());
            }
        } catch (InterruptedException e) {
            //允许线程退出
            e.printStackTrace();
        }
    }

    public void cancel() {
        //中断线程
        interrupt();
    }
}

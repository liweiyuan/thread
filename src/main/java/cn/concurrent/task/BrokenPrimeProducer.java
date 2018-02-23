package cn.concurrent.task;

import java.math.BigInteger;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by spark on 17-9-19.
 * 如果在BlockingQueue放入的对象多于消费的对象，put方法将会阻塞，
 * 如果此时中断线程，则无法从阻塞的put方法中恢复
 */
public class BrokenPrimeProducer extends Thread {
    private final BlockingQueue<BigInteger> queue;

    private volatile boolean cancelled = false;

    public BrokenPrimeProducer(BlockingQueue<BigInteger> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            BigInteger p = BigInteger.ONE;
            while (!cancelled) {
                //put方法是一个阻塞的方法，
                queue.put(p = p.nextProbablePrime());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void cancel() {
        this.cancelled = true;
    }


    //消費方法
    void consumerPrimes() {
        BlockingQueue<BigInteger> prime = new LinkedBlockingQueue(20);
        BrokenPrimeProducer primeProducer = new BrokenPrimeProducer(prime);
        primeProducer.start();
        try {
            while (newdMorePrimes()) {
                consume(prime.take());
            }
        } catch (InterruptedException e) {
            //取消操作
            primeProducer.cancel();
            e.printStackTrace();
        }
    }

    private void consume(BigInteger take) {
        //消費操作
    }

    private boolean newdMorePrimes() {
        return true;
    }
}

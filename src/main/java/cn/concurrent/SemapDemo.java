package cn.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Created by spark on 17-9-16.
 * 一个计数信号量。从概念上讲，信号量维护了一个许可集。如有必要，在许可可用前会阻塞每一个 acquire()，然后再获取该许可。
 * 每个 release() 添加一个许可，从而可能释放一个正在阻塞的获取者。
 * 但是，不使用实际的许可对象，Semaphore 只对可用许可的号码进行计数，并采取相应的行动。
 * <p>用处：Semaphore 通常用于限制可以访问某些资源（物理或逻辑的）的线程数目。</p>
 */
public class SemapDemo implements Runnable {
    final Semaphore semp = new Semaphore(5);

    @Override
    public void run() {
        try {
            semp.acquire();
            //耗时操作
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getId() + ":done!");
            semp.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(20);
        SemapDemo demo = new SemapDemo();
        for (int i = 0; i < 20; i++) {
            executorService.submit(demo);
        }
        executorService.shutdown();
    }
}
/**
 * 为了简单起见我们假设停车场仅有5个停车位，一开始停车场没有车辆所有车位全部空着，然后先后到来三辆车，停车场车位够，
 * 安排进去停车，然后又来三辆，这个时候由于只有两个停车位，所有只能停两辆，其余一辆必须在外面候着，直到停车场有空车位，
 * 当然以后每来一辆都需要在外面候着。当停车场有车开出去，里面有空位了，则安排一辆车进去（至于是哪辆 要看选择的机制是公平还是非公平）。
 * <p>
 * 从程序角度看，停车场就相当于信号量Semaphore，其中许可数为5，车辆就相对线程。当来一辆车时，许可数就会减 1 ，
 * 当停车场没有车位了（许可书 == 0 ），其他来的车辆需要在外面等候着。如果有一辆车开出停车场，许可数 + 1，然后放进来一辆车。
 * <p>
 * 号量Semaphore是一个非负整数（>=1）。当一个线程想要访问某个共享资源时，它必须要先获取Semaphore，
 * 当Semaphore >0时，获取该资源并使Semaphore – 1。如果Semaphore值 = 0，则表示全部的共享资源已经被其他线程全部占用，
 * 线程必须要等待其他线程释放资源。当线程释放资源时，Semaphore则+1
 */

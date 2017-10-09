package cn.concurrent;

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by tingyun on 2017/10/9.
 */
public class ReentrantlockDemo {
    private ArrayList<Integer> arrayList = new ArrayList<Integer>();
    private Lock lock = new ReentrantLock(); // 注意这个地方：lock 被声明为成员变量

    public static void main(String[] args) {
        final ReentrantlockDemo test = new ReentrantlockDemo();

        new Thread("A") {
            public void run() {
                test.insert(Thread.currentThread());
            }
        }.start();

        new Thread("B") {
            public void run() {
                test.insert(Thread.currentThread());
            }
        }.start();
    }

    public void insert(Thread thread) {
        if (lock.tryLock()) {     // 使用 tryLock()
            try {
                System.out.println("线程" + thread.getName() + "得到了锁...");
                for (int i = 0; i < 5; i++) {
                    arrayList.add(i);
                }
            } catch (Exception e) {

            } finally {
                System.out.println("线程" + thread.getName() + "释放了锁...");
                lock.unlock();
            }
        } else {
            System.out.println("线程" + thread.getName() + "获取锁失败...");
        }
    }
}

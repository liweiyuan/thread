package cn.concurrent;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * Created by tingyun on 2018/1/8.
 * AtomicStampedReference和AtomicInteger的区别
 * 我们定义两个线程，线程1负责将100 —> 110 —> 100，线程2执行 100 —>120，看两者之间的区别。
 */
public class AtomicStampedReferenceAndAtomInteger {

    private static AtomicInteger atomicInteger=new AtomicInteger(100);
    private static AtomicStampedReference atomicStampedReference=new AtomicStampedReference(100,1);


    public static void main(String[] args) throws InterruptedException {

        //AtomicInteger
        Thread at1 = new Thread(new Runnable() {
            @Override
            public void run() {
                atomicInteger.compareAndSet(100,110);
                atomicInteger.compareAndSet(110,100);
            }
        });

        Thread at2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(2);      // at1,执行完
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.err.println("AtomicInteger:" + atomicInteger.compareAndSet(100,120));
            }
        });

        at1.start();
        at2.start();

        at1.join();
        at2.join();

        //AtomicStampedReference
        Thread tsf1=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    //让 tsf2先获取stamp，导致预期时间戳不一致
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // 预期引用：100，更新后的引用：110，预期标识getStamp() 更新后的标识getStamp() + 1
                atomicStampedReference.compareAndSet(100,110,
                        atomicStampedReference.getStamp(),atomicStampedReference.getStamp()+1);
                atomicStampedReference.compareAndSet(110,100,
                        atomicStampedReference.getStamp(),atomicStampedReference.getStamp()+1);

            }
        });

        Thread tsf2=new Thread(new Runnable() {
            @Override
            public void run() {
                int stamp=atomicStampedReference.getStamp();
                try{
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.err.println("AtomicStampedReference:" +
                        atomicStampedReference.compareAndSet(100,120,stamp,stamp + 1));

            }
        });
        tsf1.start();
        tsf2.start();
    }
}

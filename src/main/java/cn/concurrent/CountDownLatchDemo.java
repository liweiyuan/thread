package cn.concurrent;

import java.util.concurrent.CountDownLatch;

/**
 * Created by spark on 17-9-16.
 * 闭锁操作，等所有的都准备好，才可以进行
 */
public class CountDownLatchDemo implements Runnable {

    static final CountDownLatch end=new CountDownLatch(10);
    @Override
    public void run() {

    }
}

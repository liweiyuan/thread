package cn.concurrent;

/**
 * Created by tingyun on 2017/10/9.
 */
public class SynchronizedDemo {

    private int c = 0;

    public synchronized void test() {
        c++;
    }

    public int getC() {
        return c;
    }
}

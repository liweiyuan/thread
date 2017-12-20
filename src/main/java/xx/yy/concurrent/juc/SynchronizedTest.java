package xx.yy.concurrent.juc;

/**
 * Created by tingyun on 2017/12/18.
 */
public class SynchronizedTest {

    public synchronized void test1() {

    }

    public void test2() {
        synchronized (this) {

        }
    }
}

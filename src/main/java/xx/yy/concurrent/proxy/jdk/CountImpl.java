package xx.yy.concurrent.proxy.jdk;

import java.util.concurrent.CountDownLatch;

/**
 * Created by tingyun on 2018/3/13.
 */
public class CountImpl implements Count {
    @Override
    public void queryCount() {
        System.out.println("查看账户方法...");

    }

    @Override
    public void updateCount() {
        System.out.println("修改账户方法...");

    }
}

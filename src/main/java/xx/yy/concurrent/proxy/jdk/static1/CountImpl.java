package xx.yy.concurrent.proxy.jdk.static1;

import xx.yy.concurrent.proxy.jdk.static1.Count;

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

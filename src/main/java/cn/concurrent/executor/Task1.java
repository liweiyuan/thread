package cn.concurrent.executor;

import java.util.concurrent.Callable;

/**
 * Created by spark on 17-9-24.
 *  统计“盘子”大小的代码，此处实现jdk中的Callable接口，
 */
public class Task1 implements Callable<Integer> {
    private int x;
    private int y;

    public Task1(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public Integer call() throws Exception {
        return x*y;
    }
}

package cn.concurrent.executor;

import java.util.concurrent.Callable;

/**
 * Created by spark on 17-9-24.
 */
public class Task2 implements Callable<Integer> {

    private int x;
    private int y;
    private int q;
    private int w;

    public Task2(int x, int y, int q, int w) {
        this.x = x;
        this.y = y;
        this.q = q;
        this.w = w;
    }

    @Override
    public Integer call() throws Exception {
        return x + y + q + w;
    }
}

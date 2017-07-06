package com.tingyun.bean;

/**
 * Created by tingyun on 2017/7/3.
 */
public class Counter {
    protected static long count = 0;

    public int add(long value) {
        this.count = this.count + value;
        return (int) this.count;
    }

}

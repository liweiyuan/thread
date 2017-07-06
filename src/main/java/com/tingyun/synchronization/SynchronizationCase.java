package com.tingyun.synchronization;

/**
 * Created by tingyun on 2017/7/4.
 */
public class SynchronizationCase {

    private  int count;

    private static int count1;

    /**
     * 同步实例方法
     */
    public  int add(int value){
        synchronized (this){
           count+=value;
        }
        return count;
    }


    /**
     * 静态方法同步
     */
    public static synchronized void add1(int value){
        count1 += value;

    }

}

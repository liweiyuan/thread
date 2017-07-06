package com.tingyun.threadlocal;

/**
 * Created by tingyun on 2017/7/4.
 */
public class ThreadLocalCase {
    public static void main(String[] args) {

        ThreadLocal threadLocal = new ThreadLocal() {
            @Override
            protected Object initialValue() {
                return "This is the initial value";

            }
        };

        String value = (String) threadLocal.get();
        System.out.print(value);
    }
}

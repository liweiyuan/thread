package org.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

/**
 * Created by tingyun on 2017/10/19.
 */
public class MyInvocationHandler implements InvocationHandler {

    private Object target;

    public MyInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long beginTime=System.currentTimeMillis();
        TimeUnit.MICROSECONDS.sleep(1);
        Object obj=method.invoke(target,args);
        System.out.println("总耗时:"+(System.currentTimeMillis()-beginTime)+"ms");
        return obj;
    }
}

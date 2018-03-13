package xx.yy.concurrent.proxy.jdk.invoke;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by tingyun on 2018/3/13.
 */
public class DynamicSubject implements InvocationHandler {

    private Object obj;

    public DynamicSubject(Object obj) {
        this.obj = obj;
    }

    public DynamicSubject() {
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println( " before calling "  + method);
        method.invoke(proxy,args);
        System.out.println( " after calling "  + method);
        return null;
    }
}

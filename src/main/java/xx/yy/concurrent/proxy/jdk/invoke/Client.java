package xx.yy.concurrent.proxy.jdk.invoke;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * Created by tingyun on 2018/3/13.
 */
public class Client
{
    public static void main(String[] args) {
        RealSubject realSubject=new RealSubject();
        InvocationHandler ds=new DynamicSubject(realSubject);
        Class cls=realSubject.getClass();
        //调用Proxy

        Subject subject= (Subject) Proxy.newProxyInstance(cls.getClassLoader(),cls.getInterfaces(),ds);
        subject.request();
    }
}

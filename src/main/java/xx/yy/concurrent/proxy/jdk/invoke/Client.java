package xx.yy.concurrent.proxy.jdk.invoke;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * Created by tingyun on 2018/3/13.
 * 最重要的是newProxyInstance,这个方法中，指明了将要代理的类的加载器，
 * 业务类接口，以及代理类要执行动作的调用处理器（InvokeHandler)
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

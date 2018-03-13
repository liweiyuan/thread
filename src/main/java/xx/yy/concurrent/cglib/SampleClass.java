package xx.yy.concurrent.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by wade on 18-3-7.
 */
public class SampleClass {

    public void test(){
        System.out.println("hello world");
    }

    public static void main(String[] args) {
        Enhancer enhancer=new Enhancer();
        enhancer.setSuperclass(SampleClass.class);
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                System.out.println("before method run...");
                Object obj=methodProxy.invoke(o,objects);
                System.out.println("after method run...");
                return obj;
            }
        });
        SampleClass sample = (SampleClass) enhancer.create();
        sample.test();
    }
}

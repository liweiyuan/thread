package xx.yy.concurrent.laoma.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by tingyun on 2018/2/24.
 */
public class SimpleJDKDynamicProxyDemo {
    static interface IService{
        public void sayHello();
    }
    static class RealService implements IService {
        @Override
        public void sayHello() {
            System.out.println("hello");
        }
    }
    static class SimpleInvocationHandler implements InvocationHandler{
        private Object obj;
        public SimpleInvocationHandler(Object obj) {
            this.obj = obj;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("entering " + method.getName());
            Object result = method.invoke(obj, args);
            System.out.println("leaving " + method.getName());
            return result;
        }
    }

    public static void main(String[] args) {
        IService iService=new RealService();
        IService proxyService= (IService) Proxy.newProxyInstance(
                IService.class.getClassLoader(),new Class<?>[]{IService.class},new SimpleInvocationHandler(iService));
        proxyService.sayHello();
    }
}

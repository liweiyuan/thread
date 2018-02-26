package xx.yy.concurrent.laoma.proxy.cglib.demo;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * Created by tingyun on 2018/2/26.
 */
@Aspect({ServiceA.class,ServiceB.class})
public class ServiceLogAspect {

    public static void before(Object object, Method method, Object[] args) {
        System.out.println("entering " + method.getDeclaringClass().getSimpleName()
                + "::" + method.getName() + ", args: " + Arrays.toString(args));
    }

    public static void after(Object object, Method method, Object[] args, Object result) {
        System.out.println("leaving " + method.getDeclaringClass().getSimpleName()
                + "::" + method.getName() + ", result: " + result);
    }
}

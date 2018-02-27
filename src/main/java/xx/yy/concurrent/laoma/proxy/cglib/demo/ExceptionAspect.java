package xx.yy.concurrent.laoma.proxy.cglib.demo;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * Created by tingyun on 2018/2/26.
 */
@Aspect({ServiceB.class})
public class ExceptionAspect {
    public static void exception(Object object,
                                 Method method, Object[] args, Throwable e) {
        System.err.println("exception when calling: " + method.getName()
                + "," + Arrays.toString(args));

    }

}

package xx.yy.concurrent.laoma;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by tingyun on 2018/2/24.
 */
public class MethodTest {
    public static void main(String[] args) {
        Class<?> cls = Integer.class;
        try {
            Method method = cls.getMethod("parseInt", new Class[]{String.class});
            System.out.println(method.invoke(null, "123"));
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}

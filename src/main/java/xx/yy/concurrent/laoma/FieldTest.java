package xx.yy.concurrent.laoma;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

/**
 * Created by tingyun on 2018/2/24.
 */
public class FieldTest {

    public static void main(String[] args) throws IllegalAccessException {
        List<String> obj = Arrays.asList(new String[]{"老马", "编程"});
        Class<?> cls = obj.getClass();
        for (Field e : cls.getDeclaredFields()) {
            /**
             * 关闭检查
             * private调用产生IllegalAccessException
             */
            e.setAccessible(true);
            System.out.println(e.getName() + " - " +e.get(obj));
        }
    }
}

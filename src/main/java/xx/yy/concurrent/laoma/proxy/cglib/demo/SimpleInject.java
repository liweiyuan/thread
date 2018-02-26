package xx.yy.concurrent.laoma.proxy.cglib.demo;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by tingyun on 2018/2/26.
 */
@Retention(RUNTIME)
@Target(FIELD)
public @interface SimpleInject {
}

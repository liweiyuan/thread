package xx.yy.concurrent.proxy.jdk.invoke;

/**
 * Created by tingyun on 2018/3/13.
 */
public class RealSubject  implements Subject{
    public void request() {
        System.out.println( " From real subject. " );
    }
}

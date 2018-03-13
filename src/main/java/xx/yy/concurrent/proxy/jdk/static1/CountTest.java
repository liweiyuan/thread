package xx.yy.concurrent.proxy.jdk.static1;

/**
 * Created by tingyun on 2018/3/13.
 */
public class CountTest {

    public static void main(String[] args) {
        CountImpl countImpl = new CountImpl();
        CountProxy countProxy = new CountProxy(countImpl);
        countProxy.updateCount();
        countProxy.queryCount();
    }
}

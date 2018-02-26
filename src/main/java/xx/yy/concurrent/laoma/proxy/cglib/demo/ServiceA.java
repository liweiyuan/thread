package xx.yy.concurrent.laoma.proxy.cglib.demo;

/**
 * Created by tingyun on 2018/2/26.
 */
public class ServiceA {
    @SimpleInject
    ServiceB b;

    public void callB(){
        b.action();
    }

    public ServiceB getB() {
        return b;
    }

}

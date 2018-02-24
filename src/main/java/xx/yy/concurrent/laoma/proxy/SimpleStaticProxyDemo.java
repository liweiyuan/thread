package xx.yy.concurrent.laoma.proxy;

/**
 * Created by tingyun on 2018/2/24.
 * 静态代理
 */
public class SimpleStaticProxyDemo {

    static interface Iservice {
        public void sayHello();
    }

    static class RealService implements Iservice {
        @Override
        public void sayHello() {
            System.out.println("hello.");
        }
    }

    static class TranceProxy implements Iservice {
        private Iservice realService;

        public TranceProxy(Iservice realService) {
            this.realService = realService;
        }

        @Override
        public void sayHello() {
            System.out.println("entering sayHello");
            this.realService.sayHello();
            System.out.println("leaving sayHello");
        }

    }
    public static void main(String[] args) {
        Iservice iservice=new RealService();
        Iservice proxyService=new TranceProxy(iservice);
        proxyService.sayHello();
    }
}

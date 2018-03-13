package xx.yy.concurrent.proxy.jdk;

/**
 * Created by tingyun on 2018/3/13.
 * 代理类
 */
public class CountProxy implements Count {

    private CountImpl countImpl;

    public CountProxy(CountImpl countImpl) {
        this.countImpl = countImpl;
    }

    @Override
    public void queryCount() {
        System.out.println("事务处理之前");
        // 调用委托类的方法;
        countImpl.queryCount();
        System.out.println("事务处理之后");
    }

    @Override
    public void updateCount() {
        System.out.println("事务处理之前");
        // 调用委托类的方法;
        countImpl.updateCount();
        System.out.println("事务处理之后");

    }
}

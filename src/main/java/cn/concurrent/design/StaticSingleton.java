package cn.concurrent.design;

/**
 * Created by spark on 17-9-5.
 * 内部类的形式创建单利对象，保证并发性与延迟加载
 */
public class StaticSingleton {


    private StaticSingleton() {
        System.out.println("StaticSingleton is create.");
    }

    private static class SingletonHolder {
        private static StaticSingleton instance = new StaticSingleton();
    }

    public StaticSingleton getInstance() {
        return SingletonHolder.instance;
    }
}

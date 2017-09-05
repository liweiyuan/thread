package cn.concurrent.design;

/**
 * Created by spark on 17-9-5.
 */
public class Singleton {
    private Singleton() {
        System.out.println("Singleton is create.");
    }

    private static Singleton singleton = new Singleton();

    public static Singleton getInstance() {
        return singleton;
    }
}

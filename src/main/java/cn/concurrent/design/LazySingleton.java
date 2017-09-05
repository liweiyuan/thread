package cn.concurrent.design;

/**
 * Created by spark on 17-9-5.
 */
public class LazySingleton {
    private LazySingleton() {
        System.out.println("LazySingleton is create.");
    }

    private static LazySingleton instance = null;

    public static synchronized LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }
}
/**
 * 延迟加载,只有在第一次調用該方法的時候創建該對象
 */

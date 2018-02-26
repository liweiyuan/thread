package xx.yy.concurrent.laoma.classloader;

/**
 * Created by wade on 18-2-26.
 */
public class CLInitDemo {
    public static class Hello {
        static {
            System.out.println("hello");
        }
    }

    public static void main(String[] args) {
        ClassLoader cl = ClassLoader.getSystemClassLoader();
        String className = CLInitDemo.class.getName() + "$Hello";
        try {
            //Class<?> cls = cl.loadClass(className);  //不会进行类的初始化操作
            Class<?> cls = Class.forName(className);  //会进行类的初始化操作
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

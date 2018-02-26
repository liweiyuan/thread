package xx.yy.concurrent.laoma.classloader;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * Created by wade on 18-2-26.
 */
public class ConfigurableStrategyDemo {

    public static IService createService(){
        try {
            Properties p=new Properties();
            String fileName= "a.properties";
            p.load(new FileInputStream(fileName));
            String serviceName=p.getProperty("service");
            Class<?> cls=Class.forName(serviceName);
            return (IService) cls.newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) {
        IService service = createService();
        service.action();
    }
}

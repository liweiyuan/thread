package xx.yy.concurrent.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.FixedValue;

/**
 * Created by wade on 18-3-7.
 */
public class CGLIBTest {

    public static void main(String[] args) {
        Enhancer enhancer=new Enhancer();
        enhancer.setSuperclass(SampleClass2.class);
        enhancer.setCallback(new FixedValue() {
            public Object loadObject() throws Exception {
                return "hello cglib.";
            }
        });

        SampleClass2 proxy= (SampleClass2) enhancer.create();
        System.out.println(proxy.test("a")); //拦截test，输出Hello cglib
        System.out.println(proxy.toString());
        System.out.println(proxy.getClass());
        System.out.println(proxy.hashCode());
    }
}

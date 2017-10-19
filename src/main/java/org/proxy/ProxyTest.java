package org.proxy;

import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tingyun on 2017/10/19.
 */
public class ProxyTest {



    public static void main(String[] args) {
        //ArrayList代理,通过代理计算每个方法调用所需时间
        List<Integer> arrayListProxy = (List<Integer>) Proxy.newProxyInstance(
                ArrayList.class.getClassLoader(),     /*定义代理类的类加载器,用于创建代理对象,不一定必须是ArrayList,也可以是其他的类加载器*/
                ArrayList.class.getInterfaces(),       /*代理类要实现的接口列表*/
                new MyInvocationHandler(new ArrayList<Integer>())         /*指派方法调用的调用处理程序,这里用了匿名内部类*/
        );
        arrayListProxy.add(2);
        arrayListProxy.add(4);
        System.out.println("--------- 迭代 ---------");
        for(int i : arrayListProxy) {
            System.err.println(i);
        }
    }
}

package org.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by tingyun on 2017/10/19.
 * @author tingyun
 * 　“写一个 ArrayList 类的代理，其内部实现和 ArrayList 中完全相同的功能，并可以计算每个方法运行的时间。”
 * 这是一份考题上的题目，没有答案，来看下实现：
 *
 */
public class ProxyApp {
    public static void main(String[] args) {
        //ArrayList代理类，获取每个方法运行的时间
        @SuppressWarnings("unchecked")
        List<Integer> arrayListProxy = (List<Integer>) Proxy.newProxyInstance(
                ArrayList.class.getClassLoader(),/*定义代理类的类加载器,用于创建代理对象,不一定必须是ArrayList,也可以是其他的类加载器*/
                ArrayList.class.getInterfaces(),/*代理类要实现的接口列表*/
                new InvocationHandler() { /*指派方法调用的调用处理程序,这里用了匿名内部类*/
                    //正真操作的对象(目标对象)
                    private ArrayList<Integer> target=new ArrayList<Integer>();

                    /**
                     * 在代理实例上处理方法调用并返回结果
                     * @param proxy  代理对象(注意不是目标对象)
                     * @param method  被代理的方法
                     * @param args     被代理的方法的参数集
                     * @return         <span style="color: #008080;"> 返回方法调用结果 </span>
                     * @throws Throwable
                     */
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        long beginTime=System.currentTimeMillis();//开始时间
                        TimeUnit.MICROSECONDS.sleep(1);
                        Object obj=method.invoke(target,args);//实际调用的方法,并接受方法的返回值
                        long endTime=System.currentTimeMillis();
                        System.out.println("[" + method.getName() + "] spend " + (endTime - beginTime) + " ms");
                        return obj;  //返回实际调用的方法的返回值
                    }
                });
        arrayListProxy.add(2);
        arrayListProxy.add(3);
        arrayListProxy.toString();
        System.out.println("--------- 迭代 ---------");
        for(Integer integer:arrayListProxy){
            System.err.println(integer+"\t");
        }
    }
}

package cn.concurrent.executor;

/**
 * Created by spark on 17-9-30.
 * 基于CAS原理的原子操作，一种乐观锁的基础模型，
 * 以下均为伪代码
 */
public class CASDemo {

    //对于i++；多线程如何保证安全
    //1.

    public void test1(){
        /*int expect=a;
        if(a.compareAndSet(expect,a+1)){
            //doSomthing();
        }else {
            //doSomthing2();
        }*/
    }

    //2.乐观锁的做法。
    public void test2(){
        /*while(true){
            int expect=a;
            if(a.compareAndSet(expect,a+1)){
                //doSomthing();
                return;
            }else {
                //doSomthing2();
            }
        }*/

    }


}

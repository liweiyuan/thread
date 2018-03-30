package xx.yy.concurrent.cache;

/**
 * Created by tingyun on 2017/12/4.
 * 解释CAS原理:
 * CAS有3个操作数，内存中的值V，预期内存中的值A，要修改成的值B。
 * 当内存值V和预期值相同时，就将内存值V修改为B，否则什么都不做。
 *
 * java中主要通过UNSAFE来实现CAS操作,利用JNI来实现对CPU命令的调用
 */
public class CasTest implements Runnable {

    private int memoryValue=1;
    private int expectValue;
    private int updateValue;

    public CasTest(int expectValue, int updateValue) {
        this.expectValue = expectValue;
        this.updateValue = updateValue;
    }

    @Override
    public void run() {
        if(memoryValue==expectValue){
            this.memoryValue=updateValue;
            System.out.println("修改成功");
        }else{
            System.out.println("修改失败");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        CasTest casTest1 = new CasTest(1,2);
        Thread t1 = new Thread(casTest1);
        t1.start();

        Thread t2= new Thread(casTest1);
        t2.start();

        t1.join();
        t2.join();

    }

    /**
     * 模拟cpu级别的原子操作cas
     */
}

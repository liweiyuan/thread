package xx.yy.concurrent.juc;

/**
 * Created by tingyun on 2017/12/21.
 */
public class VolatileTest {

    private volatile int number;

    public static void main(String[] args) {

    }

    public int getResult(){
        return number++;
    }
}

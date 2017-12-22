package xx.yy.concurrent.juc;

import java.io.Serializable;

/**
 * Created by tingyun on 2017/12/22.
 */
public class RecordExample1  implements Serializable {

    volatile static int b = 2;

    transient static   int c=1;

    public static void main(String[] args) {
        int a = 1;


        c=3;

        try {
            a = 3;
            b = 1 / 0;
        } catch (Exception e) {

        } finally {
            System.err.println("a : " + a);
        }
    }
}

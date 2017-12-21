package xx.yy.concurrent.juc;

import java.util.Vector;

/**
 * Created by tingyun on 2017/12/21.
 */
public class VectorTest {
    public static void main(String[] args) {
        Vector<String> vector=new Vector<String>();
        for(int i=0;i<10;i++){
            vector.add(i+"");
        }
        System.out.println(vector);
    }
}

package xx.yy.concurrent.algorithm;

/**
 * Created by tingyun on 2018/1/23.
 */
public class BinarySearchSTTest {

    public static void main(String[] args) {
        BinarySearchST<Integer,Integer> bs=new BinarySearchST<>(10);

        bs.put(3,3);
        bs.put(2,4);
        bs.put(1,4);
        System.err.println(bs.size());

    }
}

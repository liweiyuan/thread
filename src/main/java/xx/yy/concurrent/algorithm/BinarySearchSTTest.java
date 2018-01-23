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
        bs.put(4,6);
        bs.put(5,5);
        System.err.println(bs.size());
        bs.get(2);

        System.err.println(bs.ceiling(1));
    }
}

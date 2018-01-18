package xx.yy.concurrent.algorithm;

import java.util.Iterator;

/**
 * Created by tingyun on 2018/1/18.
 */
public class BagTest {

    public static void main(String[] args) {
        Bag<Integer> bag=new Bag<Integer>();
        boolean bool=bag.isEmpty();
        System.err.println("bag : "+bool);

        //增加一个元素
        bag.add(2);
        bool=bag.isEmpty();
        System.err.println("bag : "+bool);
        //背包的容量
        int size=bag.size();
        System.out.println("size : "+size);

        bag.add(3);
        bag.add(4);
        Iterator<Integer> it=bag.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }

    }
}

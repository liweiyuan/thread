package xx.yy.concurrent;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by tingyun on 2017/12/1.
 */
public class ArrayDequeTest {

    public static void main(String[] args) {
        Deque<String> deque=new ArrayDeque<String>();
        deque.addFirst("hello");
        deque.addFirst("world");
        //deque.getFirst();
        System.err.println(deque);
    }
}

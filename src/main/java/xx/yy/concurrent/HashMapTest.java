package xx.yy.concurrent;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by tingyun on 2017/11/23.
 * <p>
 * HashMap陷入死循环，造成内存溢出
 * 494行的单向链表标成了循环链表。造成的
 * 推荐使用ConcurrentHashMap:
 * ConcurrentHashMap中多了一层数组结构，由Segment和HashEntry两个数组组成。
 * 其中Segment起到了加锁同步的作用，而HashEntry则起到了存储K.V键值对的作用。
 */
public class HashMapTest {

    public static void main(String[] args) throws InterruptedException {
        final Map<String, String> map = new HashMap<String, String>();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int x = 0; x < 10000; x++) {
                    Thread tt = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            map.put(UUID.randomUUID().toString(), "");
                        }
                    });
                    tt.start();
                    System.out.println(tt.getName());
                }
            }
        });
        thread.start();
        thread.join();

        System.err.println(1 << 30);


    }

    final int number = 3;

    final Student student = new Student();


    class Student {
        private int id;
        private String name;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public void set() {
        student.setId(20);

    }

}

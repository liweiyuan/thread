package cn.concurrent.cache;

import cn.concurrent.cache.Computable;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by spark on 17-9-17.
 */
public class Memoizer2<A, V> implements Computable<A, V> {

    private final Map<A, V> cache = new ConcurrentHashMap<A, V>();
    private final Computable<A, V> c;

    public Memoizer2(Computable<A, V> c) {
        this.c = c;
    }


    //这个很好的解决了并发的问题。
    //第二种方式，如果某个线程启动了一个开销很大的计算，其他线程不知道这个计算正在进行，很可能会重复这个计算
    //我们可以使用FutureTask来解决这个问题
    @Override
    public V compute(A arg) throws InterruptedException {

        V result = cache.get(arg);
        if (result == null) {
            result = c.compute(arg);
            cache.put(arg, result);
        }
        return result;
    }
}

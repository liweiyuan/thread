package cn.concurrent.cache;

import cn.concurrent.cache.Computable;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by spark on 17-9-17.
 */
public class Memoizer<A, V> implements Computable<A, V> {

    private final Map<A, V> cache = new HashMap<A, V>();
    private final Computable<A, V> c;

    public Memoizer(Computable<A, V> c) {
        this.c = c;
    }


    //第一种方式，实现缓存，但是问题，某一个时刻只能有一个线程进行访问，其他的线程都是阻塞状态
    //思路1，用并发的ConcurrentHashMap代替HashMap
    @Override
    public synchronized V compute(A arg) throws InterruptedException {

        V result = cache.get(arg);
        if (result == null) {
            result = c.compute(arg);
            cache.put(arg, result);
        }
        return result;
    }
}
package cn.concurrent.cache;

import java.util.Map;
import java.util.concurrent.*;

/**
 * Created by spark on 17-9-17.
 */
public class Memoizer3<A, V> implements Computable<A, V> {

    private final Map<A, Future<V>> cache = new ConcurrentHashMap<A, Future<V>>();
    private final Computable<A, V> c;

    public Memoizer3(Computable<A, V> c) {
        this.c = c;
    }


    //这个很好的解决了并发的问题。
    //首先会检查相应的计算是否已经开启，如果没有开启，就创建一个FutureTask，注册到Map中，
    //如果开启了，就等待计算的结果
    @Override
    public V compute(final A arg) throws InterruptedException {
        Future<V> result = cache.get(arg);
        if (result == null) {
            Callable<V> eval = new Callable<V>() {
                @Override
                public V call() throws Exception {
                    return c.compute(arg);
                }
            };
            FutureTask<V> task = new FutureTask<V>(eval);
            result = task;
            cache.put(arg, task);
            task.run();//这里将调用c.compute()
        }
        try {
            return result.get();
        } catch (ExecutionException e) {
            throw new RuntimeException(e.getCause());
        }
    }
}

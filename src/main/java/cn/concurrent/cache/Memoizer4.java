package cn.concurrent.cache;

import java.util.Map;
import java.util.concurrent.*;

/**
 * Created by spark on 17-9-17.
 */
public class Memoizer4<A, V> implements Computable<A, V> {

    //主要是要使用putIfAbsent这个原子方法
    private final ConcurrentHashMap<A, Future<V>> cache = new ConcurrentHashMap<A, Future<V>>();
    private final Computable<A, V> c;

    public Memoizer4(Computable<A, V> c) {
        this.c = c;
    }

    @Override
    public V compute(final A arg) throws InterruptedException {

        while (true) {
            Future<V> result = cache.get(arg);
            if (result == null) {
                Callable<V> eval = new Callable<V>() {
                    @Override
                    public V call() throws Exception {
                        return c.compute(arg);
                    }
                };
                FutureTask<V> task = new FutureTask<V>(eval);
                result = cache.putIfAbsent(arg, task);
                if (result == null) {
                    result = task;
                    task.run();
                }
            }

            try {
                return result.get();
            } catch (CancellationException e) {
                cache.remove(arg, result);
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }
}

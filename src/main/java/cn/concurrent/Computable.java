package cn.concurrent;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by spark on 17-9-17.
 */
public interface Computable<A, V> {
    V compute(A arg) throws InterruptedException;
}

class ExpensiveFunction implements Computable<String, BigInteger> {
    @Override
    public BigInteger compute(String arg) throws InterruptedException {
        //在经过长时间的计算后
        return new BigInteger(arg);
    }
}

class Memoizer<A, V> implements Computable<A, V> {

    private final Map<A, V> cache = new HashMap<A, V>();
    private final Computable<A, V> c;

    public Memoizer(Computable<A, V> c) {
        this.c = c;
    }

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

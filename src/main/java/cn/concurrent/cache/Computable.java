package cn.concurrent.cache;

import java.math.BigInteger;

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




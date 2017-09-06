package cn.concurrent.disruptor;

/**
 * Created by spark on 17-9-6.
 */
public class PCData {
    private long value;

    public void set(long value) {
        this.value = value;
    }

    public long get() {
        return value;
    }
}

package xx.yy.concurrent.learn.disruptor.factory;

/**
 * Created by tingyun on 2017/12/1.
 * 单生产者，单消费者模型：
 */
public class LongEvent {
    private long value;

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }
}

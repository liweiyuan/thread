package xx.yy.concurrent.learn.disruptor.factory;

import com.lmax.disruptor.EventFactory;

/**
 * Created by tingyun on 2017/12/1.
 * 事件生产工厂：生产事件存入ringbuffer中
 */
public class LongEventFactory implements EventFactory<LongEvent> {
    @Override
    public LongEvent newInstance() {
        return new LongEvent();
    }
}

package xx.yy.concurrent.learn.disruptor.factory;


import com.lmax.disruptor.EventHandler;

/**
 * Created by tingyun on 2017/12/1.
 * 事件处理器，也就是消费者，就是将事件的值打印出来
 */
public class LongEventHandler implements EventHandler<LongEvent> {


    @Override
    public void onEvent(LongEvent event, long l, boolean b) throws Exception {
        System.out.println("Event："+event.getValue());
    }
}

package cn.concurrent.disruptor;

import com.lmax.disruptor.WorkHandler;

/**
 * Created by spark on 17-9-6.
 * 消费者，作用是是读取数据进行处理
 * 事件处理器，也就是消费者，就是将事件的值打印出来
 */
public class Consumer implements WorkHandler<PCData> {
    @Override
    public void onEvent(PCData pcData) throws Exception {
        System.out.println(Thread.currentThread().getId() +
                ":Event:--" + pcData.get() * pcData.get() + "--");
    }
}

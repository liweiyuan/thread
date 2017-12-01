package xx.yy.concurrent.disruptor;

import com.lmax.disruptor.WorkHandler;

/**
 * Created by spark on 17-9-6.
 * 消费者，作用是是读取数据进行处理
 */
public class Consumer implements WorkHandler<PCData> {
    @Override
    public void onEvent(PCData pcData) throws Exception {
        System.out.println(Thread.currentThread().getId() +
                ":Event:--" + pcData.get() * pcData.get() + "--");
    }
}

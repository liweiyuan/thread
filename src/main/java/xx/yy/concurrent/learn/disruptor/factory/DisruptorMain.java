package xx.yy.concurrent.learn.disruptor.factory;

import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Created by tingyun on 2017/12/1.
 * 主函数：创建生产者，向ringbuffer中填充元素
 */
public class DisruptorMain {

    public static void main(String[] args) throws InterruptedException {
        //创建线程池
        Executor executor= Executors.newCachedThreadPool();
        //事件工厂
        LongEventFactory factory=new LongEventFactory();
        //ringBuffer的大小
        int ringBufferSize=256;
        //实例化Discuptor对象,初始化RingBuffer
        Disruptor<LongEvent> disruptor=new Disruptor<LongEvent>(factory,ringBufferSize,executor);
        //设置事件的执行者：(单消费者)
        disruptor.handleEventsWith(new LongEventHandler());
        //disruptor启动
        disruptor.start();
        RingBuffer<LongEvent> ringBuffer=disruptor.getRingBuffer();
        //设置事件生产者
        for(int i=0;i<ringBufferSize;i++){
            //获取下一个可用位置的下标
            long sequence=ringBuffer.next();
            try{
                // 返回可用位置的元素
                LongEvent event=ringBuffer.get(sequence);
                //设置钙元素的值
                event.setValue(i);
            }finally {
                //发布事件
                ringBuffer.publish(sequence);
            }
            Thread.sleep(100);
        }
    }
}

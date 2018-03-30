package cn.concurrent.disruptor;

import com.lmax.disruptor.RingBuffer;

import java.nio.ByteBuffer;

/**
 * Created by spark on 17-9-6.
 * 创建生产者，向ringbuffer中填充元素
 */
public class Producer {
    private final RingBuffer<PCData> ringBuffer;

    public Producer(RingBuffer<PCData> ringBuffer) {
        this.ringBuffer = ringBuffer;
    }

    //相当于生产者生产消息，放入到环形队列中。
    public void pushData(ByteBuffer bb) {
        long sequence = ringBuffer.next();//Gtab the next sequence
        try {
            PCData pcData = ringBuffer.get(sequence);//Get the entry in the Disruptor for the sequence
            pcData.set(bb.getLong(0));//Fill with data
        } finally {
            //发布事件
            ringBuffer.publish(sequence);
        }
    }
}

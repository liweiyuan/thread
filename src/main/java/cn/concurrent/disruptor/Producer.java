package cn.concurrent.disruptor;

import com.lmax.disruptor.RingBuffer;

import java.nio.ByteBuffer;

/**
 * Created by spark on 17-9-6.
 */
public class Producer {
    private final RingBuffer<PCData> ringBuffer;

    public Producer(RingBuffer<PCData> ringBuffer) {
        this.ringBuffer = ringBuffer;
    }

    public void pushData(ByteBuffer bb) {
        long sequence = ringBuffer.next();//Gtab the next sequence
        try {
            PCData pcData = ringBuffer.get(sequence);//Get the entry in the Disruptor for the sequence
            pcData.set(bb.getLong(0));//Fill with data
        } finally {
            ringBuffer.publish(sequence);
        }
    }
}

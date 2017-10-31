package org.io.nio;

import java.nio.IntBuffer;

/**
 * Created by spark on 17-10-30.
 * 当我们将数据写入到 Buffer 中时, Buffer 会记录我们已经写了多少的数据,
 * 当我们需要从 Buffer 中读取数据时, 必须调用 Buffer.flip()将 Buffer 切换为读模式.
 * 一旦读取了所有的 Buffer 数据, 那么我们必须清理 Buffer, 让其从新可写, 清理 Buffer
 * 可以调用 Buffer.clear() 或 Buffer.compact().
 */
public class BufferTest {
    public static void main(String[] args) {
        IntBuffer intBuffer = IntBuffer.allocate(3);
        intBuffer.put(12345678);
        intBuffer.put(2);
        intBuffer.flip();
        System.err.println(intBuffer.get());
        System.err.println(intBuffer.get());
        //intBuffer.put(3); Exception in thread "main" java.nio.BufferOverflowException
        //首先要切换到写的模式。
        intBuffer.flip();
        intBuffer.put(3);
        //切换到读的模式
        intBuffer.flip();
        System.err.println(intBuffer.get());
    }
}

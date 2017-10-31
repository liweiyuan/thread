package org.io.nio;

import java.nio.IntBuffer;

/**
 * Created by spark on 17-10-30.
 */
public class BufferTest3 {

    public static void main(String[] args) {
        IntBuffer intBuffer = IntBuffer.allocate(2);
        intBuffer.put(1);
        intBuffer.put(2);
        System.err.println("position: " + intBuffer.position());

        intBuffer.rewind();
        System.err.println("position: " + intBuffer.position());
        intBuffer.put(1);
        intBuffer.put(2);
        System.err.println("position: " + intBuffer.position());


        intBuffer.flip();
        System.err.println("position: " + intBuffer.position());
        intBuffer.get();
        intBuffer.get();
        System.err.println("position: " + intBuffer.position());

        intBuffer.rewind();
        System.err.println("position: " + intBuffer.position());
    }
    /**
     * Buffer.rewind()方法可以重置 position 的值为0, 因此我们可以重新读取/写入 Buffer 了.
     如果是读模式, 则重置的是读模式的 position, 如果是写模式, 则重置的是写模式的 position.
     */
}

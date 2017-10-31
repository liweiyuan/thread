package org.io.nio;

import java.nio.IntBuffer;

/**
 * Created by spark on 17-10-30.
 */
public class BufferTest4 {

    public static void main(String[] args) {
        IntBuffer intBuffer = IntBuffer.allocate(2);
        intBuffer.put(1);
        intBuffer.put(2);
        intBuffer.flip();
        System.err.println(intBuffer.get());
        System.err.println("position: " + intBuffer.position());
        intBuffer.mark();
        System.err.println(intBuffer.get());

        System.err.println("position: " + intBuffer.position());
        intBuffer.reset();
        System.err.println("position: " + intBuffer.position());
        System.err.println(intBuffer.get());
    }
    /**
     * 这里我们写入两个 int 值, 然后首先读取了一个值. 此时读 position 的值为1.
     接着我们调用 mark() 方法将当前的 position 保存起来(在读模式, 因此保存的是读的 position), 然后再次读取, 此时 position 就是2了.
     接着使用 reset() 恢复原来的读 position, 因此读 position 就为1, 可以再次读取数据.
     */
}

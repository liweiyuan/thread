package org.io.netty;

/**
 * Created by spark on 17-11-2.
 */
public class ChannelTest {

    public static void main(String[] args) {

        System.err.println("读操作 : OP_READ " + (1 << 0));
        System.err.println("写操作 : OP_WRITE " + (1 << 2));
        System.err.println("客户端连接服务端操作 : OP_CONNECT " + (1 << 3));
        System.err.println("服务端接受客户端连接操作 : OP_ACCEPT " + (1 << 4));
    }
}

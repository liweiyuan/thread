package cn.concurrent.nio.nio;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.channels.spi.SelectorProvider;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by spark on 17-9-10.
 */
public class NioThreadServer {

    //用于处理所有的网络连接
    private Selector selector;
    //处理实际的业务逻辑
    private ExecutorService tp = Executors.newCachedThreadPool();
    //时间统计的类
    public static Map<Socket, Long> time_stat = new HashMap<Socket, Long>(10240);

    private void startServer() throws IOException {
        selector = SelectorProvider.provider().openSelector();
        ServerSocketChannel ssc = ServerSocketChannel.open();
        ssc.configureBlocking(false);
        InetSocketAddress isa = new InetSocketAddress(InetAddress.getLocalHost(), 8000);
        //InetSocketAddress isa=new InetSocketAddress(8000);
        ssc.socket().bind(isa);
        SelectionKey acceptKey = ssc.register(selector, SelectionKey.OP_ACCEPT);
        for (; ; ) {
            selector.select();
            Set readyKeys = selector.selectedKeys();
            Iterator it = readyKeys.iterator();
            long e = 0;
            while (it.hasNext()) {
                SelectionKey sk = (SelectionKey) it.next();
                it.remove();
                if (sk.isAcceptable()) {
                    doAccept(sk);
                } else if (sk.isValid() && sk.isReadable()) {
                    if (!time_stat.containsKey(((SocketChannel) sk.channel()).socket())) {
                        time_stat.put(((SocketChannel) sk.channel()).socket(),
                                System.currentTimeMillis());
                    }
                    doRead(sk);
                } else if (sk.isValid() && sk.isWritable()) {
                    doWrite(sk);
                    e = System.currentTimeMillis();
                    long b = time_stat.remove(((SocketChannel) sk.channel()).socket());
                    System.out.println("spend: " + (e - b) + " ms");
                }
            }
        }
    }

    private void doWrite(SelectionKey sk) {
    }

    private void doRead(SelectionKey sk) {
    }

    private void doAccept(SelectionKey sk) {

        ServerSocketChannel server = (ServerSocketChannel) sk.channel();
        SocketChannel clientChannel;
        try {
            clientChannel = server.accept();
            clientChannel.configureBlocking(false);
            //Register this channel for reading.
            SelectionKey clientKey = clientChannel.register(selector, SelectionKey.OP_READ);
            //Allocate an EchoClient instance and attach it to selection key.
            EchoClient echoClient = new EchoClient();
            clientKey.attach(echoClient);

            InetAddress clientAddress = clientChannel.socket().getInetAddress();
            System.out.println("Accepted connection from " + clientAddress.getHostAddress() + ".");
        } catch (IOException e) {
            System.out.println("Failed to accept new client.");
            e.printStackTrace();
        }
    }


    class EchoClient {
        private LinkedList<ByteBuffer> outq;

        public EchoClient() {
            this.outq = new LinkedList<ByteBuffer>();
        }

        public LinkedList<ByteBuffer> getOutputQueue() {
            return outq;
        }

        public void enqueue(ByteBuffer byteBuffer) {
            outq.addFirst(byteBuffer);
        }
    }

}

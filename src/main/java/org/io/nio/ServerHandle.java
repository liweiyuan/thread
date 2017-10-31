package org.io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by tingyun on 2017/10/30.
 */
public class ServerHandle implements Runnable {

    private Selector selector;
    private ServerSocketChannel serverSocketChannel;

    private volatile boolean started;

    /**
     * 构造器
     *
     * @param port
     */
    public ServerHandle(int port) {
        try {
            //选择器
            selector = Selector.open();
            //打开监听通道
            serverSocketChannel = ServerSocketChannel.open();
            //如果为 true，则此通道将被置于阻塞模式；如果为 false，则此通道将被置于非阻塞模式
            serverSocketChannel.configureBlocking(false);
            //绑定端口 backlog设为1024
            serverSocketChannel.socket().bind(new InetSocketAddress(port), 1024);
            //监听客户端连接
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
            //标记服务器已开启
            started = true;
            System.out.println("服务器已启动，端口号：" + port);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public void stop() {
        started = false;
    }

    @Override
    public void run() {

        //循环遍历selector
        while (started) {
            try {
                //无论是否有读写事件发生，selector每隔1s被唤醒一次
                selector.select(1000);
                //阻塞,只有当至少一个注册的事件发生的时候才会继续.
                //selector.select();
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> it = selectionKeys.iterator();
                SelectionKey key = null;
                while (it.hasNext()) {
                    key = it.next();
                    it.remove();
                    try {
                        handleInput(key);
                    } catch (Exception e) {
                        e.printStackTrace();
                        if (key != null) {
                            key.cancel();
                            if (key.channel() != null) {
                                key.channel().close();
                            }
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //selector关闭后会自动释放里面管理的资源
        if (selector != null) {
            try {
                selector.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    private void handleInput(SelectionKey key) throws IOException {
        if (key.isValid()) {
            if (key.isAcceptable()) {
                ServerSocketChannel ssc = (ServerSocketChannel) key.channel();
                //通过ServerSocketChannel的accept创建SocketChannel实例
                //完成该操作意味着完成TCP三次握手，TCP物理链路正式建立
                SocketChannel socketChannel = ssc.accept();
                socketChannel.configureBlocking(false);
                //注册为读
                //注册为读
                socketChannel.register(selector, SelectionKey.OP_READ);
            }

            System.out.println();
            if (key.isReadable()) {
                //read the data
                SocketChannel sc = (SocketChannel) key.channel();
                //创建ByteBuffer，并开辟一个1M的缓冲区
                ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                //读取请求码流，返回读取到的字节数
                int readBytes = sc.read(byteBuffer);
                //读取到字节，对字节进行编解码
                if (readBytes > 0) {
                    //将缓冲区当前的limit设置为position=0，用于后续对缓冲区的读取操作
                    byteBuffer.flip();
                    //根据缓冲区可读字节数创建字节数组
                    byte[] bytes = new byte[byteBuffer.remaining()];
                    //将缓冲区可读字节数组复制到新建的数组中
                    byteBuffer.get(bytes);
                    String expression = new String(bytes, "UTF-8");
                    System.err.println("服务器收到消息：" + expression);
                    String currentTime = "QUERY TIME ORDER".equalsIgnoreCase(expression) ?
                            new Date(System.currentTimeMillis()).toString() : "BAD ORDER";
                    //处理数据
                    doWriter(sc, currentTime);
                }else if(readBytes<0){
                    key.cancel();
                    sc.close();
                }else{

                }
            }
        }
    }

    private void doWriter(SocketChannel sc, String response) throws IOException {
        //将消息编码为字节数组
        byte[] bytes = response.getBytes();
        //根据数组容量创建ByteBuffer
        ByteBuffer writeBuffer = ByteBuffer.allocate(bytes.length);
        //将字节数组复制到缓冲区
        writeBuffer.put(bytes);
        //flip操作
        writeBuffer.flip();
        //发送缓冲区的字节数组
        sc.write(writeBuffer);
    }

    /**
     *     打开ServerSocketChannel，监听客户端连接
     绑定监听端口，设置连接为非阻塞模式
     创建Reactor线程，创建多路复用器并启动线程
     将ServerSocketChannel注册到Reactor线程中的Selector上，监听ACCEPT事件
     Selector轮询准备就绪的key
     Selector监听到新的客户端接入，处理新的接入请求，完成TCP三次握手，简历物理链路
     设置客户端链路为非阻塞模式
     将新接入的客户端连接注册到Reactor线程的Selector上，监听读操作，读取客户端发送的网络消息
     异步读取客户端消息到缓冲区
     对Buffer编解码，处理半包消息，将解码成功的消息封装成Task
     将应答消息编码为Buffer，调用SocketChannel的write将消息异步发送给客户端
     */
}

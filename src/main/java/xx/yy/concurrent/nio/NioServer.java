package xx.yy.concurrent.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * Created by tingyun on 2018/1/11.
 */
public class NioServer {
    //通道管理器
    private Selector selector;

    public static void main(String[] args) throws IOException {
        NioServer nioServer=new NioServer();
        nioServer.initServer(8089);
        nioServer.listen();
    }


    private void initServer(int port) throws IOException {
        //获得一个serverSocket通道
        ServerSocketChannel socketChannel=ServerSocketChannel.open();
        //设置通道为非阻塞
        socketChannel.configureBlocking(false);
        //将该通道对应的serverSocket绑定到指定的端口上
        socketChannel.socket().bind(new InetSocketAddress(port));
        //获得通道管理器
        selector=Selector.open();
        // 将通道管理器和该通道绑定，并为该通道注册selectionKey.OP_ACCEPT事件
        // 注册该事件后，当事件到达的时候，selector.select()会返回，
        // 如果事件没有到达selector.select()会一直阻塞
        socketChannel.register(selector, SelectionKey.OP_ACCEPT);
    }
    //采用轮训的方式监听selector上是否有需要处理的事件，如果有，进行处理
    private void listen() throws IOException {
        System.out.println("start server...");
        //轮训方式访问Selector
        while(true){
            //当注册事件到达后，该方法立即返回，否则一直阻塞
            selector.select();
            // 获得selector中选中的相的迭代器，选中的相为注册的事件
            Iterator<SelectionKey> it=selector.selectedKeys().iterator();
            while (it.hasNext()){
                SelectionKey key=it.next();
                //删除已选的key，防止重复
                it.remove();
                //客户端请求连接事件
                if(key.isAcceptable()){
                    ServerSocketChannel channel= (ServerSocketChannel) key.channel();
                    //获得和客户端连接的通道
                    SocketChannel socketChannel=channel.accept();
                    //设置为非阻塞
                    socketChannel.configureBlocking(false);
                    //在这里发送消息给客户端
                    socketChannel.write(ByteBuffer.wrap(new String("hello client").getBytes()));
                    //在客户端连接成功后，为了可以接收到客户端的信息，需要给通道设置读的权
                    socketChannel.register(selector,SelectionKey.OP_READ);
                    //获得可读的事件
                }else if(key.isReadable()){
                    read(key);
                }
            }
        }
    }

    // 处理 读取客户端发来的信息事件
    private void read(SelectionKey key) throws IOException {
        // 服务器可读消息，得到事件发生的socket通道
        SocketChannel channel= (SocketChannel) key.channel();
        //创建读取的缓冲区
        ByteBuffer byteBuffer=ByteBuffer.allocate(10);
        channel.read(byteBuffer);
        byte[] data=byteBuffer.array();
        String msg=new String(data).trim();
        System.out.println("server receive from client: " + msg);
        ByteBuffer outBuffer=ByteBuffer.wrap(msg.getBytes());
        channel.write(outBuffer);
    }

}

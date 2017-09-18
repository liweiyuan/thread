package cn.concurrent.task;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by spark on 17-9-18.
 * 因为线程是JVM比较宝贵的资源，如果大量的创建，导致开销比较大
 * 优点:1.任务处理过程与主线程分离，这样可以提高响应
 *     2.任务可以并行处理，提高吞吐绿
 *     3.要保证处理代码的线程安全
 */
public class ThreadPerTaskWebServer {

    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(80);
        while (true) {
            final Socket connection = socket.accept();
            //重新启动一个线程进行业务逻辑的处理
            Runnable task = new Runnable() {
                @Override
                public void run() {
                    //handleRequest(connection);
                }
            };
            new Thread(task).start();
        }
    }
}

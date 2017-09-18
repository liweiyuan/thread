package cn.concurrent.task;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by spark on 17-9-18.
 * 由于单线程的缘故，造成性能比较差
 */
public class SingleThreadWebServer {

    public static void main(String[] args) throws IOException {
        ServerSocket socket=new ServerSocket(80);
        while(true){
            Socket connection=socket.accept();
            //串行的处理web请求
            //handleRequest(connection);
        }
    }
}

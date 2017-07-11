package test.wade.executor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Created by spark on 17-7-12.
 */
public class TaskExecutionWebServer {
    private static final int NTHREADS=100;
    private static final Executor exec= Executors.newFixedThreadPool(NTHREADS);

    public static void main(String[] args) throws IOException {
        ServerSocket socket=new ServerSocket(80);
        while(true){
            final Socket connection=socket.accept();
            Runnable task=new Runnable() {
                public void run() {
                    //handleRequest(connection);
                    //处理请求
                }
            };
        }
    }
}

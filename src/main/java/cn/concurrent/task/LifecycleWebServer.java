package cn.concurrent.task;

import sun.misc.Request;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;

/**
 * Created by spark on 17-9-18.
 */
public class LifecycleWebServer {
    private  final ExecutorService exec= Executors.newFixedThreadPool(20);

    public void start() throws IOException {
        ServerSocket socket=new ServerSocket(80);
        while(!exec.isShutdown()){
            try {
                final Socket conn=socket.accept();
                exec.execute(new Runnable() {
                    @Override
                    public void run() {
                        handleRequest(conn);
                    }
                });
            }catch (RejectedExecutionException e){
                if(!exec.isShutdown()){
                    //记录日志，这是拒绝策略
                    //log("task submission rejected",e);
                }
            }
        }
    }

    private void handleRequest(Socket conn) {
        //Request request=readRequest(conn);
        //判断请求是否终端
        /*if(isShutdownRequest(request)){
            stop();
        }else {
            //分发请求
            //dispatcherRequest(req);
        }*/
    }

    public void stop(){
        exec.shutdown();
    }


}

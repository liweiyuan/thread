package org.io.nio;

/**
 * Created by tingyun on 2017/10/30.
 */
public class Server {

    private static int DEFAULT_PORT = 12345;
    private static ServerHandle serverHandle;

    public static void start(){
        start(DEFAULT_PORT);
    }

    private static void start(int defaultPort) {
        if(serverHandle!=null)
            serverHandle.stop();
        serverHandle = new ServerHandle(defaultPort);
        new Thread(serverHandle,"Server").start();
    }

    public static void main(String[] args) {
        start();
    }

}

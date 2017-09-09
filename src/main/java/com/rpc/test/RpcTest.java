package com.rpc.test;

import com.rpc.client.RpcImporter;
import com.rpc.server.EchoService;
import com.rpc.server.EchoServiceImpl;
import com.rpc.server.RpcExporter;

import java.io.IOException;
import java.net.InetSocketAddress;

/**
 * Created by spark on 17-9-9.
 */
public class RpcTest {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    RpcExporter.exporter("localhost", 8000);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        RpcImporter<EchoService> importer = new RpcImporter<EchoService>();
        EchoService echo = importer.importer(EchoServiceImpl.class,
                new InetSocketAddress("localhost", 8000));
        System.out.println(echo.echo("Are you ok ?"));
    }
}

package com.rpc.server;

/**
 * Created by spark on 17-9-9.
 */
public class EchoServiceImpl implements EchoService {
    @Override
    public String echo(String ping) {
        return ping != null ? ping + "--> I am ok." : "I am ok.";
    }
}

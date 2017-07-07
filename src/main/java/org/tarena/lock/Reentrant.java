package org.tarena.lock;

public class Reentrant{


    public synchronized void outer(){
        inner();
    }

    public synchronized void inner(){
        //do something
    }
}
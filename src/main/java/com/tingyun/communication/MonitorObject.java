package com.tingyun.communication;

/**
 * Created by tingyun on 2017/7/4.
 */
public class MonitorObject{
}

 class MyWaitNotify{

    MonitorObject myMonitorObject = new MonitorObject();

    public void doWait(){
        synchronized(myMonitorObject){
            try{
                myMonitorObject.wait();
            } catch(InterruptedException e){

            }
        }
    }

    public void doNotify(){
        synchronized(myMonitorObject){
            myMonitorObject.notify();
        }
    }
}
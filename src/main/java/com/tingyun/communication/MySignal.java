package com.tingyun.communication;


/**
 * Created by tingyun on 2017/7/4.
 */
public class MySignal {
    protected boolean hasDataToProcess=false;
    public synchronized boolean isHasDataToProcess(){
        return this.hasDataToProcess;
    }

    public synchronized  void setDataToProcess(boolean hasData){
        this.hasDataToProcess=hasData;
    }

}
class CounterThread extends Thread{
    protected MySignal mySignal=null;
    public CounterThread(MySignal mySignal){
        this.mySignal=mySignal;
    }

    @Override
    public void run() {
        for(int i=0; i<10; i++){
            System.out.println("I:"+i+",CurrentTreadName:"+currentThread().getName());
        }
        mySignal.setDataToProcess(true);
    }
}

class Example{
    public static void main(String[] args) {
        MySignal mySignal=new MySignal();
        Thread thread1=new CounterThread(mySignal);
        Thread thread2=new CounterThread(mySignal);
        thread1.start();
        thread2.start();
    }
}

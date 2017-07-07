package org.tarena.thread;

public class MyThread extends Thread {

    @Override
    public void run() {
        for(int i=0;i<500000;i++){
            if(this.isInterrupted()){
                System.err.println("线程已经中断，我要移除了.");
                break;
            }
            System.out.println("i="+(i+1));
        }
    }
}

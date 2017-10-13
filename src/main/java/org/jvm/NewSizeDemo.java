package org.jvm;

/**
 * Created by tingyun on 2017/10/12.
 */
public class NewSizeDemo {
    public static void main(String[] args) {
        byte[] b=null;
        for(int i=0;i<10;i++){
            b=new byte[1*1024*1024];
        }
    }
}

package cn.concurrent.jdk.future;

import java.util.concurrent.Callable;

/**
 * Created by spark on 17-9-6.
 */
public class RealData implements Callable<String> {

    private String para;

    public RealData(String para) {
        this.para = para;
    }

    @Override
    public String call() throws Exception {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 10; i++) {
            if (i == 9) {
                sb.append(para);
            } else {
                sb.append(para + ",");
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }
}

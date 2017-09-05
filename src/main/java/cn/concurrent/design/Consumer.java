package cn.concurrent.design;

import java.text.MessageFormat;
import java.util.Random;
import java.util.concurrent.BlockingQueue;

/**
 * Created by spark on 17-9-5.
 */
public class Consumer implements Runnable {

    private BlockingQueue<PCData> queue;
    private static final int SLEEPTIME = 1000;

    public Consumer(BlockingQueue<PCData> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        System.out.println("start Consumer id=" + Thread.currentThread().getId());
        Random r = new Random();//随机等待时间
        try {
            while (true) {
                PCData data = queue.take();
                if (data != null) {
                    int re = data.getIntData() * data.getIntData();//计算平方和
                    System.out.println(MessageFormat.format("{0}*{1}={2}",
                            data.getIntData(), data.getIntData(), re));
                    Thread.sleep(r.nextInt(SLEEPTIME));
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }

    }
}

package cn.concurrent.executor;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by spark on 17-9-27.
 */
public class ScheduledThreadPoolExecutorDemo {

    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        ScheduledThreadPoolExecutor pool =
                new ScheduledThreadPoolExecutor(5);
        for (int i = 0; i < 5; i++) {
            final int temp = i + 1;
            pool.schedule(() -> {
                System.out.println("第" + temp + "个炸弹爆炸时间:" + sdf.format(new Date()));
            }, temp * 5, TimeUnit.SECONDS);
        }
        pool.shutdown();
        System.out.println("end main时间:" + sdf.format(new Date()));
    }
}

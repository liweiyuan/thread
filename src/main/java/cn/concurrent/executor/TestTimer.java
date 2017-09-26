package cn.concurrent.executor;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by spark on 17-9-25.
 */
public class TestTimer {


    static class Reminder {
        Timer timer;

        public Reminder(int sec) {
            timer = new Timer("");
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    System.out.println("this is timer.");
                    timer.cancel();
                }
            }, sec * 1000);
        }
    }

    public static void main(String[] args) {
        System.out.println("------------------");
        new Reminder(5);
        System.out.println("..................");

        System.out.println(8>>2);
    }
}

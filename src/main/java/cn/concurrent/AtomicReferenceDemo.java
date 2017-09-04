package cn.concurrent;

import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by spark on 17-9-4.
 */
public class AtomicReferenceDemo {

    static AtomicReference<Integer> money = new AtomicReference<Integer>();

    //设置账户初始值小于20，显然这是一个需要被充值的账户
    static {
        money.set(19);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            new Thread() {
                @Override
                public void run() {
                    while (true) {
                        while (true) {
                            Integer m = money.get();
                            if (m < 20) {
                                if (money.compareAndSet(m, m + 20)) {
                                    System.out.println("余额小于20元，充值成功，余额为：" + money.get() + "元.");
                                    break;
                                }
                            } else {
                                System.out.println("余额大于20元，无须充值");
                                break;
                            }
                        }
                    }
                }
            }.start();
        }

        //用户消费线程，模拟消费行为
        new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    while (true) {
                        Integer m = money.get();
                        if (m > 10) {
                            System.out.println("大于10元");
                            if (money.compareAndSet(m, m - 10)) {
                                System.out.println("成功消费10元，余额为" + money.get());
                                break;
                            }

                        } else {
                            System.out.println("没有足够的金额");
                            break;
                        }

                    }
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }
}

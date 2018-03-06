package xx.yy.concurrent.Interview;

import java.util.Map;
import java.util.concurrent.*;

/**
 * Created by wade on 18-3-6.
 */
public class BankWaterService implements  Runnable {


    private CyclicBarrier c=new CyclicBarrier(4,this);
    //4个sheet，启动4个线程
    private Executor executor= Executors.newFixedThreadPool(4);
    //保存每一个sheet计算出来的流水
    private ConcurrentHashMap<String,Integer> sheetBankWaterCount=
            new ConcurrentHashMap<String, Integer>();
    private void count(){
        for(int i=0;i<4;i++){
            executor.execute(new Runnable(){
                public void run() {
                    //计算当前sheet的银行流水数据，
                    sheetBankWaterCount.put(Thread.currentThread().getName(),1);
                    //流水计算完毕，插入屏障
                    try {
                        c.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                }
            });
        }

    }

    public void run() {
        int result=0;
        //汇总每一个sheet计算的结构
        for(Map.Entry<String,Integer> sheet:sheetBankWaterCount.entrySet()){
            result+=sheet.getValue();

        }
        //输出结果
        sheetBankWaterCount.put("result",result);
        System.out.println(result);
    }

    public static void main(String[] args) {
        BankWaterService bankWaterService=new BankWaterService();
        bankWaterService.count();

    }

}

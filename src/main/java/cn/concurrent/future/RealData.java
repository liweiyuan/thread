package cn.concurrent.future;

/**
 * Created by spark on 17-9-6.
 */
public class RealData implements Data {

    protected final String result;

    public RealData(String result) {
        //RealData的构造很慢，需要用户等待很久，这里使用sleep模拟。
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 10; i++) {
            sb.append(result);
            try {
                //使用sleep，代替一个很慢的操作
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.result = sb.toString();
    }



    @Override
    public String getResult() {
        return this.result;
    }
}

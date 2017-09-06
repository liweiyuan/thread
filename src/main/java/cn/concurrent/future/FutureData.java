package cn.concurrent.future;

/**
 * Created by spark on 17-9-6.
 */
public class FutureData implements Data {

    protected RealData realData = null; //FutureData是RealData的包装
    protected boolean isReady = false;

    public synchronized void setRealData(RealData realData) {
        if (isReady) {
            return;
        }
        this.realData = realData;
        isReady = true;
        notifyAll();//RealData已经被注入，通知getResult（）
    }

    @Override
    public String getResult() {
        while (!isReady) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return realData.result;
    }


}

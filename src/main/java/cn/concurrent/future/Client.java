package cn.concurrent.future;

/**
 * Created by spark on 17-9-6.
 */
public class Client {
    public Data request(final String queryStr) {
        final FutureData future = new FutureData();
        new Thread() {
            @Override
            public void run() {
                //RealData的构建很慢，所以在单独的线程中执行
                RealData realData = new RealData(queryStr);
                future.setRealData(realData);
            }
        }.start();
        return  future;
    }
}

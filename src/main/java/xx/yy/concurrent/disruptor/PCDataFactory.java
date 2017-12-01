package xx.yy.concurrent.disruptor;

import com.lmax.disruptor.EventFactory;

/**
 * Created by spark on 17-9-6.
 * 会在系统初始化时，构造所有的缓冲区中的对象。
 */
public class PCDataFactory implements EventFactory<PCData> {
    @Override
    public PCData newInstance() {
        return new PCData();
    }
}

package cn.concurrent.design;

/**
 * Created by spark on 17-9-5.
 */
public class PCData {
    private final int intData;

    public PCData(int intData) {
        this.intData = intData;
    }
    public PCData(String d){
        this.intData=Integer.valueOf(d);
    }

    public int getIntData() {
        return intData;
    }

    @Override
    public String toString() {
        return "data:"+intData;
    }
}

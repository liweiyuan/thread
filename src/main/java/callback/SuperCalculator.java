package callback;

/**
 * Created by tingyun on 2018/3/26.
 * 回调
 */
public class SuperCalculator {

    public void add(int a,int b,DoJob customer) {
        int result = a + b;
        customer.fillBack(a,b,result);
    }
}

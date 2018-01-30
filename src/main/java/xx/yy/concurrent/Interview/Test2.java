package xx.yy.concurrent.Interview;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Created by tingyun on 2018/1/30.
 */
public class Test2 {

    //相当于计算2的45次是多少
    public static void match(){
        double result=2<<45;
        System.out.println(result);
    }

    public static void main(String[] args) {
        match();
    }
}

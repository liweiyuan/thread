package xx.yy.concurrent.algorithm;

/**
 * Created by tingyun on 2018/1/26.
 * 计算m的n次方
 */
public class Factorial {

    public static void main(String[] args) {
        double result = calculate(3.0, 2);
        System.out.println(result);
    }

    private static double calculate(double d, int n) {
        double result = 1;
        for (int i = 0; i < n; i++) {
            result *= d;
        }
        return result;
    }
}

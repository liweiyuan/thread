package xx.yy.concurrent.algorithm;

/**
 * Created by tingyun on 2018/1/26.
 * 计算m的n次方
 */
public class Factorial {

    public static void main(String[] args) {
        double result = calculate(3.0, 3);
        System.out.println(result);
        double power = power(3.0, 3);
        System.out.println(power);
    }

    //时间复杂度n*2
    private static double calculate(double d, int n) {
        double result = 1;
        for (int i = 0; i < n; i++) {
            result *= d;
        }
        return result;
    }

    //时间复杂度mlogn
    private static double power(double d, int n) {
        if (n == 0) {
            return 1;
        }
        if ((n & 1) == 1) {
            return d * power(d, n - 1);
        } else {
            double t = power(d, n / 2);
            return t * t;
        }
    }
}

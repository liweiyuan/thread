package xx.yy.concurrent.algorithm;

/**
 * Created by tingyun on 2018/1/26.
 * 斐波那契
 */
public class Fibonacci {

    public static void main(String[] args) {
        int result = calc(3);
        System.err.println(result);

        int _cache = _cache(5);
        System.err.println(_cache);
    }

    private static int calc(int m) {
        if (m < 2) {
            return 1;
        } else {
            return calc(m - 1) + calc(m - 2);
        }
    }

    private static int _cache(int m) {
        int[] _cache = new int[8192];
        if (_cache[m] != 0) {
            return _cache[m];
        }
        if (m < 2) {
            _cache[m] = 1;
            return 1;
        } else {
            _cache[m] = _cache(m - 1) + _cache(m - 2);
            return _cache[m];
        }
    }
}

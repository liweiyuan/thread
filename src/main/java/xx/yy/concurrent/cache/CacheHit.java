package xx.yy.concurrent.cache;

/**
 * Created by tingyun on 2017/12/1.
 * 缓存命中实例解析--深度解析Disruptor并发框架
 * 解决痛点伪共享(模拟伪共享)
 */
public class CacheHit {

    //二维数组
    private static long[][] longs;
    //一维数组长度
    private static int length = 1024 * 1024;

    public static void main(String[] args) {
        //创建二维数组,并赋值：
        longs = new long[length][];
        for (int x = 0; x < length; x++) {
            longs[x] = new long[6];
            for (int y = 0; y < 6; y++) {
                longs[x][y] = 1L;
            }
        }
        cacheHit();
        cacheMiss();
    }

    //缓存命中
    private static void cacheHit() {
        long sum = 0L;
        long start = System.nanoTime();
        for (int x = 0; x < length; x++) {
            for (int y = 0; y < 6; y++) {
                sum += longs[x][y];
            }
        }
        System.err.println("sum : " + sum);
        System.out.println("命中耗时：" + (System.nanoTime() - start));
    }

    private static void cacheMiss() {
        long sum = 0L;
        long start = System.nanoTime();
        for (int x = 0; x < 6; x++) {
            for (int y = 0; y < length; y++) {
                sum += longs[y][x];
            }
        }
        System.err.println("sum : " + sum);
        System.out.println("未命中耗时：" + (System.nanoTime() - start));

    }
}

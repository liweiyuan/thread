package test.wade.escape;

/**
 * Created by tingyun on 2017/11/16.
 * <p>内存分配比较</p>
 */
public class EscapeAnalysisTest {
    public static void alloc() {
        byte[] b = new byte[2];
        b[0] = 1;
    }
    public static void main(String[] args) {
        long b = System.currentTimeMillis();
        for (int i = 0; i < 100000000; i++) {
            alloc();
        }
        long e = System.currentTimeMillis();
        System.out.println(e - b);
    }
}

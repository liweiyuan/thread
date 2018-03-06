package xx.yy.concurrent.algorithm.sort;

/**
 * Created by tingyun on 2018/3/6.
 */
public class BubbleSort {

    public static void sort(int[] data) {
        int length = data.length;
        for (int i = length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (data[j] > data[j + 1]) {
                    //转换就行
                }
            }
        }
    }

    public static void sort1(int[] data) {
        int length = data.length;
        int min;
        for (int i = 0; i < length; i++) {
            min = i;
            for (int j = i; j < length; j++) {
                if (data[min] > data[j]) {
                    min = j;
                }
            }
            if (min != i) {
                //交换
            }
        }
    }

    public static void sort2(int[] data) {
        int length = data.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < i; j++) {
                if (data[i] < data[j]) {
                    int temp = data[i];
                    for (int k = i - 1; k > (j - 1); k--) {
                        data[k + 1] = data[k];
                    }
                    data[j] = temp;
                }
            }
        }
    }

}

package cn.concurrent.function;

import java.util.Arrays;

/**
 * Created by spark on 17-9-19.
 */
public class Function {


    public static void imperative() {
        int[] iArr = {1, 3, 4, 5, 6, 9, 8, 7, 4, 2};
        for (int i = 0; i < iArr.length; i++) {
            System.out.println(iArr[i]);
        }
    }

    //函数式申明
    public static void declarative() {
        int[] iArr = {1, 3, 4, 5, 6, 9, 8, 7, 4, 2};
        Arrays.stream(iArr).forEach(System.out::println);
    }


    public static void main(String[] args) {
        //imperative();

        declarative();
    }
}

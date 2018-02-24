package xx.yy.concurrent.laoma;

/**
 * Created by tingyun on 2018/2/24.
 */
public class ClassTest {

    public static void main(String[] args) {
        //基本类型
        Class<Integer> cls=int.class;
        System.out.println(cls);
        Class<Integer> cls1=Integer.class;
        System.out.println(cls1);

        //返回值类型
        Class<Void> cls2=void.class;
        System.out.println(cls2);


        String[] strArr = new String[10];
        int[][] twoDimArr = new int[3][2];
        int[] oneDimArr = new int[10];
        Class<? extends String[]> strArrCls = strArr.getClass();
        Class<? extends int[][]> twoDimArrCls = twoDimArr.getClass();
        Class<? extends int[]> oneDimArrCls = oneDimArr.getClass();

        System.out.println(strArrCls);
        System.out.println(twoDimArrCls);

        Class<Size> size=Size.class;
        System.err.println(size);
    }

    enum Size {
        SMALL, MEDIUM, BIG
    }
}

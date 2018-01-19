package xx.yy.concurrent.algorithm;

/**
 * Created by tingyun on 2018/1/19.
 * 无符号有序表的测试
 */
public class SequentialSerachSTTest {

    public static void main(String[] args) {
        SequentialSerachST<String,Integer> st=
                new SequentialSerachST<String,Integer>();

        st.put("wade",1);
        Integer result=st.get("wade");
        System.err.println(result);
    }
}

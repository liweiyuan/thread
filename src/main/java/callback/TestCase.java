package callback;

/**
 * Created by tingyun on 2018/3/26.
 * 回调机制测试
 */
public class TestCase {

    public static void main(String[] args) {
        int a=22;
        int b=34;
        Student student=new Student("wade :");
        student.callHelp(a,b);
    }
}

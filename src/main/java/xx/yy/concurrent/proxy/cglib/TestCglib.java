package xx.yy.concurrent.proxy.cglib;

/**
 * Created by tingyun on 2018/3/13.
 */
public class TestCglib {

    public static void main(String[] args) {
        BookFacadeCglib cglib=new BookFacadeCglib();
        BookFacadeImpl1 impl= (BookFacadeImpl1) cglib.getInstance(new BookFacadeImpl1());
        impl.addBook();
    }
}

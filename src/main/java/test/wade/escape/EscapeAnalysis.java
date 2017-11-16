package test.wade.escape;

/**
 * Created by tingyun on 2017/11/16.
 * <title>逃逸分析</title>
 */
public class EscapeAnalysis {

    public static B b;

    /**
     * <p>全局变量赋值发生指针逃逸</p>
     */
    public void globalVariablePointerEscape() {
        b = new B();
    }

    /**
     * <p>方法返回引用，发生指针逃逸</p>
     *
     * @return
     */
    public B methodPointerEscape() {
        return new B();
    }

    /**
     * <p>实例引用发生指针逃逸</p>
     */
    public void instancePassPointerEscape() {
        methodPointerEscape().printClassName(this);
    }

    class B {
        public void printClassName(EscapeAnalysis clazz) {
            System.out.println(clazz.getClass().getName());
        }
    }
}

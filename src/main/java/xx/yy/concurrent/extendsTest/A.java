package xx.yy.concurrent.extendsTest;

public class A {
    protected String a = "a";

    public static void main(String[] args) {
        System.err.println(new B().a.equals(new C().a));
        B b=new B();
        C c=new C();
        System.err.println(b.equals(c));
    }
}

class B extends A {
    public B() {
        this.a="a";
    }
}

class C extends A {
}




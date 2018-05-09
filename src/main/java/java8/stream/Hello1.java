package java8.stream;

public class Hello1 {


    public static void main(String[] args) {
        //System.out.println(Integer.toBinaryString(16));
        /*int a = 1, b = 2, c = 4, d = 8, e = 16, f = 32;
        int number = 17;
        boolean f1 = (number & f) == f ? true : false;
        boolean e1 = (number & e) == e ? true : false;
        boolean d1 = (number & d) == d ? true : false;
        boolean c1 = (number & c) == c ? true : false;
        boolean b1 = (number & b) == b ? true : false;
        boolean a1 = (number & a) == a ? true : false;
        System.out.println(f1);
        System.out.println(e1);
        System.out.println(d1);
        System.out.println(c1);
        System.out.println(b1);
        System.out.println(a1);*/
        test(false,true,false);

    }

    public static void test(Boolean ... booleans){
        //System.out.println(booleans);

        for (Boolean bool:booleans) {
            System.err.println(bool);
        }
    }
}

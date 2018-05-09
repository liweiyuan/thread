package java8.stream;

public class IntegerTest {

    Boolean a;
    public static void main(String[] args) {
        String i=Integer.toBinaryString(3);
        /*i="0"+1;*/
        System.out.println("0"+i);

        String preResult=i.substring(0,1);
        System.out.println(preResult);
        new IntegerTest().a();

        /*Integer i=0;
        int a=1;*/
        System.out.println(i+".............");

        System.out.println("::::::::::"+(false & false));


        System.out.println("______"+Integer.valueOf("11",2));
    }

    private void a() {

        System.err.println(a);
    }
}

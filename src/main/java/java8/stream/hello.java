package java8.stream;

public class hello {



    public static void main(String[] args) {
        boolean a = false;
        boolean b = true;
        boolean c = false;
        boolean d = false;
        boolean e = false;
        boolean f = true;
        int num1 = a ? 1 : 0;
        int num2 = b ? 1 : 0;
        int num3 = c ? 1 : 0;
        int num4 = d ? 1 : 0;
        int num5 = e ? 1 : 0;
        int num6 = f ? 1 : 0;
        String result="" + num1 + num2 + num3 + num4 + num5 + num6;
        System.out.println(result);
        System.out.println(Integer.valueOf(result,2));
    }
}

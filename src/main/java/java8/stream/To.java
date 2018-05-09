package java8.stream;

public class To {

    public static void main(String[] args) {
        //new To().binaryToDecimal(23);

        //System.out.println((~2));
        //System.out.println(~(2-1));

        //int clickNum = 2;
        //boolean click = true;
        //int number = click ? clickNum | clickNum : clickNum ^ clickNum;
        //System.out.println(number);

        System.out.println(2 & 1);
    }

    public void binaryToDecimal(int n) {
        for (int i = 31; i >= 0; i--)
            System.out.print(n >>> i & 1);
    }
}

package java8.stream;


//最终完结版
public class BooleanAndInteger {

    private static final Integer CLICK = 1;
    private static final Integer VIEW = 2;

    public static void main(String[] args) {
        BooleanAndInteger booleanAndInteger = new BooleanAndInteger();
        Boolean click = true;
        Integer clickNumber = booleanAndInteger.booleanToInteger(click, BooleanAndInteger.CLICK);

        Boolean view = true;
        Integer viewNumber = booleanAndInteger.booleanToInteger(view, BooleanAndInteger.VIEW);

        System.out.println("求和: " + (clickNumber | viewNumber));

        Boolean clickBool = booleanAndInteger.integerToBoolean(clickNumber + viewNumber, BooleanAndInteger.CLICK);

        System.out.println("click: " + clickBool);
        Boolean viewBool = booleanAndInteger.integerToBoolean(clickNumber + viewNumber, BooleanAndInteger.VIEW);

        System.out.println("view: " + viewBool);
    }

    //boolean---Integer
    private Integer booleanToInteger(Boolean bool, Integer number) {
        Integer num = bool ? number : 0;  //number | number   : number ^ number
        return num;
    }

    //Integer---boolean
    private Boolean integerToBoolean(Integer number, Integer convert) {
        Boolean bool = (number & convert) == convert;  //(number & convert) == convert ? true : false
        return bool;
    }

}

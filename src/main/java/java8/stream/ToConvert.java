package java8.stream;

import javax.jnlp.IntegrationService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ToConvert {
    public static final Map<Integer, Integer> map = new HashMap<>();

    static {
        map.put(6, 32);
        map.put(5, 16);
        map.put(4, 8);
        map.put(3, 4);
        map.put(2, 2);
        map.put(1, 1);
    }

    public static void main(String[] args) {
        Boolean a = true;
        Boolean b = true;
        Boolean c = false;
        Boolean d = false;
        Boolean e = false;
        Boolean f = true;
        //计算Boolean--int

        List<Boolean> booleanList = new ArrayList<>();
        booleanList.add(a);
        booleanList.add(b);
        booleanList.add(c);
        booleanList.add(d);
        booleanList.add(e);
        booleanList.add(f);
        int number = BooleanToInt(booleanList);
        //int---Boolean
        List<Boolean> BooleanList = intToBoolean(number);

        System.out.println(BooleanList.toString());
    }

    private static int BooleanToInt(List<Boolean> booleanList) {
        int size = booleanList.size();
        int result = 0;
        for (Boolean bool : booleanList) {
            int num = bool ? 1 : 0;
            result += num * map.get(size--);
        }
        //int number = click ? clickNum | clickNum : clickNum ^ clickNum;
        return result;
    }

    private static List<Boolean> intToBoolean(int number) {
        List<Boolean> BooleanList = new ArrayList<>();
        int size = map.size();
        for (int i = size; i > 0; i--) {
            Boolean bool = (number & map.get(i)) == map.get(i) ? true : false;
            BooleanList.add(bool);
        }
        return BooleanList;
    }

    //

    public Integer boolenToInteger(Boolean bool,Integer number){
        Integer num = bool ? number | number : number ^ number;
        return num;
    }

}

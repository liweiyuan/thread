package xx.yy.concurrent.algorithm;

/**
 * Created by tingyun on 2018/1/18.
 */
public class FixedCapacityStackOfStringsTest {

    public static void main(String[] args) {
        FixedCapacityStackOfStrings fixedCapacityStackOfStrings=new FixedCapacityStackOfStrings(10);
        //增加一个元素
        fixedCapacityStackOfStrings.push("a");
        //栈的容量
        int size=fixedCapacityStackOfStrings.size();
        System.err.println(size);

        String element=fixedCapacityStackOfStrings.pop();
        System.err.println(element);

        //判断栈的空
        boolean bool=fixedCapacityStackOfStrings.isEmpty();
        System.err.print(bool);
    }
}

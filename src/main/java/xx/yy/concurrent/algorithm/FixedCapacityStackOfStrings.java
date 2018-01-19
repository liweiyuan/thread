package xx.yy.concurrent.algorithm;

/**
 * Created by tingyun on 2018/1/18.
 * 定容栈的实现
 */
public class FixedCapacityStackOfStrings {

    private String[] cp; //stack entries
    private int size;   //size

    //初始化一个定容栈
    public FixedCapacityStackOfStrings(int cap) {
        this.cp = new String[cap];
    }

    //增加一个元素
    public void push(String a) {
        cp[size++] = a;
    }

    //定容栈中有几个元素
    public int size() {
        return size;
    }

    //判断该定容栈是否满了
    public boolean isEmpty() {
        return size == 0;
    }

    //弹出一个元素
    public String pop() {
        return cp[--size];
    }

    //判断定容栈是否满
    public boolean isFull(){
        return size==cp.length;
    }
}

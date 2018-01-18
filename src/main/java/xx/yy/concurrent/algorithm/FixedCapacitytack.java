package xx.yy.concurrent.algorithm;

/**
 * Created by tingyun on 2018/1/18.
 * 定容栈拓展1：可以装任何类型的元素(泛型)
 */
public class FixedCapacitytack<Item> {
    private Item[] item;
    private int size;

    public FixedCapacitytack(int cap) {
        this.item = (Item[]) new Object[cap];
    }

    //增加一个元素
    public void push(Item item){
        this.item[size++]=item;
    }
    //栈的深度
    public int size(){
        return size;
    }
    //判断栈是否为空
    public boolean isEmpty(){
        return size==0;
    }
    //弹出元素
    public Item pop(){
        return this.item[--size];
    }
}

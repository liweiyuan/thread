package xx.yy.concurrent.algorithm;

/**
 * Created by tingyun on 2018/1/18.
 */
public class FixedCapacitytack1<Item> {

    private Item[] cp;
    private int size;

    public FixedCapacitytack1(int cap) {
        this.cp = (Item[]) new Object[cap];
    }
    //增加一个元素

    public void push(Item item) {
        if (size == cp.length) {
            resize(2 * size);
        }
        this.cp[size++] = item;
    }

    private void resize(int max) {
        Item[] item = (Item[]) new Object[max];
        for (int i = 0; i < size; i++) {
            item[i] = cp[i];
        }
    }
    //弹出一个元素
    public Item pop() {
        Item item = cp[--size];
        //赋值为null,容易为垃圾收集
        cp[size]=null;
        if (size>0&&size==(1/4*cp.length)) {
            resize(2 / 1 * size);
        }
        return item;
    }

    //判断栈是否满
    public boolean isEmpty(){
        return size==0;
    }
    //栈中的元素
    public int size(){
        return size;
    }
}

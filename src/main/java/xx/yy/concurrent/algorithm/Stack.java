package xx.yy.concurrent.algorithm;

import java.util.Iterator;

/**
 * Created by tingyun on 2018/1/19.
 * 基于链表实现的下压栈
 */
public class Stack<Item> implements Iterable<Item> {

    //定义栈顶元素
    private Node first;
    //元素数量
    private int size;

    private class Node {
        private Item item;
        private Node next;
    }

    //判断栈是否空
    public boolean isEmpty() {
        return first == null;
    }

    //栈的深度
    public int size() {
        return size;
    }

    //栈中添加一个元素
    public void push(Item item) {
        Node oldFirst = this.first;
        Node first = new Node();
        first.item = item;
        first.next = oldFirst;
        size++;
    }

    //从栈中弹出一个元素
    public Item pop() {
        Item item = first.item;
        first = first.next;
        size--;
        return item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new StackIterator();
    }

    private class StackIterator<Item> implements Iterator<Item> {

        private Node current = first;

        @Override
        public void remove() {

        }

        @Override
        public boolean hasNext() {
            return first == null;
        }

        @Override
        public Item next() {
            Item item = (Item) current.item;
            current = current.next;
            return item;
        }
    }
}

package xx.yy.concurrent.algorithm;

import java.util.Iterator;

/**
 * Created by tingyun on 2018/1/18.
 * 背包的数据结构
 */

public class Bag<Item> implements Iterable<Item> {

    private Node first;
    private int n;

    private class Node {
        Item item;
        Node next;
    }

    //增加
    public void add(Item item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        n++;
    }

    //背包的大小
    public int size() {
        return n;
    }

    //判断背包是否为空
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public Iterator<Item> iterator() {
        return new BagIterator();
    }

    private class BagIterator implements Iterator<Item> {

        private Node current = first;

        @Override
        public void remove() {

        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
}

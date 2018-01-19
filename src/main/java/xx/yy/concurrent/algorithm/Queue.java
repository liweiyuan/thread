package xx.yy.concurrent.algorithm;

import java.util.Iterator;

/**
 * Created by tingyun on 2018/1/19.
 * 基于链表的队列
 */
public class Queue<Item>implements Iterable<Item> {

    private Node first;
    private Node last;
    private int size;

    private class Node{
        private Item item;
        private Node next;
    }

    //队列是否空
    public boolean isEmpty(){
        return size==0;
    }
    //队列的容量
    public int size(){
        return size;
    }
    //入队操作(链表的表尾部)
    public void enqueue(Item item){
        Node oldLast=last;
        last=new Node();
        last.item=item;
        last.next=null;
        if(isEmpty()){
            first=last;
        }
        size++;
    }
    //出对操作(链表的表头部)
    public Item dequeue(){
        Item item=first.item;
        first=first.next;
        if(isEmpty()){
            last=null;
        }
        size--;
        return item;
    }
    @Override
    public Iterator<Item> iterator() {
        return new QueueIterator();
    }

    private class QueueIterator implements Iterator<Item>{

        private Node current=first;
        @Override
        public void remove() {

        }

        @Override
        public boolean hasNext() {
            return first!=null;
        }

        @Override
        public Item next() {
            Item item=current.item;
            current=current.next;
            return item;
        }
    }
}

package xx.yy.concurrent.algorithm;

/**
 * Created by tingyun on 2018/1/19.
 * 基于链表实现的无序符号表(符号表就是存储key-value的数据结构)
 */
public class SequentialSerachST<Key,Value> {

    //链表的首节点
    private Node first;

    private int size=0;
    private class Node{
        //链表节点的定义
        private Key key;
        private Value value;
        private Node next;

        public Node(Key key, Value value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }
    //查找给定的键，查找对应的值
    public Value get(Key key){
        //如何查找
        for(Node x=first;x!=null;x=x.next){
            if(key.equals(x.key)) {
                return x.value;
            }
        }
        return null;
    }
    //查找给定的key,找到则更新新值，否则建新的节点
    public void put(Key key,Value value){
        for(Node x=first;x!=null;x=x.next){
            if(key.equals(x.key)){
                x.value=value;
                return;//命中
            }
        }
        first=new Node(key,value,first);//未命中，创建新的节点
        size++;
    }
    //查找指定的节点，找到就删除
    public void delete(Key key){
        first=delete(first,key);
    }

    private Node delete(Node x, Key key) {
        if(x==null){
            return null;
        }
        if(key.equals(x.key)){
            size--;
            return x.next;
        }
        //思路：首先判断链表的首节点是不是要找的节点，不是的话就递归找下一个，依次找
        x.next=delete(x.next,key);
        return x;
    }

    //符号表的容量
    public int size(){
        return size;
    }


}

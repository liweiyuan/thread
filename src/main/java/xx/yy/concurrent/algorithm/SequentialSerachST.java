package xx.yy.concurrent.algorithm;

/**
 * Created by tingyun on 2018/1/19.
 * 基于链表实现的无序符号表(符号表就是存储key-value的数据结构)
 */
public class SequentialSerachST<Key,Value> {

    //链表的首节点
    private Node first;
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
    }
}

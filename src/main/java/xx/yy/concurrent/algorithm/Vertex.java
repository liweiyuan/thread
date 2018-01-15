package xx.yy.concurrent.algorithm;


/**
 * Created by tingyun on 2018/1/15.
 * 十字链表--数据结构类-顶点
 */
public class Vertex<E,T> {
    E data;
    Edge<T> firstIn;
    Edge<T> firstOut;

    public Vertex(E data) {
        this.data = data;
    }
}

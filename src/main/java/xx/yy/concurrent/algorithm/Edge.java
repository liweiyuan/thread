package xx.yy.concurrent.algorithm;

/**
 * Created by tingyun on 2018/1/15.
 * 数据结构类——边：
 */
public class Edge<E> {
    E data;
    int fromVertexIndex;
    int toVertexIndex;
    Edge<E> nextSameFromVertex;
    Edge<E> nextSameToVertex;

    public Edge(E data, int fromVertexIndex, int toVertexIndex) {
        this.data = data;
        this.fromVertexIndex = fromVertexIndex;
        this.toVertexIndex = toVertexIndex;
    }

}

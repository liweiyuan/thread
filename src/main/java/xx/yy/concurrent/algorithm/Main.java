package xx.yy.concurrent.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tingyun on 2018/1/15.
 */
public class Main {

    public static void main(String[] args) {
        int vertexNumber = 12;
        int edgeNumber = 21;
        // 检查边的数量是否正确
        // 有向完全图
        int maxEdgeNumber = vertexNumber * (vertexNumber - 1);
        if (edgeNumber < 0 || edgeNumber > maxEdgeNumber) {
            return;
        }
        // 输入有向图数据
        // 1. 先输入顶点，暂时令firstIn， firstOut为null;
        ArrayList<Vertex<Integer, Integer>> vertexList = new ArrayList<>();
        for (int i = 0; i < vertexNumber; i++) {
            Vertex<Integer, Integer> v = new Vertex<>(i);
            vertexList.add(v);
        }
        //System.err.println(vertexList);
        // 2. 输入边
        // 二维数组，每一行两个元素，分别是起点和终点的下标
        @SuppressWarnings("serial")
        List<Edge<Integer>> rawEdgeList = new ArrayList<Edge<Integer>>() {{
            add(new Edge<Integer>(9, 0, 1));
            add(new Edge<Integer>(7, 0, 2));
            add(new Edge<Integer>(3, 0, 3));
            add(new Edge<Integer>(2, 0, 4));
            add(new Edge<Integer>(4, 1, 5));
            add(new Edge<Integer>(2, 1, 6));
            add(new Edge<Integer>(1, 1, 7));
            add(new Edge<Integer>(2, 2, 5));
            add(new Edge<Integer>(7, 2, 6));
            add(new Edge<Integer>(11, 3, 7));
            add(new Edge<Integer>(11, 4, 6));
            add(new Edge<Integer>(8, 4, 7));
            add(new Edge<Integer>(6, 5, 8));
            add(new Edge<Integer>(5, 5, 9));
            add(new Edge<Integer>(4, 6, 8));
            add(new Edge<Integer>(3, 6, 9));
            add(new Edge<Integer>(5, 7, 9));
            add(new Edge<Integer>(6, 7, 10));
            add(new Edge<Integer>(4, 8, 11));
            add(new Edge<Integer>(2, 9, 11));
            add(new Edge<Integer>(5, 10, 11));

        }};
        for (Edge<Integer> edge : rawEdgeList) {
            insertEdge(edge, vertexList);
        }
        //遍历顶点，输出每个顶点的出边和入边
        printVertexAndEdges(vertexList);
    }

    private static void insertEdge(Edge<Integer> edge, ArrayList<Vertex<Integer, Integer>> vertexList) {
        int fromVertexIndex = edge.fromVertexIndex;
        int toVertexIndex = edge.toVertexIndex;
        Vertex<Integer, Integer> fromVertex = vertexList.get(fromVertexIndex);
        Vertex<Integer, Integer> toVertex = vertexList.get(toVertexIndex);

        if (fromVertex.firstOut == null) {
            //插入到顶点的出边属性
            fromVertex.firstOut = edge;
        } else {
            // 插入到edge的nextSameFromVertex属性
            Edge<Integer> tempEdge = fromVertex.firstOut;
            //找到最后一个Edge
            while (tempEdge.nextSameFromVertex != null) {
                tempEdge = tempEdge.nextSameFromVertex;
            }
            tempEdge.nextSameFromVertex = edge;
        }
        if (toVertex.firstIn == null) {
            //插入到顶点的入边属性
            toVertex.firstIn = edge;
        } else {
            // 插入到edge的nextSameToVertex属性
            Edge<Integer> tempEdge = toVertex.firstIn;
            //找到最后一个Edge
            while (tempEdge.nextSameToVertex != null) {
                tempEdge = tempEdge.nextSameToVertex;
            }
            tempEdge.nextSameToVertex = edge;
        }
    }

    public static void printVertexAndEdges(List<Vertex<Integer, Integer>> list) {
        for (Vertex<Integer, Integer> vertex : list) {
            //输出入度
            String infoIn = String.format("vertex: %3d - its in-edge are: ", vertex.data);
            Edge<Integer> edge = vertex.firstIn;
            while (edge != null) {
                infoIn += String.format("(from: %d, to: %d, data: %d)", edge.fromVertexIndex, edge.toVertexIndex, edge.data);
                edge = edge.nextSameToVertex;
            }
            System.out.println(infoIn);
            //输出出度
            String infoOut = String.format("vertex: %3d - its out-edge are: ", vertex.data);
            Edge<Integer> edgeOut = vertex.firstOut;
            while (edgeOut != null) {
                infoOut += String.format("(from: %d, to: %d, data: %d)", edgeOut.fromVertexIndex, edgeOut.toVertexIndex, edgeOut.data);
                edgeOut = edgeOut.nextSameFromVertex;
            }
            System.out.println(infoOut);
        }
    }
}

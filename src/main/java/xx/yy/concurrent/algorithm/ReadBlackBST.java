package xx.yy.concurrent.algorithm;

/**
 * Created by spark on 18-1-30.
 * 红黑树的实现
 */
public class ReadBlackBST<Key extends Comparable<Key>, Value> {
    //根节点
    private Node root;

    private static final boolean RED=true;
    private static final boolean BLACK=false;

    private class Node{
        Key key;//键
        Value value;//相关联的值
        Node left,right;//左右子树
        int N;//这个树中的节点总数
        boolean color;//由其父节点指向它的链接的颜色

        public Node(Key key, Value value, int n, boolean color) {
            this.key = key;
            this.value = value;
            this.N = n;
            this.color = color;
        }
    }
    //判断指向该节点的链接的颜色，约定空节点为黑色
    public boolean isRed(Node x){
        if (x==null){
            return false;
        }
        return x.color==RED;
    }
}

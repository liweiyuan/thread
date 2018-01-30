package xx.yy.concurrent.algorithm;

/**
 * Created by spark on 18-1-30.
 * 红黑树的实现
 */
public class ReadBlackBST<Key extends Comparable<Key>, Value> {
    //根节点
    private Node root;

    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private class Node {
        Key key;//键
        Value value;//相关联的值
        Node left, right;//左右子树
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
    public boolean isRed(Node x) {
        if (x == null) {
            return false;
        }
        return x.color == RED;
    }

    //左旋转--指将红色右链接转换
    private Node rotateLeft(Node h) {
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = 1 + size(h.left) + size(h.right);
        return x;
    }

    //将一个红色左链接转换为红色右链接
    private Node rotateRight(Node h){
        Node x=h.left;
        h.left=x.right;
        x.right=h;
        x.color=h.color;
        h.color=RED;
        x.N=h.N;
        h.N=1+size(h.left)+size(h.right);
        return x;
    }
    private int size() {
        return size(root);
    }

    private int size(Node x) {
        if (x == null) {
            return 0;
        } else {
            return x.N;
        }
    }

    //颜色转换
    private void flipColors(Node h){
        h.color=RED;
        h.left.color=BLACK;
        h.right.color=BLACK;
    }
}

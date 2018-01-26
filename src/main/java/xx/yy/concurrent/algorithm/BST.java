package xx.yy.concurrent.algorithm;

/**
 * Created by tingyun on 2018/1/26.
 * 基于二叉查找树的符号表
 */
public class BST<Key extends Comparable<Key>, Value> {

    //根节点
    private Node root;

    private class Node {
        private Key key;
        private Value value;
        private Node left, right;
        private int size; //以改节点为根节点的树中的节点数

        public Node(Key key, Value value, int size) {
            this.key = key;
            this.value = value;
            this.size = size;
        }
    }

    //树的节点数目
    public int size() {
        return size(root);
    }

    private int size(Node root) {
        if (root == null) {
            return 0;
        }
        return root.size;
    }

    //获取一个元素
    public Value get(Key key) {
        return get(root, key);
    }

    private Value get(Node x, Key key) {
        //在以root为根节点的树中查找元素
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);
        //在它的右子树中
        if (cmp > 0) {
            return get(x.right, key);
        } else if (cmp < 0) {
            return get(x.right, key);
        } else {
            return x.value;
        }
    }
}

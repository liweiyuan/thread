package xx.yy.concurrent.algorithm;


/**
 * Created by tingyun on 2018/1/23.
 * 有序符号表的实现，基于两个数组(算法查找基于二分查找)
 */
public class BinarySearchST<Key extends Comparable<Key>, Value> {

    private Key[] keys;//存储有序符号表的key
    private Value[] values;//存储有序符号表的value
    private int size;//容量

    public BinarySearchST(int cap) {
        keys = (Key[]) new Comparable[cap];
        values = (Value[]) new Object[cap];
    }

    //1.求取有序符号表的容量
    public int size() {
        return this.size;
    }

    //2.通过key来查找value
    public Value get(Key key) {
        if (key == null || isEmpty()) {
            return null;
        }
        int i = rank(key, 0, size - 1);
        if (i < size && keys[i].compareTo(key) == 0) {
            return values[i];
        } else {
            return null;
        }
    }

    //3.插入元素
    public void put(Key key, Value value) {
        //查找键，找到则更新值，找不到则创建新的元素
        int i = rank(key, 0, size - 1);
        if (i < size && keys[i].compareTo(key) == 0) {
            return;
        }
        //没有找到
        for (int j = size; j > i; j--) {
            keys[j] = keys[j - 1];
            values[j] = values[j - 1];
        }
        keys[i] = key;
        values[i] = value;
        size++;
    }

    //二分查找的精髓
    private int rank(Key key) {
        int h0 = 0, hi = size - 1;
        while (h0 <= hi) {
            int mid = h0 + (hi - h0) / 2;
            int cmp = key.compareTo(keys[mid]);
            if (cmp < 0) {
                hi = mid - 1;
            } else if (cmp > 0) {
                h0 = mid + 1;
            } else {
                return mid;
            }
        }
        return h0;
    }

    //基于递归的二分查找
    private int rank(Key key, int h0, int hi) {
        if (hi < h0) {
            return h0;
        }
        int mid = h0 + (hi - h0) / 2;
        int cmp = key.compareTo(keys[mid]);
        if (cmp < 0) {
            return rank(key, h0, mid - 1);
        } else if (cmp > 0) {
            return rank(key, mid + 1, hi);
        } else {
            return mid;
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    //key值最大的求解
    public Key max() {
        return keys[size - 1];
    }

    //key值最小的求解
    public Key min() {
        return keys[0];
    }

    //按照索引查找某个元素
    public Key select(int k) {
        return keys[k];
    }

    //大于等于k的最小键
    public Key ceiling(Key key) {
        int i = rank(key);
        return keys[i];
    }

    public Iterable<Key> keys(Key h0, Key hi) {
        Queue<Key> q = new Queue<Key>();
        for (int i = rank(h0); i < rank(hi); i++) {
            q.enqueue(keys[i]);
        }
        if (contains(hi)) {
            q.enqueue(keys[rank(hi)]);
        }
        return q;
    }

    public boolean contains(Key key) {
        return get(key) != null;
    }

    //删除最小的元素
    public void deleteMin() {
        delete(min());
    }

    //删除最大的元素
    public void deleteMax() {
        delete(max());
    }

    //删除一个元素
    public void delete(Key key) {
        if (isEmpty()) {
            return;
        }
        int i = rank(key);
        if (i < size && keys[i].compareTo(key) == 0) {
            for (int j = i; j < size - 1; j++) {
                keys[j] = keys[j + 1];
                values[j] = values[j + 1];
            }
            size--;
            keys[size] = null;
            values[size] = null;
        }
    }

}

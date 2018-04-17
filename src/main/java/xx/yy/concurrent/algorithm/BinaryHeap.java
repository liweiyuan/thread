package xx.yy.concurrent.algorithm;

/**
 * @author wade
 * 最小堆得实现
 * 特性
 * 结构性：
 * 堆是一颗完全二叉树( complete binary tree )：一棵完全被填满的树，低层上的元素从左到右填入
 * 堆序性
 * (以最小堆为例)最小堆的最小元在根上，并且每个子堆也都满足父节点不大于子节点
 */
public class BinaryHeap {
    //实现最大堆（用数组来存放完全二叉树中的节点,从上到下,从左到右排序,按序存在数组,子节点的值小于等于父节点的值）

    private int[] data;
    private int count;//当前节点数
    private int capacity;//出事

    public BinaryHeap(int capacity) {
        this.capacity = capacity;
        this.data = new int[capacity + 1];//因为索引0不存节点，所以长度加一
        this.count = 0;
    }

    //将一个无序数组构造成一个最大堆          相当于堆排序
    public BinaryHeap(int[] arr, int n) {
        data = new int[n + 1];
        capacity = n;
        for (int i = 0; i < n; i++) {
            data[i + 1] = arr[i];
        }
        count = n;
        //i=count/2:i是最后一个叶子节点的父节点(最后一个非叶子节点)
        for (int i = count / 2; i >= 1; i--) {
            shifDown(i);
        }
    }

    private void shifDown(int k) {
        while ((2 * k) <= count) {     //有左子节点
            int j = 2 * k;      //这轮循环,data[k]和data[j]交换位置
            if ((j + 1) <= count && (data[j + 1] > data[j])) { //有右子节点且右边的更大
                j += 1;
            }
            if (data[k] >= data[j])  //如果父节点大于等于子节点,则停止循环
                break;
            swap(data, k, j);
            k = j;       //k被赋为当前位置,为下次循环做初始化
        }
    }

    public static void swap(int[] arr, int a, int b) {
        int c = arr[a];
        arr[a] = arr[b];
        arr[b] = c;
    }

}

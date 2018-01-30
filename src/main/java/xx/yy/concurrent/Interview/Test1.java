package xx.yy.concurrent.Interview;

import xx.yy.concurrent.algorithm.Stack;

import java.util.Iterator;

/**
 * Created by tingyun on 2018/1/30.
 */
public class Test1 {

    private static Stack<Integer> stack=new Stack<Integer>();

    //array表示存放源数据的数组
    public void toChange(int[] array){
        //for循环遍历每一个元素
        for(int i=0;i<array.length;i++){
            Integer number=array[i];
            //转换为字符串进行倒转
            String changeNumber=String.valueOf(number).trim();
            changeNumber=new StringBuffer(changeNumber).reverse().toString();
            //下面是比较的方法
            toCompare(changeNumber,number);
        }
    }
    //比较大小
    private void toCompare(String changeNumber, Integer number) {
        int reversenumber=Integer.valueOf(changeNumber);
        if(number*4==reversenumber){
            stack.push(number);
        }
    }

    //从栈中输出----
    public void pop(){
        Iterator<Integer> it=stack.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
    }
}

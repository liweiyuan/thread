package xx.yy.concurrent.algorithm.book;

import java.util.Stack;

/**
 * Created by tingyun on 2018/1/31.
 * 方案1
 */
public class MyStack1 {

    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;

    public MyStack1(Stack<Integer> stackData, Stack<Integer> stackMin) {
        this.stackData = stackData;
        this.stackMin = stackMin;
    }

    public void push(int value){
        if(this.stackMin.empty()){
            this.stackMin.push(value);
        }
        if(value<=this.getMin()){
            this.stackMin.push(value);
        }
        this.stackData.push(value);
    }


    public int pop(){
        if(stackData.isEmpty()){
            throw  new RuntimeException("your stack is empty..");
        }
        int value=stackData.pop();
        if(value==getMin()){
            stackMin.pop();
        }
        return value;
    }

    public int getMin() {
        if(stackMin.isEmpty()){
            throw  new RuntimeException("your stack is empty..");
        }
        return this.stackMin.peek();
    }

}

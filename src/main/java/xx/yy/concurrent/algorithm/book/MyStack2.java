package xx.yy.concurrent.algorithm.book;

import java.util.Stack;

/**
 * Created by tingyun on 2018/1/31.
 * 方案2
 */
public class MyStack2 {

    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;

    public MyStack2(Stack<Integer> stackData, Stack<Integer> stackMin) {
        this.stackData = stackData;
        this.stackMin = stackMin;
    }

    public void push(int newValue){
        if(stackMin.isEmpty()){
            stackMin.push(newValue);
        }else if(newValue<getMin()){
            stackMin.push(newValue);
        }else {
            int value=this.stackMin.peek();
            stackMin.push(value);
        }
        this.stackData.push(newValue);
    }

    public int pop() {
        if (stackData.isEmpty()) {
            throw new RuntimeException("your stack is empty..");
        }
        this.stackMin.pop();
        return this.stackData.pop();

    }
    public int getMin() {
        if(stackMin.isEmpty()){
            throw  new RuntimeException("your stack is empty..");
        }
        return this.stackMin.peek();
    }
}

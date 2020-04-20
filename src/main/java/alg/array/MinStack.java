package alg.array;

import java.util.Stack;

/**
 * Created by chen on 2020/3/17.
 */
class MinStack {

    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        stack=new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        if (stack.isEmpty()) {
            minStack.push(x);
        }else {
            if(x<minStack.peek()){
                minStack.push(x);
            }else {
                minStack.push(minStack.peek());
            }
        }
        stack.push(x);
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
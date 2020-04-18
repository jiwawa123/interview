package com.ji.offer;/*
    user ji
    data 2020/2/18
    time 9:53 AM
*/

import java.util.Stack;

public class MinStack {
    /**
     * initialize your data structure here.
     */
    public Stack<Integer> stack;
    public MinStack() {
        stack = new Stack();
    }

    public void push(int x) {
        if(stack.isEmpty()){
            stack.push(x);
            stack.push(x);
        }else{
            int min = Math.min(stack.peek(),x);
            stack.push(x);
            stack.push(min);

        }
    }

    public void pop() {
        if(!stack.isEmpty()){
            stack.pop();
            stack.pop();
        }

    }

    public int top() {
        int min = stack.pop();
        int res = stack.peek();
        stack.push(min);
        return res;
    }

    public int getMin() {
        return stack.peek();
    }
}

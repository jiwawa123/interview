package com.ji.datastructed;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * user ji
 * data 2020/3/15
 * time 10:19 PM
 */
public class CustomStack {
    public static void main(String[] args) {
        CustomStack customStack = new CustomStack(3);
        customStack.push(1);
        customStack.push(2);
        customStack.pop();
        customStack.push(2);
        customStack.push(3);
        customStack.push(4);
        customStack.increment(5,100);
        customStack.increment(2,100);

    }

    List<Integer> list;
    int size;

    public CustomStack(int maxSize) {
        size = maxSize;
        list = new LinkedList<>();
    }

    public void push(int x) {
        if (list.size() == size)
            return;
        list.add(x);
    }

    public int pop() {
        if (list.size() == 0)
            return -1;
        return list.get(list.size() - 1);
    }

    public void increment(int k, int val) {
        for (int i = 0; i < k && i < list.size(); i++) {
            list.set(i, list.get(i) + val);
        }
    }
}

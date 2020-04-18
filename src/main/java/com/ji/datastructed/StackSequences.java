package com.ji.datastructed;/*
    user ji
    data 2020/2/28
    time 1:53 PM
*/


import java.util.Stack;

public class StackSequences {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5};
        int arr1[] = {4, 5, 3, 2, 1};
        System.out.println(validateStackSequences(arr, arr1));
    }

    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int j = 0;
        int i = 0;
        while (j < popped.length && i < pushed.length) {
            if (popped[j] == pushed[i]) {
                i++;
                j++;
                continue;
            }
            if (!stack.isEmpty() && stack.peek() == popped[j]) {
                stack.pop();
                j++;
            } else {
                stack.push(pushed[i]);
                i++;
            }
        }
        while (j < popped.length && !stack.isEmpty()) {
            while (stack.pop() != popped[j++])
                return false;
        }

        return true;
    }


}

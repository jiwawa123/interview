package com.ji.bfs;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * user ji
 * data 2020/3/30
 * time 10:20 AM
 */
public class FindOrder {
    public static void main(String[] args) {

    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Stack<Integer> stack = new Stack<>();
        Set<Integer>[] graph = new HashSet[numCourses];
        boolean flag[] = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new HashSet<>();
        }
        for (int i = 0; i < prerequisites.length; i++) {
            int start = prerequisites[i][0];
            int end = prerequisites[i][1];
            graph[start].add(end);
        }
        while (stack.size() < numCourses) {
            int tmp = -1;
            for (int i = 0; i < graph.length; i++) {
                if (graph[i].size() == 0 && !flag[i]) {
                    tmp = i;
                    flag[i] = true;
                    break;
                }
            }
            if (tmp == -1) {
                int res[] = new int[0];
                return res;
            }
            for (int i = 0; i < graph.length; i++) {
                if (graph[i].size() == 0 || flag[i])
                    continue;
                graph[i].remove(tmp);
            }
            stack.add(tmp);
        }
        int res[] = new int[numCourses];
        for (int i = numCourses - 1; i >= 0; i--) {
            res[i] = stack.pop();
        }
        return res;
    }
}

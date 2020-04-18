package com.ji.graph;

import java.util.*;

/**
 * user ji
 * data 2020/3/25
 * time 9:13 AM
 */
public class FindMinHeightTrees {
    public static void main(String[] args) {
        int arr[][] = {{1,0},{1,2},{1,3}};
        findMinHeightTrees(4,arr);

    }

    public static List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> minHeightTreeToot = new ArrayList<>();
        if (n == 1) {
            minHeightTreeToot.add(0);
            return minHeightTreeToot;
        }
        int first, second;
        int[] degree = new int[n];
        List<List<Integer>> adjacencyList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        for (int[] cur : edges) {
            first = cur[0];
            second = cur[1];
            degree[first]++;
            degree[second]++;
            adjacencyList.get(first).add(second);
            adjacencyList.get(second).add(first);
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (degree[i] == 1) {
                queue.add(i);
            }
        }
        List<Integer> nextNode;
        int size, curNode;
        while (!queue.isEmpty()) {
            size = queue.size();
            minHeightTreeToot.clear();
            for (int j = 0; j < size; j++) {
                curNode = queue.poll();
                minHeightTreeToot.add(curNode);
                nextNode = adjacencyList.get(curNode);
                for (int node : nextNode) {
                    degree[node]--;
                    if (degree[node] == 1) {
                        queue.add(node);
                    }
                }
            }
        }
        return minHeightTreeToot;
    }
}

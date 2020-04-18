package com.ji.graph;

import java.util.*;

/**
 * user ji
 * data 2020/3/25
 * time 11:06 AM
 */
public class CriticalConnections {
    public static void main(String[] args) {

    }

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] degree = new int[n];
        for (int i = 0; i < n; i++) {
            graph.add(new LinkedList<>());
        }
        for (int i = 0; i < connections.size(); i++) {
            List<Integer> tmp = connections.get(i);
            int start = tmp.get(0);
            int end = tmp.get(1);
            degree[start] += 1;
            degree[end] += 1;
            graph.get(start).add(end);
            graph.get(end).add(start);
        }
        List<List<Integer>> res = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < degree.length; i++) {
            if (degree[i] == 1) {
                String tmp = i + "->" + graph.get(i).get(0);
                if (i > graph.get(i).get(0))
                    tmp = graph.get(i).get(0) + "->" + i;
                if (!map.containsKey(tmp)) {
                    map.put(tmp, 1);
                    List<Integer> inter = new LinkedList<>();
                    inter.add(i);
                    inter.add(graph.get(i).get(0));
                    res.add(inter);
                }
            }
        }
        return res;
    }
}

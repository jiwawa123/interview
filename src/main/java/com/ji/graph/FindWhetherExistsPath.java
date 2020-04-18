package com.ji.graph;
/*
    user ji
    data 2020/2/19
    time 10:06 AM
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindWhetherExistsPath {

    boolean flag = false;
    Map<Integer, Integer> map = new HashMap<>();
    Map<Integer,List<Integer>> graphMap = new HashMap<>();
    public boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {
        for (int i = 0; i < graph.length; i++) {
            int s = graph[i][0];
            int e = graph[i][1];
            List<Integer> list = new ArrayList<>();
            list.add(e);
            graphMap.put(s,list);

        }
        dfs(start, target);
        return flag;
    }

    public void dfs(int start, int target) {
        if (flag || map.containsKey(start))
            return;
        if (start == target) {
            flag = true;
            return;
        }
        map.put(start, 1);
        List<Integer> res = graphMap.getOrDefault(start,new ArrayList<Integer>());
        for (int i = 0; i < res.size(); i++) {
            dfs(res.get(i), target);
        }
    }
}

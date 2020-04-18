package com.ji.graph;

import java.util.*;

/**
 * user ji
 * data 2020/3/24
 * time 9:06 AM
 */
public class TwoWords {
    public static void main(String[] args) {

    }
    private int start, end;
    private Set<Integer>[] graph;
    private boolean[] visited;
    private List<String> res;
    private List<String> wordList;


    //构建无向图即可，使用邻接表
    public List<String> findLadders(String beginWord, String endWord, List<String> wordList) {
        start = -1;
        end = -1;
        for (int i = 0; i < wordList.size(); i++) {
            if (wordList.get(i).equals(beginWord))
                start = i;
            if (wordList.get(i).equals(endWord))
                end = i;
        }
        if (end == -1)
            return new ArrayList<>();
        if (start == -1) {
            wordList.add(beginWord);
            start = wordList.size() - 1;
        }

        if (start == end) {
            List<String> res = new ArrayList<>();
            res.add(beginWord);
            return res;
        }

        graph = new Set[wordList.size()];
        for (int i = 0; i < wordList.size(); i++) {
            graph[i] = new HashSet<>();
        }

        for (int i = 0; i < wordList.size() - 1; i++) {
            for (int j = i + 1; j < wordList.size(); j++) {
                if (isAdj(wordList.get(i), wordList.get(j))) {
                    graph[i].add(j);
                    graph[j].add(i);
                }
            }
        }
        this.wordList = wordList;

        visited = new boolean[wordList.size()];
        res = new ArrayList<>();
        dfs(start);
        Collections.reverse(res);
        return res;
    }

    private boolean dfs(int v) {
        visited[v] = true;
        if (v == end) {
            res.add(wordList.get(v));
            return true;
        }
        for (int w : graph[v]) {
            if (!visited[w]) {
                if (dfs(w)) {
                    res.add(wordList.get(v));
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isAdj(String word1, String word2) {
        int num = 0;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i))
                num += 1;
        }
        if (num != 1)
            return false;
        return true;
    }
}

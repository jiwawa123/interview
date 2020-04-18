package com.ji.bfs;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * user ji
 * data 2020/3/29
 * time 8:15 PM
 */
public class LadderLength {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("hot","dot","dog","lot","log","cog","hit");
        System.out.println(new LadderLength().ladderLength("hit",
                "cog",list));
    }

    Set<Integer>[] graph;
    int depth[];

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int begin = -1;
        int end = -1;
        for (int i = 0; i < wordList.size(); i++) {
            if (wordList.get(i).equals(beginWord)) {
                begin = i;
            }
            if (wordList.get(i).equals(endWord)) {
                end = i;
            }
        }
        //无法匹配
        if (end == -1) {
            return 0;
        }
        if (begin == -1) {
            wordList.add(beginWord);
            begin = wordList.size();
        }
        graph = new HashSet[wordList.size()];
        for (int i = 0; i < wordList.size(); i++) {
            graph[i] = new HashSet<>();
        }
        for (int i = 0; i < wordList.size(); i++) {
            for (int j = i + 1; j < wordList.size(); j++) {
                if (match(wordList.get(i), wordList.get(j))) {
                    graph[i].add(j);
                    graph[j].add(i);
                }
            }
        }
        depth = new int[wordList.size()];
        Arrays.fill(depth, Integer.MAX_VALUE);
        bfs(begin, wordList, 0);
        return depth[end] == -1 ? 0 : depth[end];

    }

    public boolean match(String str1, String str2) {
        int count = 0;
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                count++;
                if (count > 1)
                    return false;
            }
        }
        return count == 1;
    }

    public void bfs(int start, List<String> wordList, int dep) {
        if (depth[start] <= dep)
            return;
        depth[start] = dep;
        Set<Integer> set = graph[start];
        for (int k : set
                ) {
            bfs(k, wordList, dep + 1);
        }
    }

}

package com.ji.graph;

import java.util.*;

/**
 * user ji
 * data 2020/3/24
 * time 9:10 AM
 */
public class WordsSearch {
    public static void main(String[] args) {

    }

    public Set<Integer>[] set;
    public boolean flag[];
    List<String> res = new LinkedList<>();
    int start = -1;
    int end = -1;

    public List<String> findLadders(String beginWord, String endWord, List<String> wordList) {

        for (int i = 0; i < wordList.size(); i++) {
            if (beginWord.equals(wordList.get(i))) {
                start = i;
            }
            if (endWord.equals(wordList.get(i))) {
                end = i;
            }
        }
        //表示头尾实体没有匹配成功
        if (start == -1 || end == -1)
            return res;
        set = new HashSet[wordList.size()];
        flag = new boolean[wordList.size()];
        //开始构图 使用双重循环即可 构建无向图即可
        for (int i = 0; i < wordList.size(); i++) {
            for (int j = i + 1; j < wordList.size(); j++) {
                if (isMatch(wordList.get(i), wordList.get(j))) {
                    set[i].add(j);
                    set[j].add(i);
                }
            }
        }

        dfs(start,wordList);
        Collections.reverse(res);
        return res;
    }

    public boolean dfs(int v, List<String> wordList) {
        if (flag[v])
            return false;
        flag[v] = true;
        if (end == v) {
            res.add(wordList.get(v));
            return true;
        }
        for (int k : set[v]
                ) {
            if (!flag[k]) {
                if (dfs(k, wordList)) {
                    res.add(wordList.get(k));
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isMatch(String a, String b) {
        int count = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                count++;
                if (count > 1)
                    return false;
            }
        }
        return count == -1;
    }
}

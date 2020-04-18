package com.ji.design;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * user ji
 * data 2020/4/18
 * time 9:18 AM
 */
public class CombinationIterator {
    List<String> queue = new LinkedList<>();
    int len;

    public CombinationIterator(String characters, int combinationLength) {
        len = combinationLength;
        help("", characters, 0);
        Collections.sort(queue);
    }

    public void help(String tmp, String characters, int start) {
        if (tmp.length() == len) {
            queue.add(tmp);
            return;
        }
        for (int i = start; i < characters.length(); i++) {
            tmp += characters.charAt(i);
            help(tmp, characters, i + 1);
            tmp = tmp.substring(0, tmp.length() - 1);
        }
    }


    public String next() {
        return queue.remove(0);
    }

    public boolean hasNext() {
        return queue.size() == 0;
    }
}

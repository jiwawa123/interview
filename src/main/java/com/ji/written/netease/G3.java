package com.ji.written.netease;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * user ji
 * data 2020/4/7
 * time 2:28 PM
 */
public class G3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int f = sc.nextInt();
        int start = sc.nextInt();
        Set<Integer>[] set = new HashSet[10001];
        for (int i = 0; i < n; i++) {
            set[i] = new HashSet<>();
            if (i == start) {
                set[start].add(start);
            }
        }
        for (int i = 0; i < f; i++) {
            int tmp[] = new int[sc.nextInt()];
            for (int j = 0; j < tmp.length; j++) {
                tmp[j] = sc.nextInt();
            }
            for (int j = 0; j < tmp.length; j++) {
                for (int k = j + 1; k < tmp.length; k++) {
                    set[tmp[j]].add(tmp[k]);
                    set[tmp[k]].add(tmp[j]);
                }
            }
        }
        boolean flag[] = new boolean[10001];
        help(flag, set, start, start);
        System.out.println(set[start].size());
    }

    public static void help(boolean flag[], Set<Integer>[] set, int start, int i) {
        if (flag[i])
            return;
        flag[i] = true;
        for (int k : set[i]) {
            if(!flag[k]){
                set[start].add(k);
                help(flag,set,start,k);
            }
        }
    }
}

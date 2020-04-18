package com.ji.graph;

import java.util.*;

/**
 * user ji
 * data 2020/3/26
 * time 8:07 AM
 */
public class AccountsMerge {
    public static void main(String[] args) {
        List<String> l1 = Arrays.asList("David","David0@m.co","David1@m.co");
        List<String> l2 = Arrays.asList("David","David3@m.co","David4@m.co");
        List<String> l3 = Arrays.asList("David","David4@m.co","David5@m.co");
        List<String> l4 = Arrays.asList("David","David2@m.co","David3@m.co");
        List<String> l5 = Arrays.asList("David","David1@m.co","David2@m.co");
        List<List<String>> lists = Arrays.asList(l1,l2,l3,l4,l5);
        List res = new AccountsMerge().accountsMerge(lists);
        res.forEach(System.out::println);

    }

    public Map<String, Integer> map;
    Set<String>[] graph;

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        graph = new HashSet[n];
        map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph[i] = new HashSet<>();
            List<String> account = accounts.get(i);
            int tmp = Integer.MAX_VALUE;
            //每次都去找最小的那个
            for (int j = 1; j < account.size(); j++) {
                if (map.containsKey(account.get(j))) {
                    tmp = Math.min(tmp, map.get(account.get(j)));
                } else {
                    //未找到标为当前索引
                    map.put(account.get(j), i);
                    graph[i].add(account.get(j));
                }
            }
            if (tmp != Integer.MAX_VALUE) {
                //找到索引，更新所有的string，均指向最小索引
                for (int j = 1; j < account.size(); j++) {
                    int last = map.get(account.get(j));
                    if (map.get(account.get(j)) != tmp) {
                        for (String str : graph[last]) {
                            map.put(str,tmp);
                            graph[tmp].add(str);
                        }
                        graph[last] = new HashSet<>();
                    }
                }

            }
        }
        List<List<String>> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (graph[i].size() > 0) {
                List<String> tmp = new LinkedList<>(graph[i]);
                Collections.sort(tmp);
                tmp.add(0, accounts.get(i).get(0));
                res.add(tmp);
            }
        }
        return res;
    }
}

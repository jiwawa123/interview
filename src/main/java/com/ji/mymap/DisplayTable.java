package com.ji.mymap;

import java.util.*;

/**
 * user ji
 * data 2020/4/26
 * time 9:10 上午
 */
public class DisplayTable {
    public static void main(String[] args) {

    }

    public List<List<String>> displayTable(List<List<String>> orders) {
        Set<String> items = new HashSet<>();
        for (List<String> l : orders
        ) {
            items.add(l.get(2));
        }
        List<String> allItems = new ArrayList<>(items);
        Collections.sort(allItems);
        Map<Integer, Map<String, Integer>> map = new TreeMap<>();
        for (int i = 0; i < orders.size(); i++) {
            int table = Integer.valueOf(orders.get(i).get(1));
            Map<String, Integer> inter = map.getOrDefault(table, new HashMap<>());
            inter.put(orders.get(i).get(2), inter.getOrDefault(orders.get(i).get(2), 0) + 1);
            map.put(table,inter);
        }
        List<List<String>> res = new ArrayList<>();
        allItems.add(0, "Table");
        // 添加表头
        res.add(allItems);
        for (Map.Entry<Integer, Map<String, Integer>> entry : map.entrySet()) {
            List<String> tmp = new LinkedList<>();
            tmp.add(entry.getKey() + "");
            for (int i = 1; i < allItems.size(); i++) {
                tmp.add(entry.getValue().getOrDefault(allItems.get(i), 0) + "");
            }
            res.add(tmp);
        }
        return res;
    }
}

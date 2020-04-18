package com.ji.datastructed;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * user ji
 * data 2020/3/20
 * time 9:40 AM
 */
public class LRUCache {
    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        lruCache.get(1);
        lruCache.put(3, 3);
        lruCache.get(2);
        lruCache.put(4, 4);
    }

    Map<Integer, Integer> map = new LinkedHashMap<>();
    Map<Integer, Integer> cache = new HashMap<>();
    int size;

    public LRUCache(int capacity) {
        size = capacity;
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            map.remove(key);
            map.put(key, 1);
            return cache.get(key);
        } else {
            return -1;
        }

    }

    public void put(int key, int value) {
        if (cache.size() < size) {
            map.put(key, 1);
            cache.put(key, value);
        } else {
            if (cache.containsKey(key)) {
                map.put(key, 1);
                cache.put(key, value);
            } else {
                int min = Integer.MAX_VALUE;
                int k = 0;
                for (Map.Entry<Integer, Integer> entry : map.entrySet()
                        ) {
                    if (min > entry.getValue()) {
                        k = entry.getKey();
                        min = entry.getValue();
                    }
                }
                cache.remove(k);
                map.remove(k);
                map.put(key, 1);
                cache.put(key, value);
            }
        }

    }
}

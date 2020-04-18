package com.ji.design;

import java.util.*;

/**
 * user ji
 * data 2020/3/28
 * time 10:22 AM
 */
public class TweetCounts {
    public TweetCounts() {

    }

    Map<String, TreeMap<Integer, Integer>> map = new HashMap<>();

    public void recordTweet(String tweetName, int time) {
        TreeMap<Integer, Integer> treeMap = map.getOrDefault(tweetName, new TreeMap<>());
        treeMap.put(time, treeMap.getOrDefault(time, 0) + 1);
        map.put(tweetName, treeMap);
    }

    public List<Integer> getTweetCountsPerFrequency(String freq, String tweetName, int startTime, int endTime) {
        List<Integer> res = new ArrayList<>();
        if (!map.containsKey(tweetName)){
            res.add(0);
            return res;
        }
        int freqTime = 1;
        if ("minute".equals(freq)){
            freqTime = 60;
        }else if ("hour".equals(freq)){
            freqTime = 3600;
        }else if ("day".equals(freq)){
            freqTime = 86400;
        }
        // 用户的全部推文时间集合
        TreeMap<Integer,Integer> tweetMap = map.get(tweetName);
        int start = startTime;
        int end = Math.min(start + freqTime,endTime + 1);
        while (start <= endTime){
            int count = 0;
            // 找到发文时间大于等于start的推文
            Map.Entry<Integer,Integer> entry = tweetMap.ceilingEntry(start);
            while (entry != null && entry.getKey() < end){
                count += entry.getValue();// 推文数累加
                // 找比当前大的推文时间
                entry = tweetMap.higherEntry(entry.getKey());
            }
            res.add(count);
            // 时间后移
            start = end;
            end = Math.min(end + freqTime,endTime + 1);
        }
        return res;
    }
}

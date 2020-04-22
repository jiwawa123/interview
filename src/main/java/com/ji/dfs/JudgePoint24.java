package com.ji.dfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * user ji
 * data 2020/4/20
 * time 7:00 PM
 */
public class JudgePoint24 {
    public static void main(String[] args) {
        int arr[] = {1, 2, 1, 2};
        System.out.println(judgePoint24(arr));
    }

    public static boolean judgePoint24(int arr[]) {
        List<List<Integer>> res = permuteUnique(arr);
        for (int i = 0; i < res.size(); i++) {
            if (judgePoint24(res.get(i)))
                return true;
        }
        return false;
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        int[] visited = new int[nums.length];
        backtrack(res, nums, new ArrayList<Integer>(), visited);
        return new ArrayList(res);

    }

    private static void backtrack(Set<List<Integer>> res, int[] nums, ArrayList<Integer> tmp, int[] visited) {
        if (tmp.size() == nums.length) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] == 1) continue;
            visited[i] = 1;
            tmp.add(nums[i]);
            backtrack(res, nums, tmp, visited);
            visited[i] = 0;
            tmp.remove(tmp.size() - 1);
        }
    }


    public static boolean judgePoint24(List<Integer> list) {
        //不使用括号
        Set<Double> set = new HashSet<>();
        set.add(1.0 * list.get(0));
        for (int i = 1; i < 4; i++) {
            Set<Double> next = new HashSet<>();
            for (double t : set
                    ) {
                next.add(t * list.get(i));
                next.add(t + list.get(i));
                next.add(t - list.get(i));
                next.add(t / list.get(i));
            }
            set = next;
        }
        for (double t : set
                ) {
            if (t == 24)
                return true;
        }

        //使用括号1
        set = new HashSet<>();
        set.add(1.0 * list.get(0) * list.get(1));
        set.add(1.0 * list.get(0) + list.get(1));
        set.add(1.0 * list.get(0) - list.get(1));
        set.add(1.0 * list.get(0) / list.get(1));
        Set<Double> set1 = new HashSet<>();
        set1.add(1.0 * list.get(2) * list.get(3));
        set1.add(1.0 * list.get(2) + list.get(3));
        set1.add(1.0 * list.get(2) - list.get(3));
        set1.add(1.0 * list.get(2) / list.get(3));
        for (double t : set
                ) {
            for (double k : set1
                    ) {
                if (t * k == 24 || t - k == 24 || t + k == 24)
                    return true;
                if (k != 0 && t / k == 24)
                    return true;
            }
        }
        //使用括号2
        set = new HashSet<>();
        set1 = new HashSet<>();
        set1.add(1.0 * list.get(1) * list.get(2));
        set1.add(1.0 * list.get(1) - list.get(2));
        set1.add(1.0 * list.get(1) + list.get(2));
        set1.add(1.0 * list.get(1) / list.get(2));
        for (double l : set1
                ) {
            set.add(list.get(0) * l);
            set.add(list.get(0) + l);
            set.add(list.get(0) - l);
            if (l != 0)
                set.add(list.get(0) / l);
        }
        for (double l : set
                ) {
            if (l * list.get(3) == 24.0 || l + list.get(3) == 24.0 || l - list.get(3) == 24.0 || l / list.get(3) == 24.0)
                return true;
        }

        //使用括号3
        set = new HashSet<>();
        for (double l : set1
                ) {
            set.add(l * list.get(3));
            set.add(l + list.get(3));
            set.add(l - list.get(3));
            set.add(l / list.get(3));
        }
        for (double l : set
                ) {
            if (list.get(0) * l == 24.0 || list.get(0) + l == 24.0 || list.get(0) - l == 24.0)
                return true;
            if (l != 0 && list.get(0) / l == 24.0)
                return true;
        }


        //使用括号3
        set = new HashSet<>();
        set1 = new HashSet<>();
        set.add(1.0 * list.get(2) * list.get(3));
        set.add(1.0 * list.get(2) + list.get(3));
        set.add(1.0 * list.get(2) - list.get(3));
        set.add(1.0 * list.get(2) / list.get(3));
        for (double t : set
                ) {
            set1.add(1.0 * list.get(1) * t);
            set1.add(1.0 * list.get(1) + t);
            set1.add(1.0 * list.get(1) - t);
            if (t != 0)
                set1.add(1.0 * list.get(1) / t);
        }
        for (double k : set1
                ) {
            if (1.0 * list.get(0) * k == 24 || 1.0 * list.get(0) + k == 24 || 1.0 * list.get(0) - k == 24)
                return true;
            if (k != 0 && Math.abs(list.get(0) / k - 24) < 0.01)
                return true;
        }

        return false;
    }
}

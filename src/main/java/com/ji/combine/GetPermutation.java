package com.ji.combine;

import java.util.*;

/**
 * user ji
 * data 2020/4/25
 * time 10:04 上午
 */
public class GetPermutation {
    public static void main(String[] args) {
        long a = System.currentTimeMillis();
        new GetPermutation().getPermutation(9, 136371);
        System.out.println(System.currentTimeMillis() - a);
    }

    List<String> res;
    int count;
    boolean flag;

    public String getPermutation(int n, int k) {
        int arr[] = new int[n];
        count = k;
        flag = false;
        res = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }
        boolean[] tmp = new boolean[n + 1];
        help(arr, new LinkedList<>(), tmp);
        return res.get(0);
    }

    private void help(int[] nums, List<Integer> list, boolean[] tmp) {
        if (flag)
            return;
        if (list.size() == nums.length) {
            count--;
            if (count == 0) {
                StringBuilder sp = new StringBuilder();
                for (int i = 0; i < list.size(); i++) {
                    sp.append(list.get(i));
                }
                res.add(sp.toString());
                flag = true;
                return;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (!tmp[nums[i]]) {
                tmp[nums[i]] = true;
                list.add(nums[i]);
                help(nums, list, tmp);
                tmp[nums[i]] = false;
                list.remove(list.size() - 1);
            }
        }
    }


}

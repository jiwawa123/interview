package com.ji.recall;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * user ji
 * data 2020/3/13
 * time 9:54 AM
 */
public class TranslateNum {
    public static void main(String[] args) {
        System.out.println(translateNum(648006092));
    }

    static Set<String> set = new LinkedHashSet<>();

    public static int translateNum(int num) {
        String nums = String.valueOf(num);
        help(new ArrayList<>(), nums, 0, "");
        return set.size();
    }

    public static void help(List<String> list, String num, int start, String last) {
        if (start == num.length()) {
            StringBuilder sp = new StringBuilder();
            for (String s : list
                    ) {
                sp.append(s);
            }
            set.add(sp.toString());
        }

        for (int i = start; i < num.length(); i++) {
            last += num.charAt(i);
            int ll = Integer.valueOf(last);
            if (ll > 25 || (last.charAt(0)=='0'&& last.length()>1)) {
                return;
            }
            list.add("" + (char) ('a' + ll));
            help(list, num, i + 1, "");
            list.remove(list.size() - 1);
        }
    }
}

package com.ji.written.netease;

import java.util.*;

/**
 * user ji
 * data 2020/4/7
 * time 2:27 PM
 */
public class G2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int d = scanner.nextInt();
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int tmp[] = {scanner.nextInt(), 0};
            list.add(tmp);
        }
        for (int i = 0; i < n; i++) {
            list.get(i)[1] = scanner.nextInt();
        }
        Collections.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o2[1] - o1[1];
                }
                return o1[0] - o2[0];
            }
        });
        int i = 0, j = n - 1;
        int res = 0;
        while (i < j) {
            if (d > list.get(i)[0]) {
                d++;
                i++;
            } else {
                d++;
                res += list.get(j)[1];
                j--;
            }
        }
        System.out.println(res);
    }
}

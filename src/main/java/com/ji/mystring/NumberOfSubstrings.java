package com.ji.mystring;

/**
 * user ji
 * data 2020/3/30
 * time 9:17 AM
 */
public class NumberOfSubstrings {
    public static void main(String[] args) {
        System.out.println(numberOfSubstrings("abcabc"));
    }

    public static int numberOfSubstrings(String s) {
        int arr[] = new int[3];
        int count = 0;
        for (int i = 0, j = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a'] += 1;
            if (arr[0] > 0 && arr[1] > 0 && arr[2] > 0) { //后面所有的字符串都可以使用
                count += s.length() - i;
                while (((arr[0] > 1 && s.charAt(j) == 'a') ||
                        (arr[1] > 1 && s.charAt(j) == 'b') ||
                        (arr[2] > 1 && s.charAt(j) == 'c')) && j <= i) {
                    arr[s.charAt(j) - 'a'] -= 1;
                    j++;
                    count += s.length() - i;
                }
                arr[s.charAt(j++) - 'a'] -= 1;
            }

        }

        return count;
    }
}

package com.ji.mystring;

/**
 * user ji
 * data 2020/3/10
 * time 10:10 AM
 */

public class SortString {
    public static void main(String[] args) {

    }

    public String sortString(String s) {
        StringBuilder sp = new StringBuilder();
        int arr[] = new int[26];
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a'] += 1;
        }
        boolean flag = true;
        while (sp.length() < s.length()) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                if (arr[i] > 0) {
                    sb.append((char) (i + 'a'));
                    arr[i] -= 1;
                }
            }
            if(flag){
                sp.append(sb.toString());
            }
            else{
                sp.append(sb.reverse().toString());
            }
            flag = !flag;
        }

        return sp.toString();
    }
}

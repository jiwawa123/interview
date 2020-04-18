package com.ji.mystring;/*
    user ji
    data 2020/2/28
    time 2:32 PM
*/

public class ReverseWords {

    public static void main(String[] args) {
        System.out.println(reverseWords("a good   example"));
    }

    public static String reverseWords(String s) {
        String[] tmp = s.trim().split(" ");
        StringBuilder sp = new StringBuilder();
        for (int i = tmp.length-1; i>=0;i--) {
            if(!tmp[i].equals(""))
            sp.append(tmp[i].trim()+" ");
        }
        return sp.toString().trim();
    }
}

package com.ji.mystring;/*
    user ji
    data 2020/3/10
    time 9:33 AM
*/

public class ReverseLeftWords {
    public static void main(String[] args) {

    }

    public String reverseLeftWords(String s, int n) {
        return s.substring(n, s.length()) + s.substring(0, n);
    }
}

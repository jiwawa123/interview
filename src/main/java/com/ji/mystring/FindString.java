package com.ji.mystring;/*
    user ji
    data 2020/2/24
    time 7:36 PM
*/

import java.util.Arrays;

public class FindString {
    public static void main(String[] args) {
        String tmp[] = {"at", "", "", "", "ball", "", "", "car", "", "", "dad", "", ""};
        System.out.println(findString(tmp, "ball"));
    }

    public static int findString(String[] words, String s) {
        int i = 0, j = words.length - 1;
        while (i <= j) {
            while (words[i].equals(""))
                i++;
            while (words[j].equals(""))
                j--;
            int med = (j - i) / 2 + i;
            if (words[med].equals(s))
                return med;
            while (words[med].equals("") && med < j) {
                med++;
            }
            if (words[med].compareTo(s) == 0)
                return med;
            else if (words[med].compareTo(s) < 0) {
                i = med + 1;
            } else {
                j = med - 1;
            }
        }
        return -1;
    }
}

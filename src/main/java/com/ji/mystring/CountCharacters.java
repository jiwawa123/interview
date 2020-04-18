package com.ji.mystring;

import java.util.HashMap;
import java.util.Map;

/**
 * user ji
 * data 2020/3/17
 * time 9:13 AM
 */
public class CountCharacters {
    public static void main(String[] args) {

    }

    public int countCharacters(String[] words, String chars) {
        int arr[] = new int[26];
        for (char c : chars.toCharArray()
                ) {
            arr[c - 'a'] += 1;
        }
        int count = 0;
        for (String word : words
                ) {
            count += match(arr, word) ? word.length() : 0;
        }
        return count;
    }

    public boolean match(int arr[], String word) {
        int arr1[] = new int[26];
        for (char t : word.toCharArray()
                ) {
            arr1[t - 'a'] += 1;
            if (arr1[t - 'a'] > arr[t - 'a'])
                return false;
        }
        return true;
    }
}

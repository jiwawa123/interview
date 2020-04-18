package com.ji.mystring;/*
    user ji
    data 2020/2/19
    time 9:05 AM
*/

import java.util.HashMap;
import java.util.Map;

public class CanPermutePalindrome {
    public static void main(String[] args) {

    }

    public boolean canPermutePalindrome(String s) {
        if(s==null||s.length()<2)
            return true;
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if(map.containsKey(s.charAt(i))){
                map.remove(s.charAt(i));
            }else{
                map.put(s.charAt(i),1);
            }
        }

        return map.size()<2;
    }
}

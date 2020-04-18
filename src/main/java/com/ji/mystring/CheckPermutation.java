package com.ji.mystring;/*
    user ji
    data 2020/2/19
    time 9:18 AM
*/

import java.util.HashMap;
import java.util.Map;

public class CheckPermutation {
    public static void main(String[] args) {

    }
    public boolean checkPermutation(String s1, String s2) {
        if(s1==null&&s2==null)
            return true;
        if(s1==null||s2==null)
            return false;
        if(s1.length()!=s2.length())
            return false;
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            map.put(s1.charAt(i),map.getOrDefault(s1.charAt(i),0)+1);
        }
        for (int i = 0; i < s2.length(); i++) {
            if(map.getOrDefault(s2.charAt(i),0)<1){
                return false;
            }
            map.put(s2.charAt(i),map.get(s2.charAt(i))-1);
        }
        return true;
    }
}

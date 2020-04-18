package com.ji.mystring;/*
    user ji
    data 2020/2/27
    time 9:47 AM
*/

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class FirstUniqChar {
    public static void main(String[] args) {

    }

    public char firstUniqChar(String s) {
        Map<Character,Integer> map = new LinkedHashMap<>();
        for(int i = 0;i<s.length();i++){
           map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        for(Map.Entry<Character,Integer> entry:map.entrySet()){
            if(entry.getValue()==1)
                return entry.getKey();
        }

        return ' ';
    }
}

package com.ji.mystring;/*
    user ji
    data 2020/2/18
    time 2:12 PM
*/

public class IsFlipedString {
    public static void main(String[] args) {
        String a = "waterbottle";
        String b = "bottlewater";
        System.out.println(isFlipedString(a, b));
    }

    public static boolean isFlipedString(String s1, String s2) {
        if(s1==null&&s2==null)
            return true;
        if(s1.equals(s2))
            return true;
        if (s1.length() != s2.length())
            return false;
        int i = 0;
        StringBuilder sp = new StringBuilder();
        while (i < s1.length()) {
            if (!s2.contains(sp.toString())) {
                break;
            }
            sp.append(s1.charAt(i++));
        }
        String first = sp.toString().substring(0, i - 1);
        String last = s1.substring(i - 1, s1.length());
        if ((last + first).equals(s2))
            return true;
        return false;
    }
}

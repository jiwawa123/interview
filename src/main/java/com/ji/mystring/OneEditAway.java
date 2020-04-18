package com.ji.mystring;/*
    user ji
    data 2020/2/18
    time 3:46 PM
*/

public class OneEditAway {
    public static void main(String[] args) {
        String a = "islander";
        String b = "slander";
        System.out.println(oneEditAway(a, b));
    }

    public static boolean oneEditAway(String first, String second) {
        if (first == null && second == null)
            return true;
        if (first == null || second == null)
            return false;
        if (first.equals(second))
            return true;
        if (Math.abs(first.length() - second.length()) >= 2)
            return false;
        if (first.length() == second.length()) {
            int count = 0;
            for (int i = 0; i < first.length(); i++) {
                if (first.charAt(i) != second.charAt(i))
                    count++;
                if (count > 1)
                    return false;
            }
            return true;
        }
        if (first.length() < second.length()) {
            String tmp = first;
            first = second;
            second = tmp;
        }
        for (int i = 0; i < first.length() && i < second.length(); i++) {
            if (first.charAt(i) != second.charAt(i)) {

                if (!first.substring(i + 1, first.length()).equals(second.substring(i, second.length())))
                    return false;
                break;
            }
        }

        return true;
    }


}

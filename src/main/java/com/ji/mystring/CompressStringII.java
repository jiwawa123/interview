package com.ji.mystring;

/**
 * user ji
 * data 2020/3/16
 * time 8:42 AM
 */
public class CompressStringII {
    public static void main(String[] args) {

    }

    public String compressString(String S) {
        if (S == null || S.length() < 2)
            return S;
        StringBuilder sp = new StringBuilder();
        int count = 1;
        char t = S.charAt(0);
        for (int i = 2; i < S.length(); i++) {
            if (S.charAt(0) == t) {
                count++;
            } else {
                sp.append(t);
                sp.append(count);
                count = 1;
                t = S.charAt(i);
            }
        }

        sp.append(t);
        sp.append(count);
        return sp.length() < S.length() ? sp.toString() : S;
    }
}

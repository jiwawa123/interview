package com.ji.mystring;/*
    user ji
    data 2020/2/18
    time 3:37 PM
*/

public class CompressString {
    public static void main(String[] args) {

    }

    public String compressString(String S) {
        if(S==null||S.length()<2)
            return S;
        StringBuilder sp = new StringBuilder();
        int count = 1;
        char tmp = S.charAt(0);
        for (int i = 1; i < S.length(); i++) {
            if(S.charAt(i)==tmp){
                count++;
            }else{
                sp.append(tmp+count);
                tmp = S.charAt(i);
                count = 1;
            }
        }
        sp.append(tmp+count);
        return sp.length()<S.length()?sp.toString():S;
    }

    public String replaceSpaces(String S, int length) {
        return S.replaceAll(" ","%20").substring(0,length);
    }
}

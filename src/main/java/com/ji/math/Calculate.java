package com.ji.math;/*
    user ji
    data 2020/3/2
    time 6:03 PM
*/

import java.util.ArrayList;
import java.util.List;

public class Calculate {
    public static void main(String[] args) {
        System.out.println(calculate("2*3+4"));
    }

    //使用List来求解
    public static int calculate(String s) {
        s = s.replaceAll(" ", "");
        List<Integer> list = new ArrayList<>();
        List<Character> operation = new ArrayList<>();
        int fst = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                fst = fst * 10 + s.charAt(i) - '0';
            } else {
                if (operation.size() == 0) { //表示之前没有操作符
                    list.add(fst); //将前面的数字压入，并且重置为0
                    fst = 0;
                    operation.add(s.charAt(i));
                } else {
                    char t = operation.get(operation.size() - 1);
                    if (t == '*' || t == '/') {
                        int k = list.remove(list.size() - 1);
                        int res = 0;
                        if (t == '*') {
                            res = k * fst;
                        } else {
                            res = k / fst;
                        }
                        fst = 0;
                        list.add(res);
                        operation.remove(operation.size() - 1);
                    } else {
                        list.add(fst);
                        fst = 0;
                    }
                    operation.add(s.charAt(i));
                }
            }
        }

        if (operation.size() == 0) //没有遇见操作符号
            return fst;
        char oop = operation.get(operation.size() - 1);
        if (oop == '*' || oop == '/') {
            operation.remove(operation.size() - 1);
            int k = list.remove(list.size() - 1);
            int res = 0;
            if (oop == '*') {
                res = k * fst;
            } else {
                res = k / fst;
            }
            list.add(res);
        } else {
            list.add(fst);
        }
        return getRes(list, operation);
    }

    public static int getRes(List<Integer> number, List<Character> opp) {
        int f = number.get(0);
        for (int i = 1; i < number.size(); i++) {
            switch (opp.get(i - 1)) {
                case '+':
                    f += number.get(i);
                    break;
                case '-':
                    f -= number.get(i);
                    break;
                case '*':
                    f *= number.get(i);
                    break;
                case '/':
                    f /= number.get(i);
            }
        }

        return f;
    }

}

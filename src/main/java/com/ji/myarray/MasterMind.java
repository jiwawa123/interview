package com.ji.myarray;/*
    user ji
    data 2020/2/25
    time 9:31 AM
*/

public class MasterMind {
    public static void main(String[] args) {

    }

    public int[] masterMind(String solution, String guess) {
        int arr[] = new int[4];
        int array[] = new int[4];
        int correct = 0;
        int res[] = new int[2];
        for (int i = 0; i < solution.length(); i++) {
            if (solution.charAt(i) == guess.charAt(i)) {
                correct++;
            }
            help(solution.charAt(i), arr);
            help(guess.charAt(i), array);
        }
        int all = 0;
        for (int i = 0; i < arr.length; i++) {
            all += Math.min(arr[i], array[i]);
        }
        res[0] = correct;
        res[1] = all - correct;
        return res;
    }

    public void help(Character a, int arr[]) {
        switch (a) {
            case 'G':
                arr[0]++;
                break;
            case 'R':
                arr[1]++;
                break;
            case 'B':
                arr[2]++;
                break;
            default:
                arr[3]++;
                break;
        }
    }
}

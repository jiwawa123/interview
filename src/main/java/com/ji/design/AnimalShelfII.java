package com.ji.design;/*
    user ji
    data 2020/2/19
    time 9:38 AM
*/

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AnimalShelfII {

    List<Integer> list;
    List<Integer> type;

    public AnimalShelfII() {
        list = new LinkedList<>();
        type = new LinkedList<>();
    }

    public void enqueue(int[] animal) {
        list.add(animal[0]);
        type.add(animal[1]);
    }

    public int[] dequeueAny() {
        int res[] = {-1, -1};
        if (list.size() == 0)
            return res;
        res[0] = list.remove(0);
        res[1] = type.remove(0);
        return res;

    }

    public int[] dequeueDog() {
        int res[] = {-1, -1};
        for (int i = 0; i < type.size(); i++) {
            if(type.get(i)==0){
                res[0] = type.remove(i);
                res[1] = list.remove(i);
                break;
            }
        }
        return res;
    }

    public int[] dequeueCat() {

        
        int res[] = {-1, -1};
        for (int i = 0; i < type.size(); i++) {
            if(type.get(i)==1){
                res[0] = type.remove(i);
                res[1] = list.remove(i);
                break;
            }
        }
        return res;
    }
}

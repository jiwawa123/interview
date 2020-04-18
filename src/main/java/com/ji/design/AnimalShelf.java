package com.ji.design;/*
    user ji
    data 2020/2/19
    time 9:49 AM
*/

import java.util.LinkedList;
import java.util.List;

public class AnimalShelf {

    int index;
    List<Integer> dog; // 1
    List<Integer> dog_index;
    List<Integer> cat; // 0
    List<Integer> cat_index;

    public AnimalShelf() {
        index = 0;
        dog = new LinkedList<>();
        cat = new LinkedList<>();
        dog_index = new LinkedList<>();
        cat_index = new LinkedList<>();
    }

    public void enqueue(int[] animal) {
        index++;
        if (animal[1] == 0) {
            cat.add(animal[0]);
            cat_index.add(index);
        } else {
            dog.add(animal[0]);
            dog_index.add(index);
        }
    }

    public int[] dequeueAny() {
        int res[] = {-1, -1};
        if(cat.size()!=0&&dog.size()!=0){
            int cindex= cat_index.get(0);
            int dindex = dog_index.get(0);
            if(cindex<dindex){
                res[0] = cat.remove(0);
                cat_index.remove(0);
                res[1] = 0;
            }else{
                res[0] = dog.remove(0);
                dog_index.remove(0);
                res[1] = 1;
            }
        }else if(cat.size()!=0){
            res[0] = cat.remove(0);
            cat_index.remove(0);
            res[1] = 0;
        }else if(dog.size()!=0){
            res[0] = dog.remove(0);
            dog_index.remove(0);
            res[1] = 1;
        }
        return res;
    }

    public int[] dequeueDog() {
        int res[] = {-1, -1};
        if (dog.size() != 0) {
            res[0] = dog.remove(0);
            dog_index.remove(0);
            res[1] = 1;
        }
        return res;
    }

    public int[] dequeueCat() {
        int res[] = {-1, -1};
        if (cat.size() != 0) {
            res[0] = cat.remove(0);
            cat_index.remove(0);
            res[1] = 0;
        }
        return res;
    }
}

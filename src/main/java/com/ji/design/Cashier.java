package com.ji.design;

import java.util.Map;

/**
 * user ji
 * data 2020/3/25
 * time 10:28 AM
 */
public class Cashier {
    int number = 1;
    int discount;
    Map<Integer, Integer> map;
    int n;

    public Cashier(int n, int discount, int[] products, int[] prices) {
        this.n = n;
        this.discount = discount;
        for (int i = 0; i < products.length; i++) {
            map.put(products[i], prices[i]);
        }
    }

    public double getBill(int[] product, int[] amount) {
        double res = 0;
        for (int i = 0; i < product.length; i++) {
            res += map.get(product[i]) * amount[i];
        }
        if (number % n == 0) {
            res*=(100-discount)/100;
        }
        number++;
        return res;
    }
}

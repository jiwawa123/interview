package com.ji.current.game;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * user ji
 * data 2020/4/8
 * time 1:21 PM
 */
public class ZeroEvenOdd {
    private int n;

    public ZeroEvenOdd(int n) {
        this.n = n;
    }
    AtomicBoolean flag = new AtomicBoolean(true);
    Semaphore f = new Semaphore(1);
    Semaphore s = new Semaphore(0);
    Semaphore t = new Semaphore(0);
    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            f.acquire();
            printNumber.accept(0);
            if(flag.get()){
                flag.set(false);
                s.release();
            }else{
                flag.set(true);
                t.release();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i+=2) {
            s.acquire();
            printNumber.accept(i);
            f.release();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i+=2) {
            t.acquire();
            printNumber.accept(i);
            f.release();
        }
    }
}
class IntConsumer{
    public void accept(int i){

    }
}

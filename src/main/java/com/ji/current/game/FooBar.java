package com.ji.current.game;

import java.util.concurrent.Semaphore;

/**
 * user ji
 * data 2020/4/8
 * time 1:43 PM
 */
public class FooBar {
    private int n;
    Semaphore f = new Semaphore(1);
    Semaphore b = new Semaphore(0);

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            f.acquire();
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            b.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            b.acquire();
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            f.release();
        }
    }
}

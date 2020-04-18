package com.ji.current.game;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * user ji
 * data 2020/4/8
 * time 1:04 PM
 */
public class H2O {
    AtomicInteger integer = new AtomicInteger(0);

    public H2O() {

    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        while (integer.get() == 2) { //此处的死循环会导致超时

        }
        releaseHydrogen.run();
        integer.getAndAdd(1);
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        while (integer.get() != 2) {

        }
        releaseOxygen.run();
        integer.set(0);
    }
}
